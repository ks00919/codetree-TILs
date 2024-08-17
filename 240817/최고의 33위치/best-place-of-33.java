import java.util.*;
import java.io.*;

public class Main {

    private static int n;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, count(i, j));
            }
        }
        
        System.out.println(max);
    }

    public static int count(int x, int y) {
        int endX = x + 3;
        int endY = y + 3;  

        if (endX > n || endY > n)
            return -1;

        int sum = 0;
        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                sum += map[i][j];
            }
        }
        return sum;
    }
}