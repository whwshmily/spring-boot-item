<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link rel="stylesheet" type="text/css" href="/css/head.css"/>
<script type="text/javascript" src="/js/jquery.1.4.js"></script>
<!--快捷访问栏开始-->
<div id="shortcut">
    <div class="page_width">
        <ul>
            <li class="welcome">您好！欢迎来到京东商城！
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
							<span><a href="login.jsp">[请登录]</a>，
						新用户<a href="register.jsp" class="link-regist">[免费注册]</a>
					         </span>
                    </c:when>
                    <c:otherwise>
                        <span>${user.login_name}</span>
                    </c:otherwise>
                </c:choose>
            </li>
            <li class="my_order"><a href="/orderList.jsp">我的订单</a></li>
            <li><a href="/userHome.jsp">我的京东</a></li>
            <li><a href="/category/myCart">我的购物车</a></li>
            <li class="sub">
                <a href="#" target="_blank">帮助中心</a>
            </li>
        </ul>
        <span class="clear"></span>
    </div>
</div>
<!--头部导航开始-->
<div id="header" class="page_width">

    <div id="logo">
        <a href="#"><img src="/images/logo.gif" width="251" height="46"/></a>
    </div>

    <div class="clear"></div>
    <div id="book_search">
        <div id="allsort">
            <div id="more_sort">
                <strong>图书分类</strong>
            </div>
        </div>
        <div id="search">
            <!--<div id="sub_search">-->
            <input type="text" id="keyword" placeholder="男孩"/>
            <!--</div>-->
            <a href="javascript:likeSearch()"> <input type="submit" id="btn_search" value="搜 索"/></a>
        </div>
        <script>
            function likeSearch() {
                var content = $("#keyword").val();
                $.ajax({
                    url: "/category/likeSearch",
                    type: "post",
                    data: {"content": content},
                    success: function (data) {
                        window.location.href = "/search.jsp";
                    }
                })
            }
        </script>
        <ul id="mycart">
            <li id="cart_info">购物车<b><font color="#066FC9">0</font></b>件</li>
            <li><font color="#ffffff">去结算</font></li>
        </ul>
    </div>
</div>
<!--头部导航结束-->


