package week4;

import java.io.*; 
import java.util.*; 

public class p6_1520_내리막길 {
    static int[][] dir; 
    static int[][] dp; 
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M; 
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dir = new int[M][N];
        dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            StringTokenizer st1 = new StringTokenizer(br.readLine());            
            for(int j = 0; j < N; j++) {
                dir[i][j] = Integer.parseInt(st1.nextToken());
                dp[i][j] = -1; // dp 배열을 -1로 초기화하여 방문하지 않았음을 표시
            }
        }
        System.out.println(downhill(0, 0));
    }
    
    static int downhill(int i, int j) {
        if(i == M - 1 && j == N - 1) return 1; // 목적지에 도달하면 1을 반환
        
        if(dp[i][j] != -1) return dp[i][j]; // 이미 방문한 곳은 계산된 값을 반환
        
        dp[i][j] = 0; // 방문했음을 표시하고 초기화
        
        for(int x = 0; x < 4; x++) {
            int nx = dx[x] + i; 
            int ny = dy[x] + j;
            if(0 <= nx && nx < M && 0 <= ny && ny < N) {
                if(dir[i][j] > dir[nx][ny]) {
                    dp[i][j] += downhill(nx, ny); // 가능한 모든 경로를 더해준다
                }
            }
        }
        return dp[i][j]; // 계산된 값을 반환
    }
}
