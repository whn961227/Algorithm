package com.whn.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueToStack {
    Queue<Integer> q = new LinkedList<>();
    int top_elem = 0;

    public void push(int x) {
        q.offer(x);
        top_elem = x;
    }

    public int top() {
        return top_elem;
    }

    public int pop() {
        int size = q.size();
        while (size > 2) {
            q.offer(q.poll());
            size--;
        }
        top_elem = q.peek();
        q.offer(q.poll());
        return q.poll();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
