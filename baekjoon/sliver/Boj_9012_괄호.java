package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9012_괄호 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) {
			Stack<Character> ps = new Stack<>();
			String str = in.readLine();
			boolean flag = true;
			for(int j=0;j<str.length();j++) {
				if(str.charAt(j)=='(') {
					ps.add('(');
				} else {
					if(ps.size()==0) {
						sb.append("NO\n");
						flag = false;
						break;
					}
					else if(ps.peek()=='(') {
						ps.pop();
					}
					else {
						sb.append("NO\n");
						flag = false;
						break;
					}
				}
			}
			if(flag) {
				if(ps.size()>0) {
					sb.append("NO\n");
				} else {
					sb.append("YES\n");
				}	
			}
		}
		System.out.println(sb);
	}
}
