package com.buleheart.thinking.code.io;

import java.util.Arrays;
import java.util.Collection;

public class PPrint {
	public static String pformat(Collection<?> c){
		if(c.size() == 0) return "[]";
		StringBuffer result = new StringBuffer();
		for(Object elem : c){
			if(c.size() != 1)
				result.append("\n ");
			result.append(elem);
		}
		if(c.size() != 1)
			result.append("\n");
		result.append("}");
		return result.toString();	
	}
	public static void pprint(Object[] c){
		System.out.println(pformat(Arrays.asList(c)));
	}
}
