function isNumber()
{
	return isValueNumber(event.srcElement.value);
}

function isDate()
{
	return isValueDate(event.srcElement.value);
}

function isValueNumber(value)
{
	if (null == value || -1 == value.search("^\\d{1,}\\.{0,1}\\d{0,}$"))
	{
		return false;		
	}
	
	return true;
}

function isValueDate(value)
{
	if (null == value || !value.match("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
	{
		alert("���ڸ�ʽ����.ӦΪ'2007-08-12'��ʽ.");
		return false;
	}	
	
	var dates = value.split("-");
	var newDate = new Date(date[0], date[1], date[2]);
	
	if (date[0] != newDate.getYear() || date[1] != (newDate.getMonth() + 1) || date[2] != newDate.getDate())
	{
		alert("���ڴ���.");
		return false;
	}

	return true;	
}

function isNumberOrEmpty(value)
{
	if (null == value || -1 != value.search("^\\s{1,}$"))	
	{
		return true;
	}
	
	return isValueNumber(value);
}	

function isDateOrEmpty(value)
{
	if (null == value || -1 != value.search("^\\s{1,}$"))	
	{
		return true;
	}
	
	return isValueDate(value);
}

function selectChecked(obj)
{
	if(null == obj)
	{
		return false;
	}
	if(isNaN(obj.length))
	{
		if(obj.checked) 
		{
			return true;
		}
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
            form1.select_rowhead.add(new Option(optionName,optionValue));
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
            form1.select_column.add(new Option(optionName,optionValue));
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
            form1.select_colhead.add(new Option(optionName,optionValue));
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
            form1.select_column.add(new Option(optionName,optionValue));
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
            form1.show_column.add(new Option(optionName,optionValue));
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
            form1.select_statcolumn.add(new Option(optionName,optionValue));
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
function valiConWid(DateConWidName,objConWidName,dateCount){
   var sign = '0' ;
   var reSign = false;
   var count = '0';
   for (var i = 0; i < objConWidName.length; i++){
	   var mod = objConWidName[i].split("/");
	   // ����(��270��)�����޸�ֻӰ�쵽�����̸�Ԥ���еļ򵥲�ѯ
	   // ����ڲ����š��������롢ҵ����롢����״̬�ĸ�������û�б�ѡ�У���sign=0,���ܲ�ѯ������ڲ����š��������롢ҵ�����
	   // ������������һ��ѡ�л�������״̬��ѡ��������״̬��ֵ�ǳ����������ĵ���������װ������������״̬֮һ��sign=1,����ֱ��
	   // ֱ�Ӳ�ѯ���������״̬ѡ�У�������״̬��ֵ�� δ����������sign=0,���ܲ�ѯ��
	   if (document.forms[0].all[mod[0]].checked || document.forms[0].all[mod[0]].value == "Y" || document.forms[0].all[mod[0]].value == "1" ){
		   if (document.all[mod[1]].value != ""&&document.all[mod[1]].value !="N"){// lijixu 20090702
			   sign = 1;
		   }
	   }
   }
   if (sign == '0'){
   	   if(dateCount==""||dateCount==null){
   	   		dateCount=7;
   	   }
	   for (var j = 0;j < DateConWidName.length; j++){
		    var dateMod = DateConWidName[j].split("/");
            var fromStr = document.forms[0].all(dateMod[1]).value;
			var toStr = document.forms[0].all(dateMod[2]).value;
			if(document.forms[0].all[dateMod[0]].checked || document.forms[0].all(dateMod[0]).value == "Y" ||document.forms[0].all(dateMod[0]).value == "1"){
				if ("" != fromStr && "" != toStr){
					  var sub = SubDate(fromStr,toStr);
					  if(sub < dateCount){
						count = count + 1;
					  }
				}
			}
	   }
	   if(count > '0'){
	      reSign = true;
	   }else{
	      reSign = false;
	   }
   }else{
      reSign = true;
   }
   return reSign;
}
function SubDate(fromDateStr,toDateStr){
	fromDateStr = fromDateStr.replace(/-/g,"/");
	var fromDate =Date.parse(fromDateStr);  
	toDateStr = toDateStr.replace(/-/g,"/");
	var toDate = Date.parse(toDateStr);   
	fromDate = new Date(fromDate);   
	toDate = new Date(toDate);  
	return (toDate-fromDate)/(24*60*60*1000)
}

/** 
 *ΪData��չformat����
 *��date������תΪ��ʽΪ'YYYY-MM-DD HH:MM:SS'
 *@author zhaigl
*/
Date.prototype.format = function(format){
    var o = {
        "M+" : this.getMonth()+1, //month
        "d+" : this.getDate(),    //day
        "h+" : this.getHours(),   //hour
        "m+" : this.getMinutes(), //minute
        "s+" : this.getSeconds(), //second
        "q+" : Math.floor((this.getMonth()+3)/3),  //quarter
        "S" : this.getMilliseconds() //millisecond
    }
    if(/(y+)/.test(format))
    format=format.replace(RegExp.$1,(this.getFullYear()+"").substr(4 - RegExp.$1.length));
    for(var k in o)
    if(new RegExp("("+ k +")").test(format))
    format = format.replace(RegExp.$1,RegExp.$1.length==1 ? o[k] : ("00"+ o[k]).substr((""+ o[k]).length));
    return format;
}


/*
 *�Ƚ�����ʱ��Ĵ�С,ֻ֧��YYYY-MM-DD HH:MM:SS(Ŀǰϵͳͨ���ؼ���õ�ʱ���ʽ)
 *�߼�,�ȱȽ�����,����ͬһ���ٱȽ�Сʱ,����
 *���:_fromDate,_toDate
 *@author liukai
*/
function dateCompare(_fromDate,_toDate){
   var _fromLen=_fromDate.length;
   var _toLen=_toDate.length;
   var _fromDay=_fromDate.substring(0,10);
   var _toDay=_toDate.substring(0,10);
   var _filFromDay=_fromDay.replace(/-/g,'\/');
   var _filtoDay=_toDay.replace(/-/g,'\/');
  if(new Date(_filtoDay)>new Date(_filFromDay)){
      return true; 
   }else{
      if(_filtoDay==_filFromDay){
         var _fromHour=_fromDate.substring(10,_fromLen);
         var _toHour=_toDate.substring(10,_toLen);
         var _filFromHour=_fromHour.replace(/:/g,'');
         var _filToHour=_toHour.replace(/:/g,'');
         if(_filToHour>=_filFromHour){
           return true;
         }else{
            return false;
         }
      }else{
         return false;
      }
   }
};
// �������������Ƿ�Ϸ�(���ٲ���Ϊ���漸�����������û���������������Ϊ�յ�������ύ��
// ����������ĸ��������ŵ������������ֵ����ݣ���������Ϊ���֣��Ǹ�������С����Ȼ���Ϸ���
// 4���ж���������ֳ��������ֵ������Сֵ����λ�� �ȱ߽����������������)
// lijx
function checkNum(num,str){
   var renValue = "1";
	num = Trim(num);
	// �ж������Ƿ�Ϊ��
	 if(num.length<1){
	 	// alert("������������") 
	 	alert("\u8bf7\u8f93\u5165"+str+"!");
	    return  renValue = "0";
	 }
	 // �ж������Ƿ�Ϊ����
	 if(isNaN(num)){
	  	// alert("��������Ϊ���֣�") 
	  	alert(str+"\u5fc5\u987b\u4e3a\u6570\u5b57!") 
	    return renValue = "0";
      }
     // ����Ĳ�¼�����Ƿ�Ϊ ����������¼��������Ϊ��������Ҳ����Ϊ��������
     var r = /^[0-9]*[1-9][0-9]*$/��;
     var flag= r.test(num);
	 if(flag == false){
	  	// alert("��������Ϊ��������") 
	 	alert(str+"\u5fc5\u987b\u4e3a\u6b63\u6574\u6570!")
	    return renValue = "0";
     } 
     if(num>"99999999"){
     	//alert("�������ܴ���99999999��");
     	alert(str+"\u4e0d\u80fd\u5927\u4e8e 99999999!");
     	return renValue = "0";
     }
};







