package com.whw.action.admin;

import com.whw.domain.Category;
import com.whw.domain.Product;
import com.whw.service.ICategoryService;
import com.whw.service.IProductService;
import com.whw.util.PageCategory;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.Name;
import java.util.Date;

@ParentPackage("whw")
@Namespace("/admin/product")
@Results({
        @Result(name = "page" ,type = "dispatcher" ,location = "/admin/listProduct.jsp"),
        @Result(name = "ok" ,type = "redirect" ,location = "page?category.id=${category.id}"),
        @Result(name = "edit" ,type = "dispatcher" ,location = "/admin/editProduct.jsp")
})
public class ProductAction {
    @Autowired
    private IProductService service;
    @Autowired
    private ICategoryService categoryService;
    private Category category;
    private PageCategory pageCategory = new PageCategory();
    private Product product;

    @Action("page")
    public String page() {
        url = "&category.id=" + category.getId();
        category = categoryService.findById(category.getId());
        pageCategory = service.findByCategoryId(category.getId(), pageCategory.getPageNumber());
        return "page";
    }
    @Action(value = "add")
    public String add(){
        product.setCreate_time(new Date());
        service.save(product);
        category = new Category();
        category.setId(product.getCategory().getId());
        return "ok";
    }
    @Action("edit")
    public String edit(){
        product = service.findById(product.getId());
        category = categoryService.findById(category.getId());
        return "edit";
    }
    @Action("update")
    public String update(){
        service.update(product);
        return "ok";
    }
    @Action("delete")
    public String delete(){
        product = service.findById(product.getId());
        product.setDel(1);
        service.update(product);
        return "ok";
    }
    public PageCategory getPageCategory() {
        return pageCategory;
    }

    public void setPageCategory(PageCategory pageCategory) {
        this.pageCategory = pageCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
