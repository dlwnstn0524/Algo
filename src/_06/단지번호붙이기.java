package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 단지번호붙이기 {

    static int N;
    static int[][] maps;
    static boolean[][] v;
    static List<Integer> cand;
    static int[] di = {-1, 1, 0, 0};
    static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        maps = new int[N][N];
        v = new boolean[N][N];
        cand = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String st = br.readLine();
            for (int j = 0; j < N; j++) {
                maps[i][j] = st.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (maps[i][j] == 1 && !v[i][j]) {
                    cand.add(bfs(i, j));
                }
            }
        }
        System.out.println(cand.size());
        Collections.sort(cand);
        for(int i : cand){
            System.out.println(i);
        }
    }

    private static int bfs(int i, int j) {
        v[i][j] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i, j});
        int cnt = 1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = cur[0] + di[k];
                int ny = cur[1] + dj[k];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (maps[nx][ny] == 1 && !v[nx][ny]) {
                        v[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static void printMaps() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(maps[i][j] + " ");
            }
            System.out.println();
        }
    }
}
