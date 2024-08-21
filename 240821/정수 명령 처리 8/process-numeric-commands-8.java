import java.util.*;
import java.io.*;

public class Main {
    private static class Node {
        Node prev;
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node head;
    private static Node tail;
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String order = st.nextToken();

            switch(order) {
                case "push_front":
                    int a = Integer.parseInt(st.nextToken());
                    pushFront(a);
                    break;
                case "push_back":
                    a = Integer.parseInt(st.nextToken());
                    pushBack(a);
                    break;
                case "pop_front":
                    sb.append(popFront()).append("\n");
                    break;
                case "pop_back":
                    sb.append(popBack()).append("\n");
                    break;
                case "size":
                    sb.append(size()).append("\n");
                    break;
                case "empty":
                    sb.append(empty()).append("\n");
                    break;
                case "front":
                    sb.append(front()).append("\n");
                    break;
                case "back":
                    sb.append(back()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

    public static void pushFront(int a) {
        Node newNode = new Node(a);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public static void pushBack(int a) {
        Node newNode = new Node(a);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }
    
    public static int popFront() {
        size--;
        int result = head.value;
        head = head.next;
        return result;
    }

    public static int popBack() {
        size--;
        int result = tail.value;
        tail = tail.prev;
        return result;
    }

    public static int size() {
        return size;
    }

    public static int empty() {
        return size == 0? 1: 0;
    }

    public static int front() {
        return head.value;
    }

    public static int back() {
        return tail.value;
    }
}