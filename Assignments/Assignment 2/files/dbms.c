#include "dbms.h"

#include <stdio.h>
#include <string.h>

/**
 *
 * Name: Nathan Cobbald
 * Student ID: 300574719 
 * Username: cobbalnath
 * 
 */

int db_show_row(const struct db_table *db, unsigned int row) {
    for (int i = 0;i < db->rows_total; i++) {
        printf("    %lu:%.*s:          %.*s:%u\n", 
        db->table[row].id, 
        20, db->table[row].title, 
        20, db->table[row].artist, 
        db->table[row].year
        );
            
        return 1;
    }

    return 0;
}

int db_add_row(struct db_table *db, struct album *a) {

}

int db_remove_row(struct db_table *db, unsigned long id) {
    
}