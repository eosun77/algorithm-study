package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_13023_ABCDE {

	static int result = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
		for(int i=0;i<N;i++) {
			friend.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int f1 = Integer.parseInt(st.nextToken());
			int f2 = Integer.parseInt(st.nextToken());
			friend.get(f1).add(f2);
			friend.get(f2).add(f1);
		};
		for(int i=0;i<N;i++) {
			boolean[] isVisited = new boolean[N];
			result = 0;
			DFS(friend, isVisited, i, 0);
//			System.out.println(result);
			if(result==1) break;
		}
		System.out.println(result);
	}
	
	static void DFS(ArrayList<ArrayList<Integer>> friend, boolean[] isVisited, int V, int cnt) {
		if(cnt==4) {
			result = 1;
			return;
		}
		isVisited[V] = true;
		for(int i=0;i<friend.get(V).size();i++) {
			if(!isVisited[friend.get(V).get(i)]) {
				DFS(friend, isVisited, friend.get(V).get(i), cnt+1);
				isVisited[friend.get(V).get(i)] = false;
			}
		}
	}
}
