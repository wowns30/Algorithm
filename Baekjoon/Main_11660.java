package BOJ6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main11660 {

	static int N, M;
	static int arr[][];
	static int cal[][];
	static int scope[][];
	static int x1,y1,x2,y2,sum,sum2;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N+1][N+1];
		scope = new int[M+1][5];
		
		cal = new int[N+1][N+1];
		
		for(int i=1; i<N+1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1; j<N+1; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				cal[i][j] = cal[i-1][j] + cal[i][j-1] - cal[i-1][j-1] + arr[i][j];
			}
		}
		for(int i=1; i<M+1; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for(int j=1; j<5; j++) {
				scope[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=1; i<M+1; i++) {
			sum = cal[scope[i][3]][scope[i][4]] - cal[scope[i][3]][scope[i][2]-1] - cal[scope[i][1]-1][scope[i][4]] + cal[scope[i][1]-1][scope[i][2]-1];
			//scope가 (x1,y1) (x2,y2)라 하면 
			//cal[x2][y2] - cal[x2][y1-1] - cal[x1-1][y2] + cal[x1-1][y1-1]
			System.out.println(sum);
		}
	}
}
