package com.leetcode.daily.y2021.m10;

import java.util.Arrays;
import java.util.Iterator;

class d05_Q284 {

    private class PeekingIterator implements Iterator<Integer> {
    
        private Integer p;
        private Iterator<Integer> it;
        
        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            it = iterator;
        }
        
        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (p == null)
                p = it.next();
            return p;
        }
        
        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer res = null;
            if (p != null) {
                res = p;
                p = null;
            } else {
                res = it.next();
            }
            return res;
        }
        
        @Override
        public boolean hasNext() {
            return p == null ? it.hasNext() : true;
        }
    }

    public static void main(String[] args) {
        Iterator<Integer> iterator = Arrays.asList(1, 2, 3).iterator();
        PeekingIterator pIterator = new d05_Q284().new PeekingIterator(iterator);
        System.out.println(pIterator.next());
        System.out.println(pIterator.peek());
        System.out.println(pIterator.next());
        System.out.println(pIterator.next());
        System.out.println(pIterator.hasNext());
    }

}