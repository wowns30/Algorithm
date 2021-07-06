package BOJ0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕 {

	static int R,C,M;//격자판 크기 R*C, 상어의 수 M
	static int map[][], shark[][];//상어의 위치(r,c), 속력 s, 이동방향 d, 크기 z
	static boolean visited[];
	static int dx[] = {0,-1,1,0,0};
	static int dy[] = {0,0,0,1,-1};
	//					상,하,우,좌
	static int ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[M+1];
		map = new int[R+1][C+1];
		shark = new int[M+1][5];
		for(int i=1; i<=M; i++) {
			st = new StringTokenizer(in.readLine()," ");
			shark[i][0] = Integer.parseInt(st.nextToken());//행
			shark[i][1] = Integer.parseInt(st.nextToken());//열
			shark[i][2] = Integer.parseInt(st.nextToken());//속력
			shark[i][3] = Integer.parseInt(st.nextToken());//방향
			shark[i][4] = Integer.parseInt(st.nextToken());//크기
			//순서대로 상어의 위치(r,c), 속력 s, 이동방향 d, 크기 z를 상어 배열에 저장
		}
		//map 배열에 초기 상어의 위치 표시
		for(int i=1; i<=R+1; i++) {
			for(int j=1; j<=C+1; j++) {
				for(int s=1; s<=M; s++) {
					if(i == shark[s][0] && j == shark[s][1]) {
						map[i][j] = s;
					}
				}
			}
		}//입력 받기 완료
		
		ans = 0;
		for(int i=1; i<C+1; i++) {
			catchShark(i);
			for(int k=1; k<R+1; k++) {
				for(int j=1; j<C+1; j++) {
					if(map[k][j] != 0) {//상어라면
						for(int s=1; s<=M; s++) {//상어들이 이동한다.
							if(shark[s][3] != 0) {
//								move1sec(s,shark[s][0], shark[s][1], shark[s][2], shark[s][3], shark[s][4]);
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
		
	}
	//상어 잡는 함수(한 열에서 한 마리의 상어만 잡아야 한다.)
	private static int catchShark(int c) {	//상어를 잡을 열을 입력 받는다
		for(int r=1; r<R+1; r++) {			//각 행을 탐색 했을 때
			if(map[r][c] != 0) {			//탐색 칸이 상어라면
				ans += shark[map[r][c]][4];	//해당 상어의 크기를 ans에 추가
				for(int s=1; s<=M; s++) {	//잡은 상어의 정보를 없애주기 위해
					if(map[r][c] == s) {	//만약 현재 칸의 상어가 s번 상어라면 
						shark[s][3] = 0;	//해당 상어의 방향을 0으로 만들어주고
					}
					break;					
				}
				map[r][c] = 0;				//현재 칸의 상어를 잡았으므로 상어는 사라진다.
				break;						//한 마리만 잡아야 하므로 for문 탈출.
			}
			else {
				break;
			}
		}
		return ans;							//ans를 리턴해준다.
	}
//	private static void move1sec(int num, int r, int c, int s, int d, int z) {
////		int nx,ny
//		
//		
//		
//		map[r][c] = 0;
//		if(nx>0 && ny>0 && nx<C+1 && ny<R+1 && map[nx][ny] != 0) {//다음 위치가 상어라면
//			if(z > shark[map[nx][ny]][4]) {	//상어의 크기를 비교, 이동한 상어의 크기가 더 크면
//				map[nx][ny] = num;			//이동한 상어로 갱신
//			}
//		}else if(nx>0 && ny>0 && nx<C+1 && ny<R+1 && map[nx][ny] == 0) {					//상어가 아니면
//			map[nx][ny] = num;	//이동 완료
//		}
//	}
}
//nx>0 && ny>0 && nx<C+1 && ny<R+1 &&
