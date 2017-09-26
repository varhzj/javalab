package com.varhzj.lab.interview;

public class UniqueString {

    public static boolean isUniqueChars(String s) {
	if (s.length() > 256) {
	    return false;
	}

	boolean[] charSet = new boolean[256];

	for (int i = 0; i < s.length(); i++) {
	    int val = s.charAt(i);
	    if (charSet[val]) {
	        return false;
	    }
	    charSet[val] = true;
	}
	
	return true;
    }

    public static void main(String[] args) {
	String str = args[0];
        System.out.println(isUniqueChars(str));
    }

}
