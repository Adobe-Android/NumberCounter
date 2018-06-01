# NumberCounter
Each program will be a simple loop counting to 1,000,000.

## Why?
I chose one million as it was a large enough number to help separate the difference between each programming language implementation without being so large that any language took very long.

I also think this is a good reference point even if it holds little value and doesn't do enough to serve as a real benchmark.

### Additional Notes:
All benchmark times are measured with the unix time program which uses m for minutes and s for seconds.

The C++ version is compiled with the -02 optimization.

**All tests are run on a Ryzen 7 1700 at 3.6GHz.**

| C++ (GCC 7.3.0) | JavaScript (Node 8.10.0) | Python 3.6.5        |
|-----------------|:------------------------:| -------------------:|
| real: 0m 3.014s | real: 0m 6.525s          | real    0m 4.225s   |
| user: 0m 0.299s | user: 0m 4.612s          | user    0m 2.122s   |
| sys:  0m 1.248s | sys:  0m 1.797s          | sys     0m 1.606s   |

| Python (PyPy 5.10.0) | TBD                 | TBD                 |
|----------------------|:-------------------:| -------------------:|
| real: 0m 1.771s      | TBD                 | TBD                 |
| user: 0m 0.314s      | TBD                 | TBD                 |
| sys:  0m 1.208s      | TBD                 | TBD                 |