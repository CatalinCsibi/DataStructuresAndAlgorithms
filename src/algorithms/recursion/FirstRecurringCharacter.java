package algorithms.recursion;

import java.util.HashSet;
import java.util.Set;

public class FirstRecurringCharacter {

    public static void main(String[] args) {
        int[] array = {2, 4, 7, 2, 8};
        System.out.println(firstRecurringCharacter(array));
        System.out.println(firstRecurringCharacter3(array));
    }

/*  Version	                    Time	Space
    firstRecurringCharacter  	O(n)	O(n)
    firstRecurringCharacter2	O(n²)	O(1)
*/

    private static int firstRecurringCharacter(int [] numbers) {
        Set<Integer> integers = new HashSet<>();
        for(int num : numbers) {
            if(!integers.add(num)) {
                return num;
            }
        }
        return -1;
    }

    private static int firstRecurringCharacter2(int [] numbers) {
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

    private static int firstRecurringCharacter3(int [] numbers) {
        for(int i = 0; i < numbers.length-1 ; i++) {
            for(int j = i+1; j < numbers.length; j++) {
                if(numbers[i] == numbers[j])
                    return numbers[i];
            }
        }
        return -1;
    }
}
