package BOJ0415;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
public class Main_15961_회전초밥 {

	static int N, d, k, coupon, count;
	static int belt[], sushi[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine()," ");
		N = Integer.parseInt(st.nextToken());		//벨트 위 접시 수
		d = Integer.parseInt(st.nextToken());		//초밥의 종류, 몇 가지의 초밥이 있는지
		k = Integer.parseInt(st.nextToken());		//연속해서 먹는 접시 수
		coupon = Integer.parseInt(st.nextToken());	//쿠폰에 적힌 초밥 번호
		belt = new int[N];		//벨트 위 접시 수 만큼 벨트 배열 선언
		sushi = new int[d+1];	//초밥의 종류 만큼 초밥 배열 선언
		for(int i=0; i<N; i++) {
			belt[i] = Integer.parseInt(in.readLine());//벨트 위 초밥의 번호를 벨트 배열에 입력
		}
		count = 0;
		//시작
		//연속으로 k개를 먹었을 때 가장 많은 종류의 초밥을 먹을 수 있는 수를 구하자
		int eatCnt = 0;//먹은 초밥 수 초기화
		for(int i=0; i<k; i++) {//k개 먹는다.
			if(sushi[belt[i]] == 0) {//먹었던 초밥이 아니면
				eatCnt++;//먹는다.
			}
			sushi[belt[i]]++;//먹음 처리
		}
		
		//쿠폰 번호 초밥을 먹었는지 확인
		if(sushi[coupon] == 0) {//쿠폰에 적힌 번호의 초밥을 먹지 않았다면
			eatCnt++;//먹고 +1
		}
		count = Math.max(eatCnt, count);//최대값 갱신
		if(sushi[coupon] == 0) {//가장 먼저 먹은 초밥을 먹지 않았다고 생각하고
			eatCnt--;//먹은 초밥 수 -1
		}
		int idx = 0;//가장 먼저 먹은 초밥을 가리키는 index
		for(int i=1; i<N; i++) {//두 번째로 먹은 초밥부터 검사
			if(--sushi[belt[idx]] == 0) {
				//전에 먹었던 초밥은 안먹은 것으로 돌려놓고, 먹은적이 없다면
				eatCnt--;
			}
			if(sushi[belt[(i+k-1)%N]] == 0) {//N을 벗어나면 다시 0번째로 돌아감
				eatCnt++;//다음 초밥이 먹지 않은 초밥이면 먹는다.
			}
			sushi[belt[(i+k-1)%N]]++;
			
			//쿠폰에 적힌 초밥이 먹어보지 않은 종류라면 
			if(sushi[coupon] == 0) {
				eatCnt++;//먹는다.
			}
			count = Math.max(eatCnt, count);
			if(sushi[coupon] == 0) {
				eatCnt--;
			}
			idx++;
		}
		System.out.println(count);
	}
}
