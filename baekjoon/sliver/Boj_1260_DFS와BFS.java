package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj_1260_DFS와BFS {
	static StringBuilder sb = new StringBuilder();
	static boolean[] isVisDFS, isVisBFS;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		isVisDFS = new boolean[N];
		isVisBFS = new boolean[N];
		
		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<M;i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			graph.get(n1-1).add(n2);
			graph.get(n2-1).add(n1);
		}
		for(int i=0;i<N;i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0;i<N;i++) {
			Collections.sort(graph.get(i));
		}

		DFS(graph, V);
		sb.append("\n");
		BFS(graph, V);
		System.out.println(sb);

	}
	
	static void DFS(ArrayList<ArrayList<Integer>> graph, int V) {
		sb.append(V).append(" ");
		isVisDFS[V-1] = true;
		
		for(int i=0;i<graph.get(V-1).size();i++) {
			int nv = graph.get(V-1).get(i);
			if(!isVisDFS[nv-1]) DFS(graph,nv);
		}
	}
	
	static void BFS(ArrayList<ArrayList<Integer>> graph, int V) {
		Queue<Integer> temp = new LinkedList<>();
		temp.add(V);
		isVisBFS[V-1] = true;
		while(!temp.isEmpty()) {
			int v = temp.poll();
			sb.append(v).append(" ");
			for(int i=0;i<graph.get(v-1).size();i++) {
				int nv = graph.get(v-1).get(i);
				if(!isVisBFS[nv-1]) {
					temp.add(nv);
					isVisBFS[nv-1] = true;
				}
			}
		}
	}
}
