package BOJ6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main1633_2 {

	static int white[], black[];
	static int index;
	static int dp[][][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		white = new int[1001];
		black = new int[1001];
		index = 0;
		while(st.hasMoreTokens()) {
			white[index] = Integer.parseInt(st.nextToken());
			black[index] = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(in.readLine(), " ");
			index++;
		}
		dp = new int[1001][16][16];
		System.out.println(sol(0,0,0,index));
	}
	private static int sol(int i, int w, int b, int N) {
		if(w == 15 && b == 15) {
			return 0;
		}
		if(i == N) {
			return 0;
		}
		if(dp[i][w][b] != 0) {
			return dp[i][w][b];
		}
		int ans = sol(i+1, w, b, N);
		
		if(w<15) {
			ans = Math.max(ans, sol(i+1, w+1, b, N) + white[i]);
		}
		if(b<15) {
			ans = Math.max(ans, sol(i+1, w, b+1, N) + black[i]);
		}
		dp[i][w][b] = ans;
		return dp[i][w][b];
	}
}
