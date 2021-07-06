package BOJ0415;

import java.util.Scanner;

/**
 * 문제
 * 회전 초밥이 있다. 초밥의 종류를 번호로 표현한다. 벨트 위에는 같은 종류의 초밥이 둘 이상 있을  수 있다.
 * 1. 벨트 위의 임의의 한 위치에서 K개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공
 * 2. 1번 행사에 참가할 경우 쿠폰에 적힌 종류의 초밥 하나를 무료로 제공, 만약 이 번호에 적힌 초밥이 현재 벨트 위에 없을 경우, 새로 만들어 제공
 * 1,2번 행사에 참여해 최대한 많은 종류의 초밥을 먹으려 한다.
 * 
 * 입력
 * 벨트위의 접시 수 N, 초밥 종류의 수 d, 연속해서 먹는 접시 수 k, 쿠폰에 적힌 번호 c
 * N개의 줄에 벨트의 한 위치부터 시작해 회전 방향을 따라갈 때 초밥의 종류를 나타내는 1이상 d이하의 정수가 각 줄마다 하나씩 주어짐
 * 
 * 출력
 * 주어진 벨트 위의 초밥 중 먹을 수 있는 초밥의 가짓수의 최댓값
 */
public class Main_15961_회전초밥2 {
	static int N, d, k, c, sushi[], table[], maxCnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = sc.nextInt();
		k = sc.nextInt();
		c = sc.nextInt();
		table = new int[N]; // 입력받는 초밥
		sushi = new int[d+1]; // 초밥 종류

		for( int i = 0; i < N; i++) {
			table[i] = sc.nextInt();
		}
		maxCnt = 0;
		
		start();
		
		System.out.println(maxCnt);
		sc.close();
	}
	/** 연속 k개를 순차적으로 먹었을 떄 가장 많은 종류를 먹을 수 있는 수 */
	private static void start() {
		int eat = 0; // 먹었을 때 카운트
	
		// 일단 k개 만큼 먹는다.
		for( int i = 0; i < k; i++ ) {
			if(sushi[table[i]]++ == 0) { // 초밥 [테이블에 있는 종류] +1
				eat++; // 먹음
			}
		}
		// 쿠폰 초밥 먹었는지 확인.
		if(sushi[c] == 0) eat++; // 쿠폰 종류 초밥 먹은 적 없으면 먹고+1
		maxCnt = Math.max(eat, maxCnt); // 최대치 갱신
		if(sushi[c] == 0) eat--; // 가장 앞의 초밥을 안먹은 거로 치고 

		int idx = 0; // 가장 앞을 가리킬 인덱스
		for( int i = 1; i < N; i++ ) { // 가장 앞 바로 다음 초밥부터
			if(--sushi[table[idx]] == 0) { // 초밥[먹었던 가장 앞의 테이블위 종류] -1
				eat--; // 다시 안먹은걸로
			}
			// 원형처럼 연결이 되어있기 때문에 %N으로 나누어주어야한다. N을 벗어나면 가장 앞을 선택.
			if(sushi[table[(i+k-1)%N]]++ == 0) { 
	            eat++;
	         } 
			// 생각없이 아래처럼 짰다가 엄청엄청 틀렸다..
//			if(sushi[table[i]]++ == 0) {
//				eat++;
//			}
			if(sushi[c] == 0) eat++;
			maxCnt = Math.max(eat, maxCnt);
			if(sushi[c] == 0) eat--;
			idx++;
		}
	}
}