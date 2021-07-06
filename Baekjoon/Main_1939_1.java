package BOJ6_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1939_1 {

	static int N,M,A,B,C;
	static int arr[][];
	static int temp, ans, max;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());//섬의 개수
		M = Integer.parseInt(st.nextToken());//다리 개수
		max = 0;
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			max = Math.max(max, C);
			arr[i][0] = A;
			arr[i][1] = B;
			arr[i][2] = C;
		}
		
	}

}
