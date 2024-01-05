package stacks;

public class ResizeableStack <E> {

    private Object[] items = new Object[5];
    int count;

    public void push(E item) {
        if(isFull())
            resizeStack();

        items[count++] = item;
    }

    public Object pop(){
        if(isEmpty())
            throw new IllegalStateException();

        return items[--count];
    }

    public Object peek() {
        if(isEmpty())
            throw new IllegalStateException();

        return items[count - 1];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    private void resizeStack() {
        Object[] newItems = new Object[items.length * 2];

        for(int i =0; i< count; i++) {
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
            stringBuilder.append(items[i]).append(", ");
        }
        String itemsAsString = stringBuilder.toString();
        return itemsAsString.substring(0, itemsAsString.length() - 2) + "]";
    }
}
