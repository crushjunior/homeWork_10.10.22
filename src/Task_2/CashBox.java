package Task_2;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class CashBox {

    private static final List<String> NAMES = List.of(
            "Саша",
            "Маша",
            "Петя",
            "Ваня",
            "Катя",
            "Света",
            "Миша",
            "Олег",
            "Вася",
            "Кирилл"
    );
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        Queue<String> queue1 = new ArrayDeque<>(5);
        Queue<String> queue2 = new ArrayDeque<>(5);
        Queue<String> queue3 = new ArrayDeque<>(5);
        randomFill(queue1);
        randomFill(queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println();
        add("VOLODYA", queue1, queue2, queue3);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println("Третья очередь: " + queue3);
        System.out.println();
        remove(queue1,queue2);
        System.out.println("Первая очередь: " + queue1);
        System.out.println("Вторая очередь: " + queue2);
        System.out.println("Третья очередь: " + queue3);
    }

    private static void randomFill(Queue<String> queue) {
        int size = RANDOM.nextInt(6);
        for (int i = 0; i < size; i++) {
            queue.offer(NAMES.get(RANDOM.nextInt(NAMES.size())));
        }
    }

    private static void add (String name, Queue<String> queue1, Queue<String> queue2, Queue<String> queue3) {
        if (queue1.size() == 5 && queue2.size() == 5) {
            System.out.println("Галя выходи!");
            queue3.offer(name);
        }
        else if (queue1.size() < queue2.size()) {
            queue1.offer(name);
        } else {
            queue2.offer(name);
        }
    }

    private static void remove (Queue<String> queue1, Queue<String> queue2) {
        if (RANDOM.nextBoolean()) {
            queue1.poll();
        } else {
            queue2.poll();
        }
    }
}
