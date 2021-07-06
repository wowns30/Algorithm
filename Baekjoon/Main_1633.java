package BOJ6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main1633 implements Comparator<Integer>{

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		ArrayList<Integer> listB = new ArrayList<>();
		ArrayList<Integer> listW = new ArrayList<>();
		while(st.hasMoreTokens()) {
			listB.add(Integer.parseInt(st.nextToken()));
			listW.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(in.readLine(), " ");
		}
//		System.out.println(listB);
//		System.out.println(listW);
		int arr[][] = new int[listB.size()][2];
		for(int i=0; i<listB.size(); i++) {
			arr[i][0] = listB.get(i);
			arr[i][1] = listW.get(i);
		}
		System.out.println(Arrays.deepToString(arr));
		//입력 완료
	}
	@Override
	public int compare(Integer o1, Integer o2) {
		return o1 - o2;
	}

}
