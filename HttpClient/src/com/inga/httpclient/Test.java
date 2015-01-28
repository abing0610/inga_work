package com.inga.httpclient;

public class Test {
	public static void main(String[] args) {
		String str = "<span class=\"pipe\">|</span><a href=\"member.php?mod=logging&amp;action=logout&amp;formhash=d4bb54b1\">ÍË³ö</a>";
		String formH = str.substring(str.indexOf("formhash") + 9, str.indexOf("formhash") + 17);
		System.out.println(formH);
	}

}
