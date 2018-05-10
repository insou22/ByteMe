package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeStack;

import java.util.Stack;

public class DefaultByteMeStack implements ByteMeStack {

    private final Stack<Integer> stack = new Stack<>();

    @Override
    public int pop() {
        return this.stack.pop();
    }

    @Override
    public void push(int value) {
        this.stack.push(value);
    }

    @Override
    public int size() {
        return this.stack.size();
    }

}
