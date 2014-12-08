package com.cattsoft.tm.component.dao;
import java.util.List;

import com.cattsoft.pub.dao.ISDAO;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
 /**
   * ����IWoHandleSDAO
   * <p>Company: �������</p>
   * @author ����С����
   * @version 1.0  2007-5-14
  */
public interface IWoHandleSDAO extends ISDAO{
 
	public void addBat(List vos)throws AppException,SysException;

	public String query(String workAreaId) throws AppException, SysException;
       }

