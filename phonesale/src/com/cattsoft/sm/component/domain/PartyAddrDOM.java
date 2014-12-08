package com.cattsoft.sm.component.domain;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.MaxId;
import com.cattsoft.sm.component.dao.IPartyAddrSDAO;
import com.cattsoft.sm.vo.PartyAddrSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-29 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class PartyAddrDOM {
	
    private IPartyAddrSDAO partyAddrDao = (IPartyAddrSDAO) DAOFactory.getInstance().getDAO(
            IPartyAddrSDAO.class);

    private static Logger log = Logger.getLogger(PartyAddrDOM.class);

    /**
     * ����������ѯ����partyAddrSVO
     * 
     * @param vo
     * @return partyAddrSVO
     * @throws SysException
     * @throws AppException
     */
    public PartyAddrSVO findByPk(PartyAddrSVO vo) throws SysException, AppException {
        return (PartyAddrSVO) partyAddrDao.findByPK(vo);
    }

    /**
     * ������Ӧ��������ѯ����partyAddrSVO
     * 
     * @param vo
     * @return List<partyAddrSVO>
     * @throws SysException
     * @throws AppException
     */
    public List findByVo(PartyAddrSVO vo) throws SysException, AppException {
        return partyAddrDao.findByVO(vo);
    }

    /**
     * �޸ĵ���partyAddrSVO
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     * @throws SQLException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void update(PartyAddrSVO vo) throws SysException, AppException {
        partyAddrDao.update(vo);

    }

    /**
     * ɾ������partyAddrSVO
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     */
    public void delete(PartyAddrSVO vo) throws SysException, AppException {

        partyAddrDao.update(vo);

    }

    /**
     * ���ӵ���partyAddrSVO������ʷ����Ϣ
     * 
     * @param vo
     * @throws SysException
     * @throws AppException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public void add(PartyAddrSVO vo) throws SysException, AppException {
        if (vo.getPartyAddrId() == null) {
            vo.setPartyAddrId(MaxId.getSequenceNextVal(Constant.SEQ_PARTY_ADDR_ID));
        }
        partyAddrDao.add(vo);

    }

}
