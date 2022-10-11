package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15961_회전초밥 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] sushiDish = new int[N];
		int[] isAte = new int[d+1];
		for(int i=0;i<N;i++) {
			sushiDish[i] = Integer.parseInt(in.readLine());
		}
		
		int[] dp = new int[N];
		isAte[c] = 1;
		for(int i=0;i<k;i++) {
			isAte[sushiDish[i]]++;
			if(isAte[sushiDish[i]]==1) dp[0]++;
		}
		int maxDp = dp[0];
		for(int x=1;x<N;x++) {
			int start = x-1;
			int end = x+k-1;
			
			if(end>=N) end -= N;
			
			isAte[sushiDish[start]]--;
			if(isAte[sushiDish[start]]==0) dp[x] = dp[x-1]-1;
			else dp[x] = dp[x-1];
			
			isAte[sushiDish[end]]++;
			if(isAte[sushiDish[end]]==1) dp[x]++;

			maxDp = Math.max(dp[x], maxDp);
		}
		System.out.println(maxDp+1);
	}
}
