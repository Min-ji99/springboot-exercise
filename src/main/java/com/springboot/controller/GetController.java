package com.springboot.controller;

import com.springboot.domain.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/get-api")
@Slf4j
public class GetController {
    @RequestMapping(value="/hello", method= RequestMethod.GET)
    public String getHello(){
        log.info("hello 요청이 들어왔습니다");
        return "hello world";
    }
    @GetMapping(value="/name")
    public String getName(){
        return "Minji";
    }
    @GetMapping(value="/variable1/{variable}")
    public String getVariable1(@PathVariable String variable){
        log.info("getVariable1 요청이 들어왔습니다.");
        return variable;
    }
    @GetMapping(value="/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var){
        log.info("getVariable1 요청이 들어왔습니다. variable : {}", var);
        return var;
    }
    @GetMapping(value="/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization){
        //return name+" "+email+" "+organization;
        return String.format("%s %s %s", name, email, organization);
    }

    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param){
        param.entrySet().forEach(map -> {
            System.out.printf("key : %s value : %s", map.getKey(), map.getValue());
        });
        return "request2 호출되었습니다";
    }

    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto){
        return memberDto.toString();
    }
}
