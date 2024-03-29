package com.buleheart.thinking.code.io;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

public class TextFile extends ArrayList<String> {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Read a file as single string;
	public static String read(String fileName){
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader in = new BufferedReader(
					new FileReader(
							new File(fileName).getAbsoluteFile()));
			try {
				String s;
				while ((s = in.readLine()) != null){
					sb.append(s);
					sb.append("\n");
				}
			}finally{
				in.close();
			}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} 
		return sb.toString();
	}
	// Write a single file in one method call:
	public static void write(String fileName,String text){
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				out.print(text);
			} finally {
				out.close();
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	// Read a file, split by any regular expression:
	public TextFile(String fileName,String spiltter){
		super(Arrays.asList(read(fileName).split(spiltter)));
		//Regular expression split()v often leaves an empty
		//String at the first position:
		if(get(0).equals("")) remove(0);
	}
	//Normally read by lines:
	public TextFile(String fileName){
		this(fileName,"\n");
	}
	public void write(String fileName){
		try {
			PrintWriter out = new PrintWriter(
					new File(fileName).getAbsoluteFile());
			try {
				for (String item : this) {
					out.println(item);
				}
			} finally {
				out.close();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	public static void main(String[] args){
		String file = read("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/TextFile.java");
		write("test.txt",file);
		TextFile text = new TextFile("test.txt");
		text.write("test2.txt");
		//Break into unique sorted list of wods:
		TreeSet<String> words = new TreeSet<String>(
				new TextFile("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/TextFile.java",""));
		//Display the capitalized words:
		System.out.println(words.headSet("ABSC"));
		
	}
}
