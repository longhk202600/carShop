package codluck.training.demo.controller;

import codluck.training.demo.dao.CarDAO;
import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.model.*;
import codluck.training.demo.service.*;
import codluck.training.demo.service.Impl.MailSenderJava;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeAdminController {
    @Autowired
    CarService carService;

    @Autowired
    ImageService imageService;

    @Autowired
    ShowroomService showroomService;

    @Autowired
    CompanyService companyService;

    @Autowired
    UserService userService;

    @Autowired
    PageService pageService;

    @Autowired
    OrderService orderService;

    @Autowired
    PostOrderService postOrderService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private HistoryTradeService historyTradeService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    MailSenderJava mailSenderJava;

    @Autowired
    ListOrderService listOrderService;

    //Delete user by userID
    @GetMapping(DefineConstrant.DELETE_MAPPING)
    public String deleteUserByID(@RequestParam(value = DefineConstrant.ID) int id,
                                 ModelMap model) {
        userService.deleteById(id);
        loginService.deleteByIdWithAdmin(id);
        model.addAttribute(DefineConstrant.NAME_LIST, userService.findAllExits());
        return DefineConstrant.ADMIN_HTML;
    }

    //delete showroom by id
    @GetMapping(DefineConstrant.DELETE_SHOWROOM_MAPPING)
    public String deleteShowRoomByID(@RequestParam(value = DefineConstrant.ID) int id,
                                     ModelMap model) {
        showroomService.deleteById(id);
        model.addAttribute(DefineConstrant.NAME_LIST, showroomService.findAll());
        return DefineConstrant.ADMIN_SHOWROOM_HTML;
    }

    //delete order by id
    @GetMapping(DefineConstrant.DELETE_ORDER_MAPPING)
    public String deleteOrderByID(@RequestParam(value = DefineConstrant.ID) int id,
                                     ModelMap model) {
        listOrderService.deleteById(id);
        model.addAttribute(DefineConstrant.NAME_LIST, listOrderService.getListOrder());
        return DefineConstrant.ADMIN_ORDER_HTML;
    }
    // manage order in db
    @RequestMapping(DefineConstrant.ADMIN_ORDER_MAPPING)
    public String loadListOrderByAdmin(Model model) {
        model.addAttribute(DefineConstrant.NAME_LIST, listOrderService.getListOrder());
        return DefineConstrant.ADMIN_ORDER_HTML;
    }

    // manage company
    @RequestMapping(DefineConstrant.ADMIN_SHOWROOM_MAPPING)
    public String loadShowRoomAdmin(Model model) {
        model.addAttribute(DefineConstrant.NAME_LIST, showroomService.findAll());
        return DefineConstrant.ADMIN_SHOWROOM_HTML;
    }

    // quan ly lich trinh mua ban
    @RequestMapping(DefineConstrant.ADMIN_POST_ORDER_MAPPING)
    public String loadAdminPostOrder(Model model) {
        model.addAttribute(DefineConstrant.NAME_LIST, postOrderService.findAllExits());
        return DefineConstrant.ADMIN_POST_ORDER;
    }

    @RequestMapping(DefineConstrant.INCOMEWEB_MAPPING)
    public String loadIncome(Model model) {
        model.addAttribute(DefineConstrant.NAME_LIST, historyTradeService.getlist());
        return DefineConstrant.INCOMEWEB_HTML;
    }

}
