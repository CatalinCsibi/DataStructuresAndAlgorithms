package hashtables;

import java.util.LinkedList;

public class MyHashTable {

    private LinkedList<Entry>[] entries = new LinkedList[5];

    private class Entry {

        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

        public String toString() {
            return  key + "=" + value;
        }
    }

    public void put(int key, String value) {
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).add(new Entry(key, value));

    }

    public String get(int key) {
        var entry = getEntry(key);
        if(entry != null)
            return entry.value;

        return null;
    }

    public void remove(int key) {
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket) {
                if (entry.key == key)
                    return entry;
            }
        }
        return null;
    }


    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private LinkedList<Entry> getOrCreateBucket(int key) {
        var index = hash(key);
        var bucket = entries[index];

        if(bucket == null)
            return entries[index] = new LinkedList<>();

        return bucket;
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for(LinkedList<Entry> linkedList : entries) {
            if(linkedList != null) {
                for(Entry entry : linkedList) {
                    stringBuilder.append(entry.toString()).append(", ");
                }
            }
        }
        String s = stringBuilder.toString();
        s = s.substring(0, s.length()-2) + "}";
        return s;
    }
}
