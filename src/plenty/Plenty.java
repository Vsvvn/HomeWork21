package plenty;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class Plenty {
    public static void separator2(int issue, int task) {
        System.out.println("Задание " + issue + ", " + "Задание " + task + ".");
    }
    public static void main(String[] args) {

        separator2(2, 2);

        Set<Integer> numbers = new HashSet<>();
        Random random = new Random();

        while (numbers.size() < 20) {
            numbers.add(random.nextInt(1000));

            Iterator<Integer> iterator = numbers.iterator();
            while (iterator.hasNext()) {
                Integer number = iterator.next();
                if ((number % 2) == 1) {
                    iterator.remove();
                }
            }
        }
        System.out.println(numbers);
    }

}
