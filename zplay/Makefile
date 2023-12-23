DIR_JAVA := /var/shared/8b120/build/linux-x86_64-normal-server-slowdebug/jdk/bin

AddressTest.class: AddressTest.java
	$(DIR_JAVA)/javac -cp ".:jol-core-0.17.jar" AddressTest.java
r: AddressTest.class
	# -XX:+PrintInterpreter
	$(DIR_JAVA)/java -cp ".:jol-core-0.17.jar" -Xint -XX:-UseCompressedOops -XX:+UnlockDiagnosticVMOptions AddressTest
d:
	rm -f AddressTest.class
