<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<base href="<%=basePath%>">

<title>选题组卷</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">    
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<script type="text/javascript" src="js/jQuery.js"></script>
<style type="text/css">
tr {
	margin: 10px;
}

td {
	margin: 10px;
}
</style>
<script type="text/javascript">
function getCourses(){
	var url = "${basePath}course_getCourses2Json.action";
	var majorValue = $("#majorSelect").val();
	var stageValue = $("#stageSelect").val();
	$.getJSON(url,
		{
			'course.major':majorValue,
			'course.stage':stageValue
		},
		function(data){
			$("#csId").empty();
			$("#csId").append("<option value=''>请选择</option>");
			$.each(data,function(i,course){
				$("#csId").append("<option value='"+course.csId+"'>"+course.csName+"</option>");
			});
		}
	);
}

//TODO 更新总题数和每题分数
function getQuestionTotal(i){
	var ptotalScore = Number($("#ptotalScore").val());
	if(typeof(radioEasyMax) == "undefined"){
		alert("请选择科目");
		return;
	}
	//总分数
	if(ptotalScore == 0){
		alert("请填写分数");
		return;
	}
}
</script>
</head>
  
  <body>
    <div>
    	<form action="" method="post">
    		<input type="hidden" id="qids" name="qids">
    		<input type="hidden" name="paper.ptype" value="笔试">
    		<input type="hidden" name="paper.pstate" value="未开考">
    		<table align="center">
    			<tr>
    				<td style="text-align: right;">方向:</td>
    				<td colspan="3">
    					<s:select id="majorSelect" list="#{'':'请选择','SCME':'SCME','SCCE':'SCCE' }"
    						name="majorSelect" onchange="getCourses()" theme="simple" />
    					阶段:
    					<s:select id="stageSelect" list="#{'':'请选择','G1':'G1','G2':'G2','G3':'G3' }"
    						name="stageSelect" onchange="getCourses()" theme="simple" />
    					科目：
    					<%-- <s:select list="{}" name="course.csId" id="csId" theme="simple" headerKey=""
    						headerValue="请选择" onchange="getQuestionMaxNum()" /> --%>
    					<select name="course.csId" id="csId" onchange="getQuestionMaxNum()">
							<option value="">请选择</option>
						</select>
    					<font color="red">*</font>
    				</td>
    			</tr>
    			<tr>
    				<td style="text-align: right;">标题: </td>
    				<td>
    					<input type="text" name="paper.pname" size="45">
    					<font color="red">*</font>
    				</td>
    			</tr>
    			<tr>
    				<td style="text-align: right;">总分: </td>
    				<td>
    					<input type="text" name="paper.ptotalScore">分
    					<font color="red">*</font>
    				</td>
    				<td style="text-align: right;">考试时长: </td>
    				<td>
    					<input type="text" name="paper.ptime">分钟
    					<font color="red">*</font>
    				</td>
    			</tr>
    			<tr>
    				<td style="text-align: right">已选题数：</td>
    				<td style="min-width: 250px;">
    					<input type="text" id="qtotal" name="paper.qtotal" readonly="readonly">
    				</td>
    				<td style="text-align: right;">每题分数: </td>
    				<td>
    					<input type="text" name="paper.qscore" readonly="readonly">
    				</td>
    			</tr>
    			<tr>
    				<td colspan="4">
    					<fieldset class="container" id="container">
    						
    					</fieldset>
    				</td>
    			</tr>
    			<tr>
    				<td style="text-align: center;" colspan="2">
    					<input type="submit" value="创建试卷">
    					<input type="reset" value="取消">
    				</td>
    			</tr>
    		</table>
    	</form>
    	
    </div>
  </body>
</html>
