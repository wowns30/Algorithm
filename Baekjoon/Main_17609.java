package BOJ0610;

import java.util.Scanner;

public class Main_17609 {

   static String tmp;
   static char[] arr;
   
   public static void main(String[] args) {

	  Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      for(int t=1; t<=T; t++) {
         tmp = sc.next();
         arr = tmp.toCharArray();
         int left = 0;
         int right = tmp.length() - 1;
         if(check(left, right)) {
        	 System.out.println(0);
        	 continue;
         }
         if(check2(left, right)) {
        	 System.out.println(1);
         }else {
        	 System.out.println(2);
         }
      }
   }
   private static boolean check(int left,int right) {//회문 검사
		while(left <= right) {
			if(arr[left] != arr[right]) {//다름
				return false;
			}
			left+=1;
			right-=1;
		}
		return true;
	}
   private static boolean check2(int left,int right) {//유사회문 검사
		while(left <= right) {
			if(arr[left] != arr[right]) {//다름
				boolean tmp1 = check(left+1,right);
				boolean tmp2 = check(left,right-1);
				if(tmp1 == false && tmp2 == false) {
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