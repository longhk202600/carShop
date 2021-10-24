package codluck.training.demo.service.Impl;

import codluck.training.demo.model.OrderDetails;
import codluck.training.demo.repository.OrderDetailRepository;
import codluck.training.demo.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author QuocDA
 * @version 1.1 9/11/2021
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public List<OrderDetails> getOrderDetail() {
        return orderDetailRepository.getOrderDetail();
    }

    @Override
    public List<OrderDetails> getOrderDetailLimit(int index) {
        return orderDetailRepository.getOrderDetailLimit(index);
    }

    @Override
    public StringBuilder getHtmlOrderWitPage(List<OrderDetails> orderDetailsList) {
        StringBuilder html = new StringBuilder();
        for (OrderDetails orderDetails : orderDetailsList) {
            if (orderDetails.getCarUsage().equals("NEW")) {
                html.append("<tr class=\"shadow-lg border-bottom\" style=\" margin-top: 10px;\">");
                html.append("<td width=\"30%\">\n" +
                        "                    <img src=" + orderDetails.getImage() + " width=\"100%\" height=\"220px\" style=\"padding-top:10px; padding-bottom: 10px;\">\n" +
                        "                </td>");
                html.append("<td width=\"50%\">\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-bell \" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <h4 class=\"float-left\" style=\"font-weight: bold;\">" + orderDetails.getCarDescription() + "</h4>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-money-bill\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getPriceFrom() + " VND - " + orderDetails.getPriceTo() + " VND</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-couch\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getSeats() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-toggle-on\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                    <div class=\"float-left\">Mới</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-info-circle\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10 \">\n" +
                        "                                <div class=\"font-italic float-left\">" + orderDetails.getMoreDescription() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </td>");
                html.append(" <td width=\"20%\">\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <h4 style=\"font-weight: bold;\">Thông tin người đặt</h4>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-user-alt\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10 \">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getNameUser() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-map-marker-alt\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\" >" + orderDetails.getAddress() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-envelope\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getEmail() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-phone\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getPhone() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\" style=\"margin-top: 10px;\">\n" +
                        "                            <a href=\"#\" class=\"btn btn-primary\">Liên hệ</a>\n" +
                        "                        </div>\n" +
                        "                    </td>");
                html.append("</tr>");
            } else {
                html.append("<tr class=\"shadow-lg border-bottom\" style=\" margin-top: 10px;\">");
                html.append("<td>\n" +
                        "                    <img src=" + orderDetails.getImage() + " width=\"100%\" height=\"220px\" style=\"padding-top:10px; padding-bottom: 10px;\">\n" +
                        "                </td>");
                html.append("<td>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-bell \" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <h4 class=\"float-left\">" + orderDetails.getCarDescription() + "</h4>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-money-bill\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getPriceFrom() + " VND - " + orderDetails.getPriceTo() + " VND</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-couch\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getSeats() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-toggle-on\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                    <div class=\"float-left\">Cũ</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <div class=\"col-sm-1\">\n" +
                        "                                <i class=\"fas fa-info-circle\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10 \">\n" +
                        "                                <div class=\"font-italic float-left\">" + orderDetails.getMoreDescription() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                    </td>");
                html.append(" <td>\n" +
                        "                        <div class=\"row\">\n" +
                        "                            <h4 style=\"font-weight: bold;\">Thông tin người đặt</h4>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-user-alt\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10 \">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getNameUser() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-map-marker-alt\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\" >" + orderDetails.getAddress() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-envelope\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getEmail() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\">\n" +
                        "                            <div class=\"col-sm-2\">\n" +
                        "                                <i class=\"fas fa-phone\" style=\"font-size: 20px; padding: 5px;\"></i>\n" +
                        "                            </div>\n" +
                        "                            <div class=\"col-sm-10\">\n" +
                        "                                <div class=\"float-left\">" + orderDetails.getPhone() + "</div>\n" +
                        "                            </div>\n" +
                        "                        </div>\n" +
                        "                        <div class=\"form-row\" style=\"margin-top: 10px;\">\n" +
                        "                            <a href=\"#\" class=\"btn btn-primary\">Liên hệ</a>\n" +
                        "                        </div>\n" +
                        "                    </td>");
                html.append("</tr>");
            }
        }
        return html;
    }
}
