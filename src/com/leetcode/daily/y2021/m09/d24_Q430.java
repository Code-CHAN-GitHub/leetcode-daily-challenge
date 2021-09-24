package com.leetcode.daily.y2021.m09;

class d24_Q430 {
    
    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
        public Node() {}
        public Node(int val) {this.val = val;}
    };

    public Node flatten(Node head) {
        if (head != null)
            dfs(head);
        return head;
    }
    
    private Node dfs(Node head) {
        Node p = head;
        while (true) {
            if (p.child != null) {
                Node next = p.next;
                Node tmp = dfs(p.child);
                p.next = p.child;
                p.child.prev = p;
                p.child = null;
                tmp.next = next;
                if (next != null)
                    next.prev = tmp;
                p = tmp;
            }
            if (p.next == null)
                return p;
            p = p.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.child = node2;
        node2.child = node3;
        Node res = new d24_Q430().flatten(node1);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
        System.out.print("\b\b");
    }
}