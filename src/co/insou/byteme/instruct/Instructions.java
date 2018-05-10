package co.insou.byteme.instruct;

import co.insou.byteme.instruct.def.*;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public enum Instructions {

    EXIT(0, new Exit_0()),
    STORE0(1, new Store0_1()),
    STORE1(2, new Store1_2()),
    STORE2(3, new Store2_3()),
    STORE3(4, new Store3_4()),
    STORE(5, new Store_2b_5()),
    LOAD0(6, new Load0_6()),
    LOAD1(7, new Load1_7()),
    LOAD2(8, new Load2_8()),
    LOAD3(9, new Load3_9()),
    LOAD(10, new Load_2b_10()),
    SUM(11, new Sum_11()),
    SUB(12, new Sub_12()),
    MUL(13, new Mul_13()),
    DIV(14, new Div_14()),
    MOD(15, new Mod_15()),
    GOTO(16, new Goto_2b_16()),
    GOTOS(17, new GotoS_17()),
    PRINT(18, new Print_2b_18()),
    CONST0(19, new Const0_19()),
    CONST1(20, new Const1_20()),
    CONST2(21, new Const2_21()),
    CONST3(22, new Const3_22()),
    CONST(23, new Const_2b_23()),
    INCR(24, new Incr_24()),
    DECR(25, new Decr_25()),
    CMPGT(26, new CmpGt_26()),
    CMPGE(27, new CmpGe_27()),
    CMPLT(28, new CmpLt_28()),
    CMPLE(29, new CmpLe_29()),
    GOTOIF(30, new GotoIf_2b_30()),
    GOTOSIF(31, new GotoSIf_31()),
    EQUAL(32, new Equal_32()),
    NOT(33, new Not_33()),
    PRINTA(34, new PrintA_2b_34()),
    PRINTAS(35, new PrintAS_35()),
    PRINT1(36, new Print1_36()),
    STORES0(37, new StoreS0_37()),
    STORES1(38, new StoreS1_38()),
    STORES2(39, new StoreS2_39()),
    STORES3(40, new StoreS3_40()),
    STORES(41, new StoreS_41());

    public static final int INVALID = -1;

    private static final Map<Integer, ByteMeInstruction> OP_TO_INST = new IdentityHashMap<>();
    private static final Map<String, Integer> ACR_TO_OP = new HashMap<>();

    static
    {
        for (Instructions instruction : Instructions.values())
        {
            Instructions.OP_TO_INST.put(instruction.getOpcode(), instruction.getInstruction());
            Instructions.ACR_TO_OP.put(instruction.name().toLowerCase(), instruction.opcode);
        }
    }

    public static ByteMeInstruction getInstruction(int opcode)
    {
        return Instructions.OP_TO_INST.get(opcode);
    }

    public static int getOpcode(String acronym)
    {
        return Instructions.ACR_TO_OP.getOrDefault(acronym.toLowerCase(), Instructions.INVALID);
    }

    private final int opcode;
    private final ByteMeInstruction instruction;

    Instructions(int opcode, ByteMeInstruction instruction)
    {
        this.opcode = opcode;
        this.instruction = instruction;
    }

    public int getOpcode()
    {
        return this.opcode;
    }

    public ByteMeInstruction getInstruction()
    {
        return this.instruction;
    }

}
