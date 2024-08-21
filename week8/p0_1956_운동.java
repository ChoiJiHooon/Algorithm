package week8;

import java.io.*; 
import java.util.*; 

public class p0_1956_운동 {
	// 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		int V= Integer.parseInt(st1.nextToken());
		int E= Integer.parseInt(st1.nextToken());
		int[][] pro = new int[E+1][E+1]; 
		for(int i = 0; i < E ; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine()); 
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			int c = Integer.parseInt(st2.nextToken());
			pro[a][b] = c; 
		}
		
	}

}
