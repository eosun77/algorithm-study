package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2675_문자열반복 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		
		for(int tc=0;tc<t;tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int r = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			
			for(int i=0;i<s.length();i++) {
				for(int j=0;j<r;j++) {
					sb.append(s.charAt(i));
				}
			}
			sb.append("\n");
			
		}
		System.out.println(sb);
	}

}
