package arrays;


public class Main {

    public static void main(String[] args) {

        MyArray2 myArray2 = new MyArray2(5);

        myArray2.insert(1);
        myArray2.insert(2);
        myArray2.insert(3);
        myArray2.insert(4);
        myArray2.insert(5);
        myArray2.insert(6);
        myArray2.insert(7);

        System.out.println(myArray2);

        myArray2.removeFirst();

        myArray2.insert(1);
        myArray2.removeLast();
        myArray2.removeFirst();

        myArray2.reverseArray();

        myArray2.removeFirst();

        System.out.println(myArray2);

        System.out.println(myArray2.get(3));
        System.out.println(myArray2.indexOf(4));
        System.out.println(myArray2.max());
        System.out.println(myArray2.min());

        myArray2.removeAt(3);

        System.out.println(myArray2);



    }
}
