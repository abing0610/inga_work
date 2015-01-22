package test;

import java.io.File;

public class readPathAllName {

	public static void main(String[] args) {
		File file = new File("d:/test/record/");
		
		File[] array = file.listFiles();
		
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i].getName());
		}
	}
}
