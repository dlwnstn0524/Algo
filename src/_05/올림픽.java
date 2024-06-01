package _05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 올림픽 {

    static int N, K;
    static Nation[] nations;
    static class Nation{
        int num;
        int g;
        int s;
        int b;
        Nation(int num, int g, int s, int b){
            this.num = num;
            this.g = g;
            this.s = s;
            this.b = b;
        }

        @Override
        public String toString() {
            return num + " : " + g + " : " + s + " : " + b + "\n";
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int idx = -1;
        int answer = 1;
        nations = new Nation[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(num, g, s, b);
            if (num == K) idx = i;
        }
        for (int i = 0; i < N; i++) {
            if(idx == i) continue;
            else if(nations[i].g > nations[idx].g)answer++;
            else if(nations[i].s > nations[idx].s)answer++;
            else if(nations[i].b > nations[idx].b)answer++;
        }
        System.out.println(answer);
    }
}
