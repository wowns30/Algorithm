package BOJ0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 치즈엿보기2 {
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static class Pair{
		int x,y;
		public Pair(int x, int y) {
			this.x=x;
			this.y=y;
		}
	}
	static int[][] map;
	static int[][] chk;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
//		map에서 1이 아닌 부분에서 사방검색. C라면 해당좌표 q에 저장해두기.
//		모든 탐색 끝나고 q에 있는 좌표 전부 0으로 바꾸기. / q size 저장해둬야 출력가능
//		q가 비어있다면 종료.
		
//		가운데 구멍 고려 : map에서 1이 아닌부분 탐색 -> bfs로 원점에서 돌기.
		Queue<Pair> q = new LinkedList<>();
		
		int nx, ny, cnt=0,hour=0;
		boolean flag;
		while (true) {
			chk = new int[N][M];
			hour++;
			flag=false;
			q.offer(new Pair(0,0));
			while(!q.isEmpty()) {
				Pair p = q.poll();
				for (int i = 0; i < 4; i++) {
					nx=p.x+dx[i];
					ny=p.y+dy[i];
					if(nx>=0 && nx<N && ny>=0 && ny<M) {
						if(chk[nx][ny]==0) {
							chk[nx][ny]=1;
							if(map[nx][ny]==0) {
								q.offer(new Pair(nx,ny));
							}else {
								flag=true;
								chk[nx][ny]=2;
							}
						}
					}
				}
			}
			if(!flag) {
				System.out.println(hour-1);
				System.out.println(cnt);
				return;
			}
			cnt=0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < M; y++) {
					if (chk[x][y] == 2)	{
						cnt++;
						map[x][y]=0;
					}
				}
			}
		}
	}
}
