package BOJ0317;

import java.util.Scanner;

/**
 * 문제
 * N*N 크기의 공간에 물고기 M마리와 아기상어 1마리가 있을 때, 물고기는 모두 크기를 가지며, 자연수이다.
 * 아기상어는 크기가 2, 1초에 상하좌우로 한 칸씩 이동한다. 자신보다 큰 물고기가 있는 칸은 지날 수 없고, 나머지는 모두 지난다.
 * 자기보다 작은 물고기만 먹을 수 있으며 크기가 같은 물고기의 칸은 지날수만 있다.
 * 1. 더 이상 먹을 수 있는 물고기가 공간에 없다면 아기상어는 엄마상어에게 도움을 요청한다.
 * 2. 먹을 수 있는 물고기가 1마리면, 그 물고기를 먹으러 간다.
 * 3. 먹을 수 있는 물고기가 1마리보다 많으면, 거리가 가장 가까운 물고기를 먹으러 간다.
 * 	- 가장 가까운 거리의 물고기가 여러마리라면 가장 위, 가장 왼쪽의 물고기를 먼저 먹는다.
 * 
 * 입력
 * 공간의 크기 N
 * N개의 줄에 공간의 상태
 * 
 * 출력
 * 엄마상어의 도움 없이 물고기를 먹을 수 있는 시간
 */
public class Main_G4_16236_아기상어 {

	static int[][] sea;
	static boolean visited[][];
	static int moveCnt;
	static int N;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sea= new int[N][N];
		for(int n=0; n<N; n++) {
			for(int i=0; i<N; i++) {
				sea[n][i] = sc.nextInt();
			}
		}
		
	}

}
