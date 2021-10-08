package com.effectivejava.B_MethodsCommontoAllObjects.OverrideCloneJudiciously;

public class HashTableSolution implements Cloneable{
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

        Entry deepCopy(){
            //recursively copy Entry objects
            return new Entry(key,value, next==null?null :next.deepCopy());
        }
        //çok uzun bağlı listelerde recursion yerine loop ile değerleri kopyalayabiliriz.
        Entry deepCopy2() {
            Entry entry=new Entry(key,value,next);
            for(Entry p=entry; p.next!=null; p=p.next){
                p.next=new Entry(p.next.key,p.next.value,p.next.next);
            }
            return entry;
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
        HashTableSolution hashTable= (HashTableSolution) super.clone();
        hashTable.buckets=new Entry[buckets.length];
        for(int i=0;i< buckets.length;i++){
            if(buckets[i]!=null){
                hashTable.buckets[i]=buckets[i].deepCopy();
            }
        }
        return hashTable;
    }
}
