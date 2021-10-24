package codluck.training.demo.controller;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.model.Car;
import codluck.training.demo.model.Login;
import codluck.training.demo.service.CarService;
import codluck.training.demo.service.CompanyService;
import codluck.training.demo.service.ImageService;
import codluck.training.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private ImageService imageService;

    @Autowired
    private LoginService loginService;

    // hiển thị form thêm xe
    @GetMapping(DefineConstrant.POST_CAR_MAPPING)
    public String addCar(Model model) {
        model.addAttribute(DefineConstrant.CAR, new Car());
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.POST_CAR);
        model.addAttribute(DefineConstrant.COMPANY_LIST, companyService.getListCompany());
        return DefineConstrant.POST_CAR;
    }

    // hiển thị form sửa xe
    @GetMapping(DefineConstrant.EDIT_CAR_MAPPING)
    public String editCar(Model model,
                          @RequestParam int id) {
        model.addAttribute(DefineConstrant.CAR, carService.getCarById(id));
        model.addAttribute(DefineConstrant.COMPANY_LIST, companyService.getListCompany());
        model.addAttribute(DefineConstrant.MORE_CAR_IMAGE, imageService.getImageByCarId(id));
        return DefineConstrant.EDIT_CAR;
    }

    // xóa xe
    @GetMapping(DefineConstrant.DELETE_CAR)
    public String deleteCar(@RequestParam int id,
                            Model model) {
        String message = "";
        if (carService.deleteCarById(id)) {
            message = DefineConstrant.MESSAGE_DELETE_SUCCESS;
        } else {
            message = DefineConstrant.MESSAGE_DELETE_ERROR;
        }
        model.addAttribute(DefineConstrant.MESSAGE, message);
        return DefineConstrant.REDIRECT_HOME;
    }

    //save car
    @PostMapping(DefineConstrant.SAVE_CAR_MAPPING)
    public String doSaveCar(Car car,
                            HttpServletRequest request,
                            @RequestParam(DefineConstrant.IMAGE_CAR) MultipartFile multipartFile,
                            @RequestParam(DefineConstrant.MORE_CAR_IMAGE) MultipartFile[] moreImageCar)
            throws IOException {
        HttpSession session = request.getSession(true);
        int UserID = (int) session.getAttribute(DefineConstrant.USER_ID);
        car.setUserId(UserID);
        carService.saveCar(car, multipartFile, moreImageCar);
        return DefineConstrant.REDIRECT_HOME;
    }

    //update car
    @PostMapping(DefineConstrant.UPDATE_CAR_MAPPING)
    public String doUpdateCar(Car car, HttpServletRequest request,
                              @RequestParam(DefineConstrant.IMAGE_CAR) MultipartFile multipartFile,
                              @RequestParam(DefineConstrant.MORE_CAR_IMAGE) MultipartFile[] moreImageCar)
            throws IOException {
        HttpSession session = request.getSession(true);
        //get user id in session
        int UserID = (int) session.getAttribute(DefineConstrant.USER_ID);
        car.setUserId(UserID);
        carService.updateCar(car, multipartFile, moreImageCar);
        return DefineConstrant.REDIRECT_HOME;
    }
}
