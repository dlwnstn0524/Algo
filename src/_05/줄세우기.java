package _05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 줄세우기 {

    static int P, T;
    static int[] arr;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        P = Integer.parseInt(br.readLine());
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            N = 0;
            arr = new int[20];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < arr.length; j++) {
                for (int k = j-1; k >= 0 ; k--) {
                    if(arr[k] > arr[j]) N++;
                }
            }
            System.out.println(T + " " + N);
        }
    }
}
