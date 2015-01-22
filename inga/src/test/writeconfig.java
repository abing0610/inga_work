package test;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Properties;

public class writeconfig {

	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			
			OutputStream fos = new FileOutputStream("d:/test.properties");
			prop.setProperty("tes22t", "123!@#$aÄã½ÐÊ²Ã´£¿");
			prop.store(fos, null);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
}
