package BOJ0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 문제
 * 사각형 모양의 판이 있고, 그 위에 얇은 치즈가 놓여 있다. 판의 가장자리에는 치즈가 놓여있지 않으며 치즈에는 하나 이상의 구멍이 있다.
 * 치즈를 공기중에 놓으면 녹는다. 공기와 접촉된 칸은 한 시간 뒤면 녹아 없어진다. 치즈의 구멍 속엔 공기가 없지만,
 * 구멍을 둘러싼 치즈가 녹아 구멍이 열리면 구멍 속으로 공기가 들어가게 된다.
 * 치즈가 모두 녹는데 걸리는 시간과 모두 녹기 한 시간 전에 남아있는 치즈 칸 수를 구하라.
 */
public class Main_G5_2636_박재준bfs_치즈 {

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int map[][];
	static int r,c;
	static boolean[][] visited;
	static int cheese, cnt, hour;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new int[r][c];
		for(int i=0; i<r; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) {
					cheese++;
				}
			}
		}
		while (cheese != 0) {
			hour++;
			cnt = cheese;
			bfs();
		}
		System.out.println(hour);
		System.out.println(cnt);
		
	}
	static void bfs() {
		Queue<Melt> q = new LinkedList<Melt>();
		q.offer(new Melt(0,0));
		visited = new boolean[r][c];
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Melt cur = q.poll();
			for(int i=0; i<4; i++) {
				int nr = cur.r + dr[i];
				int nc = cur.c + dc[i];
				
				if(nr>=0 && nr < r && nc>=0 && nc < c && !visited[nr][nc]) {
					if(map[nr][nc] == 1) {
						cheese--;
						map[nr][nc] = 0;
					}else {
						q.offer(new Melt(nr,nc));
					}
					visited[nr][nc] = true;
				}
				
			}
		}
	}
}
class Melt {
	int r;
	int c;

	Melt(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
