package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeRegister;

import java.util.IdentityHashMap;
import java.util.Map;

public class DefaultByteMeRegister implements ByteMeRegister {

    private final Map<Integer, Integer> register;

    public DefaultByteMeRegister()
    {
        this.register = new IdentityHashMap<>();
    }

    @Override
    public int len()
    {
        return this.register.size();
    }

    @Override
    public int getData(int index)
    {
        return this.register.get(index);
    }

    @Override
    public void setData(int index, int value)
    {
        this.register.put(index, value);
    }

}
