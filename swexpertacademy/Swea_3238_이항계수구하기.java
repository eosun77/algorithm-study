package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_3238_이항계수구하기 {

	static int MOD;

	public static void main(String[] args) throws NumberFormatException, IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int tc = Integer.parseInt(in.readLine());

		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(in.readLine().trim(), " ");
			long n = Long.parseLong(st.nextToken());
			long r = Long.parseLong(st.nextToken());
			MOD = Integer.parseInt(st.nextToken());

			long[] fact = new long[MOD + 1];
			fact[0] = fact[1] = 1;
			for (int i = 2; i <= MOD; i++) {
				fact[i] = (fact[i - 1] * i) % MOD;
			}

			long answer = 1;
			long N, R;
			while (n != 0 || r != 0) {
				N = n % MOD;
				R = r % MOD;
				if (N < R) {
					answer = 0;
					break;
				}

				answer = (answer * fact[(int) N]) % MOD;
				answer = answer * pow((fact[(int) R] * fact[(int) (N - R)]) % MOD, MOD - 2) % MOD;

				n /= MOD;
				r /= MOD;
			}

			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		System.out.println(sb.toString());
	}

	static long pow(long a, long b) {
		long res = 1L;
		a = a % MOD;
		while (b > 0) {
			if (b % 2 == 1)
				res = (res * a) % MOD;
			b = b >> 1;
			a = (a * a) % MOD;
		}
		return res;
	}
}
