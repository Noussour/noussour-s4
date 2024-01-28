#include <stdio.h>
#include <stdlib.h>
#include "PILE.h"
#include "NODE.h"
#include "INSTRUCTION.h"

struct NODE *AllouerNODE(){
    return ((struct NODE *) malloc( sizeof(struct NODE)));
}

void Aff_Val_Init(struct NODE *P, int v);

void Aff_Val_Init(struct NODE *P, int v) {
    P->init = v;
}

int Valeur_Init( struct NODE *P){
    return( P->init) ;
}

void Aff_Val_Finale(struct NODE *P, int v){
    P->finale = v;
}

int Valeur_Finale( struct NODE *P){
    return( P->finale) ;
}

void Aff_Val_Stat_NODE(struct NODE *P, int v){
    P->stat = v;
}

int Valeur_Stat_NODE( struct NODE *P){
    return( P->stat) ;
}

void Aff_Adr_NODE( struct NODE *P, struct NODE *Q){
    P->next = Q;
}

struct NODE *Suivant_NODE(struct NODE *P){
    return( P->next );
}
