#include <stdio.h>
#include <stdlib.h>
#include "PILE.h"



struct pile *creerPile(){
    return (struct pile *) malloc( sizeof(struct pile));
}

int Pilevide(struct pile *P){
    if(P == NULL){
        return 0;
    }else{
        return 1;
    }
};


void empiler(struct pile **P,struct NODE *ND){

    struct pile *element= (struct pile *) malloc( sizeof(struct pile));
    if (element == NULL)  /* If the allocation is failed. */{
        exit(EXIT_FAILURE);
    }
    element->donnee = ND;
    element->precedent = *P;
    *P = element;       /* The pointer points to the last element */
}


void Depiler(struct pile *(*P),struct NODE *(*ND)){
    struct pile *q;

    q=*P;
    *ND = q->donnee;
    *P = q->precedent;
    free(q);
}
