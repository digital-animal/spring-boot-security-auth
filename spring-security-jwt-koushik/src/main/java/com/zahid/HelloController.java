package com.zahid;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController 
public class HelloController {

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/hello")
    public Map<String, String> hello() {
        HashMap<String, String> map = new HashMap<>();
        map.put("Name", "Zahidul Islam");
        map.put("Profession", "Software Engineer");
        map.put("Message", "Welcome to DSi");
        return map;
    }

    @GetMapping("/welcome")
    public ObjectNode welcome() {
        ObjectNode objectNode = mapper.createObjectNode();
        objectNode.put("Name", "Zahidul Islam");
        objectNode.put("Profession", "Software Engineer");
        objectNode.put("Message", "Welcome to DSi");
        objectNode.put("Salary", 54321);
        return objectNode;
    }
}
