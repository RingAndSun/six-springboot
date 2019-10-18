package com.sixweb.sixspringboot.dao;

import com.sixweb.sixspringboot.pojo.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by RogueMonkey on 2019/10/18.
 */
public interface UserDAO extends JpaRepository<User,Integer> {

    User findByUsername(String username);

    User getByUsernameAndPassword(String username,String password);
}
