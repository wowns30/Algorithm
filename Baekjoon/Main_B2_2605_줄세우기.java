package IMPrepare;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_B2_2605_줄세우기 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int[] input=new int[n];
		for(int i=0;i<n;i++)
			input[i]=sc.nextInt();
		
		LinkedList<Integer> list=new LinkedList<>();
	
		for(int i=0;i<n;i++) 
			list.add(list.size()-input[i], i+1);
		
		for(int i=0;i<n;i++)
			System.out.print(list.get(i)+" ");
	}
}
