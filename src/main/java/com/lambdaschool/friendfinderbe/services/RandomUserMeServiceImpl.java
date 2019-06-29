/*
package com.lambdaschool.friendfinderbe.services;

import com.lambdaschool.friendfinderbe.exceptions.ResourceNotFoundException;
import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
import com.lambdaschool.friendfinderbe.models.Quote;
import com.lambdaschool.friendfinderbe.models.RandomUserMe;
import com.lambdaschool.friendfinderbe.models.User;
import com.lambdaschool.friendfinderbe.models.UserRoles;
import com.lambdaschool.friendfinderbe.repository.RandomUserMeRepository;
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


@Service(value = "randomUserMeService")
public class RandomUserMeServiceImpl implements RandomUserMeService
{
    @Autowired
    private RandomUserMeRepository randomusermerepos;

    @Override
    public List<RandomUserMe> getProfiles()
    {
        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?seed=ffbe&results=3");
        return arrayList;
    }
}
*/
