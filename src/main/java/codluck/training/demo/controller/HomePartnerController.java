package codluck.training.demo.controller;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.model.*;
import codluck.training.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class HomePartnerController {

    @Autowired
    private ShowroomService showroomService;

    @Autowired
    private CarService carService;

    @Autowired
    private OrderDetailService orderDetailService;

    @Autowired
    ImageService imageService;

    @Autowired
    UserService userService;

    @Autowired
    OrderService orderService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private HistoryTradeService historyTradeService;

    // phân trang quản lí xe
    @GetMapping(DefineConstrant.GET_CAR_WITH_PAGE_MAPPING)
    @ResponseBody
    public StringBuilder getCarWithPage(@RequestParam int beginPage,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
         int UserID= (int) session.getAttribute(DefineConstrant.USER_ID);
            return carService.getHtmlCarWithPage(carService.getCarInShowroomByUserIdLimit(UserID, beginPage));
    }

    // phân trang quản lí xe
    @GetMapping(DefineConstrant.GET_CAR_SOLD_WITH_PAGE_MAPPING)
    @ResponseBody
    public StringBuilder getCarSoldWithPage(@RequestParam int beginPage,HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        int UserID= (int) session.getAttribute(DefineConstrant.USER_ID);
        return carService.getHtmlCarSoldWithPage(carService.getCarSoldInHistoryByUserId(UserID, beginPage));
    }

    //phân trang post order
    @GetMapping(path = DefineConstrant.GET_POST_ORDER_WITH_PAGE)
    @ResponseBody
    public StringBuilder getPostOrderWithPage(@RequestParam int beginPageOrder) {
        return orderDetailService.getHtmlOrderWitPage(orderDetailService.getOrderDetailLimit(beginPageOrder));
    }

    // phân trang order car
    @GetMapping(path = DefineConstrant.GET_ORDER_WITH_PAGE)
    @ResponseBody
    public StringBuilder getCarOrderWithPage(@RequestParam int beginPageOrder,
                                      HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        int UserID= (int) session.getAttribute(DefineConstrant.USER_ID);
        return carService.getHtmlCarOrderWithPage(carService.getCarOrderLimit(UserID,beginPageOrder));
    }

    //hiển thị form sửa thông tin showroom
    @GetMapping(DefineConstrant.EDIT_SHOWROOM_MAPPING)
    public String editShowroom(@RequestParam int id, Model model) {
        model.addAttribute(DefineConstrant.SHOWROOM, showroomService.getShowroomById(id));
        return DefineConstrant.EDIT_SHOWROOM_HTML;
    }

    @GetMapping(DefineConstrant.ADD_SHOWROOM)
    public String addShowroom(Model model){
        model.addAttribute(DefineConstrant.SHOWROOM,new Showroom());
        return DefineConstrant.ADD_SHOWROOM_HTML;
    }

    //thêm showroom **
    @PostMapping(DefineConstrant.SAVE_SHOWROOM_HTML)
    public String doSaveShowroom(Showroom showroom,
                                 @RequestParam(DefineConstrant.LOGO_SHOWROOM) MultipartFile multipartFile,
                                 HttpServletRequest request) throws IOException {
        HttpSession session = request.getSession(true);
        int userID= (int) session.getAttribute(DefineConstrant.USER_ID);
        showroom.setUser_Id(userID);
        showroomService.save(showroom, multipartFile);
        return DefineConstrant.REDIRECT_HOME;
    }

    // update thông tin showroom vào database
    @PostMapping(DefineConstrant.UPDATE_SHOWROOM_MAPPING)
    public String doUpdateShowroom(Showroom showroom,
                                   @RequestParam(DefineConstrant.LOGO_SHOWROOM) MultipartFile multipartFile,
                                   Model model) throws IOException {
        showroomService.save(showroom, multipartFile);
        return DefineConstrant.REDIRECT_HOME_MAPPING;
    }
}
