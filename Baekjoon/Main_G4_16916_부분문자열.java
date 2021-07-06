package BOJ0506;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_G4_16916_부분문자열 {

	static int ans=0;
	static int[] getPi(String p) {
		int[] arr = new int[p.length()];//문자열 p 길이 만큼의 배열 생성
		int j=0;	//j=0
		for(int i=1;i<p.length();i++) {
			while(j>0 && p.charAt(i)!=p.charAt(j)) {
				j = arr[j-1];
			}
			if(p.charAt(i)==p.charAt(j)) 
				arr[i] = ++j;
		}
		return arr;
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String p = br.readLine();
		//입력 완료
		KMP(s,p);
		System.out.println(ans);
	}
	
	static void KMP(String s, String p) {
		int[] arr = getPi(p);
		int j=0;
		for(int i=0;i<s.length();i++) {
			while(j>0 && s.charAt(i)!=p.charAt(j)) {
				j=arr[j-1];
			}
			if(s.charAt(i)==p.charAt(j)) {
				if(j==p.length()-1) {
					ans=1;
					break;
				}
				else
					j++;
			}
		}
	}
}