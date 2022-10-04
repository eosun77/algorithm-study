package baekjoon.gold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2239_스도쿠 {
	static boolean ans = false;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int[][] puzzle = new int[9][9];
		for(int i=0;i<9;i++) {
			String str = in.readLine();
			for(int j=0;j<9;j++) {
				puzzle[i][j] = str.charAt(j)-'0';
			}
		}

		makePuzzle(puzzle, 0);
		
		System.out.println(sb);
	}
	
	static void makePuzzle(int[][] puzzle, int depth) {
		if(ans) return;
		if(depth==81) {
			for(int i=0;i<9;i++) {
				for(int j=0;j<9;j++) {
					sb.append(puzzle[i][j]);
				}
				sb.append("\n");
			}
			ans = true;
			return;
		}
		int[][] temp = new int[9][9];

		for(int i=0;i<9;i++) {
			for(int j=0;j<9;j++) {
				temp[i][j] = puzzle[i][j];
			}
		}
		int i=depth/9;
		int j = depth%9;
		if(puzzle[i][j]==0) {
			boolean[] num = {false, false, false, false, false, false, false, false, false};
			for(int x=0;x<9;x++) {
				if(puzzle[x][j]>0) num[puzzle[x][j]-1]=true;
			}
			for(int y=0;y<9;y++) {
				if(puzzle[i][y]>0) num[puzzle[i][y]-1]=true;
			}
			int nx = i%3;
			int ny = j%3;
			for(int dx=0;dx<3;dx++) {
				for(int dy=0;dy<3;dy++) {
					if(puzzle[i+dx-nx][j+dy-ny]>0) num[puzzle[i+dx-nx][j+dy-ny]-1]=true;
				}
			}
			for(int x=0;x<9;x++) {
				if(!num[x]) {
					temp[i][j] = x+1;
					makePuzzle(temp, depth+1);
				}
			}
			if(puzzle[i][j]==0) return;
		} else {
			makePuzzle(temp, depth+1);
		}
	}
}
