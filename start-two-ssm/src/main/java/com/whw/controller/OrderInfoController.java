package com.whw.controller;

import com.whw.domain.Address;
import com.whw.domain.Cart;
import com.whw.domain.User;
import com.whw.service.IAddressService;
import com.whw.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class OrderInfoController {
    @Autowired
    private IAddressService service;
    @Autowired
    private ICategoryService categoryService;
    @GetMapping("/showOrderInfo")
    public String showOrderInfo(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Address> addresses = service.findByUserId(user.getUser_id());
        if (addresses != null && addresses.size()>0){
            request.setAttribute("address",addresses.get(0));
        }
        List<Cart> carts = categoryService.findByUserId(user.getUser_id());
        double totalCount = 0;
        for (Cart cart : carts) {
            totalCount += cart.getProduct().getLower_price() * cart.getProduct_num();
        }
        request.setAttribute("carts",carts);
        request.setAttribute("totalCount",totalCount);
        return "/orderInfoSure.jsp";
    }

}
