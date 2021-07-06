package BOJ0323;

import java.util.Scanner;

/**
 * 문제
 * 준규네 나라는 수 3개를 이용해 연도를 나타낸다. 각각의 수는 지구,태양,달을 나타낸다.
 * E,S,M 일때, 15이하,28이하,19이하
 * 우리가 아는 1년은 준규네에선 1 1 1 로 표현한다.
 * 1년이 지날 때마다, 세 수는 모두 1씩 증가, 만약 범위를 넘어가면 다시 1이 된다.
 * 예를 들어 16년이면 1 16 16이 된다. 
 * 주어진 년도를 보고 준규네 나라 연도를 우리가 알고 있는 연도로 몇 년인지 구하는 프로그램 작성하라.
 * 
 * 입력
 * E, S, M
 * 출력
 * 가장 빠른 연도.
 */
public class Main_S5_1476_날짜계산 {

	public static void main(String[] args) {

		int e=1,s=1,m=1;
		
		Scanner sc = new Scanner(System.in);
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();

		for(int i=1; ; i++) {
			if(e==E && s==S && m==M) {
				System.out.println(i);
				break;
			}
			e += 1;
			s += 1;
			m += 1;
			
			if(e == 16) {
				e = 1;
			}
			if(s == 29) {
				s = 1;
			}
			if(m == 20) {
				m = 1;
			}
		}
	}
}
