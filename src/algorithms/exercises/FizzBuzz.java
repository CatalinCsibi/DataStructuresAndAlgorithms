package algorithms.exercises;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {

/*    Given an integer n, return a string array answer (1-indexed) where:

    answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
    answer[i] == "Fizz" if i is divisible by 3.
    answer[i] == "Buzz" if i is divisible by 5.
    answer[i] == i (as a string) if none of the above conditions are true.*/

/*    Example 1:

    Input: n = 3
    Output: ["1","2","Fizz"]
    Example 2:

    Input: n = 5
    Output: ["1","2","Fizz","4","Buzz"]
    Example 3:

    Input: n = 15
    Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]*/

    public static void main(String[] args) {
        System.out.println(fizzBuzz(5));
        System.out.println(List.of(getFizzBuzz(5)));
    }

    public static List<String> fizzBuzz(int n) {
        List<String> answer = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                answer.add("FizzBuzz");
            } else if (i % 3 == 0) {
                answer.add("Fizz");
            } else if (i % 5 == 0) {
                answer.add("Buzz");
            } else {
                answer.add(Integer.toString(i));
            }
        }

        return answer;
    }

    private static String[] getFizzBuzz(int n) {
        String[] array = new String[n];

        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                array[i - 1] = "FizzBuzz";
            } else if (i % 3 == 0) {
                array[i - 1] = "Fizz";
            } else if (i % 5 == 0) {
                array[i - 1] = "Buzz";
            } else {
                array[i - 1] = Integer.toString(i);
            }
        }
        return array;
    }
}
