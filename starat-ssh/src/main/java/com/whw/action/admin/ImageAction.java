package com.whw.action.admin;

import cn.hutool.core.io.FileUtil;
import com.whw.domain.Imgage;
import com.whw.domain.Product;
import com.whw.service.IImgageService;
import com.whw.service.IProductService;
import lombok.Getter;
import lombok.Setter;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@ParentPackage("whw")
@Namespace("/admin/image")
@Results({
        @Result(name = "list", type = "dispatcher", location = "/admin/listProductImage.jsp")
       ,@Result(name = "ok" ,type = "redirect" ,location = "list?product.id=${image.product.id}")
})
@Getter
@Setter
public class ImageAction {
    @Autowired
    private IImgageService service;
    @Autowired
    private IProductService productService;
    private File img;
    private String imgFileName;
    private String imgFileContentType;
    private Imgage image;
    private List<Imgage> list1 = new ArrayList<Imgage>();
    private List<Imgage> list2 = new ArrayList<Imgage>();
    private List<Imgage> list3 = new ArrayList<Imgage>();
    private Product product;

    @Action("list")
    public String list() {
        product = productService.findById(product.getId());
        List<Imgage> list = service.findByProductId(product.getId());
        for (int i = 0; i <list.size() ; i++) {
            Imgage imgage = list.get(i);
            int type = imgage.getType();
            if (type == 1){
                list1.add(imgage);
            }
            if (type == 2){
                list2.add(imgage);
            }
            if (type == 3){
                list3.add(imgage);
            }
        }
        return "list";
    }


    @Action("add")
    public String coverImg() {
        if (img == null){
            return "ok";
        }
        HttpServletRequest request = ServletActionContext.getRequest();
        String saveName = imgFileName;
        String savePath = "/images/";
        String path = request.getContextPath();
        String url = "http://localhost:80" + path + savePath + saveName;
        String realPath = request.getServletContext().getRealPath(savePath);
        File target = new File(realPath + saveName);
        FileUtil.copy(img, target, true);
        image.setDel(0);
        image.setUrl(url);
        service.save(image);
        return "ok";
    }
    @Action("delete")
    public String del(){
        image = service.get(image.getId());
        image.setDel(1);
        service.update(image);
        return "ok";
    }

}
