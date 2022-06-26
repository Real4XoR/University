/**
 * abstractdb.hpp
 * C++ header file that should contain declaration for
 * - struct movie (given)
 * - AbstractDbTable abstract class
 * 
 * You need to modify this file to declare AbstractDbTable abstract class 
 * as specified in the hand-out (Task 1)
 */ 



#ifndef __ABSTRACT_DB_HPP__
#define __ABSTRACT_DB_HPP__

#include <string>

using namespace std;



namespace nwen  {
    struct movie {
        unsigned long id;
        char title[50];
        unsigned short year;
        char director[50];
    };

    class AbstractDbTable {
        public:
            virtual unsigned long rows() = 0;
            virtual movie* get(unsigned long row) = 0;
            virtual bool add(movie &mov) = 0;
            virtual bool update(int row, movie movie) = 0;
            virtual bool remove(unsigned long id) = 0;
            
            bool loadCSV(const char* in);
            bool saveCSV(const char* out);
            
            AbstractDbTable() { };           //Constructors for abstract table
            virtual ~AbstractDbTable() { };
    };
}

#endif /* __ABSTRACT_DB_HPP__ */
