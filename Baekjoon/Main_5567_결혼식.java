package BOJ0415;

import java.util.Scanner;

/**
 * 동기는 모두 N명, 학번은 1~N까지, 상근이가 1번
 * 
 * 풀이
 * 상근이의 친구의 수와 상근이 친구의 친구의 수를 세어 출력하라
 */
public class Main_5567_결혼식 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n+1][n+1];
		boolean[] visit = new boolean[n+1];
		
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = arr[b][a] = 1;//친구관계를 표시한 배열
		}
		int count = 0;
		for(int i=2; i<=n; i++) {
			if(arr[1][i] == 1) {//상근이와 친구라면
				if(!visit[i]) {//방문하지 않았다면
					count++;//count+1
					visit[i] = true;//방문처리
				}
				for(int j=2; j<=n; j++) {
					if(arr[i][j] == 1 && !visit[j]) {//상근이와 친구인 사람의 친구 찾기, 방문하지 않았다면
						count++;//count+1
						visit[j] = true;//방문처리
					}
				}
			}
		}
		System.out.println(count);
		sc.close();
	}	
}
