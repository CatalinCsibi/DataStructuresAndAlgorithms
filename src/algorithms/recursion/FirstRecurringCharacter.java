package algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 2, 8};
        System.out.println(firstRecurringCharacter(array));
    }

    private static int firstRecurringCharacter(int [] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (set.contains(number)) {
                return number;
            } else {
                set.add(number);
            }
        }
        return -1;
    }
}
