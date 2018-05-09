package co.insou.byteme.instruct;

public interface ByteMe2BInstruction extends ByteMeInstruction {

    @Override
    default byte parameters() {
        return 1;
    }
}
