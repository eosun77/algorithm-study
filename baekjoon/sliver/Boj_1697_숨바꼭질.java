package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697_숨바꼭질 {
	static int K;
	static int N;
	static int cnt = 0;
	static boolean[] isvisit = new boolean[100001];

	static class Person {
		int x;
		int time;
		public Person(int x, int time) {
			this.x = x;
			this.time = time;
		}
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		Person subin = new Person(N,0);
		System.out.println(BFS(subin).time);
	}

	static Person BFS(Person V) {
		Queue<Person> temp = new LinkedList<>();
		temp.add(V);
		isvisit[V.x] = true;
		while(!temp.isEmpty()) {
			Person v = temp.poll();
			if(v.x==K) return v;
			cnt++;
			if(v.x-1>=0&&v.x-1<100001&&!isvisit[v.x-1]) {
				temp.add(new Person(v.x-1, v.time+1));
				isvisit[v.x-1] = true;
			}
			if(v.x+1>=0&&v.x+1<100001&&!isvisit[v.x+1]) {
				temp.add(new Person(v.x+1, v.time+1));
				isvisit[v.x+1] = true;
			}
			if(v.x*2>=0&&v.x*2<100001&&!isvisit[v.x*2]) {
				temp.add(new Person(v.x*2, v.time+1));
				isvisit[v.x*2] = true;
			}
		}
		return V;
	}
}
