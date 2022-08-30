package baekjoon.gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2252_줄세우기 {
	public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] students = new int[N+1];
        ArrayList<Integer>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
        	str = in.readLine();
        	st = new StringTokenizer(str, " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            students[y]++;
        }
        
        
        Queue<Integer> queue = new LinkedList<Integer>();
        
        for(int i=1; i<=N; i++){
            if(students[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            System.out.println(queue.peek());
            int current = queue.poll();
            for(int i=0; i<list[current].size(); i++){
                int next = list[current].get(i);
                students[next]--;
                if(students[next]==0){
                    queue.add(next);
                }
            }
        }
        
    }
}