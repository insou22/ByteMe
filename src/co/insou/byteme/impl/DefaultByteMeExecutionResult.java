package co.insou.byteme.impl;

import co.insou.byteme.vm.ByteMeExecutionResult;
import co.insou.byteme.vm.ByteMeExecutionResultType;

public class DefaultByteMeExecutionResult implements ByteMeExecutionResult {

    private final int[] data;
    private final ByteMeExecutionResultType result;

    public DefaultByteMeExecutionResult(int[] data, ByteMeExecutionResultType result)
    {
        this.data = data;
        this.result = result;
    }

    @Override
    public int[] data()
    {
        return this.data;
    }

    @Override
    public ByteMeExecutionResultType resultType()
    {
        return this.result;
    }

}
