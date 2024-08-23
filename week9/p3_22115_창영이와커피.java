package week9;

import java.io.*; 
import java.util.*; 

public class p3_22115_창영이와커피 {
    static int N,K,ans;
    static int[][] dp;
    static int cant=1001;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        String[] C=br.readLine().split(" ");
        int [] coffee=new int[C.length];
        for (int i = 0; i < C.length; i++) {
            coffee[i]=Integer.parseInt(C[i]);
        }
        dp=new int[K+1][N+1];
        for (int i = 0; i < N+1; i++) {
            dp[0][i]=0;
        }
        for (int i = 1; i <K+1; i++) {
            Arrays.fill(dp[i], cant);
        }
        for (int i = 1; i <K+1; i++) {
            for (int j = 1; j <N+1; j++) {
                if (i-coffee[j-1]<0) dp[i][j]=dp[i][j-1];
                else if (!(dp[i - coffee[j-1]][j - 1] == cant && dp[i][j - 1] == cant)) {
                    dp[i][j]=Math.min(dp[i][j-1],dp[i-coffee[j-1]][j-1]+1);
                }
            }
        }
        ans=dp[K][N];
        if (ans == cant) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }


    }
}
