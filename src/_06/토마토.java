package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 토마토 {

    static int answer, N, M;
    static int[][] maps;
    static StringTokenizer st;
    static boolean[][] v;
    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        maps = new int[N][M];
        v = new boolean[N][M];
        answer = -1;
        q = new ArrayDeque<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(st.nextToken());
                if (maps[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
        bfs();
        System.out.println(answer);


    }

    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, -1, 1};

    private static void bfs() {
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int i = 0; i < 4; i++) {
                int x = p[0] + di[i];
                int y = p[1] + dj[i];
                if (x>= 0 && y>= 0 && x<N && y<M && maps[x][y] == 0) {
                    maps[x][y] = maps[p[0]][p[1]] + 1;
                    q.add(new int[]{x, y});
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (maps[i][j] == 0) {
                    answer = -1;
                    return;
                }
                answer = Math.max(answer, maps[i][j]-1);
            }
        }
    }
}
