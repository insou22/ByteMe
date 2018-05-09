package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeRegister;

import java.util.IdentityHashMap;
import java.util.Map;

public class DefaultByteMeRegister implements ByteMeRegister {

    private final Map<Integer, Byte> register;

    public DefaultByteMeRegister()
    {
        this.register = new IdentityHashMap<>();
    }

    @Override
    public byte len()
    {
        return (byte) this.register.size();
    }

    @Override
    public byte getData(int index)
    {
        return this.register.get(index);
    }

    @Override
    public void setData(int index, byte value)
    {
        this.register.put(index, value);
    }

}
