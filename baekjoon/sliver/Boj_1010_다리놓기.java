package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1010_다리놓기 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(in.readLine());
		for (int tc = 0; tc < t; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			double n = Double.parseDouble(st.nextToken());
			double m = Double.parseDouble(st.nextToken());
			
			sb.append(String.format("%.0f",com(m,n))).append("\n");
		}
		System.out.println(sb);
	}

	static double com(double m, double n) {
		double a = 1;
		double b = 1;
		
		for(double i=m;i>m-n;i--) {
			a *=i;
		}
		for(double i=n;i>0;i--) {
			b *= i;
		}	
		return a/b;
	}
}
