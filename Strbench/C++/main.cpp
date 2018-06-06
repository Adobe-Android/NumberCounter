#include <iostream>
#include <string>
#include <time.h>

int main()
{
    std::string str = "abcdefgh";
    str += "efghefgh";
    int iterator_max = 1024 / str.length() * 1024 * 4;
    time_t current_time = time(NULL);
    std::cout << "exec.time.sec\tstr.size" << std::endl;

    std::string find = "efgh";
    std::string replace = "____";
    std::string new_string;
    int iterator = 0;
    int length;
    // int end=0;
    // size_t end=0;

    while (iterator++ < iterator_max + 1000)
    {
        new_string += str;
        new_string = new_string;
        size_t start, size_search = find.size(), end = 0;

        while ((start = new_string.find(find, end)) != std::string::npos)
        {
            end = start + size_search;
            new_string.replace(start, size_search, replace);
        }
        length = str.length() * iterator;
        if ((length % (1024 * 256)) == 0)
        {
            std::cout << time(NULL) - current_time << " sec\t\t" << length / 1024 << "kb" << std::endl;
        }
    }
    // std::cout << new_string << std::endl;

    return 0;
}