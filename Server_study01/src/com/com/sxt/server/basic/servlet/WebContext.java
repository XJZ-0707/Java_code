package com.com.sxt.server.basic.servlet;

import com.sxt.server.basic.servlet.Entity;
import com.sxt.server.basic.servlet.Mapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WebContext {
	private List<com.sxt.server.basic.servlet.Entity> entitys  =null;
	private List<com.sxt.server.basic.servlet.Mapping> mappings =null;
	//key-->servlet-name  value -->servlet-class
	private Map<String,String> entityMap =new HashMap<String,String>();
	//key -->url-pattern value -->servlet-name
	private Map<String,String> mappingMap =new HashMap<String,String>();
	public WebContext(List<com.sxt.server.basic.servlet.Entity> entitys, List<com.sxt.server.basic.servlet.Mapping> mappings) {
		this.entitys = entitys;
		this.mappings = mappings;
		
		//将entity 的List转成了对应map
		for(Entity entity:entitys) {
			entityMap.put(entity.getName(), entity.getClz());
		}
		//将map 的List转成了对应map
		for(Mapping mapping:mappings) {
			for(String pattern: mapping.getPatterns()) {
				mappingMap.put(pattern, mapping.getName());				
			}
		}
	}
	/**
	 * 通过URL的路径找到了对应class
	 * @param pattern
	 * @return
	 */
	public String getClz(String pattern) {
		String name = mappingMap.get(pattern);
		return entityMap.get(name);
	}
	
}
