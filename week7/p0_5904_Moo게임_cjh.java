package week7;

import java.io.*; 
import java.util.*; 

public class p0_5904_Moo게임_cjh {
	static int N; 
	static String t,m;
	static StringBuilder sb = new StringBuilder(); 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		N = Integer.parseInt(br.readLine()); 
		moo(0); 
	}
	static void moo(int cnt) {
		if(cnt == 0) {sb.append("moo"); t  = sb.toString(); m = "moo"; }
		else {
			sb.append(m).append(t); 
		}
		
		if(sb.length() >= N) {System.out.println(sb.charAt(N - 1)); return;} 
		else {
			 t  = sb.toString();
			 m += "o"; 
			moo(cnt+1); 
			return; 
		}
	}

}
