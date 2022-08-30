package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_10814_나이순정렬 {
	static class Member implements Comparable<Member> {
		int age;
		public Member(int age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		String name;
		@Override
		public int compareTo(Member m) {
			return this.age-m.age;
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		ArrayList<Member> m = new ArrayList<>();
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			Member member = new Member(Integer.parseInt(st.nextToken()), st.nextToken());
			m.add(member);
		}
		Collections.sort(m);
		for(int i=0;i<N;i++) {
		System.out.println(m.get(i).age + " " + m.get(i).name);
		}
	}

}
