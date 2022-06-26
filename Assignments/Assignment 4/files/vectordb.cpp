/**
 * vectordb.cpp
 * C++ source file that should contain implementation for member functions
 * - rows()
 * - get()
 * - add()
 * - update()
 * - remove()
 * 
 * You need to modify this file to implement the above-mentioned member functions
 * as specified in the hand-out (Task 3)
 */ 




// Disclaimer: my code broke and I can't get it to stop giving me a winmain@16 error and im not sure how to fix it so I couldnt do any firther testing 






#include <cstring>
#include <iostream>

#include "vectordb.hpp"

using namespace std;
using namespace nwen;

unsigned long VectorDbTable::rows() { // Return total number of rows
    return vectorMovies->size();
}
movie* VectorDbTable::get(unsigned long row) {
    if (row >= vectorMovies->size()) {
        return nullptr;
    }
    return &vectorMovies->at(row);
}
bool VectorDbTable::add(movie &mov) { // Add movie to back of table
    try {
        vectorMovies->push_back(mov);
    } catch (exception &e) {
        return false;
    }
    return true;
}
bool VectorDbTable::update(int row, movie m) { // Update movie at specified id
    printf("Test");
    return true;
}
bool VectorDbTable::remove(unsigned long id) { // Remove movie from specified id
    for (unsigned long i = 0; i < vectorMovies->size(); i++) {
        if (vectorMovies->at(i).id == id) {
            vectorMovies->erase(vectorMovies->begin() + i);
            return true;
        }
    }
    return false;
}
VectorDbTable::VectorDbTable() {
    vectorMovies = new vector<movie>;
}

VectorDbTable::~VectorDbTable() {
    delete vectorMovies;
}