package BOJ0326;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 문제
 * 파이프가 (1,1),(1,2)에 걸쳐 가로로 놓여 있을 때, 가로, 세로, 대각선 아래로 연장하여
 * (N,N)까지 연장하는 방법의 개수를 구하라. 이때, 가로로 놓인 경우는 가로와 대각선, 세로로 놓인 경우는 세로와 대각선으로만 연장 가능하다.
 * 
 * 입력
 * N
 * N*N의 집의 상태(0이면 아무것도 없고, 1이면 벽이다.)
 * 
 * 출력
 * 이동시킬 수 없는 경우는 0, 이동시키는 방법의 수 출력
 */
class Move {
    int x;
    int y;
    int dist;

    Move(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main_G5_17070_파이프옮기기1 {

	//				    우,우하,하
//	static int dr[] = {0,1,1};
//	static int dc[] = {1,1,0};
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int home[][] = new int[N][N];//집의 상태 배열
		int cross[][] = new int[N-1][N-1];//i,j 좌표의 대각선 상태배열
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				home[i][j] = sc.nextInt();
			}
		}
		//i,j 좌표의 우측하단 좌표 상태 배열
		for(int i=0; i<N-1; i++) {
			for(int j=0; j<N-1; j++) {
				cross[i][j] = home[i+1][j+1];
			}
		}
		
//		int a = 0;
//		boolean possible = false;
		int a = 0;// a=0 가로방향, 1세로방향, 2대각선방향
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(home[i][j+1]==0 && home[i][j+1]<N) {//우측이 벽이 아니고 경계를 벗어나지 않으면 가로 이동
					
				}
				if(home[i][j+1]==0 && home[i+1][j]<N) {//아래측이 벽이 아니고 경계를 벗어나지 않으면 세로 이동 
					
				}
				if(home[i][j+1]==0 && home[i][j+1]<N && home[i][j+1]==0 && home[i+1][j]<N && home[i+1][j+1]==0) {
					//우,하,우하 방향이 0이고 우측과 아래측 경계를 벗어나지 않으면 대각선 이동
				}
			}
		}
	}
	static void bfs(int r, int c, int d) {
		Queue<Move> q = new LinkedList<>();
		
		int[] dr = {0,1,1};
		int[] dc = {1,1,0};
		
//		int nr = r + dr[];
	}

}
//while() {
//	switch (a) {
//	case 0://파이프가 가로방향일 때
//		
//	case 1://세로
//		
//	case 2://대각선
//	}
//}
