package BOJ0318;

import java.util.Scanner;

public class Main_S3_15651_N과M3_22222 {
	static int[] arr;
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	N = in.nextInt();
	M = in.nextInt();
	arr = new int[M];
	perm(0);
	System.out.print(sb);
	}
	
	public static void perm(int depth) {
		if (depth == M) {
			for (int i = 0; i < M; i++) {
				sb.append(arr[i] + " ");
			}
			sb.append('\n');
			return;
		}
		for (int i = 1; i <= N; i++) {
			arr[depth] = i;
			perm(depth + 1);
		}
	}
}

