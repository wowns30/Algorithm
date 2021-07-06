package BOJ0610;

import java.util.Scanner;

public class Main_회문 {
	static int T;
	static String s;
	static char[] arr;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t=1; t<=T; t++) {
			s=sc.next();
			arr=s.toCharArray();
			int left=0;
			int right=s.length()-1;
			if(check(left,right)) {
				System.out.println(0);
				continue;
			}
			if(check2(left,right)) {
				System.out.println(1);
			}else {
				System.out.println(2);
			}
		}
	}
	
	private static boolean check(int left,int right) {//회문 검사
		while(left<=right) {
			if(arr[left]!=arr[right]) {//다름
				return false;
			}
			left+=1;
			right-=1;
		}
		return true;
	}
	
	private static boolean check2(int left,int right) {//유사회문 검사
		while(left<=right) {
			if(arr[left]!=arr[right]) {//다름
				boolean a=check(left+1,right);
				boolean b=check(left,right-1);
				if(a==false && b==false) {
					return false;
				}else {
					return true;
				}
			}
			left+=1;
			right-=1;
		}
		return true;
	}
}