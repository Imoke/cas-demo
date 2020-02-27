package org.example;

import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@SpringBootApplication
@EnableCasClient
@Controller
public class Application {

    @Value(value = "${client.redirect-url}")
    private String redirectUrl;
    public static void main(String[] args) {
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/cas/client/logout")
    public String logout(HttpServletRequest request, Model model) {
        // String loginUrl = request.getHeader("loginUrl");
        model.addAttribute("url", redirectUrl);
        return "logout";
    }

    @RequestMapping("/cas/client/login")
    public String casLogin(HttpServletRequest request, Model model) {
        // String clientRedirectUrl = request.getHeader("clientRedirectUrl");
        model.addAttribute("url", redirectUrl);
        return "index";
    }

}

