package BOJ0326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Cheese {
	int r;
	int c;

	Cheese(int r, int c) {
		this.r = r;
		this.c = c;
	}
}

public class 치즈엿보기1 {

	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };
	public static int[][] map;
	public static boolean[][] isVisited;
	public static int N, M, curCheese, cnt, hour;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					curCheese++;
				}
			}
		}
		while (curCheese != 0) {
			hour++;
			cnt = curCheese;
			bfs();
		}
		System.out.println(hour);
		System.out.println(cnt);
	}

	public static void bfs() {
		Queue<Cheese> q = new LinkedList<Cheese>();

		q.offer(new Cheese(0, 0));

		isVisited = new boolean[N][M];
		isVisited[0][0] = true;

		while (!q.isEmpty()) {
			Cheese now = q.poll();
			for (int i = 0; i < 4; i++) {
				int nr = now.r + dr[i];
				int nc = now.c + dc[i];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !isVisited[nr][nc]) {
					if (map[nr][nc] == 1) {
						curCheese--;
						map[nr][nc] = 0;
					} else {
						q.offer(new Cheese(nr, nc));
					}
					isVisited[nr][nc] = true;
				}
			}
		}
	}
}
