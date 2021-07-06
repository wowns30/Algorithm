package BOJ0413;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 문제
 * 방향성이 없는 그래프가 주어진다 . 1번 정점에서 N번 정점으로 최단 거리로 이동, 임의로 주어진 두 정점은 반드시 통과해야 한다.
 * 한번 이동했던 정점은 물론, 한번 이동했던 간선도 다시 이동할 수 있다. 하지만 반드시 최단 경로로 이동해야 한다.
 * 주어진 두 정점을 반드시 거치면서 최단 경로로 이동하는 프로그램을 작성.
 * 
 * 입력
 * 정점의 수 N, 간선의 수 E
 * E개의 줄에 걸쳐 세개의 정수 a,b,c
 * a번 정점에서 b번 정점까지 양방향 길 존재, 거리는 c이다.
 * 반드시 거쳐야 하는 두 개의 서로 다른 정점 번호 v1, v2 (v1 != v2, v1 != N, v2 != 1)
 * 
 * 출력
 * 두 개의 정점을 지나는 최단 경로의 길이, 경로가 존재하지 않을 땐 -1 출력
 */
public class Main_1504_G4_특정한최단경로 {

	static int N, E, a, b, c, v1, v2, result, start, end;
	static int[][] map;
	static int INF = Integer.MAX_VALUE;
	static int distance[];
	static boolean visited[];
	
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());//정점의 개수
		E = Integer.parseInt(st.nextToken());//간선의 개수
		map = new int[N+1][N+1];//인접 행렬
		
		visited = new boolean[N+1];// 정점에 대한 방문 처리 배열
		distance = new int[N+1];// 정점에 대한 최소 비용 처리를 위한 배열
		
		start = 1;
		end = N;
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = c;
		}
		st = new StringTokenizer(in.readLine(), " ");
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		
		int road1 = 0;
		road1 += dijkstra(1, v1);
		road1 += dijkstra(v1, v2);
		road1 += dijkstra(v2, N);
		
		int road2 = 0;
		road2 += dijkstra(1, v2);
		road2 += dijkstra(v2, v1);
		road2 += dijkstra(v1, N);
		
		if(road1 >= INF && road2 >= INF) {
			result = -1;
		}else {
			result = Math.min(road1, road2);
		}
		
		System.out.println(result);
	}
	private static int dijkstra(int start, int end) {
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		int min = 0, cur = 0;
		for (int i = 1; i < N+1; i++) {
			min = Integer.MAX_VALUE;
			for(int j=1; j<N+1; j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					cur = j;
				}
			}
			visited[cur] = true;
			for(int j=1; j<N+1; j++) {
				if(!visited[j] && map[cur][j] != 0 // 인접 되지 않은 정보
					&& distance[j] > min + map[cur][j]) {
					// 기존의 최소 비용  >	경유 비용
					distance[j] = min + map[cur][j];// 경유 비용이 더 최소이면 업데이트
				}
			}
		}
		return distance[end];
	}
	
}
