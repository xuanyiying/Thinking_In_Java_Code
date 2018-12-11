package com.buleheart.thinking.code.io.nio;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

//Use zip Compression to compress any number of files given on the command line.
public class ZipCompress {

	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/nio/test.txt");
		CheckedOutputStream csum = new CheckedOutputStream(fos,new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream out = new BufferedOutputStream(zos);
		zos.setComment("A test of java Zipping");
		for (String arg : args) {
			print("Writing file" + arg);
			BufferedReader in = new BufferedReader(new FileReader(arg));
			zos.putNextEntry(new ZipEntry(arg));
			int c;
			while((c = in.read())!= -1){
				out.write(c);
			}
			in.close();
			out.flush();
		}
		out.close();
		// Checksum valid only after the file has been closd!
		print("Checksum: " +csum.getChecksum().getValue());
		FileInputStream fi = new FileInputStream("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/nio/test.zip");
		CheckedInputStream csum1 = new CheckedInputStream(fi,new Adler32());
		ZipInputStream in2 = new ZipInputStream(csum1);
		BufferedInputStream bis = new BufferedInputStream(in2);
		ZipEntry ze;
		while((ze = in2.getNextEntry()) != null){
			print("Reading file " + ze);
			int x;
			while((x = bis.read()) != -1){
				System.out.write(x);
			}
		}
		if(args.length == 1){
			print("Checksum: " + csum1.getChecksum().getValue());			
		}
		bis.close();
		//Alternative way to open Zip files:
		ZipFile zf = new ZipFile("D:/work/Thinking_In_Java_Code/src/com/buleheart/thinking/code/io/nio/test.zip");
		Enumeration e = zf.entries();
		while(e.hasMoreElements()){
			ZipEntry ze2 = (ZipEntry) e.nextElement();
			print("File: " +ze2);
		}
		
	}

	private static void print(String value) {
		System.out.println(value);
		
	}

}
