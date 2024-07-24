package _07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * BOJ
 * 1927
 * Silver 2
 */
public class _최소힙 {

    static int answer;
    static int N, x;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0){
                if (pq.size() == 0){
                    System.out.println("0");
                } else {
                    System.out.println(pq.poll());
                }
            } else if (x != 0) {
                pq.add(x);
            }
        }

    }
}
