// hotspot jvm interpretation execution demo

// result of javap -verbose:
// public static void main(java.lang.String[]);
//     descriptor: ([Ljava/lang/String;)V
//     flags: ACC_PUBLIC, ACC_STATIC
//     Code:
//       stack=1, locals=2, args_size=1
//          0: iconst_1
//          1: istore_1
//          2: return

// key debug points:
// **** stack and registers, bcp pointer inc and jump****
// 1. callstub site
// 2. zerolocals
// 3. iconst_1
// 4. istore_1
// 5. return

public class Interpret {

    public static void main(String[] args) {
        int i = 1;
    }
}
