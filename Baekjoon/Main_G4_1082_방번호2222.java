package BOJ0427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 방 번호
// 문자열, 그리디 
public class Main_G4_1082_방번호2222 {
	static int[] prices;
	static int n, money;
	static int min = Integer.MAX_VALUE, minIndex = 0;
	static StringBuilder sb;
	static String max = "";
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.valueOf(br.readLine());
		prices = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		// index : 숫자 , value : 해당 숫자를 살 수 있는 가격 
		for(int i = 0; i < n; i++) {
			prices[i] = Integer.valueOf(st.nextToken());
			if(prices[i] <= min) {	// 최소비용으로 살 수 있는 숫자 찾기 
				min = prices[i];
				minIndex = i;
			}
		}
		
		money = Integer.valueOf(br.readLine());
		sb = new StringBuilder();
		
		// 최대 숫자 개수 얻기 
		int maxLen = getMaxNumberLength();
		if(minIndex != 0) {	// 최소 비용의 숫자가 0이 아니면
			buyBigNumber(maxLen, money, false);
		}
		else {	// 최소 비용의 숫자가 0이면 
			buyBigNumber(maxLen, money, true);
		}
		
		System.out.println(sb.toString());
	}
	
	// 최소 비용의 숫자를 최대 몇 개 살수 있는지 찾기 
	static int getMaxNumberLength() {
		int len = 0;
		while(money >= min) {
			money -= min;
			len++;
		}
		
		return len;
	}
	
	// 최소 비용의 숫자가 0일 때, 전부 0으로 샀다면
	// isZero : 현재 전부 제로인지 체크하는 FLAG
	static void buyBigNumber(int maxLen, int money, boolean isZero) {
		String str = "";
		
		// 최대한 많이 0을 팔아서, 더 나은 숫자를 사야하니까 
		while(maxLen --> 0) {
			// 최소 숫자 하나를 버리고 돈을 얻기
			money += min;
			boolean getNumber = false;
			
			for(int i = n - 1; i >= 0; i--) {
				if(i == minIndex) {	// 이 뒤로는 같은 가격의 숫자가 존재하더라도 지금보다 작은 숫자이므로 굳이 탐색할 필요 없다.
					break;
				}
				
				if(prices[i] <= money) {	// 현재 가지고 있는 돈보다 비용이 크면 패스 
					getNumber = true;
					isZero = false;
					money -= prices[i];
					sb.append(i);
					break;
				}
			}
			
			// 하나의 최소 숫자를 팔았을 때, 아무것도 살 수 없다면 하나의 최소 숫자를 더 팔아서 다른 숫자를 사는게 아니라 판 것을 다시 사서 만드는게 가장 큰 숫자가 된다.
			if(!getNumber) {
				if(isZero) {	// 만약 전부 0인 상태에서 아무것도 살 수 없다면 하나 더 팔아서라도 다른 숫자를 사야한다.	
					continue;
				}
				else {	
					maxLen++; // 팔았던 최소숫자 회수하기
					break;	
				}
			}
		}
		
		// 정말 0밖에 없다면(이 경우에는 0하나만 존재하는 경우)
		if(isZero) {
			sb.append(0);
		}
		while(maxLen --> 0) {
			sb.append(minIndex);
		}
	}
}