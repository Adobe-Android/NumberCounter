# NumberCounter
Each program will be a simple loop counting to 1,000,000. 

More benchmarks on the way!

## Why?
I chose one million as it was a large enough number to help separate the difference between each programming language implementation without being so large that any language took very long.

I also think this is a good reference point even if it holds little value and doesn't do enough to serve as a real benchmark.

### Additional Notes:
All benchmark times are measured with the unix time program which uses m for minutes and s for seconds.

Real, User and Sys process time statistics:

One of these things is not like the other. Real refers to actual elapsed time; User and Sys refer to CPU time used only by the process.

    Real is wall clock time - time from start to finish of the call. This is all time including time used by other processes and time the process spends blocked (for example if it is waiting for I/O to complete).

    User is the amount of CPU time spent in user-mode code (outside the kernel) within the process. This is only actual CPU time used in executing the process. Other processes and time the process spends blocked do not count towards this.

    Sys is the amount of CPU time spent in the kernel within the process. This means executing CPU time spent in system calls within the kernel, as opposed to library code, which is still running in user-space. Like 'user', this is only CPU time used by the process. See below for a brief description of kernel mode (also known as 'supervisor' mode) and the system call mechanism.

*Reference: https://stackoverflow.com/questions/556405/what-do-real-user-and-sys-mean-in-the-output-of-time1* 

The C++ version is compiled with the -03 optimization.

**All tests are run on a Ryzen 7 1700 at 3.6GHz.**

**All tests are run on Ubuntu 18.04.**

|       | C++ (GCC 7.3.0) | JavaScript (Node 8.10.0) |
|-------|-----------------|:------------------------:|
| real: | 0m 1.808s       | 0m 6.525s                |
| user: | 0m 0.256s       | 0m 4.612s                |
| sys:  | 0m 1.259s       | 0m 1.797s                |

|       | C# (.NET Core 2.1.300) | Java (10.0.1) |
|-------|------------------------|:-------------:|
| real: | 0m 5.365s              | 0m 4.887s     |
| user: | 0m 2.723s              | 0m 1.228s     |
| sys:  | 0m 1.805s              | 0m 2.651s     |

|       | Python (CPython 3.6.5) | Python (PyPy 5.10.0) | Python (Jython) |
|-------|------------------------|:--------------------:|:---------------:|
| real: | 0m 4.225s              | 0m 1.771s            | TBD             |
| user: | 0m 2.122s              | 0m 0.314s            | TBD             |
| sys:  | 0m 1.606s              | 0m 1.208s            | TBD             |