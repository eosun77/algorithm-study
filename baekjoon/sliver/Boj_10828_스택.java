package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10828_스택 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		Stack<Integer> stack = new Stack<>();
		for(int i=0;i<N;i++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			String op = st.nextToken();
			if(op.equals("push")) {
				stack.push(Integer.parseInt(st.nextToken()));
			} else if(op.equals("pop")) {
				if(!stack.isEmpty()) System.out.println(stack.pop());
				else System.out.println("-1");
			} else if(op.equals("size")) {
				System.out.println(stack.size());
			} else if(op.equals("empty")) {
				if(stack.isEmpty()) System.out.println("1");
				else System.out.println("0");
			} else if(op.equals("top")) {
				if(!stack.isEmpty()) System.out.println(stack.peek());
				else System.out.println("-1");
			}
		}
	}
}
