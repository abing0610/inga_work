package test;

import java.io.FileInputStream;
import java.util.Properties;

public class readconfig {

	public static void main(String[] args) {
		Properties prop =  new Properties();
		try {
			prop.load(new FileInputStream("d:/test.properties"));
			
//			System.out.println(prop.size());
			System.out.println(prop.getProperty("test"));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
