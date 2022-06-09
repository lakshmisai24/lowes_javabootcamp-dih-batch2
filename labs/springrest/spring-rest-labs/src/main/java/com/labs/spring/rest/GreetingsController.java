package com.labs.spring.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.awt.*;

@RestController
public class GreetingsController {

    @RequestMapping(path = "/greetings", method = RequestMethod.GET, produces = {MediaType.TEXT_PLAIN_VALUE})
    public String greetings() {
        return "Hello rest spring";
    }

}