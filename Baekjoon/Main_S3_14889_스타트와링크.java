package BOJ0317;

import java.util.Scanner;

/**
 * 문제
 * 축구는 평일 오후, 의무참석 아님, 총 N명이 모였고 N은 짝수 N/2로 이루어진 두 팀으로 나눠야 한다.
 * 사람들에게 1~N의 번호를 배정, 능력치를 조사했다. Sij는 i번과 j번이 같은 팀일 경우 팀에 더해지는 능력치.
 * 팀의 능력치는 모든 Sij의 합, Sij와 Sji는 다를 수 있고 i번과 j번이 같은 팀일 경우 Sij와 Sji 둘다 더해줘야한다.
 * 재밌는 경기를 위해 두 팀의 능력치의 차이를 최소로 할 때, 그 최솟값을 구하라.
 * 
 * 입력
 * N
 * N개의 줄에 S, 각 줄은 N개의 수로 이루어지며 i번 줄의 j번째 수는 Sij, Sii는 항상 0이고 다른 S들은 1~100의 정수이다.
 * 
 * 출력
 * 두 팀의 능력치 차이의 최솟값
 * 
 * 풀이
 * 1. 조합을 이용해 팀을 나눈다.
 * 2. 팀을 나눴을 때 두 팀의 능력치를 구해 그 차이를 구한다.
 * 3. 그 차이를 계속해서 비교해 최솟값을 구한다.
 */
public class Main_S3_14889_스타트와링크 {
	
	static int N;
	static int ability[][];
	static boolean visited[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ability = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=1; i<=N;i++) {
			for(int j=1; j<=N; j++) {
				ability[i][j] = sc.nextInt();
			}
		}
		combination(0,1);
		System.out.println(min);
		
	}
	private static void combination(int idx, int start) {
		if(idx == N/2) {
			min = Math.min(min, difference());
			return;
		}
		for(int i=start; i<N; i++) {
			if(visited[i] != true) {
				visited[i] = true;
				combination(idx+1, i+1);
				visited[i] = false;
			}
		}
	}
	private static int difference() {
		int Team1 = 0;
		int Team2 = 0;
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				if(visited[i] && visited[j]) {
					Team1 = Team1 + ability[i][j];
				}
				if(!visited[i] && !visited[j]) {
					Team2 = Team2 + ability[i][j];
				}
			}
		}
		return Math.abs(Team1 - Team2); 
	}
}