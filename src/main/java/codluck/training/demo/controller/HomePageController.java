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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class HomePageController {

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
    private LoginService loginService;

    @Autowired
    private HistoryTradeService historyTradeService;

    @Autowired
    private OrderDetailService orderDetailService;

    // trang chủ khi người dùng đăng nhập
    @GetMapping(DefineConstrant.HOME_PAGE_MAPPING)
    public String getAll(Model model, HttpServletRequest request) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        HttpSession session = request.getSession(true);
        //ghi list company
        session.setAttribute(DefineConstrant.LIST_COMPANY, companyService.findAll());
        if (authentication == null)
            return null;
        Object principal = authentication.getPrincipal();
        //nếu có 1 account đăng nhập sẽ checxk role
        if (principal instanceof UserDetails) {
            String role = ((UserDetails) principal).getAuthorities().toString();
            String username = ((UserDetails) principal).getUsername();
            Login login = loginService.getAccountByUserName(username);
            int userID = login.getUserId();
            session.setAttribute(DefineConstrant.USER_ID, userID);
            //nếu là đăng nhập vs vai trò người mua
            if (DefineConstrant.ROLE_CUSTOMER_SECURITY.equals(role)) {
                model.addAttribute(DefineConstrant.NAME_LIST, carService.getTop12Car());
                model.addAttribute(DefineConstrant.NAME_OF_TOP_LIST, companyService.getTop5Company());
                model.addAttribute(DefineConstrant.NAME_OF_LIST_COMPANY, companyService.findAll());
                model.addAttribute(DefineConstrant.TITLE, DefineConstrant.MESSAGE_NEW_CAR);
                model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.MESSAGE_HOME);
                model.addAttribute(DefineConstrant.ROLE, DefineConstrant.CUSTOMER);
                session.setAttribute(DefineConstrant.ROLE, DefineConstrant.CUSTOMER);
                return DefineConstrant.INDEX_HTML;
                //nếu là đăng nhập vs vai trò admin
            } else if (DefineConstrant.ROLE_ADMIN_SECURITY.equals(role)) {
                session.setAttribute(DefineConstrant.ROLE, DefineConstrant.ADMIN);
                model.addAttribute(DefineConstrant.NAME_LIST, userService.findAllExits());
                return DefineConstrant.ADMIN_HTML;
                //nếu là đăng nhập vs vai người bán
            } else if (DefineConstrant.ROLE_PARTNER_SECURITY.equals(role)) {
                session.setAttribute(DefineConstrant.ROLE, DefineConstrant.PARTNER);
                model.addAttribute(DefineConstrant.SHOWROOM, showroomService.getShowroomByUserId(userID));
                model.addAttribute(DefineConstrant.CAR_IN_SHOWROOM,
                        carService.getCarInShowroomByUserIdLimit(userID, 0));
                model.addAttribute(DefineConstrant.CAR_SOLD,
                        carService.getCarSoldInShowroomByUserIdLimit(userID, 0));
                model.addAttribute(DefineConstrant.ORDER_DETAIL, orderDetailService.getOrderDetailLimit(0));
                model.addAttribute(DefineConstrant.CAR_ORDER, carService.getCarOrderLimit(userID, 0));
                model.addAttribute(DefineConstrant.TOTAL_PAGE_ORDER,
                        carService.arrayPage(orderDetailService.getOrderDetail().size()));
                model.addAttribute(DefineConstrant.TOTAL_PAGE_CAR,
                        carService.arrayPage(carService.getCarInShowroomByUserId(userID).size()));
                model.addAttribute(DefineConstrant.TOTAL_PAGE_CAR_SOLD,
                        carService.arrayPage(carService.getCarSoldInShowroomByUserId(userID).size()));
                model.addAttribute(DefineConstrant.TOTAL_PAGE_CAR_ORDER,
                        carService.arrayPage(carService.getCarOrder(userID).size()));
                return DefineConstrant.HOME_PARTNER_HTML;
            }
            //nếu chưa đăng nhập sẽ trả về trang home dành cho customer
        } else {
            session.setAttribute(DefineConstrant.ROLE, DefineConstrant.CUSTOMER);
            model.addAttribute(DefineConstrant.NAME_LIST, carService.getTop12Car());
            model.addAttribute(DefineConstrant.NAME_OF_TOP_LIST, companyService.getTop5Company());
            model.addAttribute(DefineConstrant.NAME_OF_LIST_COMPANY, companyService.findAll());
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.MESSAGE_NEW_CAR);
            model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.MESSAGE_HOME);
            return DefineConstrant.INDEX_HTML;
        }
        return DefineConstrant.ERROR_HTML;
    }

    //hiển thị ra danh sác các xe theo tên hãng xe
    @GetMapping(DefineConstrant.GET_COMPANY_MAPPING)
    public String getCarByCompanyID(@RequestParam(value = DefineConstrant.ID) int id,
                                     @RequestParam(value = DefineConstrant.NAME, required = false,
                                             defaultValue = DefineConstrant.DEFAULT_BMV) String name,
                                     ModelMap model) {
        model.addAttribute(DefineConstrant.NAME_LIST, carService.getCarByCompanyId(id));
        model.addAttribute(DefineConstrant.NAME_OF_TOP_LIST, companyService.getTop5Company());
        model.addAttribute(DefineConstrant.NAME_OF_LIST_COMPANY, companyService.findAll());
        model.addAttribute(DefineConstrant.TITLE, name);
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.COMPANY);

        return DefineConstrant.NEW_CAR_HTML;
    }

    //tìm kiếm xe
    @PostMapping(DefineConstrant.SEARCH_MAPPING)
    public String searchCar(@RequestParam(value = DefineConstrant.SEARCH) String value,
                            @RequestParam(value = DefineConstrant.INPUT) String input,
                            ModelMap model) {
        System.out.println(value);
        System.out.println(input);
        if (DefineConstrant.NAME.equals(value)) {
            model.addAttribute(DefineConstrant.NAME_LIST, carService.findByNameContaining(input));
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.FIND_CAR_BY_NAME + input);
        } else if (DefineConstrant.COMPANY.equals(value)) {
            model.addAttribute(DefineConstrant.NAME_LIST, carService.findByNameCompanyContaining(input));
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.FINE_CAR_BY_TYPE + input);
        }
        return DefineConstrant.NEW_CAR_HTML;
    }

    //sắp xếp xe
    @PostMapping(DefineConstrant.SORT_MAPPING)
    public String sortCar(@RequestParam(value = DefineConstrant.SORT) String value, ModelMap model) {
        if (DefineConstrant.PRICE_ASC.equals(value)) {
            model.addAttribute(DefineConstrant.NAME_LIST, carService.sortCarByPriceASC());
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.SORT_CAR_AS);
        } else if (DefineConstrant.PRICE_DESC.equals(value)) {
            model.addAttribute(DefineConstrant.NAME_LIST, carService.sortCarByPriceDESC());
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.SORT_CAR_DE);
        } else if (DefineConstrant.NAME_DESC.equals(value)) {
            model.addAttribute(DefineConstrant.NAME_LIST, carService.sortCarByNameASC());
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.SORT_CAR_BY_NAME);
        }
        model.addAttribute(DefineConstrant.NAME_OF_TOP_LIST, companyService.getTop5Company());
        model.addAttribute(DefineConstrant.NAME_OF_LIST_COMPANY, companyService.findAll());
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.MESSAGE_HOME);
        return DefineConstrant.INDEX_HTML;
    }

    // hiển thị chi tiết xe
    @GetMapping(DefineConstrant.DETAIL_CAR_MAPPING)
    public String getCarByCarID(@RequestParam(value = DefineConstrant.ID) int id, ModelMap model) {
        model.addAttribute(DefineConstrant.CAR_UPCASE, carService.findCarById(id));
        model.addAttribute(DefineConstrant.LIST_IMAGE, imageService.getListImageByCarId(id));
        Car car = carService.findCarById(id);
        int userId = car.getUserId();
        String price = CarDAO.getPrice(car.getPriceFrom(), car.getPriceTo());
        model.addAttribute(DefineConstrant.PRICE, price);
        model.addAttribute(DefineConstrant.ATTRIBUTE_SHOWROOM, showroomService.getShowroomByUserID(userId));
        model.addAttribute(DefineConstrant.NAME_LIST, carService.getCarByCompanyId(car.getCompanyId(), id));
        return DefineConstrant.DETAIL_CAR_HTML;
    }

    @GetMapping(DefineConstrant.ADMIN_MAPPING)
    public String homeAdmin(Model model) {
        model.addAttribute(DefineConstrant.NAME_LIST, userService.findAllExits());
        return DefineConstrant.ADMIN_HTML;
    }

    //khi người dùng ấn vào quan tâm 1 sản phẩm thì sản phẩm đó sẽ vào giỏ hàng
    @GetMapping(DefineConstrant.ADD_CART_MAPPING)
    public String addCart(@RequestParam(value = DefineConstrant.ID, required = false,
            defaultValue = DefineConstrant.DEFAUL_VALUE_ZERO) int id,
                          HttpServletRequest request,
                          ModelMap model) {
        try {
            HttpSession session = request.getSession(true);
            Object o = session.getAttribute(DefineConstrant.CART);
            int userID = (int) session.getAttribute(DefineConstrant.USER_ID);
            List<Car> listCar = carService.getListCarFromUserOrder(userID);
            if (id == 0) {
                model.addAttribute(DefineConstrant.LIST_ORDER_HTML, listCar);
                return DefineConstrant.CART_HTML;
            } else {
                Car car = carService.findCarById(id);
                List<Car> list = carService.getListfromCart(o, car);
                session.setAttribute(DefineConstrant.CART, list);
                model.addAttribute(DefineConstrant.LIST_ORDER_HTML, listCar);
                return DefineConstrant.CART_HTML;
            }
        } catch (Exception e) {
            model.addAttribute(DefineConstrant.MESSGESS, DefineConstrant.CUSTORMER_IS_ADD);
            return DefineConstrant.ERROR_HTML;
        }
    }

    //phân trang ở trang xe mới và xe cũ
    @GetMapping(DefineConstrant.PAGE_MAPPING)
    public String findPaginated(@RequestParam(value = DefineConstrant.PAGE_NO, required = false) int pageNo,
                                @RequestParam(value = DefineConstrant.STATUS, required = false) boolean status,
                                Model model) {
        int pageSize = 12;
        Page<Car> page;
        page = pageService.findAllByStatus(status, pageNo, pageSize);
        List<Car> listProducts = page.getContent();
        if (status) {
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.NEW_CAR_MESS);
            model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.NEW_CAR_HTML);
        }
        if (!status) {
            model.addAttribute(DefineConstrant.TITLE, DefineConstrant.OLD_CAR_MESS);
            model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.OLD_CAR);
        }
        model.addAttribute(DefineConstrant.LIST_COMPANY, companyService.findAll());
        model.addAttribute(DefineConstrant.ACTIVE_PAGE, true);
        model.addAttribute(DefineConstrant.STATUS, status);
        model.addAttribute(DefineConstrant.CURRENT_PAGE, pageNo);
        model.addAttribute(DefineConstrant.TOTAL_PAGES, page.getTotalPages());
        model.addAttribute(DefineConstrant.TOTAL_ITEMS, page.getTotalElements());
        model.addAttribute(DefineConstrant.NAME_LIST, listProducts);
        model.addAttribute(DefineConstrant.NAME_OF_TOP_LIST, companyService.getTop5Company());
        return DefineConstrant.NEW_CAR_HTML;
    }

    @GetMapping(DefineConstrant.CAR_ODER_MAPPING)
    public String Order(@RequestParam(value = DefineConstrant.ID) int carId,
                        ModelMap model,
                        HttpServletRequest request) {
        try {
            HttpSession session = request.getSession(true);
            int userID = (int) session.getAttribute(DefineConstrant.USER_ID);
            Order order = new Order(carId, userID, true);
            if (orderService.checkOrder(carId, userID)) {
                orderService.save(order);
                model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.ADD_CAR_SUCCSESS);
                return DefineConstrant.REDIRECT_ADD_CART;
            } else if (!orderService.checkOrder(carId, userID)) {
                model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.CAR_HAVE_ORDER);
                return DefineConstrant.ERROR_HTML;
            }
        } catch (Exception e) {
            return DefineConstrant.ERROR_HTML;
        }
        return DefineConstrant.ERROR_HTML;
    }

    //when partner click one car will show customer order this car
    @GetMapping(DefineConstrant.LIST_ODER_MAPPING)
    public String getListOrderByCarID(@RequestParam(value = DefineConstrant.ID, required = false,
            defaultValue = DefineConstrant.DEFAULT_VALUE_ONE) int id,
                                      ModelMap model) {
        Car car = carService.findCarById(id);
        List<Image> listImage = imageService.getListImageByCarId(car.getId());
        List<User> listUser = userService.getListUserByCarID(id);
        String price = CarDAO.getPrice(car.getPriceFrom(), car.getPriceTo());
        model.addAttribute(DefineConstrant.PRICE, price);
        model.addAttribute(DefineConstrant.CAR, car);
        model.addAttribute(DefineConstrant.LIST_USER, listUser);
        model.addAttribute(DefineConstrant.LIST_IMAGE, listImage);
        return DefineConstrant.LIST_ORDER_HTML;
    }

    //when partner click car solded , will change status in db
    @GetMapping(DefineConstrant.CONFIRM_ODER_MAPPING)
    public String ConfirmOrder(@RequestParam(value = DefineConstrant.USER_ID, required = false) int userId,
                               @RequestParam(value = DefineConstrant.CAR_ID, required = false) int carId,
                               @RequestParam(value = DefineConstrant.MONEY, required = false) float money,
                               ModelMap model) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DefineConstrant.FORMAT_DATE);
        LocalDateTime now = LocalDateTime.now();
        String currentDate = dtf.format(now);
        int userIdPartner = carService.getCarById(carId).getUserId();
        HistoryTrade historyTrade = new HistoryTrade(userId, userIdPartner, carId, money, currentDate, true);
        HistoryTrade history = historyTradeService.save(historyTrade);
        if (history != null) {
            orderService.deleteOrderByCarID(historyTrade.getCarID());
//            carService.deleteCarById(history.getCarID());
            carService.changeUserId(history.getCarID(),history.getUserID());
            model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.ACCEP_SUCCES);
            return DefineConstrant.REDIRECT_HOME_MAPPING;
        }
        return DefineConstrant.ERROR_HTML;
    }

    //khi người dùng muốn xóa bỏ 1 xe đã order từ trước
    @GetMapping(DefineConstrant.CAR_DELETE_ORDER_MAPPING)
    public String deleteOrder(@RequestParam(value = DefineConstrant.ID) int id, ModelMap model) {
        orderService.deleteOrderByID(id);
        model.addAttribute(DefineConstrant.MESSAGE, DefineConstrant.DELETE_ORDER_SUCCESS);
        return DefineConstrant.INDEX_HTML;
    }

    // show all list show room
    @RequestMapping(DefineConstrant.SHOW_ROOM_MAPPING)
    public String showAllCar(Model model) {
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.SHOWROOM);
        model.addAttribute(DefineConstrant.NAME_LIST, showroomService.findAll());
        return DefineConstrant.SHOWROOM;
    }

    @RequestMapping(DefineConstrant.GET_SHOWROOM_MAPPING)
    public String getByShowRoom_ID(@RequestParam(value = DefineConstrant.ID) int id,
                                   @RequestParam(value = DefineConstrant.NAME) String name,
                                   ModelMap model) {
        model.addAttribute(DefineConstrant.NAME_LIST, carService.getCarByUserId(id));
        model.addAttribute(DefineConstrant.TITLE, name);
        model.addAttribute(DefineConstrant.SHOWROOM, showroomService.getShowroomByUserId(id));
        return DefineConstrant.LIST_CAR_IN_SHOWROOM_HTML;
    }

    @GetMapping(DefineConstrant.FORGOT_PASSWORD)
    public String forgotPassword() {
        return DefineConstrant.FORGOT_PASSWORD_HTML;
    }

    //khi người dùng muốn xem tất cả hãng xe có trong web
    @GetMapping(DefineConstrant.LIST_COMPANY_MAPPING)
    public String getListCompany(Model model) {
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.COMPANY);

        return DefineConstrant.LIST_COMPANY;
    }

    //get all list post order
    @GetMapping(DefineConstrant.LIST_POST_ORDER)
    public String getListPostOrder(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        int userID = (int) session.getAttribute(DefineConstrant.USER_ID);
        model.addAttribute(DefineConstrant.ORDER_DETAIL, orderDetailService.getOrderDetailLimit(0));
        model.addAttribute(DefineConstrant.TOTAL_PAGE_ORDER, carService.arrayPage(orderDetailService.getOrderDetail().size()));
        model.addAttribute(DefineConstrant.TOTAL_PAGE_CAR_ORDER, carService.arrayPage(carService.getCarOrder(userID).size()));
        return DefineConstrant.LIST_POST_ORDER_HTML;
    }
}
