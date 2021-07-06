package BOJ0223;

import java.util.Scanner;

public class Main_S5_2477_참외밭교수님 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int [][] data = new int[6][2];
		int wMax = 0, hMax = 0;
		for(int i=0; i<6; i++) {
			data[i][0] = sc.nextInt(); //방향
			data[i][1] = sc.nextInt(); //길이
			if(data[i][0] < 3) {
				wMax = Math.max(wMax, data[i][1]);
			}else {
				hMax = Math.max(hMax, data[i][1]);
			}
		}
		//최솟값 구하기
		int min = 1;
		for(int i=0; i<6; i++) {
			if(data[(i+5)%6][0] == data[(i+1)%6][0]) {
				min *= data[i][1];
			}
		}
		System.out.println((wMax * hMax - min)*K);
	}
}