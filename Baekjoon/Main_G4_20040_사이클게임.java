package BOJ0429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_G4_20040_사이클게임 {

	static int n, m, ans, Node[];
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Node = new int[n];
		for(int i=0; i<n; i++) {
			Node[i] = i;
		}
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(!union(a,b)) {//사이클 형성 확인, 사이클이면
				ans = i;
				break;
			}
		}
		System.out.println(ans);
	}
	private static boolean union(int a, int b) {
		int aRoot = findRoot(a);
		int bRoot = findRoot(b);
		if(aRoot == bRoot) {//사이클이 형성 됨
			return false;
		}
		Node[aRoot] = bRoot;
		return true;
	}
	private static int findRoot(int x) {
		if(x == Node[x]) return x;
		return Node[x] = findRoot(Node[x]);
	}
}	
