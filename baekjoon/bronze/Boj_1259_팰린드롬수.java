package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1259_팰린드롬수 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		String str = in.readLine();
		while(!str.equals("0")){
			flag = true;
			for(int i=0;i<str.length()/2;i++) {
				if(str.charAt(i)!=str.charAt(str.length()-i-1)) {
					flag = false;
					sb.append("no").append("\n");
					break;
				}
			}
			if(flag) sb.append("yes").append("\n");
			str = in.readLine();
		}
		System.out.println(sb);
	}

}
