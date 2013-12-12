package cn.cnic.dp.util;

import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {
	
	private Properties prop;
	
	private PropertyUtil(){
		prop = new Properties();  
		InputStream fis = null;
		try {
			fis = this.getClass().getResourceAsStream(StaticUtil.PROPERTY_NAME);
			prop.load(fis);    
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
	private static PropertyUtil instance = null;
	public static PropertyUtil getInstance() {
		if(instance==null) {
			instance = new PropertyUtil();
		}
		return instance;
	}
	
	public Integer getIntegerPropertyValue(String propertyKey) {
		String obj = prop.getProperty(propertyKey);
		if(obj!=null) {
			return Integer.parseInt(obj);
		}
		return null;
	}
	
	public String getPropertyValue(String propertyKey) {
		Object obj = prop.get(propertyKey);
		if(obj!=null) {
			return (String)obj;
		}
		return null;
	}
}
