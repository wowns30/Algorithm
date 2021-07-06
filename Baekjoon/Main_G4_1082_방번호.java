package BOJ0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_1082_방번호 {

	static int N, money;
	static int price[];
	static String answer ="";
	static int min = Integer.MAX_VALUE;
	static int minIdx = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		price = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			if(price[i] <= min) {	//최소의 비용으로 살 수 있는 숫자
				min = price[i];		//숫자들의 비용 중 가장 저렴한 가격
				minIdx = i;			//가장 저렴한 비용의 숫자
			}
		}
		money = Integer.parseInt(in.readLine());//가진 돈
		//입력 완료
		
		int max = getMaxNumber();		//살 수 있는 수의 최대 수 얻기
		if(minIdx != 0) {				//가장 저렴한 비용의 숫자가 0이 아닐 경우
			buyNum(max, money, false);	//0이 아님을 표시하고 수를 사기 시작
		}else {
			buyNum(max, money, true);	//0임을 표시하고 수를 사기 시작
		}
		
		System.out.println(answer);
	}
	static int getMaxNumber() {		//가장 큰 수의 길이 얻기
		int len = 0;				//초기화
		while(money >= min) {		//money가 숫자들의 비용 중 가장 저렴한 가격 min보다 크거나 같으면
			money -= min;			//money에서 min을 빼는 일을 반복
			len++;					//한 번 뺄 때마다 1씩 추가해 큰 수의 길이, 즉 살 수 있는 수의 개수를 파악
		}
		return len;					//len 반환
	}
	static void buyNum(int max, int money, boolean checkZero) {
		
		while(max-- > 0) {				//max가 0보가 클경우 반복
			money += min;				//money에 다시 min을 더해준다.
			boolean getNumber = false;	//수를 아직 사지 않았음 표시
			for(int i=N-1; i>=0; i--) {	//수는 큰수부터 
				if(i == minIdx) {		//가장 저렴한 비용의 숫자가 i와 같다면
					break;				//for문 탈출
				}
				if(price[i] <= money) {	//만약 현재 가격이 money보다 작거나 같다면
					getNumber = true;	//수 살 수 있음
					checkZero = false;	//0이 아님 표시
					money -= price[i];	//money에서 현재 가격 빼줌
					answer += Integer.toString(i);//answer에서 추가하여 출력을 준비
					break;				//for문 탈출
				}
			}
			//하나의 최소의 숫자를 팔았을 때, 아무것도 살 수 없다면 하나의 최소 숫자를 더 팔아 
			//다른 숫자를 사는것이 아니라 판 것을 다시 사서 만드는 것이 가장 큰 숫자가 된다.
			if(!getNumber) {			//현재 수를 사지 않았을 때, 하나를 더 팔아서라도 다른 수를 사야한다.
				if(checkZero) {			//현재 구매한 모든 숫자가 0일 경우
					continue;			//다음으로 넘어감
				}else {					//현재 구매한 모든 숫자가 0이 아닐 경우
					max++;				//팔았던 최소의 수 다시 복구 while문 탈출
					break;
				}
			}
		}
		if(checkZero) {							//가장 저렴한 비용의 숫자가 0일 경우
			answer += Integer.toString(0);		//answer에 추가
		}
		while(max-- > 0) {						//max
			answer += Integer.toString(minIdx);
		}
	}
}
