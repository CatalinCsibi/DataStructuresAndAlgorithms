package binarytrees;

public class Main {

    public static void main(String[] args) {

        MyBinaryTree2 myBinaryTree2 = new MyBinaryTree2();

        myBinaryTree2.insert(8);
        myBinaryTree2.insert(5);
        myBinaryTree2.insert(11);
        myBinaryTree2.insert(9);
        myBinaryTree2.insert(14);
        myBinaryTree2.insert(4);
        myBinaryTree2.insert(7);
        myBinaryTree2.insert(6);
        myBinaryTree2.insert(3);
        myBinaryTree2.insert(1);

        System.out.println(myBinaryTree2.find(6));
        System.out.println(myBinaryTree2.find(7));
        System.out.println(myBinaryTree2.find(33));

        System.out.println();

        myBinaryTree2.traversePreOrder();

        System.out.println();

        myBinaryTree2.traverseInOrder();


        System.out.println();

        myBinaryTree2.traversePostOrder();

        System.out.println();

        System.out.println(myBinaryTree2.isBinarySearchTree());
        System.out.println();

        System.out.println(myBinaryTree2.height());
        System.out.println(myBinaryTree2.min());

        MyBinaryTree2 myBinaryTree21 = new MyBinaryTree2();

//               8
//            5     11
//           4 7   9 14
//          3  6
//         1

        // traversePreOrder -> 8 5 4 3 1 7 6 11 9 14
        // traverseInOrder -> 1 3 4 5 6 7 8 9 11 14
        // traversePostOrder -> 1 3 4 6 7 5 9 14 8
        myBinaryTree21.insert(7);
        myBinaryTree21.insert(5);
        myBinaryTree21.insert(9);
        myBinaryTree21.insert(8);
        myBinaryTree21.insert(10);
        myBinaryTree21.insert(4);
        myBinaryTree21.insert(6);
        myBinaryTree21.insert(3);
        myBinaryTree21.insert(1);

//        myBinaryTree21.mixUp();

        System.out.println(myBinaryTree2.equals(myBinaryTree21));
        System.out.println(isPalindrome2(12321));


    }

    private static int factorial(int n) {
        if (n == 0)
            return 1;

        return n * factorial(n - 1);
    }

    // 1221

    private static boolean isPalindrome(int number) {

        String a = Integer.toString(number);

        char[] chars = a.toCharArray();
        int lastIndex = chars.length - 1;

        for (int i = 0; i < chars.length / 2; i++) {

            if (chars[i] != chars[lastIndex--]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindrome2(int number) {
        int actualNumber = number;
        int newNumber = 0;

        while (number != 0) {
            int digit = number % 10;
            number = number / 10;
            if(number != 0) {
                newNumber = (newNumber + digit) * 10;
            } else {
                newNumber += digit;
                break;
            }
        }
        return actualNumber == newNumber;
    }
}
