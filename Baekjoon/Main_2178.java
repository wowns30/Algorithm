package BOJ6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2178 {

	static int N, M;
	static int arr[][];
	static boolean check[][];
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			String s = st.nextToken();
			for(int j=0; j<M; j++) {
				arr[i][j] = s.charAt(j)-'0';
			}
		}//입력 완료
		bfs(0,0);
		System.out.println(arr[N-1][M-1]);
	}
	private static void bfs(int i, int j) {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {i, j});
		while(!q.isEmpty()) {
			int location[] = q.poll();
			check[i][j] = true;
			
			for(int d=0; d<4; d++) {
				int nx = location[0] + dx[d];
				int ny = location[1] + dy[d];
				if(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(arr[nx][ny] != 0 && !check[nx][ny]) {
						q.offer(new int[] {nx, ny});
						check[nx][ny] = true;
						arr[nx][ny] = arr[location[0]][location[1]] + 1;
					}
				}
			}
		}
	}
}
