package com.cattsoft.phonesale.menu;

public class Menu {
	
	public  static String acessToken="{\"button\":[{\"type\":\"view\",\"name\":\"��̳\",\"url\":\"http://www.baidu.com\"},{\"name\":\"����\",\"sub_button\":[{\"type\":\"view\",\"name\":\"����\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"����\",\"url\":\"http:.qq.com/\"}]},{\"name\":\"����\",\"sub_button\":[{\"type\":\"view\",\"name\":\"����\",\"url\":\"http://www.163.com/\"},{\"type\":\"view\",\"name\":\"����\",\"url\":\"http:www.qq.com\"}]}]}";
	
	public String createMenu() {
		MenuItem l1Luntan=new MenuItem();
		l1Luntan.setName("��̳");
		l1Luntan.setUrl("http://www.baidu.com");
		l1Luntan.setType("view");
		
		
		MenuItem l1Order=new MenuItem();
		l1Order.setName("����");
		MenuItem l2OrderHis=new MenuItem();
		l2OrderHis.setName("����");
		l2OrderHis.setType("view");
		l2OrderHis.setUrl("http://www.163.com");
		MenuItem l2OrderNow=new MenuItem();
		l2OrderNow.setName("����");
		l2OrderNow.setType("view");
		l2OrderNow.setUrl("http://www.qq.com");
		
		
		MenuItem l1Stat=new MenuItem();
		l1Stat.setName("����");
		MenuItem l2StatHis=new MenuItem();
		l2StatHis.setName("����");
		l2StatHis.setType("type");
		l2StatHis.setUrl("http://www.sina.com.cn");
		MenuItem l2StatNow=new MenuItem();
		l2StatNow.setName("����");
		l2StatNow.setType("type");
		l2StatNow.setUrl("http://www.sina.com.cn");
		
		
		
		
		return null;
	}
	

	
}
