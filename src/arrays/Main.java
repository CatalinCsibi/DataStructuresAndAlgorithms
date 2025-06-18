package arrays;


public class Main {

    public static void main(String[] args) {

        MyArray2<Integer> myArray2 = new MyArray2<>(5);

        myArray2.insert(1);
        myArray2.insert(2);
        myArray2.insert(3);
        myArray2.insert(4);
        myArray2.insert(5);
        myArray2.insert(6);
        myArray2.insert(7);
        myArray2.insert(8);
        myArray2.insert(9);
        myArray2.insert(10);
        myArray2.insert(11);

        myArray2.removeLast();
        myArray2.removeFirst();
        myArray2.removeFirst();

        System.out.println(myArray2);

        myArray2.reverseArray();

//        myArray2.removeFirst();
//        myArray2.removeLast();
//        myArray2.removeLast();


        System.out.println(myArray2);



    }
}
