package BOJ0406;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main_G4_2234_성곽 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		bfs(N, M, map);
		System.out.println(count);
		System.out.println(ans);
		System.out.println(summary);
	}

	static void bfs(int N, int M, int[][] map2) {
		Queue<Node> q = new LinkedList<>();
		List<Integer> list = new ArrayList<Integer>();
		boolean visit[][] = new boolean[N][M];

		int map3[][] = new int[N][M];
		for (int idx = 0; idx < N; idx++) {
			for (int jdx = 0; jdx < M; jdx++) {
				map3[idx][jdx] = map2[idx][jdx];
			}
		}
		int map4[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {

					visit[i][j] = true;
					q.add(new Node(i, j, 1));
					int max = 1;
					boolean visited[][] = new boolean[N][M];
					visited[i][j] = true;
					while (!q.isEmpty()) {
						Node n = q.poll();
						int arr[] = new int[4];
						String s = Integer.toBinaryString(map2[n.y][n.x]);
						int len = 0;
						for (int ii = s.length() - 1; ii >= 0; ii--) {
							arr[len] = s.charAt(ii) - '0';
							len++;
							if (len == 0)
								break;
						}
						for (int k = 0; k < arr.length; k++) {
							if (arr[k] == 0) {
								int ny = Y[k] + n.y;
								int nx = X[k] + n.x;

								if (ny < 0 || nx < 0 || ny >= N || nx >= M)
									continue;
								if (visit[ny][nx])
									continue;
								q.add(new Node(ny, nx, n.cnt + 1));
								visit[ny][nx] = true;
								visited[ny][nx] = true;
								max++;
							}
						}
					}
					count++;
					list.add(max);
					if (ans < max) {
						ans = max;
					}
					for (int idx = 0; idx < N; idx++) {
						for (int jdx = 0; jdx < M; jdx++) {
							if (visited[idx][jdx]) {
								map2[idx][jdx] = max;
								map4[idx][jdx] = count;
							}
						}
					}
				}
			}
		}
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				int arr[] = new int[4];
				String s = Integer.toBinaryString(map3[i][j]);
				int len = 0;
				for (int ii = s.length() - 1; ii >= 0; ii--) {
					arr[len] = s.charAt(ii) - '0';
					len++;
					if (len == 0)
						break;
				}
				for (int k = 0; k < arr.length; k++) {
					if (arr[k] == 1) {
						int ny = Y[k] + i;
						int nx = X[k] + j;

						if (ny < 0 || nx < 0 || ny >= N || nx >= M)
							continue;
						if(map4[ny][nx]!=map4[i][j])
							sum = map2[ny][nx] + map2[i][j];
					}
				}
				if (sum > summary)
					summary = sum;
			}
		}
	}
	static int summary;
	static int count;
	static int ans;
	static int Y[] = { 0, -1, 0, 1 };
	static int X[] = { -1, 0, 1, 0 };

	static class Node {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
		@Override
		public String toString() {
			return "Node [y=" + y + ", x=" + x + ", cnt=" + cnt + "]";
		}
	}
}
