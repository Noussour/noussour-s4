#ifndef LLC_H_INCLUDED
#define LLC_H_INCLUDED
#include "PILE.h"
#include "NODE.h"

typedef struct pile
{
    struct NODE *donnee; /* La donnée que notre pile stockera. */
    struct pile *precedent; /* Pointeur vers l'élément précédent de la pile. */
} Pile;


struct pile *creerPile();

int Pilevide(struct pile *P);

void empiler(struct pile *(*P),struct NODE *ND);

void Depiler(struct pile *(*P),struct NODE *(*ND));



#endif // LLC_H_INCLUDED
