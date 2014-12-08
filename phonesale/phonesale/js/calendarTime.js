<!--
document.write("<div id=calendarLayer style='position: absolute; z-index: 9999; width: 144; height: 193; display: none'>");
document.write("<iframe name=calendarIframe scrolling=no frameborder=0 width=100% height=100%></iframe></div>");
function writeCalendarFrame(){
	//added by zhaigl
	if(Calendar.timeShow){
		document.getElementById("calendarLayer").style.height="193";
	}else{
		document.getElementById("calendarLayer").style.height="171";
	}
    var strHtml =
    "	<html> " +
    "		<head> " +
    "			<meta http-equiv='Content-Type' content='text/html; charset=gb2312'/> " +
    "     <style> "+
    "			*{font-size: 12px; font-family: ����} "+
    "			.bg{  color: "+ Calendar.lightColor +"; cursor: default; background-color: "+ Calendar.darkColor +";} "+
    "			table#tableMain{ width: 142; height: 180;} "+
    "			table#tableWeek td{ color: "+ Calendar.lightColor +";} "+
    "			table#tableDay  td{ font-weight: bold;} "+
    "			td#yearHead, td#yearMonth, td#dayHour, td#hourMinute, td#minuteSecond {color: "+ Calendar.wordColor +"} "+
    "			.out { text-align: center; border-top: 1px solid "+ Calendar.DarkBorder +"; border-left: 1px solid "+ Calendar.DarkBorder +";"+
    "					border-right: 1px solid "+ Calendar.lightColor +"; border-bottom: 1px solid "+ Calendar.lightColor +";}"+
    "			.over{ text-align: center; border-top: 1px solid #FFFFFF; border-left: 1px solid #FFFFFF;"+
    "				border-bottom: 1px solid "+ Calendar.DarkBorder +"; border-right: 1px solid "+ Calendar.DarkBorder +"}"+
    "			input{ border: 1px solid "+ Calendar.darkColor +"; padding-top: 1px; height: 18; cursor: hand;"+
    "       color:"+ Calendar.wordColor +"; background-color: "+ Calendar.btnBgColor +"}"+
    "			</style> " +
    "		</head> " +
    "	<body onselectstart='return false' style='margin: 0px' oncontextmenu='return false'> " +
    "	<form name=calendarForm> ";

    if (Calendar.drag){
      strHtml +=
      "	<script language=javascript> "+
    	"		var drag=false, cx=0, cy=0, o = parent.Calendar.calendar; "+
      "		function document.onmousemove(){ "+
    	"			if(parent.Calendar.drag && drag){ "+
      "  			if(o.style.left=='') { "+
      "  				o.style.left=0; "+
     	"				} "+
      " 			if(o.style.top=='') { "+
      "  				o.style.top=0; "+
      "				}"+
    	"				o.style.left = parseInt(o.style.left) + window.event.clientX-cx; "+
    	"				o.style.top  = parseInt(o.style.top)  + window.event.clientY-cy; "+
      "			} "+
      "		} "+
    	"		function document.onkeydown(){ "+
      "  		switch(window.event.keyCode){ "+
      "  			case 27 : parent.hiddenCalendarTime(); break; "+
    	"				case 37 : parent.prevMonth(); break; "+
      "				case 38 : parent.prevYear(); break; "+
      "				case 39 : parent.nextMonth(); break; "+
      "				case 40 : parent.nextYear(); break; "+
    	"				case 84 : document.forms[0].today.click(); break; " +
      "			} " +
     " 			window.event.keyCode = 0; " +
     "			window.event.returnValue= false; " +
     "		} "+
    	"		function dragStart(){ " +
      "			cx=window.event.clientX; " +
      "			cy=window.event.clientY; " +
      "			drag=true; " +
      "		} " +
      "	</script> ";
    }

    strHtml +=
    	"	<select name=tmpHourSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:173;left:11;display:none' "+
    	" 	onchange='parent.Calendar.thisHour=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpMinuteSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:173;left:51;display:none' "+
    	" 	onchange='parent.Calendar.thisMinute=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpSecondSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:173;left:91;display:none' "+
    	" 	onchange='parent.Calendar.thisSecond=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpYearSelect  onblur='parent.hiddenSelect(this)' style='z-index:1;position:absolute;top:3;left:18;display:none' "+
    	" 	onchange='parent.Calendar.thisYear =this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
    	"	<select name=tmpMonthSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:3;left:74;display:none' "+
    	" 	onchange='parent.Calendar.thisMonth=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+

    	"	<table id=tableMain class=bg border=0 cellspacing=2 cellpadding=0> "+
    	"		<tr> "+
      "			<td width=140 height=19 bgcolor='"+ Calendar.lightColor +"'> "+
    	"    		<table width=140 id=tableHead border=0 cellspacing=1 cellpadding=0> "+
      "					<tr align=center> "+
    	"    				<td width=15 height=19 class=bg title='��ǰ�� 1 ��&#13;��ݼ�����' style='cursor: hand' onclick='parent.prevMonth()'><b>&lt;</b></td> "+
    	"    				<td width=60 id=yearHead  title='����˴�ѡ�����' onclick='parent.showYearSelect(parseInt(this.innerText, 10))' "+
    	"        			onmouseover='this.bgColor=parent.Calendar.darkColor; this.style.color=parent.Calendar.lightColor' "+
    	"        			onmouseout='this.bgColor=parent.Calendar.lightColor; this.style.color=parent.Calendar.wordColor'></td> "+
    	"    				<td width=50 id=yearMonth title='����˴�ѡ���·�' onclick='parent.showMonthSelect(parseInt(this.innerText, 10))' "+
    	"        			onmouseover='this.bgColor=parent.Calendar.darkColor; this.style.color=parent.Calendar.lightColor' "+
    	"        			onmouseout='this.bgColor=parent.Calendar.lightColor; this.style.color=parent.Calendar.wordColor'></td> "+
    	"    				<td width=15 class=bg title='��� 1 ��&#13;��ݼ�����' onclick='parent.nextMonth()' style='cursor: hand'><b>&gt;</b></td> "+
      "					</tr> "+
      "				</table> "+
    	"			</td> "+
      "		</tr> "+
      "		<tr> "+
      "			<td height=20> "+
      "				<table id=tableWeek border=1 width=140 cellpadding=0 cellspacing=0 ";
    					if(Calendar.drag){
                strHtml +=
                "onmousedown='dragStart()' onmouseup='drag=false' onmouseout='drag=false' ";
              }
    					strHtml +=
              	"borderColorLight='"+ Calendar.darkColor +"' borderColorDark='"+ Calendar.lightColor +"'> "+
    "    				<tr align=center> "+
    "							<td height=20>��</td>"+
    "							<td>һ</td>"+
    "							<td>��</td>"+
    "							<td>��</td>"+
    "							<td>��</td>"+
    "							<td>��</td>"+
    "							<td>��</td>"+
    "						</tr> "+
    "					</table> "+
    "				</td> "+
    "			</tr> "+
    "			<tr> "+
    "				<td valign=top width=140 bgcolor='"+ Calendar.lightColor +"'> "+
    "    			<table id=tableDay height=120 width=140 border=0 cellspacing=1 cellpadding=0> ";
         			for(var x=0; x<5; x++){
              	strHtml +=
    "						<tr> ";
         				for(var y=0; y<7; y++) {
                 	strHtml +=
    "							<td class=out id='calendarDay"+ (x*7+y) +"'></td> ";
         				}
              	strHtml +=
    "						</tr> ";
    					}
         			strHtml +=
    "						<tr> ";
         				for(var x=35; x<38; x++) {
                	strHtml +=
    "							<td class=out id='calendarDay"+ x +"'></td> ";
         				}
                strHtml +=
    "							<td colspan=2 class=out title='"+ Calendar.regInfo +"'> "+
    "								<input style=' background-color: "+ Calendar.btnBgColor +
    "									;cursor: hand; padding-top: 4px; width: 100%; height: 100%; border: 0' onfocus='this.blur()' "+
    " 								type=button value='���' onclick='parent.clearCalendar()'> "+
    "							</td> "+
    "							<td colspan=2 class=out title='"+ Calendar.regInfo +"'> "+
    "								<input style=' background-color: "+ Calendar.btnBgColor +
    "									;cursor: hand; padding-top: 4px; width: 100%; height: 100%; border: 0' onfocus='this.blur()' "+
    " 								type=button value='�ر�' onclick='parent.hiddenCalendarTime()'> "+
    "							</td> "+
    "						</tr> "+
    "					</table> "+
    "				</td> "+
    "			</tr> ";

	//added by zhaigl
	if(Calendar.timeShow){
		strHtml +=" <tr style='visibility:visible'> ";
	}else{
		strHtml +=" <tr style='visibility:hidden'> ";
	}

	strHtml +=	"<td height=20 bgcolor='"+ Calendar.lightColor +"'> "+
		"    			<table width=140 border=0 cellspacing=1 cellpadding=0> "+
		"						<tr align=center> "+
		"							<td width=10>&nbsp;</td> " +
		"							<td width=40 id=dayHour  title='����˴�ѡ��ʱ' onclick='parent.showHourSelect(parseInt(this.innerText, 10))' "+
		"        					onmouseover='this.bgColor=parent.Calendar.darkColor; this.style.color=parent.Calendar.lightColor' "+
		"        					onmouseout='this.bgColor=parent.Calendar.lightColor; this.style.color=parent.Calendar.wordColor'> </td> "+
		"    					<td width=40 id=hourMinute  title='����˴�ѡ���' onclick='parent.showMinuteSelect(parseInt(this.innerText, 10))' "+
		"        					onmouseover='this.bgColor=parent.Calendar.darkColor; this.style.color=parent.Calendar.lightColor' "+
		"        					onmouseout='this.bgColor=parent.Calendar.lightColor; this.style.color=parent.Calendar.wordColor'></td> "+
		"   					<td width=40 id=minuteSecond title='����˴�ѡ����' onclick='parent.showSecondSelect(parseInt(this.innerText, 10))' "+
		"        					onmouseover='this.bgColor=parent.Calendar.darkColor; this.style.color=parent.Calendar.lightColor' "+
		"        					onmouseout='this.bgColor=parent.Calendar.lightColor; this.style.color=parent.Calendar.wordColor'></td> "+
		"							<td width=10>&nbsp;</td> " +
		"    				</tr> "+
		"					</table> "+
		"				</td> "+
		"			</tr> ";

    strHtml += "<table> "+
		"	</form> "+
		"</body> "+
		"</html> ";

    with(Calendar.iframe)
    {
        document.writeln(strHtml);
        document.close();
        for(var i=0; i<38; i++)
        {
            Calendar.dayObj[i] = eval("calendarDay"+ i);
            Calendar.dayObj[i].onmouseover = onDayMouseOver;
            Calendar.dayObj[i].onmouseout  = onDayMouseOut;
            Calendar.dayObj[i].onclick     = returnCalendar;
        }
    }
}

//��ʼ������������
function XCalendar() {
    this.regInfo    = "";
    this.daysMonth  = new Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
    this.day        = new Array(39);            //��������չʾ�õ�����
    this.dayObj     = new Array(39);            //��������չʾ�ؼ�����
    this.dateStyle  = null;                     //�����ʽ������������
    this.objExport  = null;                     //�����ش�����ʾ�ؼ�
    this.eventSrc   = null;                     //������ʾ�Ĵ����ؼ�
    this.inputDate  = null;                     //ת��������������(d/m/yyyy)
    this.thisYear   = new Date().getFullYear(); //������ı����ĳ�ʼֵ
    this.thisMonth  = new Date().getMonth()+ 1; //�����µı����ĳ�ʼֵ
    this.thisDay    = new Date().getDate();     //�����յı����ĳ�ʼֵ
    this.thisHour	= new Date().getHours();			//����ʱ�ı����ĳ�ʼֵ
    this.thisMinute	= new Date().getMinutes();			//����ʱ�ı����ĳ�ʼֵ
    this.thisSecond	= new Date().getSeconds();			//����ʱ�ı����ĳ�ʼֵ
    this.today      = this.thisDay +"/"+ this.thisMonth +"/"+ this.thisYear;   //����(d/m/yyyy)
    this.iframe     = window.frames("calendarIframe"); //������ iframe ����
    this.calendar   = getObjectById("calendarLayer");  //�����Ĳ�
    this.dateReg    = "";           //������ʽ��֤������ʽ

    this.yearFall   = 50;           //����������������ֵ
    this.format     = "yyyy-mm-dd"; //�ش����ڵĸ�ʽ
    this.timeShow   = true;        //�Ƿ񷵻�ʱ��
    this.drag       = true;         //�Ƿ������϶�
    this.darkColor  = "#96BBD8";    //�ؼ��İ�ɫ
    this.lightColor = "#FFFFFF";    //�ؼ�����ɫ
    this.btnBgColor = "#DEEFFB";    //�ؼ��İ�ť����ɫ
    this.wordColor  = "#878888";    //�ؼ���������ɫ
    this.wordDark   = "#DCDCDC";    //�ؼ��İ�������ɫ
    this.dayBgColor = "#F0F0F0";    //�������ֱ���ɫ
    this.todayColor = "#F8BF6E";    //�����������ϵı�ʾ����ɫ
    this.DarkBorder = "#D4D0C8";    //������ʾ��������ɫ
}

var Calendar = new XCalendar();
Calendar.DATE = true;
Calendar.TIMESTAMP = false;
var isDisplayTime = true; 

//��������
XCalendar.prototype.display = function(_timeShowFlag){
	this.calendarTime(_timeShowFlag);
};
XCalendar.prototype.calendarTime = function(_timeShow) {
	Calendar.timeShow = _timeShow;
	isDisplayTime = _timeShow;
	var e = window.event.srcElement;
    writeCalendarFrame();
    var o = Calendar.calendar.style;
    Calendar.eventSrc = e;
	Calendar.objExport = e;
	if (arguments.length > 0) {
		Calendar.timeShow = arguments[0];
	} 

    Calendar.iframe.tableWeek.style.cursor = Calendar.drag ? "move" : "default";
		var t = e.offsetTop,  h = e.clientHeight, l = e.offsetLeft, p = e.type;
		while (e = e.offsetParent){t += e.offsetTop; l += e.offsetLeft;}
    o.display = ""; Calendar.iframe.document.body.focus();
    var cw = Calendar.calendar.clientWidth, ch = Calendar.calendar.clientHeight;
    var dw = document.body.clientWidth, dl = document.body.scrollLeft, dt = document.body.scrollTop;

    if (document.body.clientHeight + dt - t - h >= ch) o.top = (p=="image")? t + h : t + h + 6;
    else o.top  = (t - dt < ch) ? ((p=="image")? t + h : t + h + 6) : t - ch;
    if (dw + dl - l >= cw) o.left = l; else o.left = (dw >= cw) ? dw - cw + dl : dl;

    if  (!Calendar.timeShow) Calendar.dateReg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
    else Calendar.dateReg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2}) (\d{1,2}):(\d{1,2}):(\d{1,2})$/;
    try{
        if (Calendar.objExport.value.trim() != ""){
            Calendar.dateStyle = Calendar.objExport.value.trim().match(Calendar.dateReg);
            if (Calendar.dateStyle == null)
            {
                Calendar.thisYear   = new Date().getFullYear();
                Calendar.thisMonth  = new Date().getMonth()+ 1;
                Calendar.thisDay    = new Date().getDate();
                alert("ԭ�ı�����������д���\n�������㶨�����ʾʱ�����г�ͻ��");
                writeCalendarTime(); return false;
            }
            else
            {
                Calendar.thisYear   = parseInt(Calendar.dateStyle[1], 10);
                Calendar.thisMonth  = parseInt(Calendar.dateStyle[3], 10);
                Calendar.thisDay    = parseInt(Calendar.dateStyle[4], 10);
				//Added by zhaigl
				if(Calendar.timeShow){
					Calendar.thisHour    = parseInt(Calendar.dateStyle[5], 10);
					Calendar.thisMinute    = parseInt(Calendar.dateStyle[6], 10);
					Calendar.thisSecond    = parseInt(Calendar.dateStyle[7], 10);
				}else{
					Calendar.thisHour    = new Date().getHours();
					Calendar.thisMinute    = new Date().getMinutes();
					Calendar.thisSecond    = new Date().getSeconds();
				}
                Calendar.inputDate  = parseInt(Calendar.thisDay, 10) +"/"+ parseInt(Calendar.thisMonth, 10) +"/"+
                parseInt(Calendar.thisYear, 10); writeCalendarTime();
            }
        }  else{
			Calendar.thisHour    = new Date().getHours();
			Calendar.thisMinute    = new Date().getMinutes();
			Calendar.thisSecond    = new Date().getSeconds();
			writeCalendarTime();
		}
    }  catch(e){writeCalendarTime();}
}
function showMonthSelect() //�·ݵ�������
{
    var m = isNaN(parseInt(Calendar.thisMonth, 10)) ? new Date().getMonth() + 1 : parseInt(Calendar.thisMonth);
    var e = Calendar.iframe.document.forms[0].tmpMonthSelect;
    for (var i=1; i<13; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showHourSelect() //Сʱ��������
{
    var m = isNaN(parseInt(Calendar.thisHour, 10)) ? new Date().getHours() : parseInt(Calendar.thisHour);
    var e = Calendar.iframe.document.forms[0].tmpHourSelect;
    for (var i=0; i<24; i++) e.options.add(new Option(i +"ʱ", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showMinuteSelect() //�ֵ�������
{
    var m = isNaN(parseInt(Calendar.thisMinute, 10)) ? new Date().getMinutes() : parseInt(Calendar.thisMinute);
    var e = Calendar.iframe.document.forms[0].tmpMinuteSelect;
    for (var i=0; i<=59; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showSecondSelect() //���������
{
    var m = isNaN(parseInt(Calendar.thisSecond, 10)) ? new Date().getSeconds() : parseInt(Calendar.thisSecond);
    var e = Calendar.iframe.document.forms[0].tmpSecondSelect;
    for (var i=0; i<=59; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showYearSelect() //��ݵ�������
{
    var n = Calendar.yearFall;
    var e = Calendar.iframe.document.forms[0].tmpYearSelect;
    var y = isNaN(parseInt(Calendar.thisYear, 10)) ? new Date().getFullYear() : parseInt(Calendar.thisYear);
        y = (y <= 1000)? 1000 : ((y >= 9999)? 9999 : y);
    var min = (y - n >= 1000) ? y - n : 1000;
    var max = (y + n <= 9999) ? y + n : 9999;
        min = (max == 9999) ? max-n*2 : min;
        max = (min == 1000) ? min+n*2 : max;
    for (var i=min; i<=max; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = y; e.focus();
}
function prevMonth()  //��ǰ���·�
{
    Calendar.thisDay = 1;
    if (Calendar.thisMonth==1)
    {
        Calendar.thisYear--;
        Calendar.thisMonth=13;
    }
    Calendar.thisMonth--; writeCalendarTime();
}
function nextMonth()  //�����·�
{
    Calendar.thisDay = 1;
    if (Calendar.thisMonth==12)
    {
        Calendar.thisYear++;
        Calendar.thisMonth=0;
    }
    Calendar.thisMonth++; writeCalendarTime();
}
function prevYear()
{
  Calendar.thisDay = 1;
  Calendar.thisYear--;
  writeCalendarTime();
}//��ǰ�� Year
function nextYear()
{
  Calendar.thisDay = 1;
  Calendar.thisYear++;
  writeCalendarTime();
}//���� Year
function hiddenSelect(e)
{
  for(var i=e.options.length; i>-1; i--)
  	e.options.remove(i);
  e.style.display="none";
}
function getObjectById(id)
{
  if(document.all)
  	return(eval("document.all."+ id));
  return(eval(id));
}
function hiddenCalendarTime()
{
  getObjectById("calendarLayer").style.display = "none";
};
function appendZero(n)
{
  return(("00"+ n).substr(("00"+ n).length-2));
}

function trim()
{
  return this.replace(/(^\s*)|(\s*$)/g,"");
}
function onDayMouseOver()
{
    this.className = "over";
    this.style.backgroundColor = Calendar.darkColor;
    if(Calendar.day[this.id.substr(11)].split("/")[1] == Calendar.thisMonth)
    this.style.color = Calendar.lightColor;
}
function onDayMouseOut()
{
    this.className = "out";
    var d = Calendar.day[this.id.substr(11)];
    var a = d.split("/");
    this.style.removeAttribute('backgroundColor');
    if(a[1] == Calendar.thisMonth && d != Calendar.today)
    {
        if(Calendar.dateStyle != null && a[0] == parseInt(Calendar.dateStyle[4], 10))
        this.style.color = Calendar.lightColor;
        this.style.color = Calendar.wordColor;
    }
}
function writeCalendarTime() //��������ʾ�����ݵĴ������
{
    var y = Calendar.thisYear;
    var m = Calendar.thisMonth;
    var d = Calendar.thisDay;
    var h = Calendar.thisHour;
    Calendar.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28;
    if (!(y<=9999 && y >= 1000 && parseInt(m, 10)>0 && parseInt(m, 10)<13 && parseInt(d, 10)>0)){
        alert("�Բ����������˴�������ڣ�");
        Calendar.thisYear   = new Date().getFullYear();
        Calendar.thisMonth  = new Date().getMonth()+ 1;
        Calendar.thisDay    = new Date().getDate();
    }
    y = Calendar.thisYear;
    m = Calendar.thisMonth;
    d = Calendar.thisDay;
    h = Calendar.thisHour;
    mi = Calendar.thisMinute;
    s = Calendar.thisSecond;
    Calendar.iframe.yearHead.innerText  = y +" ��";
	Calendar.iframe.yearMonth.innerText = parseInt(m, 10) +" ��";
	Calendar.iframe.dayHour.innerText  = h +" ʱ";
	Calendar.iframe.hourMinute.innerText  = mi +" ��";
	Calendar.iframe.minuteSecond.innerText  = s +" ��";
    Calendar.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28; //�������Ϊ29��
    var w = new Date(y, m-1, 1).getDay();
    var prevDays = m==1  ? Calendar.daysMonth[11] : Calendar.daysMonth[m-2];
    for(var i=(w-1); i>=0; i--) //������ for ѭ��Ϊ����������Դ������ Calendar.day����ʽ�� d/m/yyyy
    {
        Calendar.day[i] = prevDays +"/"+ (parseInt(m, 10)-1) +"/"+ y;
        if(m==1) Calendar.day[i] = prevDays +"/"+ 12 +"/"+ (parseInt(y, 10)-1);
        prevDays--;
    }
    for(var i=1; i<=Calendar.daysMonth[m-1]; i++) Calendar.day[i+w-1] = i +"/"+ m +"/"+ y;
    for(var i=1; i<39-w-Calendar.daysMonth[m-1]+1; i++)
    {
        Calendar.day[Calendar.daysMonth[m-1]+w-1+i] = i +"/"+ (parseInt(m, 10)+1) +"/"+ y;
        if(m==12) Calendar.day[Calendar.daysMonth[m-1]+w-1+i] = i +"/"+ 1 +"/"+ (parseInt(y, 10)+1);
    }
    for(var i=0; i<38; i++)    //���ѭ���Ǹ���Դ����д����������ʾ
    {
        var a = Calendar.day[i].split("/");
        Calendar.dayObj[i].innerText    = a[0];
        Calendar.dayObj[i].title        = a[2] +"-"+ appendZero(a[1]) +"-"+ appendZero(a[0]);
        Calendar.dayObj[i].bgColor      = Calendar.dayBgColor;
        Calendar.dayObj[i].style.color  = Calendar.wordColor;
        if ((i<10 && parseInt(Calendar.day[i], 10)>20) || (i>27 && parseInt(Calendar.day[i], 10)<12))
            Calendar.dayObj[i].style.color = Calendar.wordDark;
        if (Calendar.inputDate==Calendar.day[i])    //�����������������������ϵ���ɫ
        {Calendar.dayObj[i].bgColor = Calendar.darkColor; Calendar.dayObj[i].style.color = Calendar.lightColor;}
        if (Calendar.day[i] == Calendar.today)      //���ý����������Ϸ�Ӧ��������ɫ
        {Calendar.dayObj[i].bgColor = Calendar.todayColor; Calendar.dayObj[i].style.color = Calendar.lightColor;}
    }
}
function returnCalendar() //�������ڸ�ʽ�ȷ����û�ѡ��������
{
    if(Calendar.objExport)
    {
        var returnValue;
        var a = (arguments.length==0) ? Calendar.day[this.id.substr(11)].split("/") : arguments[0].split("/");
        var d = Calendar.format.match(/^(\w{4})(-|\/)(\w{1,2})\2(\w{1,2})$/);
        if(d==null){alert("���趨�����������ʽ���ԣ�\r\n\r\n�����¶��� Calendar.format ��"); return false;}
        var flag = d[3].length==2 || d[4].length==2; //�жϷ��ص����ڸ�ʽ�Ƿ�Ҫ����
        returnValue = flag ? a[2] +d[2]+ appendZero(a[1]) +d[2]+ appendZero(a[0]) : a[2] +d[2]+ a[1] +d[2]+ a[0];
        if(Calendar.timeShow)
        {
            var h = Calendar.thisHour, m = Calendar.thisMinute, s = Calendar.thisSecond;
            returnValue += flag ? " "+ appendZero(h) +":"+ appendZero(m) +":"+ appendZero(s) : " "+  h  +":"+ m +":"+ s;
        }
        if(isDisplayTime){
        	Calendar.objExport.value = returnValue;
        }else{
        	Calendar.objExport.value = returnValue.substring(0,10);
        }
        hiddenCalendarTime();
    }
}
function clearCalendar(){
    if(Calendar.objExport){
    	Calendar.objExport.value = "";
    	hiddenCalendarTime();
    }
}

function  onclick()
{
     if(Calendar.eventSrc != window.event.srcElement) hiddenCalendarTime();
}

//-->