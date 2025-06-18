package arrays;

public class MyArray2 <E>{


    private Object[] items;
    int size;

    public MyArray2() {
        this.items = new Object[10];
    }

    public MyArray2(int initialCapacity) {
        this.items = new Object[initialCapacity];
    }

    public void insert(E item) {
        if(isFull()) {
            resizeArray();
        }
        items[size++] = item;
    }

    public void removeFirst() {
        if(isEmpty())
            throw new IllegalStateException("Array is empty. Cannot remove first item.");

        for(int i = 0; i < items.length-1; i++) {
            items[i] = items[i+1];
        }
        size--;
    }

    public void removeLast() {
        if(isEmpty())
            throw new IllegalStateException("Array is empty. Cannot remove last item.");

        items[--size] = null;
    }

    public void removeAt(int index) {
        if(isEmpty())
            throw new IllegalStateException("Array is empty, Cannot remove item ar index " + index);
        for(int i = index; i < items.length-1; i++) {
            items[index++] = items[i+1];
        }
        size--;
    }

    public int indexOf(Object item) {
        for(int i = 0; i < size; i++) {
            if(items[i] == item)
                return i;
        }
        return -1;
    }

    public void reverseArray() {
        Object[] newItems = new Object[items.length];
        int index = 0;
        for(int i = size-1; i >= 0; i--) {
            newItems[index++] = items[i];
        }
        items= newItems;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == items.length;
    }

    private void resizeArray() {
        Object[] newItems = new Object[items.length * 2];
        for(int i = 0; i < items.length; i++){
            newItems[i] = items[i];
        }
        items = newItems;
    }



















    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1)
                stringBuilder.append(items[i]).append("]");
            else
                stringBuilder.append(items[i]).append(", ");
        }
        return stringBuilder.toString();
    }
}
