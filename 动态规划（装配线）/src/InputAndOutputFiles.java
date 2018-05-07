import java.io.*;
import java.util.ArrayList;

public class InputAndOutputFiles {

	public int[] RandomNumber(int n) {
		int[] r = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			r[i] = (int) (Math.random() * 10 + 1);
		}
		return r;
	}

	public void createDataFile(int n) {
		File f = new File("E:/data.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			int e[]= RandomNumber(2);
			int x[]= RandomNumber(2);
			int a[][] = new int[3][];
			int t[][] = new int[3][];
			a[1] = RandomNumber(n);
			a[2] = RandomNumber(n);
			t[1] = RandomNumber(n-1);
			t[2] = RandomNumber(n-1);

			bw.write("e ");
			for (int i = 1; i < e.length; i++) {
				bw.write(String.valueOf(e[i]) + " ");
			}
			bw.newLine();
			bw.write("x ");
			for (int i = 1; i < x.length; i++) {
				bw.write(String.valueOf(i) + " ");

			}
			bw.newLine();
			bw.write("a1 ");
			for (int i = 1; i < a[1].length; i++) {
				bw.write(String.valueOf(a[1][i]) + " ");

			}
			bw.newLine();
			bw.write("a2 ");
			for (int i = 1; i < a[2].length; i++) {
				bw.write(String.valueOf(a[2][i]) + " ");

			}
			bw.newLine();
			bw.write("t1 ");
			for (int i = 1; i < t[1].length; i++) {
				bw.write(String.valueOf(t[1][i]) + " ");

			}
			bw.newLine();
			bw.write("t2 ");
			for (int i = 1; i < t[2].length; i++) {
				bw.write(String.valueOf(t[2][i]) + " ");

			}
			bw.newLine();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public ArrayList<int[]> readDataFile(int n) {
		File f = new File("E:/data.txt");
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<int[]> list = null;
		try {
			list = new ArrayList<int[]>(10);
			int e[] = new int[3];
			int x[] = new int[3];
			int a[][] = new int[3][n + 1];
			int t[][] = new int[3][n];

			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String se[] = br.readLine().split(" ");
			for (int i = 1; i < se.length; i++) {
				e[i] = Integer.parseInt(se[i]);
			}

			String sx[] = br.readLine().split(" ");
			for (int i = 1; i < sx.length; i++) {
				x[i] = Integer.parseInt(sx[i]);
			}

			String sa1[] = br.readLine().split(" ");
			for (int i = 1; i < sa1.length; i++) {
				a[1][i] = Integer.parseInt(sa1[i]);
			}

			String sa2[] = br.readLine().split(" ");
			for (int i = 1; i < sa2.length; i++) {
				a[2][i] = Integer.parseInt(sa2[i]);
			}

			String st1[] = br.readLine().split(" ");
			for (int i = 1; i < st1.length; i++) {
				t[1][i] = Integer.parseInt(st1[i]);
			}

			String st2[] = br.readLine().split(" ");
			for (int i = 1; i < st2.length; i++) {
				t[2][i] = Integer.parseInt(st2[i]);
			}
			list.add(e);
			list.add(x);
			list.add(a[1]);
			list.add(a[2]);
			list.add(t[1]);
			list.add(t[2]);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
				fr.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public void createResultFile(int[] result,int n) {
		File f = new File("E:/results.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			bw.write("最快路线:");
			bw.newLine();
			for (int i = 1; i <= n; i++) {
				bw.write("第" + String.valueOf(result[i+1]) + "条装配线 " + "第" + i
						+ "站点");
				bw.newLine();
			}
			bw.newLine();
			bw.write("最短时间是:" + String.valueOf(result[n+2]));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
				fw.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
