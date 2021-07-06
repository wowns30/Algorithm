//package BOJ0322;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.PriorityQueue;
//import java.util.StringTokenizer;
///**
// * 문제
// * 방향그래프가 주어진다. 시작점에서다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하라.
// * 모든 간선의 가중치는 10이하의 자연수. V는 20000만 이하, E는 30만 이하
// * 
// * 입력
// * V(정점 개수), E(간선 개수)
// * K(시작 정점 번호)
// * E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 u,v,w = u에서 v로 가는 가중치 w
// * 서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수 있다.
// * 
// * 출력
// * V개의 줄에 걸쳐 i번째 줄에 i번 정점으로의 최단 경로의 경로 값
// * 시작점 자신은 0, 경로가 없으면 INF
// */
////class Node implements Comparable<Node>{
////	int end, weight;
////	
////	public Node(int end, int weight) {
////		this.end = end;
////		this.weight = weight;
////	}
////	@Override
////	public int compareTo(Node o) {
////		return weight - o.weight;
////	}
////}
//
//public class Main_G5_1753_최단경로 {
//	
//	static int V,E,K;
//	static int distance[];
//	static List<Node>[] list;
//	
//	public static void main(String[] args) throws Exception {
//
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		
//		V = Integer.parseInt(st.nextToken());
//		E = Integer.parseInt(st.nextToken());
//		K = Integer.parseInt(in.readLine());
//		
//		list = new ArrayList[V+1];
//		distance = new int[V+1];
//		int INF = 100000000;
//		
//		Arrays.fill(distance, INF);
//		
//		for(int i=1; i<=V; i++) {
//			list[i] = new ArrayList<>();
//		}
//		//리스트에 그래프 정보를 초기화
//		for(int i=0; i<E; i++) {
//			st = new StringTokenizer(in.readLine());
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			int w = Integer.parseInt(st.nextToken());
//			list[u].add(new Node(v,w));
//		}
//		StringBuilder sb = new StringBuilder();
//		
//		dijkstra(K);
//		
//		for(int i=1; i<=V; i++) {
//			if(distance[i] == INF) sb.append("INF\n");
//			else sb.append(distance[i] + "\n");
//		}
//	}
//	static void dijkstra(int start) {
//		PriorityQueue<Node> queue = new PriorityQueue<>();
//		boolean visited[] = new boolean[V+1];
//		queue.add(new Node(start, 0));
//		distance[start] = 0;
//		
//		while(!queue.isEmpty()) {
//			Node curNode = queue.poll();
//			int cur = curNode.end;
//			
//			if(visited[cur]==true) continue;
//			visited[cur] = true;
//			
//			for(Node node : list[cur]) {
//				if(distance[node.end] > distance[cur] + node.weight) {
//					distance[node.end] = distance[cur] + node.weight;
//					queue.add(new Node(node.end, distance[node.end]));
//				}
//			}
//		}
//	}
//}