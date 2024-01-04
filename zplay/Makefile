DIR_JAVA := /var/shared/openjdk/build/linux-x86_64-normal-server-slowdebug/jdk/bin

AddressTest.class: AddressTest.java
	# -cp ".:jol-core-0.17.jar"
	$(DIR_JAVA)/javac  AddressTest.java
r: AddressTest.class
	$(DIR_JAVA)/java AddressTest
ri: AddressTest.class
	$(DIR_JAVA)/java -cp ".:jol-core-0.17.jar" -Xint -XX:-UseCompressedOops -XX:+UnlockDiagnosticVMOptions -XX:+PrintInterpreter  AddressTest
d:
	rm -f AddressTest.class
