package com.cattsoft.sm.component.dao.oracleImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.cattsoft.pub.connection.ConnectionFactory;
import com.cattsoft.pub.exception.AppException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.pub.util.CollectionFactory;
import com.cattsoft.pub.util.Constant;
import com.cattsoft.pub.util.ResultSetUtil;
import com.cattsoft.pub.vo.GenericVO;
import com.cattsoft.sm.component.dao.ILocalNetAreaMDAO;
import com.cattsoft.sm.vo.AreaSVO;
import com.cattsoft.sm.vo.LocalNetSVO;

public class LocalNetAreaMDAOImpl implements ILocalNetAreaMDAO {

    public List findLocalNet(GenericVO vo1, GenericVO vo2) throws AppException, SysException {
       
    	List results = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);
        LocalNetSVO localNet = (LocalNetSVO) vo1;
        AreaSVO area = (AreaSVO) vo2;
        if (localNet.getLocalNetId() == null) {
            throw new AppException("", "�޷����Ա������������");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("select LOCAL_NET_ID,NAME from LOCAL_NET where 1=1");
        if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
            /** TODO �������������ı����������ķ���������Ҫ������еķ����� */
        } else {
            /** ���������������ı����������������ı������������ķ�������ֻ�ܻ�ȡ�Լ�����Ϣ */
            sql.append(" and LOCAL_NET_ID = ?");
        }
        if (localNet.getSts() != null) {
            sql.append(" and STS = ?");
        }
        sql.append(" order by LOCAL_NET_ID desc");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            int index = 1;
            if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                    && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
                /** TODO �������������ı����������ķ���������Ҫ������еķ����� */
            } else {
                ps.setString(index++, localNet.getLocalNetId());
            }
            if (localNet.getSts() != null) {
                ps.setString(index++, localNet.getSts());
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                LabelValueBean option = new LabelValueBean();
                option.setLabel(rs.getString("NAME"));
                option.setValue(rs.getString("LOCAL_NET_ID"));
                results.add(option);
            }
        } catch (SQLException e) {
            throw new SysException("", "findLocalNet error..", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return results;
    }

    public List findArea(GenericVO vo1, GenericVO vo2) throws AppException, SysException {
        List results = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);
        LocalNetSVO localNet = (LocalNetSVO) vo1;
        AreaSVO area = (AreaSVO) vo2;
        if (area.getLocalNetId() == null) {
            throw new AppException("", "�޷����Ա������������������");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("select AREA_ID,NAME from AREA where 1=1");
        /** Ա����������Ϊ���ı����������ķ�����,��ʱ��Ҫ�ڷ������б��ж��һ����"���з�����"�ļ�¼ */
        if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
            sql.append(" and (LOCAL_NET_ID = ? or LOCAL_NET_ID = 0 )");
        } else {
            sql.append(" and LOCAL_NET_ID = ?");
        }
        if (area.getSts() != null) {
            sql.append(" and STS = ?");
        }
        sql.append(" order by AREA_ID desc");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            int index = 1;
            ps.setString(index++, area.getLocalNetId());
            if (area.getSts() != null) {
                ps.setString(index++, area.getSts());
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                LabelValueBean option = new LabelValueBean();
                option.setLabel(rs.getString("NAME"));
                option.setValue(rs.getString("AREA_ID"));
                results.add(option);
            }
        } catch (SQLException e) {
            throw new SysException("", "findArea error..", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return results;
    }

    /** �ڷ���ʱ��999��¼��û��ʵ������Ĺ�������Ӧ�ó�����ǰ̨ */
    public List findLocalNetTree(GenericVO vo1, GenericVO vo2) throws AppException, SysException {
        List results = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);
        LocalNetSVO localNet = (LocalNetSVO) vo1;
        AreaSVO area = (AreaSVO) vo2;
        if (localNet.getLocalNetId() == null) {
            throw new AppException("", "�޷����Ա������������");
        }
        StringBuffer sql = new StringBuffer();
        sql.append("select LOCAL_NET_ID,NAME from LOCAL_NET where 1=1");
        if (localNet.getLocalNetId() != null && area.getAreaId() != null) {
            if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                    && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
                /** TODO �������������ı����������ķ���������Ҫ������еķ�����,���ǲ�����999 */
                sql.append(" and LOCAL_NET_ID <> ?");
            } else {
                /** ���������������ı����������������ı������������ķ�������ֻ�ܻ�ȡ�Լ�����Ϣ */
                sql.append(" and LOCAL_NET_ID = ?");
            }
        }
        if (localNet.getSts() != null) {
            sql.append(" and STS = ?");
        }
        sql.append(" order by LOCAL_NET_ID desc");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            int index = 1;
            if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())) {
                /** TODO �������������ı����������ķ���������Ҫ������еķ����� */
                ps.setString(index++, Constant.CENTER_LOCAL_NET_ID);
            } else {
                ps.setString(index++, localNet.getLocalNetId());
            }
            if (localNet.getSts() != null) {
                ps.setString(index++, localNet.getSts());
            }
            rs = ps.executeQuery();
            results = (List) ResultSetUtil.convertToList(rs, LocalNetSVO.class);
        } catch (SQLException e) {
            throw new SysException("", "findLocalNet error..", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return results;
    }

    public List findAreaTree(GenericVO vo1, GenericVO vo2) throws AppException, SysException {
        List results = (List)CollectionFactory.createCollection(CollectionFactory.COLLECTION_LIST);
        LocalNetSVO localNet = (LocalNetSVO) vo1;
        AreaSVO area = (AreaSVO) vo2;
        StringBuffer sql = new StringBuffer();
        sql.append("select * from AREA where 1=1");
        if (localNet.getLocalNetId() != null && area.getAreaId() != null) {
            /** Ա����������Ϊ���ı��������ķ����� */
            if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                    && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
                sql.append(" and LOCAL_NET_ID <> ?");

            } else {
                sql.append(" and AREA_ID = ?");
                sql.append(" and LOCAL_NET_ID = ?");
            }
        }
        if (area.getSts() != null) {
            sql.append(" and STS = ?");
        }
        sql.append(" order by AREA_ID desc");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = ConnectionFactory.getConnection();
            ps = connection.prepareStatement(sql.toString());
            int index = 1;
            if (Constant.IS_CENTER_LOCAL_NET_Y.equalsIgnoreCase(localNet.getIscenter())
                    && Constant.IS_CENTER_AREA_Y.equalsIgnoreCase(area.getIscenter())) {
                ps.setString(index++, Constant.CENTER_LOCAL_NET_ID);
            } else {
                ps.setString(index++, area.getAreaId());
                ps.setString(index++, localNet.getLocalNetId());
            }

            if (area.getSts() != null) {
                ps.setString(index++, area.getSts());
            }
            rs = ps.executeQuery();
            results = (List) ResultSetUtil.convertToList(rs, AreaSVO.class);
        } catch (SQLException e) {
            throw new SysException("", "findArea error..", e);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
            }
        }
        return results;
    }
}
