package week8;

import java.io.*; 
import java.util.*; 
 /**/
public class p1_10282_해킹_cjh {
	static int n,d,c,a,b,s; 
	static List<int[]>[] g ; 
	static int[] dis; 
	static boolean[] v; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); 
		for(int i = 0; i < T; i++) {
			int av = 0,am = 0; 
			StringTokenizer st1 = new StringTokenizer(br.readLine()); 
			n = Integer.parseInt(st1.nextToken()); 
			d = Integer.parseInt(st1.nextToken()); 
			c = Integer.parseInt(st1.nextToken());
			g = new List[n+1]; 
			dis = new int[n+1]; 
			v = new boolean[n+1]; 
			for(int j = 1; j <= n; j++) {g[j] = new ArrayList<>(); dis[j] = Integer.MAX_VALUE; }
			dis[c] = 0; 
			for(int j = 0; j < d; j++) {
				StringTokenizer st2 = new StringTokenizer(br.readLine()); 
				a = Integer.parseInt(st2.nextToken()); 
				b = Integer.parseInt(st2.nextToken()); 
				s = Integer.parseInt(st2.nextToken());
				g[b].add(new int[] {a,s}); 
			}
			PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
			pq.offer(new int[] {c,0});
			while(!pq.isEmpty()) {
				int[] t = pq.poll(); 
				if(v[t[0]]) continue; 
				v[t[0]] = true; 
				av +=1; 
				for(int[] j : g[t[0]]) {
					if (!v[j[0]] &&  dis[j[0]] > dis[t[0]] + j[1]) {
					    dis[j[0]] = dis[t[0]] + j[1];
					    pq.add(new int[]{j[0], dis[j[0]]});
					}

				}
			}
			for(int j = 1; j < n+1 ; j++) {
				if(dis[j] != Integer.MAX_VALUE) {
					 am = Math.max(am, dis[j]);
				}
			}
			System.out.println(av + " " + am); 
			}
	}
}
