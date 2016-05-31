/**
 * 
 */
function ajaxToGetReader() {
	url = "./BookResultServlet";
	var postParam = "type=" + "reader" + "&userName=" + document.getElementById("uid").value ;
	console.log(postParam);
	var ajax = false;
	//开始初始化XMLHttpRequest对象
	if (window.XMLHttpRequest) { //Mozilla 浏览器
		ajax = new XMLHttpRequest();
		if (ajax.overrideMimeType) { //设置MiME类别
			ajax.overrideMimeType("text/xml");
		}
	} 
	else if (window.ActiveXObject) { // IE浏览器
		try {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!ajax) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	//通过Post方式打开连接
	ajax.open("POST", url, true);
	//定义传输的文件HTTP头信息
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//发送POST数据
	ajax.send(postParam);
	//获取执行状态
	ajax.onreadystatechange = function() {
		//如果执行状态成功，那么就把返回信息写到指定的层里
		if (ajax.readyState == 4 && ajax.status == 200) {
			var jsonList = eval(ajax.responseText);
			console.log(jsonList);
			var div = document.getElementById("breakNewsList3");
		    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
		    {
		        div.removeChild(div.firstChild);
		    }
			for(var i = 0; i < jsonList.length; i++){
				var json = jsonList[i];
				var li = document.createElement("li");
				li.id = ("li-" + i);
				var str = addItem(jsonList[i].bookName);
				li.innerHTML = str;
				
				document.getElementById("breakNewsList3").appendChild(li);
			}
	 	}
	}
}

function ajaxToGetData() {
	url = "./BookResultServlet";
	var postParam = "type=" + "recommender" + "&userName=" + document.getElementById("uid").value ;
	var ajax = false;
	console.log(postParam);
	//开始初始化XMLHttpRequest对象
	if (window.XMLHttpRequest) { //Mozilla 浏览器
		ajax = new XMLHttpRequest();
		if (ajax.overrideMimeType) { //设置MiME类别
			ajax.overrideMimeType("text/xml");
		}
	} 
	else if (window.ActiveXObject) { // IE浏览器
		try {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!ajax) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	//通过Post方式打开连接
	ajax.open("POST", url, true);
	//定义传输的文件HTTP头信息
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//发送POST数据
	ajax.send(postParam);
	//获取执行状态
	ajax.onreadystatechange = function() {
		//如果执行状态成功，那么就把返回信息写到指定的层里
		if (ajax.readyState == 4 && ajax.status == 200) {
			var jsonList = eval(ajax.responseText); //Yolanda
			console.log(jsonList.length);
			var div = document.getElementById("breakNewsList4");
		    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
		    {
		        div.removeChild(div.firstChild);
		    }
			for(var i = 0; i < jsonList.length; i++){
				var json = jsonList[i];
				if(jsonList[i].type != 2) 
					continue;
				var li = document.createElement("li");
				li.id = ("li-" + i);
				var str = addItem(jsonList[i].recommendBook);
				li.innerHTML = str;
				
				document.getElementById("breakNewsList4").appendChild(li);
			}
	 	}
	}
}


function ajaxToGetUser() {
	url = "./BookResultServlet";
	var postParam = "type=user";
	console.log(postParam);
	var ajax = false;
	//开始初始化XMLHttpRequest对象
	if (window.XMLHttpRequest) { //Mozilla 浏览器
		ajax = new XMLHttpRequest();
		if (ajax.overrideMimeType) { //设置MiME类别
			ajax.overrideMimeType("text/xml");
		}
	} 
	else if (window.ActiveXObject) { // IE浏览器
		try {
			ajax = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				ajax = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
	if (!ajax) { // 异常，创建对象实例失败
		window.alert("不能创建XMLHttpRequest对象实例.");
		return false;
	}
	//通过Post方式打开连接
	ajax.open("POST", url, true);
	//定义传输的文件HTTP头信息
	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	//发送POST数据
	ajax.send(postParam);
	//获取执行状态
	ajax.onreadystatechange = function() {
		//如果执行状态成功，那么就把返回信息写到指定的层里
		if (ajax.readyState == 4 && ajax.status == 200) {
			var jsonList = eval(ajax.responseText);
			console.log(jsonList);
			var div = document.getElementById("breakNewsList1");
		    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
		    {
		        div.removeChild(div.firstChild);
		    }
			for(var i = 0; i < jsonList.length; i++){
				var json = jsonList[i];
				var li = document.createElement("li");
				li.id = ("li-" + i);
				var str = addItem(jsonList[i].userName);
				li.innerHTML = str;
				
				document.getElementById("breakNewsList1").appendChild(li);
			}
	 	}
	}
}

//function ajaxToGetBook() {
//	url = "./BookResultServlet";
//	var postParam = "type=book";
//	console.log(postParam);
//	var ajax = false;
//	//开始初始化XMLHttpRequest对象
//	if (window.XMLHttpRequest) { //Mozilla 浏览器
//		ajax = new XMLHttpRequest();
//		if (ajax.overrideMimeType) { //设置MiME类别
//			ajax.overrideMimeType("text/xml");
//		}
//	} 
//	else if (window.ActiveXObject) { // IE浏览器
//		try {
//			ajax = new ActiveXObject("Msxml2.XMLHTTP");
//		} catch (e) {
//			try {
//				ajax = new ActiveXObject("Microsoft.XMLHTTP");
//			} catch (e) {
//			}
//		}
//	}
//	if (!ajax) { // 异常，创建对象实例失败
//		window.alert("不能创建XMLHttpRequest对象实例.");
//		return false;
//	}
//	//通过Post方式打开连接
//	ajax.open("POST", url, true);
//	//定义传输的文件HTTP头信息
//	ajax.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
//	//发送POST数据
//	ajax.send(postParam);
//	//获取执行状态
//	ajax.onreadystatechange = function() {
//		//如果执行状态成功，那么就把返回信息写到指定的层里
//		if (ajax.readyState == 4 && ajax.status == 200) {
//			var jsonList = eval(ajax.responseText);
//			console.log(jsonList);
//			
//			var div = document.getElementById("breakNewsList2");
//		    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
//		    {
//		        div.removeChild(div.firstChild);
//		    }
//			
//			for(var i = 0; i < jsonList.length; i++){
//				var json = jsonList[i];
//				var li = document.createElement("li");
//				li.id = ("li-" + i);
//				var str = addItem(jsonList[i].bookName);
//				li.innerHTML = str;
//				
//				document.getElementById("breakNewsList2").appendChild(li);
//			}
//	 	}
//	}
//}


//js中的格式化字符串
String.prototype.StringFormat = function() {
	if (arguments.length == 0) {
		return this;
	}
	for (var StringFormat_s = this, StringFormat_i = 0; StringFormat_i < arguments.length; StringFormat_i++) {
		StringFormat_s = StringFormat_s.replace(new RegExp("\\{"
				+ StringFormat_i + "\\}", "g"), arguments[StringFormat_i]);
	}
	return StringFormat_s;
};

/*
 * 动态添加标签
 * */
function addItem(name) {
	
	var str = "";
	str += "<li><a href=\"#\" target=\"_blank\">{0}</a></li>".StringFormat(name);
	return str;
}

/*
 * 删除以allResume为id的div的后代标签
 * */
function removeAllChild(divName)
{
	console.log(divName);
    var div = document.getElementById(divName);
    while(div.hasChildNodes()) //当div下还存在子节点时 循环继续
    {
        div.removeChild(div.firstChild);
    }
}