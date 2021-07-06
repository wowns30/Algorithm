package BOJ0326;

import java.util.Scanner;

/**
 * 문제
 * 섬으로 이루어진 나라들을 다리로 연결하려 한다. N*M의 크기의 이차원 격자로 나타낼 수 있고
 * 격자의 각 칸은 땅 또는 바다다. 섬은 연결된 땅이 상하좌우로 붙어있는 덩어리를 말한다.
 * 다리는 바다에만 건설하고, 다리의 길이는 다리가 격자에서 차지하는 칸의 수다. 다리를 연결해 모든 섬을 연결하려 할 때,
 * 다리의 양 끝은 섬과 인접한 바다 위에 있고 직선 형태이며 길이는 2 이상이다. 다리가 교차해도 물리적으로는 만나는게 아니며
 * 길이를 계산할 때에도 각각의 다리의 길이에 한 칸을 차지한다.
 * 모든 섬을 연결하는 다리 길이의 최솟값을 구해보자.
 * 
 * 입력
 * N,M
 * N개의 줄에 지도의 정보
 * 각 줄은 M개의 수로 이루어짐. 0은 바다, 1은 땅
 * 
 * 출력
 * 모든 섬을 연결하는 다리 길이의 최솟값 출력, 불가능하면 -1 출력
 */
public class Main_G2_17472_다리만들기2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int map[][] = new int [N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j]==1) {
					
				}
			}
		}
		
	}

}
