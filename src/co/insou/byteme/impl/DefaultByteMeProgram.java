package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeProgram;

public class DefaultByteMeProgram implements ByteMeProgram {

    private final byte[] code;

    public DefaultByteMeProgram(byte[] code)
    {
        this.code = code;
    }

    @Override
    public byte[] code()
    {
        return this.code;
    }

    @Override
    public int len()
    {
        return this.code.length;
    }

}
