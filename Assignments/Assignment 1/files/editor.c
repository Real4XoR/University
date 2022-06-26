/**
 * Student id 300574719
 * Name: Nathan Cobbald
 * Username: cobbalnath
 */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "editor.h"

/**
 * Inserts selected character into buffer, then moving the remaning contents to the right
*/

int editor_insert_char (char editing_buffer[], int editing_buflen, char to_insert, int pos) {
    if (pos < 0 || pos >= editing_buflen) {
        return 0;
    }
    // moving all elements past pos to the right
    for (int i = editing_buflen - 1; i > pos; i--) {
        editing_buffer[i] = editing_buffer[i - 1];
    }
    //insetting new element
    editing_buffer[pos] = to_insert;

    return 1;
}


/**
 * Deletes selected character from buffer, then moving the reminaing contents to the left
 */
int editor_delete_char (char editing_buffer[], int editing_buflen, char to_delete, int offset) {
    if (offset < 0 || offset >= editing_buflen) {
        return 0;
    }

    for (int i = offset; i < editing_buflen; i++) {
        if (editing_buffer[i] == to_delete) { // checks of its the character to delete
            for (int j = i; j < editing_buflen; j++) { //moving all elements to the left to fill void
                editing_buffer[j] = editing_buffer[j + 1];
            }
            return 1;
        }
    }
    return 0;
}

/**
 * searches list for the first occurence of the selected character and replaces it with replacement
 */

int editor_replace_str (char editing_buffer[], int editing_buflen, const char *str, const char *replacement, int offset) {
    int str_length = strlen(str);
    int replacement_length = strlen(replacement);
    int length_diff = str_length > replacement_length ? str_length - replacement_length : replacement_length - str_length;
    
    if (offset < 0 || str_length == 0 || offset >= editing_buflen || offset + str_length >= editing_buflen)
        return -1;

    for (int i = offset; i < editing_buflen; i++) {
        unsigned long j;

        //compare the next characters in the string 
        for (j = 0; j < str_length; j++)
            if (editing_buffer[i + j] != str[j])
                break;

        //continue through loop if lengths don't match
        if (j < str_length)
            continue;
        
    }
    
    return -1;
}
