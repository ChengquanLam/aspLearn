package test1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Random;

public class Create {
	Boolean bool = false;
	public static String path = "E:\\";
	String filePath = null;

	public Boolean CreateFile(String name, int[] arr) {
		filePath = path + name + ".txt";
		File file = new File(filePath);
		
		try {
			if(file.exists()) {
				deleteFile(filePath);
				CreateFile(name, arr);
			}else{
					file.createNewFile();
					bool = true;
					//System.out.println("文件创建成功");
					write(filePath, arr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bool;

	}
	public boolean write(String path,int[] arr) throws IOException{
		FileOutputStream fis = null;
		
		
		BufferedReader br = null;
		OutputStreamWriter osw  = null;
		
		
		InputStreamReader isr = null;
		try {
			fis = new FileOutputStream(path);
			osw = new OutputStreamWriter(fis);
			
			for (int i = 0;i<arr.length;i++){
				osw.write(String.valueOf(arr[i])+"");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		osw.close();

		fis.close();

		return true;
	}
	public boolean deleteFile(String path){
		File file = new File(path);
		file.delete();
		return true;
	}
}
