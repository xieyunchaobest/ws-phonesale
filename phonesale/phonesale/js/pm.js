/***************************************************************
*
*��Ʒ������ϵͳPM���õ���ȫ��JS����������ҳ��У�飩
*��Ҫ���public.js��prototype.jsʹ��
*��JS������Ʒ������ϵͳPMʹ��
*author:longtao
***************************************************************/


/*��Ʒ������ϵͳ���÷���----START*/

function MM_preloadImages() { //v3.0
  	var d=document; 
  	if(d.images){ 
  		if(!d.MM_p) d.MM_p=new Array();
    	var i,j=d.MM_p.length,a=MM_preloadImages.arguments; 
    	for(i=0; i<a.length; i++){
    		if (a[i].indexOf("#")!=0){ 
    			d.MM_p[j]=new Image; 
    			d.MM_p[j++].src=a[i];
    		}
    	}
    }
}

function MM_swapImgRestore() { //v3.0
  	var i,x,a=document.MM_sr; 
  	for(i=0;a&&i<a.length&&(x=a[i])&&x.oSrc;i++){ 
  		x.src=x.oSrc;
  	}
}

function MM_findObj(n, d) { //v4.01
  	var p,i,x;
  	if(!d) d=document; 
  	if((p=n.indexOf("?"))>0&&parent.frames.length) {
    	d=parent.frames[n.substring(p+1)].document; 
    	n=n.substring(0,p);
    }
  	if(!(x=d[n])&&d.all) x=d.all[n]; 
  	for (i=0;!x&&i<d.forms.length;i++) 
  		x=d.forms[i][n];
  	for(i=0;!x&&d.layers&&i<d.layers.length;i++) 
  		x=MM_findObj(n,d.layers[i].document);
  	if(!x && d.getElementById) 
  		x=d.getElementById(n); return x;
}

function MM_swapImage() { //v3.0
  	var i,j=0,x,a=MM_swapImage.arguments; 
  	document.MM_sr=new Array; 
  	for(i=0;i<(a.length-2);i+=3){
   		if ((x=MM_findObj(a[i]))!=null){
   			document.MM_sr[j++]=x; 
   			if(!x.oSrc) x.oSrc=x.src; 
   			x.src=a[i+2];
   		}
   	}   	
}


var XForm = Class.create();
XForm.prototype = {
	initialize : function(/*Form*/ form){
		this._form = form;
	},
	addParam : function(/*object*/ options){
		for(name in options){
			if(options[name] instanceof Array){
				$A(options[name]).each(function(value,index){
					this._addParam(name,value);
				}.bind(this));
			}else{
				this._addParam(name,options[name]);
			}
		}
	},
	_addParam : function( /*String*/ name, /*String*/ value){
		if(this._form[name]){
			this._form[name].value = value;
		}else{
			var paramObj = document.createElement("input");
			paramObj.type="hidden";
			paramObj.name = name;
			paramObj.value = value;
			this._form.appendChild(paramObj);
		}
	},
	submit : function(){
		this._form.submit();
	}
};

/***************************************************************
* ��ȡ������б���ѡ�еļ�¼�ı��:����ID������Ҫ���ӵļ�¼�ı��
* ������ checkBoxName:��ѡ������
* ���أ� Array : ��Ҫ���ӵļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getToAddArray(checkBoxName){
	var toAddArray = new Array();
	var checkIds = document.getElementsByName(checkBoxName);
	var size = checkIds.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
			if(checkIds[i].checked){
				toAddArray[position] = checkIds[i].value;
				position++;
			}
		}
	}

	return toAddArray;
}

/***************************************************************
* ��ȡ���Ҳ��б��Ѵ��ڵļ�¼�ı��:����ID�������ݿ������еļ�¼�ı��
* ������ hiddenName:����������
* ���أ� Array : ���ݿ������еļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getExistArray(hiddenName){
	var existArray = new Array();
	var hiddenIds = document.getElementsByName(hiddenName);
	var size = hiddenIds.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
				existArray[position] = hiddenIds[i].value;
				position++;
		}
	}

	return existArray;
}

/***************************************************************
* ��ȡ���Ҳ��б���ѡ�еļ�¼�ı��:����ID������Ҫɾ���ļ�¼�ı��
* ������ checkBoxName:��ѡ������
* ���أ� Array : ��Ҫɾ�����߸��µļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getRemoveArray(checkBoxName){
	var removeArray = new Array();
	var checkIds = document.getElementsByName(checkBoxName);
	var size = checkIds.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
			if(checkIds[i].checked){
				removeArray[position] = checkIds[i].value;
				position++;
			}
		}
	}

	return removeArray;
}

/***************************************************************
* ��ȡ���Ҳ��б���ѡ�еļ�¼�ı��:����ID������Ҫɾ���ļ�¼�ı��
* ������ removeArray����ѡ�ļ�¼��suffix������id�ĺ�׺��
*       yesValue�ɲ����ļ�¼���������ֵ
* ���أ� Array : �ܱ�ɾ���ļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getTargetRemoveArray(removeArray,suffix,yesValue){
	var targetRemoveArray = new Array();
	var size = removeArray.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
			var temp = removeArray[i]+suffix;
			if(document.getElementById(temp).value == yesValue){
				targetRemoveArray[position] = removeArray[i];
				position++;
			}
		}
	}

	return targetRemoveArray;
}

/***************************************************************
* ��ȡ��Ȩ�����ļ�¼�ı��
* ������ removeArray����ѡ�ļ�¼��suffix������id�ĺ�׺��
*       yesValue�ɲ����ļ�¼���������ֵ
* ���أ� Array : ���ܱ�ɾ���ļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getUngrantedArray(removeArray,suffix,yesValue){
	var ungrantedArray = new Array();
	var size = removeArray.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
			var temp = removeArray[i]+suffix;
			if(document.getElementById(temp).value != yesValue){
				ungrantedArray[position] = removeArray[i];
				position++;
			}
		}
	}

	return ungrantedArray;
}

/***************************************************************
* ��ȡ���Ҳ��б���ѡ�еļ�¼�ı��:����ID������Ҫ���µļ�¼�ı��
* ������ checkBoxName:��ѡ������
* ���أ� Array : ��Ҫɾ�����߸��µļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getUpdateArray(checkBoxName){
	var updateArray = new Array();
	var checkIds = document.getElementsByName(checkBoxName);
	var size = checkIds.length;
	if(size > 0){
		var position = 0;
		for(var i = 0;i < size;i++){
			if(checkIds[i].checked){
				updateArray[position] = checkIds[i].value;
				position++;
			}
		}
	}

	return updateArray;
}

/***************************************************************
* ��ȡ���������е��ظ���¼�ı��:����ID����ʾ�û��ظ���¼�ı��
* ������ resArray:Դ���飬��������б���ѡ�еļ�¼
* ������ desArray:Ŀ�����飬�����Ҳ��б��еļ�¼�������ݿ������еļ�¼
* ���أ� Array : �ظ��ļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getRepeatArray(resArray,desArray){
	var repeatArray = new Array();
	var position = 0;
	var repeatFlag = false;

	if(desArray.length == 0){//���ݿ�����û���κμ�¼����Ȼ�������ظ��ļ�¼
		return desArray;
	}

	for(var i=0;i<resArray.length;i++){
		for(var j=0;j<desArray.length;j++){
			if(resArray[i] == desArray[j]){
				repeatFlag = true;				
			}
		}
		if(repeatFlag){
			//�����ظ���¼����������
			repeatArray[position] = resArray[i];
			position++;
		}
		repeatFlag = false;
	}

	return repeatArray;
}

/***************************************************************
* ��ȡ��Դ���������Ŀ�������еļ�¼�ı�ţ�����Ҫ���ӵļ�¼�ı��
* ������ resArray:Դ���飬��������б���ѡ�еļ�¼
* ������ desArray:Ŀ�����飬�����Ҳ��б��еļ�¼�������ݿ������еļ�¼
* ���أ� Array : �����ļ�¼�ı����ɵ�һ��һά����
*****************************************************************/
function getInsertArray(resArray,desArray){
	var insertArray = new Array();
	var position = 0;
	var insertFlag = true;

	if(desArray.length == 0){//���ݿ�����û���κμ�¼����ȻԴ�������Ҫ���ӵļ�¼�ı��
		return resArray;
	}

	for(var i=0;i<resArray.length;i++){
		for(var j=0;j<desArray.length;j++){
			if(resArray[i] == desArray[j]){
				insertFlag = false;				
			}
		}
		if(insertFlag){
			//�����µļ�¼����������
			insertArray[position] = resArray[i];
			position++;
		}
		insertFlag = true;
	}

	return insertArray;
}

/***************************************************************
* �ж�Դ��¼����Ƿ���Ŀ�ļ�¼��������д���
* ������ resRecordId:Դ��¼��ţ�������������ѡ���һ����¼
* ������ desArray:Ŀ�ļ�¼������飬�����Ҳ��б��еļ�¼�������ݿ������еļ�¼
* ���أ� true or false : �����򷵻�true�����򷵻�false
*****************************************************************/
function getRepeatFlag(resRecordId,desArray){
	var size = desArray.length;
	if( size == 0){
		return false;
	}

	for(var i=0;i<size;i++){
		if(desArray[i] == resRecordId){
			return true;
		}
	}

	return false;
}

function getDataNoCache(url,obj){
	var options={
		method: 'get',
		asynchronous: false,
		requestHeaders:["Cache-Control","no-cache"],
		onComplete: function(request){
			var resultHTML = request.responseText;									
			$(obj).innerHTML = resultHTML;						
		}
	}	
				  
	new Ajax.Request(url+"&timestamp="+new Date().getTime(),options); 
}

function queryStart(qryTR){
	var qryTRTable = document.getElementById(qryTR);
	qryTRTable.style.display="block";
}

function queryCancle(qryTR){
	var qryTRTable = document.getElementById(qryTR);
	qryTRTable.style.display="none";
}

/***************************************************************
* 
* չ�����ڲ�ѯ�Ĳ㣬�������㶨λ��ĳԪ����
* ������ qryTR:���ڲ�ѯ�Ĳ�ID��focusName:��Ҫ��λ�����Ԫ������
* ���أ� 
*****************************************************************/
function queryStart(qryTR,focusName){
	var qryTRTable = document.getElementById(qryTR);
	qryTRTable.style.display="block";
	var focusElement = document.getElementsByName(focusName)[0];
	focusElement.focus();
}

/***************************************************************
* 
* У���¼�Ƿ��ܱ�����
* ������url 
* ���أ� "true" or "false"
*****************************************************************/
function validateOperate(url){
var resultHTML ="";
	var options={
		method: 'get',
		asynchronous: false,
		requestHeaders:["Cache-Control","no-cache"],
		onComplete: function(request){
			resultHTML = request.responseText;								
		}
	}				  
	new Ajax.Request(url,options); 
	
	return 	resultHTML;	
}

/***************************************************************
* 
* ִ��ȫѡ/ȫ��ѡ�Ĺ���
* ������parentCheckBox--"ȫѡ"��ѡ�����ƣ�childCheckBox--"��"��ѡ������ 
* ���أ� 
*****************************************************************/
function allChecked(parentCheckBox,childCheckBox){
	var parent = document.getElementsByName(parentCheckBox);
	var child = document.getElementsByName(childCheckBox);
	for(var i=0,size=child.length;i<size;i++){
		child[i].checked = parent[0].checked;
	}
}

/***************************************************************
* 
* ִ�������ѡ�Ĺ���
* ������parentCheckBox--"ȫѡ"��ѡ�����ƣ�childCheckBox--"��"��ѡ������
* ���أ� 
*****************************************************************/
function allUnChecked(parentCheckBox,childCheckBox){
	var parent = document.getElementsByName(parentCheckBox);
	var child = document.getElementsByName(childCheckBox);
	parent[0].checked = false;
	for(var i=0,size=child.length;i<size;i++){
		child[i].checked = false;
	}
}

/***************************************************************
* 
* ִ�л�ȡ�Ƿ��в���Ȩ�޵Ĺ���
* ������hiddenElement--ҳ��������Ԫ��ID��value--У��ֵ
* ˵��������������ֵ�봫���valueֵ�����˵�����в���Ȩ��
* ���أ�true or false
*****************************************************************/
function checkRight(hiddenElement,value){
	var srcValue = document.getElementById(hiddenElement).value;
	if(srcValue == value){
		return true;
	}else{
		alert("��û�в����ü�¼��Ȩ��");
		return false;
	}
}

/***************************************************************
* 
* ִ���û����߱�����ĳ��¼��Ȩ��ʱ�Ƿ����������һ���Ĺ���
* ������elementValue--����ֵ��judgeValue--��׼ֵ
* ˵�����������ֵ�봫��Ļ�׼ֵ�����˵�����в���Ȩ��
* ���أ�true or false
*****************************************************************/
function checkStillContinue(element,value){
	if(element == value){
		return true;
	}else{
		if(confirm("��ֻ�в鿴�������Ϣ��Ȩ��,û���޸��������Ϣ��Ȩ��,ȷ��������?")){
			return true;
		}else{
			return false;
		}
	}
}

/***************************************************************
* 
* ִ��+/-ǰ�ļ��ж�
* ������selectedArray:ѡ��ɾ���ļ�¼���ɵ�����
* ������type:��ʶ��+��-�����޸ģ�0Ϊ-��1Ϊ+������Ϊ�޸�
* ˵�������ж��Ƿ�ѡ���˼�¼
* ���أ�true or false
*****************************************************************/
function checkSelectLength(selectedArray,type){
	if(selectedArray.length == 0){
		if(type == 0){
			alert("��ѡ����Ҫɾ���ļ�¼");
		}else if(type == 1){
			alert("��ѡ����Ҫ��ӵļ�¼");
		}else{
			alert("��ѡ����Ҫ���õļ�¼");
		}
		return false;
	}else{
		return true;
	}
}

/***************************************************************
* 
* ִ�����ǰ�ļ��ж�
* ������repeatArray:������ʾ����ʾ�ظ��ļ�¼
* ˵����������ʾ����ʾ�ظ��ļ�¼
* ���أ�true or false
*****************************************************************/
function alertRepeat(repeatArray){
	if(repeatArray.length > 0){
		alert("��¼��"+repeatArray+"�Ѿ�����");
	}
}

/***************************************************************
* 
* ִ���¼�¼���ύ
* ������resArray:׼����ӵļ�¼
* ������desArray:����ȫ���ļ�¼
* ˵�������ж��Ƿ�ѡ���˼�¼
* ���أ�true or false
*****************************************************************/
function commitAdd(resArray,desArray){
	var repeatArray = getRepeatArray(resArray,desArray);
	var insertArray = getInsertArray(resArray,desArray);			
	if(repeatArray.length > 0){
		alert("��¼��"+repeatArray+"�Ѿ�����");
	}
	if(insertArray.length>0&&confirm("��ȷ��Ҫ�����ѡ�ļ�¼?")){
		return true;
	}else{
		return false;
	}
}

/***************************************************************
* 
* ִ�оɼ�¼���ύ
* ������deleteArray:׼��ɾ���ļ�¼
* ˵�������ж��Ƿ�ѡ���˼�¼
* ���أ�true or false
*****************************************************************/
function commitDel(deleteArray){
	if(deleteArray.length == 0){
		alert("��ѡ����Ҫɾ���ļ�¼");
		return false;
	}
	if(deleteArray.length > 0 && confirm("��ȷ��Ҫɾ����ѡ�ļ�¼?")){
		return true;
	}else{
		return false;
	}
}

/***************************************************************
* 
* ִ�м�¼��ɾ����У��
* ������deleteArray:׼��ɾ���ļ�¼
* ������valiUrl
* ˵�������ж��Ƿ�ѡ���˼�¼,��У���Ƿ��ܹ�ɾ����¼
* ���أ�true or false
*****************************************************************/
function commitValiDel(deleteArray,valiUrl){
	if(deleteArray.length == 0){
		alert("��ѡ����Ҫɾ���ļ�¼");
		return false;
	}
	if(validateOperate(valiUrl)== "false"){
		alert("��¼����ʹ����.....����ɾ��");
		return false;
	}else{
		if(confirm("��ȷ��Ҫɾ����ѡ�ļ�¼?")){
			return true;
		}else{
			return false;
		}
	}
}

/***************************************************************
* 
* ִ�м�¼�����Ƶ�У��
* ������valiUrl
* ������errorString
* ˵�������ж������Ƿ�ʹ��
* ���أ�true or false
*****************************************************************/
function nameUsedVali(valiUrl,errorString){
	if(isEmpty(errorString)){	
		if(validateOperate(valiUrl)== "false"){
			alert("�����ظ�...����������");
			return false;
		}else{
			return true;
		}
	}else{
		alert(errorString);
		return false;
	}
}

/***************************************************************
* 
* ִ�м�¼�����Ƶ�У��
* ������valiUrl
* ������errorString
* ������originName
* ������name
* ˵�������ж������Ƿ�ʹ��
* ���أ�true or false
*****************************************************************/
function nameUsedVali2(valiUrl,errorString,originName,name){
	if(isEmpty(errorString)){
		if(originName == name){
			return true;
		}else{
			if(validateOperate(valiUrl)== "false"){
				alert("�����ظ�...����������");
				return false;
			}else{
				return true;
			}
		}
	}else{
		alert(errorString);
		return false;
	}
}

/***************************************************************
* 
* ִ�н�������Ҽ�
* ������
* ���أ�
*****************************************************************/
function disableMouseRight(){
	document.oncontextmenu=new Function("event.returnValue=false;");
	document.onselectstart=new Function("event.returnValue=false;");
}

/***************************************************************
* 
* ִ�����ظ�ҳ���е�ĳԪ��
* ������elementId��ҳ��Ԫ�ص�ID
* ���أ�
*****************************************************************/
function hideFatherElement(elementId){
	var addTable = self.parent.document.getElementById(elementId);
	addTable.style.display="none";
}

/***************************************************************
* 
* ִ��У���Ƿ������˲�ѯ����
* ��������ѯԪ�ص�����
* ���أ�true or false
*****************************************************************/
function hasFillName(elementName){
	var queryName = document.getElementsByName(elementName)[0];
	var name = trim(queryName.value);
	if(isEmpty(name)){
		alert("�������ѯ����");
		queryName.focus();
		return false;
	}else{
		return true;
	}
}

/***************************************************************
* 
* �жϿ��ܰ������ֵ�STRING�ĳ����Ƿ񳬳����ݿ�����
* ������str��У����ַ���length���ݿ��еĳ���textName�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function checkCNStrLen(str,length,textName){
	var msg = "";
	if(str.length > 0){
		if(!checkCN(str,length)){
			msg = textName + "���ܳ���" + length + "���ַ�\n";
		}
	}
	
	return msg;
}

/***************************************************************
* 
* �ж�String�Ƿ�Ϊ�ջ��߿հ״�,Ϊ�ջ��߿հ״��򷵻ش�����ʾ
* ������str��У����ַ���textName�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function checkBlankStr(str,textName){
	var msg = "";
	if(isEmpty(str)){
		msg = textName + "����Ϊ��\n";
	}
	return msg;
}

/***************************************************************
* 
* �жϱ�ѡ�������Ƿ��Ѿ�ѡ���ֵ
* ������optionValue�������ֵalertValue����ͨ��У���ֵtextName�����������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function checkSelectOption(optionValue,alertValue,textName){
	var msg = "";
	if(optionValue == alertValue){
		msg = "��ѡ��" + textName + "\n";
	}
	
	return msg;
}

/***************************************************************
* 
* ��������б����ѡ����ѡ���Ƿ�Ĭ��ѡ��
* ������ str:ѡ���ѡ��,cStr:Ĭ��ѡ��
* ���أ� true:ѡ���ѡ�����Ĭ��ѡ��  false:ѡ���ѡ�����Ĭ��ѡ��
*****************************************************************/
function checkSelect(str,cStr){
	if(str == cStr){
		return true;
	}else{
		return false;
	}
}

/***************************************************************
* 
* �ж��ַ����Ƿ�Ϊ�Ϸ����������룬�����Ƿ���
* ������str��У����ַ���ֵlength��󳤶�����textName�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function checkInt(str,length,textName){
	var msg = "";
	if(str != ""){
		if(!checkTheLetter(str,1)){//����У�������Ƿ�ȫΪ����
			msg = textName + "ֻ��Ϊ�Ϸ�����\n"
		}else{
			var intStr = parseInt(str,10);
			if(isNaN(intStr)){
				msg = textName + "ֻ��Ϊ�Ϸ�����\n"
			}else{
				var intLength = parseInt(trim(length),10);
				if(intStr.length > intLength.length){
					msg = textName + "�ĳ��Ȳ��ܳ���" + length +"λ\n"
				}
			}
		}
	}
	
	return msg;
}

/***************************************************************
* 
* �Ƚ���������������ַ����Ĵ�С��Ҫ��str1������str2
* ������str1��str2��У����ַ���ֵtextName1��textName2�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function compareInt(str1,str2,textName1,textName2){
	var msg = "";
	if(!isEmpty(str1) && !isEmpty(str2)){
		var int_str1 = parseInt(trim(str1),10);
		var int_str2 = parseInt(trim(str2),10);
		if(!isNaN(int_str1) && !isNaN(int_str2)){
			if(int_str1 > int_str2){
				msg = textName1 + "���ܴ���" + textName2;
			}
		}
	}
	
	return msg;
}

/***************************************************************
* 
* �ж��ַ����Ƿ�Ϊ�Ϸ��ĸ��������룬�����Ƿ���
* ������str��У����ַ���ֵintLength����λ��󳤶�����
*     decLengthС��λ��󳤶����� textName�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function checkFloat(str,intLength,decLength,textName){
	var msg = "";
	var formatMsg = textName + "���벻�Ϸ�\n���Ϸ�����֧�֣�" + intLength + "λ����+" + decLength + "λС����\n";
	if(str != ""){
		var splitArray = str.split(".");
		var len = splitArray.length;
		if(len == 1){//����Ϊ����
			var tempMsg = checkInt(str,intLength,textName);
			if(tempMsg != ""){
				msg = formatMsg;
			}
		}else if(len == 2){//С����ʽ����
			var intStr = splitArray[0];//��������
			var decStr = splitArray[1];//С������
			if(intStr.length == 0){//��.��ʼ�Ĵ�С��������������
				msg = formatMsg;
			}else if(decStr.length == 0){//��.�����Ĵ�����������������
				msg = formatMsg;
			}else{//����С������������������
				var tempMsg = checkInt(intStr,intLength,textName);
				if(tempMsg != ""){//����У����������
					msg = formatMsg;
				}else{//����У��С������
					if(!checkTheLetter(decStr,1)){//У�������Ƿ�ȫΪ����
						msg = formatMsg;
					}else{//��У�鳤������
						if(decStr.length > decLength){
							msg = formatMsg;
						}
					}
				}
			}			
		}else{
			msg = formatMsg;
		}
	}
	
	return msg;
}

/***************************************************************
* 
* �ж��������ڵĴ�С����Чʱ�䲻�ܴ���ʧЧʱ��
* ������str1,str2��У����ַ���ֵtextName1,textName2�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function compareDateStr(str1,str2,textName1,textName2){
	var msg = "";//str1Ϊ��ʼ���ڣ�str2Ϊ��ֹ����
	if(!isEmpty(str1) && !isEmpty(str2)){
		if(!dateCompare(str1,str2)){
			msg = textName1 + "���ܴ���" + textName2 + "\n";
		}
	}
	
	return msg;
}

/***************************************************************
* 
* �Ƚϸ���������������ַ����Ĵ�С��Ҫ��str1������str2
* ������str1��str2��У����ַ���ֵtextName1��textName2�ı��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function compareFloat(str1,str2,textName1,textName2){
	var msg = "";
	if(!isEmpty(str1) && !isEmpty(str2)){
		var float_str1 = parseFloat(trim(str1),10);
		var float_str2 = parseFloat(trim(str2),10);
		if(!isNaN(float_str1) && !isNaN(float_str2)){
			if(float_str1 > float_str2){
				msg = textName1 + "���ܴ���" + textName2;
			}
		}
	}
	
	return msg;
}
/*��Ʒ������ϵͳ���÷���----END*/


/*��Ʒ������ϵͳ��ģ�����ҳ��У�鷽��----START*/

/***************************************************************
* 
* Ŀ¼����ģ�飺ͨ�ŷ���Ŀ¼������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiCommServSpecTree(){
	var errorString = "";
	//ͨ�ŷ������ڵ����ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"Ŀ¼����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"Ŀ¼����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	
	return errorString;
}

/***************************************************************
* 
* Ŀ¼����ģ�飺������ԴĿ¼������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiResourceSpecTree(){
	var errorString = "";
	//������Դ���ڵ����ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"Ŀ¼����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"Ŀ¼����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	
	return errorString;
}

/***************************************************************
* 
* Ŀ¼����ģ�飺��ƷĿ¼������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiProdTree(){
	var errorString = "";
	//��Ʒ���ڵ����ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"Ŀ¼����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"Ŀ¼����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}	
	return errorString;
}

/***************************************************************
* 
* ������Ϣ����ģ�飺���Ի�����Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiCharacteristic(){
	var errorString = "";			
	//�������ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)--%>			
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//�������ͱ�ʶ(����Ϊ��ѡ��,dataType)--%>
	var dataType = document.getElementById("dataType");	
	errorString = errorString + checkSelectOption(dataType.value,"X","��������");
	//����ֵ����(����Ϊ��ѡ��,valueType)--%>
	var valueType = document.getElementById("valueType");
	errorString = errorString + checkSelectOption(valueType.value,"X","����ֵ����");				
	if(valueType.value == "D"){
		//����ֵ����Ϊ��ɢѡ����ʱ����������ֻ��Ϊ�ַ����ͻ���������--%>
		if(dataType.value == "VA"||dataType.value == "N"){
			//��ȷ������--%>
		}else{
			//�Ƿ�������--%>
			errorString = errorString + "����ֵ����Ϊ��ɢѡ����ʱ����������ֻ��Ϊ�ַ����ͻ��������� \n";
		}
	}
	//��ʼֵ(varchar2(10))--%>
	var fromValue = document.getElementById("fromValue");
	errorString = errorString + checkCNStrLen(fromValue.value,10,"��ʼֵ");
	var toValue = document.getElementById("toValue");
	errorString = errorString + checkCNStrLen(toValue.value,10,"��ֵֹ");
	//Ĭ��ֵ(vachar2(10))--%>
	var defaultValue = document.getElementById("defaultValue");
	errorString = errorString + checkCNStrLen(defaultValue.value,10,"Ĭ��ֵ");
	//��׼����(���Ȳ��ܳ���45��standardCode)--%>
	var standardCode = document.getElementById("standardCode");				
	errorString = errorString + checkCNStrLen(standardCode.value,10,"��׼����");
	//����ֵ��󳤶�����(��Ϊ��,ֻ��Ϊ���֣�����λ�����Ϊ6,valueLenLimit)--%>
	var valueLenLimit = document.getElementById("valueLenLimit");
	errorString = errorString + checkInt(valueLenLimit.value,6,"��󳤶�");
	//����ֵ��С��������(��Ϊ��,ֻ��Ϊ���֣�����λ�����Ϊ6,valueLenMinLimit)--%>
	var valueLenMinLimit = document.getElementById("valueLenMinLimit");
	errorString = errorString + checkInt(valueLenMinLimit.value,6,"��С����");
	//��󳤶Ȳ���С����С����--%>
	compareInt(valueLenMinLimit.value,valueLenLimit.value,"��С����","��󳤶�");	
	//����ֵ��������(��Ϊ��,ֻ��Ϊ���֣�����λ�����Ϊ6,valueNumLimit)--%>
	var valueNumLimit = document.getElementById("valueNumLimit");
	errorString = errorString + checkInt(valueNumLimit.value,6,"��������");
	
	return errorString;	
}

/***************************************************************
* 
* ������Ϣ����ģ�飺����ֵ������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiEnumValue(){
	var errorString = "";			
	//����ֵ������Ϊ�գ����Ȳ��ܳ�45,enumValueCode)	--%>		
	var enumValueCode = document.getElementById("enumValueCode");			
	var blankCheckMsg = checkBlankStr(enumValueCode.value,"����ֵ");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(enumValueCode.value,45,"����ֵ");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}		
	//����ֵ����(����Ϊ�� varchar2(45))--%>			
	var enumValueName = document.getElementById("enumValueName");
	var blankCheckMsg2 = checkBlankStr(enumValueName.value,"����ֵ����");
	if(blankCheckMsg2 == ""){
		var lengthCheckMsg = checkCNStrLen(enumValueName.value,45,"����ֵ����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg2;
	}
	
	return errorString;	
}

/***************************************************************
* 
* ͨ�ŷ������ģ�飺ͨ�ŷ��������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiCommServSpec(){
	var errorString = "";
	//ͨ�ŷ������ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//ͨ�ŷ�������(����Ϊ��ѡ��,commServSpecCatId)
	var commServSpecCatId = document.getElementById("commServSpecCatId");
	errorString = errorString + checkSelectOption(commServSpecCatId.value,"X","��������");
	//�����ʶ(����Ϊ��ѡ��,mainFlag)-->
	var mainFlag = document.getElementById("mainFlag");	
	errorString = errorString + checkSelectOption(mainFlag.value,"X","�����ʶ");		
	//�ظ���ʶ(����Ϊ��ѡ��,repFlag)--
	var repFlag = document.getElementById("repFlag");
	errorString = errorString + checkSelectOption(repFlag.value,"X","�ظ���ʶ");	
	//��׼����(���Ȳ��ܳ���30��standardCode)-->
	var standardCode = document.getElementById("standardCode");
	errorString = errorString + checkCNStrLen(standardCode.value,30,"��׼����");	
					
	return errorString;
}

/***************************************************************
* 
* Э�����ģ�飺Э���������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiContractTemplate(){
	var errorString ="";
	//Э�����ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"Э������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"Э������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//Э������(����Ϊ��ѡ��,contractType)--%>
	var contractType = document.getElementById("contractType");	
	errorString = errorString + checkSelectOption(contractType.value,"X","Э������");	
	//����ļ�(���Ȳ��ܳ�60,relFile)
	var relFile = document.getElementById("relFile");
	errorString = errorString + checkCNStrLen(relFile.value,60,"����ļ�·��");
	//Э�����(���Ȳ��ܳ�60,contractTempCode)
	var contractTempCode = document.getElementById("contractTempCode");	
	errorString = errorString + checkCNStrLen(contractTempCode.value,60,"����ļ�·��");
	//ģ������(���Ȳ��ܳ�255,templateDesc);
	var templateDesc = document.getElementById("templateDesc");	
	errorString = errorString + checkCNStrLen(templateDesc.value,255,"����ļ�·��");
				
	return errorString;	
}

/***************************************************************
* 
* Э�����ģ�飺Э��Լ��������Ϣά����ҳ��У��
* ������
* ���أ�
*****************************************************************/
function valiContractTemplateRestrict(){
	var errorString = "";
	//������(����Ϊ��ѡ��,mainFlag)-->
	var servActId = document.getElementById("servActId");
	errorString = errorString + checkSelectOption(servActId.value,"X","������");
	//Լ��ʱ����ֻ��Ϊ���֣�����λ�����6λ,resCycle)
	var resCycle = document.getElementById("resCycle");
	errorString = errorString + checkInt(resCycle.value,6,"Լ��ʱ��");
	//Լ������������Ϊ��,resMethod)
	var resMethod = document.getElementById("resMethod");
	errorString = errorString + checkCNStrLen(resMethod.value,100,"Լ������");
	//Լ������(��Ϊ��,���Ȳ��ܳ�255,resDesc);
	var resDesc = document.getElementById("resDesc");
	errorString = errorString + checkCNStrLen(resDesc.value,255,"Լ������");
				
	return errorString;	
}

/***************************************************************
* 
* Э�����ģ�飺Э��Լ���ͷ�������Ϣά����ҳ��У��
* ������
* ���أ�
*****************************************************************/
function valiContractTemplatePunish(){
	var errorString ="";
	//��λΥԼ��(ֻ��Ϊ���֣�����λ�����6λ,unitPunishFine)
	var unitPunishFine = document.getElementById("unitPunishFine");
	errorString = errorString + checkInt(unitPunishFine.value,6,"��λΥԼ��");
	//����(ֻ��Ϊ���֣�����λ�����6λ,count)
	var count = document.getElementById("count");
	errorString = errorString + checkInt(count.value,6,"����");
	//�ͷ�����(���Ȳ��ܳ�255,punishDescription)			    
	var punishDesc = document.getElementById("punishDesc");
	errorString = errorString + checkCNStrLen(punishDesc.value,255,"�ͷ�����");
				
	return errorString;	
}

/***************************************************************
* 
* Ⱥ�������ģ�飺Ⱥ���������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiGroupSpec(){
	var errorString = "";
	//Ⱥ�������֣�����Ϊ�գ����Ȳ��ܳ�60,name)
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"Ⱥ������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"Ⱥ������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--�漰����ͨ(����Ϊ��ѡ��,pfFlag)--%>
	var pfFlag = document.getElementById("pfFlag");	
	errorString = errorString + checkSelectOption(pfFlag.value,"X","����ͨ��ʶ");
	//--Ⱥ��������ɱ�־(����Ϊ��ѡ��,groupNbrFlag)--%>
	var groupNbrFlag = document.getElementById("groupNbrFlag");	
	errorString = errorString + checkSelectOption(groupNbrFlag.value,"X","�������ɱ�ʶ");
	//--�������(����Ϊ��ѡ��,attchFlag)--%>
	var attchFlag = document.getElementById("attchFlag");
	errorString = errorString + checkSelectOption(attchFlag.value,"X","�������");
	//--Ⱥ���Ƿ�̬����(����Ϊ��ѡ��,autoFlag)--%>
	var autoFlag = document.getElementById("autoFlag");
	errorString = errorString + checkSelectOption(autoFlag.value,"X","��̬���ɱ�ʶ");	
	//--Ⱥ������(����Ϊ��ѡ��,mainFlag)--%>
	var groupTypeId = document.getElementById("groupTypeId");
	errorString = errorString + checkSelectOption(groupTypeId.value,"X","Ⱥ�����ͱ�ʶ");
	//--��ϵ����(����Ϊ��ѡ��,relType)--%>
	var relType = document.getElementById("relType");
	errorString = errorString + checkSelectOption(relType.value,"X","��ϵ���ͱ�ʶ");
	//--��С����(����Ϊ��,minNumber Number(6))--%>
	var minNumber = document.getElementById("minNumber");
	var blankCheckMsg2 = checkBlankStr(minNumber.value,"��С����");
	if(blankCheckMsg2 == ""){
		errorString = errorString + checkInt(minNumber.value,6,"��С����");
	}else{
		errorString = errorString + blankCheckMsg2;		
	}
	
	return errorString;
}
/***************************************************************
* 
* �۸�ƻ�����ģ�飺���۲���������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPriceParam(){
	var errorString = "";
	//--�������ƣ�����Ϊ�գ����Ȳ��ܳ�32,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,32,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--ȡֵ����(����Ϊ��ѡ��,inputFlag)--%>				
	var inputFlag = document.getElementById("inputFlag");	
	errorString = errorString + checkSelectOption(inputFlag.value,"X","ȡֵ����");
	//--��������(����Ϊ��ѡ��,inputType)--%>
	var inputType = document.getElementById("inputType");
	errorString = errorString + checkSelectOption(inputType.value,"X","��������");
	//--��������(����Ϊ��ѡ��,inputFlag)--%>				
	var nullFlag = document.getElementById("nullFlag");	
	errorString = errorString + checkSelectOption(nullFlag.value,"X","�����ʶ");	
	//--Ĭ��ֵ(���Ȳ��ܳ�20,�����������2λС��,defaultValue)--%>
	var defaultValue = document.getElementById("defaultValue");
	var defaultMsg = checkFloat(defaultValue.value,18,2,"Ĭ��ֵ");
	errorString = errorString + defaultMsg;
	//--��ʼֵ(���Ȳ��ܳ�20,�����������2λС��,paramValueFrom)--%>
	var paramValueFrom = document.getElementById("paramValueFrom");
	var fromMsg = checkFloat(paramValueFrom.value,18,2,"��ʼֵ");
	errorString = errorString + fromMsg;
	//--��ֵֹ(���Ȳ��ܳ�20,�����������2λС��,paramValueTo)--%>
	var paramValueTo = document.getElementById("paramValueTo");
	var toMsg = checkFloat(paramValueTo.value,18,2,"��ֵֹ");	
	errorString = errorString + toMsg;
	//--��ֵֹ����ʼֵ��Ĭ��ֵ֮���У��--%>
	if(isEmpty(toMsg) && isEmpty(fromMsg)){		
		errorString = errorString + compareFloat(paramValueFrom.value,paramValueTo.value,"��ʼֵ","��ֵֹ");
	}
	if(isEmpty(toMsg) && isEmpty(defaultMsg)){
		errorString = errorString + compareFloat(defaultValue.value,paramValueTo.value,"Ĭ��ֵ","��ֵֹ");
	}
	if(isEmpty(fromMsg) && isEmpty(defaultMsg)){
		errorString = errorString + compareFloat(paramValueFrom.value,defaultValue.value,"��ʼֵ","Ĭ��ֵ");
	}

	return errorString;
}

/***************************************************************
* 
* �۸�ƻ�����ģ�飺���۲���ֵ������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPriceParamValue(){
	var errorString = "";			
	//--����ֵ������Ϊ��,���Ȳ��ܳ�60,priceParamValue)--%>
	var priceParamValue = document.getElementById("priceParamValue");
	var blankCheckMsg = checkBlankStr(priceParamValue.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(priceParamValue.value,60,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	
	return errorString;	
}
/***************************************************************
* 
* �۸�ƻ�����ģ�飺���۲��Ի�����Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPriceItem(){
	var errorString = "";
	//--���۲�������(����Ϊ�գ����Ȳ��ܳ�60,,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--��Чʱ��(����Ϊ��,effDate)--%>
	var effDate = document.getElementById("effDate");
	errorString = errorString + checkBlankStr(effDate.value,"��Чʱ��");
	//--ʧЧʱ��(��Ϊ��,expDateString)--%>
	var expDateString = document.getElementById("expDateString");
	//--��Чʱ�䲻�ܴ���ʧЧʱ��--%>
	errorString = errorString + compareDateStr(effDate.value,expDateString.value,"��Чʱ��","ʧЧʱ��");
	//--���(ֻ��Ϊ���֣�number(8,2),rate)--%>
	var rate = document.getElementById("rate");
	errorString = errorString + checkFloat(rate.value,6,2,"���");
	//--����(ֻ��Ϊ���֣�����λ�����6λ,pricingUnitCount)--%>
	var pricingUnitCount = document.getElementById("pricingUnitCount");
	errorString = errorString + checkInt(pricingUnitCount.value,6,"����");
	//--���۲�������(���Ȳ��ܳ�255,remarks)--%>
	var remarks = document.getElementById("remarks");
	errorString = errorString + checkCNStrLen(remarks.value,255,"��������");
	
	return errorString;
}

/***************************************************************
* 
* �۸�ƻ�����ģ�飺�۸�ƻ�������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPricePlan(){
	var errorString = "";			
	//--����(����Ϊ�գ����Ȳ��ܳ�60,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"�۸�����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"�۸�����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--����(����Ϊ��ѡ��,type)--%>
	var type = document.getElementById("type");
	errorString = errorString + checkSelectOption(type.value,"X","�۸�����");		
	//--�㼶(����Ϊ��ѡ��,priceLevel)--%>
	var priceLevel = document.getElementById("priceLevel");				
	errorString = errorString + checkSelectOption(priceLevel.value,"X","�۸�㼶");		
	//--�Ż�����(����Ϊ��ѡ��,disctType)--%>
	var disctType = document.getElementById("disctType");				
	errorString = errorString + checkSelectOption(disctType.value,"X","�Ż�����");		
	//--���Ż�����(����Ϊ��ѡ��,subDisctType)--%>
	var subDisctType = document.getElementById("subDisctType");				
	errorString = errorString + checkSelectOption(subDisctType.value,"X","���Ż�����");		
	//--������(����Ϊ��ѡ��,disctType)--%>
	var rejectFlag = document.getElementById("rejectFlag");				
	errorString = errorString + checkSelectOption(rejectFlag.value,"X","������");		
	//--��Чʱ��(����Ϊ��,effDate)--%>
	var effDate = document.getElementById("effDate");
	errorString = errorString + checkBlankStr(effDate.value,"��Чʱ��");
	//--ʧЧʱ��(��Ϊ��,expDateString)--%>
	var expDateString = document.getElementById("expDateString");
	//--��Чʱ�䲻�ܴ���ʧЧʱ��--%>
	errorString = errorString + compareDateStr(effDate.value,expDateString.value,"��Чʱ��","ʧЧʱ��");	
	//--��ע(���Ȳ��ܳ�255,remarks)--%>
	var remarks = document.getElementById("remarks");	
	errorString = errorString + checkCNStrLen(remarks.value,255,"��ע");
	
	return errorString;
}

/***************************************************************
* 
* �۸�ƻ�����ģ�飺�۸�ƻ����Թ��ɻ�����Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPricePlanList(){
	var errorString = "";
	var priority = document.getElementById("priority");
	var blankCheckMsg = checkBlankStr(priority.value,"���ȼ�");
	if(blankCheckMsg == ""){
		errorString = errorString + checkInt(priority.value,6,"���ȼ�");
	}else{
		errorString = errorString + blankCheckMsg;
	}
	
	return errorString;
}
/***************************************************************
* 
* �۸�ƻ�����ģ�飺�۸�ƻ��ײͻ�����Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiPricePlanBrand(){
	var errorString = "";
	//--�ײ�����(����Ϊ�գ����Ȳ��ܳ�60,,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"�ײ�����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"�ײ�����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--��ѡ��־(����Ϊ��ѡ��,multiFlag)--%>
	var multiFlag = document.getElementById("multiFlag");
	errorString = errorString + checkSelectOption(multiFlag.value,"X","��ѡ��־");		
	//--�ײ�����(���Ȳ��ܳ�255,remarks);--%>
	var remarks = document.getElementById("remarks");
	errorString = errorString + checkCNStrLen(remarks.value,255,"��ע");
	
	return errorString;
}

/***************************************************************
* 
* ��Ʒ��������ģ�飺��Ʒ������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiProduct(){
	var errorString = "";
	//--��Ʒ����(����Ϊ�գ����Ȳ��ܳ�60,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��Ʒ����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��Ʒ����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}					
	//--�����ʶ������Ϊ��ѡ��,mainFlag��--%>
	var mainFlag = document.getElementById("mainFlag");				
	errorString = errorString + checkSelectOption(mainFlag.value,"X","�����ʶ");		
	//--�����ʶ������Ϊ��ѡ��,bundleFlag��--%>
	var bundleFlag = document.getElementById("bundleFlag");				
	errorString = errorString + checkSelectOption(bundleFlag.value,"X","�����ʶ");		
	//--��Чʱ��(����Ϊ��,effDateString)--%>
	var effDateString = document.getElementById("effDateString");
	errorString = errorString + checkBlankStr(effDateString.value,"��Чʱ��");
	//--ʧЧʱ��(��Ϊ��,expDateString)--%>
	var expDateString = document.getElementById("expDateString");
	//--��Чʱ�䲻�ܴ���ʧЧʱ��--%>
	errorString = errorString + compareDateStr(effDateString.value,expDateString.value,"��Чʱ��","ʧЧʱ��");	
	//--��׼����(��Ϊ��,���Ȳ��ܳ���60��standardCode)--%>
	var standardCode = document.getElementById("standardCode");
	errorString = errorString + checkCNStrLen(standardCode.value,60,"��׼����");
	//--��ѡ��������(ֻ��Ϊ���֣�����λ�����Ϊ6,amountLow)--%>
	var amountLow = document.getElementById("amountLow");
	var lowMsg = checkInt(amountLow.value,6,"��������");
	errorString = errorString + lowMsg;
	//--��ѡ��������(ֻ��Ϊ���֣�����λ�����Ϊ6,amountHigh)--%>
	var amountHigh = document.getElementById("amountHigh");
	var highMsg = checkInt(amountHigh.value,6,"��������");
	errorString = errorString + highMsg;
	if(isEmpty(lowMsg) && isEmpty(highMsg)){
		errorString = errorString + compareInt(amountLow.value,amountHigh.value,"��������","��������");
	}
			
	return errorString;		
}

/***************************************************************
* 
* ��Ʒ��������ģ�飺��Ʒ���ɻ�����Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiProdItem(){
	var errorString = "";					
	//��ѡ��־(����Ϊ��ѡ��,selFlag)
	var selFlag = document.getElementById("selFlag");				
	errorString = errorString + checkSelectOption(selFlag.value,"X","��ѡ��־");		
	//ͬ������(����Ϊ��ѡ��,synCompFlag)
	var synCompFlag = document.getElementById("synCompFlag");							
	errorString = errorString + checkSelectOption(synCompFlag.value,"X","ͬ��������־");		
	//��ѡ��������(ֻ��Ϊ���֣�����λ�����Ϊ6,amountLow)	
	var amountLow = document.getElementById("amountLow");
	var lowMsg = checkInt(amountLow.value,6,"��������");
	errorString = errorString + lowMsg;
	//--��ѡ��������(ֻ��Ϊ���֣�����λ�����Ϊ6,amountHigh)--%>
	var amountHigh = document.getElementById("amountHigh");
	var highMsg = checkInt(amountHigh.value,6,"��������");
	errorString = errorString + highMsg;
	if(isEmpty(lowMsg) && isEmpty(highMsg)){
		errorString = errorString + compareInt(amountLow.value,amountHigh.value,"��������","��������");
	}
				
	return errorString;	
}

/***************************************************************
* 
* ��Ʒ��������ģ�飺��Ʒ�۸�ƻ�������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiProdPricePlan(){
	var errorString = "";
	//--��ѡ��ʶ������Ϊ��ѡ��,mainFlag��--%>
	var mandFlag = document.getElementById("mandFlag");	
	errorString = errorString + checkSelectOption(mandFlag.value,"X","��ѡ��ʶ");		
	//--��Чʱ��(����Ϊ��,effDate)--%>
	var effDate = document.getElementById("effDate");
	errorString = errorString + checkBlankStr(effDate.value,"��Чʱ��");	
		
	return errorString;
}

/***************************************************************
* 
* ��Ʒ������ģ�飺��Ʒ��������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiProdSpec(){
	var errorString = "";	
	//--������ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)--%>			
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"�������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"�������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--��ϱ�ʶ(����Ϊ��ѡ��,composeFlag)--%>
	var composeFlag = document.getElementById("composeFlag");				
	errorString = errorString + checkSelectOption(composeFlag.value,"X","��ϱ�ʶ");		
	//--�����ʶ(����Ϊ��ѡ��,mainFlag)--%>
	var mainFlag = document.getElementById("mainFlag");				
	errorString = errorString + checkSelectOption(mainFlag.value,"X","�����ʶ");		
	//--���ɱ�(ֻ��Ϊ���֣�����λ�����8λ,cost)--%>
	var cost = document.getElementById("cost");
	errorString = errorString + checkInt(cost.value,8,"���ɱ�");
	//--��׼����(���Ȳ��ܳ���30��standardCode)--%>
	var standardCode = document.getElementById("standardCode");				
	errorString = errorString + checkCNStrLen(standardCode.value,30,"��׼����");
	
	return errorString;	
}

/***************************************************************
* 
* ������Դ����ģ�飺������Դ������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiResourceSpec(){
	var errorString = "";
	//--������Դ���ƣ�����Ϊ�գ����Ȳ��ܳ�60,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��Դ����");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��Դ����");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--������Դ���(����Ϊ��ѡ��,resourceSpecTypeId)--%>
	var resourceSpecTypeId = document.getElementById("resourceSpecTypeId");				
	errorString = errorString + checkSelectOption(resourceSpecTypeId.value,"X","��Դ���");		
		
	return errorString;
}

/***************************************************************
* 
* ����������ģ�飺������������Ϣά����ҳ��У��
* ��������
* ���أ�������Ϣ�ַ���
*****************************************************************/
function valiServAct(){
	var errorString = "";			
	//--����������(����Ϊ�գ����Ȳ��ܳ�60,name)--%>
	var name = document.getElementById("name");
	var blankCheckMsg = checkBlankStr(name.value,"��������");
	if(blankCheckMsg == ""){
		var lengthCheckMsg = checkCNStrLen(name.value,60,"��������");
		errorString = errorString + lengthCheckMsg;
	}else{
		errorString = errorString + blankCheckMsg;
	}
	//--��������(����Ϊ��ѡ��N,type)--%>
	var type = document.getElementById("type");	
	errorString = errorString + checkSelectOption(type.value,"X","��������");			
	//--��������(����Ϊ��ѡ��N,actType)--%>
	var actType = document.getElementById("actType");				
	errorString = errorString + checkSelectOption(actType.value,"X","��������");			
	//--Ƿ�Ѱ���(����Ϊ��ѡ��X,debtFlag)--%>
	var debtFlag = document.getElementById("debtFlag");				
	errorString = errorString + checkSelectOption(debtFlag.value,"X","Ƿ�Ѱ����ʶ");			
	//--��������(����Ϊ��ѡ��X,batchFlag)--%>
	var batchFlag = document.getElementById("batchFlag");				
	errorString = errorString + checkSelectOption(batchFlag.value,"X","���������ʶ");			
	//--��ϱ�ʶ(����Ϊ��ѡ��X,composeFlag)--%>
	var composeFlag = document.getElementById("composeFlag");				
	errorString = errorString + checkSelectOption(composeFlag.value,"X","��ϱ�ʶ");			
	//--��׼����(���Ȳ��ܳ���30��standardCode)--%>
	var standardCode = document.getElementById("standardCode");
	errorString = errorString + checkCNStrLen(standardCode.value,30,"��׼����");
	
	return errorString;
}
function isEmpty(name){
	 if (name == ""){
	   return true;
	 }else{
	    return false;
	 }
}
function checkCN(value,length){
  if(value.length > length){
       return false;
  }else{
       return true;
  }
}
/*��Ʒ������ϵͳ��ģ�����ҳ��У�鷽��----END*/