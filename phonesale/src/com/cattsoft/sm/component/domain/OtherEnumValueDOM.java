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
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.component.dao.IOtherEnumValueSDAO;
import com.cattsoft.sm.vo.OtherEnumValueSVO;

public class OtherEnumValueDOM {
	
    private IOtherEnumValueSDAO enumValueDao = (IOtherEnumValueSDAO) DAOFactory.getInstance()
            .getDAO(IOtherEnumValueSDAO.class);

    public List findEnumValue(OtherEnumValueSVO vo) throws AppException, SysException {
        return enumValueDao.findByVO(vo);
    }

    public OtherEnumValueSVO getEnumValue(OtherEnumValueSVO vo) throws AppException, SysException {
        return (OtherEnumValueSVO) enumValueDao.findByPK(vo);
    }

    public String addEnumValue(OtherEnumValueSVO vo) throws AppException, SysException {
        if(vo.getEnumValueId()==null)
        vo.setEnumValueId(MaxId.getSequenceNextVal(Constant.SEQ_OTHER_ENUM_VALUE_ID));
        enumValueDao.add(vo);
        return vo.getEnumValueId();
    }

    public void deleteEnumValue(OtherEnumValueSVO vo) throws AppException, SysException {
        enumValueDao.delete(vo);
    }

    public void updateEnumValue(OtherEnumValueSVO vo) throws AppException, SysException {
        enumValueDao.update(vo);
    }

    /**
     * �������ԡ����Ա����ֵ����
     * 
     * @param EnumValueSVO
     *            vo
     * @param PagInfo
     *            pagInfo
     * @throws AppException
     * @throws SysException
     * @return PagView ��ҳ��ѯ�Ľ��
     * @author longtao
     */
    public PagView findEnumValuePage(GenericVO vo, PagInfo pagInfo, Set set) throws AppException,
            SysException {
        return enumValueDao.findEnumValueMVO(vo, pagInfo, set);
    }

    public void deleteBatchEnumValue(String[] enumValueIds) throws AppException, SysException {
        for (int i = 0, size = enumValueIds.length; i < size; i++) {
            OtherEnumValueSVO vo = new OtherEnumValueSVO();
            vo.setEnumValueId(enumValueIds[i]);
            enumValueDao.delete(vo);
        }
    }

    /**
     * У������ֵ�Ƿ���Ա�ɾ�� *
     * 
     * @param String
     * @throws AppException
     * @throws SysException
     * @return String "true"--����ɾ��;"false"--����ɾ��
     * @author longtao
     */
    public String valiEnumValueDelete(String[] enumValueIds) throws AppException, SysException {

        return "true";
    }

    /**
     * У������ֵ�����Ƿ�ʹ��
     * 
     * @param EnumValueSVO
     * @throws AppException
     * @throws SysException
     * @return String "true"--δ��ʹ��;"false"--��ʹ��
     * @author longtao
     */
    public String valiEnumValueNameRepeat(OtherEnumValueSVO vo) throws AppException, SysException {
        List judgeList = enumValueDao.findByVO(vo);
        if (judgeList != null && judgeList.size() > 0) {
            return "false";
        } else {
            return "true";
        }
    }
}
