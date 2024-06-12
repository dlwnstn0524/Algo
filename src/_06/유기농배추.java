package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 유기농배추 {

    static int T, M, N, K, answer;
    static int[][] maps;
    static boolean[][] visitied;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            answer = 0;

            maps = new int[M][N];
            visitied = new boolean[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                maps[s][e] = 1;
            }

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (maps[i][j] == 1 && !visitied[i][j]) {
                        bfs(i, j);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void bfs(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        visitied[i][j] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + di[k];
                int ny = cur[1] + dj[k];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && !visitied[nx][ny] && maps[nx][ny] == 1) {
                    visitied[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }
}
