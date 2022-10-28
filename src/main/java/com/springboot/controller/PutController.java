package com.springboot.controller;

import com.springboot.domain.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/put-api")
public class PutController {
    @PutMapping(value="/member3")
    public ResponseEntity<MemberDto> MemberDto3(@RequestBody MemberDto memberDto){
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(memberDto);
    }

}
