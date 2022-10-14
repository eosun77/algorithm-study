package swexpertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2112_보호필림 {
	static int[][] film;
	static int D, W, K;
	static boolean end;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for(int tc=1;tc<=T;tc++) {
			end = false;
			StringTokenizer st = new StringTokenizer(in.readLine(), " ");
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			film = new int[D][W];
			for(int i=0;i<D;i++) {
				st = new StringTokenizer(in.readLine(), " ");
				for(int j=0;j<W;j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			boolean[] isSelected = new boolean[D];
			if(test(film)) end = true;
			int r = 0;
			while(!end) {
				r++;
				com(isSelected, 0, 0, r);
			}
			sb.append("#").append(tc).append(" ").append(r).append("\n");
		}
		System.out.println(sb);
	}
	static void copyA2B(int[][] a, int[][] b) {
		for(int i=0;i<D;i++) {
			for(int j=0;j<W;j++) {
				b[i][j] = a[i][j];
			}
		}
	}
	static void com(boolean[] isSelected, int depth, int n, int r) {
		if(end) return;
		
		if(n==r) {
			int[] drink = new int[r];
			selecteAB(drink, r, 0, isSelected);
			return;
		}
		if(depth==D) return;
		isSelected[depth] = true;
		com(isSelected, depth+1, n+1, r);
		isSelected[depth] = false;
		com(isSelected, depth+1, n, r);
	}
	private static void selecteAB(int[] drink, int r, int depth, boolean[] isSelected) {
		if(end) return;
		
		if(depth==r) {
			int cnt =0;
			int[][] temp = new int[D][W];
			copyA2B(film, temp);
			for(int i=0;i<D;i++) {
				if(isSelected[i]) {
					for(int j=0;j<W;j++) {
						temp[i][j] = drink[cnt];
					}
					cnt++;
				}
			}
			if(test(temp)) end = true;
			return;
		}
		
		drink[depth] = 0;
		selecteAB(drink, r, depth+1, isSelected);
		drink[depth] = 1;
		selecteAB(drink, r, depth+1, isSelected);
	}
	static boolean test(int[][] film) {
		for(int i=0;i<W;i++) {
			int check = 0;
			int ab = 0; // a면 0 b면 1
			for(int j=0;j<D;j++) {
				if(film[j][i]==0 && ab==0) {
					check++;
				} else if(film[j][i]==0 && ab==1) {
					check=1;
					ab=0;
				} else if(film[j][i]==1 && ab==1) {
					check++;
				} else if(film[j][i]==1 && ab==0) {
					check=1;
					ab=1;
				}
				if(check>=K) break;
			}
			if(check<K) return false;
		}
		return true;
	}
}
