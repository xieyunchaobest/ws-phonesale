package com.cattsoft.pub;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class MailUtil {
	private static final String MAIL_SMTP_HOST = "mail.smtp.host";

	private static final String MAIL_SMTP_AUTH = "mail.smtp.auth";
	
	private static final String SMTP = "smtp";
	
	private static final String  ENCODING="GBK";

	private MimeMessage mimeMsg; //MIME�ʼ����   

	private Session session; //�ʼ��Ự���   

	private Properties props; //ϵͳ����   

	private String username = ""; //smtp��֤�û���������   

	private String password = "";

	private Multipart mp; //Multipart����,�ʼ�����,����,���������ݾ���ӵ����к�������MimeMessage����   

	private String mailHostName = "";

	private String needAuth = "false"; //smtp�Ƿ���Ҫ��֤

	private String mailTitle = "   �����ʼ�"; //�ʼ�����   

	private String mailContent = "�����ʼ�����"; //�ʼ�����

	private String sendFile = "";//���͸���
	
	private String sendMailName ="";//����������
	
	private String[] receiveMailName={""};//����������
	
	
	private static MailUtil mailUtil = null;//synchronized static

	/**
	 *ȱʡ������
	 */
	private MailUtil() {
	}
	/**
	 * 
	 * @return
	 */
    public synchronized static MailUtil getInstance(){
    	if(mailUtil == null)
    		mailUtil = new MailUtil();
      return mailUtil;
    }
	/**   
	 *   @return   boolean   
	 */
	private boolean createMimeMessage(){
		try {
			if (props == null) {
				props = System.getProperties(); //���ϵͳ���Զ���
			}
			if(mailHostName == null || mailHostName.trim().length() == 0){
				System.err.println("�������������������");
				return false;
			}
			props.put(MAIL_SMTP_HOST, mailHostName); //����SMTP����   
			props.put(MAIL_SMTP_AUTH, needAuth); //���������֤Ϊfalse    		
			//System.out.println("׼����ȡ�ʼ��Ự����");
			session = Session.getDefaultInstance(props, null); //����ʼ��Ự����
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("��ȡ�ʼ�����ʱ��������" + e);
			return false;
		}
		//System.out.println("׼������MIME�ʼ�����");
		try {
			mimeMsg = new MimeMessage(session); //����MIME�ʼ�����   
			mp = new MimeMultipart();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("����MIME�ʼ�����ʧ�ܣ�" + e);
			return false;
		}
	}

	/**
	 * 
	 * @param from
	 * @param to
	 * @return
	 */
	private boolean setMail() {
		try {
			mimeMsg.setSubject(mailTitle, ENCODING); //���� 
			if(sendMailName == null || sendMailName.trim().length() == 0){
				System.err.println("���������䷢�������䣡");
				return false;
			}
			if(receiveMailName == null || receiveMailName.length == 0){
				System.err.println("������������������䣡");
				return false;
			}
			if(mailContent == null || mailContent.trim().length() == 0){
				System.err.println("�������ʼ����ݣ�");
				return false;
			}
			mimeMsg.setFrom(new InternetAddress(sendMailName)); //������   
			BodyPart bp = new MimeBodyPart();
			bp.setText("����");
			mp.addBodyPart(bp);
			bp.setContent(
					"<meta http-equiv=Content-Type content=text/html;   charset=gb2312>"
							+ mailContent, "text/html;charset=GB2312");
			if(sendFile.trim().length() > 0){
				mp.addBodyPart(bp);
				bp = new MimeBodyPart();
				FileDataSource fileds = new FileDataSource(sendFile);
				bp.setDataHandler(new DataHandler(fileds));
				bp.setFileName(fileds.getName()); //���� 
			}
			mp.addBodyPart(bp);
		    InternetAddress[] sendTo = new InternetAddress[receiveMailName.length];
		    for (int i = 0; i < receiveMailName.length; i++)
		       {
		         //System.out.println("���͵�:" + receiveMailName[i]);
		         sendTo[i] = new InternetAddress(receiveMailName[i]);
		       }
			
			mimeMsg.setRecipients(Message.RecipientType.TO,sendTo);
			mimeMsg.setContent(mp);
			mimeMsg.saveChanges();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			//System.err.println("�ʼ�����ʧ��!" + e);
			return false;
		}
	}

	/**
	 * �����ʼ�
	 * @return
	 */
	private boolean sendout() {
		try {
			Session mailSession = Session.getInstance(props, null);
			Transport transport = mailSession.getTransport(SMTP);
			if(needAuth == null || needAuth.trim().length() == 0){
				needAuth = "false";				
			}
			if(needAuth.trim().toUpperCase().equals("TRUE")){
				if(username == null || username.trim().length() == 0){
					System.err.println("��������֤�û����������ʼ���");
					return false;
				}
			}
			transport.connect((String) props.get(MAIL_SMTP_HOST), username,password);
			transport.sendMessage(mimeMsg, mimeMsg.getRecipients(Message.RecipientType.TO));
			transport.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("�ʼ�����ʧ�ܣ�" + e);
			return false;
		}
	}
	/**
	 *�����ʼ�
	 */
    public void sendMail(){
    	boolean bRet = false;
    	try{
    		bRet = this.createMimeMessage();
    		if(!bRet)
    			return;
    		bRet = this.setMail();
    		if(!bRet)
    			return;
    		bRet = this.sendout();
    		if(!bRet)
    			return;    		
    	}catch(Exception e){
    		System.err.println("�ʼ�����ʧ�ܣ�" + e);
    		e.printStackTrace();
    	}
    }
    /**
     * ��֤�����û���
     * @return
     */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    /**
     * ��֤��������
     * @return
     */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    /**
     * �����������
     * @return
     */
	public String getMailHostName() {
		return mailHostName;
	}

	public void setMailHostName(String mailHostName) {
		this.mailHostName = mailHostName;
	}
    /**
     * �Ƿ���Ҫ������֤
     * �����ҪneedAuth��"true"����needAuth��"false"
     * @return
     */
	public String getNeedAuth() {
		return needAuth;
	}

	public void setNeedAuth(String needAuth) {
		this.needAuth = needAuth;
	}
    /**
     * �ʼ�����
     * @return
     */
	public String getMailTitle() {
		return mailTitle;
	}

	public void setMailTitle(String mailTitle) {
		this.mailTitle = mailTitle;
	}
    /**
     * �ʼ�����
     * @return
     */
	public String getMailContent() {
		return mailContent;
	}

	public void setMailContent(String mailContent) {
		this.mailContent = mailContent;
	}
    /**
     * �ʼ�����
     * @return
     */
	public String getSendFile() {
		return sendFile;
	}

	public void setSendFile(String sendFile) {
		this.sendFile = sendFile;
	}
    /**
     * �����ʼ�����
     * @return
     */
	public String getSendMailName() {
		return sendMailName;
	}

	public void setSendMailName(String sendMailName) {
		this.sendMailName = sendMailName;
	}
    /**
     * �����ʼ�����
     * @return
     */
	public String[] getReceiveMailName() {
		return receiveMailName;
	}

	public void setReceiveMailName(String[] receiveMailName) {
		this.receiveMailName = receiveMailName;
	}
}
