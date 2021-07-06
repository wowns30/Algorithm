package BOJ6_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_3079 {
	static int[] gate;
	static long maxHigh = 0;
	static long min = Long.MAX_VALUE;
	public static void main(String args[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		gate = new int[N];
		
		for(int i = 0; i < N; i++) {
			gate[i] = Integer.parseInt(in.readLine());
			maxHigh = Math.max(maxHigh, gate[i]);
		}
		getMinTime(N, M);
		System.out.println(min);
	}
	// 최소 시간 얻는 함수
	static void getMinTime(int n, int m) {
		long low = 0;
		long high = maxHigh * m;
		
		// 가능 시간 범위를 구하기 위한 이진탐색
		while(low <= high) {
			long mid = (low + high) / 2;
			long sum = 0;
			
			for(int time : gate) {
				long needPeopleCount = mid / time;
				// 굳이 정렬해서 0이 나오는 경우만 break할 필요 없이 
				// sum >= m 이 되면 더해봤자 의미 없으므로 바로 반복문을 종료시킨다.
				if(sum >= m) {
					break;
				}
				sum += needPeopleCount;
			}
			if(sum >= m) {
				System.out.println(mid + ", " + sum);
				min = Math.min(min, mid);
				high = mid - 1;
			}
			else {
				low = mid + 1;
			}
		}
	}
}