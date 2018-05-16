package greedy;
import java.util.Arrays;
import java.util.ArrayList;

public class Greedy {

	public double bigBag(double[] weight,double[] value) {
		double c =300;
		int n = 7;
		
		double[] r = new double[n]; //性价比数组
		
        int[] index = new int[n];  
        for (int i = 0; i < n; i++) {  
            r[i] = (double) value[i] / (double) weight[i];  
            index[i] = i;  
        } 
        
        double temp = 0;  
        for (int i = 0; i < n - 1; i++) {  
            for (int j = i + 1; j < n; j++) {  
                if (r[i] < r[j]) {  
                    temp = r[i];  
                    r[i] = r[j];  
                    r[j] = temp;  
                    int x = index[i];  
                    index[i] = index[j];  
                    index[j] = x;  
                }  
            }  
        } 
        
        /** 
         * 排序后的重量和价值分别存到w1[]和v1[]中 
         */  
        double[] w1 = new double[n];  
        double[] v1 = new double[n];  
        for (int i = 0; i < n; i++) {  
            w1[i] = weight[index[i]];  
            v1[i] = value[index[i]];  
        }  
        /** 
         * 初始化解向量x[n] 
         */  
        double[] x = new double[n];  
        for (int i = 0; i < n; i++) {  
            x[i] = 0;  
        }  
        /** 
         * 求解并打印解向量 
         */  
        for (int i = 0; i < n; i++) {  
            if (w1[i] < c) {  
                x[i] = 1;  
                c = c - w1[i];  
            }  
        }  
        //System.out.println("The solution vector is(解向量是：)" + Arrays.toString(x));  
        /** 
         * 根据解向量求出背包中存放物品的最大价值并打印 
         */  
      double maxValue = 0;  
        for (int i = 0; i < n; i++) {  
            if (x[i] == 1)  
                maxValue += v1[i];  
        }
        
        return maxValue +=(c-maxValue);

	}
	
	
}