//package BOJ0318;
//
//import java.util.Scanner;
//
///**
// * 5*5 크기의 숫자판의 각 칸에는 0~9의 숫자가 하나씩 적혀있다. 숫자판의 임의의 위치에서 시작해
// * 인접한 네 방향으로 다섯번 이동하면서, 각 칸에 적힌 숫자를 차례로 붙이면 6자리 숫자가 된다.
// * 이동을 할 때에는 한 번 거쳤던 칸을 다시 거칠 수 있고, 000123과 같은 수도 만들 수 있다.
// * 서로 다른 6자리의 수들의 개수를 구하라.
// * 
// * 입력
// * 5*5 숫자판
// * 출력
// * 만들 수 있는 수들의 개수
// * 
// * 풀이
// * 1. 
// */
//public class Main_S2_2210_숫자판점프 {
//
//	static int dr[] = {-1,1,0,0};
//	static int dc[] = {0,0,-1,1};	
//	static int num[][] = new int[5][5];
//	static boolean visited[][] = new boolean[5][5];
//	
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				num[i][j] = sc.nextInt();
//			}
//		}
//		String s = new String();
//		for(int i=0; i<5; i++) {
//			for(int j=0; j<5; j++) {
//				dfs(i,j,0,s);
//			}
//			
//		}
//		
//	
//	}
//
//}
