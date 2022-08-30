package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


public class Boj_2164_카드2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		Queue<Integer> cards = new LinkedList<>();
		
		for(int i =0;i<n;i++) {
			cards.offer(i+1);
		}
		
		while(cards.size()>1) {
			cards.poll();
			cards.offer(cards.poll());
		}
		System.out.println(cards.poll());
	}
}
