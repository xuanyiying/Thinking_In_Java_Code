package com.buleheart.thinking.code.io;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

//build the anonymous inner class 
/**
 * 
 * @author wangying
 *
 */
public class DirectoryList3 {
	public static void main(final String[] args) {
		File path = new File(".");
		String[] list;
		if(args.length == 0){
			list = path.list();
		}else{
			list = path.list(new FilenameFilter(){
				private Pattern pattern = Pattern.compile(args[0]);
				public boolean accept(File dir, String name) {
					return pattern.matcher(name).matches();
				}
			});
			Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
			for (String dirItem : list) {
				System.out.println(dirItem);
			}
		}
	}
}
