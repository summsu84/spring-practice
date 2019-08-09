package com.teamjw.ctr;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @RequestMapping(value="/hello", method = RequestMethod.GET, produces = "application/json; charset=utf8")
    public Map<String, String> helloWorld()
    {
        Map<String, String> stringMap = new HashMap<String, String>();

        stringMap.put("1", "test");
        stringMap.put("2", "test");

        return stringMap;

    }
}
