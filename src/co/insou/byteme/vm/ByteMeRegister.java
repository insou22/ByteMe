package co.insou.byteme.vm;

public interface ByteMeRegister {

    byte len();

    byte getData(int index);

    void setData(int index, byte value);

}
