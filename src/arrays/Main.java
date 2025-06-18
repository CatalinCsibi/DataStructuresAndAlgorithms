package arrays;


public class Main {

    public static void main(String[] args) {

        MyArray<Integer> myArray = new MyArray<>(5);

        myArray.insert(1);
        myArray.insert(2);
        myArray.insert(3);
        myArray.insert(4);
        myArray.insert(5);
        myArray.insert(6);
        myArray.insert(7);
        myArray.insert(8);
        myArray.insert(9);
        myArray.insert(10);
        myArray.insert(11);

        myArray.removeLast();
        myArray.removeFirst();
        myArray.removeFirst();

        System.out.println(myArray.indexOf(5));
        myArray.removeAt(2);
        System.out.println(myArray);

        myArray.reverseArray();

//        myArray.removeFirst();
//        myArray.removeLast();
//        myArray.removeLast();


        System.out.println(myArray);



    }
}
