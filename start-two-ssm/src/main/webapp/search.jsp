<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>${content}</title>
    <link type="text/css" rel="stylesheet" href="/css/search_style.css"/>
    <script type="text/javascript" src="/js/jquery.1.4.js"></script>
</head>
<body>

<!--头部导航开始-->
<%@include file="head.jsp" %>

<div id="bodyPart">

    <div class="crumb">
        全部结果&nbsp;&gt;&nbsp;
        <strong>"${content}"</strong>
    </div>

    <div class="left">

        <div id="commend" class="m rank">
            <div class="mt"><h2>热销商品</h2></div>
            <div class="mc">
                <ul>
                    <li class="fore">
                        <span>1</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>2</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>3</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>4</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>5</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>6</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>7</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                    <li>
                        <span>8</span>
                        <div class="p-img"><a href="#" target="_blank"><img width="50" height="50"
                                                                            src="img/ln_hotImg.jpg"></a></div>
                        <div class="p-name"><a href="#" target="_blank">联想（Lenovo）G460ALN 14</a></div>
                        <div class="p-price"><img src="img/ln_ipad_price.png"></div>
                    </li>
                </ul>
            </div>
        </div>
    </div><!-------left结束------->
    <div class="right-extra">
        <div id="select" class="m">
            <div class="mt">
                <h1>“${content}”</h1>
                <c:if test="${products.size() == 0}">
                    <strong>找不到相关匹配请您换一个搜索词</strong>
                </c:if>
                <c:if test="${products.size() != 0}">
                    <strong>搜索结果(${products.size()})</strong>
                </c:if>
            </div>
        </div>
        <div id="filter">
            <!--
                <div class="fore item">排序：</div>
                <ul class="item tab">
                    <li class="curr"><a href="#">相关性</a><span></span></li>
                    <li><a href="#">销量</a><span></span></li>
                    <li><b></b><a href="#">价格</a><span></span></li>
                    <li><a href="#">好评度</a><span></span></li>
                    <li><a href="#">上架时间</a><span></span></li>
                </ul>
             -->
            <div class="pagin pagin-m fr">
                <span class="text">1/1</span>
                <span class="prev-disabled">上一页<b></b></span>
                <span class="next-disabled">下一页<b></b></span>
            </div>

            <ul class="extra">
                <li class="total"><span>共<strong>${products.size()}</strong>个商品</span></li>
            </ul>
        </div>
        <div id="plist" class="m">
            <ul class="list-h clearfix">
                <c:forEach items="${products}" var="p">
                    <li>
                        <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="/${p.big_picture}"></a>
                        </div>
                        <div class="p-name"><a href="#" target="_blank">${p.author}<font style="color: red;">SUB</font>${p.name}<font
                                class="adwords" style="color:red;">${p.description}</font></a></div>
                        <div class="p-price">
                            <del>￥${p.fixed_price}</del>
                        <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>
                        <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>
                            <input type="button" value="收藏" class="btn-coll">
                        </div>
                    </li>
                </c:forEach>

<%--                <li>--%>
<%--                    <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="img/hivi.jpg"></a>--%>
<%--                    </div>--%>
<%--                    <div class="p-name"><a href="#" target="_blank">惠威（HIVI）H10 <font style="color: red;">SUB</font>有源低音炮<font--%>
<%--                            class="adwords" style="color:red;">“监听”风，从这里开始,H・system之-2</font></a></div>--%>
<%--                    <div class="p-price">--%>
<%--                        <del>￥3980.00</del>--%>
<%--                        <em></em><strong><img src="img/ln_ipad_price.png"></strong></div>--%>
<%--                    <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>--%>
<%--                    <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>--%>
<%--                        <input type="button" value="收藏" class="btn-coll">--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="img/hivi.jpg"></a>--%>
<%--                    </div>--%>
<%--                    <div class="p-name"><a href="#" target="_blank">惠威（HIVI）H10 <font style="color: red;">SUB</font>有源低音炮<font--%>
<%--                            class="adwords" style="color:red;">“监听”风，从这里开始,H・system之-2</font></a></div>--%>
<%--                    <div class="p-price">--%>
<%--                        <del>￥3980.00</del>--%>
<%--                        <em></em><strong><img src="img/ln_ipad_price.png"></strong></div>--%>
<%--                    <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>--%>
<%--                    <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>--%>
<%--                        <input type="button" value="收藏" class="btn-coll">--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="img/hivi.jpg"></a>--%>
<%--                    </div>--%>
<%--                    <div class="p-name"><a href="#" target="_blank">惠威（HIVI）H10 <font style="color: red;">SUB</font>有源低音炮<font--%>
<%--                            class="adwords" style="color:red;">“监听”风，从这里开始,H・system之-2</font></a></div>--%>
<%--                    <div class="p-price">--%>
<%--                        <del>￥3980.00</del>--%>
<%--                        <em></em><strong><img src="img/ln_ipad_price.png"></strong></div>--%>
<%--                    <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>--%>
<%--                    <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>--%>
<%--                        <input type="button" value="收藏" class="btn-coll">--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="img/hivi.jpg"></a>--%>
<%--                    </div>--%>
<%--                    <div class="p-name"><a href="#" target="_blank">惠威（HIVI）H10 <font style="color: red;">SUB</font>有源低音炮<font--%>
<%--                            class="adwords" style="color:red;">“监听”风，从这里开始,H・system之-2</font></a></div>--%>
<%--                    <div class="p-price">--%>
<%--                        <del>￥3980.00</del>--%>
<%--                        <em></em><strong><img src="img/ln_ipad_price.png"></strong></div>--%>
<%--                    <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>--%>
<%--                    <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>--%>
<%--                        <input type="button" value="收藏" class="btn-coll">--%>
<%--                    </div>--%>
<%--                </li>--%>
<%--                <li>--%>
<%--                    <div class="p-img"><a href="#" target="_blank"><img width="160" height="160" src="img/hivi.jpg"></a>--%>
<%--                    </div>--%>
<%--                    <div class="p-name"><a href="#" target="_blank">惠威（HIVI）H10 <font style="color: red;">SUB</font>有源低音炮<font--%>
<%--                            class="adwords" style="color:red;">“监听”风，从这里开始,H・system之-2</font></a></div>--%>
<%--                    <div class="p-price">--%>
<%--                        <del>￥3980.00</del>--%>
<%--                        <em></em><strong><img src="img/ln_ipad_price.png"></strong></div>--%>
<%--                    <div class="extra"><span class="evaluate"><a href="#" target="_blank">已有5人评论</a></span></div>--%>
<%--                    <div class="btns"><a class="btn-buy" target="_blank" href="#">购买</a>--%>
<%--                        <input type="button" value="收藏" class="btn-coll">--%>
<%--                    </div>--%>
<%--                </li>--%>
            </ul>
        </div>


        <div class="pagin fr">
            <span class="prev-disabled">上一页<b></b></span>
            <a href="#" class="current">1</a>
            <span class="next-disabled">下一页<b></b></span>
        </div>


    </div>
    <div class="m" id="re-search">
        <dl>
            <dt>重新搜索</dt>
            <dd>
                <input type="text" id="likeword" placeholder="${content}" class="text">
                <input type="button" onclick="likesearch()" value="搜&nbsp;索" class="button">
            </dd>
        </dl>
    </div>
    <script>
        function likesearch() {
            var content = $("#likeword").val();
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
    <div style="clear:both;"></div>
    <!-- 页脚 -->
    <%@include file="footer.jsp" %>

</div>
</body>
</html>
