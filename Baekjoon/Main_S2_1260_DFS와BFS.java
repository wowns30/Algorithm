package BOJ0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 문제
 * 그래프를 DFS와 BFS로 각각 탐색하고 그 결과를 출력하는 프로그램 작성.
 * 방문할 수 있는 정점이 여러 개인 경우, 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료.
 * 정점 번호는 1~N까지 이다.
 * 
 * 입력
 * N = 정점의 개수, M = 간선의 개수, V = 탐색 시적 정점 번호
 * M개의 줄에 간선이 연결하는 두 정점의 번호가 주어진다. 주어지는 간선은 양방향
 * 
 * 출력
 * DFS를 수행한 결과
 * BFS를 수행한 결과
 *
 */
public class Main_S2_1260_DFS와BFS {

	static int N,M,V;
	static int[][] map;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s = in.readLine();
		StringTokenizer st = new StringTokenizer(s," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		for(int i=0; i<N+1; i++) {
			Arrays.fill(map[i], 0);
		}
		Arrays.fill(visited, false);
		for(int i=0; i<M; i++){
			String edge = in.readLine();
			StringTokenizer st1 = new StringTokenizer(edge," ");
			int from = Integer.parseInt(st1.nextToken());
			int to = Integer.parseInt(st1.nextToken());
			map[from][to] = 1;
			map[to][from] = 1;
		}
		dfs(V);
		System.out.println();
		Arrays.fill(visited, false);
		bfs(V);
	}
	public static void dfs(int i) {
		visited[i] = true;
		System.out.print(i+" ");
		for(int k=1; k<N+1; k++) {
			if(map[i][k] == 1 && !visited[k]) {
				dfs(k);
			}
		}
	}
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current+" ");
			
			for(int k=1; k<=N; k++) {
				if(map[current][k] == 1 && !visited[k]) {
					queue.offer(k);
					visited[k] = true;
					//들어갈때 방문 처리
					//여기에서 방문한 것을 처리하지 않고 꺼내올때 처리하면 갔던 곳을 또 가게된다.
				}
			}
		}
	}
}
