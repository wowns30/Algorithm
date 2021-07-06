package IMPrepare;

import java.util.Scanner;

/**
 * 문제
 * 25개의 칸으로 이루어진 빙고판에 1~25까지의 자연수를 쓴다.
 * 불리는 수를 차례로 지워나간다.지워가다가 같은 가로줄 또는 세로줄, 또는 대각선 위의 5개의 수가 지워지는 경우
 * 그 줄에 선을 긋는다. = 1빙고
 * 이러한 선이 3개 이상 되면 빙고라고 외친다. 이때 가장 먼저 외치는 사람이 게임의 승자가 된다.
 * 
 * 입력
 * 첫 5줄은 빙고판, 다음 5줄은 사회자가 부르는 수를 순서대로 나열.
 *
 */
public class Main_S5_2578_빙고 {

	static int bingo[][] = new int [5][5];
	static int call[] = new int [25];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				bingo[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<25; i++) {
			call[i] = sc.nextInt();
		}
		int cnt = 0;
		for(int j=0; j<25; j++) {
			int tmp = call[j];
			cnt++;
			for(int x=0; x<5; x++) {
				for(int y=0; y<5; y++) {
					if(bingo[x][y] == tmp) {
						bingo[x][y] = 0;
						if(bingochk(x,y)>=3) {
							System.out.println(cnt);
							return;
						}
					}
				}
			}
		}
	}
	public static int bingochk(int x, int y) {
		int count = 0;
		//행 검사
		for(int i=0; i<5; i++) {
			int rowCnt = 0;
			for(int j=0; j<5; j++) {
				if(bingo[i][j]==0) {
					rowCnt++;
				}
			}
			if(rowCnt == 5) {
				count++;
			}
		}
		//열 검사
		for(int i=0; i<5; i++) {
			int colCnt = 0;
			for(int j=0; j<5; j++) {
				if(bingo[j][i]==0) {
					colCnt++;
				}
			}
			if(colCnt == 5) {
				count++;
			}
		}
		//오른쪽 아래로 향하는 대각선 검사
		int cross1 = 0;
		for(int i=0; i<5; i++) {
			if(bingo[i][i] == 0) {
				cross1++;
			}
			if(cross1 == 5) {
				count++;
			}
		}
		//오른쪽 위로 향하는 대각선 검사
		int cross2 = 0;
		for(int i=0; i<5; i++) {
			if(bingo[4-i][i] == 0) {
				cross2++;
			}
			if(cross2 == 5) {
				count++;
			}
		}
		return count;
	}
}
