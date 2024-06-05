package _06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백만장자프로젝트 {

    static int T, answer, N;
    static int tmp;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            tmp = arr[N-1];
            calculate();

            System.out.println("#" + t + " " + answer);
        }
    }
    private static void calculate() {
        for (int i = N-1; i >= 0; i--) {
            if(tmp > arr[i]){
                answer += tmp - arr[i];
            } else {
                tmp = arr[i];
            }
        }
    }
}
