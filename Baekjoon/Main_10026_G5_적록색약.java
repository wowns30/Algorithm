package BOJ0422;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_10026_G5_적록색약 {

	static int N; 
	static char arr1[][], arr2[][];//색약이 아닌 사람과 색약인 사람의 그림은 다르게 보이므로 보이는 그림에 따라 다른 배열에 그림을 저장
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	static boolean visited1[][];
	static boolean visited2[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		arr1 = new char[N][N];
		arr2 = new char[N][N];
		visited1 = new boolean[N][N];
		visited2 = new boolean[N][N];
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			for(int j=0; j<N; j++) {
				arr1[i][j] = s.charAt(j);
				arr2[i][j] = arr1[i][j];
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(arr2[i][j] == 'R') {
					arr2[i][j] = 'G';//적색과 녹색의 차이가 없으므로 둘 중 한 가지 색으로 맞춰줌
				}
			}
		}
		int ans1 = 0;
		int ans2 = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited1[i][j]) {
					bfs1(new Node(i,j));
					ans1++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visited2[i][j]) {
					bfs2(new Node(i,j));
					ans2++;
				}
			}
		}
		System.out.println(ans1 +" "+ans2);
	}
	private static void bfs1(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		visited1[node.x][node.y] = true;
		while(!q.isEmpty()) {
			Node nodes = q.poll();
			for(int d=0; d<4; d++) {
				int nx = nodes.x + dx[d];
				int ny = nodes.y + dy[d];
				if(nx>=0 && ny>=0 && nx < N && ny < N && arr1[nodes.x][nodes.y] == arr1[nx][ny] && !visited1[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited1[nx][ny] = true;
				}
			}
		}
	}
	private static void bfs2(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.offer(node);
		visited2[node.x][node.y] = true;
		while(!q.isEmpty()) {
			Node nodes = q.poll();
			for(int d=0; d<4; d++) {
				int nx = nodes.x + dx[d];
				int ny = nodes.y + dy[d];
				if(nx>=0 && ny>=0 && nx < N && ny < N && arr2[nodes.x][nodes.y] == arr2[nx][ny] && !visited2[nx][ny]) {
					q.offer(new Node(nx, ny));
					visited2[nx][ny] = true;
				}
			}
		}
	}
	static class Node{
		int x;
		int y;
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
