package IMPrepare;

import java.util.Scanner;

/**
 * 0부터 9까지의 숫자로 이루어진 N개의 숫자가 나열된 수욜이 있다. 그 수열 안에서 연속해서 커지거나 혹은 연속해서 작아지는(두 경우 모두 같은 수 포함) 수열 중
 * 가장 길이가 긴 것을 찾아 그 길이를 출력하는 프로그램을 작성하라.
 * ex) 1 2 2 4 4 5 7 7 2 의 경우  12244577의 길이 8이 출력된다.4 1 3 3 2 2 9 2 3의 경우 3322의 길이 4가 출력된다.
 * 또 1 5 3 6 4 7 1 3 2 9 5 의 경우 길이가 3이상인 경우가 없으므로 2를 출력한다.
 * 입력
 * 수열의 길이 N (1~10만)
 * N개의 숫자가 주어진다.
 * 출력
 * 가장 긴 길이
 * 풀이
 * 1. 수열을 배열에 입력 받는다.
 * 2. 수열을 탐색하는데, count=1 부터 시작,
 * 	2-1. 현재 위치인 curr 보다 다음 수인 next가 크거나 같으면 count를 1 증가시킨다.
 * 		그렇지 않으면 count를 max와 비교해 더 큰 값을 max에 저장한다.
 * 		그 후, 다음 위치부터 반복 탐색
 * 	2-2. 현재 위치인 curr 보다 다음 수 next가 작거나 같으면 count를 1 증가시킨다.
 * 		그렇지 않으면 count를 max와 비교해 더 큰 값을 max에 저장한다.
 */
public class Main_S2_2491_수열 {

	static int N;
	static int ans = 0;
	static int[] arr;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//수열의 길이
		arr = new int[N];
		for(int n=0; n<N; n++) {
			arr[n] = sc.nextInt();
		}
		int count1 = 1;
		for(int i=0; i<N-1; i++) {
			if(arr[i+1] >= arr[i]) { //증가하는 수열 검사
				count1++;
			}else { //초기화를 해버려 count2를 배열에 넣어 뒀다가 최대값을 뽑아야 함.
				count1 = 1;
			}
			ans = Math.max(ans, count1);
		}
		int count2 = 1;
		for(int i=0; i<N-1; i++) {
			if(arr[i+1] <= arr[i]) { //감소하는 수열 검사
				count2++;
			}else { //초기화를 해버려 count2를 배열에 넣어 뒀다가 최대값을 뽑아야 함.
				count2 = 1;
			}
			ans = Math.max(ans, count2);
		}
		System.out.println(ans);
	}
}
