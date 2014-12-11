package com.cattsoft.phonesale.menu;

public class Menu {
	
	public  static String acessToken="{\"button\":[{\"type\":\"view\",\"name\":\"论坛\",\"url\":\"http://www.baidu.com\"},{\"name\":\"订购\",\"sub_button\":[{\"type\":\"view\",\"name\":\"在行\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"往期\",\"url\":\"http:.qq.com/\"}]},{\"name\":\"汇总\",\"sub_button\":[{\"type\":\"view\",\"name\":\"在行\",\"url\":\"http://www.163.com/\"},{\"type\":\"view\",\"name\":\"往期\",\"url\":\"http:www.qq.com\"}]}]}";
	
	public String createMenu() {
		MenuItem l1Luntan=new MenuItem();
		l1Luntan.setName("论坛");
		l1Luntan.setUrl("http://www.baidu.com");
		l1Luntan.setType("view");
		
		
		MenuItem l1Order=new MenuItem();
		l1Order.setName("订购");
		MenuItem l2OrderHis=new MenuItem();
		l2OrderHis.setName("往期");
		l2OrderHis.setType("view");
		l2OrderHis.setUrl("http://www.163.com");
		MenuItem l2OrderNow=new MenuItem();
		l2OrderNow.setName("在行");
		l2OrderNow.setType("view");
		l2OrderNow.setUrl("http://www.qq.com");
		
		
		MenuItem l1Stat=new MenuItem();
		l1Stat.setName("汇总");
		MenuItem l2StatHis=new MenuItem();
		l2StatHis.setName("往期");
		l2StatHis.setType("type");
		l2StatHis.setUrl("http://www.sina.com.cn");
		MenuItem l2StatNow=new MenuItem();
		l2StatNow.setName("往期");
		l2StatNow.setType("type");
		l2StatNow.setUrl("http://www.sina.com.cn");
		
		
		
		
		return null;
	}
	

	
}
