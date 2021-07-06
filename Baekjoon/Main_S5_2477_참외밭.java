package BOJ0223;

import java.util.Scanner;

/**
 * BOJ 참외밭 Silver5
 * 밭에서 자라는 참외가 몇 개나 되는지 궁금하다.
 * 1m^2에서 자라는 참외의 개수는 K개 일때, 참외밭이 ㄱ자이거나 ㄱ자를 90,180,270도 회전한 모양이다.
 * 참외밭의 왼쪽위 꼭짓점에서 출발해 반시계방향으로 돌아 출발점으로 돌아오자.
 * 입력
 * 1m^2에서 자라는 참외의 개수 K
 * 둘째줄부터 일곱번째줄까지 반시계방향으로 돌면서 지나는 변의 방향과 길이가 주어진다.
 * 동=1, 서=2, 남=3, 북=4
 * 출력
 * 첫째 줄에 입력으로 주어진 밭에서 자라는 참외의 수 출력
 */
public class Main_S5_2477_참외밭 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int arr[][] = new int [6][2];
		int W = 0, H = 0;
		for(int i=0; i<6; i++) {
			arr[i][0] = sc.nextInt(); //방향
			arr[i][1] = sc.nextInt(); //밭의 길이
			if(arr[i][0]<3) {
				W = Math.max(arr[i][1], W);
			}else {
				H = Math.max(arr[i][1], H);
			}
		}
		int min = 1;
		for(int i=0; i<6; i++) {
			if(arr[(i+5)%6][0]==arr[(i+1)%6][0]) {
				min *= arr[i][1];
			}
		}
		System.out.println((W*H-min)*K);
	}
}