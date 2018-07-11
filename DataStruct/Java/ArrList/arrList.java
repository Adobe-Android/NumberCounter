import java.util.ArrayList;

public class arrList {
    public static void main(String[] args) {
        int loopNum = 10000000;
        ArrayList<Integer> aList = new ArrayList<>();
        for (int i = 0; i < loopNum; i++) {
            System.out.println(i);
            aList.add(i, 1);
        }
    }
}
