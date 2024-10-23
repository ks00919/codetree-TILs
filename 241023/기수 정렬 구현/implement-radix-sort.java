import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxLength = 0;
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            numbers.add(st.nextToken());
            maxLength = Math.max(maxLength, numbers.get(i).length());
        }

        for (int i = 0; i < maxLength; i++) {
            List<String>[] arrays = new ArrayList[10];

            for (int j = 0; j < 10; j++) {
                arrays[j] = new ArrayList<>();
            }

            for (int j = 0; j < n; j++) {
                String number = numbers.get(j);
                if (number.length() < i) {
                    arrays[0].add(number);
                    continue;
                }

                int pos = number.charAt(i) - '0';
                arrays[pos].add(number);
            }

            List<String> newNumbers = new ArrayList<>();
            for (int j = 0; j < 10; j++) {
                int size = arrays[j].size();
                for (int k = 0; k < size; k++) {
                    newNumbers.add(arrays[j].get(k));
                }
            }
            numbers = newNumbers;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(numbers.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}