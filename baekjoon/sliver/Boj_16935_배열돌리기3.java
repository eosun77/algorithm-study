package baekjoon.sliver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16935_배열돌리기3 {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str = in.readLine();
		StringTokenizer st = new StringTokenizer(str, " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int[][] arr = new int[Math.max(n,m)][Math.max(n,m)];
		
		for (int i = 0; i < n; i++) {
			str = in.readLine();
			st = new StringTokenizer(str, " ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[] com = new int[r];
		str = in.readLine();
		st = new StringTokenizer(str, " ");
		for (int i = 0; i < r; i++) {
			com[i] = Integer.parseInt(st.nextToken());
		}
		int temp=0;
		for(int i=0;i<r;i++) {
			switch(com[i]) {
			case 1 :
				com1(arr, n, m);
				break;
			case 2 : 
				com2(arr, n, m);
				break;
			case 3 :
				arr = com3(arr, n, m);
				temp = n;
				n = m;
				m = temp;
				break;
			case 4 : 
				arr = com4(arr, n, m);
				temp = n;
				n = m;
				m = temp;
				break;
			case 5 : 
				arr = com5(arr, n, m);
				break;
			case 6 : 
				arr = com6(arr, n, m);
				break;
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(arr[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void com1 (int[][] arr, int n, int m) {
		int[] temp = new int[m];
		for(int i=0;i<n/2;i++) {
			temp = arr[i];
			arr[i] = arr[n-i-1];
			arr[n-i-1] = temp;
		}
	}
	static void com2 (int[][] arr, int n, int m) {
		int temp;
		for(int i=0;i<m/2;i++) {
			for(int j=0;j<n;j++) {
				temp = arr[j][i];
				arr[j][i] = arr[j][m-i-1];
				arr[j][m-i-1] = temp;
			}
			}
	}
	static int[][] com3 (int[][] arr, int n, int m) {
		int[][] temp = new int[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[j][n-1-i] = arr[i][j] ;
			}
		}
		return temp;
	}
	static int[][]  com4 (int[][] arr, int n, int m) {
		int[][] temp = new int[m][n];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				temp[m-1-j][i] = arr[i][j] ;
			}
		}
		return temp;
	}
	static int[][] com5 (int[][] arr, int n, int m) {
		int[][] temp = new int[n][m];
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				temp[i][j+m/2] = arr[i][j];
			}
		}
		for(int i=0;i<n/2;i++) {
			for(int j=m/2;j<m;j++) {
				temp[i+n/2][j] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=m/2;j<m;j++) {
				temp[i][j-m/2] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				temp[i-n/2][j] = arr[i][j];
			}
		}
		return temp;

	}
	static int[][] com6 (int[][] arr, int n, int m) {
		int[][] temp = new int[n][m];
		for(int i=0;i<n/2;i++) {
			for(int j=0;j<m/2;j++) {
				temp[i+n/2][j] = arr[i][j];
			}
		}
		for(int i=0;i<n/2;i++) {
			for(int j=m/2;j<m;j++) {
				temp[i][j-m/2] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=m/2;j<m;j++) {
				temp[i-n/2][j] = arr[i][j];
			}
		}
		for(int i=n/2;i<n;i++) {
			for(int j=0;j<m/2;j++) {
				temp[i][j+m/2] = arr[i][j];
			}
		}
		return temp;
	}

}
