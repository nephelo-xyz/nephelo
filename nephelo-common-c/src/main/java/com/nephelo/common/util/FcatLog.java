package com.nephelo.common.util;

import lombok.extern.log4j.Log4j2;

import java.util.Date;

@Log4j2
public class FcatLog {
	private Class<?> clazz;
    public FcatLog(Class<?> clazz) {
        this.clazz = clazz;
    }
    public boolean isDebugEnabled() {
    	return true;
    }
    public void debug(Object message) {
      //if(repository.isDisabled(Level.DEBUG_INT))
        //return;
      //if(Level.DEBUG.isGreaterOrEqual(this.getEffectiveLevel())) {
    	  StringBuilder sb = new StringBuilder();
    	  sb.append(DateUtil.formatDate(new Date(),"yyyy-MM-dd HH:mm:ss"));
  		  sb.append(" ");
  		  sb.append("INFO");
  		  sb.append(" ");
  		  sb.append("(");
  		  sb.append(StrUtil.getInvokStack(clazz));
  		  sb.append(")");
  		  sb.append(" - ");
  		  sb.append(message);
  		  //
  		 log.info(sb.toString());
      //}
    }
}
