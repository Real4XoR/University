/**
 * vectordb.hpp
 * C++ header file that should contain declaration for
 * - VectorDbTable class
 * 
 * You need to modify this file to declare VectorDbTable class 
 * as specified in the hand-out (Task 2)
 */ 

#include <vector>
#include "abstractdb.hpp"

using namespace std;

namespace nwen {
    class VectorDbTable : public AbstractDbTable {
    public:
        movie* get(unsigned long row);
        unsigned long rows();
        bool add(movie &mov);
        bool update(int, movie);
        bool remove(unsigned long id);

        VectorDbTable();
        ~VectorDbTable();
    private:
        std::vector<movie>* vectorMovies; 
    };
}
