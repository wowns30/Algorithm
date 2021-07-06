package BOJ0330;

import java.util.Scanner;

public class Main_1890_점프 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		long memo[][] = new long[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		memo[0][0] = 1;//memo배열에는 해당 좌표까지 올 수 있는 경로의 수를 저장해준다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i==N-1 && j==N-1) break; //현재의 좌표가 (N-1,N-1)이면 더이상 이동하지 않는다.
				if(i+map[i][j]<N) {//아래쪽 이동
					memo[i+map[i][j]][j] += memo[i][j];
				}
				if(j+map[i][j]<N) {//오른쪽 이동
					memo[i][j+map[i][j]] += memo[i][j];
				}
			}
		}
		System.out.println(memo[N-1][N-1]);
	}
}
