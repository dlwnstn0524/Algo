package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질 {

    static int N, K;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[100001];
        map[N] = 1;
        bfs();
        System.out.println(map[K] -1);
    }

    private static void bfs() {
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == K){
                return;
            }
            if (cur - 1 >= 0 && cur - 1 < map.length && map[cur - 1] == 0) {
                map[cur - 1] = map[cur] + 1;
                q.offer(cur - 1);
            }
            if (cur + 1 >= 0 && cur + 1 < map.length && map[cur + 1] == 0) {
                map[cur + 1] = map[cur] + 1;
                q.offer(cur + 1);
            }
            if (cur*2 >= 0 && cur*2 < map.length && map[cur*2] == 0) {
                map[cur*2] = map[cur] + 1;
                q.offer(cur*2);
            }
        }
    }
}
