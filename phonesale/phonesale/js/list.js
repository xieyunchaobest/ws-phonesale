function isValueNull(value)
{
	if (null == value || -1 != value.search("^\\s{0,}$"))
	{
		return true;
	}
	return false;
}

function isNumber(obj)
{
	return isValueNumber(obj.value);
}

function isDate(obj)
{
	return isValueDate(obj.value);
}

function isDateWithHMS(obj)
{
	return isValueDateWithHMS(obj.value);	
}

function isValueNumber(value)
{
	if (null == value || -1 == value.search("^\\d{1,}\\.{0,1}\\d{0,}$"))
	{
		return false;		
	}
	
	return true;
}

function isValueIntNumber(value)
{
	if (null == value || -1 == value.search("^\\d{1,}$"))
	{
		return false;		
	}
	
	return true;
}


function isValueDate(value)
{
	if (null == value)
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-12'����'20070801'��ʽ.");
		return false;
	}

	if (value.match("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
	{
		var dates = value.split("-");
		var newDate = new Date(dates[0], dates[1] - 1, dates[2]);
		
		if (dates[0] != newDate.getFullYear() || dates[1] != (newDate.getMonth() + 1) || dates[2] != newDate.getDate())
		{
			alert(value + "���ڴ���.ӦΪ'2007-08-12'����'20070801'��ʽ.");
			return false;
		}
		return true;	
	}	
	else if (value.match("^\\d{8}$"))
	{
		var year = value.substr(0, 4);
		var month = value.substr(4, 2);	
		var day = value.substr(6, 2);
	    newDate = new Date(year, month - 1, day);
		
		if (year != newDate.getFullYear() || month != (newDate.getMonth() + 1) || day != newDate.getDate())
		{
			alert(value + "���ڴ���.ӦΪ'2007-08-12'����'20070801'��ʽ.");
			return false;
		}
		return true;	
	}
	else
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-12'����'20070801'��ʽ.");
		return false;
	}
}

function isValueDateWithHMS(value)
{
	if (null == value)
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-01 08:02:03'��ʽ.");
		return false;
	}

	if (value.match("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$"))
	{
		var times = value.split(" ");
		dates = times[0].split("-");
	    newDate = new Date(dates[0], dates[1] - 1, dates[2]);
		
		if (dates[0] != newDate.getFullYear() || dates[1] != (newDate.getMonth() + 1) || dates[2] != newDate.getDate())
		{
			alert(value + "���ڴ���.");
			return false;
		}
		
		var hours = times[1].split(":");
		if (parseFloat(hours[0]) > 23 || parseFloat(hours[0]) < 0 
			|| parseFloat(hours[1]) > 59 || parseFloat(hours[1]) < 0   
			|| parseFloat(hours[2]) > 59 || parseFloat(hours[2]) < 0)
		{
			alert(value + "���ڴ���.");
			return false;
		}
		
		return true;	
	}
	else
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-01 08:02:03'��ʽ.");
		return false;
	}
}

function isNumberOrEmpty(value)
{
	if (null == value || -1 != value.search("^\\s{0,}$"))	
	{
		return true;
	}
	
	return isValueNumber(value);
}	

function isDateOrEmpty(value)
{
	if (null == value || -1 != value.search("^\\s{0,}$"))	
	{
		return true;
	}
	
	return isValueDate(value);
}

function isDateWithHMSOrEmpty(value)
{
	if (null == value || -1 != value.search("^\\s{0,}$"))	
	{
		return true;
	}
	
	return isValueDateWithHMS(value);
}

function selectChecked(obj)
{
	if(obj == null)
	{
		return false;
	}

	if(isNaN(obj.length))
	{
		if(obj.checked) return true;
	} 
	else 
	{
		var iLen = obj.length;
		for(var i = 0; i < iLen; i++)
		{
			if(obj[i].checked)
			{
				return true;
			}
		}
	}
	
	return false;
}

function selectCheckbox(obj)
{
	var value = obj.value;
	if ("0" == value)
	{
		return false;
	}
	
	return true;
}

function onAddRowHead()
{
   var rList = new Array();	
   for(var i = 0, n = form1.select_column.options.length; i< n; i++)
   {
        if(form1.select_column.options[i].selected)
		{
            var optionName = form1.select_column.options[i].text;
            var optionValue = form1.select_column.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.select_column.options[i].necessary;
            form1.select_rowhead.add(newoption);
			rList.push(optionValue);	
		}
   }	

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.select_column.options.length; j < m; j++)
		{
			if (rList[i] == form1.select_column.options[j].value)
			{
				form1.select_column.options.remove(j);	
				break;
			}
		}
   }
}

function onDelRowHead()
{
    var rList = new Array();
    for(var i = 0, n = form1.select_rowhead.options.length; i < n; i++)
	{
        if(true == form1.select_rowhead.options[i].selected)
		{
            var optionName = form1.select_rowhead.options[i].text;
            var optionValue = form1.select_rowhead.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.select_rowhead.options[i].necessary;
            form1.select_column.add(newoption);
            rList.push(optionValue);
        }
    }

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.select_rowhead.options.length; j < m; j++)
		{
			if (rList[i] == form1.select_rowhead.options[j].value)
			{
				form1.select_rowhead.options.remove(j);	
				break;
			}
		}
   }
}

function onAddColHead()
{
   var rList = new Array();
   for(var i = 0, n = form1.select_column.options.length; i< n; i++)
   {
        if(true == form1.select_column.options[i].selected)
		{
            var optionName = form1.select_column.options[i].text;
            var optionValue = form1.select_column.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.select_column.options[i].necessary;
            form1.select_colhead.add(newoption);
			rList.push(optionValue);
		}
   }	

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.select_column.options.length; j < m; j++)
		{
			if (rList[i] == form1.select_column.options[j].value)
			{
				form1.select_column.options.remove(j);	
				break;
			}
		}
   }
}

function onDelColHead()
{
	var rList = new Array();
    for(var i = 0, n = form1.select_colhead.options.length; i < n; i++)
	{
        if(true == form1.select_colhead.options[i].selected)
		{
            var optionName = form1.select_colhead.options[i].text;
            var optionValue = form1.select_colhead.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.select_colhead.options[i].necessary;
            form1.select_column.add(newoption);
            rList.push(optionValue);
        }
    }

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.select_colhead.options.length; j < m; j++)
		{
			if (rList[i] == form1.select_colhead.options[j].value)
			{
				form1.select_colhead.options.remove(j);	
				break;
			}
		}
   }
}

function onAddStatCol()
{
   var rList = new Array();
   for(var i = 0, n = form1.select_statcolumn.options.length; i< n; i++)
   {
        if(form1.select_statcolumn.options[i].selected == true)
		{
            var optionName = form1.select_statcolumn.options[i].text;
            var optionValue = form1.select_statcolumn.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.select_statcolumn.options[i].necessary;
			form1.show_column.add(newoption);
			rList.push(optionValue);
		}
   }	

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.select_statcolumn.options.length; j < m; j++)
		{
			if (rList[i] == form1.select_statcolumn.options[j].value)
			{
				form1.select_statcolumn.options.remove(j);	
				break;
			}
		}
   }

}

function onDelStatCol()
{
   var rList = new Array();			
   for(var i = 0, n = form1.show_column.options.length; i< n; i++)
   {
        if(form1.show_column.options[i].selected == true)
		{
            var optionName = form1.show_column.options[i].text;
            var optionValue = form1.show_column.options[i].value;
			var newoption = new Option(optionName,optionValue);
			newoption.necessary = form1.show_column.options[i].necessary;
            form1.select_statcolumn.add(newoption);
			rList.push(optionValue);
		}
   }	

   for (var i = 0, n = rList.length; i < n; i++)
   {
		for (var j = 0, m = form1.show_column.options.length; j < m; j++)
		{
			if (rList[i] == form1.show_column.options[j].value)
			{
				form1.show_column.options.remove(j);	
				break;
			}
		}
   }
}

function headCheck()
{
	for(var i = 0; i < form1.select_rowhead.length; i++)
	{
		var rowhead = form1.select_rowhead.options[i].value;
		var oRowHead = document.all.item(rowhead);
		if (null != oRowHead)
		{
			var type = new String(oRowHead.type);	
			if ("text" == type || "hidden" == type || "textarea" == type)
			{
				var value = oRowHead.value;
				if (-1 != value.search("^\\s{0,}$"))
				{
					alert(oRowHead.chinese + "�Ѿ�ѡ���б�ͷ,����д���ֵ.");		
					return false;
				}					
			}
			else if ("undefined" == type)
			{
				if (!selectChecked(oRowHead))
				{
					alert(oRowHead[0].chinesename + "�Ѿ�ѡ���б�ͷ,��ѡ�����ֵ.");
					return false;
				}
			}
		}
	}

	for(var i = 0; i < form1.select_colhead.length; i++)
	{
		var colhead = form1.select_colhead.options[i].value;
		var oColHead = document.all.item(colhead);
		if (null != oColHead)
		{
			var type = new String(oColHead.type);	
			if ("text" == type || "hidden" == type || "textarea" == type)
			{
				var value = oColHead.value;
				if (-1 != value.search("^\\s{0,}$"))
				{
					alert(oColHead.chinese + "�Ѿ�ѡ���б�ͷ,����д���ֵ.");		
					return false;
				}					
			}
			else if ("undefined" == type)
			{
				if (!selectChecked(oColHead))
				{
					alert(oColHead[0].chinesename + "�Ѿ�ѡ���б�ͷ,��ѡ�����ֵ.");
					return false;
				}
			}
		}
	}

	return true;
}

function checkListHead()
{
	for(var i = 0; i < form1.select_column.length; i++)
	{
		var isNecessary = form1.select_column.options[i].necessary;
		if (isNecessary == 'true')
		{
			alert( form1.select_column.options[i].text + "Ϊ��ѡ����ͷ,��ѡ��.");
			return false;
		}
	}

	return true;
}

function checkStatcolumn()
{
	for(var i = 0; i < form1.select_statcolumn.length; i++)
	{
		var isNecessary = form1.select_statcolumn.options[i].necessary;
		if (isNecessary == 'true')
		{
			alert( form1.select_statcolumn.options[i].text + "Ϊ��ѡͳ��ָ��,��ѡ��.");
			return false;
		}
	}

	return true;
}

function checkSumusable()
{
	if (form1.select_rowhead.length == 0 && (form1.show_sum_flag.checked || form1.show_total_flag.checked))
	{
		alert("�б�ͷδѡ��,��ֹѡ��С�ƻ��ܼ�.");
		return false;
	}
	return true;
}

function getParent(spanName)
{
	var objSpan = document.all.item( 'span' + spanName);

	parentnames += objSpan.name + ';';	
	types += objSpan.htmltype + ';';		
	values += getValue(objSpan.name, objSpan.htmltype) + ';';
 
	if ('' == objSpan.parentname)
	{ 
		return;
	}
	else
	{ 
		getParent(objSpan.parentname); 				
	} 
	return;
}

function getValue(itemName, htmlType)
{
	var value = '';
	if (2 == htmlType || 3 == htmlType)
	{
		var objItems = document.all.item(itemName);
		if (null == objItems)
		{
			return value;
		}

		if (objItems.length)
		{
			for (var i = 0, n = objItems.length; i < n; i++)
			{
				if (objItems[i].checked && !objItems[i].disabled)
				{
					value += objItems[i].value + ':';
				}
			}
		}
		else
		{
				if (objItems.checked && !objItems.disabled)
				{
					value += objItems.value + ':';
				}
		}
		return value;
	}
	else if (9 == htmlType)
	{
		var objItems = document.all.item(itemName);
		if (null == objItems)
		{
			return value;
		}

		if (objItems.length)
		{
			for (var i = 0, n = objItems.length; i < n; i++)
			{
				if (objItems[i].selected)
				{
					if ('' != value)
					{
						value += ':' + objItems[i].value;
					}
					else
					{
						value += objItems[i].value;
					}
				}
			}
		}
		else
		{
				if (objItems.selected)
				{
					value = objItems.value;
				}
		}
		return value;		
	}
	else
	{	
		return document.all.item(itemName).value; 					
	}
}

var parentnames = ''; 
var values = ''; 
var types = '';

var request;

function submitQuery()
{
	//alert(form1.change.value);
	var check = verifyData(); 
	if (!check)
	{
		return;
	}	
	
	document.all("busy").style.display=""; 
	document.all("busy1").style.display=""; 
	document.all("show").innerHTML="��ѯ������......";
	document.all("show1").innerHTML="��ѯ������......";
	
	var pageNum = form2.pagenum.value;
	var pageAmount = form2.pageamount.value; 
	var mainurl = "../DetailListServlet/main";
	var url = "pagenum=" + pageNum + "&pageamount=" + pageAmount + "&command=query";

	//alert(document.forms.length);
	var objs = popmenu.elements;
	var showcols = "";
	for (var i = 0, n = objs.length; i < n; i++)
	{
		var obj = objs[i];
		var objType = obj.type;
		if ("checkbox" == objType)
		{
			if (obj.checked)
			{
				showcols += obj.id + ":";
			}
		}
	}
	url += "&showcol=" + showcols;  
    if (!document.getElementById("form1"))
	{
		  url += form2.url.value;
	}else {
	objs = form1.elements;
	for (var i = 0, n = objs.length; i < n; i++)
	{
		var obj = objs[i];
		var objType = obj.type;
		var value = obj.value;
		if (!isValueNull(value))
		{
			if ("checkbox" == objType || "radio" == objType)
			{
				if (obj.checked)
				{
					url += "&" + obj.name + "=" + value;
				}
			}
			else if ("hidden" == objType || "text" == objType || "textarea" == objType || "select-one" == objType)
			{
				url += "&" + obj.name + "=" + value;
			}
			else if ("select-multiple" == objType)
			{				
				for (var j = 0, m = obj.options.length; j < m; j++)
				{
					var op = obj.options[j];
					if (op.selected)
					{
						url += "&" + obj.name + "=" + op.value;
					}
				}
			}
		}
	}  	
	} 
	 url +="&urlPart="+form2.url.value.replace(new RegExp("&","gm"),"%26");
	 
	postData(mainurl, url);
}

function postData(mainurl, url)
{
	request=false;
	if(window.HttpResponse)
	{
		request=new XMLHttpResponse();
	}
	else
	{
		if(window.ActiveXObject)
		{
			try
			{
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch(e)
			{
				try
				{
					request=new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e)
				{
				}
			}
		}
	}	
	
	if (!request)
	{
		alert("������IE");
		return;
	}
	if (document.getElementById("form1"))
	{
	  form1.submitform.disabled = true;
	  form1.reset.disabled = true;
	  form1.closeme.disabled = true;
	}	
	form2.prepage.disabled = true;
	form2.nextpage.disabled = true;
	form2.gotopage.disabled = true;
	form2.excel.disabled = true;
	form2.prepage1.disabled = true;
	form2.nextpage1.disabled = true;
	form2.gotopage1.disabled = true;
	form2.excel1.disabled = true;
	request.onreadystatechange = reflash;
	request.open("POST",mainurl,true);
	request.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
	request.send(url);
	hiddenCondition();
}

function reflash()
{
	if(request.readystate==4)
	{
		if(request.status==200)
		{
			var info = request.responseText;
			if (isValueNull(info))
			{
				alert("����ѯ�������Ѿ�������������ѯ������,��������С��ѯ���ݷ�Χ.");
			}
			else
			{
				document.all("main").innerHTML = request.responseText;			
			}
			
			try
			{
				form1.change.value = '0';
				form1.submitform.disabled = false;
				form1.reset.disabled = false;
				form1.closeme.disabled = false;
				form2.prepage.disabled = false;
				form2.nextpage.disabled = false;
				form2.gotopage.disabled = false;
				form2.excel.disabled = false;	
				form2.prepage1.disabled = false;
				form2.nextpage1.disabled = false;
				form2.gotopage1.disabled = false;
				form2.excel1.disabled = false;	
			}
			catch (e)
			{
			}
			
			document.all("busy").style.display="none"; 
			document.all("busy1").style.display="none"; 
			document.all("show").innerHTML="";
			document.all("show1").innerHTML="";		
		}
		else 
		{
			alert("���ݴ������.");
			document.all("show").innerHTML="";
		}
	}
	
	return;	
}

function gotoPrePage()
{
	var currentPage = parseFloat(form2.pagenum.value);
	var pageamount = parseFloat(form2.pageamount.value);
	if (1 == currentPage || 0 == currentPage)
	{
		alert("��ǰΪ��ҳ.");
		return;
	}
	form2.pagenum.value = currentPage - 1;
	if (document.getElementById("form1"))
	{	 
		form1.command.value='query';
	}
	 
	submitQuery();
}

function gotoNextPage()
{ 
	var currentPage = parseFloat(form2.pagenum.value);
	var pageamount = parseFloat(form2.pageamount.value);
 
	if (currentPage >= pageamount)
	{
		alert("��ǰΪ���ҳ.");
		return;
	}

	form2.pagenum.value = currentPage + 1;	
	if (document.getElementById("form1"))
	{	 
	 form1.command.value='query';
	}
	submitQuery();
}

function gotoPage(gotoPageNum)
{  
	var currentPage = parseFloat (form2.pagenum.value);
	var pageamount = parseFloat (form2.pageamount.value);

	if (!isValueIntNumber(gotoPageNum))
	{
		alert("ָ��ҳ��ӦΪ��ֵ.");
		return;
	}
	
	gotoPageNum = parseFloat(gotoPageNum);
 
	if (gotoPageNum == currentPage)
	{
		return;
	}
	
	if (0 == gotoPageNum || gotoPageNum  > pageamount)
	{
		alert("ָ��ҳ������Χ.");
		return;
	}
	form2.pagenum.value =  gotoPageNum; 
	if (document.getElementById("form1"))
	{ 
	  form1.command.value='query';
	} 
	submitQuery();
}

function createExcel()
{
	var check = verifyData();
	if (!check)
	{
		return;
	}
	if (document.getElementById("form1")){
	   if (1 == form1.change.value && !confirm("��ǰ��ѯ�����Ѿ������޸�,����Excel���Ե�ǰ��ѯ�������²�ѯ����Excel.\n�����ǵ�ǰ���ɽ��.�Ƿ����?"))
	   {
	 	 return;
	   }
	  	form1.command.value = "excel";	
	}else {
		form2.command.value = "excel";
	} 
	/*var url = "../DetailListServlet/main?pagenum=-1";
	var objs = form1.elements;
	for (var i = 0, n = objs.length; i < n; i++)
	{
		var obj = objs[i];
		var objType = obj.type;
		var value = obj.value;
		if (!isValueNull(value))
		{
			if ("checkbox" == objType || "radio" == objType)
			{
				if (obj.checked)
				{
					url += "&" + obj.name + "=" + value;
				}
			}
			else if ("hidden" == objType || "text" == objType || "textarea" == objType || "select-one" == objType)
			{
				url += "&" + obj.name + "=" + value;
			}
			else if ("select-multiple" == objType)
			{				
				for (var j = 0, m = obj.options.length; j < m; j++)
				{
					var op = obj.options[j];
					if (op.selected)
					{
						url += "&" + obj.name + "=" + op.value;
					}
				}
			}
		}
	}  		
	window.open(url);*/
	var objs = popmenu.elements;
	var showcols = "";
	for (var i = 0, n = objs.length; i < n; i++)
	{
		var obj = objs[i];
		var objType = obj.type;
		if ("checkbox" == objType)
		{
			if (obj.checked)
			{
				showcols += obj.id + ":";
			}
		}
	}
	if (document.getElementById("form1")){
	 	form1.showcol.value = showcols;
	 	form1.submit();	
	}else {
		form2.showcol.value = showcols;
		form2.submit();	
	}
}

function changeCondtion()
{
	form1.change.value=1;
	return;
}

function switchBar()
{
		if (document.getElementById("menu").innerText==555)
		{
				document.getElementById("menu").innerText=666;
				document.getElementById("queryForm").style.display="none";
				document.getElementById("main").style.height="100%";
		}
		else
		{
				document.getElementById("menu").innerText=555;
				document.getElementById("queryForm").style.display="";
				document.getElementById("main").style.height="95%";
		}
}

function hiddenCondition()
{
	if(document.getElementById("menu") != null){
		document.getElementById("menu").innerText=666;
	}
    if(document.getElementById("queryForm") != null){
    	document.getElementById("queryForm").style.display="none";
    }

	if(document.getElementById("main") != null){
		document.getElementById("main").style.height="100%";	
	}

}

function sendRequest(url, innerHTMLObj)
{
	var request = false;
	if(window.HttpResponse)
	{
		request=new XMLHttpResponse();
	}
	else
	{
		if(window.ActiveXObject)
		{
			try
			{
				request=new ActiveXObject("Msxml2.XMLHTTP");
			}
			catch(e)
			{
				try
				{
					request=new ActiveXObject("Microsoft.XMLHTTP");
				}
				catch(e)
				{
				}
			}
		}
	}	
	
	if (!request)
	{
		alert("������IE");
		return;
	}
	
	try
	{
		document.all("show").innerHTML = "��ѯά��������......";
	}
	catch(e)
	{
	}	

	request.open("POST", url, false);
	request.send();	
	document.all(innerHTMLObj).innerHTML = request.responseText;	

	try
	{
		document.all("show").innerHTML = "";
	}
	catch(e)
	{
	}
}

function cancelselect(obj)
{
	obj.options[obj.selectedIndex].selected = false;
	obj.fireEvent("onchange");	
}

function sort(column)
{	
	if (form1.sortcolumn.value == column && 'asc' == form1.sortrule.value)
	{
		form1.sortrule.value = 'desc';
	}
	else
	{
		form1.sortrule.value = 'asc';
	}
	form1.sortcolumn.value = column;
	form1.command.value = "query";
	submitQuery();
}

function document.onkeydown() 
{ 
	if (((event.keyCode == 8) && (event.srcElement.type != "text" && event.srcElement.type != "textarea" && event.srcElement.type != "password"))//�����˸�ɾ���� 
		|| (event.keyCode == 116) //���� F5 ˢ�¼�
		|| (event.ctrlKey && event.keyCode == 82) //Ctrl + R
		|| (event.ctrlKey && event.keyCode == 78) //Ctrl + N�� 
		|| (window.event.altKey)&&((window.event.keyCode==37)|| (window.event.keyCode==39))) //Alt + ����
	{
		alert("IE��ݼ��Ѿ�����,��ʹ��ϵͳ�ṩ�Ĺ��ܰ�ť.");
		event.keyCode=0;
		event.returnvalue=false;
        return false; 
	}
}

function pageSetup()
{
	try
	{
		var RegWsh = new ActiveXObject("WScript.Shell");
		var hkey_root="HKEY_CURRENT_USER\\Software\\Microsoft\\Internet Explorer\\PageSetup\\";
		RegWsh.RegWrite(hkey_root+"header","&b��ӡʱ��:&d &T");
		RegWsh.RegWrite(hkey_root+"footer","&b��&pҳ&b��&Pҳ");
	}
	catch(e)
	{
		alert("�뽫����ϵͳ���뵽�ܿ����ε�����.�����Զ�����ҳ��.");
	}
	
	try
	{
		document.getElementById("printspan").innerHTML = "<object  id='WebBrowser'  classid='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'  height='0'  width='0' viewastext></object>"; 
		document.all.WebBrowser.ExecWB(7,1);
	}
	catch(e)
	{
		alert("�Ѿ�����Excel,���������뱾�嵥���ɽ��д�ӡ����.");
	}
}

function getDate(value)
{
	if (null == value)
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-12'����'20070801'��ʽ.");
		return false;
	}

	if (value.match("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
	{
		var dates = value.split("-");
		var newDate = new Date(dates[0], dates[1] - 1, dates[2]);
		
		if (dates[0] != newDate.getFullYear()
			|| dates[1] != (newDate.getMonth() + 1)
			|| dates[2] != newDate.getDate())
		{
			alert(value + "���ڴ���.");
			return null;
		}
		return newDate;	
	}	
	else if (value.match("^\\d{8}$"))
	{
		var year = value.substr(0, 4);
		var month = value.substr(4, 2);	
		var day = value.substr(6, 2);
		var newDate = new Date(year, month - 1, day);
		
		if (year != newDate.getFullYear()
			|| month != (newDate.getMonth() + 1)
			|| day != newDate.getDate())
		{
			alert(value + "���ڴ���.");
			return null;
		}
		return newDate;	
	}
	else if (value.match("^\\d{4}-\\d{1,2}-\\d{1,2} \\d{1,2}:\\d{1,2}:\\d{1,2}$"))
	{
		var times = value.split(" ");
		dates = times[0].split("-");
	    var newDate = new Date(dates[0], dates[1] - 1, dates[2]);
		
		if (dates[0] != newDate.getFullYear() || dates[1] != (newDate.getMonth() + 1) || dates[2] != newDate.getDate())
		{
			return false;
		}
		
		var hours = times[1].split(":");
		if (parseFloat(hours[0]) > 23 || parseFloat(hours[0]) < 0 
			|| parseFloat(hours[1]) > 59 || parseFloat(hours[1]) < 0   
			|| parseFloat(hours[2]) > 59 || parseFloat(hours[2]) < 0)
		{
			return null;
		}
		
		return new Date(dates[0], dates[1] - 1, dates[2], hours[0], hours[1], hours[2]);	
	}
	else
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-12'����'20070801'��ʽ.");
		return null;
	}
}

function closeWindow()
{
	try
	{
		if (confirm("ȷ���˳��嵥?"))
		{
			document.getElementById("printspan").innerHTML = "<object  id='WebBrowser'  classid='CLSID:8856F961-340A-11D0-A96B-00C04FD705A2'  height='0'  width='0' viewastext></object>"; 
			document.all.WebBrowser.ExecWB(45,1);
		}
	}
	catch (e)
	{
		alert("��ʹ��IE�رհ�ť�˳�ϵͳ.");	
	}

	return;
}
function showSQMXA(objA)
{
	var num = objA.rownum;
	var actionURL = objA.actionurl; 
	var trName = "data" +num;
	var tr = document.getElementById(trName);
	var url = actionURL + "&localNetId=471&soNbr=" + document.getElementById("SO_NBR" + num).value;
	var h = screen.height - 60;
	var w = screen.width - 10;	
	window.open(url,'','height='+h+',width='+w+',left=0,top=0,toolbar=no,titlebar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes');
}
function showSQMX(objA)
{
	var num = objA.rownum;
	var actionURL = objA.actionurl; 
	var trName = "data" +num;
	var tr = document.getElementById(trName); 
	var localNetID = form1.local_net_id.value;
	if (isValueNull(localNetID))
	{
		alert("��ѡ�񱾵���.");
		return;
	}
	
	var url = actionURL + "&localNetId=" + localNetID + "&soNbr="
		+ "&userName=" + loginfo.sysuser.value  
		+ "&password=" + loginfo.password.value;

	var url = actionURL + "&localNetId=" + localNetID 
		+ "&soNbr=" + document.getElementById("so_nbr" + num).value
		+ "&userName=" + loginfo.sysuser.value  
		+ "&password=" + loginfo.password.value;
	var h = screen.height - 60;
	var w = screen.width - 10;	
	window.open(url,'','height='+h+',width='+w+',left=0,top=0,toolbar=no,titlebar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes');
}

var X;
function dataScroll()
{
	if(event.button==2) 
	{
		document.getElementById("listdatadiv").scrollLeft = document.getElementById("listdatadiv").scrollLeft + event.clientX -X ;
	}
}

function locationMark()
{
	if(event.button==2) 
	{
		X = event.clientX;
	}
}

var pop;
function initMenu()
{
	pop = window.createPopup();  
	pop.document.body.innerHTML=document.getElementById("itemMenu").innerHTML;
}

function divshow(obj)
{
	if (!obj.checked)
	{
		document.getElementById(obj.id).checked = false;
		if (isLast())
		{
			document.getElementById(obj.id).checked = true;
			/*alert("���붨��һ����ʾ��.");
			return;	*/	
		}
	}
	else
	{
		document.getElementById(obj.id).checked = obj.checked;
	}

	var trs = document.getElementById("datatable").childNodes[0].rows;
	for (var i = 0; i < trs.length; i++)
	{
		var tr = trs[i];
		for (var j = 0; j < tr.childNodes.length; j++)
		{
			var td = tr.childNodes[j];
			if (td.columnname == obj.id)
			{
				if (obj.checked)
				{
					td.className = td.showclass;
					if (0 == i && isValueNumber(td.width))
					{
						document.getElementById("datatable").width = parseFloat(document.getElementById("datatable").width) + parseFloat(td.width);
					}
				}
				else
				{
					td.className = td.hiddenclass;
					if (0 == i && isValueNumber(td.width))
					{
						document.getElementById("datatable").width = parseFloat(document.getElementById("datatable").width) - parseFloat(td.width);
					}
				}
			}	
		}
	} 
}

function isLast()
{
	var has = true;
	var objs = popmenu.elements;
	for (var i = 0, n = objs.length; i < n; i++)
	{
		var obj = objs[i];
		var objType = obj.type;
		if ("checkbox" == objType)
		{
			if (obj.checked)
			{
				has = false;
				break;
			}
		}
	}
	return has;
}


function showMenu()
{
    pop.document.oncontextmenu=function()
    {
            return false;
    }
	var rownum = document.getElementById("datatable").childNodes[0].childNodes[0].childNodes.length;
    pop.show(event.clientX-1,event.clientY, 150, rownum*25,document.body);
    event.returnValue=false;
    event.cancelBubble=true;

    return false;
}
function search(selectName, contentName, srcName)
{ 
	var sel = document.all.item(selectName);
	var condtion = document.all.item(contentName).value;
	var src = document.all.item(srcName);
	var selectedArray = new Array();
	var sSize = 0;	
	
	while (sel.options.length > 0)
	{
		if (sel.options[0].selected)
		{
			selectedArray[sSize++] = sel.options[0];  
		}
		sel.options.remove(0);
	}		
	
	if("" == condtion.replace(/^\s+|\s+$/, ""))
	{
		for (var i = 0, n = src.options.length; i < n; i++)
		{
			var op = document.createElement('option');
			op.value = src.options[i].value;
			op.text = src.options[i].text;
			sel.options.add(op);	
			for (var j = 0, m = selectedArray.length; j < m; j++)
			{
				var sOp = selectedArray[j];
				if (op.value == sOp.value)
				{
					sel.options[i].selected = true;		
					break;
				}
			}
		}
	} 
	else
	{
		for (var i = 0, n = selectedArray.length; i < n; i++)
		{
			sel.options.add(selectedArray[i]);
		}
		
		for (var i = 0, n = src.options.length; i < n; i++)
		{
			var op = src.options[i];
			var opText = op.text;
			if (-1 != opText.indexOf(condtion))
			{
				var f = false;
				for (var j = 0, m = selectedArray.length; j < m; j++)
				{
					var sOp = selectedArray[j];
					if (sOp.value == op.value)
					{
						f = true;
						break;
					}
				}
				if (!f)
				{
					var opt = document.createElement('option');
					opt.value = op.value;
					opt.text = opText;
					sel.options.add(opt);				
				}
			}	
		}
	}
		
	return;
}

function selectAll(selectName)
{
	var sel = document.all.item(selectName);
	if(document.getElementById("selectAllOptions")!=null){
	document.getElementById("selectAllOptions").value="1";
	
}
	for (var i = 0, n = sel.options.length; i < n; i++)
	{
		sel.options[i].selected = true;	
	}
	
	eval("on" + selectName + "change()");
}

function invertedChoose(selectName)
{
	var sel = document.all.item(selectName);
	for (var i = 0, n = sel.options.length; i < n; i++)
	{
		if (true == sel.options[i].selected)
		{
			sel.options[i].selected = false;
		}
		else
		{
			sel.options[i].selected = true;
		}
			
	}
	
	eval("on" + selectName + "change()");
}

function cancelAll(selectName)
{
	var sel = document.all.item(selectName);
	for (var i = 0, n = sel.options.length; i < n; i++)
	{
		sel.options[i].selected = false;	
	}
	
	eval("on" + selectName + "change()");
}

function checkHistory(obj)
{
	if (true == obj.checked && !confirm("��ѯ��ʷ������,ϵͳ��Ӧ�ٶȽ��Ȳ�ѯ��ǰ��ϵͳ��Ӧʱ�䳤.\n�Ƿ�ȷ�ϱ��β�ѯ������ʷ������?"))
	{
		obj.checked = false;	
	}
}

var subWindow;
function createWindow(url,listcode)
{
    var url1 = '../DetailListServlet/main?command=listresult&listcode='+listcode+'&change=1&'+url;
	var h = screen.height - 60;
	var w = screen.width - 10;		
	var status = "height="+h+",width="+w+",left=0,top=0,toolbar=no,titlebar=no,location=no,directories=no,status=no,menubar=no,scrollbars=yes,resizable=yes";			
	if (null != subWindow && !subWindow.closed)
	{
		if (confirm("�Ѵ򿪴���չ���嵥,�Ƿ������µ�����?"))
		{
			subWindow.close();
			subWindow = window.open(url1,"",status);			
		}	
	}
	else
	{
		subWindow = window.open(url1,"",status);		
	}
	return;
}
 

