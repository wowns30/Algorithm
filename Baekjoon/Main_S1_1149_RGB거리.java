package BOJ0323;

import java.util.Scanner;

/**
 * 문제
 * RGB 거리에는 집이 N개 있다. 1번 집부터 N번 집이 순서대로 있다.
 * 집을 빨강,초록,파랑 중 하나의 색으로 칠해야 할 때, 각각의 집을 칠하는 비용이 주어진다. 
 * 규칙
 * 1. 1번 집의 색은 2번 집과 다르다.
 * 2. N번 집의 색은 N-1번 집의 색과 다르다.
 * 3. i(2<=i<=N-1)번 집의 색은 i-1, i+1번 집의 색과 다르다.
 * >> 결과적으로 색칠할 집의 색깔은 양 옆의 집 색깔과 달라야 한다.
 * 
 * 입력
 * 첫째 줄에 집의 수 N = 2이상 1000이하
 * 둘째 줄부터 N개의 줄에 각 집을 칠하는 색깔별 비용이 1줄에 세 개씩 주어진다.
 * 비용은 1000 이하의 자연수
 * 
 * 출력
 * 모든 집을 칠하는 비용의 최솟값.
 * 
 * 풀이: 점화식
 * memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0];
 * memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + map[i][1];
 * memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][2];
 */
public class Main_S1_1149_RGB거리 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N+1][3];
		int memo[][] = new int[N+1][3];
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N; i++) {
			map[i][0] = sc.nextInt();
			map[i][1] = sc.nextInt();
			map[i][2] = sc.nextInt();
		}
		memo[0][0] = 0;
		memo[0][1] = 0;
		memo[0][2] = 0;
		map[0][0] = 0;
		map[0][1] = 0;
		map[0][2] = 0;
		
		for(int i=1; i<=N; i++) {
			memo[i][0] = Math.min(memo[i-1][1], memo[i-1][2]) + map[i][0];
			memo[i][1] = Math.min(memo[i-1][0], memo[i-1][2]) + map[i][1];
			memo[i][2] = Math.min(memo[i-1][0], memo[i-1][1]) + map[i][2];
		}
		System.out.println(Math.min(Math.min(memo[N][0], memo[N][1]), memo[N][2]));
	}
}