public class arr {
    public static void main(String[] args) {
        int loopNum = 10000000;
        int[] intArray = new int[loopNum];
        for (int i = 0; i < loopNum; i++) {
            System.out.println(i);
            intArray[i] = 1;
        }
    }
}
