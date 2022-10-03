package baekjoon.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2798_블랙잭 {
	static int N, M;
	static int[] card;
	static int ans=0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine(), " ");
		card = new int[N];
		for(int i=0;i<N;i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		cardSelection(0, 0, 0);
		System.out.println(ans);
	}
	
	static void cardSelection(int n, int depth, int sum) {
		
		if(sum>M) return;
		
		if(depth==3) {
			ans = Math.max(sum, ans);
			return;
		}
		
		
		if(n==N) return;
		
		sum += card[n];
		cardSelection(n+1, depth+1, sum);
		
		sum -= card[n];
		cardSelection(n+1, depth, sum);
	}

}
