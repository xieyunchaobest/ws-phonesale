package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRptJtbbQsfzrbSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRptJtbbQsfzrbSVO extends GenericVO {private String cpMc = null;private Date createDate = null;private String fgs = null;private Date openDate = null;private String qgs = null;private int flagCpMc = 0;private int flagCreateDate = 0;private int flagFgs = 0;private int flagOpenDate = 0;private int flagQgs = 0;public String getCpMc(){ return cpMc;}public void setCpMc(String newValue){  this.cpMc = newValue;  flagCpMc = 1;}public int getFlagCpMc(){  return flagCpMc;}public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getFgs(){ return fgs;}public void setFgs(String newValue){  this.fgs = newValue;  flagFgs = 1;}public int getFlagFgs(){  return flagFgs;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getQgs(){ return qgs;}public void setQgs(String newValue){  this.qgs = newValue;  flagQgs = 1;}public int getFlagQgs(){  return flagQgs;}public void clearFlagCpMc(){ flagCpMc = 0 ;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagFgs(){ flagFgs = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagQgs(){ flagQgs = 0 ;}public void clearAll(){ flagCpMc = 0; flagCreateDate = 0; flagFgs = 0; flagOpenDate = 0; flagQgs = 0;}}
