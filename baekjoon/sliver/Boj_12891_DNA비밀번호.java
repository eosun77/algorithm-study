package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_12891_DNA비밀번호 {
	static char[] inputStr;
	static int S, P, ans, cA, cC, cG, cT, nA, nC, nG, nT;
	static HashSet<String> answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		String input = in.readLine();
		StringTokenizer st = new StringTokenizer(input);
		S = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		inputStr = in.readLine().toCharArray();

		String conditionStr = in.readLine();
		StringTokenizer st2 = new StringTokenizer(conditionStr);
		cA = Integer.parseInt(st2.nextToken());
		cC = Integer.parseInt(st2.nextToken());
		cG = Integer.parseInt(st2.nextToken());
		cT = Integer.parseInt(st2.nextToken());

		nA = 0;
		nC = 0;
		nG = 0;
		nT = 0;
//		첫 번째 위치에서 nA, nC, nG, nT 초기화
		for (int i = 0; i < P; i++) {
			switch (inputStr[i]) {
			case 'A':
				nA++;
				break;
			case 'C':
				nC++;
				break;
			case 'G':
				nG++;
				break;
			case 'T':
				nT++;
				break;
			}
		}
		check();

		int start = 1;
		while (start + P <= S) {
			if (inputStr[start - 1] == 'A')
				nA--;
			if (inputStr[start - 1] == 'C')
				nC--;
			if (inputStr[start - 1] == 'G')
				nG--;
			if (inputStr[start - 1] == 'T')
				nT--;
			if (inputStr[start + P - 1] == 'A')
				nA++;
			if (inputStr[start + P - 1] == 'C')
				nC++;
			if (inputStr[start + P - 1] == 'G')
				nG++;
			if (inputStr[start + P - 1] == 'T')
				nT++;
			check();
			start++;
		}
		System.out.println(ans);

	}

	private static void check() {
		if (nA >= cA && nC >= cC && nG >= cG && nT >= cT)
			ans++;
	}

}
