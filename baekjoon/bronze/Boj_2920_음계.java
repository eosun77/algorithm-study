package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2920_음계 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");

		char[] ascending = { '1', '2', '3', '4', '5', '6', '7', '8' };
		char[] descending = { '8', '7', '6', '5', '4', '3', '2', '1' };
		char[] input = new char[8];

		for (int i = 0; i < 8; i++) {
			input[i] = st.nextToken().charAt(0);
		}
		
		if(Arrays.equals(ascending, input)) {
			System.out.println("ascending");
		} else if(Arrays.equals(descending , input)) {
			System.out.println("descending");
		} else System.out.println("mixed");
	}

}
