package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 연결요소의개수 {

    static int answer, N, M;
    static int[][] maps;
    static boolean[] v;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N+1][N+1];
        v = new boolean[N+1];
        answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            maps[u][v] = 1;
            maps[v][u] = 1;
        }

        while(true){
            if (check()){
                break;
            } else {
                for (int i = 1; i <= N; i++) {
                    if(!v[i]){
                        bfs(i);
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }

    private static boolean check() {
        for (int i = 1; i <= N; i++) {
            if (!v[i]) return false;
        }
        return true;
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        v[i] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int j = 1; j <= N; j++) {
                if (maps[cur][j] == 1 && !v[j]) {
                    v[j] = true;
                    q.add(j);
                }
            }
        }
    }
}
