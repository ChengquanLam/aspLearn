package test1;

import java.awt.Graphics;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JFrame {
	FileInputStream fos;
	DataInputStream dis;
	int[] arr = new int[10];
	int[] a = new int[10];
	int i = 0;
	public test() {}

	public void createFile() {
		for (int i = 0; i < arr.length; i++) {
			Random ran = new Random();
			arr[i] = ran.nextInt(10) - 10;
		}
		Create create = new Create();
		create.CreateFile("input", arr);
		Main main = new Main();
		int[] test = main.fen(readFile(), 0, a.length - 1, "开始");
		System.out.println( test[0] + " 起始数" + test[1] + " 结束数" + test[2]);
	}
	public int[] readFile(){
		Create create = new Create();
		String path = create.path + "input.txt";
		try {
			fos = new FileInputStream(path);
			dis = new DataInputStream(fos);
			while (dis.available() > 0) {
				int ar = dis.readInt();
				a[i] = ar;
				++i;
				System.out.println(ar);
			}
			dis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
	}
	public static void main(String[] args) throws IOException {
	   new test().createFile();
	}
}
