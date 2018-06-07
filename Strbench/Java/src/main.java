class Main {

    public static final void main(String[] args) {
        String str = "abcdefgh" + "efghefgh";
        int iteratorMax = 1024 / str.length() * 1024 * 4;

        long time = System.currentTimeMillis();
        System.out.println("exec.time.sec\tstr.size\tallocated memory:free memory:memory used");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("0\t\t0\t\t" + runtime.totalMemory() / 1024 + ":" + runtime.freeMemory() / 1024 + ":" + (runtime.totalMemory() - runtime.freeMemory()) / 1024);

        String newString = "";
        int iterator = 0;
        int length;

        while (iterator++ < iteratorMax + 1000) {
            newString += str;
            newString = newString.replaceAll("efgh", "____");
            length = str.length() * iterator;
            if ((length % (1024 * 256)) == 0) {
                System.out.println(((System.currentTimeMillis() - time) / 1000) + " sec\t\t" + length / 1024 + "kb\t\t" + runtime.totalMemory() / 1024 + ":" + runtime.freeMemory() / 1024 + ":" + (runtime.totalMemory() - runtime.freeMemory()) / 1024);
            }
        }
    }
}