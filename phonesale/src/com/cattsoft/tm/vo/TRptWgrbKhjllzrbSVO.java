package com.cattsoft.tm.vo;import java.io.*;import com.cattsoft.pub.vo.GenericVO;import java.util.*;import java.sql.Clob;import java.sql.Blob; /**   * TRptWgrbKhjllzrbSVO   * @author ����С����   * @version 1.1  2007-9-23   * <p>Company: ��������</p>  */public class TRptWgrbKhjllzrbSVO extends GenericVO {private Date createDate = null;private String ghDtfz = null;private String ghDyljc = null;private String ghDyljfz = null;private String kdDtfz = null;private String kdDyljc = null;private String kdDyljfz = null;private String khjlXm = null;private Date openDate = null;private String rh2gDtfz = null;private String rh2gDyljfz = null;private String rh3gDtfz = null;private String rh3gDyljfz = null;private String wgCode = null;private String wgMc = null;private int flagCreateDate = 0;private int flagGhDtfz = 0;private int flagGhDyljc = 0;private int flagGhDyljfz = 0;private int flagKdDtfz = 0;private int flagKdDyljc = 0;private int flagKdDyljfz = 0;private int flagKhjlXm = 0;private int flagOpenDate = 0;private int flagRh2gDtfz = 0;private int flagRh2gDyljfz = 0;private int flagRh3gDtfz = 0;private int flagRh3gDyljfz = 0;private int flagWgCode = 0;private int flagWgMc = 0;public Date getCreateDate(){  return createDate;}public void setCreateDate(Date newValue){   this.createDate = newValue;  flagCreateDate = 1;}public int getFlagCreateDate(){  return flagCreateDate;}public String getGhDtfz(){ return ghDtfz;}public void setGhDtfz(String newValue){  this.ghDtfz = newValue;  flagGhDtfz = 1;}public int getFlagGhDtfz(){  return flagGhDtfz;}public String getGhDyljc(){ return ghDyljc;}public void setGhDyljc(String newValue){  this.ghDyljc = newValue;  flagGhDyljc = 1;}public int getFlagGhDyljc(){  return flagGhDyljc;}public String getGhDyljfz(){ return ghDyljfz;}public void setGhDyljfz(String newValue){  this.ghDyljfz = newValue;  flagGhDyljfz = 1;}public int getFlagGhDyljfz(){  return flagGhDyljfz;}public String getKdDtfz(){ return kdDtfz;}public void setKdDtfz(String newValue){  this.kdDtfz = newValue;  flagKdDtfz = 1;}public int getFlagKdDtfz(){  return flagKdDtfz;}public String getKdDyljc(){ return kdDyljc;}public void setKdDyljc(String newValue){  this.kdDyljc = newValue;  flagKdDyljc = 1;}public int getFlagKdDyljc(){  return flagKdDyljc;}public String getKdDyljfz(){ return kdDyljfz;}public void setKdDyljfz(String newValue){  this.kdDyljfz = newValue;  flagKdDyljfz = 1;}public int getFlagKdDyljfz(){  return flagKdDyljfz;}public String getKhjlXm(){ return khjlXm;}public void setKhjlXm(String newValue){  this.khjlXm = newValue;  flagKhjlXm = 1;}public int getFlagKhjlXm(){  return flagKhjlXm;}public Date getOpenDate(){  return openDate;}public void setOpenDate(Date newValue){   this.openDate = newValue;  flagOpenDate = 1;}public int getFlagOpenDate(){  return flagOpenDate;}public String getRh2gDtfz(){ return rh2gDtfz;}public void setRh2gDtfz(String newValue){  this.rh2gDtfz = newValue;  flagRh2gDtfz = 1;}public int getFlagRh2gDtfz(){  return flagRh2gDtfz;}public String getRh2gDyljfz(){ return rh2gDyljfz;}public void setRh2gDyljfz(String newValue){  this.rh2gDyljfz = newValue;  flagRh2gDyljfz = 1;}public int getFlagRh2gDyljfz(){  return flagRh2gDyljfz;}public String getRh3gDtfz(){ return rh3gDtfz;}public void setRh3gDtfz(String newValue){  this.rh3gDtfz = newValue;  flagRh3gDtfz = 1;}public int getFlagRh3gDtfz(){  return flagRh3gDtfz;}public String getRh3gDyljfz(){ return rh3gDyljfz;}public void setRh3gDyljfz(String newValue){  this.rh3gDyljfz = newValue;  flagRh3gDyljfz = 1;}public int getFlagRh3gDyljfz(){  return flagRh3gDyljfz;}public String getWgCode(){ return wgCode;}public void setWgCode(String newValue){  this.wgCode = newValue;  flagWgCode = 1;}public int getFlagWgCode(){  return flagWgCode;}public String getWgMc(){ return wgMc;}public void setWgMc(String newValue){  this.wgMc = newValue;  flagWgMc = 1;}public int getFlagWgMc(){  return flagWgMc;}public void clearFlagCreateDate(){ flagCreateDate = 0 ;}public void clearFlagGhDtfz(){ flagGhDtfz = 0 ;}public void clearFlagGhDyljc(){ flagGhDyljc = 0 ;}public void clearFlagGhDyljfz(){ flagGhDyljfz = 0 ;}public void clearFlagKdDtfz(){ flagKdDtfz = 0 ;}public void clearFlagKdDyljc(){ flagKdDyljc = 0 ;}public void clearFlagKdDyljfz(){ flagKdDyljfz = 0 ;}public void clearFlagKhjlXm(){ flagKhjlXm = 0 ;}public void clearFlagOpenDate(){ flagOpenDate = 0 ;}public void clearFlagRh2gDtfz(){ flagRh2gDtfz = 0 ;}public void clearFlagRh2gDyljfz(){ flagRh2gDyljfz = 0 ;}public void clearFlagRh3gDtfz(){ flagRh3gDtfz = 0 ;}public void clearFlagRh3gDyljfz(){ flagRh3gDyljfz = 0 ;}public void clearFlagWgCode(){ flagWgCode = 0 ;}public void clearFlagWgMc(){ flagWgMc = 0 ;}public void clearAll(){ flagCreateDate = 0; flagGhDtfz = 0; flagGhDyljc = 0; flagGhDyljfz = 0; flagKdDtfz = 0; flagKdDyljc = 0; flagKdDyljfz = 0; flagKhjlXm = 0; flagOpenDate = 0; flagRh2gDtfz = 0; flagRh2gDyljfz = 0; flagRh3gDtfz = 0; flagRh3gDyljfz = 0; flagWgCode = 0; flagWgMc = 0;}}
