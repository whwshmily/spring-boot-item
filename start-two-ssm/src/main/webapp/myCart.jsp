<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="/css/myCart_style.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="/js/jquery.1.4.js"></script>
<title>无标题文档</title>
</head>
<body>
<!------------头部------------->
<%@include file="head1.jsp" %>

<div id="bodyPart">
	<div id="top">
		<div id="logo"></div>
		<div id="Cart">
			<ul>
				<li id="myCart" class="white">1.我的购物车</li>
				<li id="writeInfo">2.填写核对订单信息</li>
				<li id="successSub">3.成功提交订单</li>				
			</ul>
		</div>
	</div>
	<div id="top_myCart"></div>
	<div class="List_cart">
		<h2>
			<strong>我挑选的商品</strong>
		</h2>
		<div class="cart_table" id="cart_table">
			<table id="CartTb" cellpadding="0" cellspacing="0" width="600">
				<tr class="align_Right">
					<td>商品编号</td>
					<td>商品名称</td>
					<td>京东价</td>
					<td>返现</td>
					<td>赠送积分</td>
					<td>商品数量</td>
					<td>删除商品</td>
				</tr>
				<c:forEach items="${carts}" var="c">
				<tr>
					<td>${c.product.product_id}</td>
					<td id="align_Left">
						<div id="c_img"><a href="ipad.jsp"><img src="/${c.product.picture}" style="height: 100px"></a></div>
						<div id="c_info"><span><a href="#">${c.product.name}</a></span><br><span class="redColor">[赠品]</span>无 <span class="redColor"></span></div>
					</td>
					<td class="price">￥${c.product.lower_price}</td>
					<td>￥0.00</td>
					<td>0</td>
					<td width="70">
						<div id="eqNum">
							<ul>
								<li class="Img" onclick="updateCartNum(this,-1)"><img src="/img/bag_close.gif"/></li>
								<li><span type="text"  id="num" >${c.product_num}</span></li>
								<li class="Img" onclick="updateCartNum(this,1)"><img src="/img/bag_open.gif"/></li>
							</ul>
						</div>
					</td>
					<td onclick="deleteCart(this)">删除</td>
				</tr>
				<tr>
				</c:forEach>

					<td colspan="7" class="align_Right" height="40"><b>商品总金额(不含运费)：<span id="cartBottom_price" class="price">￥${totalPrice}</span>元</b></td>
				</tr>
				<script>
					function deleteCart(e) {
						var product_id = $(e).parents("tr").find("td:eq(0)").text();
						var	price =  $(e).parents("tr").find(".price").text().substring(1);
						var span = $(e).prev().find("ul>li:eq(1)").find("span").text();
						var cartBottom_price = $("#cartBottom_price").text().substring(1);
						$.ajax({
							url:"/category/deleteCart",
							data:{"product_id":product_id},
							type:"post",
							success:function (data) {
								if (data.code = '200'){
									alert("删除成功");
									$(e).parent().remove();
									cartBottom_price = +cartBottom_price -Number(price)*Number(span);
									$("#cartBottom_price").html("￥"+cartBottom_price)
									console.info(data.cart);
									showDelete(data.cart);
								}else {
									alert("删除失败")
								}
							}
						})
					}
					function updateCartNum(e,type) {
						var	price =  $(e).parents("tr").find(".price").text().substring(1);
						var product_id = $(e).parents("tr").find("td:eq(0)").text();
						var  num =- null;
						var span = null;
						var cartBottom_price = $("#cartBottom_price").text().substring(1);
						if (type == -1){
							span =$(e).next().find("span");
						   num	= span.text();
							cartBottom_price = Number(cartBottom_price) - price;
						}else {
							span = $(e).prev().find("span");
							num	= span.text();
							cartBottom_price = Number(cartBottom_price) + +price;
						}
						if (num == 1 && type == -1){
							return ;
						}
						num = +num + +type;
						$.ajax({
							url:"/category/updateCartNum",
							data:{"product_id":product_id,"type":type},
							type:"post",
							success:function (data) {
								if (data.code = '200'){
									span.html(num);
									$("#cartBottom_price").html("￥"+cartBottom_price)
								}else {
									alert("修改失败");
								}
							}
						})
					}
					function showDelete(data) {
						var totalPrice = data.product.lower_price * data.product_num;
						$("#cart_table").append("\t\t\t<div id=\"DeledSkuInfo\"\n" +
								"\t\t\t\t<div>已删除商品，您可以重新购买或加入收藏夹：</div>\n" +
								"\t\t\t\t<div id=\"divDeledSku\">\n" +
								"\t\t\t\t\t<div class=\"delItem\">\n" +
								"\t\t\t\t\t\t<table class=\"delItem\">\n" +
								"\t\t\t\t\t\t\t<tr>\n" +
								"\t\t\t\t\t\t\t\t<td style=\"width: 70px;\">"+data.product.product_id+"</td>\n" +
								"\t\t\t\t\t\t\t\t<td style=\"text-align: left;\"><a href=\"#\">"+data.product.name+"</a></td>\n" +
								"\t\t\t\t\t\t\t\t<td style=\"width: 150px;\"><span class=\"price\">￥"+totalPrice +"</span></td>\n" +
								"\t\t\t\t\t\t\t\t<td style=\"width: 125px;\">"+data.product_num+"</td><td style=\"width: 100px;\"><a href=\"/category/initCart?productId="+data.product.product_id+"\">重新购买</a> | <a href=\"#\">收藏</a></td>\n" +
								"\t\t\t\t\t\t\t</tr>\n" +
								"\t\t\t\t\t\t</table>\n" +
								"\t\t\t\t\t</div>\n" +
								"\t\t\t\t</div>\n" +
								"\t\t\t</div>\n")
					}
				</script>
			</table>
			<div id="cart_op">
				<ul>
					<li id="li1">寄存购物车</li>
					<li id="li2" onclick="deleteAll()">清空购物车</li>
					<li id="li3">凑单商品</li>
					<li id="li4"><a href="showAllOneLevelCategory"><img src="/img/btn0603_1.jpg"/></a><a href="/order/showOrderInfo"><img src="/img/btn0603_2.jpg"/></a></li>
				</ul>
			</div>
			<script>
				function deleteAll() {
					$.ajax({
						url:"/category/deleteCart",
						type:"post",
						success:function (data) {
							if (data = 'success'){
								alert("删除成功")
								$("#CartTb").find("tr:eq(0)").nextAll().html("");
								$("#cartBottom_price").html("0")

							}else {
								alert("删除失败")
							}
						}
					})
				}
			</script>

		</div><!---cart_table--->
	</div>
	
	<div id="sbox_3" class="Wrap_cart">
		<div class="c-top"></div>	
		<div class="content_right">
			<h3>购买了同样商品的顾客还购买了</h3>		
			<ul class="num">
				<li>1</li>
				<li>2</li>
				<li class="on">3</li>
			</ul>
			<div class="ad">
				<ul>
					<li class="Product_List_S3">
						<ul>
							<li>
								<dl>
									<dt><a href="#"><img src="/img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="/img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="/img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
							<li>
								<dl>
									<dt><a href="#"><img src="/img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="/img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
							<li>
								<dl>
									<dt><a href="#"><img src="/img/ms.jpg"></a></dt>
									<dd>
										<div class="p_Name"><a href="#">微软（Microsoft）无线激光鼠标ARC 黑色</a></div>
										<div class="p_Price"><img src="/img/ms_price.png"></div>
										<div class="p_Opp"><a href="#"><img src="/img/addcart2.gif"></a></div>

									</dd>
								</dl>
							</li>						
						</ul>
					</li>
				</ul>			
			</div>			
		</div>
		<div class="c-bot"></div>		
		
			
	</div>
	
	<div class="List_cart t">
		<h2>
			<strong>我收藏的商品<span id="smallSize">(现在就放入购物车吧！)</span><span id="extra">进入收藏夹>></span></strong>
		</h2>
		<div id="notFav">
			您还未收藏任何商品...
		</div>
	</div>
	<div id="help">
		帮我们改进购物车	</div>	
</div>
<!-- 页脚1 -->
<%@include file="footer1.jsp" %>

</body>
</html>
