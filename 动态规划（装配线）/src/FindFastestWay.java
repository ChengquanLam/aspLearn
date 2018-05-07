//×°ÅäÏß

public class FindFastestWay {

	public int[] fastestWay(int[][] a, int[][] t, int[] e, int[] x, int n) {
		int[][] f = new int[3][n + 2];
		int[][] line = new int[3][n + 3];
		int[] result = null;
		f[1][1] = a[1][1] + e[1];
		f[2][1] = a[2][1] + e[2];

		for (int i = 2; i <= n; i++) {
			if (f[1][i - 1] + a[1][i] <= f[2][i - 1] + t[2][i - 1] + a[1][i]) {
				f[1][i] = f[1][i - 1] + a[1][i];
				line[1][i] = 1;
			} else if (f[1][i - 1] + a[1][i] > f[2][i - 1] + t[2][i - 1]
					+ a[1][i]) {
				f[1][i] = f[2][i - 1] + t[2][i - 1] + a[1][i];
				line[1][i] = 2;
			}
			if (f[2][i - 1] + a[2][i] <= f[1][i - 1] + t[1][i - 1] + a[2][i]) {
				f[2][i] = f[2][i - 1] + a[2][i];
				line[2][i] = 2;
			} else if(f[2][i - 1] + a[2][i] > f[1][i - 1] + t[1][i - 1] + a[2][i]){
				f[2][i] = f[1][i - 1] + t[1][i - 1] + a[2][i];
				line[2][i] = 1;
			}
		}
		
		if (f[1][n] + x[1] <= f[2][n] + x[2]) {
			f[1][n + 1] = f[1][n] + x[1];
			line[1][n + 1] = 1;
			line[1][n + 2] = f[1][n] + x[1];
			line[2][n + 2] = 0;
		} else if (f[1][n] + x[1] > f[2][n] + x[2]) {
			line[2][n + 1] = 2;
			line[2][n + 2] = f[2][n] + x[2];
			line[1][n + 2] = 0;
		}
		
		if (line[1][n + 2] > 0) {
			result = line[1];
		} else if (line[2][n + 2] > 0) {
			result = line[2];
		}
		return result;
	}
}
