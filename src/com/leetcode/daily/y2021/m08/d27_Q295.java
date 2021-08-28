package com.leetcode.daily.y2021.m08;/**
 * @author chen
 * @create 2021-08-28-11:22
 */

import java.util.PriorityQueue;

/**
 *@ClassName d27_Q295
 *@Description TODO
 *Author chen
 *Date 2021/8/28 11:22
 *Version 1.0
 **/
public class d27_Q295 {

    class MedianFinder {

        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((e1, e2) -> e2 - e1);

        /** initialize your data structure here. */
        public MedianFinder() {

        }

        /**
         max: 5 4 3 2 1
         min: 6 7 8 9
         */

        public void addNum(int num) {
            if (getSize() == 0) {
                maxHeap.add(num);
            } else if (getSize() % 2 == 0) {
                if (num <= minHeap.peek()) {
                    maxHeap.add(num);
                } else {
                    minHeap.add(num);
                }
            } else {
                if (minHeap.size() > maxHeap.size()) {
                    if (num > minHeap.peek()) {
                        maxHeap.add(minHeap.poll());
                        minHeap.add(num);
                    } else {
                        maxHeap.add(num);
                    }
                } else {
                    if (num < maxHeap.peek()) {
                        minHeap.add(maxHeap.poll());
                        maxHeap.add(num);
                    } else {
                        minHeap.add(num);
                    }
                }
            }
        }

        public double findMedian() {
            if (getSize() % 2 == 0)
                return (minHeap.peek() + maxHeap.peek()) * 0.5;
            else
                return minHeap.size() > maxHeap.size() ? minHeap.peek() : maxHeap.peek();
        }

        private int getSize() {
            return minHeap.size() + maxHeap.size();
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new d27_Q295().new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        double median = medianFinder.findMedian();
        System.out.println(median);
        medianFinder.addNum(3);
        median = medianFinder.findMedian();
        System.out.println(median);
    }
}
