package com.brainmentors.ims.common.listener;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.log4j.Logger;

import com.brainmentors.ims.cache.dto.CacheDTO;
import com.brainmentors.ims.common.dao.CacheDAO;
import com.brainmentors.ims.common.utils.CacheConstants;
import com.brainmentors.ims.common.utils.CommonUtils;


@WebListener
public class CacheListener implements ServletContextListener {
	Logger logger = Logger.getLogger(CacheListener.class);

    private static  Map<String,List<CacheDTO>> cacheMap = new HashMap<>();
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // Server Down
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
         // Server Start
    	System.out.println("Server Start...");
    	try {
			cacheMap.put(CacheConstants.ROLE_KEY, CacheDAO.getData("roles"));
		} catch (NamingException e) {
			
			logger.error(CommonUtils.convertStackTraceToString(e));
		} catch (SQLException e) {
			
			logger.error(CommonUtils.convertStackTraceToString(e));
		}
    	
    	
    }
    public static Map<String,List<CacheDTO>> getAllCacheMap(){
    	return cacheMap;
    }
    public static List<CacheDTO> getCacheMap(String key){
    	return cacheMap.get(key);
    }
	
}
