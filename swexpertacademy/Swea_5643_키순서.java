package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_5643_키순서 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc=1;tc<=T;tc++) {
			int N = Integer.parseInt(in.readLine());
			int M = Integer.parseInt(in.readLine());
			ArrayList<ArrayList<Integer>> smallList = new ArrayList<>();
			ArrayList<ArrayList<Integer>> bigList = new ArrayList<>();
			for(int i=0;i<N+1;i++) {
				smallList.add(new ArrayList<>());
				bigList.add(new ArrayList<>());
			}

			for(int i=0;i<M;i++) {
				StringTokenizer st = new StringTokenizer(in.readLine(), " ");
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				smallList.get(x).add(y);
				bigList.get(y).add(x);
			}
			int ans =0;
			for(int n=1;n<N+1;n++) {
				Queue<Integer> q = new LinkedList<Integer>();
				q.add(n);
				int smaller = 0;
				boolean[] isVisited = new boolean[N+1];
				while(!q.isEmpty()) {
					int x = q.poll();
					for(int i=0;i<smallList.get(x).size();i++) {
						if(!isVisited[smallList.get(x).get(i)]) {
							smaller++;
							isVisited[smallList.get(x).get(i)] = true;
							q.add(smallList.get(x).get(i));
						}
					}
				}
				q.add(n);
				int bigger = 0;
				isVisited = new boolean[N+1];
				while(!q.isEmpty()) {
					int x = q.poll();
					for(int i=0;i<bigList.get(x).size();i++) {
						if(!isVisited[bigList.get(x).get(i)]) {
							bigger++;
							isVisited[bigList.get(x).get(i)] = true;
							q.add(bigList.get(x).get(i));
						}
					}
				}
				if(smaller+bigger==N-1) ans++;
			}
			sb.append("#").append(tc).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
}
