package BOJ6_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_1245 {

	static int N;
	static int M;
	static int map[][];
	static boolean visited[][];
	static int answer = 0;
	static int dx[] = {-1,1,0,0,1,1,-1,-1};
	static int dy[] = {0,0,-1,1,1,-1,1,-1};
	static boolean position;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//입력 받기 완료
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!visited[i][j]) {//만약 현재 위치를 방문하지 않았다면, 검사하지 않았다면
					position = true;//position = 현재 위치
					dfs(i,j);		//현재 위치를 dfs로 검사
					if(position) {
						answer++; //현재 위치가 true라면 봉우리라는 뜻으로 답에 +1
					}
				}
			}
		}
		System.out.println(answer);//답을 출력
	}
	//dfs 함수
	private static void dfs(int x, int y) {//좌표를 입력 받음
		visited[x][y] = true; 		//현재 위치를 방문했다고 표시하고 시작 
		for(int k=0; k<8; k++) {	//8방 탐색
			int nx = x + dx[k];		//다음 x좌표
			int ny = y + dy[k];		//다음 y좌표
			if(nx<0 || ny<0 || nx>=N || ny>=M) {//경계 검사
				continue; //다음 검사할 좌표가 경계를 벗어났다면 다음 방향 검사로 넘어감
			}
			if(map[nx][ny] > map[x][y]) {//다음에 검사할 곳이 더 높다면 현재 위치에 대해 false로 만들어 봉우리가 아니라고 표시
				position = false;
			}
			if(!visited[nx][ny] && map[nx][ny] == map[x][y]) {//다음 검사할 곳이 아직 검사하지 않았고, 현재의 위치와 높이가 같다면
				dfs(nx, ny);//다음 검사할 곳 검사 들어감
			}
		}
	}
}
