package BOJ0420;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
public class Main_G5_강의실배정2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int time[][] = new int[N][2];
		
		for(int n=0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			time[n][0] = Integer.parseInt(st.nextToken());
			time[n][1] = Integer.parseInt(st.nextToken());
			
		}//입력받기 완료
		//강의 시간을 오름차순 정렬, 시작 시간이 같은 강의는 끝나는 시간을 기준으로 정렬
		Arrays.sort(time, new Comparator<int []>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] == o2[0]) {
					return o1[1] - o2[1];
				}
				return o1[0] - o2[0];
			}
		});
		int count = 1;
		int temp = 0;
		for(int n=1; n<N; n++) {
			if(time[temp][1] <= time[n][0]) {
				temp = n;
			}else {
				count++;
			}
		}
		System.out.println(count);
	}
}
