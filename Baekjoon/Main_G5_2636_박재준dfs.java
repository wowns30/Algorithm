package BOJ0326;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G5_2636_박재준dfs {
	static int R,C;
	static int[][] map;
	static boolean[][] visit;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static int total;
	static int remainCheese=0;
	static int time=0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		total=R*C;
		for (int i = 0; i < R; i++) {
			st=new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < C; j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		while(true) {
			airCheck();
			if(checkTime())
				time++;
			else
				break;
			removeCheese();
		}
		System.out.println(time);
		System.out.println(remainCheese);
	}
	private static boolean checkTime() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==2) {
					return true;
				}
			}
		}
		return false;
	}
	private static void removeCheese() {
		remainCheese=0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j]==2) {
					remainCheese++;
					map[i][j]=0;
				}
			}
		}
	}
	private static void airCheck() {
		visit=new boolean[R][C];
		dfs(0,0);
	}
	private static void dfs(int r, int c) {
		for (int i = 0; i < 4; i++) {
			int nr= dr[i]+r;
			int nc= dc[i]+c;
			
			if(nr >=0 && nr<R && nc>=0 && nc<C && !visit[nr][nc]) {
				if(map[nr][nc]==1) {
					map[nr][nc]=2;
				}
				if(map[nr][nc]==0) {
					visit[nr][nc]=true;
					dfs(nr,nc);
				}
			}
		}
	}
}
