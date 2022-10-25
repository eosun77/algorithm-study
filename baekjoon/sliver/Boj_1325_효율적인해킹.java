package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1325_효율적인해킹 {
	
	static int[] dp;
	static ArrayList<Integer>[] computer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		computer = new ArrayList[N+1];
		dp = new int[N+1];
		for(int i=0;i<N+1;i++) {
			computer[i] = new ArrayList<>();
			dp[i] = -1;
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			computer[x].add(y);
		}
		
		int[] cnt = new int[N+1];
		for(int i=1;i<N+1;i++) {
			Queue<Integer> q = new LinkedList<Integer>();
			boolean[] isVisited = new boolean[N+1];
			q.add(i);
			isVisited[i] = true;
			while(!q.isEmpty()) {
				int x = q.poll();
				for(int j=0;j<computer[x].size();j++) {
					int next = computer[x].get(j);
					if(!isVisited[next]) {
						cnt[next]++;
						q.add(next);
					}
				}
			}
		}
		int max = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i=1;i<N+1;i++) {
			if(max<cnt[i]) {
				max = cnt[i];
				ans = new ArrayList<>();
				ans.add(i);
			} else if(max==cnt[i]) ans.add(i); 
		}
		
		for(int i=0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	} 
}
