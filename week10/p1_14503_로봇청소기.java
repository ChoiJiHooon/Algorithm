package cjh.week10;

import java.io.*; 
import java.util.*; 

public class p1_14503_로봇청소기 {
	static int N,M , r, c, d , ans = 0; 
	static int[][] pro; 
	static int [] di = {-1,0,1,0}; 
	static int [] dj = {0,1,0,-1}; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st1 = new StringTokenizer(br.readLine()); 
		N = Integer.parseInt(st1.nextToken()); 
		M = Integer.parseInt(st1.nextToken());
		pro = new int[N][M];
		StringTokenizer st2 = new StringTokenizer(br.readLine()); 
		r = Integer.parseInt(st2.nextToken()); 
		c = Integer.parseInt(st2.nextToken()); 
		d = Integer.parseInt(st2.nextToken()); 
		for(int i = 0; i < N; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine()); 
			for(int j = 0; j < M; j++) {
				pro[i][j] = Integer.parseInt(st3.nextToken()); 
			}
		}
		dp(r,c,d); 
		System.out.println(ans);
	}
	public static void dp(int R, int C, int D) {
	    if (pro[R][C] == 0) {
	        ans += 1;
	        pro[R][C] = 2; 
	    }
	    
	    int td = D;
	    boolean cleaned = false; // 청소 가능 여부
	    
	    for (int i = 0; i < 4; i++) {
	        td = (td + 3) % 4; // 왼쪽 방향으로 회전
	        int newR = R + di[td];
	        int newC = C + dj[td];
	        
	        if (newR >= 0 && newR < N && newC >= 0 && newC < M && pro[newR][newC] == 0) {
	            dp(newR, newC, td);
	            return; 
	        }
	    }
	 
	        int backD = (D + 2) % 4; // 후진 방향
	        int backR = R + di[backD];
	        int backC = C + dj[backD];
	        
	        if (backR >= 0 && backR < N && backC >= 0 && backC < M && pro[backR][backC] != 1) {
	            dp(backR, backC, D); // 후진하면서 같은 방향 유지
	        }
	    
	}


}

