package hashtables;


import java.util.LinkedList;

public class MyHashTable2<K, V> {

    private LinkedList<Entry>[] entries = new LinkedList[10];

    private class Entry {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }

    }

    public void put(K key, V value) {
        var entry = getEntry(key);
        if(entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).add(new Entry(key, value));
    }

    public void remove(K key) {
        var entry = getEntry(key);
        if(entry == null)
            throw new IllegalStateException();

        getBucket(key).remove(entry);
    }

    public V get(K key) {
        var entry = getEntry(key);

        if(entry != null)
            return entry.value;

        return null;
    }

    private LinkedList<Entry> getOrCreateBucket(K key) {
        var index = hash(key);
        var bucket = entries[index];

        if(bucket == null)
            return entries[index] = new LinkedList<>();

        return bucket;
    }

    private Entry getEntry(K key) {
        var bucket = getBucket(key);
        if(bucket != null) {
            for(var entry : bucket) {
                if(entry.key == key)
                    return entry;
            }
        }
        return null;
    }

    private LinkedList<Entry> getBucket(K key) {
        return entries[hash(key)];
    }

    private int hash(K key) {
        return key.hashCode() % entries.length;
    }
















    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        for (LinkedList<Entry> linkedList : entries) {
            if (linkedList != null) {
                for (Entry entry : linkedList) {
                    stringBuilder.append(entry.toString()).append(", ");
                }
            }
        }
        String s = stringBuilder.toString();
        s = s.substring(0, s.length() - 2) + "}";
        return s;
    }
}
