import java.util.ArrayList;

public class arrList {
    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            System.out.println(i);
            aList.add(i, 1);
        }
    }
}
