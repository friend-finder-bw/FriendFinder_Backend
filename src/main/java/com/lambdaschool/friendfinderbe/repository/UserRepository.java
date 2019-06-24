package com.lambdaschool.friendfinderbe.repository;

import com.lambdaschool.friendfinderbe.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long>
{
    User findByUsername(String username);
}
