package arrays;

public class MyArray2 <E>{

    private Object[] items;
    private int count;

    public MyArray2() {
        items = new Object[5];
    }

    public MyArray2(int initialCapacity) {
        items = new Object[initialCapacity];
    }

    public void insert(E value) {
        if(isFull())
            resizeArray();
        
        items[count++] = value;
    }
    
    public void removeFirst() {
        if(isEmpty())
            throw new IllegalStateException();
        
        for(int i = 0; i < count-1; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }
    
    public void removeLast() {
        if(isEmpty())
            throw new IllegalStateException();
        
        items[--count] = 0;
    }
    
    public boolean isEmpty() {
        return count == 0;
    }
    
    public void reverseArray() {
        Object[] reversedArray = new Object[items.length];
        
        int index = 0;
        
        for(int i = count - 1; i >=0; i--) {
            reversedArray[index++] = items[i];
        }
        items = reversedArray;
    }

    public void reverseArray2() {
        if(isEmpty())
            throw new IllegalStateException();

        int last = count - 1;

        for(int i = 0; i < count / 2; i++) {
            Object firstItem = items[i];
            items[i] = items[last];
            items[last--] = firstItem;
        }
    }
    
    public Object get(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        return items[index];
    }

    public int indexOf(E value) {
        if(isEmpty())
            return -1;
        
        for(int i = 0; i < count; i++) {
            if(items[i] == value)
                return i;
        }
        return -1;
    }
    
    public void removeAt(int index) {
        if(isOutOfBounds(index))
            throw new IndexOutOfBoundsException();

        for(int i = index; i < count-1; i++) {
            items[i] = items[i+1];
        }
    }

    private boolean isOutOfBounds(int index) {
        return index < 0 || index > count - 1;
    }
    
    private void resizeArray() {
        Object[] newItems = new Object[items.length * 2];
        
        for(int i = 0; i < count; i++) {
            newItems[i] = items[i];
        }
        items = newItems;
    }
    
    private boolean isFull() {
        return count == items.length;
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
