package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Jungol_1828_냉장고 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(in.readLine());
		List<Integer> refMax = new ArrayList<>();
		List<Integer> refMin = new ArrayList<>();
		int[][] xy = new int[t][2];
		for (int tc = 0; tc < t; tc++) {
			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			xy[tc][0] = Integer.parseInt(st.nextToken());
			xy[tc][1] = Integer.parseInt(st.nextToken());
 		}
		Arrays.sort(xy, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				 if (o1[0] == o2[0])
				      return o1[1] - o2[1];
				    else
				      return o1[0] - o2[0];
			}	
		});
		for (int tc = 0; tc < t; tc++) {
			int x = xy[tc][0];
			int y = xy[tc][1];
			int size = refMax.size();
			boolean flag = false;
			for (int i = 0; i < size; i++) {
				if (refMin.get(i) <= x && refMax.get(i) >= x){
					refMin.set(i, x); 
					flag = true;
				}
				if (refMin.get(i) <= y && refMax.get(i) >= y) {
					refMax.set(i, y);
					flag = true;
				}
				if(refMin.get(i)>x&&refMax.get(i)<y) {
					flag = true;
				}
				if(flag) break;
			}
			if (!flag) {
				refMin.add(x);
				refMax.add(y);
			}
			
//			for (int i = 0; i < refMax.size(); i++) {
//				System.out.println(refMin.get(i) + " ~ " + refMax.get(i));
//			}
//			System.out.println("=======================================");
		}
		System.out.println(refMax.size());
	}
}
