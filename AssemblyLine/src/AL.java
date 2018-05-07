import java.io.FileWriter; 
import java.io.*;
import java.io.IOException;


public class AL {
	int[][] f =new int[3][6];
	int out1,out2,in1,in2,shortT;
	String bstway;
	 
	static int[][] a = new int[][]{{},{7,9,3,4,8,4},{8,5,6,4,5,7}};
		
	int[][] t = new int[][]{{},{0,2,3,1,3,4},{0,2,1,2,2,1}};
	int[][] l = new int[3][6];
	public void AssemblyLine() throws IOException{
		FileReader fr = new FileReader("E:\\input.txt");
	  
	   	
		f[1][0] = in1+a[1][0];
		f[2][0] = in2+a[2][0];
		for(int i = 1;i<a[1].length;i++){
			if((a[1][i]+f[1][i-1])<(f[2][i-1]+t[2][i]+a[1][i])){
				f[1][i] = a[1][i]+f[1][i-1];
				l[1][i] = 1;
			}else{
				f[1][i] = f[2][i-1]+t[2][i]+a[1][i];
				l[1][i] = 2;
						
			}
			if((a[2][i]+f[2][i-1])<(f[1][i-1]+t[1][i]+a[2][i])){
				f[2][i] = a[2][i]+f[2][i-1];
				l[2][i] = 2;
			}else{
				f[2][i] = f[1][i-1]+t[1][i]+a[2][i];
				l[2][i] = 1;
			}
		}
		if((f[1][a[1].length-1]+in1)<(f[2][a[2].length-1])+in2){
			shortT = f[1][a[1].length-1]+out1;
			bstway = "wayUp";
		}else{
			shortT = f[2][a[2].length-1]+out2;
			bstway = "wayDown";
		}
	}
	public static void main(String[] args) throws IOException { 
		FileWriter fw = new FileWriter("E:\\AssemblyLine.txt",false);
		FileReader fr = new FileReader("E:\\input.txt");
		
		
		AL al = new AL();
		al.in1 = 2;
		al.in2 = 4;
		al.out1 = 3;
		al.out2 = 2;
		al.AssemblyLine();
		
		System.out.println("最短装配过程花费时间是"+al.shortT);
		System.out.println("两条装配路径的过程分别是：");
		for(int i =1;i<3;i++) {
			for(int j = 0;j<6;j++) {
				System.out.print(al.l[i][j]+"");
			}System.out.println("");
		}
		
		System.out.println("各装配点的完成时间如下：");
		for(int i =1;i<3;i++) {
			for(int j = 0;j<6;j++) {
				System.out.print(al.f[i][j]+" ");
			}
			System.out.println("");
		}
		
		System.out.println("应该选择装配路径"+al.bstway);
	
		
	//输出到文本
		fw.write("最短装配过程花费的时间是"+al.shortT);
		
//		fw.write(al.shortT);
		fw.write("两条装配过程路径分别为");
		
		for(int i =1;i<3;i++){
			for(int j=0;j<6;j++){
				fw.write(al.l[i][j]+" ");
				
//				System.out.print(al.f[i][j]+" ");
			}
			System.out.println("  ");
		}
		fw.flush();
		
	}
}
