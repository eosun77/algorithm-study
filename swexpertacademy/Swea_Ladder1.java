package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_Ladder1 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(
				new InputStreamReader(new FileInputStream(new File("swea/input_Ladder1.txt"))));
		int[][] ladder = new int[100][100];
		for (int tc = 0; tc < 10; tc++) {
			int tcn = Integer.parseInt(in.readLine());
			for (int i = 0; i < 100; i++) {
				String str = in.readLine();
				StringTokenizer st = new StringTokenizer(str, " ");
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < 100; i++) {
				if (ladder[0][i] == 1) {
					int start = i;
					for (int j = 1; j < 100;) {
//						System.out.println(j + " , " + start);
						if (start < 99 && ladder[j][start + 1] == 1) {
							while(ladder[j][start]==1) {
								start++;
								if(start==100) break;
							}
							start--;
							j++;
						}
						else if (start > 0 && ladder[j][start - 1] == 1) {
							while(ladder[j][start]==1) {
								start--;
								if(start==-1) break;
							}
							start++;
							j++;
						} else j++; 
					}
					if (ladder[99][start] == 2) {
						System.out.println("#"+tc+" " + i);
					}

				}
			}
		}
	}

}
