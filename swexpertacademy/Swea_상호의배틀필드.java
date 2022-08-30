package swexpertacademy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		StringBuilder sb = new StringBuilder();
		//BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("hw/input_상호의배틀필드.txt"))));
		int T = Integer.parseInt(in.readLine());
		for (int t = 0; t < T; t++) {
			
			sb.append("#").append(t+1).append(" ");

			String str = in.readLine();
			StringTokenizer st = new StringTokenizer(str, " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char map[][] = new char[H][W];
			int tankX = 0;
			int tankY = 0;
			int sTime = 0;
			for (int i = 0; i < H; i++) {
				str = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);
					if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '>') {
						tankX = i;
						tankY = j;
					}
				}
			}

			int N = Integer.parseInt(in.readLine());
			String move = in.readLine();
			
			for (int i = 0; i < N; i++) {
				if (move.charAt(i) == 'U') {
					if (tankX > 0 && map[tankX - 1][tankY] == '.') {
						map[tankX--][tankY] = '.';
						map[tankX][tankY] = '^';
					} else map[tankX][tankY] = '^';
				} else if (move.charAt(i) == 'D') {
					if (tankX < H - 1 && map[tankX + 1][tankY] == '.') {
						map[tankX++][tankY] = '.';
						map[tankX][tankY] = 'v';
					} else map[tankX][tankY] = 'v';
				} else if (move.charAt(i) == 'L') {
					if (tankY > 0 && map[tankX][tankY - 1] == '.') {
						map[tankX][tankY--] = '.';
						map[tankX][tankY] = '<';
					} else map[tankX][tankY] = '<';
				} else if (move.charAt(i) == 'R') {
					if (tankY < W - 1 && map[tankX][tankY + 1] == '.') {
						map[tankX][tankY++] = '.';
						map[tankX][tankY] = '>';
					} else map[tankX][tankY] = '>';
				} else if (move.charAt(i) == 'S') {
					if (map[tankX][tankY] == 'v') {
						sTime = 1;
						while (sTime > 0) {
							if (tankX + sTime < H && map[tankX + sTime][tankY] == '.')
								sTime++;
							else if (tankX + sTime < H && map[tankX + sTime][tankY] == '*') {
								map[tankX + sTime][tankY] = '.';
								sTime = 0;
							} else if (tankX + sTime < H && map[tankX + sTime][tankY] == '#') {
								sTime = 0;
							} else if (tankX + sTime < H && map[tankX + sTime][tankY] == '-') {
								sTime++;
							} else
								sTime = 0;
						}
					} else if (map[tankX][tankY] == '^') {
						sTime = 1;
						while (sTime > 0) {
							if (tankX - sTime >= 0 && map[tankX - sTime][tankY] == '.')
								sTime++;
							else if (tankX - sTime >= 0 && map[tankX - sTime][tankY] == '*') {
								map[tankX - sTime][tankY] = '.';
								sTime = 0;
							} else if (tankX - sTime >= 0 && map[tankX - sTime][tankY] == '#') {
								sTime = 0;
							} else if (tankX - sTime >= 0 && map[tankX - sTime][tankY] == '-') {
								sTime++;
							} else
								sTime = 0;
						}
					} else if (map[tankX][tankY] == '>') {
						sTime = 1;
						while (sTime > 0) {
							if (tankY + sTime < W && map[tankX][tankY + sTime] == '.')
								sTime++;
							else if (tankY + sTime < W && map[tankX][tankY + sTime] == '*') {
								map[tankX][tankY + sTime] = '.';
								sTime = 0;
							} else if (tankY + sTime < W && map[tankX][tankY + sTime] == '#') {
								sTime = 0;
							} else if (tankY + sTime < W && map[tankX][tankY + sTime] == '-') {
								sTime++;
							} else
								sTime = 0;
						}
					} else if (map[tankX][tankY] == '<') {
						sTime = 1;
						while (sTime > 0) {
							if (tankY - sTime >= 0 && map[tankX][tankY - sTime] == '.')
								sTime++;
							else if (tankY - sTime >= 0 && map[tankX][tankY - sTime] == '*') {
								map[tankX][tankY - sTime] = '.';
								sTime = 0;
							} else if (tankY - sTime >= 0 && map[tankX][tankY - sTime] == '#') {
								sTime = 0;
							} else if (tankY - sTime >= 0 && map[tankX][tankY - sTime] == '-') {
								sTime++;
							} else
								sTime = 0;
						}
					}
				}

			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb);

	}

}
