import java.util.*;
import java.io.*;

public class Main {

    private static int[] value = new int[10_001];
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            switch(order) {
                case "push_back":
                    int a = Integer.parseInt(st.nextToken());
                    pushBack(a);
                    break;
                case "pop_back":
                    popBack();
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "get":
                    int k = Integer.parseInt(st.nextToken()) - 1;
                    sb.append(get(k)).append("\n");
            }
        }

        System.out.println(sb);
    }

    public static void pushBack(int a){
        value[size++] = a;
    }

    public static void popBack() {
        size--;
    }

    public static int size() {
        return size;
    }

    public static int get(int k) {
        return value[k];
    }
}