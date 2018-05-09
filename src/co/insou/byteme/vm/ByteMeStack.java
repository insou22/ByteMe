package co.insou.byteme.vm;

public interface ByteMeStack {

    byte pop();

    void push(byte value);

    int size();

}
