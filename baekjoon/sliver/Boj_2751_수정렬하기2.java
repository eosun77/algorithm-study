package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Collections;

public class Boj_2751_수정렬하기2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(in.readLine()));
		}
		Collections.sort(list);
		for (int i = 0; i < N; i++) {
			sb.append(list.get(i)).append("\n");
		}
		System.out.println(sb);	
	}
}
