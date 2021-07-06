package BOJ0222;

import java.util.Scanner;
/**
 * 색종이를 평면에 놓는다. 비스듬하게 놓이는 경우는 없다. 평면은 101*101
 * 
 * 입력
 * 색종이의 장 수 N 1~100
 * 이어서 N장의 색종이에 관한 입력이 색종이마다 한 줄씩 주어짐
 * 
 * 출력
 * 색종이가 놓인 부분의 면적을 한 줄에 하나씩 하나의 정수로 출력
 * ex) 첫 번째 줄의 출력은 첫 번째로 놓은 색종이가 현재 보이는 면적의 넓이
 * 
 * 풀이
 * 1번 색종이가 놓이는 곳을 1로 바꿈
 * 2번 색종이가 놓이는 곳은 2로 바꿈 
 * 위와 같은 과정을 반복하여 각 위치에 표시된 숫자를 count
 */
public class Main_B1_10163_색종이 {
	
	public static void main(String[] args) {
		
		int arr[][] = new int [101][101];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr2[] = new int [N+1];
		for(int n = 1; n<=N; n++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for(int i = x; i<x+w; i++) {
				for(int j = y; j<y+h; j++) {
					arr[i][j] = n;
				}
			}
		}
		for(int i = 0; i<101; i++) {
			for(int j = 0; j<101; j++) {
				arr2[arr[i][j]]++;
			}
		}
		for(int i = 1; i<=N; i++) {
			System.out.println(arr2[i]);
		}
	}
}