package com.cattsoft.webpub.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PropertyResourceBundle;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.util.EncryptUtil;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.PageContext;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.log4j.Logger;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.CollectionUtil;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.LogUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.pub.util.SysConfigData;
import com.cattsoft.sm.component.dao.IWorkAreaMDAO;
import com.cattsoft.sm.vo.ActionLogSVO;
import com.cattsoft.sm.vo.StaffExtendMVO;
import com.cattsoft.sm.vo.SysUserExtendedMVO;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.sm.vo.WorkAreaMVO;
import com.cattsoft.sm.component.dao.IWorkAreaSDAO;
import com.cattsoft.sm.vo.WorkAreaSVO;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


public class ReqUtil {
	public ReqUtil() {
	}

	private static Logger log = Logger.getLogger(ReqUtil.class);

	private static int DEF_PAGE_NUM = 10; // Ĭ�ϳ�ʼҳ����

	private static int PAGE_NUM = 0; // ��ʼҳ����

	public static List getList(HttpServletRequest req, String listName) {
		List list = (List) req.getSession().getAttribute(listName);
		if (list == null) {
			list = new LinkedList();
			req.getSession().setAttribute(listName, list);
		}
		return list;
	}

	public static void setList(HttpServletRequest req, String listName,
			List list) {
		req.getSession().setAttribute(listName, list);
	}

	public static void removeList(HttpServletRequest req, String listName) {
		req.getSession().removeAttribute(listName);
	}

	public static HashSet getHashSet(HttpServletRequest req, String setName) {
		HashSet list = (HashSet) req.getSession().getAttribute(setName);
		if (list == null) {
			list = new HashSet();
			req.getSession().setAttribute(setName, list);
		}
		return list;
	}

	public static void setHashSet(HttpServletRequest req, String setName,
			HashSet set) {
		req.getSession().setAttribute(setName, set);
	}

	public static void removeHashSet(HttpServletRequest req, String setName) {
		req.getSession().removeAttribute(setName);
	}

	public static HashMap getHashMap(HttpServletRequest req, String mapName) {
		HashMap map = null;
		Object obj = req.getSession().getAttribute(mapName);
		if (obj == null) {
			map = new HashMap();
			req.getSession().setAttribute(mapName, map);
		} else {
			map = (HashMap) obj;
		}
		return map;
	}

	public static void removeFromMap(HttpServletRequest req, String mapName,
			Object key) {
		HashMap map = null;
		Object obj = req.getSession().getAttribute(mapName);
		if (obj != null) {
			map = (HashMap) obj;
			map.remove(key);
		}

	}

	/**
	 * ��ȡsession�е�ǰ�û����ڱ�����id
	 * 
	 * @param req
	 * @return
	 */
	public static String getLocalNetId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		String localNetId = null;
		if (sysUserVOExtended == null) {
			localNetId = "311";
		} else {
			WorkAreaMVO mvo = sysUserVOExtended.getCurrentWorkAreaVO();
			if (mvo != null) {
				localNetId = mvo.getLocalNetId();
			} else {
				localNetId = sysUserVOExtended.getStaffExtendMVO()
						.getLocalNetId();
			}

		}

		log.debug("�������ǣ�����������" + localNetId);
		return localNetId;
		// return new Integer(431);
	}

	/**
	 * ��ȡsession�е�ǰ�û���Ȩ�޵ı�����
	 * 
	 * @param req
	 * @return
	 * @throws SysException 
	 * @throws AppException 
	 */
	public static List getLocalNets(HttpServletRequest req) throws AppException, SysException {

		List workAreas = ReqUtil.getWorkAreas(req);
		if (workAreas == null)
			return null;
		
		for (int i = 0; i < workAreas.size(); i++) {

		}
		// TODO ������Ȩ�޵ķ��������ɱ������б�
		log.debug("��ǰ�û���Ȩ�޵ı�������" + CollectionUtil.toString(workAreas));
		return null;
		// return new Integer(431);
	}

	/**
	 * ��ȡsession�е�ǰ�û���Ȩ�޵Ĺ���
	 * 
	 * @param req
	 * @return
	 * @throws SysException 
	 * @throws AppException 
	 */
	public static List getWorkAreas(HttpServletRequest req) throws AppException, SysException {
		/*SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);*/
		IWorkAreaMDAO workAreaMDao = (IWorkAreaMDAO) DAOFactory.getDAO(
	            IWorkAreaMDAO.class);
		//List workAreas = sysUserVOExtended.getStaffWorkAreas();
		
		List workAreas = workAreaMDao.findSingleWorkAreasBySystemStaff(
                new com.cattsoft.sm.vo.WorkAreaSVO(), null, getStaffId(req));

		log.debug("��ǰ�û���Ȩ�޵Ĺ�����" + CollectionUtil.toString(workAreas));
		return workAreas;
	}

	/**
	 * ��ȡSession�е�ǰ�û����ڷ�����Id
	 * 
	 * @param req
	 * @return
	 */
	public static String getAreaId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		String areaId = null;

		if (sysUserVOExtended != null) {
			WorkAreaMVO mvo = sysUserVOExtended.getCurrentWorkAreaVO();
			if (mvo != null) {
				areaId = mvo.getAreaId();
			} else {
				areaId = sysUserVOExtended.getStaffExtendMVO().getAreaId();
			}

		} else {
			areaId = "31101";
		}
		log.debug("�������ǣ�����������" + areaId);
		return areaId;
		// return new Integer(43101);
	}

	/**
	 * ��ȡsession�еĵ�ǰ�û�id
	 * 
	 * @param req
	 * @return
	 */
	public static String getStaffId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		String staffId = null;
		if(sysUserVOExtended != null){
			StaffExtendMVO mvo = sysUserVOExtended.getStaffExtendMVO();
			staffId = mvo.getStaffSVO().getStaffId();
		}else {
			staffId = "0";
		}
		log.debug("Ա���ǣ�����������" + staffId);
		return staffId;
	}

	/**
	 * ��ȡSession�е�ǰ�û�����workAreaId
	 * 
	 * @param req
	 * @return
	 */
	public static String getWorkAreaId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		String workAreaId = null;

		if (sysUserVOExtended != null) {
			WorkAreaMVO mvo = sysUserVOExtended.getCurrentWorkAreaVO();
			log.debug("---------");
			if(mvo!=null)
			   workAreaId = mvo.getWorkAreaId();
		} else {
			workAreaId = "0";
		}
		if(StringUtil.isBlank(workAreaId)){
			workAreaId = "0";
		}
		log.debug("�������ǣ�����������" + workAreaId);
		return workAreaId;
	}
	
	
	
	/**
	 * ��ȡSession�е�ǰ�û�����workArea
	 * 
	 * @param req
	 * @return
	 * @throws SysException 
	 * @throws AppException 
	 */
	public static WorkAreaSVO getWorkArea(HttpServletRequest req) throws AppException, SysException {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		
		WorkAreaMVO mvo = sysUserVOExtended.getCurrentWorkAreaVO();
		IWorkAreaSDAO dao = (IWorkAreaSDAO) DAOFactory.getDAO(IWorkAreaSDAO.class);
		WorkAreaSVO workArea = new WorkAreaSVO();
		workArea.setWorkAreaId(mvo.getWorkAreaId());
		ConnectionFactory.createConnection();
		try{
		workArea = (WorkAreaSVO)dao.findByPK(workArea);
		}catch(AppException e){
			throw e;
		}catch(SysException e){
			throw e;
		}catch(Exception e){
			throw new SysException("1000001","",e);
		}finally{
			ConnectionFactory.closeConnection();
		}
		return workArea;
	}

	/**
	 * ��ȡSession�е�ǰ�û�����getWorkAreaTypeId
	 * 
	 * @param req
	 * @return
	 */
	public static String getWorkAreaTypeId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
		String workAreaTypeId = null;

		if (sysUserVOExtended != null) {
			workAreaTypeId = sysUserVOExtended.getCurrentWorkAreaVO()
					.getWorkTypeId();
		} else {
			workAreaTypeId = "5";
		}
		log.debug("�����������ǣ�����������" + workAreaTypeId);
		return workAreaTypeId;
		// return new Integer(43101);
	}

	/**
	 * ��ȡ��½�û���ʶ
	 * 
	 * @param req
	 * @return
	 */
	public static String getLoginUserId(HttpServletRequest req) {
		SysUserExtendedMVO sysUserVOExtended = (SysUserExtendedMVO) req
				.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);

		String userId = null;

		if (sysUserVOExtended != null) {
			SysUserSVO svo = sysUserVOExtended.getSysUserSVO();
			userId = svo.getSysUserId();
		} else {
			userId = "0";
		}
		return userId;
	}

	public static void clearSessionModList(HttpServletRequest req) {
		ReqUtil.removeHashSet(req, "modList");
	}

	public static Object lookup(HttpServletRequest req, String name,
			String prpty) {
		return lookup(req, name, prpty, 3);
	}

	public static Object lookup(HttpServletRequest req, String name) {
		return lookup(req, name, null, 3);
	}

	public static Object look(HttpServletRequest req, String name, String prpty) {
		return lookup(req, name, prpty, 2);
	}

	public static Object look(PageContext pageCtx, String name, int scope) {
		return lookup(pageCtx, name, null, 2);
	}

	public static Object look(HttpServletRequest req, String name) {
		return lookup(req, name, null, 2);
	}

	public static Object lookup(HttpServletRequest req, String name,
			String property, int scope) {
		Object bean = null;
		if (scope == 0) {
			bean = req.getAttribute(name);
			if (bean == null) {
				bean = req.getSession().getAttribute(name);
			}
		} else {
			if (scope == 2) {
				bean = req.getAttribute(name);
			}
			if (scope == 3) {
				bean = req.getSession().getAttribute(name);
			}
		}

		if (bean == null) {
			return null;
		}

		if (property == null) {
			return bean;
		}

		try {
			Object prpty = PropertyUtils.getProperty(bean, property);
			return prpty;
		} catch (Exception ex) {
			return null;
		}
	}

	public static Object lookup(PageContext pageCtx, String name,
			String property, int scope) {
		ServletRequest req = pageCtx.getRequest();
		HttpSession session = pageCtx.getSession();
		Object bean = null;
		if (scope == 0) {
			bean = req.getAttribute(name);
			if (bean == null) {
				bean = session.getAttribute(name);
			}
		} else {
			if (scope == 2) {
				bean = req.getAttribute(name);
			}
			if (scope == 3) {
				bean = session.getAttribute(name);
			}
		}

		if (bean == null) {
			return null;
		}

		if (property == null) {
			return bean;
		}

		try {
			Object prpty = PropertyUtils.getProperty(bean, property);
			return prpty;
		} catch (Exception ex) {
			return null;
		}
	}

	public static void printSession(HttpServletRequest req) {
		Enumeration e = req.getSession().getAttributeNames();
		if (e != null && e.hasMoreElements()) {
			int i = 0;
			while (e.hasMoreElements()) {
				log.debug("SESSION�е� " + i++ + " ������ : \""
						+ e.nextElement() + "\"");
			}
		}
	}

	public static void printReq(HttpServletRequest req) {
		Enumeration e = req.getAttributeNames();
		if (e != null && e.hasMoreElements()) {
			int i = 0;
			while (e.hasMoreElements()) {
				log.debug("Request�е� " + i++ + " ������ : \""
						+ e.nextElement() + "\"");
			}
		}
	}

	public static void printParam(HttpServletRequest req) {
		Enumeration e = req.getParameterNames();
		if (e != null && e.hasMoreElements()) {
			int i = 0;
			while (e.hasMoreElements()) {
				String name = (String) e.nextElement();
				log.debug("Request�е� " + i++ + " ������ : \"" + name
						+ "\"");
				log.debug("                    �˲���������"
						+ req.getParameterValues(name));
			}
		}
	}

	public static void sessionClear(HttpServletRequest req, String s) {
		if (s == null || s.equals("")) {
			return;
		}

		String[] st = s.trim().split(",");
		for (int i = 0; i < st.length; i++) {
			String name = st[i];
			// if(req.getSession().getAttribute(name)!= null){
			req.getSession().removeAttribute(name);
			// }
		}

	}

	/**
	 * 2005-11-29 chenbailin ����ĳ���ܵ�ǰ�������¼��Ϣ�������session����
	 * 
	 * @param req
	 *            HttpServletRequest
	 */
	public static void sessionClearAll(HttpServletRequest req) {
		HttpSession s = req.getSession();
		Enumeration e = s.getAttributeNames();
		String an = null;
		while (e.hasMoreElements()) {
			an = (String) e.nextElement();
			if (log.isDebugEnabled())
				log.debug("session attr name:" + an);
			if (!an.equalsIgnoreCase(SysUserExtendedMVO.SESSION_NAME)
					&& !an.equalsIgnoreCase("hrefFuncNodes"))
				s.removeAttribute(an);
		}
	}

	/**
	 * ���ض���Ĳ�ѯ��¼����Ĭ��ΪDEF_PAGE_NUM
	 * 
	 * @param key
	 *            String
	 * @throws SysException
	 * @return int
	 */
	public static int getPageNum(String key) throws SysException {
		// ���û�г�ʼ���Ŷ����ݿ�
		if (PAGE_NUM == 0) {
			InputStream is = ReqUtil.class
					.getResourceAsStream("/page.properties");
			try {
				PropertyResourceBundle prb = new PropertyResourceBundle(is);
				String str = prb.getString(key);
				if (str != null) {
					Integer it = new Integer(str);
					PAGE_NUM = it.intValue();
				} else
					// if not config ,return default value.
					PAGE_NUM = DEF_PAGE_NUM;

			} catch (Exception ex) {
				PAGE_NUM = DEF_PAGE_NUM;
				ex.printStackTrace();
			}
		}
		return PAGE_NUM;
	}
	/**
	 * ��ȡ��־��Ϣ
	 */
     public static ActionLogSVO getActionLog(HttpServletRequest req){
        //��session�õ���¼�û���־��һЩ����
 		SysUserExtendedMVO suve = 
 			(SysUserExtendedMVO)req.getSession().getAttribute(SysUserExtendedMVO.SESSION_NAME);
 		ActionLogSVO actionLogSVO = new ActionLogSVO();						
 		actionLogSVO.setLoginId(suve.getSysUserSVO().getSysUserId());
 		String subSystems = suve.getUserSubSystems();
 		if(StringUtil.isBlank(subSystems)){
 			subSystems="SP";
 		}
 		actionLogSVO.setActionDomain(subSystems);
 		actionLogSVO.setActionModule(suve.getCurFuncNodeId());
 		actionLogSVO.setActionTime(DateUtil.getDBDate());
 		return actionLogSVO;
     }
     
     /**
      * add by xieyunchao 20130603����Action����ʱ����Ҫ��ת�����ֻ������ַ�����������ajax������ƶ�Ӧ�ÿͻ���)���˷�����Ϊ������ִ����ظ��Դ������װ
      * @param response 
      * @param str
      */
	public static void write(HttpServletResponse response, String str) {
		try {
				response.setCharacterEncoding("GBK");
				response.setContentLength(str.length());
				response.getOutputStream().write(str.getBytes());
				response.getOutputStream().flush();
				response.getOutputStream().close();
			}   catch (Exception e) {
			log.error("reponse data error!");
			e.printStackTrace();
		}
	}
     

     /**
     * @param str
     * @return
     * @throws IOException
     */
    public static  byte[] compress(String str)throws IOException{
 		
			ByteArrayOutputStream out = new ByteArrayOutputStream();
		    GZIPOutputStream gzip = new GZIPOutputStream(out);
		    gzip.write(str.getBytes("GBK"));
		    gzip.close();
		    return out.toByteArray();
     }
		
		/**
      * ���ڻ�ȡ�ͻ��˴����������˵�����
      * @param request
      * @return
		 * @throws SysException 
      * @throws IOException
      */
	public static String getRequestStr(HttpServletRequest request) throws SysException {
		String strDecrypted = null;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					(ServletInputStream) request.getInputStream(), "UTF-8"));
			StringBuffer sb = new StringBuffer("");
			String temp;
			while ((temp = br.readLine()) != null) {
				sb.append(temp);
			}
			br.close();

			if ("Y".equals(SysConfigData.getSysConfigCurValue(
					SysConstants.ENCRYPT_USABLE, null, null, null, null, null))) {
				// ��������
				strDecrypted = EncryptUtil.decryptThreeDESECB(sb.toString());
			} else {
				strDecrypted = sb.toString();
			}
		} catch (Exception e) {
			throw new SysException("1111","��ȡ�ͻ�������ʱʧ��",e);
		}
		return strDecrypted;
	}
     
}
