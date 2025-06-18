package arrays;

public class MyArray2 {

    public int length = 0;

    private int index = 0;

    private int[] numbers;

    public MyArray2() {
        this.numbers = new int [10];
        this.length = 10;
    }
    public MyArray2(int length) {
        this.numbers = new int [length];
        this.length = length;
    }

    public void insert(int number) {
        if(index == length) {
            int[] newArray = new int[numbers.length * 2];
            System.arraycopy(numbers, 0, newArray, 0, numbers.length);
            numbers = newArray;
            length = numbers.length;
        }

        numbers[index] = number;
        index++;
    }

    public void removeAt(int index) {
        if(index < this.index && index >= 0) {
            int number = numbers[index];
            int[] newArray = new int[numbers.length - 1];
            int newArrayIndex = 0;
            for (int i = 0; i < this.index; i++) {
                if(numbers[i] == number) {
                    continue;
                }
                newArray[newArrayIndex] = numbers[i];
                newArrayIndex++;
            }
            this.index--;
            this.length--;
            numbers = newArray;
        } else {
            throw new IndexOutOfBoundsException(index);
        }
    }

    public int indexOf(int number) {
        for(int i = 0; i < index; i++ ){
            if (numbers[i] == number) {
                return i;
            }
        }
        return -1;
    }

    public int getMaxNumber() {
        if(index > 0) {
            int max = numbers[0];

            for (int number : numbers) {
                if(number > max) {
                    max = number;
                }
            }
            return max;
        }
        System.out.println("Array is empty. Cannot get max number.");
        return -1;

    }

    public void printArray() {
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
    }

    public void reverseArray() {
        if(index > 0) {
            int [] newNumbers = new int[numbers.length];
            int lastIndex = index - 1;

            for(int i = 0; i < index; i++) {
                newNumbers[i] = numbers[lastIndex];
                lastIndex--;
            }
            numbers = newNumbers;
        } else {
            System.out.println("Array is empty. Cannot reverse.");
        }
    }

    public void intersect(MyArray2 myArray) {
        for(int i = 0; i < myArray.index; i++) {
            for(int j = 0; j < index; j++) {
                if(myArray.numbers[i] == numbers[j]) {
                    System.out.print(myArray.numbers[i] + " ");
                }
            }
        }
        System.out.println();
    }

}

