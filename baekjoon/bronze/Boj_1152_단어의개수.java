package baekjoon.bronze;

import java.util.Scanner;

public class Boj_1152_단어의개수 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		boolean flag = true;
		char[] words = line.toCharArray();
		int cnt = 0;
		for(int i=0; i<words.length;i++) {
			if(words[i]!=' ' && flag) {
				cnt++;
				flag = false;
			}
			else if (words[i]==' ') {
				flag = true;
			}

		}
		
		System.out.println(cnt);
		sc.close();
	}

}
