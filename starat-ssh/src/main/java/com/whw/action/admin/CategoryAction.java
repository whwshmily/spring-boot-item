package com.whw.action.admin;

import com.opensymphony.xwork2.ActionContext;
import com.whw.domain.Category;
import com.whw.service.ICategoryService;
import com.whw.util.PageCategory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@ParentPackage("whw")
@Namespace("/admin/category")
@Results({
        @Result(name = "success", type = "dispatcher", location = "/admin/listCategory.jsp"),
        @Result(name = "ok", type = "redirectAction", location = "page"),
        @Result(name = "edit", type = "dispatcher", location = "/admin/editCategory.jsp")
})
public class CategoryAction {
    @Autowired
    private ICategoryService service;

    private Category category;

    private PageCategory pageCategory;

    public void setPageCategory(PageCategory pageCategory) {
        this.pageCategory = pageCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public PageCategory getPageCategory() {
        return pageCategory;
    }

    @Action(value = "page")
    public String pageSelect() {
        if (pageCategory ==null) {
            pageCategory = new PageCategory();
            pageCategory.setPageNumber(1);
        }
        pageCategory = service.pageSelect(pageCategory.getPageNumber());
        return "success";
    }

    @Action(value = "add")
    public String save() {
        ServletActionContext.getResponse();
        ActionContext.getContext().getSession();
        service.save(category);
        return "ok";
    }

    @Action(value = "delete")
    public String delete() {
        category = service.findById(category.getId());
        category.setDel(1);
        service.update(category);
        return "ok";
    }
    @Action("edit")
    public String edit(){
        category = service.findById(category.getId());
        return "edit";
    }
    @Action("update")
    public String update(){
        service.update(category);
        return "ok";
    }
}
