package week3;

import java.io.*; 
import java.util.*; 

public class p2_2293_동전1_최지훈 {
	static int[] pro; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		pro = new int[N];
		for(int i = 0; i < N; i++) {
			pro[i] = Integer.parseInt(br.readLine());
		}
		coin(); 
	}
	static void coin() {
		
	}

}
