package test1;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Random;

public class Main {
	public int[] fen(int[] a,int s,int e,String loc){
		if(s==e){
			int[] end1 = new int[]{a[s],s,s};
			return end1;
		}
		int mid = (s+e)/2;
		int[] l_list = fen(a,s,mid,"左");
		int l_sum = l_list[0];
		int[] r_list = fen(a,mid+1,e,"右");
		int r_sum = r_list[0];	
		int[] mid_list = midMax(a, s, mid, e);
		int mid_sum = mid_list[0];
		System.out.println("左总和："+l_sum+"右总和： "+r_sum+"跨中和："+mid_sum+" 最大的位置："+loc);
		if(l_sum>r_sum&&l_sum>mid_sum){
			return l_list;
		}else if(r_sum>l_sum&&r_sum>mid_sum){
			int[] endr = new int[]{r_sum,mid+1,e};
			return r_list;
		}else{
			return mid_list;
		}
	}
	public int[] midMax(int[] a,int s,int m,int e){
		int sum = 0;
		int l = 0;
		int r = 0;
		//System.out.println(s+" "+m+" "+e);
		int left_sum = a[m];
		l = m;
		for(int i = m;i>=s;i--){
			sum += a[i];
			if(sum > left_sum){
				l = i;
				left_sum = sum;
			}
		}
		sum = 0;
		int right_sum = a[m+1];
		r = m+1;
		
		for(int i = m+1; i<=e;i++){
			sum += a[i];
			if(sum > right_sum){
				r = i; 
				right_sum = sum;
			}
		}
		
		
		int[] end = new int[]{left_sum+right_sum,l,r};
		return end;
	}
}
