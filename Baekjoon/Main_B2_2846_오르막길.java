package BOJ_오르막길;

import java.util.Scanner;

public class Main_B2_2846_오르막길 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int step[] = new int[N];
		for(int i=0; i<N; i++) {
			step[i] = sc.nextInt();
		}//입력 완료
		
		int sum = 0;	//오르막길 크기를 더할 변수
		int upup = 0;	//현재와 다음 층의 차이를 저장할 변수
		int ans = 0;	//최종으로 출력할 최댓값 비교 변수
		for(int i=0; i<N-1; i++) {
			if(step[i] < step[i+1]) {
				sum += step[i+1] - step[i];
			}else {
				sum = 0;
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);

	}

}
