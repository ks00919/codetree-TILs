import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static int n;
    private static int m;

    private static List<Character> breads = new ArrayList<>();
    private static int pointer;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pointer = n;
        size = n;

        String input = br.readLine();
        for (int i = 0; i < n; i++) {
            breads.add(input.charAt(i));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "L":
                    prev();
                    break;
                case "R":
                    next();
                    break;
                case "D":
                    delete();
                    break;
                case "P":
                    add(st.nextToken().charAt(0));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(breads.get(i));
        }
        System.out.println(sb);
    }

    public static void prev() {
        if (pointer == 0)
            return;
        pointer--;
    }

    public static void next() {
        if (pointer == size)
            return;
        pointer++;
    }

    public static void delete() {
        if (pointer == size)
            return;
        size--;
        breads.remove(pointer);
    }

    public static void add(char c) {
        breads.add(pointer, c);
        size++;
        pointer++;
    }

}