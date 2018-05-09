package co.insou.byteme;

import co.insou.byteme.impl.DefaultByteMeVM;
import co.insou.byteme.vm.ByteMeVM;

public class ByteMe {

    private static final boolean DEBUG = false;

    public static ByteMeVM defaultVM()
    {
        return new DefaultByteMeVM();
    }

    public static void debug(String debug)
    {
        if (ByteMe.DEBUG)
        {
            System.out.println("[DEBUG] " + debug);
        }
    }

}
