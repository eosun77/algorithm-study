package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Swea_최소스패닝트리 {

	static int cnt =0;
	static long sumw=0;
	static int[] parent;
	static int[] rank;
	static class E {
		int a;
		int b;
		int w;
		public E(int a, int b, int w) {
			super();
			this.a = a;
			this.b = b;
			this.w = w;
		}
	}
	static E[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			sumw=0;
			sb.append("#").append(tc).append(" ");
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			parent = new int[V+1];
			rank = new int[V+1];
			for(int i=1;i<=V;i++) {
				MakeSet(i);
				rank[i] = 0;
			}
			arr = new E[E];
			for(int i=0;i<E;i++) {
				str = in.readLine();
				st = new StringTokenizer(str, " ");
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int w = Integer.parseInt(st.nextToken());
				arr[i] = new E(a, b, w);
			}
			Arrays.sort(arr, new Comparator<E>() {

				@Override
				public int compare(swexpertacademy.Swea_최소스패닝트리.E o1, swexpertacademy.Swea_최소스패닝트리.E o2) {
					// TODO Auto-generated method stub
					return o1.w-o2.w;
				}
			});

			for(int i=0;i<E;i++) {
				Union(i, arr[i].a, arr[i].b);
			}
			sb.append(sumw).append("\n");
		}
		System.out.println(sb);
	}
	static void MakeSet(int x) {
		parent[x] = x;
	}
	static int FindSet(int x) {
		if(parent[x]==x) return x;
		else return parent[x] = FindSet(parent[x]);
	}
	static void Union(int i, int x, int y) {

		if(parent[FindSet(x)]==parent[FindSet(y)]) return;
		
		if(rank[FindSet(x)]==rank[FindSet(y)]) {
			parent[FindSet(y)] = FindSet(x);
			sumw += arr[i].w;
			rank[FindSet(x)]++;
			cnt++;
		} else if(rank[FindSet(x)]>rank[FindSet(y)]) {
			parent[FindSet(y)] = FindSet(x);
			sumw += arr[i].w;
			cnt++;
		} else {
			parent[FindSet(x)] = FindSet(y);
			sumw += arr[i].w;
			cnt++;
		}
		
	}
	
}