
// /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin/java -Xcomp -server -XX:CompileThreshold=1 -XX:+UnlockDiagnosticVMOptions '-XX:CompileCommand=print,AddressTest::f1' -XX:-DebugNonSafepoints AddressTest
// CompileCommand JVM option: https://jpbempel.github.io/2016/03/16/compilecommand-jvm-option.html


public class AddressTest {

    public static void main(String[] args) {
        int i = 1;
        // System.out.println(i);
    }
}
