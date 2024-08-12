package week7;


import java.io.*; 
import java.util.*; 

public class p3_2660_회장뽑기_cjh {
    static final int INF = 100;  // 충분히 큰 값
    static int N;
    static int[][] dist;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();  // 회원 수
        dist = new int[N + 1][N + 1];

        // 초기화: 자기 자신에게 가는 거리는 0, 다른 경로는 INF로 설정
        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // 친구 관계 입력
        while (true) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            if (a == -1 && b == -1) break;

            dist[a][b] = 1;
            dist[b][a] = 1;
        }
  
        // 플로이드-워셜 알고리즘
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 회장 후보 찾기
        int minScore = INF;
        List<Integer> candidates = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            int maxDist = 0;
            for (int j = 1; j <= N; j++) {
                if (dist[i][j] != INF) {
                    maxDist = Math.max(maxDist, dist[i][j]);
                }
            }
            if (maxDist < minScore) {
                minScore = maxDist;
                candidates.clear();
                candidates.add(i);
            } else if (maxDist == minScore) {
                candidates.add(i);
            }
        }

        // 결과 출력
        System.out.println(minScore + " " + candidates.size());
        for (int candidate : candidates) {
            System.out.print(candidate + " ");
        }
    }
}