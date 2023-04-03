package com.company.approvalcore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("ms")
public class MsController {

    @GetMapping("login")
    public String msLogin() {
        return "redirect:https://login.microsoftonline.com/common/oauth2/v2.0/authorize?client_id=aa37dd07-47bc-4942-a172-7a50666bb9e6&response_type=code&redirect_uri=http://localhost:8080/auth/token&response_mode=query&scope=openid%20offline_access%20https%3A%2F%2Fgraph.microsoft.com%2Fmail.read&state=12345";
    }

}
