package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_최장증가부분수열 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc = 1; tc <= T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			int[] dp = new int[N];
			int maxAns = 0;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			for(int i=0;i<N;i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=0;i<N;i++) {
				int maxDepth = N;
				int maxDp = 0;
				for(int depth = i-1;depth>=0;depth--) {
					if(arr[i]>arr[depth]&&maxDp<dp[depth]) {
						maxDp = dp[depth];
						maxDepth = depth;
					}
				}
				if(maxDepth==N) dp[i] = 1;
				else dp[i] = dp[maxDepth] + 1;
				maxAns = Math.max(maxAns, dp[i]);
			}
			sb.append("#").append(tc).append(" ").append(maxAns).append("\n");
		}
		System.out.println(sb);
	}
}
