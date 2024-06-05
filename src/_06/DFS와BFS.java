package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class DFS와BFS {

    static int N, M, V;
    static StringTokenizer st;
    static int[][] maps;
    static boolean[] v;
    static class Node{
        int r,c;
        Node(int r,int c){
            this.r=r;
            this.c=c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        maps = new int[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            maps[r-1][c-1] = 1;
            maps[c-1][r-1] = 1;
        }
        v = new boolean[N];
        dfs(V-1);
        System.out.println();
        v = new boolean[N];
        bfs(V-1);
        
    }

    private static void dfs(int i) {
        if(v[i]){
            return;
        }
        v[i] = true;
        System.out.print((i+1) + " ");
        for(int k = 0; k < N; k++) {
            if(maps[i][k] == 1){
               dfs(k);
            }
        }
    }

    private static void bfs(int i) {
        Queue<Integer> q = new ArrayDeque<>();
        v[i] = true;
        q.add(i);
        while(!q.isEmpty()) {
            int cur = q.poll();
            System.out.print((cur+1) + " ");
            for(int k = 0; k < N; k++) {
                if(maps[cur][k] == 1 && !v[k]){
                    v[k] = true;
                    q.add(k);
                }
            }
        }
    }

}
