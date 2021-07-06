package IMPrepare;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 문제
 * 일과를 마치고 돌아온 난쟁이가 7명이 아닌 9명일 때, 진짜 난쟁이 7명의 키를 합하면 100이 된다.
 * 이때 진짜 7명의 키를 오름차순으로 출력하라.
 * 
 * 입력
 * 아홉 개의 줄에 난쟁이의 키 주어짐, 100을 넘지 않는 자연수, 모두 다르다.
 * 
 * 출력
 * 일곱 난쟁이의 키를 오름차순으로 출력
 */
public class Main_B2_2309_일곱난쟁이2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		int sum = 0;
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<9; j++) {
				if(sum-arr[i]-arr[j]==100) {
					int tmp1 = arr[7];
					int tmp2 = arr[8];
					arr[7] = arr[i];
					arr[8] = arr[j];
					arr[i] = tmp1;
					arr[j] = tmp2;
				}
			}
		}
		arr = Arrays.copyOf(arr, arr.length-2);
		Arrays.sort(arr);
		for(int k=0; k<7; k++) {
			System.out.println(arr[k]);
		}
	}
}