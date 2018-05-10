package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeProgram;

public class DefaultByteMeProgram implements ByteMeProgram {

    private final int[] code;

    public DefaultByteMeProgram(int[] code)
    {
        this.code = code;
    }

    @Override
    public int[] code()
    {
        return this.code;
    }

    @Override
    public int len()
    {
        return this.code.length;
    }

}
