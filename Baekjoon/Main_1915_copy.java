package BOJ6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1915 골드5 가장 큰 정사각형
 * nXm의 0,1로 채워진 배열이 있다. 이 배열에서 1로 이루어진 가장 큰 정사각형의 크기를 구하라
 * hint : 다이나믹 프로그래밍
 * 
 * 아이디어 : n과 m중 작은 수로 만들 수 있는 정사각형의 크기를 정하면 그 수가 최고로 큰 정사각형의 크기가 된다. 예를 들어 n<m이라고 하고 문제를 풀어보자
 * nxm 배열에서 mxm의 정사각형이 존재하는지 파악한다. 없으면 m-1 x m-1 크기의 정사각형이 존재하는지 확인한다. 없으면 m-2 x m-2 크기의 정사각형이 존재하는지 확인한다.
 * 이때 존재하면 m-2 x m-2를 출력하면 된다.
 * 그렇다면 
 */

public class Main1915_copy {

	static int n, m, x, ans;
	static int arr[][], d[][];
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		//n과 m중 작은 수를 x로 저장 받는다.
		arr = new int[n][m];
		d = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			for(int j=0; j<m; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}
		//입력 완료
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j] == 1) {
					d[i][j] = 1;
					ans = 1;
				}
			}
		}
		for(int i=1; i<n; i++) {
			for(int j=1; j<m; j++) {
				if(arr[i-1][j] == 1 && arr[i-1][j-1] == 1 && arr[i][j-1] == 1) {
					d[i][j] = Math.min(d[i-1][j], d[i-1][j-1]);
					d[i][j] = Math.min(d[i][j], d[i][j-1]) + 1;
				}
				ans = Math.max(d[i][j], ans);
			}
		}
		System.out.println(ans*ans);
	}
}
