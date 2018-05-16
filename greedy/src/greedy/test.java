package greedy;

import java.util.ArrayList;

public class test {
	public static void main() {
		int n = 2;
		double maxV ;
	ArrayList<double[]> list = new ArrayList<double[]>();
	double[] weight = new double[5];
	double[] value = new double[5];
	
	Greedy greedy = new Greedy();
	InputAndOutputFiles iaof = new InputAndOutputFiles();

	list = iaof.readDataFile(n);
	weight = list.get(0);
	value = list.get(1);
	 
	maxV =greedy.bigBag(weight, value);
	
	}
}
