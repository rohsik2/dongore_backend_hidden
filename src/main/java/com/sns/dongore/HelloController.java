package com.sns.dongore;

import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HelloController {

    @GetMapping("/")
    public ResponseEntity<?> sayhello(){
        return ResponseEntity.ok().body("Good Try.");
    }
}

