function updateMenu(obj) {
	var menu = new tree_menu(120);
	if (obj != null) {
		if (foldAllItem.isShow == null) {
			menu.add("�޸�", "..\\images\\sla_modi.gif", 'js', "modiLeaf('"
					+ obj.id + "');");
			menu.add("ɾ��", "..\\images\\sla_del.gif", 'js', "delLeaf('"
					+ obj.id + "');");
		}
		obj.oncontextmenu = function() {
			event.returnValue = false;
		}
		if (event.button == 2) {
			menu.hideAll();
			menu.show();
		}
	}
}
//��������ڵ��¼�
function updateRootMenu(obj) {
	var menu = new tree_menu(120);
	if (obj != null) {
		if (foldAllItem.isShow == null) {
			menu.add("����", "..\\images\\sla_add.gif", 'js', "addLeaf('"
					+ obj.id + "');");
		}
		obj.oncontextmenu = function() {
			event.returnValue = false;
		}
		if (event.button == 2) {
			menu.hideAll();
			menu.show();
		}

	}
}
function toClickBox(name) {
	var searchValue = document.getElementById(name);
	searchValue.value = "";
	searchValue.style.color = "black";
	searchValue.style.fontStyle = "normal";
}
function toLeaveBox(name) {
	var search = document.getElementById(name);
	if (search.value == "") {
		search.value = "����������";
		search.style.color = "gray";
		search.style.fontStyle = "italic";
	}
}
//�ַ�������ȥ���ո�
function trim(inStr) {
	var str = inStr.replace(/^\s+/, '');
	for ( var i = str.length - 1; i >= 0; i--) {
		if (/\S/.test(str.charAt(i))) {
			str = str.substring(0, i + 1);
			break;
		}
	}
	return str;
}
function initSearchName(eName){
		//��ʼ������
	var search = document.getElementById(eName);
	search.style.color="gray";
	search.style.fontStyle="italic";
	
}
//ִ��ģ����ѯ����
function searchTreeName(url,eName,frame) {
	var name = document.getElementById(eName).value.toString() + "";
	var searchName = trim(name); //��ѯʱȥ�����߿ո�
	var f1 = document.getElementById(frame);
	if (searchName != null && searchName != "����������") {
		f1.src = url + "&" + eName + "=" + name;
	} else {
		f1.src = url;
	}
	function(){tree.openItem("root")};
	��//frame1.submit();		
}
var sp_tree = {
	modiLeaf : function(id){
		alert();
	},
	addLeaf : function(id){
		
	},
	delLeaf : function(id){
		
	}
}