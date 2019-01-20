# Lang-Benchmark

### What is it?
This is a repository where I (and possibly others) will be writing small programs to compare a limited number of languages.

I think this is a good reference point even if it holds little practical value and doesn't do enough to serve as a real benchmark.

### Hardware/OS:
- All tests are run on an **Intel® Core™ i5-4200U at 1.60GHz.**
- The OS is **Fedora 29.**
- C and C++ code is compiled using the **-0s optimization.**
- Rust code (*coming soon*) is compiled using **cargo build --release.**

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
| total:   | 0m 27.53        | 0 sec		 | 768 kb   |
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
|----------|---------------|---------------|----------|
| user:    | 1m 53.89s     | 0 sec	       | 256 kb   |
| sys:     | 0m 0.05s      | 1 sec		   | 512 kb   |
| total:   | 1m 54.54      | 3 sec	       | 768 kb   |
| cpu:     | 99%           | 6 sec	       | 1024 kb  |
| max mem: | 47852 KB      | 10 sec	       | 1280 kb  |
|          |               | 15 sec	       | 1536 kb  |
|          |               | 21 sec	       | 1792 kb  |
|          |               | 27 sec	       | 2048 kb  |
|          |               | 35 sec	       | 2304 kb  |
|          |               | 43 sec	       | 2560 kb  |
|          |               | 52 sec	       | 2816 kb  |
|          |               | 62 sec	       | 3072 kb  |
|          |               | 74 sec	       | 3328 kb  |
|          |               | 86 sec	       | 3584 kb  |
|          |               | 99 sec	       | 3840 kb  |
|          |               | 113 sec       | 4096 kb  |

|          | JavaScript (Node 10.4.0) | exec.time.sec | str.size |
|----------|--------------------------|---------------|----------|
| user:    | 2m 52.49s                | 0 sec	      | 256 kb   |
| sys:     | 3m 32.53s                | 1 sec		  | 512 kb   |
| total:   | 3m 51.28                 | 5 sec		  | 768 kb   |
| cpu:     | 166%                     | 11 sec		  | 1024 kb  |
| max mem: | 134 MB                   | 18 sec	      | 1280 kb  |
|          |                          | 27 sec	      | 1536 kb  |
|          |                          | 38 sec	 	  | 1792 kb  |
|          |                          | 51 sec	      | 2048 kb  |
|          |                          | 65 sec	      | 2304 kb  |
|          |                          | 81 sec	      | 2560 kb  |
|          |                          | 99 sec	      | 2816 kb  |
|          |                          | 118 sec	      | 3072 kb  |
|          |                          | 140 sec	      | 3328 kb  |
|          |                          | 163 sec	      | 3584 kb  |
|          |                          | 188 sec	      | 3840 kb  |
|          |                          | 215 sec       | 4096 kb  |

|          | Python (CPython 3.6.5) | exec.time.sec | str.size |
|----------|------------------------|---------------|----------|
| user:    | 6m 17.7s               | 1 sec	        | 256 kb   |
| sys:     | 2m 1.45s               | 6 sec		    | 512 kb   |
| total:   | 8m 19.26               | 14 sec	    | 768 kb   |
| cpu:     | 99%                    | 27 sec	    | 1024 kb  |
| max mem: | 25 MB                  | 44 sec	    | 1280 kb  |
|          |                        | 64 sec	    | 1536 kb  |
|          |                        | 88 sec	    | 1792 kb  |
|          |                        | 117 sec	    | 2048 kb  |
|          |                        | 149 sec	    | 2304 kb  |
|          |                        | 186 sec	    | 2560 kb  |
|          |                        | 227 sec	    | 2816 kb  |
|          |                        | 272 sec	    | 3072 kb  |
|          |                        | 322 sec	    | 3328 kb  |
|          |                        | 375 sec	    | 3584 kb  |
|          |                        | 433 sec	    | 3840 kb  |
|          |                        | 495 sec       | 4096 kb  |

## SumCalc
This is a program that calculates all values divisible by 3 or 5 that are less than 1 million. If they are, it then adds them to a total number and outputs the result.
I got inspiration for this test at project euler.

*Reference: https://projecteuler.net/problem=1*

### Why?
I thought this would be a good addition as the benchmarks were severely lacking some mathematical computation and it presents some fun optimization opportunities.

|          | C++ (GCC 8.2.1) |
|----------|-----------------|
| user:    | 0m 0.01s        |
| sys:     | 0m 0.00s        |
| total:   | 0m 2s           |
| cpu:     | 95%             |
| max mem: | 4804 KB         |

|          | Java (openjdk-11.0.1) |
|----------|-----------------|
| user:    | 0m 0.16s        |
| sys:     | 0m 0.02s        |
| total:   | 0m 10s          |
| cpu:     | 173%            |
| max mem: | 49792 KB        |

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
