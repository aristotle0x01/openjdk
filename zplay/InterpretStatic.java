// hotspot jvm invokestatic interpretation execution demo

// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/javac InterpretStatic.java
// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java InterpretStatic
// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/javap -verbose InterpretStatic

/**
Classfile /var/shared/openjdk/zplay/InterpretStatic.class
  Last modified Jan 18, 2024; size 388 bytes
  MD5 checksum 32a0fd6a096cb4ef4af203b219cf3d80
  Compiled from "InterpretStatic.java"
public class InterpretStatic
  SourceFile: "InterpretStatic.java"
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#15         //  java/lang/Object."<init>":()V
   #2 = Methodref          #3.#16         //  InterpretStatic.int_static_test_method:(II)I
   #3 = Class              #17            //  InterpretStatic
   #4 = Class              #18            //  java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               main
  #10 = Utf8               ([Ljava/lang/String;)V
  #11 = Utf8               int_static_test_method
  #12 = Utf8               (II)I
  #13 = Utf8               SourceFile
  #14 = Utf8               InterpretStatic.java
  #15 = NameAndType        #5:#6          //  "<init>":()V
  #16 = NameAndType        #11:#12        //  int_static_test_method:(II)I
  #17 = Utf8               InterpretStatic
  #18 = Utf8               java/lang/Object
{
  public InterpretStatic();
    descriptor: ()V
    flags: ACC_PUBLIC
    Code:
      stack=1, locals=1, args_size=1
         0: aload_0
         1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         4: return
      LineNumberTable:
        line 71: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=1
         0: iconst_1
         1: istore_1
         2: iconst_2
         3: istore_2
         4: iload_1
         5: iload_2
         6: invokestatic  #2                  // Method int_static_test_method:(II)I
         9: pop
        10: return
      LineNumberTable:
        line 74: 0
        line 75: 2
        line 76: 4
        line 77: 10

  public static int int_static_test_method(int, int);
    descriptor: (II)I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=2, locals=3, args_size=2
         0: iload_0
         1: iload_1
         2: iadd
         3: istore_2
         4: iload_2
         5: ireturn
      LineNumberTable:
        line 80: 0
        line 81: 4
}
**/

public class InterpretStatic {

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        InterpretStatic.int_static_test_method(i, j);
    }

    public static int int_static_test_method(int i, int j) {
        int a = i+j;
        return a;
    }
}
