package com.cattsoft.sm.component.domain;

import java.util.List;
import java.util.Set;

import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.DAOFactory;
import com.cattsoft.pub.util.MaxId;
import com.cattsoft.pub.util.PagInfo;
import com.cattsoft.pub.util.PagView;
import com.cattsoft.sm.component.dao.IOtherCharacteristicSDAO;
import com.cattsoft.sm.vo.OtherCharacterApplyRangeSVO;
import com.cattsoft.sm.vo.OtherCharacteristicMVO;
import com.cattsoft.sm.vo.OtherCharacteristicSVO;
import com.cattsoft.webpub.util.SysDateUtil;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-10-19 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author anzhiqiang
 */
public class OtherCharacteristicDOM {
	

    private IOtherCharacteristicSDAO characteristicDao = (IOtherCharacteristicSDAO) DAOFactory
            .getInstance().getDAO(IOtherCharacteristicSDAO.class);

    /**
     * ��ȡ������Ϣ
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @return List<CharacteristicSVO>
     * @author longtao
     */
    public List findCharacteristic(OtherCharacteristicSVO vo) throws AppException, SysException {
        return characteristicDao.findByVO(vo);
    }

    /**
     * ����������ѯ���Ե���ϸ��Ϣ
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @return CharacteristicSVO
     * @author longtao
     */
    public OtherCharacteristicSVO getCharacteristic(OtherCharacteristicSVO vo) throws AppException,
            SysException {
        return (OtherCharacteristicSVO) characteristicDao.findByPK(vo);
    }

    /**
     * ����������Ϣ
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @author longtao
     */
    public String addCharacteristic(OtherCharacteristicSVO vo) throws AppException, SysException {
        if (vo.getCharacteristicId() == null)
            vo.setCharacteristicId(MaxId.getSequenceNextVal(Constant.SEQ_CHARACTERISTIC_ID));
        vo.setCreateDate(SysDateUtil.getCurrentTimestamp());
        vo.setStsDate(SysDateUtil.getCurrentTimestamp());
        vo.setSts(Constant.STS_IN_USE);
        characteristicDao.add(vo);
        return vo.getCharacteristicId();
    }

    /**
     * ɾ��������Ϣ
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @author longtao
     */
    public void deleteCharacteristic(OtherCharacteristicSVO vo) throws AppException, SysException {
        vo.setStsDate(SysDateUtil.getCurrentTimestamp());
        vo.setSts(Constant.STS_HISTORY);
        characteristicDao.update(vo);
    }

    /**
     * ����ɾ��������Ϣ
     * 
     * @param String[]
     *            characteristicIds
     * @throws AppException
     * @throws SysException
     * @author longtao
     */
    public void deleteBatchCharacteristic(String[] characteristicIds) throws AppException,
            SysException {
        for (int i = 0, size = characteristicIds.length; i < size; i++) {
            OtherCharacteristicSVO vo = new OtherCharacteristicSVO();
            vo.setCharacteristicId(characteristicIds[i]);
            vo.setStsDate(SysDateUtil.getCurrentTimestamp());
            vo.setSts(Constant.STS_HISTORY);
            characteristicDao.update(vo);
        }
    }

    /**
     * �޸�������Ϣ
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @author longtao
     */
    public void updateCharacteristic(OtherCharacteristicSVO vo) throws AppException, SysException {
        vo.setStsDate(SysDateUtil.getCurrentTimestamp());
        characteristicDao.update(vo);
    }

    /**
     * ��ȡ������Ϣ ----���÷�������
     * 
     * @param CharacteristicSVO
     * @param PagInfo
     * @throws AppException
     * @throws SysException
     * @return PagView
     * @author longtao
     */
    public PagView findCharacteristicPage(OtherCharacteristicMVO vo, PagInfo pagInfo, Set set)
            throws AppException, SysException {
        return characteristicDao.findCharacteristicMVO(vo, pagInfo, set);
    }

    /**
     * ���������Ƿ����ɾ��
     * 
     * @param String[]
     *            characteristicIds
     * @throws AppException
     * @throws SysException
     * @return String "true"--����ɾ����"false"--������ɾ��
     * @author longtao
     */
    public String valiCharacteristicDelete(String[] characteristicIds) throws AppException,
            SysException {
        return null;

    }

    /**
     * У�����������Ƿ��ѱ�ʹ��
     * 
     * @param CharacteristicSVO
     * @throws AppException
     * @throws SysException
     * @return String "true"--δ��ʹ��;"false"--��ʹ��
     */
    public String valiCharacteristicNameRepeat(OtherCharacteristicSVO vo) throws AppException,
            SysException {
        List judgeList = characteristicDao.findByVO(vo);
        if (judgeList != null && judgeList.size() > 0) {
            return "false";
        } else {
            return "true";
        }
    }

    /**
     * ��ȡ������Ϣ ----������Ӧ��Χ
     * 
     * @param CharacteristicSVO
     * @param PagInfo
     * @throws AppException
     * @throws SysException
     * @return PagView
     * @author longtao
     */
    public PagView findByRange(OtherCharacteristicMVO vo, PagInfo pagInfo, Set set)
            throws AppException, SysException {
        return characteristicDao.findCharacteristicMVOByRange(vo, pagInfo, set);
    }
}
