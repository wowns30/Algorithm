package BOJ0222;

import java.util.Arrays;
import java.util.Scanner;
/**
 * 방배정 백준 13300 Bronze 2
 * 1~6학년 학생들이 묵을 방을 배정해야 한다. 남자끼리, 여자끼리 배정, 한 방에는 같은 학년의 학생들을 배정
 * 한 방에 한 명도 가능, 최대 인원은 K로 주어짐, 방의 최소 개수를 구해라.
 *
 * 입력
 * 첫째줄 - 학생 수 N, 한 방에 배정 가능한 최대 인원 수 K
 * 다음 N개의 줄에는 학생의 성별 S, 학년 Y (S는 0은 여자, 1은 남자)
 * 
 * 출력
 * 최소 방의 수
 * 
 * 풀이
 * 1. 먼저 여학생과 남학생을 입력 받아 남녀 성별을 구분, 학년까지 구분하여 몇명이 있는지 배열에 저장
 * 2. 그 배열을 이용해 해당 인원을 K로 나누어 방을 배정하는데
 * 	2-1. 인원수를 K로 나누었을 때 나누어 떨어진다면(나머지가 0이라면) 필요한 방의 개수는 몫
 * 	2-2. 인원수를 K로 나누었을 때 나머지가 0이 아닌 다른 수라면 필요한 방의 개수는 몫 + 1
 */
public class Main_B2_13300_방배정 {

	public static void main(String[] args) {

//		int [][] arr = new int [2][7]; //성별과 학년을 저장할 2차원 배열
		
		int [] boy = new int [7];
		int [] girl = new int [7];
		int cntboy = 0;
		int cntgirl = 0;
		int ans = 0;
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		for(int n = 1; n<=N; n++) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			if(S==0) {
				girl[Y]++;
			}
			if(S==1) {
				boy[Y]++;
			}
		}
		for(int n = 1; n<7; n++) {
			if(boy[n]%K==0) {
				cntboy += boy[n]/K;
			}else {
				cntboy += (boy[n]/K + 1);
			}
		}
		for(int n = 1; n<7; n++) {
			if(girl[n]%K==0) {
				cntgirl += girl[n]/K;
			}else {
				cntgirl += (girl[n]/K + 1);
			}
		}
		ans = cntboy + cntgirl;
		System.out.println(ans);
	}
}