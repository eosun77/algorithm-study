package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj_2579_계단오르기 {
	static int maxAns = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> stairs = new ArrayList<>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		for(int i=0;i<N;i++) {
			stairs.add(Integer.parseInt(in.readLine()));
		}
		
		upStair(stairs, -1, 0, 0);
		System.out.println(maxAns);
	}
	
	static void upStair(List<Integer> stairs, int n, int cnt, int score) {
		if(n==stairs.size()-1) {
			maxAns = Math.max(maxAns, score);
			return;
		}
		if(cnt!=2) {
			score += stairs.get(n+1);
			upStair(stairs, n+1, cnt+1, score);
			score -= stairs.get(n+1);
		}
		
		if(n!=stairs.size()-2) {
			score += stairs.get(n+2);
			upStair(stairs, n+2, 1, score);
		}
	}

}
