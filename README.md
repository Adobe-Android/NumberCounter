# Lang-Benchmark

### What is it?
This is a repository where I (and possibly others) will be writing small programs and pushing the most basic programming constructs to compare a number of languages.

I also think this is a good reference point even if it holds little value and doesn't do enough to serve as a real benchmark.

### Additional Notes:

**All tests are run on Ubuntu 18.04.**

**All tests are run on a Ryzen 7 1700 at 3.6GHz.**

**The C++ version is compiled with the -03 optimization.**

### How do I read this chart?
All benchmark times are measured with the zsh time command.

Total refers to actual elapsed time; User and Sys refer to CPU time used only by the process.

    Total is wall clock time - time from start to finish of the call. This is all time including time used by other processes and time the process spends blocked (for example if it is waiting for I/O to complete).

    User is the amount of CPU time spent in user-mode code (outside the kernel) within the process. This is only actual CPU time used in executing the process. Other processes and time the process spends blocked do not count towards this.

    Sys is the amount of CPU time spent in the kernel within the process. This means executing CPU time spent in system calls within the kernel, as opposed to library code, which is still running in user-space. Like 'user', this is only CPU time used by the process. See below for a brief description of kernel mode (also known as 'supervisor' mode) and the system call mechanism.

*Reference: https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1* 

## NumberCounter
Each program will be a simple loop counting to 10,000,000.

### Why?
I chose ten million as it was a large enough number to help separate the difference between each programming language implementation without being so large that any language took very long.

|          | C++ (GCC 7.3.0) |
|----------|-----------------|
| user:    | 0m 2.59s        |
| sys:     | 0m 12.46s       |
| total:   | 0m 30.597       |
| cpu:     | 49%             |
| max mem: | 3 MB            |

|          | C# (.NET Core 2.1.300) | Java (10.0.1) | Go (1.10.1) |
|----------|------------------------|:-------------:|:-----------:|
| user:    | 0m 8.89s               | 0m 8.61s      | 0m 4.60s    |
| sys:     | 0m 14.49s              | 0m 23.80s     | 0m 14.03s   |
| total:   | 0m 38.919s             | 0m 46.361s    | 0m 33.895s  |
| cpu:     | 60%                    | 69%           | 54%         |
| max mem: | 101 MB                 | 192 MB        | 7 MB        |

|          | JavaScript (Node 10.4.0) | PHP (7.2.5) |
|----------|--------------------------|:-----------:|
| user:    | 1m 29.07s                | 0m 3.79s    |
| sys:     | 0m 17.69s                | 0m 29.89s   |
| total:   | 1m 27.24s                | 0m 47.842s  |
| cpu:     | 122%                     | 70%         |
| max mem: | 1530 MB                  | 16 MB       |

|          | Python (CPython 3.6.5) | Python (PyPy 5.10.0) | Python (Jython) |
|----------|------------------------|:--------------------:|:---------------:|
| user:    | 0m 25.20s              | 0m 2.84s             | TBD             |
| sys:     | 0m 17.12s              | 0m 12.63s            | TBD             |
| total:   | 0m 55.777s             | 0m 31.325s           | TBD             |
| cpu:     | 75%                    | 49%                  |                 |
| max mem: | 9 MB                   | 61 MB                |                 |

## Strbench
I actually had a lot of trouble coming up with a string benchmark that ran long enough for a good comparison. I was lucky enough to find a fantastic one.
If the original author would like to collaborate with me to update all or most of his old examples, I would be happy to.

*Reference: https://raid6.com.au/~onlyjob/posts/arena/*

### Why?
Strings are manipulated extremely often and this is a fantastic example with a lot of data and a long enough run-time to present more accurate results. Unfortunately, Pypy doesn't work with Python 3 features and so it was omitted from this test. It may also be dropped in all other benchmarks until it supports Python 3. I planned to redeem Java in this benchmark from its poor fate in the older reference benchmark by running it on the latest JVM. Unfortunately, this did not happen. I may look into optimizations in the future, but I would certainly appreciate suggestions.

|          | C++ (GCC 7.3.0) | exec.time.sec | str.size |
|----------|-----------------|---------------|----------|
| user:    | 0m 9.82s        | 0 sec	     | 256 kb   |
| sys:     | 0m 0.00s        | 1 sec		 | 512 kb   |
| total:   | 0m 9.827        | 1 sec		 | 768 kb   |
| cpu:     | 99%             | 1 sec		 | 1024 kb  |
| max mem: | 10 MB           | 1 sec	     | 1280 kb  |
|          |                 | 2 sec	     | 1536 kb  |
|          |                 | 2 sec		 | 1792 kb  |
|          |                 | 3 sec	     | 2048 kb  |
|          |                 | 3 sec	     | 2304 kb  |
|          |                 | 4 sec	     | 2560 kb  |
|          |                 | 5 sec	     | 2816 kb  |
|          |                 | 6 sec	     | 3072 kb  |
|          |                 | 7 sec	     | 3328 kb  |
|          |                 | 8 sec	     | 3584 kb  |
|          |                 | 9 sec	     | 3840 kb  |
|          |                 | 10 sec	     | 4096 kb  |

|          | Java (10.0.1) | exec.time.sec | str.size |
|----------|---------------|---------------|----------|
| user:    | 0m 48.57s     | 0 sec	       | 256 kb   |
| sys:     | 0m 0.04s      | 0 sec		   | 512 kb   |
| total:   | 0m 48.390     | 1 sec	       | 768 kb   |
| cpu:     | 100%          | 3 sec	       | 1024 kb  |
| max mem: | 44 MB         | 4 sec	       | 1280 kb  |
|          |               | 6 sec	       | 1536 kb  |
|          |               | 9 sec	       | 1792 kb  |
|          |               | 12 sec	       | 2048 kb  |
|          |               | 15 sec	       | 2304 kb  |
|          |               | 18 sec	       | 2560 kb  |
|          |               | 22 sec	       | 2816 kb  |
|          |               | 26 sec	       | 3072 kb  |
|          |               | 31 sec	       | 3328 kb  |
|          |               | 36 sec	       | 3584 kb  |
|          |               | 42 sec	       | 3840 kb  |
|          |               | 47 sec        | 4096 kb  |

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