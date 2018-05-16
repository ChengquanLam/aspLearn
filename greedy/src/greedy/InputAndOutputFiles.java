package greedy;
import java.io.*;
import java.util.ArrayList;

public class InputAndOutputFiles {


	public void createDataFile(int n) {
		File f = new File("E:/data.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			int e[]= null;
			int x[]= null;


			bw.write("各物品的重量 ：");
			for (int i = 1; i < e.length; i++) {
				bw.write(String.valueOf(e[i]) + " ");
			}
			bw.newLine();
			bw.write("各物品的价值： ");
			for (int i = 1; i < x.length; i++) {
				bw.write(String.valueOf(i) + " ");

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

	public ArrayList<double[]> readDataFile(int n) {
		File f = new File("E:/data.txt");
		FileReader fr = null;
		BufferedReader br = null;
		ArrayList<double[]> list = null;
		try {
			list = new ArrayList<double[]>(10);
			double weight[] = new double[5];
			double value[] = new double[5];
		
			fr = new FileReader(f);
			br = new BufferedReader(fr);

			String sweight[] = br.readLine().split(" ");
			for (int i = 1; i < sweight.length; i++) {
				weight[i] = Double.parseDouble(sweight[i]);
			}

			String svalue[] = br.readLine().split(" ");
			for (int i = 1; i < svalue.length; i++) {
				value[i] = Double.parseDouble(svalue[i]);
			}


			list.add(weight);
			list.add(value);
		

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
		File f = new File("E:/result.txt");
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			bw.write("背包能装的最大价值是：");
			bw.newLine();
			
			
			bw.write("maxV");//最大价值的值ֵ

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
