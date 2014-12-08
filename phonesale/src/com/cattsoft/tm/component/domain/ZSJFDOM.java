package com.cattsoft.tm.component.domain;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.cattsoft.pub.dao.DAOFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.DateUtil;
import com.cattsoft.pub.util.PasswordUtil;
import com.cattsoft.pub.util.StringUtil;
import com.cattsoft.sm.component.dao.ISysUserSDAO;
import com.cattsoft.sm.vo.SysUserSVO;
import com.cattsoft.tm.component.dao.IMosVersionMDAO;
import com.cattsoft.tm.component.dao.ITRpt2g3grhrbSDAO;
import com.cattsoft.tm.component.dao.IZSJFMDAO;
import com.cattsoft.tm.vo.FuncNodeSVO;
import com.cattsoft.tm.vo.FuncNodeTreeSVO;
import com.cattsoft.tm.vo.MosVersionSVO;
import com.cattsoft.tm.vo.TRpt2g3grhrbSVO;
import com.cattsoft.tm.vo.TRpt2gfzrbSVO;
import com.cattsoft.tm.vo.TRpt3grbSVO;
import com.cattsoft.tm.vo.TRptHfyb3gybSVO;
import com.cattsoft.tm.vo.TRptHfybGjywytbSVO;
import com.cattsoft.tm.vo.TRptJtbbHybrbSVO;
import com.cattsoft.tm.vo.TRptJtbbQsfzrbSVO;
import com.cattsoft.tm.vo.TRptKdywrbSVO;
import com.cattsoft.tm.vo.TRptWgybKdyfzbbSVO;
import com.cattsoft.tm.vo.TRptZdgzKhjlSVO;
import com.cattsoft.tm.vo.TRptZdywrtbSVO;

public class ZSJFDOM {
	
	public String login(String reqParm) throws AppException,SysException{
		ISysUserSDAO sysUserSDAO = (ISysUserSDAO) DAOFactory.getDAO(ISysUserSDAO.class);
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String userName=json.getString("userName");
		String passWord=json.getString("password");
		try {
			passWord=PasswordUtil.getMD5Str(passWord);
		} catch (NoSuchAlgorithmException e) {
			throw new AppException("", "加密过程出现错误！");
		}
		
		SysUserSVO sysUserSVO =new SysUserSVO();
		sysUserSVO.setSysUserName(userName);
		sysUserSVO.setPassword(passWord);
		
		List userList=sysUserSDAO.findByVO(sysUserSVO);
		if(userList==null || userList.size()==0) {
			throw new AppException("","用户名或密码错误！");
		}else {
			SysUserSVO sysuserSVO=(SysUserSVO)userList.get(0);
			Map  resMap=new HashMap();
			resMap.put("resultCode", "1");
			resMap.put("resultInfo", "登录成功！");
			List funcList=this.getFuncNodeListByUser(sysuserSVO);
	
			Map sysUserSVOMap=new HashMap();
			sysUserSVOMap.put("sysUserSVO", sysuserSVO);
			sysUserSVOMap.put("sysUserFuncTree", funcList);
			resMap.put("suveJsonObject", sysUserSVOMap);
			
			
			
			return com.alibaba.fastjson.JSONObject.toJSONString(resMap);
		}
	}
	
	/**
	 * 修改密码
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String modifyPwd(String reqParm) throws AppException,
			SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String oldPwd=json.getString("oldPwd");
		String newPwd=json.getString("newPwd");
		//String newPwdConfirm=json.getString("newPwdConfirm");
		String staffId=json.getString("staffId");
		String md5OldPwd="";
		String md5NewPwd="";
		try {
			md5OldPwd=PasswordUtil.getMD5Str(oldPwd);
			md5NewPwd=PasswordUtil.getMD5Str(newPwd);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new AppException("", "加密过程出现错误！");
		}
		
		ISysUserSDAO sysUserSDAO = (ISysUserSDAO) DAOFactory.getDAO(ISysUserSDAO.class);
		SysUserSVO user=new SysUserSVO();
		user.setSysUserId(staffId);
		user.setPassword(md5OldPwd);
		List userList=sysUserSDAO.findByVO(user);
		if(userList==null || userList.size()==0) {
			throw new AppException("","原密码输入错误");
		}
		
		SysUserSVO user1=new SysUserSVO();
		user1.setSysUserId(staffId);
		user1.setPassword(md5NewPwd);
		//user1.setUpdatePwdTime(DateUtil.getDBTimestamp());
		
		
		sysUserSDAO.update(user1);
		
		Map map=new HashMap();
		map.put("flag", "1");
		map.put("desc", "");
		
		return com.alibaba.fastjson.JSONObject.toJSONString(map);
		
	}
	
	/**
	 * 查询最新版本信息
	 * @return
	 * @throws AppException 
	 * @throws SysException 
	 */
	public String getLateVersion4MOS(String mosVersion) throws SysException, AppException{
		IMosVersionMDAO mosVersionMDAO = (IMosVersionMDAO)DAOFactory.getDAO(IMosVersionMDAO.class);
		JSONObject mosVersionObject=JSONObject.parseObject(mosVersion);
		String whichApp = mosVersionObject.getString("whichApp");
		MosVersionSVO mosVersionSVO = mosVersionMDAO.getLateVersion(whichApp);//得到最新版本
		String mosVersionSVOJson = com.alibaba.fastjson.JSONObject.toJSONString(mosVersionSVO);//将最新版本对象转换成json字符串
		return mosVersionSVOJson;
		
	}
	
	
	public List getFuncNodeListByUser(SysUserSVO user) throws AppException,SysException {
		com.cattsoft.tm.component.dao.IFuncNodeTreeSDAO treeSDAO = (com.cattsoft.tm.component.dao.IFuncNodeTreeSDAO) DAOFactory.getDAO(com.cattsoft.tm.component.dao.IFuncNodeTreeSDAO.class);
		FuncNodeTreeSVO atree=new FuncNodeTreeSVO();
		List treeList=treeSDAO.findByVO(atree);
		
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List userAllocList=zsjfmdao.getFuncNodeListByUser(user);
		
		if(treeList!=null && treeList.size()>0) {
			for(int i=0;i<treeList.size();i++) {
				List funcNodeList=new ArrayList();
				
				FuncNodeTreeSVO tree=(FuncNodeTreeSVO)treeList.get(i);
				tree.setUserFuncNodeList(funcNodeList);
				String treeId=tree.getNodeTreeId();
				System.err.println("treeId===="+treeId);
				if(userAllocList!=null && userAllocList.size()>0) {
					for(int j=0;j<userAllocList.size();j++) {
						FuncNodeSVO alloc=(FuncNodeSVO)userAllocList.get(j);
						String atreeId=alloc.getNodeTreeId();
						//System.out.println("atreeId="+atreeId);
						if(atreeId.equals(treeId)) {
							funcNodeList.add(alloc);
						}
					}
				}
				/**if(funcNodeList.size()==0) {
					treeList.remove(i);
				}**/
				
			}
		}else {
			throw new AppException("","该用户没有任何权限");
		}
		return treeList;
	}
	
	
	//重点关注之重点业务发展日报
	public String zdgz4zdywrb(String reqParm) throws AppException,SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		TRptZdywrtbSVO svo=new TRptZdywrtbSVO();
		svo.setOpenDate(d);
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=zsjfmdao.zdgz4zdywrb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	
	//呼市日报之重点业务发展日报
	public String hsrb4zdywfzrb(String reqParm) throws AppException,SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		TRptZdywrtbSVO svo=new TRptZdywrtbSVO();
		svo.setOpenDate(d);
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=zsjfmdao.hsrb4zdywfzrb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 呼市日报之3G业务日报
	 */
	public String hsrb43gyw(String reqParm) throws AppException, SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		String diqu=json.getString("dq");
		String showwgFlag=json.getString("showwgFlag");
		TRpt3grbSVO svo=new TRpt3grbSVO();
		svo.setOpenDate(d);
		svo.setT3grbDq(diqu);
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=zsjfmdao.hsrb43gyw(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		if(!StringUtil.isBlank(showwgFlag)) {
			List wglist=zsjfmdao.hsrb43gywDqList();
			if(wglist==null)wglist=new ArrayList();
			Map dqm=new HashMap();
			dqm.put("diqu", "全部");
			wglist.add(0, dqm);
			m.put("wglist", wglist);
		}
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	/**
	 * 呼市日报之2G业务日报
	 */
	public String hsrb42gyw(String reqParm ) throws AppException, SysException {
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		TRpt2gfzrbSVO svo=new TRpt2gfzrbSVO();
		svo.setOpenDate(d); 
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=zsjfmdao.hsrb42gyw(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	
	/**
	 * 呼市日报之宽带业务日报
	 */
	public String hsrb4kdyw(String reqParm) throws AppException, SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		TRptKdywrbSVO svo=new TRptKdywrbSVO();
		svo.setOpenDate(d); 
		IZSJFMDAO zsjfmdao = (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=zsjfmdao.hsrb4kdyw(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 呼市日报之2G3G融合
	 */
	public String hsrb42g3grh(String reqParm) throws AppException, SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		TRpt2g3grhrbSVO svo=new TRpt2g3grhrbSVO();
		svo.setOpenDate(d); 
		ITRpt2g3grhrbSDAO dao= (ITRpt2g3grhrbSDAO) DAOFactory.getDAO(ITRpt2g3grhrbSDAO.class);
		List list=dao.findByVO(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	
	/**
	 * 网格日报之重点业务揽装日报
	 */
	public String hsrb4zdywlz(String reqParm) throws AppException, SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		Date d=DateUtil.str2Date(date);
		String staffId=json.getString("staffId");
		Map aMap=new HashMap();
		aMap.put("openDate", date);
		aMap.put("staffId", staffId);
		  
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsrb4zdywlz(aMap);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 呼市日报之客户经理揽装日报
	 */
	public String hsrb4khjllz(String reqParm) throws AppException, SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		String wgMC=json.getString("diqu");
		String showwgFlag=json.getString("showwgFlag");
		String staffId=json.getString("staffId");
		
		Date d=DateUtil.str2Date(date);
		Map aMap=new HashMap();
		
		aMap.put("openDate", date);
		if(!StringUtil.isBlank(wgMC)) {
			//svo.setWgMc(wgMC);
			aMap.put("wgMC", wgMC);
		}
		aMap.put("staffId", staffId);
		
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsrb4khjllz(aMap);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		if(!StringUtil.isBlank(showwgFlag)) {
			List wglist=dao.getWgList4hsrb4khlzjlrb();
			if(wglist==null)wglist=new ArrayList();
			m.put("wglist", wglist);
		}
			
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	
	/**
	 * 获取该去除重复后的呼市日报之客户经理缆桩日报中的部门
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String getWgList4hsrb4khlzjlrb() throws AppException, SysException{
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.getWgList4hsrb4khlzjlrb();
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 集团日报之区级、市级业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4qsjywfzrb(String reqParm) throws AppException,
			SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		TRptJtbbQsfzrbSVO svo=new TRptJtbbQsfzrbSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.jtrb4qsjywfzrb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 集团日报之区级、市级业务发展日报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String jtrb4hybywfzrb(String reqParm) throws AppException,
			SysException {
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		TRptJtbbHybrbSVO svo=new TRptJtbbHybrbSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.jtrb4hybywfzrb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	

	/**
	 * 渠道日报各网点业务发展日报
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String qdrb4gwdywfzrb(String reqParm) throws AppException,SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		String staffId=json.getString("staffId");
		String wg=json.getString("diqu");
		String wgFlag=json.getString("showwgFlag");
		Map m=new HashMap();
		m.put("openDate", date);
		m.put("staffId", staffId);
		m.put("diqu", wg);
		
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List wgList=null;
		if(!StringUtil.isBlank(wgFlag)) {
			wgList=dao.qdrb4gwdywfzrbwgList();
			if(wgList==null) wgList=new ArrayList();
			Map m1=new HashMap();
			m1.put("diqu", "全部");
			wgList.add(0, m1);
		}
		
		List list=dao.qdrb4gwdywfzrb(m);
		if(list==null)list=new ArrayList();
		Map resm=new HashMap();
		resm.put("list", list);
		resm.put("wglist", wgList);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(resm);
		return res;
	}
	
	/**
	 * 呼市月报4关键指标月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4gjzbyb(String reqParm) throws AppException,
			SysException {
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		TRptHfybGjywytbSVO svo=new TRptHfybGjywytbSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsyb4gjzbyb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	
	/**
	 * 呼市月报43G业务月报
	 * 
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb43gywyb(String reqParm) throws AppException,
			SysException {
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		String wgMC=json.getString("diqu");
		String showwgFlag=json.getString("showwgFlag");
		
		TRptHfyb3gybSVO svo=new TRptHfyb3gybSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		if(!StringUtil.isBlank(wgMC)) {
			svo.setRbQy(wgMC);
		}
		
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsyb43gyb(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		if(!StringUtil.isBlank(showwgFlag)) {
			List wglist=dao.getWgList4hsyb43gyw();
			if(wglist==null)wglist=new ArrayList();
			m.put("wglist", wglist);
		}
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
	
	/**
	 * 呼市月报4宽带月发展情况
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsyb4kdyfzqk(String reqParm)  throws AppException,SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		TRptWgybKdyfzbbSVO svo=new TRptWgybKdyfzbbSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsyb4kdyfzqk(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	}
	 
	/**
	 * 呼市日报4网格经理重点关注
	 * @return
	 * @throws AppException
	 * @throws SysException
	 */
	public String hsrb4wgjlzdgz(String reqParm)  throws AppException,SysException{
		com.alibaba.fastjson.JSONObject json=com.alibaba.fastjson.JSONObject.parseObject(reqParm); 
		String date=json.getString("date");
		String staffId=json.getString("staffId");
		TRptZdgzKhjlSVO svo=new TRptZdgzKhjlSVO();
		Date d=DateUtil.str2Date(date);
		svo.setOpenDate(d);
		svo.setLoginId(staffId);
		IZSJFMDAO dao= (IZSJFMDAO) DAOFactory.getDAO(IZSJFMDAO.class);
		List list=dao.hsrb4wgjlzdgz(svo);
		if(list==null)list=new ArrayList();
		Map m=new HashMap();
		m.put("list", list);
		String res=com.alibaba.fastjson.JSONObject.toJSONString(m);
		return res;
	
	}
}
