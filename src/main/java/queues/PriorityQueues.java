package queues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;


public class PriorityQueues {

    public static void main(String[] args) {
        Queue<Double>  queue = new PriorityQueue<>(Collections.reverseOrder());
        queue.offer(3.0);
        queue.offer(2.5);
        queue.offer(4.0);
        queue.offer(1.5);
        queue.offer(2.0);

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }



    }

}
