package com.ssafy.homework;

import java.util.Scanner;

public class BaekJoon_1244_Switch {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 스위치 개수
		int state [] = new int[N+1]; // 스위치 상태를 저장할 배열
		for(int i=1; i<=N; i++) {
			state[i] = sc.nextInt(); // 스위치 상태 입력
		}
		int M = sc.nextInt(); // 학생수
		int male = 1; // 남자는 1
		int female = 2; // 여자는 2
		
		while(M-->0) {	//학생수 만큼 반복
			int sex = sc.nextInt();
			int num = sc.nextInt();
			if(sex == male) { //남자일 때
				for(int i = num; i<N; i += num) { //
					if(state[i]==0) {
						state[i] = 1;
					}else {
						state[i] = 0;
					}
				}
			}
			else if(sex == female) { //여자일 때
				int left = num - 1;
				int right = num + 1;
				if(state[num]==0) {
					state[num]=1;
				}else {
					state[num]=0;
				}
				while(left > 0 && right <=N) {
					if(state[left] == state[right]) {
						if(state[left]==0) {
							state[left] = 1;
						}else {
							state[left] = 0;
						}if(state[right]==0) {
							state[right]=1;
						}else {
							state[right]=0;
						}//두 개의 if else 문을 합칠 수는 없을까?
						--left;
						++right;
					}else {
						break;
					}
				}
			}
		}
		for(int i = 1; i<=N; i++) {
			System.out.print(state[i] + " ");
			if(i%20==0) { //20개까지만 출력
				System.out.println();
			}
		}sc.close();
	}
}
