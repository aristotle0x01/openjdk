// hotspot jvm invokestatic interpretation execution demo

// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/javac InterpretStatic.java
// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java InterpretStatic
// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/javap -verbose InterpretStatic

/**
public class InterpretStatic
  SourceFile: "InterpretStatic.java"
  minor version: 0
  major version: 52
  flags: ACC_PUBLIC, ACC_SUPER
Constant pool:
   #1 = Methodref          #4.#15         //  java/lang/Object."<init>":()V
   #2 = Methodref          #3.#16         //  InterpretStatic.int_static_test_method:()I
   #3 = Class              #17            //  InterpretStatic
   #4 = Class              #18            //  java/lang/Object
   #5 = Utf8               <init>
   #6 = Utf8               ()V
   #7 = Utf8               Code
   #8 = Utf8               LineNumberTable
   #9 = Utf8               main
  #10 = Utf8               ([Ljava/lang/String;)V
  #11 = Utf8               int_static_test_method
  #12 = Utf8               ()I
  #13 = Utf8               SourceFile
  #14 = Utf8               InterpretStatic.java
  #15 = NameAndType        #5:#6          //  "<init>":()V
  #16 = NameAndType        #11:#12        //  int_static_test_method:()I
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
        line 23: 0

  public static void main(java.lang.String[]);
    descriptor: ([Ljava/lang/String;)V
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=1
         0: invokestatic  #2                  // Method int_static_test_method:()I
         3: pop
         4: return
      LineNumberTable:
        line 26: 0
        line 27: 4

  public static int int_static_test_method();
    descriptor: ()I
    flags: ACC_PUBLIC, ACC_STATIC
    Code:
      stack=1, locals=1, args_size=0
         0: iconst_1
         1: istore_0
         2: iload_0
         3: ireturn
      LineNumberTable:
        line 30: 0
        line 31: 2
}
**/

public class InterpretStatic {

    public static void main(String[] args) {
        InterpretStatic.int_static_test_method();
    }

    public static int int_static_test_method() {
        int i = 1;
        return i;
    }
}
