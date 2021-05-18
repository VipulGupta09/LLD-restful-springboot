package com.learn.restfulwebservices.restful_webservice.user.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learn.restfulwebservices.restful_webservice.user.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

}
