package arrays;

public class MyArray2 <E>{

    private Object[] items;
    private int count;

    public MyArray2() {
        this.items = new Object[5];
    }

    public MyArray2(int initialCapacity) {
        this.items = new Object[initialCapacity];
    }

    public void insert(E item) {
        if(count == items.length) {
            resizeArray();
        }
        items[count++] = item;
    }

    public void removeLast() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty.");
        }
        items[count--] = null;
    }

    public void removeFirst() {
        if(isEmpty()) {
            throw new IllegalStateException("Array is empty.");
        }

        for(int i = 0; i < count -1; i++) {
            items[i] = items[i+1];
        }
        items[count--] = null;
    }

    public void reverseArray() {
        if(isEmpty())
            throw new IllegalStateException("Array is empty");

        int last = count - 1;

        for(int i = 0; i < count / 2; i++) {
            Object firstItem = items[i];
            items[i] = items[last];
            items[last--] = firstItem;
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    private void resizeArray() {
        Object[] newArray = new Object[items.length* 2];
        for (int i = 0; i < count; i++) {
            newArray[i] = items[i];
        }
        items = newArray;
    }



    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < count; i++) {
            if (i == count - 1)
                stringBuilder.append(items[i]).append("]");
            else
                stringBuilder.append(items[i]).append(", ");
        }
        return stringBuilder.toString();
    }
}
