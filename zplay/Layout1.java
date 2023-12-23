import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;
import java.lang.reflect.Field;

// -XX:-UseCompressedOops
public class Layout1 {
    static Unsafe getUnsafe() throws NoSuchFieldException, IllegalAccessException {
        Field f = Unsafe.class.getDeclaredField("theUnsafe"); //Internal reference
        f.setAccessible(true);
        return (Unsafe) f.get(null);
    }

    public static void main(String args[]) throws Exception {
        Unsafe unsafe = getUnsafe();
        FieldsArrangement1 fa = new FieldsArrangement1();
        System.out.println(ClassLayout.parseInstance(fa).toPrintable());

        Field f3 = FieldsArrangement1.class.getDeclaredField("third");
        f3.setAccessible(true);
        System.out.println("unsafe.objectFieldOffset:");
        long offset = unsafe.objectFieldOffset(f3);
        unsafe.putDouble(fa, offset, 2.0);

        System.out.println("field third: " + f3.get(fa));
    }
}

class FieldsArrangement1 {
    private boolean first;
    private char second;
    private double third;
    private int fourth;
    private boolean fifth;
}

