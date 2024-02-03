package queues;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        Queue<String>  queue = new LinkedList<>();
        queue.offer("Karen");
        queue.offer("Halil");
        queue.offer("Steve");
        queue.offer("Harold");
        System.out.println(queue);
        System.out.println(queue.isEmpty());
        System.out.println(queue.peek());
        queue.poll();
        System.out.println(queue.contains("Halil"));

    }
}
