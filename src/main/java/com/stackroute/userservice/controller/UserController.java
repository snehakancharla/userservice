package com.stackroute.userservice.controller;
import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exceptions.UserAlreadyExistsException;
import com.stackroute.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping(value="api/v1")
public class UserController {
    UserService userService;
    public  UserController(UserService userService){

        this.userService=userService;
    }
    @PostMapping("user")
    public ResponseEntity<?>saveUser(@RequestBody User user){
        ResponseEntity responseEntity;
        try{
            userService.saveUser(user);
            responseEntity=new ResponseEntity<String>("Successfully created", HttpStatus.CREATED);

        }catch (UserAlreadyExistsException ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);


        }
        return responseEntity;
    }
    @GetMapping("user")
    public ResponseEntity<?>getAllUsers(){
        return  new ResponseEntity<List<User>>(userService.getAllUsers(),HttpStatus.OK);
    }


}