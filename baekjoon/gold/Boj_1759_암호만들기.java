package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1759_암호만들기 {
	static char[] aeiou = { 'a', 'e', 'i', 'o', 'u' };

	public static void main(String[] args) throws IOException {
		boolean[] isVisited = new boolean[26];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		char[] password = new char[C];
		for (int i = 0; i < C; i++) {
			password[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(password);
		comb(password, isVisited, 0, L, C);
	}

	static void comb(char[] password, boolean[] isVisited, int depth, int L, int C) {
		if (L == 0) {
			int cntA = 0;
			boolean flag = true;
			int cntB = 0;
			for (int i = 0; i < 26; i++) {
				if (isVisited[i]) {
					for (int j = 0; j < 5; j++) {
						if (password[i] == aeiou[j]) {
							cntA++;
							flag = false;
							break;
						}
					}
					if (flag)
						cntB++;
				}
				flag = true;
			}
			if(cntA>0l&&cntB>1) {
				for (int i = 0; i < 26; i++) {
					if (isVisited[i]) System.out.print(password[i]);
				}
				System.out.println();
			}
			return;
		}
		if (depth == C)
			return;

		isVisited[depth] = true;
		comb(password, isVisited, depth + 1, L - 1, C);
		isVisited[depth] = false;
		comb(password, isVisited, depth + 1, L, C);
	}
}
