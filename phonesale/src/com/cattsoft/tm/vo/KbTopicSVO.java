package com.cattsoft.tm.vo;

import java.util.Date;

import com.cattsoft.pub.vo.GenericVO;

/**
 * ֪ʶ����������SVO
 * 
 * @author lupan
 *
 */
public class KbTopicSVO extends GenericVO {
	/**
	 * �Զ�����
	 */
	private static final long serialVersionUID = 175954753263269811L;
	/**
	 * ��������ID
	 */
	private String topicId = null;
	/**
	 * ������ID
	 */
	private String forumId = null;
	private String forumName = null;
	/**
	 * ��������
	 */
	private String topicTitle = null;
	/**
	 * ������������
	 */
	private String topicDesc = null;
	/**
	 * �������ⷢ���û�ID
	 */
	private String userId = null;
	/**
	 * �������ⷢ���û���
	 */
	private String postUserName = null;
	/**
	 * �������ⷢ��ʱ��
	 */
	private Date topicTime = null;
	/**
	 * ���������������
	 */
	private int topicViews = 0;
	/**
	 * ��������ظ�����
	 */
	private int topicReplies = 0;
	/**
	 * ���������״̬
	 */
	private String topicStatus = null;
	/**
	 * ��̳����Ͷ��ID
	 */
	private String topicVoteId = null;
	/**
	 * ��������
	 */
	private String topicType = null;
	/**
	 * �����һ���ظ�
	 */
	private String topicFirstPostId = null;
	/**
	 * �������һ���ظ�
	 */
	private String topicLastPostId = null;
	/**
	 * �Ƿ���Ҫ���
	 */
	private String moderated = null;
	/**
	 * ��һ�λظ�ʱ��
	 */
	private String firstPostTime = null;
	
	/**
	 * �޲ι��캯��
	 */
	public KbTopicSVO() {
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
	
	public String getForumName() {
		return forumName;
	}

	public void setForumName(String forumName) {
		this.forumName = forumName;
	}

	public String getTopicTitle() {
		return topicTitle;
	}

	public void setTopicTitle(String topicTitle) {
		this.topicTitle = topicTitle;
	}

	public String getTopicDesc() {
		return topicDesc;
	}

	public void setTopicDesc(String topicDesc) {
		this.topicDesc = topicDesc;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPostUserName() {
		return postUserName;
	}

	public void setPostUserName(String postUserName) {
		this.postUserName = postUserName;
	}

	public Date getTopicTime() {
		return topicTime;
	}

	public void setTopicTime(Date topicTime) {
		this.topicTime = topicTime;
	}

	public int getTopicViews() {
		return topicViews;
	}

	public void setTopicViews(int topicViews) {
		this.topicViews = topicViews;
	}

	public int getTopicReplies() {
		return topicReplies;
	}

	public void setTopicReplies(int topicReplies) {
		this.topicReplies = topicReplies;
	}

	public String getTopicStatus() {
		return topicStatus;
	}

	public void setTopicStatus(String topicStatus) {
		this.topicStatus = topicStatus;
	}

	public String getTopicVoteId() {
		return topicVoteId;
	}

	public void setTopicVoteId(String topicVoteId) {
		this.topicVoteId = topicVoteId;
	}

	public String getTopicType() {
		return topicType;
	}

	public void setTopicType(String topicType) {
		this.topicType = topicType;
	}

	public String getTopicFirstPostId() {
		return topicFirstPostId;
	}

	public void setTopicFirstPostId(String topicFirstPostId) {
		this.topicFirstPostId = topicFirstPostId;
	}

	public String getTopicLastPostId() {
		return topicLastPostId;
	}

	public void setTopicLastPostId(String topicLastPostId) {
		this.topicLastPostId = topicLastPostId;
	}

	public String getModerated() {
		return moderated;
	}

	public void setModerated(String moderated) {
		this.moderated = moderated;
	}

	public String getFirstPostTime() {
		return firstPostTime;
	}

	public void setFirstPostTime(String firstPostTime) {
		this.firstPostTime = firstPostTime;
	}
	
}
