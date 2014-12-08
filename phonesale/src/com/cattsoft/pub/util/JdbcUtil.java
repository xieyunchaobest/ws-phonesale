package com.cattsoft.pub.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cattsoft.pub.exception.SysException;

public class JdbcUtil {
	
	
	/**
	 * �ر� ResultSet��Statement��Connection
	 * @param rs
	 * @param st
	 * @param con
	 * @throws SysException 
	 */
    public static void close(ResultSet rs, Statement ps, Connection con) throws  SysException
    {
        close(rs,ps);
        close(con);
    }

    /**
     * �ر�ResultSet��Statement
     * @param rs
     * @param st
     * @throws SysException 
     */
    public static void close(ResultSet rs, Statement ps) throws  SysException
    {
        close(rs);
        close(ps);
    }

    /**
     * �ر�Connection
     * @param con
     * @throws ConnectionException 
     */
    public static void close(Connection con) throws SysException
    {
        try
        {
            if(con != null)
                con.close();
        }
        catch(SQLException e) { 
        	e.printStackTrace();
        	
        	throw new SysException("100000","�ر�con����ʱ�����쳣��",e);
        }
    }

    /**
     * �ر�ResultSet
     * @param rs
     * @throws SysException 
     */
    public static void close(ResultSet rs) throws  SysException
    {
        try
        {
            if(rs != null)
                rs.close();
        }
        catch(SQLException e) { 
        	e.printStackTrace();
        	throw new SysException("100000","�ر�rs����ʱ�����쳣��",e);
        }
    }

    /**
     * �ر�Statement
     * @param st
     * @throws ConnectionException 
     * @throws SysException 
     */
    public static void close(Statement ps) throws  SysException
    {
        try
        {
            if(ps != null)
            	ps.close();
        }
        catch(SQLException e) { 
        	throw new SysException("100000","�ر�statementʱ�����쳣��",e);
        }
    }

}
