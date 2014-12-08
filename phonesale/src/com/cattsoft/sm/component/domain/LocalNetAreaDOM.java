package com.cattsoft.sm.component.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.sm.component.dao.ILocalNetAreaMDAO;
import com.cattsoft.sm.vo.AreaSVO;
import com.cattsoft.sm.vo.LocalNetSVO;

public class LocalNetAreaDOM {
	
    private ILocalNetAreaMDAO localNetAreaMDao = (ILocalNetAreaMDAO) DAOFactory.getInstance()
            .getDAO(ILocalNetAreaMDAO.class);

    /**
     * ����Ա����������������������Ϣ���ҳ�������ǰ̨��ʾ�ı�������Ϣ
     * 
     * @param LocalNetSVO
     *            vo1, AreaSVO vo2
     * @return List<LabelValueBean>
     * @throws AppException
     * @throws SysException
     */
    public List findLocalNet(LocalNetSVO vo1, AreaSVO vo2) throws AppException, SysException {
        return localNetAreaMDao.findLocalNet(vo1, vo2);
    }

    /**
     * ����Ա����������������������Ϣ���ҳ�������ǰ̨��ʾ�ķ�������Ϣ
     * 
     * @param LocalNetSVO
     *            vo1,AreaSVO vo2
     * @return List<LabelValueBean>
     * @throws AppException
     * @throws SysException
     */
    public List findArea(LocalNetSVO vo1, AreaSVO vo2) throws AppException, SysException {
        return localNetAreaMDao.findArea(vo1, vo2);
    }

    /**
     * ������������������
     * 
     * @param vo1
     * @param vo2
     * @return
     * @throws AppException
     * @throws SysException
     */
    public String initLocalNetAreaTree(LocalNetSVO vo1, AreaSVO vo2) throws AppException,
            SysException {
    return null;
    }

    /**
     * ���ڵ�
     * 
     * @param list
     * @return
     */
    private List convertNodeBean(List list) {
    	return null;
    }

    /**
     * Ҷ�ӽڵ�
     * 
     * @param list
     * @return
     */
    private List convertLeafNodeBean(List list) {
return null;
    }
}
