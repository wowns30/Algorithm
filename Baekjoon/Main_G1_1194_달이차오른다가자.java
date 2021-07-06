package BOJ0421;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * 열쇠와 문을 비트로 표현하면 
 * a, A = 000001
 * b, B = 000010
 * c, C = 000100
 * d, D = 001000
 * e, E = 010000
 * f, F = 100000
 * 이때, 문과 열쇠를 AND 연산한 값이 0보다 크면 해당 문을 열 수 있다는 뜻이 된다.
 * 열쇠는 획득할 때 마다 현재 열쇠와 획득한 열쇠의 비트를 OR 연산을 해준다. >> 000000~111111의 총 64개의 경우의 수 존재
 * 하나의 경로를 통해 열쇠를 획득하고, 다시 왔던 길을 통해 탐색을 진행할 수 있어야 하기 때문에
 * 2차원 visited 배열을 모두 false로 초기화하는 것이 아니라 각각의 열쇠를 획득했을 경우에 대한 방문기록을 따로 가져가야 한다.
 * 따라서 visited 배열을 3차원배열 visited[64][N][M]으로 선언한다.
 * ex ) 현재 열쇠 a를 획득했다면 visited배열의 방문 체크 위치는 visited[1][r][c]이다.
 * 		현재 열쇠 a와 b를 획득했다면 비트는 000011(3)이므로 visited배열의 방문 체크 위치는 visited[3][r][c]이다.
 * 따라서 열쇠를 획들할 때마다 현재 열쇠의 정보를 갱신, 그 열쇠의 값을 참조해 visited배열에 방문 기록을 해야한다.
 * 
 * 풀이
 * 1. Queue를 이용한 BFS
 * 2. 해당 칸이 '.' 또는 '0','1' 이라면 해당 위치를 탐색
 * 3. 해당 칸이 열쇠면 현재 가지고 있는 열쇠 정보와 획득한 열쇠의 비트 값을 OR 연산, 열쇠 정보 갱신
 * 4. 해당 칸이 문이면 현재 가지고 있는 열쇠정보와 문의 비트 값을 AND 연산한다. 그 결과가 1 이상이면 문을 열 수 있다는 뜻이므로 해당 칸의 탐색을 계속 진행한다.
 */
public class Main_G1_1194_달이차오른다가자 {

	static int N, M;
	static boolean visited[][][];
	static char[][] map;
	static int dx[] = new int[] {0,0,-1,1};
	static int dy[] = new int[] {1,-1,0,0};
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static Nodes zero;
	
	public static void main(String[] args) throws IOException {

		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[64][N][M];
		for(int i=0; i<N; i++) {
			String s = in.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = s.charAt(j);		//입력 받기 완료
				if(map[i][j] == '0') {			//map 배열의 값이 0이면 시작점이므로
					zero = new Nodes(i,j,0,0);	//시작점 좌표 등록, 이동 횟수는 0부터 시작, key는 아직 획득 못해서 0
				}
			}
		}
		System.out.println(bfs());
	}
	private static int bfs() {
		Queue<Nodes> q = new LinkedList<Nodes>();
		q.offer(new Nodes(zero.row, zero.col, 0, 0));	//시작점 큐에 삽입
		visited[0][zero.row][zero.col] = true;			//시작점
		
		while(!q.isEmpty()) {		//큐가 빌때까지 반복
			Nodes node = q.poll();	//큐에서 뽑아오기
			int row = node.row;		//뽑아온 row값 row에 저장
			int col = node.col;		//뽑아온 col값 col에 저장
			int cnt = node.cnt;		//뽑아온 cnt값 cnt에 저장
			int key = node.key;		//뽑아온 key값 key에 저장
			
			if(map[row][col] == '1') {	//뽑은 위치가 출구라면
				return cnt;				//현재의 이동횟수 return
			}
			for(int i=0; i<4; i++) {	//다음 탐색할 지점 정하기
				int nr = row + dx[i];
				int nc = col + dy[i];
				
				if(check(nr, nc) && map[nr][nc] != '#' && !visited[key][nr][nc]) {
					//만약 다음 위치가 경계를 벗어나지 않고 벽이 아니며 방문하지 않았던 위치일 때
					if(map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
						//다음 위치가 빈 곳이거나, 빈 곳이거나, 출구라면
						visited[key][nr][nc] = true;			//방문 처리해준다.
						q.offer(new Nodes(nr, nc, cnt+1, key));	//다음 위치를 큐에 삽입, 이동 횟수는 +1 됨
					} else if(map[nr][nc] >= 'a' && map[nr][nc] <= 'f') {
						//다음 위치의 값이 a~f의 key값이라면
						int newKey = 1 << (map[nr][nc] - 'a');	//newKey에 방금 획득한 key 값 넣기
						newKey = newKey | key;					//현재 열쇠 정보와 획득한 열쇠의 비트 값 OR 연산, 열쇠 정보 갱신
						if(!visited[newKey][nr][nc]) {			//다음 위치가 새로운 키를 획득하고 방문한 위치가 아니라면
							visited[key][nr][nc] = true;		//키를 획득하지 않았을 때와 획득했을 때 모두 방문 처리
							visited[newKey][nr][nc] = true;
							q.offer(new Nodes(nr, nc, cnt+1, newKey));//다음 위치를 큐에 삽입, 이동횟수+1, 새로운 키 값 newKey
						}
					} else if(map[nr][nc] >= 'A' && map[nr][nc] <= 'F') {
						//다음 위치의 값이 A~F의 문이라면
						int door = 1 << (map[nr][nc] - 'A');		//door에 방금 마주친 문의 값 넣기
						if((key & door) > 0) {			//현재 가지고 있는 열쇠정보와 문의 비트 값을 AND 연산, 결과가 0보다 크다면
							visited[key][nr][nc] = true;//문에 해당하는 다음 위치를 방문 처리
							q.offer(new Nodes(nr, nc, cnt+1, key));	//다음 위치를 큐에 삽입, 이동횟수+1, key값은 그대로
						}
					}
				}
			}
		}
		return -1;		//위의 과정에서 미로를 탈출 할 수 없다면 -1 출력하기 위해 -1을 return
	}
	private static boolean check(int row, int col) {
		return (row >= 0 && row < N) && (col >= 0 && col < M);
	}
}
class Nodes {
	int row;//좌표의 행
	int col;//좌표의 열
	int cnt;//이동 횟수
	int key;//키의 값
	public Nodes(int row, int col, int cnt, int key) {
		this.row = row;
		this.col = col;
		this.cnt = cnt;
		this.key = key;
	}
}