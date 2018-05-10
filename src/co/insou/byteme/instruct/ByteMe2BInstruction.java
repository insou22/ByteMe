package co.insou.byteme.instruct;

public interface ByteMe2BInstruction extends ByteMeInstruction {

    @Override
    default int parameters() {
        return 1;
    }
}
