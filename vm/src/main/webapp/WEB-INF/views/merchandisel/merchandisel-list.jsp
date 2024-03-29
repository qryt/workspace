<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<meta http-equiv="Cache-Control" content="no-siteapp" />
<!--[if lt IE 9]>
<script type="text/javascript" src="lib/html5shiv.js"></script>
<script type="text/javascript" src="lib/respond.min.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/page/css/H-ui.min.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/login/css/H-ui.admin.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/lib/Hui-iconfont/1.0.8/iconfont.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/login/skin/default/skin.css" id="skin" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/login/css/style.css" />
<link rel="stylesheet" type="text/css" href="${APP_PATH }/static/page/css/bootstrap.css" />

<title>商品列表</title>
</head>
<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 渠道管理 <span class="c-gray en">&gt;</span> 渠道列表 <a class="btn btn-success radius r" style="line-height:1.6em;margin-top:3px" href="javascript:location.replace(location.href);" title="刷新" ><i class="Hui-iconfont">&#xe68f;</i></a></nav>
	<div style="width:100%;height:100%; margin-left: 30%">
		<div style="float: left;">
			<select id="selectContext" class="input-text" style="width:150px;">
				<option value="1">按商品名称</option>
				<option value="2">按渠道商品名称</option>
			</select>
		</div>
		<div>
			<div class="" id="channelMerchandise">
				<input type="text" class="input-text" style="width:250px" placeholder="输入商品名称" id="content" name="">
				<button type="button" class="btn btn-success" id="selectMerchandiseByName" name=""><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>
			</div>
			<div class="" id="merchandise" style="display: none;">
				<input type="text" class="input-text" style="width:250px" placeholder="输入渠道商品名称" id="channelMerchandiseName" name="">
				<button type="button" class="btn btn-success" id="selectMerchandiseByChannelMerName" name=""><i class="Hui-iconfont">&#xe665;</i> 搜商品</button>
			</div>
		</div>
	</div>
	
	<div class="cl pd-5 bg-1 bk-gray mt-20"> <span class="l">
		<a href="javascript:;" onclick="merchandise_add('维护商品渠道','/web/addMerchandise','550','500')" class="btn btn-primary radius">
			<i class="Hui-iconfont">&#xe600;</i> 维护商品渠道
		</a></span>
	</div>
	<table id="admin_table" class="table table-border table-bordered table-bg">
		<thead>
			<tr>
				<th scope="col" colspan="9">渠道列表</th>
			</tr>
			<tr class="text-c">
				<th width="25"><input type="checkbox" name="" value=""></th>
				<th>渠道商品名称</th>
				<th>渠道名称</th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>渠道关联编号</th>
				<th>渠道商品价格</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		</tbody>
	</table>
			<!-- 显示分页信息 -->
		<div class="row" style="width:80%;">
			<!--分页文字信息  -->
			<div class="col-md-6" id="page_info_area"></div>
			<!-- 分页条信息 -->
			<div class="col-md-6" id="page_nav_area">
				
			</div>
		</div>

<!--_footer 作为公共模版分离出去-->
<script type="text/javascript" src="${APP_PATH }/static/lib/jquery/1.9.1/jquery.min.js"></script> 
<script type="text/javascript" src="${APP_PATH }/static/lib/layer/2.4/layer.js"></script>
<script type="text/javascript" src="${APP_PATH }/static/page/js/H-ui.min.js"></script> 
<script type="text/javascript" src="${APP_PATH }/static/login/js/H-ui.admin.js"></script> <!--/_footer 作为公共模版分离出去-->



<!--请在下方写此页面业务相关的脚本-->
<script type="text/javascript" src="${APP_PATH }/static/lib/My97DatePicker/4.8/WdatePicker.js"></script> 
<script type="text/javascript" src="${APP_PATH }/static/lib/datatables/1.10.0/jquery.dataTables.min.js"></script> 
<script type="text/javascript" src="${APP_PATH }/static/lib/laypage/1.2/laypage.js"></script>
<!-- 删除时确认窗口 -->

<!-- 分页相关 -->
<script src="${APP_PATH }/static/HDpaging/jquery-1.11.1.min.js"></script>
<script src="${APP_PATH }/static/HDpaging/paging.js"></script>


<script type="text/javascript">
var totalRecord,currentPage;
		$(function(){
		  	//去首页
			to_page(1);
		});
		/**
		* 首页
		*/
		function to_page(pn){
			var select = $("#selectContext").val();
			var channelMerchandiseName = $("#channelMerchandiseName").val();
			var content = $("#content").val();
			
			//alert(channelMerchandiseName);
			//alert(content);
			
			if (select == 1) {
				channelMerchandiseName == "";
			}else{
				content == "";
			}
			$.ajax({
				url:"${APP_PATH}/getMerchandiseAll",
				data:{"pn":pn,"content":content,"channelMerchandiseName":channelMerchandiseName},
				type:"GET",
				success:function(result){
					//1、解析并显示角色数据
					build_roles_table(result);
					//2、解析并显示分页信息
					build_page_info(result);
					//3、解析显示分页条数据
					build_page_nav(result);
				}
			});
		}
		
		//显示数据
		function build_roles_table(result){
			//清空table表格
			$("#admin_table tbody").empty();
			var menu = result.extend.pageInfo.list;
			$.each(menu,function(index,item){
					var checkBoxTd = $("<td><input type='checkbox' class='check_item'/></td>").css("padding-left","14px");
					var channelMerchandiseId = $("<td style='display: none;'></td>").append(item.channelMerchandiseId);
					var ChannelName = item.channel;
					if (ChannelName != null) {
						ChannelName = $("<td></td>").append(item.channel.channelName).css("text-align","center");
					}else{
						ChannelName = $("<td></td>").append("").css("text-align","center");
					}
					
					var merchandiseName = item.merchandise;
					if (merchandiseName != null) {
						merchandiseName = $("<td></td>").append(item.merchandise.merchandiseName).css("text-align","center");
						var merchandiseNum = $("<td></td>").append(item.merchandise.merchandiseNumber).css("text-align","center");
					}else{
						merchandiseName = $("<td></td>").append("").css("text-align","center");
						var merchandiseNum = $("<td></td>").append("").css("text-align","center");
					}
					var channelMerchandiseNumber = $("<td></td>").append(item.channelMerchandiseNumber).css("text-align","center");
					var abc = item.channelMerchandisePrice;
					if (abc != null) {
						var channelMerchandisePrice = $("<td></td>").append("￥"+item.channelMerchandisePrice).css("text-align","center");
					}else{
						var channelMerchandisePrice = $("<td></td>").append("").css("text-align","center");
					}
					
					var channelMerchandiseName = $("<td></td>").append(item.channelMerchandiseName).css("text-align","center");
					
					
					var editBtn = $("<button></button>").addClass("btn btn-primary btn-sm edit_btn").append($("<span></span>").addClass("glyphicon")).append("编辑");
					//为编辑按钮添加一个自定义的属性，来表示当前角色id
					editBtn.attr("edit-id",item.channelMerchandiseId).attr("onclick","merchandise_edit('商品编辑','/web/EditMerchandise?id="+item.channelMerchandiseId+"',"+item.channelMerchandiseId+",'800','600')");
					var delBtn =  $("<button></button>").addClass("btn btn-danger btn-sm delete_btn").append($("<span></span>").addClass("glyphicon")).append("删除");
					//为删除按钮添加一个自定义的属性来表示当前删除的角色id
					delBtn.attr("del-id",item.channelMerchandiseId);
					var btnTd = $("<td></td>").append(editBtn).append(" ").append(delBtn).append(" ").css("width","130px");
					//var delBtn = 
					//append方法执行完成以后还是返回原来的元素
					$("<tr></tr>").append(checkBoxTd)
						.append(channelMerchandiseId)
						.append(channelMerchandiseName)
						.append(ChannelName)
						.append(merchandiseName)
						.append(merchandiseNum)
						.append(channelMerchandiseNumber)
						.append(channelMerchandisePrice)
						.append(btnTd)
						.appendTo("#admin_table tbody");
			});
		}
		
		//解析显示分页信息
		function build_page_info(result){
			$("#page_info_area").empty();
			$("#page_info_area").append("当前"+result.extend.pageInfo.pageNum+"页,总"+
					result.extend.pageInfo.pages+"页,总"+
					result.extend.pageInfo.total+"条记录");
			totalRecord = result.extend.pageInfo.total;
			currentPage = result.extend.pageInfo.pageNum;
		}
		//解析显示分页条，点击分页要能去下一页....
		function build_page_nav(result){
			//page_nav_area
			$("#page_nav_area").empty();
			var ul = $("<ul></ul>").addClass("pagination");
			
			//构建元素
			var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
			var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
			if(result.extend.pageInfo.hasPreviousPage == false){
				firstPageLi.addClass("disabled");
				prePageLi.addClass("disabled");
			}else{
				//为元素添加点击翻页的事件
				firstPageLi.click(function(){
					to_page(1);
				});
				prePageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum -1);
				});
			}
			
			var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
			var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
			if(result.extend.pageInfo.hasNextPage == false){
				nextPageLi.addClass("disabled");
				lastPageLi.addClass("disabled");
			}else{
				nextPageLi.click(function(){
					to_page(result.extend.pageInfo.pageNum +1);
				});
				lastPageLi.click(function(){
					to_page(result.extend.pageInfo.pages);
				});
			}
			
			
			//添加首页和前一页 的提示
			ul.append(firstPageLi).append(prePageLi);
			//1,2，3遍历给ul中添加页码提示
			$.each(result.extend.pageInfo.navigatepageNums,function(index,item){
				
				var numLi = $("<li></li>").append($("<a></a>").append(item));
				if(result.extend.pageInfo.pageNum == item){
					numLi.addClass("active");
				}
				numLi.click(function(){
					to_page(item);
				});
				ul.append(numLi);
			});
			//添加下一页和末页 的提示
			ul.append(nextPageLi).append(lastPageLi);
			
			//把ul加入到nav
			var navEle = $("<nav></nav>").append(ul);
			navEle.appendTo("#page_nav_area");
		}
		
		//单个删除
		$(document).on("click",".delete_btn",function(){
			//1、弹出是否确认删除对话框
			var menuName = $(this).parents("tr").find("td:eq(3)").text();
			var menuId = $(this).attr("del-id");
			layer.confirm('确认要删除"'+menuName+'"吗？',function(index){
					//确认，发送ajax请求删除即可
					$.ajax({
						url:"${APP_PATH}/deletemerchan/"+menuId,
						type:"DELETE",
						success:function(result){
							var res = result.code;
							if (res == 100) {
								to_page(1);
								layer.msg(result.extend.msg,{icon:1,time:2000});
							}else{
								layer.msg(result.extend.msg,{icon:1,time:2000});
							}
						}
					});
				})
		});
		
/*渠道商品-增加*/
function merchandise_add(title,url,w,h){
	layer_show(title,url,w,h);
}


/*渠道商品-编辑*/
function merchandise_edit(title,url,id,w,h){
	layer_show(title,url,w,h,id);

}


$("#selectContext").change(function(){
	var s = $(this).val();
	if (s == 1) {
		$("#channelMerchandise").css("display","block")
		$("#merchandise").css("display","none");
	}else{
		
		
		$("#merchandise").css("display","block");
		$("#channelMerchandise").css("display","none")
	}
	
})
$("#selectMerchandiseByName").click(function(){
	
	to_page(1);
	
});
$("#selectMerchandiseByChannelMerName").click(function(){
	
	to_page(1);
	
});




		
</script>
</body>
</html>