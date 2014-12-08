<!--
document.write("<div id=calendarLayer style='position: absolute; z-index: 9999; width: 144px; height: 170px; display: none'>");
document.write("<iframe name=calendarIframe scrolling=no frameborder=0 width=100% height=100%></iframe></div>");
function writeCalendarFrame()
{
    var strHtml =
    "	<html> " +
    "		<head> " +
    "			<meta http-equiv='Content-Type' content='text/html; charset=gb2312'/> " +
    "     <style> "+
    "			*{font-size: 12px; font-family: ����} "+
    "			.bg{  color: "+ CalendarWithTime.lightColor +"; cursor: default; background-color: "+ CalendarWithTime.darkColor +";} "+
    "			table#tableMain{ width: 142; height: 180;} "+
    "			table#tableWeek td{ color: "+ CalendarWithTime.lightColor +";} "+
    "			table#tableDay  td{ font-weight: bold;} "+
    "			td#yearHead, td#yearMonth, td#dayHour, td#hourMinute, td#minuteSecond {color: "+ CalendarWithTime.wordColor +"} "+
    "			.out { text-align: center; border-top: 1px solid "+ CalendarWithTime.DarkBorder +"; border-left: 1px solid "+ CalendarWithTime.DarkBorder +";"+
    "					border-right: 1px solid "+ CalendarWithTime.lightColor +"; border-bottom: 1px solid "+ CalendarWithTime.lightColor +";}"+
    "			.over{ text-align: center; border-top: 1px solid #FFFFFF; border-left: 1px solid #FFFFFF;"+
    "				border-bottom: 1px solid "+ CalendarWithTime.DarkBorder +"; border-right: 1px solid "+ CalendarWithTime.DarkBorder +"}"+
    "			input{ border: 1px solid "+ CalendarWithTime.darkColor +"; padding-top: 1px; height: 18; cursor: hand;"+
    "       color:"+ CalendarWithTime.wordColor +"; background-color: "+ CalendarWithTime.btnBgColor +"}"+
    "			</style> " +
    "		</head> " +
    "	<body onselectstart='return false' style='margin: 0px' oncontextmenu='return false'> " +
    "	<form name=calendarForm> ";

    if (CalendarWithTime.drag){
      strHtml +=
      "	<script language=javascript> "+
    	"		var drag=false, cx=0, cy=0, o = parent.CalendarWithTime.calendar; "+
      "		function document.onmousemove(){ "+
    	"			if(parent.CalendarWithTime.drag && drag){ "+
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
    	" 	onchange='parent.CalendarWithTime.thisHour=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpMinuteSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:173;left:51;display:none' "+
    	" 	onchange='parent.CalendarWithTime.thisMinute=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpSecondSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:173;left:91;display:none' "+
    	" 	onchange='parent.CalendarWithTime.thisSecond=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
			"	<select name=tmpYearSelect  onblur='parent.hiddenSelect(this)' style='z-index:1;position:absolute;top:3;left:18;display:none' "+
    	" 	onchange='parent.CalendarWithTime.thisYear =this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+
    	"	<select name=tmpMonthSelect onblur='parent.hiddenSelect(this)' style='z-index:1; position:absolute;top:3;left:74;display:none' "+
    	" 	onchange='parent.CalendarWithTime.thisMonth=this.value; parent.hiddenSelect(this); parent.writeCalendarTime();'></select> "+

    	"	<table id=tableMain class=bg border=0 cellspacing=2 cellpadding=0> "+
    	"		<tr> "+
      "			<td width=140 height=19 bgcolor='"+ CalendarWithTime.lightColor +"'> "+
    	"    		<table width=140 id=tableHead border=0 cellspacing=1 cellpadding=0> "+
      "					<tr align=center> "+
    	"    				<td width=15 height=19 class=bg title='��ǰ�� 1 ��&#13;��ݼ�����' style='cursor: hand' onclick='parent.prevMonth()'><b>&lt;</b></td> "+
    	"    				<td width=60 id=yearHead  title='����˴�ѡ�����' onclick='parent.showYearSelect(parseInt(this.innerText, 10))' "+
    	"        			onmouseover='this.bgColor=parent.CalendarWithTime.darkColor; this.style.color=parent.CalendarWithTime.lightColor' "+
    	"        			onmouseout='this.bgColor=parent.CalendarWithTime.lightColor; this.style.color=parent.CalendarWithTime.wordColor'></td> "+
    	"    				<td width=50 id=yearMonth title='����˴�ѡ���·�' onclick='parent.showMonthSelect(parseInt(this.innerText, 10))' "+
    	"        			onmouseover='this.bgColor=parent.CalendarWithTime.darkColor; this.style.color=parent.CalendarWithTime.lightColor' "+
    	"        			onmouseout='this.bgColor=parent.CalendarWithTime.lightColor; this.style.color=parent.CalendarWithTime.wordColor'></td> "+
    	"    				<td width=15 class=bg title='��� 1 ��&#13;��ݼ�����' onclick='parent.nextMonth()' style='cursor: hand'><b>&gt;</b></td> "+
      "					</tr> "+
      "				</table> "+
    	"			</td> "+
      "		</tr> "+
      "		<tr> "+
      "			<td height=20> "+
      "				<table id=tableWeek border=1 width=140 cellpadding=0 cellspacing=0 ";
    					if(CalendarWithTime.drag){
                strHtml +=
                "onmousedown='dragStart()' onmouseup='drag=false' onmouseout='drag=false' ";
              }
    					strHtml +=
              	"borderColorLight='"+ CalendarWithTime.darkColor +"' borderColorDark='"+ CalendarWithTime.lightColor +"'> "+
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
    "				<td valign=top width=140 bgcolor='"+ CalendarWithTime.lightColor +"'> "+
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
    "							<td colspan=2 class=out title='"+ CalendarWithTime.regInfo +"'> "+
    "								<input style=' background-color: "+ CalendarWithTime.btnBgColor +
    "									;cursor: hand; padding-top: 4px; width: 100%; height: 100%; border: 0' onfocus='this.blur()' "+
    " 								type=button value='���' onclick='parent.clearCalendar()'> "+
    "							</td> "+
    "							<td colspan=2 class=out title='"+ CalendarWithTime.regInfo +"'> "+
    "								<input style=' background-color: "+ CalendarWithTime.btnBgColor +
    "									;cursor: hand; padding-top: 4px; width: 100%; height: 100%; border: 0' onfocus='this.blur()' "+
    " 								type=button value='�ر�' onclick='parent.hiddenCalendarTime()'> "+
    "							</td> "+
    "						</tr> "+
    "					</table> "+
    "				</td> "+
    "			</tr> "+
	"			<tr><td height=150>&nbsp;</td></tr>"+
	"		<table> "+
    "	</form> "+
    "</body> "+
    "</html> ";

    with(CalendarWithTime.iframe)
    {
        document.writeln(strHtml);
        document.close();
        for(var i=0; i<38; i++)
        {
            CalendarWithTime.dayObj[i] = eval("calendarDay"+ i);
            CalendarWithTime.dayObj[i].onmouseover = onDayMouseOver;
            CalendarWithTime.dayObj[i].onmouseout  = onDayMouseOut;
            CalendarWithTime.dayObj[i].onclick     = returnCalendar;
        }
    }
}
function CalendarWithTime() //��ʼ������������
{
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
    this.thisHour	 = new Date().getHours();			//����ʱ�ı����ĳ�ʼֵ
    this.thisMinute	 = new Date().getMinutes();			//����ʱ�ı����ĳ�ʼֵ
    this.thisSecond	 = new Date().getSeconds();			//����ʱ�ı����ĳ�ʼֵ
    this.today      = this.thisDay +"/"+ this.thisMonth +"/"+ this.thisYear;   //����(d/m/yyyy)
    this.iframe     = window.frames("calendarIframe"); //������ iframe ����
    this.calendar   = getObjectById("calendarLayer");  //�����Ĳ�
    this.dateReg    = "";           //������ʽ��֤������ʽ
    this.yearFall   = 50;           //����������������ֵ
    this.format     = "yyyy-mm-dd"; //�ش����ڵĸ�ʽ
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

 var CalendarWithTime = new CalendarWithTime();

function calendarDate() //��������
{
    var e = window.event.srcElement;
    writeCalendarFrame();
    var o = CalendarWithTime.calendar.style;
    CalendarWithTime.eventSrc = e;
		if (arguments.length == 0) {
    	CalendarWithTime.objExport = e;
		} else {
    	CalendarWithTime.objExport = eval(arguments[0]);
		}

    CalendarWithTime.iframe.tableWeek.style.cursor = CalendarWithTime.drag ? "move" : "default";
		var t = e.offsetTop,  h = e.clientHeight, l = e.offsetLeft, p = e.type;
		while (e = e.offsetParent){t += e.offsetTop; l += e.offsetLeft;}
    o.display = ""; CalendarWithTime.iframe.document.body.focus();
    var cw = CalendarWithTime.calendar.clientWidth, ch = CalendarWithTime.calendar.clientHeight;
    var dw = document.body.clientWidth, dl = document.body.scrollLeft, dt = document.body.scrollTop;

    if (document.body.clientHeight + dt - t - h >= ch) o.top = (p=="image")? t + h : t + h + 6;
    else o.top  = (t - dt < ch) ? ((p=="image")? t + h : t + h + 6) : t - ch;
    if (dw + dl - l >= cw) o.left = l; else o.left = (dw >= cw) ? dw - cw + dl : dl;
    CalendarWithTime.dateReg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;
    try{
        if (CalendarWithTime.objExport.value.trim() != ""){
            CalendarWithTime.dateStyle = CalendarWithTime.objExport.value.trim().match(CalendarWithTime.dateReg);
            if (CalendarWithTime.dateStyle == null)
            {
                CalendarWithTime.thisYear   = new Date().getFullYear();
                CalendarWithTime.thisMonth  = new Date().getMonth()+ 1;
                CalendarWithTime.thisDay    = new Date().getDate();
                alert("ԭ�ı�����������д���\n�������㶨�����ʾʱ�����г�ͻ��");
                writeCalendarTime(); return false;
            }
            else
            {
                CalendarWithTime.thisYear   = parseInt(CalendarWithTime.dateStyle[1], 10);
                CalendarWithTime.thisMonth  = parseInt(CalendarWithTime.dateStyle[3], 10);
                CalendarWithTime.thisDay    = parseInt(CalendarWithTime.dateStyle[4], 10);
                CalendarWithTime.thisHour    = parseInt(CalendarWithTime.dateStyle[5], 10);
                CalendarWithTime.thisMinute    = parseInt(CalendarWithTime.dateStyle[6], 10);
                CalendarWithTime.thisSecond    = parseInt(CalendarWithTime.dateStyle[7], 10);
                CalendarWithTime.inputDate  = parseInt(CalendarWithTime.thisDay, 10) +"/"+ parseInt(CalendarWithTime.thisMonth, 10) +"/"+
                parseInt(CalendarWithTime.thisYear, 10); writeCalendarTime();
            }
        }  else writeCalendarTime();
    }  catch(e){writeCalendarTime();}
}
function showMonthSelect() //�·ݵ�������
{
    var m = isNaN(parseInt(CalendarWithTime.thisMonth, 10)) ? new Date().getMonth() + 1 : parseInt(CalendarWithTime.thisMonth);
    var e = CalendarWithTime.iframe.document.forms[0].tmpMonthSelect;
    for (var i=1; i<13; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showHourSelect() //Сʱ��������
{
    var m = isNaN(parseInt(CalendarWithTime.thisHour, 10)) ? new Date().getHours() : parseInt(CalendarWithTime.thisHour);
    var e = CalendarWithTime.iframe.document.forms[0].tmpHourSelect;
    for (var i=0; i<24; i++) e.options.add(new Option(i +"ʱ", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showMinuteSelect() //�ֵ�������
{
    var m = isNaN(parseInt(CalendarWithTime.thisMinute, 10)) ? new Date().getMinutes() : parseInt(CalendarWithTime.thisMinute);
    var e = CalendarWithTime.iframe.document.forms[0].tmpMinuteSelect;
    for (var i=0; i<=59; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showSecondSelect() //���������
{
    var m = isNaN(parseInt(CalendarWithTime.thisSecond, 10)) ? new Date().getSeconds() : parseInt(CalendarWithTime.thisSecond);
    var e = CalendarWithTime.iframe.document.forms[0].tmpSecondSelect;
    for (var i=0; i<=59; i++) e.options.add(new Option(i +"��", i));
    e.style.display = ""; e.value = m; e.focus(); window.status = e.style.top;
}
function showYearSelect() //��ݵ�������
{
    var n = CalendarWithTime.yearFall;
    var e = CalendarWithTime.iframe.document.forms[0].tmpYearSelect;
    var y = isNaN(parseInt(CalendarWithTime.thisYear, 10)) ? new Date().getFullYear() : parseInt(CalendarWithTime.thisYear);
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
    CalendarWithTime.thisDay = 1;
    if (CalendarWithTime.thisMonth==1)
    {
        CalendarWithTime.thisYear--;
        CalendarWithTime.thisMonth=13;
    }
    CalendarWithTime.thisMonth--; writeCalendarTime();
}
function nextMonth()  //�����·�
{
    CalendarWithTime.thisDay = 1;
    if (CalendarWithTime.thisMonth==12)
    {
        CalendarWithTime.thisYear++;
        CalendarWithTime.thisMonth=0;
    }
    CalendarWithTime.thisMonth++; writeCalendarTime();
}
function prevYear()
{
  CalendarWithTime.thisDay = 1;
  CalendarWithTime.thisYear--;
  writeCalendarTime();
}//��ǰ�� Year
function nextYear()
{
  CalendarWithTime.thisDay = 1;
  CalendarWithTime.thisYear++;
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
}//�����Զ��������
String.prototype.trim = function() {
    return this.replace(/(^\s*)|(\s*$)/g, "");
}
function onDayMouseOver()
{
    this.className = "over";
    this.style.backgroundColor = CalendarWithTime.darkColor;
    if(CalendarWithTime.day[this.id.substr(11)].split("/")[1] == CalendarWithTime.thisMonth)
    this.style.color = CalendarWithTime.lightColor;
}
function onDayMouseOut()
{
    this.className = "out";
    var d = CalendarWithTime.day[this.id.substr(11)];
    var a = d.split("/");
    this.style.removeAttribute('backgroundColor');
    if(a[1] == CalendarWithTime.thisMonth && d != CalendarWithTime.today)
    {
        if(CalendarWithTime.dateStyle != null && a[0] == parseInt(CalendarWithTime.dateStyle[4], 10))
        this.style.color = CalendarWithTime.lightColor;
        this.style.color = CalendarWithTime.wordColor;
    }
}
function writeCalendarTime() //��������ʾ�����ݵĴ������
{
    var y = CalendarWithTime.thisYear;
    var m = CalendarWithTime.thisMonth;
    var d = CalendarWithTime.thisDay;
    var h = CalendarWithTime.thisHour;
    CalendarWithTime.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28;
    if (!(y<=9999 && y >= 1000 && parseInt(m, 10)>0 && parseInt(m, 10)<13 && parseInt(d, 10)>0)){
        alert("�Բ����������˴�������ڣ�");
        CalendarWithTime.thisYear   = new Date().getFullYear();
        CalendarWithTime.thisMonth  = new Date().getMonth()+ 1;
        CalendarWithTime.thisDay    = new Date().getDate();
    }
    y = CalendarWithTime.thisYear;
    m = CalendarWithTime.thisMonth;
    d = CalendarWithTime.thisDay;
    h = CalendarWithTime.thisHour;
    mi = CalendarWithTime.thisMinute;
    s = CalendarWithTime.thisSecond;
    CalendarWithTime.iframe.yearHead.innerText  = y +" ��";
    CalendarWithTime.iframe.yearMonth.innerText = parseInt(m, 10) +" ��";
	// begin
	if (CalendarWithTime.timeShow)
	{
		CalendarWithTime.iframe.dayHour.innerText  = h +" ʱ";
		CalendarWithTime.iframe.hourMinute.innerText  = mi +" ��";
		CalendarWithTime.iframe.minuteSecond.innerText  = s +" ��";
	}
	// end
    CalendarWithTime.daysMonth[1] = (0==y%4 && (y%100!=0 || y%400==0)) ? 29 : 28; //�������Ϊ29��
    var w = new Date(y, m-1, 1).getDay();
    var prevDays = m==1  ? CalendarWithTime.daysMonth[11] : CalendarWithTime.daysMonth[m-2];
    for(var i=(w-1); i>=0; i--) //������ for ѭ��Ϊ����������Դ������ CalendarWithTime.day����ʽ�� d/m/yyyy
    {
        CalendarWithTime.day[i] = prevDays +"/"+ (parseInt(m, 10)-1) +"/"+ y;
        if(m==1) CalendarWithTime.day[i] = prevDays +"/"+ 12 +"/"+ (parseInt(y, 10)-1);
        prevDays--;
    }
    for(var i=1; i<=CalendarWithTime.daysMonth[m-1]; i++) CalendarWithTime.day[i+w-1] = i +"/"+ m +"/"+ y;
    for(var i=1; i<39-w-CalendarWithTime.daysMonth[m-1]+1; i++)
    {
        CalendarWithTime.day[CalendarWithTime.daysMonth[m-1]+w-1+i] = i +"/"+ (parseInt(m, 10)+1) +"/"+ y;
        if(m==12) CalendarWithTime.day[CalendarWithTime.daysMonth[m-1]+w-1+i] = i +"/"+ 1 +"/"+ (parseInt(y, 10)+1);
    }
    for(var i=0; i<38; i++)    //���ѭ���Ǹ���Դ����д����������ʾ
    {
        var a = CalendarWithTime.day[i].split("/");
        CalendarWithTime.dayObj[i].innerText    = a[0];
        CalendarWithTime.dayObj[i].title        = a[2] +"-"+ appendZero(a[1]) +"-"+ appendZero(a[0]);
        CalendarWithTime.dayObj[i].bgColor      = CalendarWithTime.dayBgColor;
        CalendarWithTime.dayObj[i].style.color  = CalendarWithTime.wordColor;
        if ((i<10 && parseInt(CalendarWithTime.day[i], 10)>20) || (i>27 && parseInt(CalendarWithTime.day[i], 10)<12))
            CalendarWithTime.dayObj[i].style.color = CalendarWithTime.wordDark;
        if (CalendarWithTime.inputDate==CalendarWithTime.day[i])    //�����������������������ϵ���ɫ
        {CalendarWithTime.dayObj[i].bgColor = CalendarWithTime.darkColor; CalendarWithTime.dayObj[i].style.color = CalendarWithTime.lightColor;}
        if (CalendarWithTime.day[i] == CalendarWithTime.today)      //���ý����������Ϸ�Ӧ��������ɫ
        {CalendarWithTime.dayObj[i].bgColor = CalendarWithTime.todayColor; CalendarWithTime.dayObj[i].style.color = CalendarWithTime.lightColor;}
    }
}
function returnCalendar() //�������ڸ�ʽ�ȷ����û�ѡ��������
{
    if(CalendarWithTime.objExport)
    {
        var returnValue;
        var a = (arguments.length==0) ? CalendarWithTime.day[this.id.substr(11)].split("/") : arguments[0].split("/");
        var d = CalendarWithTime.format.match(/^(\w{4})(-|\/)(\w{1,2})\2(\w{1,2})$/);
        if(d==null){alert("���趨�����������ʽ���ԣ�\r\n\r\n�����¶��� CalendarWithTime.format ��"); return false;}
        var flag = d[3].length==2 || d[4].length==2; //�жϷ��ص����ڸ�ʽ�Ƿ�Ҫ����
        returnValue = flag ? a[2] +d[2]+ appendZero(a[1]) +d[2]+ appendZero(a[0]) : a[2] +d[2]+ a[1] +d[2]+ a[0];
        CalendarWithTime.objExport.value = returnValue;
        hiddenCalendarTime();
    }
}
function clearCalendar(){
    if(CalendarWithTime.objExport){
    	CalendarWithTime.objExport.value = "";
    	hiddenCalendarTime();
    }
}

document.onclick=function()
{
     if(CalendarWithTime.eventSrc != window.event.srcElement) hiddenCalendarTime();
}

//-->
