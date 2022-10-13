package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_5607_조합 {

	static int MOD = 1234567891;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			
			long[] fac = new long[N+1];
			fac[0] = 1;
			for(int i=1;i<=N;i++) { 
				fac[i] = fac[i-1] * i % MOD;
			}
			sb.append("#").append(tc).append(" ").append((fac[N]*pow(fac[R], MOD-2)% MOD * pow(fac[N-R], MOD-2)%MOD)%MOD).append("\n");
		}
		System.out.println(sb);
	}
	
	static long pow(long a, long b) {
		long res = 1L;
		a = a % MOD;
		while(b>0) {
			if(b%2==1) res = (res*a)% MOD;
			b = b >> 1;
			a = (a*a)% MOD;
		}
		return res;
	}
}
