docker run --name=jdk --security-opt seccomp=unconfined -p 1234:1234 -v  /Users/wanghao18/Downloads/wanghao18/repository/jdk8u:/var/shared/jdk8u  -idt bolingcavalryopenjdk:0.0.3
docker exec -it jdk /bin/bash

docker commit 035aa1b980d8 bolingcavalryopenjdk:0.0.3

gdbserver  :1234 /var/shared/jdk8u/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java Test
gdb --args /var/shared/jdk8u/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -version

The Java Virtual Machine maintains a list of the names of all the types already loaded by each class loader. Each of these lists forms a name space inside the Java Virtual Machine

The ultimate goal of constant pool resolution is to replace a symbolic reference with a direct reference. The form of symbolic references is well-defined in Chapter 6, "The Java Class File," but what form do direct references take?

what is method table


Chapter 8 of Inside the Java Virtual Machine： https://www.artima.com/insidejvm/ed2/linkmod19.html
With each pass of the for loop, the main() method of GreetAndForget creates a new GreeterClassLoader object. Thus, every greeter that GreetAndForget loads is loaded through a different user-defined class loader. For example, if you invoke the GreetAndForget application with the Hello greeter listed five times on the command line, the application will create five instances of class GreeterClassLoader. The Hello greeter will be loaded five times by five different user-defined class loaders. The method area will contain five different copies of the type data for Hello. The heap will contain five Class instances that represent the Hello class--one for each namespace into which Hello is loaded. When one of the Class instances for Hello becomes unreferenced, only the Hello type data associated with that particular Class instance would be available for unloading.




对同一个类，使用不同加载器加载，查看systemdic查询过程

# 查看 libjvm.debuginfo
ls ./build/linux-x86_64-normal-server-release/jdk/lib/amd64/server/
# 若编译时没有设置生成，可进入该目录（libjvm.so 所在目录）手动解压
unzip libjvm.diz

symbol-file    /var/shared/jdk8u/build/linux-x86_64-normal-server-slowdebug/hotspot/linux_amd64_compiler2/debug

./configure --with-debug-level=slowdebug --with-native-debug-symbols=internal --enable-debug-symbols --disable-zip-debug-info
make all ENABLE_FULL_DEBUG_SYMBOLS=1 DISABLE_HOTSPOT_OS_VERSION_CHECK=OK CONF=linux-x86_64-normal-server-slowdebug JOBS=8

handle SIGSEGV nostop noprint pass
break jvm.cpp:1197 if ((int)strcmp(str, "ClassLoaderTest2$Test2")) == 0
condition 1 $_streq(str, "ClassLoaderTest2$Test2")

break instanceKlass.cpp:1161 if ((int)strcmp(this->external_name(), "FieldsArrangement2")) == 0
condition 4 $_streq(this->external_name(), "AddressTest$FieldsArrangement2")

condition 1 $_streq(str, "FieldsArrangement2")
break jvm.cpp:1197 if ((int)strcmp(str, "FieldsArrangement2")) == 0

p this->external_name()
p this->name()->as_C_string()
p class_name->as_C_string()
p loader_data->loader_name()


my mac compile openjdk8-b120:
    docker build -t bolingcavalryopenjdk:0.0.1 .

    docker:
        docker run --name=openjdk --security-opt seccomp=unconfined -v  /Users/xiaofei/repo/openjdk:/var/shared/openjdk  -idt bolingcavalryopenjdk:0.0.1
        docker exec -it openjdk /bin/bash
        ./configure --with-debug-level=slowdebug --enable-debug-symbols --disable-zip-debug-info
        make all ZIP_DEBUGINFO_FILES=0 ENABLE_FULL_DEBUG_SYMBOLS=1 DISABLE_HOTSPOT_OS_VERSION_CHECK=OK CONF=linux-x86_64-normal-server-slowdebug JOBS=16    
        docker commit openjdk bolingcavalryopenjdk:0.0.2
    soft link:
        ln -s /Users/xiaofei/repo/openjdk /var/shared
    debug:
        docker run --name=openjdk --security-opt seccomp=unconfined -p 1234:1234 -v /Users/xiaofei/repo/openjdk:/var/shared/openjdk  -idt bolingcavalryopenjdk:0.0.2
        docker exec -it openjdk /bin/bash
        # yum install gdb-gdbserver
        gdbserver  :1234 /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java AddressTest
        gdb --args ./java -version




https://sourceware.org/gdb/wiki/PermissionsDarwin


../java -cp ".:jol-core.jar" -XX:+PrintFieldLayout  -XX:-UseCompressedOops AddressTest
../java -jar jol-cli.jar internals java.lang.Object


TLAB == Thread-Local-Allocation-Buffer
java对象在内存中的表达及其层级结构
java方法栈帧
    打印PrintInterpreter  invokevirtual  编译结果
编译执行过程
jitwatch 单独查看一段invokevirtual编译后的代码


一些学习想法：
    jvmti 增加一个功能
    修改一种实现
    删除其它没用的东西，减少代码体积？同时改造编译啥的？
    看懂一个jdk bug修复的过程，自己模拟？


/var/shared/jdk8u/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -Xint -XX:-UseCompressedOops -XX:+UnlockDiagnosticVMOptions -XX:+PrintInterpreter AddressTest > r.txt
../java -cp ".:jol-core-0.17.jar" -Xint -XX:-UseCompressedOops -XX:+CountBytecodes AddressTest
gdbserver  :1234 /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java AddressTest
gdbserver  :1234 /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -XX:+PrintFlagsFinal -XX:+UseSerialGC AddressTest
gdb --args /var/shared/jdk8u/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java AddressTest
gdb --args /var/shared/8b120/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java AddressTest
gdb --args /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java AddressTest


b classFileParser.cpp:3735
b parseClassFile
macro expand xxxMACRO

:
    in ../bin/ folder
    run gdb
    directory /var/shared/jdk8u
    b classFileParser.cpp:3735
    break pending

b templateTable_x86_64.cpp:3105
b init.cpp:95

vm/runtime/thread.cpp:3436::create_vm()
    hotspot/src/share/vm/runtime/init.cpp::init_globals()
        interpreter.cpp::interpreter_init()
            TemplateInterpreter::initialize() // InterpreterGenerator g(_code);
                InterpreterGenerator:InterpreterGenerator()
                    generate_all(
                        set_entry_points_for_all_bytes(
                            TemplateInterpreterGenerator::set_entry_points(
                                template_for(


generate_method_entry
method_kind(


gdbserver  :1234 /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -XX:+PrintInterpreter AddressTest | grep -A 50 invokevirtual
gdb /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java
    b breakpoint
    run -XX:StopInterpreterAt=182 AddressTest
p 'TemplateTable::_template_table'['Bytecodes::_invokevirtual']
p &'TemplateTable::_template_table'['Bytecodes::_invokevirtual']

gdb /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -ex "set args -cp . AddressTest"
gdb /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -ex "set args -cp . AddressTest"                           \
         -ex "set breakpoint pending on"                        \
         -ex "break jni_CallStaticVoidMethod"                   \
         -ex "run"                                              \
         -ex "break InterpreterRuntime::resolve_from_cache"     \
         -ex "cont"                                             \
         -ex 'call pns($rsp, $rbp, $pc)'


/var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -Xint -XX:+UnlockDiagnosticVMOptions -XX:+PrintInterpreter -XX:LogFile=int.log AddressTest
first round:
gdb /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java
    run -Xint -XX:+PrintInterpreter -XX:PrintAssemblyOptions=intel AddressTest | grep -E -A 10 'iconst_1|istore_1'
    run -Xint -XX:StopInterpreterAt=4 AddressTest
    run Interpret
    
second round:
    b init_globals()
    b javaCalls.cpp:393
    run -Xint AddressTest
    fin
    b *0x00007fffe101e2e0 // zerolocals start address


zero round:
    /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -XX:+PrintInterpreter -XX:LogFile=interpret.log InterpretStatic

first round:
gdb /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java
    run InterpretStatic
    run -XX:+PrintInterpreter InterpretStatic | grep -E -A 10 'invokestatic|zerolocals'
    
second round:
    b stubGenerator_x86_64.cpp:3811
    b javaCalls.cpp:393

    p 'StubRoutines::_call_stub_entry'
    $2 = (address) 0x7fffe1000564

    p 'StubRoutines::call_stub()'
    p *'StubRoutines::call_stub()'
    0x7ffff66f7768

    
    method entry point (kind = zerolocals)  [0x00007fffe101e2e0, 0x00007fffe101f040]  3424 bytes

    r14 0x7fffdb0f7760

    ctrl+x+a 
    ctrl+x+1 / 2 查看汇编结果，验证call_stub()地址

third round:
    // jdk/src/share/bin/java.c
    b java.c:472
    break then:
        b javaCalls.cpp:393
        b *0x7fffe1000564 // break call_stub

    
fourth:
    run -XX:+PrintInterpreter InterpretStatic | grep -E -A 20 'invokestatic|zerolocals'

    b java.c:472
    run InterpretStatic

    b *0x00007fffe1043690 // invokestatic vtos入口
    b *0x00007fffe101e2e0 // zerolocals

    p (unsigned char)*($r13)
    p (unsigned char)*($r13+1)

    p 'TemplateInterpreter::_active_table'.table_for(vtos)[184]
    p 'AbstractInterpreter::_entry_table'[0]  // zerolocals

    p ((Method*)($rbx))->name()







/var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/javap -c AddressTest
/var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -Xint -XX:+UnlockDiagnosticVMOptions -XX:+PrintInterpreter -XX:PrintAssemblyOptions=intel AddressTest > intp.txt

p 'TemplateTable::_template_table'['Bytecodes::_iconst_1']
p 'TemplateTable::_template_table'['Bytecodes::_istore_1']


  public static void main(java.lang.String[]);
    Code:
       0: iconst_1
       1: istore_1
       2: return
iconst_1  4 iconst_1  [0x00007fffe10287a0, 0x00007fffe1028800]  96 bytes
istore_1  60 istore_1  [0x00007fffe102ac00, 0x00007fffe102ac40]  64 bytes

ni 5
p *($r10+8*$rbx)
p (unsigned char)*($r13)
x /18i $pc
break if (unsigned char)*($r13) == 4 && (unsigned char)*($r13+1) == 60
break if $ebx == 60
break if (unsigned char)*($r13) == 177


du -sh -I build .

git checkout tags/jdk8-b120
git checkout -b j8-b120


CppCon 2015: Greg Law " Give me 15 minutes & I'll change your view of GDB"
5 Easy Ways to Reduce Your Debugging Hours: https://undo.io/resources/gdb-watchpoint/5-ways-reduce-debugging-hours
gdb: ctrl+x+a with text user interface
    ctrl+x+1 / 2...
    tui reg general
    disas // assemble

unleash to real power of gdb, using macros
GDB and Debugging: https://web.stanford.edu/class/archive/cs/cs107/cs107.1196/resources/gdb
Advanced GDB Usage: https://interrupt.memfault.com/blog/advanced-gdb#essentials
Mastering GDB:  https://betterprogramming.pub/mastering-gdb-be5e589af90b
Back to Basics: Debugging in Cpp - Greg Law - CppCon 2023: https://www.youtube.com/watch?v=qgszy9GquRs




todo
    为什么保存入参和局部变量分界？
        r14保存分界，和后续其它指令对local变量的偏移如何解释
    为什么栈帧结束后保存esp?
    invokevirtual时参数如何传递
    movptr(Address(rbp, frame::interpreter_frame_bcx_offset * wordSize), r13);
    movptr(cache, Address(rbp, frame::interpreter_frame_cache_offset * wordSize));



Universe::initialize_heap()
    gc_policy = new MarkSweepPolicy();
    Universe::_collectedHeap = new GenCollectedHeap(gc_policy);
    Universe::heap()->initialize();


gc debug:

gdbserver  :1234 /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -XX:+UseSerialGC -Xmx100M -Xms100M -XX:NewRatio=2 AddressTest
