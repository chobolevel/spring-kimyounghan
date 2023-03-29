package com.company.approvalcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ms")
public class MsController {

    @GetMapping("login")
    public String msLogin() {
        return "redirect:https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=aa37dd07-47bc-4942-a172-7a50666bb9e6&response_type=token&response_mode=query&scope=user.read";
    }

}
