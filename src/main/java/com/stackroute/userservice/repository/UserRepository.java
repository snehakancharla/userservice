package com.stackroute.userservice.repository;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.Max;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>
{
//    List<User> findByName(String name);
//
//    @Query
//    List<User> findbyNameAndAge(String name,int age);

}
