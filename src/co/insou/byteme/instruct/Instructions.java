package co.insou.byteme.instruct;

import co.insou.byteme.instruct.def.*;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public enum Instructions {

    EXIT((byte) 0, new Exit_0()),
    STORE0((byte) 1, new Store0_1()),
    STORE1((byte) 2, new Store1_2()),
    STORE2((byte) 3, new Store2_3()),
    STORE3((byte) 4, new Store3_4()),
    STORE((byte) 5, new Store_2b_5()),
    LOAD0((byte) 6, new Load0_6()),
    LOAD1((byte) 7, new Load1_7()),
    LOAD2((byte) 8, new Load2_8()),
    LOAD3((byte) 9, new Load3_9()),
    LOAD((byte) 10, new Load_2b_10()),
    SUM((byte) 11, new Sum_11()),
    SUB((byte) 12, new Sub_12()),
    MUL((byte) 13, new Mul_13()),
    DIV((byte) 14, new Div_14()),
    MOD((byte) 15, new Mod_15()),
    GOTO((byte) 16, new Goto_2b_16()),
    GOTOS((byte) 17, new GotoS_17()),
    PRINT((byte) 18, new Print_2b_18()),
    CONST0((byte) 19, new Const0_19()),
    CONST1((byte) 20, new Const1_20()),
    CONST2((byte) 21, new Const2_21()),
    CONST3((byte) 22, new Const3_22()),
    CONST((byte) 23, new Const_2b_23()),
    INCR((byte) 24, new Incr_24()),
    DECR((byte) 25, new Decr_25()),
    CMPGT((byte) 26, new CmpGt_26()),
    CMPGE((byte) 27, new CmpGe_27()),
    CMPLT((byte) 28, new CmpLt_28()),
    CMPLE((byte) 29, new CmpLe_29()),
    GOTOIF((byte) 30, new GotoIf_2b_30()),
    GOTOSIF((byte) 31, new GotoSIf_31()),
    EQUAL((byte) 32, new Equal_32()),
    NOT((byte) 33, new Not_33());

    public static final byte INVALID = -1;

    private static final Map<Byte, ByteMeInstruction> OP_TO_INST = new IdentityHashMap<>();
    private static final Map<String, Byte> ACR_TO_OP = new HashMap<>();

    static
    {
        for (Instructions instruction : Instructions.values())
        {
            Instructions.OP_TO_INST.put(instruction.getOpcode(), instruction.getInstruction());
            Instructions.ACR_TO_OP.put(instruction.name().toLowerCase(), instruction.opcode);
        }
    }

    public static ByteMeInstruction getInstruction(byte opcode)
    {
        return Instructions.OP_TO_INST.get(opcode);
    }

    public static byte getOpcode(String acronym)
    {
        return Instructions.ACR_TO_OP.getOrDefault(acronym.toLowerCase(), Instructions.INVALID);
    }

    private final byte opcode;
    private final ByteMeInstruction instruction;

    Instructions(byte opcode, ByteMeInstruction instruction)
    {
        this.opcode = opcode;
        this.instruction = instruction;
    }

    public byte getOpcode()
    {
        return this.opcode;
    }

    public ByteMeInstruction getInstruction()
    {
        return this.instruction;
    }

}
