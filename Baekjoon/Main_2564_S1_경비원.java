package BOJ0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * 직사각형 모양의 블록으로, 블록 중간을 가로질러 차가 통과할만한 길이 없다. 이 블록의 경계에 무인 경비를 의뢰한 상점들이 있다.
 * 경계란 직사각형의 각 변을 의미한다.
 * 동근이의 위치와 각 상점 사이의 최단 거리의 합을 구하는 프로그램을 작성하라.
 * 
 * 입력
 * 블록의 가로의 길이 X, 세로의 길이 Y 
 * 상점의 개수 N
 * (모두 100이하의 자연수)
 * 한 줄에 하나씩 상점의 위치
 * 첫번째 수는 상점 위치의 방향
 * (1=북, 2=남, 3=서, 4=동)
 * 두번째 수는 왼쪽 경계 또는 위쪽 경계로부터의 거리
 * 마지막 줄에는 동근이의 위치 
 * 모든 상점과 동근이는 꼭짓점에 위치할 수 없다.
 * 
 * 출력
 * 동근이의 위치와 각 상점 사이의 최단거리의 합
 */

public class Main_2564_S1_경비원 {

	static int X, Y, N;
	static int map[][];
	static int store[][];
	static int dg[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(in.readLine());
		store = new int[N][2];
		dg = new int[2];
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(in.readLine(), " ");
			store[n][0] = Integer.parseInt(st.nextToken());
			store[n][1] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(in.readLine(), " ");
		dg[0] = Integer.parseInt(st.nextToken());
		dg[1] = Integer.parseInt(st.nextToken());
		//입력 완료
		//(1=북, 2=남, 3=서, 4=동)
		int ans = 0;
		if(dg[0] == 1 || dg[0] == 2) {//dg가 남쪽 또는 북쪽에 있을 때
			for(int n=0; n<N; n++) {
				if(store[n][0] == dg[0]) {//dg가 남쪽 또는 북쪽에 있을 때 dg와 store가 같은 방향에 있다면
					ans += Math.abs(store[n][1] - dg[1]); 
				} else if(store[n][0] == 3 || store[n][0] == 4) {//dg가 남쪽 또는 북쪽에 있고, 상점이 서쪽 또는 동쪽이라면
					if(store[n][0] == 3 && dg[0] == 2) {//dg는 남, 상점은 서쪽일 때
						ans += dg[1] + (Y - store[n][1]);
					}else if(store[n][0] == 4 && dg[0] == 2) {//dg는 남, 상점은 동쪽일 때
						ans += (X - dg[1]) + (Y - store[n][1]);
					}else if(store[n][0] == 3 && dg[0] == 1) {//dg는 북, 상점은 서쪽일 때
						ans += dg[1] + store[n][1];
					}else if(store[n][0] == 4 && dg[0] == 1){//dg는 북, 상점은 동쪽일 때
						ans += (X - dg[1]) + store[n][1];
					}
				} else {//dg가 남쪽 또는 북쪽에 있고 상점은 dg와는 반대 방향에 있다면
					ans += Y + Math.min(((X-dg[1])+(X-store[n][1])), (store[n][1]+dg[1]));
				}
			}
		} else if(dg[0] == 3 || dg[0] == 4){//dg가 동쪽 또는 서쪽에 있을 때
			for(int n=0; n<N; n++) {
				if(store[n][0] == dg[0]) {//dg가 동쪽 또는 서쪽에 있을 때 상점이 같은 방향에 있다면
					ans += Math.abs(store[n][1] - dg[1]);
				}else if(store[n][0] == 1 || store[n][0] == 2) {//dg가 동쪽 또는 서쪽에 있고, 상점은 남쪽 또는 북쪽이라면
					if(dg[0] == 3 && store[n][0] == 2) {//dg는 서, 상점은 남쪽
						ans += (Y - dg[1]) + store[n][1];
					}else if(dg[0] == 3 && store[n][0] == 1) {//dg는 서, 상점은 북쪽
						ans += dg[1] + store[n][1];
					}else if(dg[0] == 4 && store[n][0] == 2) {//dg는 동, 상점은 남쪽
						ans += (Y - dg[1]) + (X - store[n][1]);
					}else if(dg[0] == 4 && store[n][0] == 1) {//dg는 동, 상점은 북쪽
						ans += dg[1] + (X - store[n][1]);
					}
				}else {//dg가 동쪽 또는 서쪽에 있고 상점은 dg와 반대 방향에 있다면
					ans += X + Math.min((dg[1]+store[n][1]), ((Y-dg[1])+(Y-store[n][1])));
				}
			}
		}
		System.out.println(ans);
	}
}
