package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_사칙연산유효성검사 {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("src/hw/input_사칙연산유효.txt"))));
		StringBuilder sb = new StringBuilder();
		
		for(int t=1;t<=10;t++ ) {
			int n = Integer.parseInt(in.readLine());
			int result = 1;
			for (int i = 0; i < n; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				st.nextToken();

				char node = st.nextToken().charAt(0);
				if (st.hasMoreTokens()) {
					if ('0' <= node && '9' >= node)
						result = 0;
				} else {
					if ('0' > node && '9' < node)
						result = 0;
				}
			}
			sb.append("#").append(t).append(" ").append(result).append("\n");
		}
		System.out.println(sb);

	}

}
