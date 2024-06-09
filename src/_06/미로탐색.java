package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탐색 {

    static int answer, N, M;
    static int[][] maps;
    static StringTokenizer st;
    static int[] di = new int[]{-1, 1, 0, 0};
    static int[] dj = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maps = new int[N][M];
        for (int i = 0; i < N; i++) {
            String temp = br.readLine();
            for (int j = 0; j < M; j++) {
                maps[i][j] = temp.charAt(j) - '0';
            }
        }
        answer = bfs();
        System.out.println(answer);
    }

    private static int bfs() {
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if(cur[0] == N-1 && cur[1] == M-1){
                return cur[2];
            }
            for (int i = 0; i < 4; i++) {
                int ni = cur[0] + di[i];
                int nj = cur[1] + dj[i];
                if(ni >= 0 && ni < N && nj >= 0 && nj < M && !visited[ni][nj] && maps[ni][nj] == 1){
                    visited[ni][nj] = true;
                    q.add(new int[]{ni,nj,cur[2]+1});
                }
            }
        }
        return -1;
    }

    private static void printMaps() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(maps[i]));
        }
    }
}
