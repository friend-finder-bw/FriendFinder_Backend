package com.lambdaschool.friendfinderbe.services;

import com.lambdaschool.friendfinderbe.exceptions.ResourceNotFoundException;
import com.lambdaschool.friendfinderbe.models.Quote;
import com.lambdaschool.friendfinderbe.models.User;
import com.lambdaschool.friendfinderbe.models.UserRoles;
import com.lambdaschool.friendfinderbe.repository.RoleRepository;
import com.lambdaschool.friendfinderbe.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService, UserService
{

    @Autowired
    private UserRepository userrepos;

    @Autowired
    private RoleRepository rolerepos;

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        User user = userrepos.findByUsername(username);
        if (user == null)
        {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthority());
    }

    @Override
    public User findUserById(long id) throws ResourceNotFoundException
    {
        return userrepos.findById(id).orElseThrow(() -> new ResourceNotFoundException(Long.toString(id)));
    }

    @Override
    public User findUserByName(String name)
    {
        return userrepos.findByUsername(name);
    }

    public List<User> findAll()
    {
        List<User> list = new ArrayList<>();
        userrepos.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void delete(long id)
    {
        if (userrepos.findById(id).isPresent())
        {
            userrepos.deleteById(id);
        } else
        {
            throw new ResourceNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public User save(User user)
    {
        User newUser = new User();
        newUser.setUsername(user.getUsername());
        newUser.setPasswordNoEncrypt(user.getPassword());
        newUser.setEmail(user.getEmail());
        newUser.setLocation(user.getLocation());
        newUser.setAge(user.getAge());
        newUser.setGender(user.getGender());
        newUser.setHobby(user.getHobby());

        ArrayList<UserRoles> newRoles = new ArrayList<>();
        for (UserRoles ur : user.getUserRoles())
        {
            newRoles.add(new UserRoles(newUser, ur.getRole()));
        }
        newUser.setUserRoles(newRoles);

        for (Quote q : user.getQuotes())
        {
            newUser.getQuotes().add(new Quote(q.getQuote(), newUser));
        }

        return userrepos.save(newUser);
    }


    @Transactional
    @Override
    public User update(User user, long id)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userrepos.findByUsername(authentication.getName());

        if (currentUser != null)
        {
            if (id == currentUser.getUserid())
            {
                if (user.getUsername() != null)
                {
                    currentUser.setUsername(user.getUsername());
                }

                if (user.getPassword() != null)
                {
                    currentUser.setPasswordNoEncrypt(user.getPassword());
                }

                if (user.getEmail() != null)
                {
                    currentUser.setPasswordNoEncrypt(user.getEmail());
                }

                if (user.getLocation() != null)
                {
                    currentUser.setLocation(user.getLocation());
                }

                if (user.getAge() > 0)
                {
                    currentUser.setAge(user.getAge());
                }

                if (user.getGender() != null)
                {
                    currentUser.setGender(user.getGender());
                }

                if (user.getHobby() != null)
                {
                    currentUser.setHobby(user.getHobby());
                }

                if (user.getUserRoles().size() > 0)
                {
                    // with so many relationships happening, I decided to go
                    // with old school queries
                    // delete the old ones
                    rolerepos.deleteUserRolesByUserId(currentUser.getUserid());

                    // add the new ones
                    for (UserRoles ur : user.getUserRoles())
                    {
                        rolerepos.insertUserRoles(id, ur.getRole().getRoleid());
                    }
                }

                if (user.getQuotes().size() > 0)
                {
                    for (Quote q : user.getQuotes())
                    {
                        currentUser.getQuotes().add(new Quote(q.getQuote(), currentUser));
                    }
                }

                return userrepos.save(currentUser);
            } else
            {
                throw new ResourceNotFoundException(id + " Not current user");
            }
        } else
        {
            throw new ResourceNotFoundException(authentication.getName());
        }

    }
}
