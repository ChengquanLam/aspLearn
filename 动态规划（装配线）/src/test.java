import java.util.ArrayList;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		ArrayList<int[]> list = new ArrayList<int[]>(7);
		int[] e = new int[3];
		int[] x = new int[3];
		int[][] a = new int[3][n + 1];
		int[][] t = new int[3][n + 1];
		int[] result = new int[n + 3];

		FindFastestWay ffw = new FindFastestWay();
		InputAndOutputFiles iaof = new InputAndOutputFiles();
		//iaof.createDataFile(n);

		list = iaof.readDataFile(n);
		e = list.get(0);
		x = list.get(1);
		a[1] = list.get(2);
		a[2] = list.get(3);
		t[1] = list.get(4);
		t[2] = list.get(5);

		result = ffw.fastestWay(a, t, e, x, n);
		iaof.createResultFile(result, n);
	}

}
