package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2908_상수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		String A = st.nextToken();
		String A2 = "";
		String B = st.nextToken();
		String B2 = "";	
		for(int i=A.length()-1;i>=0;i--) {
			A2 += Character.toString(A.charAt(i));
		}
		for(int i=B.length()-1;i>=0;i--) {
			B2 += Character.toString(B.charAt(i));
		}
		System.out.println(Math.max(Integer.parseInt(A2), Integer.parseInt(B2)));
	}

}
