package week6;

import java.io.*; 
import java.util.*; 

public class p5_17289_222풀링 {
	static int N; 
	static int[][] pro; 
	static int[] order = new int[4]; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pro = new int[N][N]; 
		for(int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				pro[i][j] = Integer.parseInt(st.nextToken()); 
			}
		}
		pooling(N); 
	}
	static void pooling(int size) {
		if(size ==1) {System.out.println(pro[0][0]); return;}
		else {
			for(int i = 0; i < N; i+= 2) {
				for(int j = 0; j < N; j+=2) {
					order[0] = pro[i][j]; order[1] = pro[i][j+1]; 
					order[2] = pro[i+1][j]; order[3] = pro[i+1][j+1]; 
					Arrays.sort(order);
					pro[i / 2][j / 2] = order[2]; 
				}
			}
			pooling(size / 2); return; 
		}
		
	}
}
