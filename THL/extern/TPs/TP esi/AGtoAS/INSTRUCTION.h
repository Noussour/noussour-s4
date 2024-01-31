#ifndef INSTRUCTION_H_INCLUDED
#define INSTRUCTION_H_INCLUDED

typedef struct INSTRUCTION INSTRUCTION;
struct INSTRUCTION{
    char *w;
    struct NODE *Sj;
    struct INSTRUCTION *next;
};



struct INSTRUCTION *Allouer ( );
void Aff_Val_w(struct INSTRUCTION *P, char *v);
void Aff_Val_Sj(struct INSTRUCTION *P, struct NODE *v);
void Aff_Adr_INSTRU(struct INSTRUCTION *P,struct INSTRUCTION *Q);
struct INSTRUCTION *Suivant_INSTRU(struct INSTRUCTION *P);
char *Valeur_w(struct INSTRUCTION *P);
struct NODE *Valeur_Sj(struct INSTRUCTION *P);



#endif // INSTRUCTION_H_INCLUDED
