package com.cattsoft.pub.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.cattsoft.pub.SysConstants;
import com.cattsoft.pub.exception.DataCacheException;
import com.cattsoft.pub.exception.SysException;
import com.cattsoft.sm.vo.SysAreaConfigSVO;
import com.cattsoft.sm.vo.SysConfigSVO;

/**
 * Title: CRM <br>
 * Description: <br>
 * Date: 2007-8-9 <br>
 * Copyright (c) 2007 CATTSoft <br>
 * 
 * @author luojia
 */
public class SysConfigData {
    public SysConfigData() {
    }
    
    /**
     * ����SysConfigIdȡSysConfig ������
     * @param configId
     * @return
     * @throws DataCacheException
     */
    public static SysConfigSVO getSysConfigById(String configId) throws DataCacheException{
    	return getSysConfigById(configId,null,null,null,null, null);
    }

    /**
     * ����ϵͳ���ñ���Լ������Ų��Ҷ�Ӧ��ֵSysConfigSVO
     * 
     * @param configId
     * @param localNetId
     * @param areaId
     * @param workAreaId
     * @param exchId
     * @param workTypeId TODO
     * @return
     * @throws DataCacheException
     */
    public static SysConfigSVO getSysConfigById(String configId, String localNetId, String areaId,
    		String workAreaId, String exchId, String workTypeId) throws DataCacheException {
    	SysConfigSVO vo = new SysConfigSVO();
        SysConfigSVO voResult = new SysConfigSVO();        
        try {
            Map configMap = DataCache.getCache(DataCache.SYS_CONFIG);
            Map sysAreaConfigMap = DataCache.getCache(DataCache.SYS_AREA_CONFIG);
            Map areaConfigMap =  null;
            if(sysAreaConfigMap != null && !sysAreaConfigMap.isEmpty()){
            	areaConfigMap = (Map)sysAreaConfigMap.get( configId);
            	if(areaConfigMap == null){
            		areaConfigMap = new HashMap();
            	}
            }else{
            	areaConfigMap = new HashMap();
            }
            
            
            if (configMap == null || configMap.isEmpty()) {
                return null;
            }
            vo = (SysConfigSVO) configMap.get(configId);
            SysAreaConfigSVO areaVO = new SysAreaConfigSVO();
            if (vo == null) {
                return null;
            }
            if (SysConstants.SYS_CONFIG_TYPE_PROVINCE.equalsIgnoreCase(vo.getConfigType())) {
                return vo;
            } else if (SysConstants.SYS_CONFIG_TYPE_LOCALNET.equalsIgnoreCase(vo.getConfigType())) {
                if (StringUtil.isBlank(localNetId)) {
                    throw new DataCacheException("1000031","ϵͳ���������ǰ����������ã�������ʱȱ�ٱ�����������",null);
                }
                areaVO = (SysAreaConfigSVO) areaConfigMap.get(localNetId.toString());
            } else if (SysConstants.SYS_CONFIG_TYPE_AREA.equalsIgnoreCase(vo.getConfigType())) {
                if (StringUtil.isBlank(areaId)) {
                	throw new DataCacheException("1000031","ϵͳ���������ǰ����������ã�������ʱȱ�ٷ�����������",null);
                }
                areaVO = (SysAreaConfigSVO) areaConfigMap.get(areaId.toString());
            } else if (SysConstants.SYS_CONFIG_TYPE_WORKAREA.equalsIgnoreCase(vo.getConfigType())) {
                if (StringUtil.isBlank(workAreaId)) {
                	throw new DataCacheException("1000031","ϵͳ���������ǰ��������ã�������ʱȱ�ٹ���������",null);
                }
                areaVO = (SysAreaConfigSVO) areaConfigMap.get(workAreaId.toString());
            } else if (SysConstants.SYS_CONFIG_TYPE_EXCH.equalsIgnoreCase(vo.getConfigType())) {
                if (StringUtil.isBlank(exchId)) {
                	throw new DataCacheException("1000031","ϵͳ���������ǰ��������ã�������ʱȱ�پ��������",null);
                }
                areaVO = (SysAreaConfigSVO) areaConfigMap.get(exchId.toString());
            } else if (SysConstants.SYS_CONFIG_TYPE_WORKTYPE.equalsIgnoreCase(vo.getConfigType())) {
                if (StringUtil.isBlank(workTypeId)) {
                	throw new DataCacheException("1000031","ϵͳ���������ǰ������������ã�������ʱȱ�ٹ������Ͳ�����",null);
                }
                areaVO = (SysAreaConfigSVO) areaConfigMap.get(workTypeId.toString());
            } else {
                return null;
            }
            voResult.setConfigId(vo.getConfigId());
            voResult.setConfigType(vo.getConfigType());
            voResult.setCreateDate(vo.getCreateDate());
            voResult.setCurValue(vo.getCurValue());
            voResult.setName(vo.getName());
            voResult.setSystemName(vo.getSystemName());
            voResult.setValueDesc(vo.getValueDesc());
            if (areaVO != null) {
                voResult.setCurValue(areaVO.getCurValue());
                voResult.setValueDesc(areaVO.getValueDesc());
            }

        } catch (Exception ex) {
            throw new DataCacheException(ex);
        }
        return voResult;
    }

    /**
     * ����valueֵ���Ҷ�Ӧ��SYS_CONFIG_ID,��Ӧ�ķ�������VALUEֵ
     * 
     * @param curValue
     * @param spAreaId
     * @return
     * @throws DataCacheException
     */
    public static String getSysConfigByCurValue(String curValue, Integer spAreaId)
            throws DataCacheException {
        try {
            SysAreaConfigSVO result = new SysAreaConfigSVO();
            Map sysConfigMap = DataCache.getCache(DataCache.SYS_CONFIG);
            if (sysConfigMap == null || sysConfigMap.isEmpty()) {
                return null;
            }
            Iterator ite = sysConfigMap.keySet().iterator();
            Object key;
            SysConfigSVO vo = new SysConfigSVO();
            while (ite.hasNext()) {
                key = ite.next();
                vo = (SysConfigSVO) sysConfigMap.get(key.toString());
                if (curValue.equals(vo.getCurValue())) {
                    if ("A".equalsIgnoreCase(vo.getConfigType())) {
                        HashMap areaSysConfigMap = (HashMap)DataCache.getCache(DataCache.SYS_AREA_CONFIG).get(vo.getConfigId());
                        if (areaSysConfigMap != null) {
                            result = (SysAreaConfigSVO) areaSysConfigMap.get(spAreaId.toString());
                        }
                    }
                    break;
                }
            }
            if (result == null) {
                return null;
            }
            return result.getCurValue();
        } catch (DataCacheException be) {
            throw new DataCacheException(be);
        }
    }

    /**
     * ����valueֵ���Ҷ�Ӧ��SYS_CONFIG_ID,���ݸñ�ŷ������Ӧ�����з�������SysAreaConfigSVO�����LIST
     * 
     * @param curValue
     * @return
     * @throws DataCacheException
     */
    public static List getSpecSysConfigByCurValue(String curValue) throws DataCacheException {
        try {
            List result = new ArrayList();
            Map sysConfigMap = DataCache.getCache(DataCache.SYS_CONFIG);
            HashMap areaSysConfigMap = new HashMap();
            if (sysConfigMap == null || sysConfigMap.isEmpty()) {
                return null;
            }
            Iterator ite = sysConfigMap.keySet().iterator();
            Object key;
            SysConfigSVO vo = new SysConfigSVO();
            while (ite.hasNext()) {
                key = ite.next();
                vo = (SysConfigSVO) sysConfigMap.get(key.toString());
                if (curValue.equals(vo.getCurValue().toString())) {
                    areaSysConfigMap = (HashMap) DataCache.getCache(DataCache.SYS_AREA_CONFIG).get(vo.getConfigId());
                    break;
                }
            }
            if (areaSysConfigMap != null) {
                Iterator ite1 = areaSysConfigMap.keySet().iterator();
                Object areaKey;
                SysAreaConfigSVO areaSVO = new SysAreaConfigSVO();
                while (ite1.hasNext()) {
                    areaKey = ite1.next();
                    areaSVO = (SysAreaConfigSVO) areaSysConfigMap.get(areaKey.toString());
                    result.add(areaSVO);
                }
            }
            return result;

        } catch (DataCacheException be) {
            throw new DataCacheException(be);
        }
    }
    
    
    
    /**
     * ����ϵͳ���ñ���Լ������Ų��Ҷ�Ӧ��ֵ
     * @param configId
     * @param localNetId
     * @param areaId
     * @param workAreaId
     * @param exchId
     * @return
     * @throws DataCacheException
     */
    public static String getSysConfigCurValue(String configId, String localNetId, String areaId,
    		String workAreaId, String exchId,String workTypeId) throws SysException {
    	SysConfigSVO sysConfig = null;
		try {
			sysConfig = getSysConfigById(configId,localNetId,areaId,workAreaId,exchId, workTypeId);
		} catch (DataCacheException e) {
			throw new SysException("1000019","��ȡϵͳ����SysConfig����",e);
		}
    	if(sysConfig == null) {
    		return null;
    	}
    	
    	return sysConfig.getCurValue();
    	
    }
    
    /**
     * ����name���ֲ��Ҷ�Ӧ��CONFIG_ID,��Ӧ��VALUEֵ  
     * 
     * �����ƶ�ҵ��ͨ  by baijm 2010-10-28
     * @param name
     * @param spAreaId
     * @return
     * @throws DataCacheException
     */
    public static String getSysConfigByName(String name, Integer spAreaId)
            throws SysException {
    	String result = null;
        try {
        	Map sysConfigMap = DataCache.getCache(DataCache.SYS_CONFIG);
        	if (sysConfigMap == null || sysConfigMap.isEmpty()) {
        		return null;
        	}
        	Iterator ite = sysConfigMap.keySet().iterator();
        	Object key;
        	SysConfigSVO vo = new SysConfigSVO();
        	while (ite.hasNext()) {
        		key = ite.next();
        		vo = (SysConfigSVO) sysConfigMap.get(key.toString());
        		if (name.equals(vo.getName())){
        			result = vo.getCurValue();
        			break;
        		}      		
        	}      	
        } catch (DataCacheException be) {
        	throw new SysException("1000019","��ȡϵͳ����SysConfig����",be);
        }
    	if (result == null) {
    		return null;
    	}
    	return result;
    }
   
}
