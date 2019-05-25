# Lang-Benchmark

### What is it?
This is a repository where I (and possibly others) will be writing small programs to compare a limited number of languages.

I think this is a good reference point even if it holds little practical value and doesn't do enough to serve as a real benchmark.

### Hardware/OS:
- All tests are run on an **Intel® Core™ i7-8650U at 1.90 GHz base and 4.20 GHz max turbo**
- The OS is **Pengwin 0.1-182 (WSL).**
- C++ code is compiled using the **-0s optimization.**
- Rust code (*possibly coming soon*) is compiled using **cargo build --release.**

### Supported Programming Languages:
- C++
- C#
- Java
- JavaScript
- Python
- Rust (*possibly coming soon*)

### How do I read this chart?
All benchmark times are measured with the GNU time command.

I chose this version for its capabilities and used it across all tests.

`command time --format "%U user %S system %E total %P CPU %K KB avg mem (shared & unshared) %M KB max mem" ./example`

- Total is wall clock time - time from start to finish of the call. This is all time including time used by other processes and time the process spends blocked (for example if it is waiting for I/O to complete).

- User is the amount of CPU time spent in user-mode code (outside the kernel) within the process. This is only actual CPU time used in executing the process. Other processes and time the process spends blocked do not count towards this.

- Sys is the amount of CPU time spent in the kernel within the process. This means executing CPU time spent in system calls within the kernel, as opposed to library code, which is still running in user-space. Like 'user', this is only CPU time used by the process. See below for a brief description of kernel mode (also known as 'supervisor' mode) and the system call mechanism.

*Reference: https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1* 

## Strbench
I actually had a lot of trouble coming up with a string benchmark that ran long enough for a good comparison. I was lucky enough to find a fantastic one.
If the original author would like to collaborate with me to update all or most of his old examples, I would be happy to.

*Reference: https://raid6.com.au/~onlyjob/posts/arena/*

### Why?
Strings are manipulated extremely often and this is a fantastic example with a lot of data and a long enough run-time to present more accurate results. I opted to use StringBuilder to speed up the Java implementation and will do the same for the upcoming C# implementation as strings are immutable in both languages.

|          | C++ (GCC 8.2.1) | exec.time.sec | str.size |
|----------|-----------------|---------------|----------|
| user:    | 0m 27.31s       | 0 sec	     | 256 kb   |
| sys:     | 0m 0.00s        | 0 sec		 | 512 kb   |
| total:   | 0m 27.53s       | 0 sec		 | 768 kb   |
| cpu:     | 99%             | 1 sec		 | 1024 kb  |
| max mem: | 10752 KB        | 1 sec	     | 1280 kb  |
|          |                 | 2 sec	     | 1536 kb  |
|          |                 | 3 sec		 | 1792 kb  |
|          |                 | 4 sec	     | 2048 kb  |
|          |                 | 5 sec	     | 2304 kb  |
|          |                 | 7 sec	     | 2560 kb  |
|          |                 | 9 sec	     | 2816 kb  |
|          |                 | 11 sec	     | 3072 kb  |
|          |                 | 14 sec	     | 3328 kb  |
|          |                 | 18 sec	     | 3584 kb  |
|          |                 | 22 sec	     | 3840 kb  |
|          |                 | 27 sec	     | 4096 kb  |

|          | Java (openjdk-11.0.1) | exec.time.sec | str.size |
|----------|-----------------------|---------------|----------|
| user:    | 1m 53.89s             | 0 sec	       | 256 kb   |
| sys:     | 0m 0.05s              | 1 sec		   | 512 kb   |
| total:   | 1m 54.54s             | 3 sec	       | 768 kb   |
| cpu:     | 99%                   | 6 sec	       | 1024 kb  |
| max mem: | 47852 KB              | 10 sec	       | 1280 kb  |
|          |                       | 15 sec	       | 1536 kb  |
|          |                       | 21 sec	       | 1792 kb  |
|          |                       | 27 sec	       | 2048 kb  |
|          |                       | 35 sec	       | 2304 kb  |
|          |                       | 43 sec	       | 2560 kb  |
|          |                       | 52 sec	       | 2816 kb  |
|          |                       | 62 sec	       | 3072 kb  |
|          |                       | 74 sec	       | 3328 kb  |
|          |                       | 86 sec	       | 3584 kb  |
|          |                       | 99 sec	       | 3840 kb  |
|          |                       | 113 sec       | 4096 kb  |

|          | JavaScript (Node 10.15.0) | exec.time.sec | str.size |
|----------|---------------------------|---------------|----------|
| user:    | 4m 53.40s                 | 0 sec         | 256 kb   |
| sys:     | 4m 42.29s                 | 2 sec   	   | 512 kb   |
| total:   | 7m 03.93s                 | 9 sec   	   | 768 kb   |
| cpu:     | 135%                      | 19 sec   	   | 1024 kb  |
| max mem: | 129308 KB                 | 33 sec        | 1280 kb  |
|          |                           | 50 sec        | 1536 kb  |
|          |                           | 70 sec    	   | 1792 kb  |
|          |                           | 94 sec        | 2048 kb  |
|          |                           | 121 sec       | 2304 kb  |
|          |                           | 153 sec       | 2560 kb  |
|          |                           | 188 sec       | 2816 kb  |
|          |                           | 227 sec       | 3072 kb  |
|          |                           | 270 sec       | 3328 kb  |
|          |                           | 317 sec       | 3584 kb  |
|          |                           | 367 sec       | 3840 kb  |
|          |                           | 420 sec       | 4096 kb  |

|          | Python (CPython 3.7.2) | exec.time.sec | str.size |
|----------|------------------------|---------------|----------|
| user:    | 6m 17.26s              | 1 sec	        | 256 kb   |
| sys:     | 3m 19.33s              | 6 sec		    | 512 kb   |
| total:   | 9m 41.32s              | 14 sec	    | 768 kb   |
| cpu:     | 99%                    | 28 sec	    | 1024 kb  |
| max mem: | 25440 KB               | 45 sec	    | 1280 kb  |
|          |                        | 68 sec	    | 1536 kb  |
|          |                        | 96 sec	    | 1792 kb  |
|          |                        | 129 sec	    | 2048 kb  |
|          |                        | 166 sec	    | 2304 kb  |
|          |                        | 209 sec	    | 2560 kb  |
|          |                        | 257 sec	    | 2816 kb  |
|          |                        | 311 sec	    | 3072 kb  |
|          |                        | 370 sec	    | 3328 kb  |
|          |                        | 434 sec	    | 3584 kb  |
|          |                        | 502 sec	    | 3840 kb  |
|          |                        | 576 sec       | 4096 kb  |

## SumCalc
This is a program that calculates all values divisible by 3 or 5 that are less than 100 million. If they are, it then adds them to a total number and outputs the result.
I got inspiration for this test at project euler.

*Reference: https://projecteuler.net/problem=1*

### Why?
I thought this would be a good addition as the benchmarks were severely lacking some mathematical computation and it presents some fun optimization opportunities. It should be noted that memory usage is so high here because the program is storing so many items in a collection.

|          | C++ (GCC 8.2.1) |
|----------|-----------------|
| user:    | 0m 0.76s        |
| sys:     | 0m 0.17s        |
| total:   | 0m 0.94s        |
| cpu:     | 99%             |
| max mem: | 264964 KB       |

|          | Java (openjdk-11.0.1) |
|----------|-----------------------|
| user:    | 0m 11.80s             |
| sys:     | 0m 0.67s              |
| total:   | 0m 05.14s             |
| cpu:     | 242%                  |
| max mem: | 1456444 KB            |

## DataStruct
A collection of small data stucture based benchmarks. These data structures are being tested at extremely large sizes to help separate the differences between them. You won't be able to see the difference between something like an Array and an ArrayList in much smaller programs. More coming soon (C++ Arrays and Vectors sound good). 

### Java (10.0.1)

|          | ArrayList  | Array      |
|----------|------------|:----------:|
| user:    | 0m 16.72s  | 0m 7.82s   |
| sys:     | 0m 22.16s  | 0m 22.85s  |
| total:   | 0m 34.528  | 0m 34.295s |
| cpu:     | 112%       | 89%        |
| max mem: | 991 MB     | 230 MB     |
