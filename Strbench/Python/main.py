import re
import time
import sys

str = "abcdefgh" + "efghefgh"
iterator_max = 1024 / len(str) * 1024 * 4
# 4mb

start_time = time.time()
print("exec.time.sec\tstr.size")
sys.stdout.flush()

new_string = ''
iterator = 0

while (iterator < iterator_max + 1000):
    iterator = iterator + 1
    new_string += str
    new_string = re.sub('efgh', '____', new_string)
    length = len(str) * iterator
    if(length % (1024 * 256) == 0):
        print(int(time.time() - start_time), "sec\t\t", (length / 1024), "kb")
        sys.stdout.flush()
