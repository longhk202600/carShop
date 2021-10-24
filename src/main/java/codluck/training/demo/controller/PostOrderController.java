package codluck.training.demo.controller;

import codluck.training.demo.define.DefineConstrant;
import codluck.training.demo.service.PostOrderService;
import codluck.training.demo.model.PostOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author QuocDA
 * @version 1.1 9/6/2021
 */
@Controller
public class PostOrderController {

    @Autowired
    private PostOrderService postOrderService;

    @GetMapping(DefineConstrant.POST_ORDER_MAPPING)
    public String index(Model model) {
        model.addAttribute(DefineConstrant.ORDER, new PostOrder());
        model.addAttribute(DefineConstrant.ACTIVE, DefineConstrant.ORDER_CAR);
        return DefineConstrant.POST_ORDER_HTML;
    }

    @PostMapping(DefineConstrant.POST_ORDER_MAPPING)
    public String save(PostOrder order,
                       @RequestParam(DefineConstrant.IMAGE_CAR) MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        order.setIdUser(2);
        postOrderService.save(order, multipartFile);
        return DefineConstrant.INDEX_HTML;
    }

    @PostMapping(DefineConstrant.POST_ORDER_SAVE_MAPPING)
    public String savePostOrder(PostOrder order,
                                Model model) throws IOException {
        return DefineConstrant.INDEX_HTML;
    }



}
