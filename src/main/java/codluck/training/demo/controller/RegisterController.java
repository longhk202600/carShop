package codluck.training.demo.controller;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.model.Login;
import codluck.training.demo.model.User;
import codluck.training.demo.service.Impl.MailSenderJava;
import codluck.training.demo.service.Impl.RandomCode;
import codluck.training.demo.service.LoginService;
import codluck.training.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    @Autowired
    MailSenderJava mailSenderJava;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginService loginService;

    @GetMapping(DefineConstrant.REGISTER_MAPPING)
    public String login(Model model) {
        model.addAttribute(DefineConstrant.USER, new User());
        return DefineConstrant.REGISTER_HTML;
    }
// function register account
    @PostMapping(DefineConstrant.REGISTER_MAPPING)
    public String register(User user, Login login, Model model) {
        if (userService.save(user, login) == 2) {
            model.addAttribute(DefineConstrant.EMAIL_MESS, DefineConstrant.EMAIL_EXITS);
            return DefineConstrant.REGISTER_HTML;
        } else if (userService.save(user, login) == 3) {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.MESSAGE_ACCOUNT_EXITS);
            return DefineConstrant.REGISTER_HTML;
        } else {
            try {
                String body =
                        DefineConstrant.TEXT_HELLO + user.getName() +
                                DefineConstrant.TEXT_WELCOME +
                                login.getUsername() +
                                DefineConstrant.LINK_IN_MAIL_TEXT + user.getId() +
                                DefineConstrant.TEXT_BODY;
                mailSenderJava.sendSimpleEmail(user.getEmail(), body,
                        DefineConstrant.SUBJECT_ACTIVE_MAIL);
                model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.CHECKMAIL_ACCEPT_ACCOUT);
                return DefineConstrant.SUCCESS;
            } catch (Exception e) {
                model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.CHECK_AGAIN);
                return DefineConstrant.ERROR_HTML;
            }
        }
    }
//Function edit account and profile user
    @RequestMapping(value = DefineConstrant.EDIT_MAPPING, method = RequestMethod.POST)
    public String EditUser(User user, Login login, Model model,
                           @RequestParam(name = DefineConstrant.PASSWORD) String Password,
                           @RequestParam(name = DefineConstrant.NEW_PASSWORD) String newPassword,
                           @RequestParam(name = DefineConstrant.REPASSWORD) String rePassword) {

        if (!Password.isEmpty()) {
            if (!passwordEncoder.matches(Password, loginService.getPassword(user.getId()))) {
                model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.PASSWORD_WORRING);
                model.addAttribute(DefineConstrant.USER_UPPER, user);
                model.addAttribute(DefineConstrant.LOGIN_HTML, login);
                return DefineConstrant.EDIT_USER_HTML;
            } else if (!newPassword.equals(rePassword)) {
                model.addAttribute(DefineConstrant.MESSAGE_ERROR, DefineConstrant.REPASSWORD_WORRING);
                model.addAttribute(DefineConstrant.USER_UPPER, user);
                model.addAttribute(DefineConstrant.LOGIN_HTML, login);
                return DefineConstrant.EDIT_USER_HTML;
            } else {
                Login loginIn = loginService.getLoginByUserID(user.getId());
                loginIn.setPassword(newPassword);
                loginService.save(loginIn);
            }
        }
        if (userService.edit(user, login)) {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.EDIT_ACCOUNT_SUCCESS);
            return DefineConstrant.INDEX_HTML;
        } else {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.EDIT_ACCOUNT_FALSE);
            return DefineConstrant.REGISTER_HTML;
        }
    }
//Function get profile user by id
    @GetMapping(DefineConstrant.PROFILE_MAPPING)
    public String Profile(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        int userID = (int) session.getAttribute(DefineConstrant.USER_ID);
        User user = userService.getUserByID(userID);
        Login login = loginService.getLoginByUserID(userID);
        login.setPassword(passwordEncoder.encode(login.getPassword()));
        model.addAttribute(DefineConstrant.USER_UPPER, user);
        model.addAttribute(DefineConstrant.LOGIN_HTML, login);
        return DefineConstrant.EDIT_USER_HTML;
    }
//function get password from email
    @RequestMapping(value = DefineConstrant.FORGOT_PASSWORD, method = RequestMethod.POST)
    public String getPasswordFromEmail(Model model,
                           @RequestParam(name = DefineConstrant.EMAIL) String email) {
        RandomCode randomCode = new RandomCode();
        int code = randomCode.randomCode(1000, 10000);
        String newPassword = code + "";
        try {
            User user = userService.getUserByEmail(email);
            Login login = loginService.getLoginByUserID(user.getId());
            login.setPassword(newPassword);
            loginService.save(login);
            String body =
                    DefineConstrant.TEXT_HELLO + user.getName() +
                            DefineConstrant.TEXT_NEW_PASSWORD_MAIL +
                            login.getUsername() +
                            DefineConstrant.TEXT_NEW_MAIL + newPassword +
                            DefineConstrant.BODY_MAIL;
            mailSenderJava.sendSimpleEmail(email, body,
                    DefineConstrant.SUBJECT_MAIL);
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.SEEN_MAIL_RE_NEW_PASSWORD);
            return DefineConstrant.INDEX_HTML;
        } catch (Exception e) {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.ACCOUNT_DONT_EXITS);
            return DefineConstrant.INDEX_HTML;
        }
    }

    @GetMapping(DefineConstrant.CHANGE_PASSWORD_MAPPING)
    public String changePassword(Model model) {
        return DefineConstrant.LOGIN_HTML;
    }
//When user create new account will activate account
    @GetMapping(DefineConstrant.ACTIVE_ACOUNT_MAPPING)
    public String ActiveAccount(Model model,
                                @RequestParam(name = DefineConstrant.USER_ID) int userID) {
        try {
            loginService.activeAccount(userID);
        } catch (Exception e) {
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.CHECK_AGAIN);
            return DefineConstrant.ERROR_HTML;
        }
        return DefineConstrant.REDIRECT_LOGIN;
    }
}
