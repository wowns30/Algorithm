package BOJ6_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1939 {

	static int N,M;
	static ArrayList<ArrayList<Island>> list = new ArrayList<>();
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());//섬의 개수
		M = Integer.parseInt(st.nextToken());//다리 개수
		int left = 0;
		int right = 0;
		int max = 0;//중량을 저장할 변수
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<>());
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			list.get(A).add(new Island(B,C));//list의 A번째에는 (B,C) 쌍을 저장 
			list.get(B).add(new Island(A,C));//list의 B번째에는 (A,C) 쌍을 저장
			max = Math.max(max, C); //다리의 중량 중 최대 값이 저장된다.
		}//입력 받기 완료
		
		right = max; //오른쪽에 max값을 저장
		st = new StringTokenizer(in.readLine(), " ");
		int fac1 = Integer.parseInt(st.nextToken());//공장이 있는 섬1
		int fac2 = Integer.parseInt(st.nextToken());//공장이 있는 섬2
		while(left <= right) {//left가 right보다 커지면 반복 멈춤
			int mid = (left+right)/2;//이분 탐색을 위한 mid 값 설정, mid 값을 최대 중량으로 보고 푼다.
			visit = new boolean[N+1];
			if(bfs(fac1, fac2, mid)) {	//탐색 시 공장이 있는 섬에 도착하면
				left = mid+1;			//left를 mid+1로 두고 반복	
			}else {						//공장이 있는 섬이 아니라면
				right = mid-1;			//right를 mid+1로 두고 반복
			}
		}
		System.out.println(right);
	}
	private static boolean bfs(int start, int end, int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);			//출발 섬을 큐에 넣는다.
		visit[start] = true;	//방문 표시 해준다.
		while(!q.isEmpty()) {	//큐가 빌때까지
			int cur = q.poll();	//현재 위치인 섬을 뽑고
			if(cur == end) {	//만약 현재 위치가 도착 섬이면
				return true;	//true 반환
			}
			for(Island i : list.get(cur)) {				//현재 위치가 도착섬이 아닐 경우
				if(!visit[i.dest] && mid <= i.weight) { 
					//만약 현재 위치와 연결된 섬을 아직 방문하지 않았고 mid가 섬과 연결된 다리의 중량보다 작거나 같다면
					visit[i.dest] = true;	//현재 위치와 연결된 섬을 방문 표시하고
					q.add(i.dest);			//큐에 출발 섬으로 현재 위치와 연결된 섬을 넣는다.
				}//만약 mid보다 i.weight가 작으면 갈 필요가 없다.최대 중량 만족 못함
			}
		}
		return false;
	}
	static class Island{//섬의 쌍을 갖는 클래스 (연결된 섬, 다리의 중량)
		int dest, weight;
		Island (int dest, int weight){
			this.dest = dest;
			this.weight = weight;
		}
	}
}
