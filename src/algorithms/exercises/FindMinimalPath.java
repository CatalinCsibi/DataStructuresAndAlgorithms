package algorithms.exercises;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FindMinimalPath {


    public static void main(String[] args) {
        System.out.println(findMinimalPath("/foo/bar/../loo/../.."));
        System.out.println(findMinimalPath("/foo/../.."));
        System.out.println(findMinimalPath("/foo/./bar///.."));
        System.out.println(findMinimalPath("/foo///./loo/../bar/."));
        System.out.println();
        System.out.println(findMinimalPath2("/foo/bar/../loo/../.."));
        System.out.println(findMinimalPath2("/foo/../.."));
        System.out.println(findMinimalPath2("/foo/./bar///.."));
        System.out.println(findMinimalPath2("/foo///./loo/../bar/."));
    }


    private static String findMinimalPath(String path) {
        Deque<String> deque = new ArrayDeque<>();

        for (String part : path.split("/")) {

            if (part.isEmpty() || part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(part);
            }
        }

        return "/" + String.join("/", deque);
    }


    private static String findMinimalPath2(String s) {
        String[] strings = s.split("/");

        List<String> stringList = new ArrayList<>();

        for(String str : strings) {
            if(str.isEmpty() || str.equals("."))
                continue;

            if(!str.equals("..")) {
                stringList.add(str);
            } else if(!stringList.isEmpty()) {
                stringList.removeLast();
            }
        }

        return "/" + String.join("/", stringList);
    }

}
