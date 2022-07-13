package com.mindtree.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigureData {

	Properties pro;
	
	public ConfigureData() throws IOException {
		File src=new File("./PropertyFiles/object.properties");
		
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
	}
	
	public String getUrl() {
		return pro.getProperty("lurl");
	}

	public String getName() {
		return pro.getProperty("username");
	}
	
	public String getKey() {
		return pro.getProperty("password");
	}
}
