/**
 * abstractdb.cpp
 * C++ source file that should contain implementation for member functions
 * - loadCSV()
 * - saveCSV()
 * 
 * You need to modify this file to implement the above-mentioned member functions
 * as specified in the hand-out (Tasks 4 and 5)
 */ 





// Disclaimer: my code broke and I can't get it to stop giving me a winmain@16 error and im not sure how to fix it so I couldnt do any further testing



#include "abstractdb.hpp"

#include <iostream>
#include <fstream>
#include <cstring>
#include <cstdlib>

using namespace std;

namespace nwen {
    bool AbstractDbTable::loadCSV(const char* in){
        ifstream dataIn;
        if(!in){return false;}// If file name doesn't exist
        dataIn.open(in);
        if(!dataIn.is_open()){ // Checking if file is actually open
            cout<< "Error: File isn't open" <<'\n';
            return false;
        }
            struct movie m;; // Setting up all the temp variables
            string id;
            string title;
            string year;
            string director;
        while(dataIn.good()){ // Check data isn't corrupt
            getline(dataIn,id,',');
            m.id = strtoul(id.c_str(), NULL, 10);// Convert string to unsigned long and set m.id to that value
            getline(dataIn,title,',');
            strcpy(m.title, title.c_str());
            getline(dataIn,year,',');
            m.year = (unsigned short)strtoul(year.c_str(), NULL, 10); // Set m.year to unsigned long after converting it from sting
            getline(dataIn,director,'\n');
            strcpy(m.director, director.c_str());
            add(m);
        }
        bool isEnd = dataIn.eof();// Is it the end if the file input
        dataIn.close();// Closing file
        return isEnd;
        return false;
    }

    bool AbstractDbTable::saveCSV(const char* out){
        FILE *fp = fopen(out, "w"); // Declaring a writable file

        if(fp == NULL) return false; // If file doesn't exist

        unsigned int i = 0;
        while(i < rows()) {
            const struct movie *mov = get(i);
            if(mov == NULL){break;// If theres nothing to write then break loop
            cout << mov->id << ",";
            cout << mov->title << ",";
            cout << mov->year << ",";
            cout << mov->director << endl; // Move onto next line as its the last input needed
            i++;
        }
        fclose(fp);
        return true;
    } 

}
}