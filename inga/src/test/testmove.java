package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class testmove {

	public static void main(String[] args) {
		try {
			int     bytesum     =     0;    
	        int     byteread     =     0;    
	        File     oldfile     =     new     File("d:/test/file/"+0+".txt");    
	        if     (oldfile.exists())     {      
	                InputStream     inStream     =     new     FileInputStream("d:/test/file/"+0+".txt");     
	                FileOutputStream     fs     =     new     FileOutputStream("d:/test/"+ 0 + ".txt");    
	                byte[]     buffer     =     new     byte[1444];    
//	                int     length;    
	                while     (     (byteread     =     inStream.read(buffer))     !=     -1)     {    
	                        bytesum     +=     byteread;        
	                        System.out.println(bytesum);    
	                        fs.write(buffer,     0,     byteread);    
	                }    
	                inStream.close();    
	        }    
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
