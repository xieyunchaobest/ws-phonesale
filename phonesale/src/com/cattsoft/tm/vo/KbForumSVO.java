package com.cattsoft.tm.vo;

import com.cattsoft.pub.vo.GenericVO;

/**
 * ֪ʶ��������SVO
 * 
 * @author lupan
 *
 */
public class KbForumSVO extends GenericVO {

	/**
	 * �Զ�����
	 */
	private static final long serialVersionUID = -778883845172290503L;
	/**
	 * ������ID
	 */
	private String forumId = null;
	
	/**
	 * ����ID
	 */
	private String categoriesId = null;
	/**
	 * ����
	 */
	private String forumName = null;
	/**
	 * ����
	 */
	private String forumDesc = null;
	/**
	 * ��ʾ˳��
	 */
	private int forumOrder = 0;
	/**
	 * ��������
	 */
	private int forumTopics = 0;
	/**
	 * �����������������ID
	 */
	private String forumLastPostId = null;
	/**
	 * �Ƿ���Ҫ���
	 */
	private String moderated = null;
	
	/**
	 * �޲ι��캯��
	 */
	public KbForumSVO() {
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getCategoriesId() {
		return categoriesId;
	}

	public void setCategoriesId(String categoriesId) {
		this.categoriesId = categoriesId;
	}

	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getForumDesc() {
		return forumDesc;
	}

	public void setForumDesc(String forumDesc) {
		this.forumDesc = forumDesc;
	}

	public int getForumOrder() {
		return forumOrder;
	}

	public void setForumOrder(int forumOrder) {
		this.forumOrder = forumOrder;
	}

	public int getForumTopics() {
		return forumTopics;
	}

	public void setForumTopics(int forumTopics) {
		this.forumTopics = forumTopics;
	}

	public String getForumLastPostId() {
		return forumLastPostId;
	}

	public void setForumLastPostId(String forumLastPostId) {
		this.forumLastPostId = forumLastPostId;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

}
