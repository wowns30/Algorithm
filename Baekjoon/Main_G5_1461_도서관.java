package BOJ0511;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제
 * 도서관의 책들을 정리해야 한다. 현재 위치는 0, 사람들이 마구 놓은 책도 전부 0에 위치해 있다.
 * 각 책들의 원래 위치가 주어질 때, 책을 모두 제자리에 놔둘 때 드는 최소 걸음 수를 계산하라.
 * 한 걸음에 좌표 1칸, 책의 원래 위치는 정수 좌표. 모두 제자리에 둔 후에 0으로 돌아올 필요는 없다.
 * 한 번에 최대 M개의 책을 들 수 있다.
 * 
 * 입력
 * 책의 개수 N, 한 번에 들 수 있는 책의 권 수 M
 * 책의 위치
 *
 */

public class Main_G5_1461_도서관 {

	static int N, M;
	static int books[];
	static int el, max, sum;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Queue<Integer> plus = new PriorityQueue<Integer>((x,y) -> y-x);
		Queue<Integer> minus = new PriorityQueue<Integer>();
		books = new int[N];
		st = new StringTokenizer(in.readLine(), " ");
		for(int i=0; i<N; i++) {
			books[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<N; i++) {
			if(books[i] > 0) {
				plus.add(books[i]);
			}else {
				minus.add(books[i]);
			}
		}
		
		max = 0;
		sum = 0;
		
		while(!plus.isEmpty()) {
			for(int i=0; i<M; i++) {
				if(plus.isEmpty()) continue;
				el = plus.poll();
				if(i==0) {
					sum += Math.abs(el);
					if(Math.abs(el)>max) {
						max = Math.abs(el);
					}
				}
			}
		}
		while(!minus.isEmpty()) {
			for(int i=0; i<M; i++) {
				if(minus.isEmpty()) continue;
				el = minus.poll();
				if(i==0) {
					sum += Math.abs(el);
					if(Math.abs(el)>max) {
						max = Math.abs(el);
					}
				}
			}
		}
		System.out.println(sum * 2 - max);
	}
}
