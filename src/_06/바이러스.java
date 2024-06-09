package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 바이러스 {

    static int answer, N, M;
    static int[][] maps;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        maps = new int[N+1][N+1];
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            maps[a][b] = 1;
            maps[b][a] = 1;
        }

        bfs();
    }

    private static void bfs() {
        answer = 0;
        v = new boolean[N+1];
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        v[1] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < N+1; i++) {
                if (maps[now][i] == 1 && !v[i]) {
                    v[i] = true;
                    q.add(i);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
