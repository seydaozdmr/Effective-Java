package com.effectivejava.B_MethodsCommontoAllObjects.OverrideCloneJudiciously;

public class HashTable implements Cloneable{
    private Entry [] buckets;

    private static class Entry {
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * Suppose you merely clone the bucket array recursively, as we did for Stack:
     * // Broken clone method - results in shared mutable state!
     * @return HashTable
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        HashTable hashTable= (HashTable) super.clone();
        hashTable.buckets=buckets.clone();
        return hashTable;
    }
}
