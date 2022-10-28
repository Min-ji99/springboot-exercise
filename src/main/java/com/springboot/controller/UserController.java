package com.springboot.controller;

import com.springboot.dao.UserDao;
import com.springboot.domain.User;
import com.springboot.domain.dto.UserRequestDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private UserDao userDao;

    public UserController(UserDao userDao){
        this.userDao=userDao;
    }
    @GetMapping("/{id}")
    public User getId(@PathVariable("id") String id){
        return userDao.findById(id);
    }
    @PostMapping("/add")
    public void add(){
        userDao.add(new UserRequestDto("1", "minji", "1234"));
        System.out.println("등록되었습니다.a");
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable("id") String id){
        userDao.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAll() {
        userDao.deleteAll();
    }
}
