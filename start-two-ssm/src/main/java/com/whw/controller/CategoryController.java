package com.whw.controller;

import com.whw.domain.Cart;
import com.whw.domain.Category;
import com.whw.domain.Product;
import com.whw.domain.User;
import com.whw.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService service;

    @RequestMapping("/showAllOneLevelCategory")
    public String showAllOneLevelCategory(HttpServletRequest request) {
        List<Category> list = service.findAllOneLevelCategory();
        request.setAttribute("list", list);
        return "/book.jsp";
    }

    @GetMapping("/showAllTwoLevelCategory")
    public String showAllTwoLevelCategory(
            @RequestParam("id") int id,
            @RequestParam(value = "childId", defaultValue = "0") int childId,
            HttpServletRequest request) {
        Category parent = service.findById(id);
        List<Category> childList = service.findByParentId(id);
        request.setAttribute("parent", parent);
        request.setAttribute("childList", childList);
        Category category = null;
        List<Product> bookList = null;
        if (childId == 0) {
            if (childList != null && childList.size() != 0) {
                category = childList.get(childId);
            }
        } else {
            category = service.findById(childId);
        }
        if (category != null) {
            bookList = service.findByCategoryIdAndSort(category.getCategory_id(), "print_INT", "desc");
        }
        request.setAttribute("category", category);
        request.setAttribute("bookList", bookList);
        return "/book_list.jsp";
    }

    @GetMapping("/changeSort")
    @ResponseBody
    public List<Product> changeSort(int id, String orderByName, String sortType) {
        return service.findByCategoryIdAndSort(id, orderByName, sortType);
    }

    @PostMapping("/likeSearch")
    @ResponseBody
    public String likeSearch(String content, HttpServletRequest request) {
        List<Product> products = service.findByLikeSearch("'%" + content + "%'");
        request.getSession().setAttribute("products", products);
        request.getSession().setAttribute("content", content);
        return "ok";
    }

    @GetMapping("/showProduct")
    public String showProduct(int id, int pid, HttpServletRequest request) {
        Product product = service.findByProductId(id);
        Category category = service.findById(pid);
        request.setAttribute("product", product);
        request.setAttribute("category", category);
        return "/bookDetail.jsp";
    }

    @RequestMapping("/initCart")
    public String initCart(int productId, HttpServletRequest request) {
        Product product = service.findByProductId(productId);
        User user = (User) request.getSession().getAttribute("user");
        Product p = new Product();
        p.setProduct_id(productId);
        Cart cart = new Cart(-1, p, user.getUser_id(), 1);
        double price = 0;
        int productCount = 0;
        List<Cart> carts = service.findByUserId(user.getUser_id());
        int i = carts.indexOf(cart);
        if (i != -1) {
            Cart c = carts.get(i);
            c.setProduct_num(c.getProduct_num() + 1);
            service.updateByCartId(c);
        } else {
            service.insertCart(cart);
            carts.add(cart);
        }
        for (int j = 0; j < carts.size(); j++) {
            Cart cc = carts.get(j);
            Product pp = service.findByProductId(cc.getProduct().getProduct_id());
            price += pp.getLower_price() * cc.getProduct_num();
            productCount += cc.getProduct_num();
        }
        request.setAttribute("product", product);
        request.setAttribute("price", price);
        request.setAttribute("productCount", productCount);
        return "/initCart.jsp";
    }
    @RequestMapping("/myCart")
    public String myCart(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        List<Cart> carts = service.findByUserId(user.getUser_id());
        double totalPrice = 0;
        for (Cart cart : carts) {
            totalPrice += cart.getProduct().getLower_price() * cart.getProduct_num();
        }
        request.setAttribute("carts",carts);
        request.setAttribute("totalPrice",totalPrice);
        return "/myCart.jsp";
    }

    @PostMapping("/updateCartNum")
    @ResponseBody
    public String updateCartNum(int product_id ,int type,HttpSession session){
        User user = (User) session.getAttribute("user");
        Cart cart = service.findByUserIdAndProductId(user.getUser_id(), product_id);
        cart.setProduct_num(cart.getProduct_num()+type);
        int i = service.updateByCartId(cart);
        if (i<0){
            return "error";
        }
        return "success";
    }
    @PostMapping("/deleteCart")
    @ResponseBody
    public Map<String,Object> deleteCart(@RequestParam(value = "product_id",defaultValue = "-1")int product_id ,HttpSession session){
        User user = (User) session.getAttribute("user");
        Map<String,Object> map = new HashMap<>();
        int i;
        if (product_id == -1){
             i = service.deleteByUserId(user.getUser_id());
        }else {
            Cart cart = service.findByUserIdAndProductId(user.getUser_id(), product_id);
            i = service.deleteByUserIdAndProduct(user.getUser_id(),product_id);
            map.put("cart",cart);
        }
        if (i<0){
            map.put("code","-1");
        }else {
            map.put("code","200");
        }
        return map;
    }
}
