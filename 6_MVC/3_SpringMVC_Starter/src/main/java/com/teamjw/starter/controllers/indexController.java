package com.teamjw.starter.controllers;

import com.teamjw.starter.data.model.MemberVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class indexController {

    @GetMapping("/")
    public String index(Model model){

        model.addAttribute("title","Home");
        model.addAttribute("body","It Works!!");
        return "index";
    }

    //st
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public
    Object getAffiliateInfoByAffiliateNo(MemberVO member, HttpServletRequest request) throws Throwable
    {
        System.out.println("logger : " + member);
        HashMap< String, Object > results = null;
        return results;
    }
}
