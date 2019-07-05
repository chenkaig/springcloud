package com.jk.controller;

import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class PageController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("toShow")
    public String toShow(){
        return "show";
    }

    @RequestMapping("toAddDialog")
    public String toAddDialog(){
        return "addDialog";
    }

    @RequestMapping("selectUserById")
    public String selectUserById(Integer id, Model  model){
        User user = restTemplate.getForObject("http://provider-user/selectUserById/"+id, User.class);
        model.addAttribute("user",user);
        return "updateDialog";
    }
}
