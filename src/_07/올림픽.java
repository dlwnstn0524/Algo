package _07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Function;

/**
 * BOJ
 * 8979
 * Silver 5
 */
public class 올림픽 {

    static int N, K, answer;
    static StringTokenizer st;
    static Nation[] nations;

    static class Nation implements Comparable<Nation> {
        int idx, gold, silver, bronze;
        public Nation(int idx, int gold, int silver, int bronze){
            this.idx = idx;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public String toString() {
            return "[" + idx + ", " + gold + ", " + silver + ", " + bronze + "]";
        }
        @Override
        public int compareTo(Nation o) {
            return -1;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        nations = new Nation[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(idx, gold, silver, bronze);
        }
        Arrays.sort(nations);
        for(Nation n : nations){
            System.out.println(n);
        }

    }
}
