package BOJ0326;

import java.io.*;
import java.util.*;

public class 파이프옮기기 {
	private static class Node {
		int x, y, type;

		Node(int x, int y, int type) {
			this.x = x;
			this.y = y;
			this.type = type; // 0 = 가로, 1 = 세로, 2 = 대각선
		}
	}

	static int size, result = 0;
	static int[] dx = { 0, 1, 1 }; // 가로, 세로, 대각선
	static int[] dy = { 1, 0, 1 };

	static int[][] map;
	static Queue<Node> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		size = stoi(st.nextToken());

		map = new int[size][size];

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				map[i][j] = stoi(st.nextToken());
			}
		} // 인풋 종료

		q.add(new Node(0, 1, 0));
		bfs();
		System.out.println(result);

	}

	private static void bfs() {
		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.x == size - 1 && n.y == size - 1) {
				result++;
				continue;
			}

			for (int i = 0; i < 3; i++) {
				if (n.type == 0 && i == 1) {
					continue;
				} else if (n.type == 1 && i == 0) {
					continue;
				}

				if (isPossible(n.x, n.y, i)) {
					q.add(new Node(n.x + dx[i], n.y + dy[i], i));
				}
			}
		}
	}

	private static boolean isPossible(int x, int y, int type) {
		int nx = x + dx[type];
		int ny = y + dy[type];

		if (nx >= size || ny >= size)
			return false;

		if (type != 2) {
			if (map[nx][ny] == 0) {
				return true;
			}
		} else {
			if (map[nx][ny] == 0 && map[nx - 1][ny] == 0 && map[nx][ny - 1] == 0) {
				return true;
			}
		}
		return false;
	}

	private static int stoi(String input) {
		return Integer.parseInt(input);
	}
}