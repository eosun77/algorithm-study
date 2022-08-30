package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_1541_잃어버린괄호 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		String token = "";
		List<Integer> num = new ArrayList<>();
		List<Character> sym = new ArrayList<>();
		for (int i = 0; i < str.length(); i++) {
			if ('0' <= str.charAt(i) && '9' >= str.charAt(i)) {
				token += Character.toString(str.charAt(i));
			} else {
				num.add(Integer.parseInt(token));
				sym.add(str.charAt(i));
				token = "";
			}
		}
		num.add(Integer.parseInt(token));
		int result = num.get(0);
		boolean flag = false;
		for (int i = 0; i < sym.size(); i++) {
			if (flag) {
				result -= num.get(i + 1);
			} else {
				if (sym.get(i) == '+') {
					result += num.get(i + 1);
				} else if (sym.get(i) == '-') {
					flag = true;
					result -= num.get(i + 1);
				}
			}
		}
		System.out.println(result);
	}
}
