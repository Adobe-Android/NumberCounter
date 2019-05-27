# Lang-Benchmark

### What is it?
This is a repository where I (and possibly others) will be writing small programs to compare a limited number of languages.

I think this is a good reference point even if it holds little practical value and doesn't do enough to serve as a real benchmark.

### Hardware and OS:
- All tests are run on an **AMD Ryzen 7 1700**
- The OS is **Pengwin 0.1-182 (WSL).**

### Supported Programming Languages:
- C++
  - compiled with **g++ 8.3.0** using **-0s**
- C#
  - compiled with **.NET Core SDK 2.2.300 and .NET Core Runtime 2.2.5** using **dotnet build -c Release**
  - run using **dotnet BubbleSort.dll**
- Java
  - compiled with **javac 12.0.1** using **maven package**
  - run using **java -cp target/Strbench-1.0-SNAPSHOT.jar tech.dbrown.App**
- JavaScript
- Python
- Rust (*possibly coming soon*)
  - compiled using **cargo build --release.**

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

|          | C++ (GCC 8.3.0) | exec.time.sec | str.size |
|----------|-----------------|---------------|----------|
| user:    | 0m 10.25s       | 0 sec	     | 256 kb   |
| sys:     | 0m 0.01s        | 1 sec		 | 512 kb   |
| total:   | 0m 10.27s       | 1 sec		 | 768 kb   |
| cpu:     | 99%             | 1 sec		 | 1024 kb  |
| max mem: | 9300 KB         | 1 sec	     | 1280 kb  |
|          |                 | 2 sec	     | 1536 kb  |
|          |                 | 2 sec		 | 1792 kb  |
|          |                 | 3 sec	     | 2048 kb  |
|          |                 | 4 sec	     | 2304 kb  |
|          |                 | 4 sec	     | 2560 kb  |
|          |                 | 5 sec	     | 2816 kb  |
|          |                 | 6 sec	     | 3072 kb  |
|          |                 | 7 sec	     | 3328 kb  |
|          |                 | 8 sec	     | 3584 kb  |
|          |                 | 9 sec	     | 3840 kb  |
|          |                 | 11 sec	     | 4096 kb  |

|          | Java (12.0.1-zulu)    | exec.time.sec | str.size |
|----------|-----------------------|---------------|----------|
| user:    | 0m 55.37s             | 0 sec	       | 256 kb   |
| sys:     | 0m 0.14s              | 0 sec		   | 512 kb   |
| total:   | 0m 55.22s             | 1 sec	       | 768 kb   |
| cpu:     | 100%                  | 3 sec	       | 1024 kb  |
| max mem: | 44096 KB              | 5 sec	       | 1280 kb  |
|          |                       | 7 sec	       | 1536 kb  |
|          |                       | 10 sec	       | 1792 kb  |
|          |                       | 13 sec	       | 2048 kb  |
|          |                       | 17 sec	       | 2304 kb  |
|          |                       | 21 sec	       | 2560 kb  |
|          |                       | 25 sec	       | 2816 kb  |
|          |                       | 30 sec	       | 3072 kb  |
|          |                       | 36 sec	       | 3328 kb  |
|          |                       | 41 sec	       | 3584 kb  |
|          |                       | 48 sec	       | 3840 kb  |
|          |                       | 54 sec        | 4096 kb  |

|          | JavaScript (Node 12.3.1)  | exec.time.sec | str.size |
|----------|---------------------------|---------------|----------|
| user:    | 1m 50.85s                 | 0 sec         | 256 kb   |
| sys:     | 7m 27.15s                 | 6 sec    	   | 512 kb   |
| total:   | 9m 03.98s                 | 17 sec    	   | 768 kb   |
| cpu:     | 102%                      | 31 sec   	   | 1024 kb  |
| max mem: | 177080 KB                 | 50 sec        | 1280 kb  |
|          |                           | 73 sec        | 1536 kb  |
|          |                           | 100 sec   	   | 1792 kb  |
|          |                           | 132 sec       | 2048 kb  |
|          |                           | 167 sec       | 2304 kb  |
|          |                           | 207 sec       | 2560 kb  |
|          |                           | 251 sec       | 2816 kb  |
|          |                           | 300 sec       | 3072 kb  |
|          |                           | 353 sec       | 3328 kb  |
|          |                           | 410 sec       | 3584 kb  |
|          |                           | 473 sec       | 3840 kb  |
|          |                           | 539 sec       | 4096 kb  |

|          | Python (CPython 3.7.3) | exec.time.sec | str.size |
|----------|------------------------|---------------|----------|
| user:    | 5m 07.17s              | 2 sec	        | 256 kb   |
| sys:     | 6m 30.89s              | 9 sec		    | 512 kb   |
| total:   | 11m 38.24s             | 20 sec	    | 768 kb   |
| cpu:     | 99%                    | 37 sec	    | 1024 kb  |
| max mem: | 22968 KB               | 59 sec	    | 1280 kb  |
|          |                        | 86 sec	    | 1536 kb  |
|          |                        | 119 sec	    | 1792 kb  |
|          |                        | 158 sec	    | 2048 kb  |
|          |                        | 204 sec	    | 2304 kb  |
|          |                        | 256 sec	    | 2560 kb  |
|          |                        | 314 sec	    | 2816 kb  |
|          |                        | 378 sec	    | 3072 kb  |
|          |                        | 447 sec	    | 3328 kb  |
|          |                        | 523 sec	    | 3584 kb  |
|          |                        | 605 sec	    | 3840 kb  |
|          |                        | 692 sec       | 4096 kb  |

## BubbleSort
Just your typical BubbleSort.

### Why?
I thought sorting algorithms would make for a good comparison. Where better to start than the classic bubble sort?

|          | C++ (GCC 8.3.0) |
|----------|-----------------|
| user:    | 0m 0.00s        |
| sys:     | 0m 0.00s        |
| total:   | 0m 00.02s       |
| cpu:     | 0%              |
| max mem: | 1500 KB         |

|          | C# (.NET Core Runtime 2.2.5) |
|----------|------------------------------|
| user:    | 0m 0.17s                     |
| sys:     | 0m 0.10s                     |
| total:   | 0m 00.30s                    |
| cpu:     | 92%                          |
| max mem: | 19084 KB                     |

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
