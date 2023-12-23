public class AddressTest {

    public static void main(String args[]) throws Exception {
        AddressTest at = new AddressTest();
        int i = at.f1(0);
        i = at.f1(i);
        i = at.f1(i);
        System.out.println(i);
    }

    public int f1(int it) {
        return it+1;
    }
}
