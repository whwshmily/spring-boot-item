<%@ page contentType="text/html;charset=utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix='fmt' %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>京东商城 - 图书频道首页</title>
<link rel="stylesheet" type="text/css" href="/css/book.css" />
<link rel="stylesheet" type="text/css" href="/css/book_list.css" />
</head>
<body id="book">
<!--快捷访问栏开始-->
<%@include file="head.jsp"%>
<!--头部导航结束-->
<div class="clear"></div>
<c:if test="${parent ==null || parent.category_id >5 }">
    <script>
        (function () {
            alert("暂无书籍相关信息，下面将为您跳转到图书主页面");
            window.location.href = "/category/showAllOneLevelCategory";
        })();
    </script>
</c:if>
<!--位置-->
<div id="position" class="page_width">
	<ul>
     	<li><a href="/category/showAllOneLevelCategory">首页</a></li>
        <li>&gt;</li>
     	<li><a href = "/category/showAllOneLevelCategory">图书</a></li>
        <li>&gt;</li>
     	<li><a href="/category/showAllTwoLevelCategory?id=${parent.category_id}">${parent.name}</a></li>
        <li>&gt;</li>
        <li><a href="#">${category !=null ? category.name : "无"}</a></li>
     </ul>
</div>
<!--主体main部分开始-->
<div class="clear"></div>

<div id="main" class="page_width">
<!--左侧开始-->
	<div id="left_list">
    	<div id="same_sort">
			<div class="book_tit" style="width:209px;"><h2>浏览同级分类<br /><span>Browse other categories</span></h2></div>
				<div class="book_content">
					<ul>
                        <c:forEach items="${childList}" var="child">
                            <li><a href='/category/showAllTwoLevelCategory?id=${parent.category_id}&childId=${child.category_id}'>${child.name}</a></li>
                        </c:forEach>
<%--                        <li><a href='#'>中国近现代小说</a></li>--%>
<%--                        <li><a href='#'>中国古典小说</a></li>--%>
<%--                        <li><a href='#'>四大名著</a></li>--%>
<%--                        <li><a href='#'>港澳台小说</a></li>--%>
<%--                        <li><a href='#'>网络小说</a></li>--%>
<%--                        <li><a href='#'>外国小说</a></li>--%>
<%--                        <li><a href='#'>侦探/悬疑/推理</a></li>--%>
<%--                        <li><a href='#'>惊悚/恐怖</a></li>--%>
<%--                        <li><a href='#'>魔幻/奇幻/玄幻</a></li>--%>
<%--                        <li><a href='#'>军事</a></li>--%>
<%--                        <li><a href='#'>武侠</a></li>--%>
<%--                        <li><a href='#'>情感/家庭/婚姻</a></li>--%>
<%--                        <li><a href='#'>宫廷</a></li>--%>
<%--                        <li><a href='#'>社会</a></li>--%>
<%--                        <li><a href='#'>都市</a></li>--%>
<%--                        <li><a href='#'>乡土</a></li>--%>
<%--                        <li><a href='#'>职场</a></li>--%>
<%--                        <li><a href='#'>财经</a></li>--%>
<%--                        <li><a href='#'>官场</a></li>--%>
<%--                        <li><a href='#'>历史</a></li>--%>
<%--                        <li><a href='#'>影视小说</a></li>--%>
<%--                        <li><a href='#'>作品集</a></li>--%>
<%--                        <li><a href='#'>世界名著</a></li>--%>
<%--                        <li><a href='#'>期刊杂志</a></li>--%>
<%--                        <li><a href='#'>综合</a></li>--%>
<%--                        <li><a href='#'>名人A-Z</a></li>--%>
					</ul>
                    <div class="clear"></div>
					<div class="extra"><a href="/category/showAllOneLevelCategory">返回上级分类&gt;&gt;</a></div>
				</div>
			</div>	
			
            <div class="books">
			<div class="book_title">
				<h2>新书推荐<br /><span>New Releases</span></h2>
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="/bookDetail.jsp" target="_blank"><img src="/img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="/bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="/bookDetail.jsp" target="_blank"><img src="/img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			<div class="book_info">					
                <div class="book_pic">
                    <div class=""><a href="/bookDetail.jsp" target="_blank"><img src="/img/book_59.jpg"/></a></div>
                </div>
                <div class="book_text">
                    <div class="book_name"><a href="bookDetail.jsp" target="_blank"><font color="#FF0000">《古炉》（贾平凹）</font></a></div>
                    <div class="book_intr">　　《<古炉>（贾平凹）》的故事发生在陕西一个叫“古...</div>
                    <div class="book_more"><a href="#" target="_blank">深度了解&gt;&gt;</a></div>
                </div>	
			</div>
			</div>
            
		
			<div class="ad_left_list">
            	<div class=""><a href="#" target="_blank"><img src="/img/book_61.jpg" /></a></div>
				<div class=""><a href="#" target="_blank"><img src="/img/book_47.jpg"></a></div>
			</div>

    </div>
<!--左侧结束-->

<!--右侧开始-->    
    <div id="right_list">
    
		<div id="filter">
			<div class="fore item">排序：</div>
			<ul class="item tab">
                <li id='filter-curr' class='down'><b></b><a onclick="productSort(this,'print_INT',${parent.category_id},${category == null ? -5555 : category.category_id})">销售排行</a><span></span></li>
                <li  class='up price'><b></b><a onclick="productSort(this,'fixed_price',${parent.category_id},${category == null ? -5555 : category.category_id})">价格</a><span></span></li>
                <li  class="up discount"><b></b><a onclick="productSort(this,'lower_price',${parent.category_id},${category == null ? -5555 : category.category_id})">折扣</a><span></span></li>
                <li class="down"><b></b><a onclick="productSort(this,'print_INT',${parent.category_id},${category == null ? -5555 : category.category_id})">好评度</a><span></span></li>
                <li  class='down'><b></b><a onclick="productSort(this,'add_time',${parent.category_id},${category == null ? -5555 : category.category_id})">上架时间</a><span></span></li>
                <li  class="down"><b></b><a onclick="productSort(this,'print_time',${parent.category_id},${category == null ? -5555 : category.category_id})">出版时间</a><span></span></li>
			</ul>
            <script>
                function productSort(e,type,pid,id) {
                  var  filter = $("#filter-curr").attr("id",'');
                  var parent =  $(e).parent();
                  var up =  parent.hasClass("up");
                  parent.attr("id","filter-curr");
                  var sort = null;
                  if (up){
                     sort = 'desc';
                     parent.removeClass("up");
                     parent.addClass("down");
                  }else {
                      sort = 'asc';
                      parent.removeClass("down");
                      parent.addClass("up");
                  }
                  if (id == -5555)
                  return;
                  $.ajax({
                      url:"/category/changeSort",
                      type:"get",
                      data:{
                          "orderByName":type,
                          "sortType":sort,
                          "id":id
                      },
                      success:function (data) {
                          var ajaxData = $("#ajaxData");
                          ajaxData.html("");
                        for (var i = 0; i < data.length;i++){
                            var temp = data[i];
                            var myDate =  getMyDate(temp.publish_time);
                            myDate = myDate.substring(0,11);
                            ajaxData.append($("<div class=\"pro_item\">\n" +
                                "<div class=\"pro_picture\"><a href=\"/category/showProduct?id="+temp.product_id+"&pid="+pid+"\"><img src=\"/"+temp.picture+"\" /></a></div>\n" +
                                "<div class=\"pro_info\">\n" +
                                "<div class=\"pro_up\">\n" +
                                "<div class=\"bookName\"><a href=\"/category/showProduct?id="+temp.product_id+"&pid="+pid+"\">"+temp.name+"</a></div>\n" +
                                "<div class=\"author\">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>"+temp.author+"</span> 著，译<br />出&nbsp;版&nbsp;社：<span>"+temp.publishing+"</span><br /></div>\n" +
                                "</div>\n" +
                                "<div class=\"pro_down\">\n" +
                                "<div class=\"pro_left\">\n" +
                                "出版时间："+myDate+"<br />\n" +
                                "定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥"+temp.fixed_price+"</s>\n" +
                                "</div>\n" +
                                " <div class=\"pro_right\">\n" +
                                " 顾客评价：<span class=\"star\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />\n" +
                                "  销量：<b><font>"+temp.print_INT+"</font></b><span class=\"user_price\"></span> 京东价：<b>￥"+temp.lower_price+"</b>（43折)\n" +
                                "                            </div>\n" +
                                "                        </div>\n" +
                                "<div class=\"clear\"></div>\n" +
                                "<div class=\"book_btn\">\n" +
                                "  <a href=\"/category/initCart?productId="+temp.product_id+"\" class=\"buy\"></a><input type=\"button\" value=\"收藏\" class=\"favorite\" />\n" +
                                "  </div>\n" +
                                "  </div>\n" +
                                "                </div>\n"))
                        }
                      }
                  })
                }
                function getMyDate(str) {
                    var oDate = new Date(str),
                        oYear = oDate.getFullYear(),
                        oMonth = oDate.getMonth()+1,
                        oDay = oDate.getDate(),
                        oHour = oDate.getHours(),
                        oMin = oDate.getMinutes(),
                        oSen = oDate.getSeconds(),
                        oTime = oYear +'-'+ addZero(oMonth) +'-'+ addZero(oDay) +' '+ addZero(oHour) +':'+
                            addZero(oMin) +':'+addZero(oSen);
                    return oTime;
                }

                //补零操作
                function addZero(num){
                    if(parseInt(num) < 10){
                        num = '0'+num;
                    }
                    return num;
                }
            </script>
			<span class="clear"></span>
		</div>
        
<%--        <div class="page">--%>
<%--			<img src="/images/page.jpeg" />--%>
<%--		</div>--%>
        
        <div class="clear"></div>
        
        <div class="product_list" id="ajaxData">
            <c:if test="${bookList == null || bookList.size() == 0}">
                <div style="margin: 10px auto ; font-size: 22px">您查询的图书暂无</div>
            </c:if>
            <c:forEach items="${bookList}" var="p">
                <div class="pro_item">
                    <div class="pro_picture"><a href="/category/showProduct?id=${p.product_id}&pid=${parent.category_id}"><img src="/${p.picture}" /></a></div>
                    <div class="pro_info">
                        <div class="pro_up">
                            <div class="bookName"><a href="/category/showProduct?id=${p.product_id}&pid=${parent.category_id}">${p.name}</a></div>
                            <div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>${p.author}</span> 著，译<br />出&nbsp;版&nbsp;社：<span>${p.publishing}</span><br /></div>
                        </div>
                        <div class="pro_down">
                            <div class="pro_left">
                                出版时间：<fmt:formatDate value="${p.publish_time}" pattern="yyyy-MM-dd"></fmt:formatDate> <br />
                                定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥${p.fixed_price}</s>
                            </div>
                            <div class="pro_right">
                                顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />
                                销量：<b><font>${p.print_INT}</font></b><span class="user_price"></span> 京东价：<b>￥${p.lower_price}</b>（43折)
                            </div>
                        </div>
                        <div class="clear"></div>
                        <div class="book_btn">
                            <a href="/category/initCart?productId=${p.product_id}" class="buy"></a><input type="button" value="收藏" class="favorite" />
                        </div>
                    </div>
                </div>
            </c:forEach>

<%--            --%>
<%--             <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="/img/book_63.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="bookDetail.jsp">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div>--%>
<%--            --%>
<%--            <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="/img/book_64.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="bookDetail.jsp">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div> --%>
<%--            --%>
<%--            <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="/img/book_62.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="bookDetail.jsp">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div> --%>
<%--            --%>
<%--            <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="/img/book_62.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="bookDetail.jsp">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div> --%>
<%--            --%>
<%--            <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="bookDetail.jsp"><img src="/img/book_62.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="bookDetail.jsp">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div> --%>
<%--            --%>
<%--            <div class="pro_item">--%>
<%--            	<div class="pro_picture"><a href="ipad.html"><img src="/img/book_62.jpg" /></a></div>--%>
<%--                <div class="pro_info">--%>
<%--                	<div class="pro_up">--%>
<%--                    	<div class="bookName"><a href="#">夜谭十记：让子弹飞</a></div>--%>
<%--                    	<div class="author">作&nbsp;&nbsp;&nbsp;&nbsp;者：<span>马识途</span> 著，译<br />出&nbsp;版&nbsp;社：<span>陕西师范大学出版社</span><br /></div>--%>
<%--                    </div>--%>
<%--                    <div class="pro_down">--%>
<%--                    	<div class="pro_left">--%>
<%--                    	出版时间：2010年10月<br />--%>
<%--                        定&nbsp;&nbsp;&nbsp;&nbsp;价：<s>￥29.80</s>--%>
<%--                        </div>--%>
<%--                        <div class="pro_right">--%>
<%--                        顾客评价：<span class="star">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>（<span>已有96人评价</span>）<br />--%>
<%--                        会员价：<b><font>￥12.10</font></b><span class="user_price"></span> 京东价：<b>￥12.70</b>（43折)--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                    <div class="clear"></div>--%>
<%--                    <div class="book_btn">--%>
<%--                    <a href="initCart.jsp" class="buy"></a><input type="button" value="收藏" class="favorite" />--%>
<%--                    </div>--%>
<%--                </div>            --%>
<%--            </div> --%>
              
        </div><!--列表结束-->
        
        <div class="page">
			<img src="/images/page.jpeg" />
		</div>
          
    </div>
<!--右侧结束-->
</div>

<div class="clear"></div>
<!--服务部分开始-->
<%@include file="footer.jsp"%>
</body>
</html>
