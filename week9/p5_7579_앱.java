package week9;

import java.io.*; 
import java.util.*; 

public class p5_7579_앱 {
    static int N, M;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken()); // 앱의 개수
        M = Integer.parseInt(st1.nextToken()); // 확보해야 하는 메모리
        int[] memory = new int[N];
        int[] cost = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        StringTokenizer st3 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            memory[i] = Integer.parseInt(st2.nextToken()); // 메모리 크기
            cost[i] = Integer.parseInt(st3.nextToken()); // 비용
        }

        int sumCost = Arrays.stream(cost).sum();
        dp = new int[sumCost + 1];
        Arrays.fill(dp, 0); // 메모리 확보를 위한 최소 비용을 저장하는 배열

        for (int i = 0; i < N; i++) {
            for (int j = sumCost; j >= cost[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - cost[i]] + memory[i]);
            }
        }

        int result = 0;
        for (int i = 0; i <= sumCost; i++) {
            if (dp[i] >= M) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}