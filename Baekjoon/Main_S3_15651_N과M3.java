package BOJ0318;

import java.util.Scanner;

/**
 * 문제
 * 자연수 N,M이 주어질 때, 1부터 N까지의 자연수 중 M개를 고른 수열을 출력한다. 이때 같은 수를 여러번 골라도 된다.
 * 
 * 입력
 * N,M
 * 
 * 출력
 * 조건을 만족하는 수열을 한 줄에 하나씩 출력
 * 사전 순으로 증가하는 순서로 출력
 * 
 * 풀이
 *
 */
public class Main_S3_15651_N과M3 {

	static int N,M;
	static int num[];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		num = new int[M+1];
		
		combination(0,1);
	}
	static void combination(int idx, int start) {
		if(idx == M) {
			
		}
		for(int i=start; i<=N; i++) {
			num[idx] = i;
			combination(idx+1, i+1);
		}
	}

}
