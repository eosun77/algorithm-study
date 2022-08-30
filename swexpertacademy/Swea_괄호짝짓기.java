package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Swea_괄호짝짓기 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int tc = 0; tc < 10; tc++) {
			int t = Integer.parseInt(in.readLine());
			String str = in.readLine();
			Stack<Character> bracket = new Stack<>();
			Stack<Character> temp = new Stack<>();
			for (int i = 0; i < str.length(); i++) {
				bracket.push(str.charAt(i));
			}
			while (!bracket.isEmpty()) {
				if (!temp.isEmpty()) {
					char b = bracket.pop();
					if (isMatch(temp.peek(),b)) {
						temp.pop();
					} else
						temp.push(b);

				} else
					temp.push(bracket.pop());
			}

			if (temp.isEmpty()) {
				sb.append("#").append(tc+1).append(" ").append("1").append("\n");
			} else
				sb.append("#").append(tc+1).append(" ").append("0").append("\n");
		}
		System.out.println(sb);

	}

	private static boolean isMatch(char c1, char c2) {
		switch (c1) {
		case ']':
			if (c2 == '[')
				return true;
			else
				return false;
		case '}':
			if (c2 == '{')
				return true;
			else
				return false;
		case ')':
			if (c2 == '(')
				return true;
			else
				return false;
		case '>':
			if (c2 == '<')
				return true;
			else
				return false;
		}
		return false;
	}
}
