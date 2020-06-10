<%--
  Created by IntelliJ IDEA.
  User: xen
  Date: 2017/12/5
  Time: 21:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>

<c:set var="title" value="商品管理 - 图片管理"/>
<%@include file="common/adminHeader.jsp" %>
<c:set var="light" value="1"/>
<%@include file="common/adminNavigator.jsp" %>

<div class="container">
    <ol class="breadcrumb">
        <li><a href="/admin/category/page">所有分类</a></li>
        <li><a href="../product/page?category.id=${product.category.id}">${product.category.name}</a></li>
        <li>${product.name}</li>
        <li>图片管理</li>
    </ol>

    <div class="container" style="width:33.3%;float:left">
        <h4>封面图片</h4>

        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">图片</th>
                <th scope="col">删除</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="list" items="${list1}">
                <tr>
                    <th scope="row">${list.id}</th>
                    <td><img src="${list.url}" height="50px"></td>
                    <td><a href="delete?image.id=${list.id}" class="delete-button"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>

            </tbody>
        </table>

        <div class="panel panel-default">
            <div class="panel-heading">新增图片</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form3" action="add"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="file3" class="col-sm-4 control-label">图片文件</label>
                        <div class="col-sm-8">
                            <input id="file3" name="img" type="file" class="file">
                        </div>
                    </div>
                    <input type="hidden" value="${product.id}" name="image.product.id">
                    <input type="hidden" value="1" name="image.type">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建图片</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </div>

    <div class="container" style="width:33.3%;float:left">
        <h4>顶部图片</h4>

        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">图片</th>
                <th scope="col">删除</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${list2}" var="ti" varStatus="vs">
                <tr>
                    <th scope="row">${ti.id}</th>
                    <td><img src="${ti.url}" height="50px"></td>
                    <td><a href="  delete?image.id=${ti.id}" class="delete-button"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="panel panel-default">
            <div class="panel-heading">新增图片</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form" action="add"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="file" class="col-sm-4 control-label">图片文件</label>
                        <div class="col-sm-8">
                            <input id="file" name="img" type="file" class="file">
                        </div>
                    </div>
                    <input type="hidden" value="${product.id}" name="image.product.id">
                    <input type="hidden" value="2" name="image.type">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建图片</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </div>

    <div class="container" style="width:33.3%;float:left">
        <h4>详情图片</h4>

        <table class="table table-hover table-striped">
            <thead>
            <tr>
                <th scope="col">#</th>
                <th scope="col">图片</th>
                <th scope="col">删除</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach items="${list3}" var="ti" varStatus="vs">
                <tr>
                    <th scope="row">${ti.id}</th>
                    <td><img src="${ti.url}" height="50px"></td>
                    <td><a href="delete?image.id=${ti.id}" class="delete-button"><span
                            class="glyphicon glyphicon-trash"></span></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <div class="panel panel-default">
            <div class="panel-heading">新增图片</div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" id="add-form2" action="add"
                      enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="file2" class="col-sm-4 control-label">图片文件</label>
                        <div class="col-sm-8">
                            <input id="file2" name="img" type="file" class="file">
                        </div>
                    </div>
                    <input type="hidden" value="${product.id}" name="image.product.id">
                    <input type="hidden" value="3" name="image.type">
                    <div class="form-group">
                        <div style="text-align: center">
                            <button type="submit" class="btn btn-success btn-sm">新建图片</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>


    </div>
</div>
<%@include file="common/adminFooter.jsp" %>