package com.adobeandroid.strbench;

public class App {
    public static final void main(String[] args) {
        String str = "abcdefgh" + "efghefgh";
        int iteratorMax = 1024 / str.length() * 1024 * 4;

        long time = System.currentTimeMillis();
        System.out.println("exec.time.sec\tstr.size\tallocated memory:free memory:memory used");
        Runtime runtime = Runtime.getRuntime();
        System.out.println("0\t\t0\t\t" + runtime.totalMemory() / 1024 + ":" + runtime.freeMemory() / 1024 + ":"
                + (runtime.totalMemory() - runtime.freeMemory()) / 1024);

        final StringBuilder newString = new StringBuilder();
        int iterator = 0;
        int length;
        while (iterator++ < iteratorMax + 1000) {
            newString.append(str);
            int startIndex = newString.indexOf("efgh");
            while (startIndex != -1) {
                newString.replace(startIndex, startIndex + 4, "____");
                startIndex = newString.indexOf("efgh", startIndex + 4);
            }
            length = str.length() * iterator;
            if ((length % (1024 * 256)) == 0) {
                System.out.println(((System.currentTimeMillis() - time) / 1000) + " sec\t\t" + length / 1024 + "kb\t\t"
                        + runtime.totalMemory() / 1024 + ":" + runtime.freeMemory() / 1024 + ":"
                        + (runtime.totalMemory() - runtime.freeMemory()) / 1024);
            }
        }
    }
}