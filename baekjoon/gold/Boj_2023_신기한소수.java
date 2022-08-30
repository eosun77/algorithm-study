package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Boj_2023_신기한소수 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(in.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		list.add(2);
		list.add(3);
		list.add(5);
		list.add(7);	
		int cnt=1;
		while(cnt<n) {
			for (int i = 0; i < list.size(); i++) {
				for (int j = 1; j < 10; j++) {
					String num = Integer.toString(list.get(i)) + Integer.toString(j);
					int isp = Integer.parseInt(num);
					boolean flag = true;
					for (int k = 2; k <= Math.sqrt(isp); k++) {
						if (isp % k == 0) {
							flag = false;
							break;
						}
					}
					if (flag == true)
						temp.add(isp);
				}
			}
			list.clear();
			list.addAll(temp);
			temp.clear();
			cnt++;
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
