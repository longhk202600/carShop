package codluck.training.demo.controller;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.model.Login;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping(DefineConstrant.LOGIN_MAPPING)
    public String login(Model model,
                        @RequestParam(value = DefineConstrant.SUCCESS,
                                defaultValue = DefineConstrant.TRUE, required = false) boolean success) {
        if (!success ) {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.LOGIN_FAIL);
            return DefineConstrant.LOGIN_HTML;
        } else {
            return DefineConstrant.LOGIN_HTML;
        }
    }

}
