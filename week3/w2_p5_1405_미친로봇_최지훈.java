package week3;

import java.io.*; 
import java.util.*; 


public class w2_p5_1405_미친로봇_최지훈 {
	static int N; 
	static double ans; 
	static double[]dir = new double[4]; 
	static boolean[] v = new boolean[4]; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < 4; i++) dir[i] = Integer.parseInt(st.nextToken()) / 100.00;
		for(double j : dir) System.out.println(dir);
		robot(0);
	}
	
	static void robot(int cnt) {
		if(cnt == 0 && cnt  == 1) {ans = 1.0; cnt+=1; robot(cnt); return; }
		if(cnt == N) {System.out.println(ans); return; }
		return;
	}

}
 // 