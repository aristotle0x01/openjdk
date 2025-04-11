import java.util.ArrayList;
import java.util.List;

public class FullGCExample {
    public static void main(String[] args) {
        List<byte[]> list = new ArrayList<>();

        while (true) {
            byte[] data = new byte[1000 * 1024]; 
            list.add(data);

            if (list.size() >= 1000) {
                list.clear(); 
            }
        }
    }
}