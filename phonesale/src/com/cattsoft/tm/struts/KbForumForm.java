package com.cattsoft.tm.struts;

import org.apache.struts.action.ActionForm;

/**
 * 
 * Title: ����ͨϵͳ-֪ʶ����ϵͳ<br>
 * Description: ֪ʶ���������ActionForm<br>
 * Date: 2012-8-27 <br>
 * Copyright (c) 2012 CATTSoft<br>
 * 
 * @author ³��
 */

public class KbForumForm extends ActionForm {

	/**
	 * �Զ��������к�
	 */
	private static final long serialVersionUID = -8183726975099455537L;
	
	/**
	 * ����ID
	 */
	private String categories_id;
	/**
	 * �������
	 */
	private String title;
	/**
	 * ��ʾ˳��
	 */
	private String display_order;
	/**
	 * �Ƿ���Ҫ���
	 */
	private String moderated;
	
	/**
	 * �޲ι��캯��
	 */
	public KbForumForm() {
		// TODO Auto-generated constructor stub
	}

	public String getCategories_id() {
		return categories_id;
	}

	public void setCategories_id(String categoriesId) {
		categories_id = categoriesId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDisplay_order() {
		return display_order;
	}

	public void setDisplay_order(String displayOrder) {
		display_order = displayOrder;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

}
