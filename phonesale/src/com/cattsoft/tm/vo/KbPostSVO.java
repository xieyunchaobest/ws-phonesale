package com.cattsoft.tm.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * ֪ʶ��ظ���ϢSVO
 * 
 * @author lupan
 *
 */
public class KbPostSVO extends GenericVO {
	/**
	 * �Զ�����
	 */
	private static final long serialVersionUID = -6251762669215740098L;
	/**
	 * �ظ���ϢID
	 */
	private String postId = null;
	/**
	 * ��������ID
	 */
	private String topicId = null;
	/**
	 * ������ID
	 */
	private String forumId = null;
	/**
	 * �������ⷢ���û�
	 */
	private String userName = null;
	/**
	 * �ظ�ʱ��
	 */
	private Date postTime = new Date();
	/**
	 * �ظ���IP
	 */
	private String posterIp = null;
	/**
	 * ת���뿪����ʶ
	 */
	private String enableBbcode = null;
	/**
	 * HTML������ʶ
	 */
	private String enableHtml = null;
	/**
	 * ������ſ�����ʶ
	 */
	private String enableSmilies = null;
	/**
	 * ǩ��������ʶ
	 */
	private String enableSig = null;
	/**
	 * �ظ��༭ʱ��
	 */
	private Date postEditTime = new Date();
	/**
	 * �ظ��༭����
	 */
	private int postEditCount = 0;
	/**
	 * ״̬
	 */
	private String status = null;
	/**
	 * ������ʶ
	 */
	private String attach = null;
	/**
	 * �Ƿ���Ҫ���
	 */
	private String needModerate = null;
	/**
	 * �ظ���Ϣ����
	 */
	private String postText = null;
	/**
	 * �ظ�����
	 */
	private String postSubject = null;

	/**
	 * �޲ι��캯��
	 */
	public KbPostSVO() {
	}

	public String getPostId() {
		return postId;
	}

	public void setPostId(String postId) {
		this.postId = postId;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}

	public String getForumId() {
		return forumId;
	}

	public void setForumId(String forumId) {
		this.forumId = forumId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getPostTime() {
		return postTime;
	}

	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public String getPosterIp() {
		return posterIp;
	}

	public void setPosterIp(String posterIp) {
		this.posterIp = posterIp;
	}

	public String getEnableBbcode() {
		return enableBbcode;
	}

	public void setEnableBbcode(String enableBbcode) {
		this.enableBbcode = enableBbcode;
	}

	public String getEnableHtml() {
		return enableHtml;
	}

	public void setEnableHtml(String enableHtml) {
		this.enableHtml = enableHtml;
	}

	public String getEnableSmilies() {
		return enableSmilies;
	}

	public void setEnableSmilies(String enableSmilies) {
		this.enableSmilies = enableSmilies;
	}

	public String getEnableSig() {
		return enableSig;
	}

	public void setEnableSig(String enableSig) {
		this.enableSig = enableSig;
	}

	public Date getPostEditTime() {
		return postEditTime;
	}

	public void setPostEditTime(Date postEditTime) {
		this.postEditTime = postEditTime;
	}

	public int getPostEditCount() {
		return postEditCount;
	}

	public void setPostEditCount(int postEditCount) {
		this.postEditCount = postEditCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getNeedModerate() {
		return needModerate;
	}

	public void setNeedModerate(String needModerate) {
		this.needModerate = needModerate;
	}

	public String getPostText() {
		return postText;
	}

	public void setPostText(String postText) {
		this.postText = postText;
	}

	public String getPostSubject() {
		return postSubject;
	}

	public void setPostSubject(String postSubject) {
		this.postSubject = postSubject;
	}

}
