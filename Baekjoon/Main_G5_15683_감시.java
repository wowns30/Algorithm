package BOJ0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_15683_감시 {

	static int N, M, map[][], count;
	static int dx[] = {-1,0,1,0};
	static int dy[] = {0,1,0,-1};
	static int state[][] = {
			{1,0,0,0},{0,1,0,0},{0,0,1,0},{0,0,0,1},//cctv1
			{1,0,1,0},{0,1,0,1},{1,1,0,0},{0,1,1,0},//cctv2
			{0,0,1,1},{1,0,0,1},					//cctv3
			{1,1,1,0},{0,1,1,1},{1,0,1,1},{1,1,0,1},//cctv4
			{1,1,1,1}								//cctv5
	};
	static List<int[]> list = new ArrayList<>();//cctv의 좌표를 저장할 list
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		count = 0;
		for(int n=0; n<N; n++) {
			st = new StringTokenizer(in.readLine()," ");
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.nextToken());
				//입력 받기 완료
				if(map[n][m] == 0) {//map배열의 값이 0이라면 count++
					count++;
				}
				if(0 < map[n][m] && map[n][m] < 6) {//map배열의 값이 0과 6사이, 즉 cctv라면
					list.add(new int[]{n,m});		//해당 좌표를 리스트에 넣어줌
				}
			}
		}
		bfs(map, count);//bfs 실행
		System.out.println(count);
		
	}
	private static void bfs(int[][] map, int n) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(n,map));//큐에 
		
		for(int i=0; i<list.size(); i++) {
			int len = q.size();
			
			for(int k=0; k<len; k++) {
				Node m = q.poll();
				int num = m.num;
				int x = list.get(i)[0];
				int y = list.get(i)[1];
				
				if(map[x][y] == 1) {
					q.add(cctv(m.map, x,y,num,state[0]));
					q.add(cctv(m.map, x,y,num,state[1]));
					q.add(cctv(m.map, x,y,num,state[2]));
					q.add(cctv(m.map, x,y,num,state[3]));
				}if(map[x][y] == 2) {
					q.add(cctv(m.map, x,y,num,state[4]));
					q.add(cctv(m.map, x,y,num,state[5]));
				}if(map[x][y] == 3) {
					q.add(cctv(m.map, x,y,num,state[6]));
					q.add(cctv(m.map, x,y,num,state[7]));
					q.add(cctv(m.map, x,y,num,state[8]));
					q.add(cctv(m.map, x,y,num,state[9]));
				}if(map[x][y] == 4) {
					q.add(cctv(m.map, x,y,num,state[10]));
					q.add(cctv(m.map, x,y,num,state[11]));
					q.add(cctv(m.map, x,y,num,state[12]));
					q.add(cctv(m.map, x,y,num,state[13]));
				}if(map[x][y] == 5) {
					q.add(cctv(m.map, x,y,num,state[14]));
				}
			}
		}
	}
	private static Node cctv(int[][] map, int x, int y, int num, int state[]) {
		int result[][] = copy(map);
		for(int i=0; i<4; i++) {
			if(state[i] == 0) continue;
			int nx = x, ny = y;
			while(true) {
				nx += dx[i];
				ny += dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M) {
					break;
				}
				if(result[nx][ny] == 6) break;
				if(result[nx][ny] == 0) {
					result[nx][ny] = 8;
					num--;
				}
			}
		}
		if(count > num) {
			count = num;
		}
		return new Node(num, result);
	}
	private static int[][] copy(int[][] map){
		int[][] result = new int[N][M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				result[i][j] = map[i][j];
			}
		}
		return result;
	}
}
class Node { 
	int num; 
	int[][] map; 
	
	Node(int num, int[][] map) { 
		this.num = num; 
		this.map = map; 
	} 
}
