package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeStack;

import java.util.Stack;

public class DefaultByteMeStack implements ByteMeStack {

    private final Stack<Byte> stack = new Stack<>();

    @Override
    public byte pop() {
        return this.stack.pop();
    }

    @Override
    public void push(byte value) {
        this.stack.push(value);
    }

    @Override
    public int size() {
        return this.stack.size();
    }

}
