var TabPageFramework = {

	/**
	*�������ݽṹ  
	*
	*tabPageName:tabҳ��ǩ����
	*viewDivId:չ��div ID
	*callBackFunc:�ص��������ƣ�Ŀǰ��֧�ֲ�����
	*isRefresh:�Ƿ�ÿ��ˢ��ҳ�� true or false default true;
	*isInit���Ƿ��״μ��� true or false default false;
	*loaded: �Ƿ��Ѿ����� 
	*initDisplay :�Ƿ��ʼ��ʾ
	**/
	createTabPageInfo:function(tabPageName,viewDivId,callBackFunc,isRefresh,isInit,initDisplay){
		var tabPageInfo = new Object();
		
		tabPageInfo.tabPageName = tabPageName;
		tabPageInfo.viewDiv = viewDivId;
		tabPageInfo.callBackFunc = callBackFunc;
		tabPageInfo.refresh = isRefresh;
		tabPageInfo.init = isInit;
		tabPageInfo.loaded = false;
		tabPageInfo.initDisplay = initDisplay;
		
		//ˢ��Ĭ��ֵΪtrue
		if((isRefresh !== true) && (isRefresh !== false) ){
			tabPageInfo.refresh = true;
		}
		//�Ƿ��ʼ����Ĭ��ֵΪfalse
		if((isInit !== true) && (isInit !== false) ){
			tabPageInfo.init = false;
		}
		//�Ƿ��ʼ��ʾ
		if((initDisplay !== true) && (initDisplay !== false) ){
			tabPageInfo.initDisplay = false;
		}
		//��ǩ��������Ĭ�Ϸ���
		if((null === callBackFunc) || (undefined === callBackFunc) || ("" === callBackFunc)){
			tabPageInfo.callBackFunc = TabPageFramework._doNothing;
		}
		
		return tabPageInfo;
	},

	/**
	*����Tabҳ�ķ��� 
	*/
	createTabPage:function(outerDivId,tabPageInfoArr,ctlLayout){

		var outerDiv = $(outerDivId);
	    //����ϴλ���
		outerDiv.innerHTML="";       
		var tabTableId = outerDivId+'tabPageTable';
		var _viewId = outerDivId+'_viewId';
		var tableHtml = '<table style="width:100%;border:0px" cellpadding="0" cellspacing="0" > ';
		tableHtml +=		'<tr>';
		tableHtml +=			'<td align="left">';
		tableHtml +=				'<table id="'+ tabTableId+'" cellpadding="0" cellspacing="0">';
		tableHtml +=				'</table>';
		tableHtml +=			'</td>';
		tableHtml +=		'</tr>';
		tableHtml +=        '<tr>';
		tableHtml +=			'<td align="left">';
		tableHtml +=				'<div id="'+_viewId+'"/>';
		tableHtml +=			'</td>';
		tableHtml +=        '</tr>';
		tableHtml +=	'</table>';
		var view_DIV = document.createElement("div");
		view_DIV.innerHTML = tableHtml;
		outerDiv.appendChild(view_DIV);
		var tabPageTable = $(tabTableId);
		//��Ҫ��������tabҳ
		var len = tabPageInfoArr.length;
		var tr = document.createElement("tr");
		
		for(i = 0 ; i < len ; i++){
			td = TabPageFramework.createTd('L',false);
			tr.appendChild(td);
			td = TabPageFramework.createTd("M",false,tabPageInfoArr[i].tabPageName);
			Event.observe(td, 'click', TabPageFramework.tabChangeHandler.bindAsEventListener("replaceObj",view_DIV,tabPageTable,i,tabPageInfoArr));
			tr.appendChild(td); 
			td = TabPageFramework.createTd('R',false);
			tr.appendChild(td);
		}
		tabPageTable.tBodies[0].appendChild(tr);
		
		//�Ƿ��ɿ�ܿ��Ʋ���
		if(ctlLayout !== true && ctlLayout !== false){
			ctlLayout = true;
		}
		//��չ��div apppend����
		if(ctlLayout){
			for(var i = 0 ; i < tabPageInfoArr.length ; i++){
				var viewDiv = $(tabPageInfoArr[i].viewDiv);
				$(_viewId).appendChild(viewDiv);
			}
		}
		TabPageFramework.initTabPage(tabPageTable,tabPageInfoArr);
	},

	/**
	*tabҳclick�¼���������
	*��;�ǿ�����ʾ��ʽ���Լ�ˢ�ºͲ�ˢ�µĵȿ������⣬ʵ�ʵĲ�����������Ĵ��������൱��һ��action
	*���������
	*/
	tabChangeHandler:function (e){
		var paras = $A(arguments);	
		var outerDiv = paras[1];
		var table = paras[2];
		var num = paras[3];
		var tagPageInfoArr = paras[4];
		//�����ѯ��(��num��tabҳ�Ĳ�ѯ)
		var tabPageInfo = tagPageInfoArr[num];
		var tabPageDiv = $(tabPageInfo.viewDiv);
		var refresh = tabPageInfo.refresh;
		var loaded = tabPageInfo.loaded;
		var innerHTML = tabPageDiv.innerHTML;
		var retFlag = true;
		//���ˢ�£�����ѯ����
		if(refresh){
			retFlag = tabPageInfo.callBackFunc.apply("replaceObj",$A(arguments));
		}else{
				//�������ÿ��ˢ�£���ֻ��ѯһ�� 
				if(!loaded){
					retFlag = tabPageInfo.callBackFunc.apply("replaceObj",$A(arguments));
					tabPageInfo.loaded=true;
				}
		}
		//�ص���������ȷ����false����Ĭ��Ϊ�ɹ�ִ�У����ø�ʽ���ƺ���
		if(retFlag != false){
			retFlag = true;
		}
		if(retFlag){
			//������ʾ��ʽ
			TabPageFramework.changeStyle(outerDiv,table,num,tagPageInfoArr);
		}
		
		retFlag = true; //����ֵ�ó�ֵ
	},

	/*
	*����td
	*
	*postion : L,M,R
	*curr:��ǰ�Ƿ�ѡ�� true,false 
	*/
	createTd:function(position,curr,text){
		var td = null;
		if(position == 'L'){
			td = document.createElement("td");
			if(curr){
				td.className = "left1";
			}else{
				td.className = "left2";
			}
		}
		if(position == 'M'){
			td = document.createElement("td");
			var innerText = document.createTextNode(text);
			td.appendChild(innerText);
			if(curr){
				td.className="middle1";
			}else{
				td.className="middle2";
			}
		}
		if(position == 'R'){
			td = document.createElement("td");
			if(curr){
				td.className = "right1";
			}else{
				td.className = "right2";
			}
		}
		return td;
	},

	/*
	*
	*������ʾ��ʽ
	*outerDiv������ʱδʹ��
	*
	*/
	changeStyle:function(outerDiv,table,num,tagPageInfoArr){
		//�ı�չ��div����ʾ���
		for(var i = 0 ; i < tagPageInfoArr.length ; i++){
			var tabPageInfo = tagPageInfoArr[i];
			var viewDiv = $(tabPageInfo.viewDiv);
			var displayDiv;
			if(i == num){
				displayDiv = viewDiv;
			}else{
				viewDiv.style.display = "none";
			}
		}
		displayDiv.style.display = "block";
		//�ı�tabҳ����ʽ����������
		 var currPos = eval((num+1)*3-2);
		 var c=table.cells;
		  for(var i=1 ; i<c.length ; i+=3){
				 if(c[i].className=="middle1"){
					if(currPos != i ){
						c[i].className="middle2";
						c[i-1].className="left2";
						c[i+1].className="right2";
						break;
					}
				  }
			}
			c[currPos].className = "middle1";
			c[currPos-1].className = "left1";
			c[currPos+1].className = "right1";
	 },

	/**
	*init������1.Ĭ�ϵ�һ��tabҳҪ��ѯ������ʾ������İ�init��initDiplay�����Ƿ��ѯ����ʾ
	*
	*/
	initTabPage:function(tabPageTable,tagPageInfoArr){
		var displayNum = 0;
		for(var i = 0 ; i < tagPageInfoArr.length ; i++){
			var tabpageInfo = tagPageInfoArr[i];
			var init = tabpageInfo.init;
			var initDisplay = tabpageInfo.initDisplay;
			
			//��ʼ����(��ʼ��ʾ��Ĭ��Ϊ��ʼ����)
			if(init || initDisplay){
				tagPageInfoArr[i].callBackFunc.apply("replaceObj",$A(arguments));
				tagPageInfoArr[i].loaded=true;
			}
			//��ʼ��ʾ
			if(initDisplay){
				displayNum = i;
			}
		}
		var loaded = tagPageInfoArr[displayNum].loaded;
		if(!loaded){
			var func = tagPageInfoArr[displayNum].callBackFunc;
			func.apply("replaceObj",$A(arguments));
			tagPageInfoArr[displayNum].loaded = true;
		}
		TabPageFramework.changeStyle('',tabPageTable,displayNum,tagPageInfoArr);
	},
	
	/**
	*Ĭ�ϵĻص�������ʲôҲ����������tabҳ����¼������κδ�������
	*һ�����ڸ�tabҳ�ļ���ͬʱ��ʼ��ʱ��ɣ��ҵ��tabҳʱ��������ˢ�£�
	*ֻ�ǿ�����ʾ�Ϳ����ˡ�
	*/
	_doNothing:function(){
		return true;
	}
}

 