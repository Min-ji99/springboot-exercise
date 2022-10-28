package com.springboot.controller;

import com.springboot.dao.UserDao;
import com.springboot.domain.User;
import com.springboot.domain.dto.UserRequestDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao=userDao;
    }
    @GetMapping("/")
    public String hello(){
        return "hello";
    }
    @GetMapping("/{variable}")
    public User findById(@RequestParam String id){
        return userDao.findById(id);
    }
    @PostMapping("/add")
    public void add(){
        //이 부분 맞나요..???
        userDao.add(new UserRequestDto("1", "minji", "1234"));
    }

    @DeleteMapping("/delete/{variable}")
    public void deleteById(@RequestParam String id){
        userDao.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll(){
        userDao.deleteAll();
    }
}
