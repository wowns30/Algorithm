package BOJ0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 문제
 * Si에서 시작해 Ti에 끝나는 N개의 수업이 주어지는데, 최소의 강의실을 사용해서 모든 수업을 가능하게 해야 한다.
 * 수업이 끝난 직후에 다음 수업을 시작할 수 있을 때, Ti <= Si 일 경우 i수업과 j수업은 같이 들을 수 있다는 뜻.
 * 수강신청을 대충한 것이 찔린다면 선생님을 도와드리자.
 * 입력
 * N
 * N개의 줄에 Si, Ti
 * 출력
 * 강의실의 개수
 */
public class Main_G5_강의실배정 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int start[][] = new int[N][2];
		int end[][] = new int[N][2];
		boolean visited[] = new boolean [N+1];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			start[n][0] = end[n][0] = n+1;
			start[n][1] = Integer.parseInt(st.nextToken());
			end[n][1] = Integer.parseInt(st.nextToken());
			visited[n+1] = false;
			
		}//입력받기 완료
		for(int n=0; n<N; n++) {
			if(!visited[n+1]) {
				
			}
		}
	}
}
