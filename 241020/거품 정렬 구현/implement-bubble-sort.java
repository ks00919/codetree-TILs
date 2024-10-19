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

        for (int i = 0; i < n-1; i++) {
            boolean sorted = true;
            for (int j = 0; j < n-1; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                    sorted = false;
                }
            }
            if (sorted)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<n; i++) {
            sb.append(numbers[i]).append(" ");
        }
        System.out.println(sb);
    }
}