package BOJ0322;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_G5_1753_최단경로2 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INF = 100000000;
    static int V,E,K;
    static List<Node>[] list;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        list = new ArrayList[V + 1];
        distance = new int[V + 1];

        Arrays.fill(distance, INF);

        for(int i = 1; i <= V; i++){
            list[i] = new ArrayList<>();
        }
        // 리스트에 그래프 정보를 초기화
        for(int i = 0 ; i < E; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            // start에서 end로 가는 weight 가중치
            list[u].add(new Node(v, w));
        }

        StringBuilder sb = new StringBuilder();
        // 다익스트라 알고리즘
        dijkstra(K);
        // 출력 부분
        for(int i = 1; i <= V; i++){
            if(distance[i] == INF) sb.append("INF\n");
            else sb.append(distance[i] + "\n");
        }

        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    private static void dijkstra(int start){
       PriorityQueue<Node> queue = new PriorityQueue<>();
       boolean[] check = new boolean[V + 1];
       queue.add(new Node(start, 0));
       distance[start] = 0;

       while(!queue.isEmpty()){
           Node curNode = queue.poll();
           int cur = curNode.end;

           if(check[cur] == true) continue;
           check[cur] = true;

           for(Node node : list[cur]){
               if(distance[node.end] > distance[cur] + node.weight){
                   distance[node.end] = distance[cur] + node.weight;
                   queue.add(new Node(node.end, distance[node.end]));
               }
           }
       }
    }
    static class Node implements Comparable<Node>{
        int end, weight;

        public Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return weight - o.weight;
        }
    }
}