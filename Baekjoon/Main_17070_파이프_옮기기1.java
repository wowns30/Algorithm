package BOJ0317;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_17070_파이프_옮기기1 {
	static class Pos{
		int r;
		int c;
		int dir;
		public Pos(int r, int c, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.dir = dir;
		}
		public String toString() {
			return "Pos [r=" + r + ", c=" + c + ", dir=" + dir + "]";
		}
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/baekjun17070.txt"));
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int[][] direction = {{0, 1}, {1,0}, {1,1}};
		LinkedList<Pos> queue  = new LinkedList<>();
		queue.add(new Pos(0, 1, 0));
		while(!queue.isEmpty()) {
				Pos cur = queue.poll();
				int r = cur.r;
				int c = cur.c;
				int dir = cur.dir;
				if(r== N-1 && c == N-1 ) {
					cnt++;
				}else {
					int nr=0;
					int nc=0;
					switch (dir) {
					case 0:					//오른쪽 
						nr= r;				//오른쪽 
						nc= c+1;
						if(nr <N && nc<N && map[nr][nc] != 1) {
							queue.offer(new Pos(nr, nc, 0));
						}
						break;
					case 1:					//아래 
						nr= r+1;			//아래 
						nc= c;
						if(nr <N && nc<N && map[nr][nc] != 1) {
							queue.offer(new Pos(nr, nc, 1));
						}
						break;
					case 2:								//대각선
						nr= r;							//오른쪽
						nc= c+1;
						if(nr <N && nc<N && map[nr][nc] != 1) {
							queue.offer(new Pos(nr, nc, 0));
						}
						nr= r+1;						//아래
						nc= c;
						if(nr <N && nc<N && map[nr][nc] != 1) {
							queue.offer(new Pos(nr, nc, 1));
						}
						break;
					}
					nr= r+1;							//대각선
					nc= c+1;
					if(nr <N && nc<N && map[r][nc] != 1 && map[nr][c] != 1 && map[nr][nc] !=1) {
						queue.offer(new Pos(nr, nc, 2));
					}
				}
		}
		System.out.println(cnt);
	}
}
