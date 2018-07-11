
// Work in progress..
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int i;
        int IntSum = 0;
        Set<Integer> hash_Set = new HashSet<>();
        for (i = 1; i < 1000000; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                System.out.println("Divisible by 3 or 5 " + i + "\n");
                hash_Set.add(i);
            }
        }
//        List<Integer> integersList = new ArrayList<>(hash_Set);
//        int test = integersList.get(0); // "string1";
        hash_Set.forEach(IntSum += );
        System.out.println();
    }
}
