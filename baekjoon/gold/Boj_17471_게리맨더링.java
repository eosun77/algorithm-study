package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17471_게리맨더링 {

	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int[] pop = new int[N];
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		for(int i=0;i<N;i++) {
			pop[i] = Integer.parseInt(st.nextToken());
		}
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			graph.add(new ArrayList<>());
			for(int j = 0;j<n;j++) {
				graph.get(i).add(Integer.parseInt(st.nextToken())-1);
			}
		}
		boolean[] A = new boolean[N];
		boolean[] B = new boolean[N];
		for(int i=0;i<N;i++) {
			A[i] = false;
			B[i] = true;
		}
		Queue<Integer> q = new LinkedList<>();
		boolean[] isVisited = new boolean[N];
		int minAns = Integer.MAX_VALUE;
		q.add(0);
		while(!q.isEmpty()) {
			int n = q.poll();
			A[n] = true;
			B[n] = false;
			isVisited[n] = true;
//			for(int i=0;i<B.length;i++) {
//				System.out.print(B[i]+" ");
//			}
//			System.out.println();
			if(isConnected(graph, B)) {
				int suma = 0;
				int sumb = 0;
				for(int i=0;i<N;i++) {
					if(A[i]) {
						suma += pop[i];
					}
					if(B[i]) {
						sumb += pop[i];
					}
				}
				minAns = Math.min(minAns, Math.abs(suma-sumb));
				for(int i=0;i<graph.get(n).size();i++) {
					int nn = graph.get(n).get(i);
					if(!isVisited[nn]) {
						q.add(nn);
					}
				}
			} else {
				A[n] = false;
				B[n] = true;
			}
		}
		if(minAns==Integer.MAX_VALUE) minAns = -1;
		System.out.println(minAns);
		
	}
	
	static boolean isConnected(ArrayList<ArrayList<Integer>> graph, boolean[] A) {
		ArrayList<Integer> a = new ArrayList<>();
		boolean[] isVisited = new boolean[N];
		for(int i=0;i<N;i++) {
			if(A[i]) {
				isVisited[i] = false;
				a.add(i);
			} else {
				isVisited[i] = true;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(a.get(0));
		while(!q.isEmpty()) {
			int n = q.poll();
			isVisited[n] = true;
			for(int i=0;i<graph.get(n).size();i++) {
				int nn = graph.get(n).get(i);
				if(!isVisited[nn]) {
					q.add(nn);
				}
			}
			
		}
		for(int i=0;i<N;i++) {
			if(!isVisited[i]) return false;
		}
		return true;
	}
}
 