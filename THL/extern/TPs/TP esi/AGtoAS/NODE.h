#ifndef NODE_H_INCLUDED
#define NODE_H_INCLUDED
#include "PILE.h"
#include "NODE.h"

typedef struct NODE NODE;
struct NODE{
    int init;
    int finale;
    int stat;
    struct NODE *next;
    struct INSTRUCTION *ptrInstru;
};




NODE *AllouerNODE ( );
void Aff_Val_Init(struct NODE *P, int v);
int Valeur_Init( struct NODE *P);
void Aff_Val_Finale(struct NODE *P, int v);
int Valeur_Finale( struct NODE *P);
void Aff_Val_Stat_NODE(struct NODE *P, int v);
int Valeur_Stat_NODE( struct NODE *P);
//void Aff_Adr_LLC_to_NODE( struct NODE *P, struct LLC *Q);
//struct LLC *Valeur_LLC( struct NODE *P);



#endif // NODE_H_INCLUDED
