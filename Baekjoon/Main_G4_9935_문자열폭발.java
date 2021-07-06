package BOJ0513;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_G4_9935_문자열폭발 {

	static String st;
	static String ex;
	static StringBuilder str;
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		st = in.readLine();//원래 문자열
		ex = in.readLine();//폭발 문자열
		str = new StringBuilder(st);//원래 문자열과 같은 문자열

		repeat(str);
		System.out.println(ans.length() > 0 ? ans : "FRULA");
	}
	static StringBuilder repeat(StringBuilder call) {
		for(int i=0; i<=call.length()-ex.length(); i++) {//(원래 문자열의 길이 - 폭발문자열의 길이)만큼 반복
			for(int j=i, c=0; j<i+ex.length() && c<ex.length(); j++, c++) {	
				
				if(c==ex.length()-1 && ex.charAt(c) == st.charAt(j)) {
					ans = explore(call, ex, j-ex.length()+1);//그렇다면 처음 문자가 일치한 index부터 폭발 문자열의 길이 만큼 없애 줘야 함
					repeat(ans);
				}
				
				if(c!=ex.length()-1 && st.charAt(j)==ex.charAt(c)) continue;//만약 원래 문자열의 j번째 문자와 폭발 문자열의 c번째 문자가 같다면  다음 문자 탐색
				
				else {
					break;
				}
			}
		}
		return ans;

	}
	static StringBuilder explore(StringBuilder ori, String k, int index) {
		
		StringBuilder answer = null;
		
		for(int i=0; i<k.length(); i++) {
			answer = ori.deleteCharAt(index);
		}
		str = answer;
		return answer;
	}

}
