package IMPrepare;

import java.util.Scanner;

/**
 * 문제
 * 100*100인 흰색 도화지에 가로,세로 길이가 10인 정사각형 검은 색종이를
 * 도화지 변과 색종이 변이 평행하게 붙인다. 이때 여러 장 겹쳐 붙일 수 있을 때 색종이가 붙은 영역의 넓이를 구해라
 * 
 * 입력
 * 첫째 줄에 색종이 수, 둘째 줄부터 한 줄에 하나씩 붙인 위치(두 자연수는 색종이의 왼쪽 아래 모서리의 x,y좌표)
 * 
 * 출력
 * 색종이가 붙어있는 면적의 넓이
 * 
 * 풀이
 * 도화지를 100*100의 배열로 보면 색종이가 붙은 부분은 1로, 나머지는 0으로 보고 1의 개수를 세어보면 된다.
 */
public class Main_S5_2563_색종이 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int paper[][] = new int[100][100];
		for(int i=0; i<N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int k = x; k<x+10; k++) {
				for(int n = y; n<y+10; n++) {
					paper[k][n] = 1;
				}
			}
		}
		int count = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++) {
				if(paper[i][j]==1) {
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
