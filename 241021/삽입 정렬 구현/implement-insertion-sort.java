import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] numbers = new int[n];
        for (int i = 0; i<n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i<n; i++) {
            int j = i - 1;
            int key = numbers[i];

            while(j >= 0 && numbers[j] > key) {
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = key;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb);
    }
}