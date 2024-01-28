
#ifndef FONCTIONS_H_INCLUDED
#define FONCTIONS_H_INCLUDED

typedef struct Etat Etat;
struct Etat
{
    char *nom;
};

typedef struct instruction instruction;
struct instruction
{
    Etat Si;
    char lettre[10];
    Etat Sj;
};

typedef struct ListEtat ListEtat;
struct ListEtat
{
    Etat etat;
    ListEtat *suivant;
};

typedef struct ListInstruction ListInstruction;
struct ListInstruction
{
    instruction ins;
    ListInstruction *suivant;
};

typedef struct Automate Automate;
struct Automate
{
    char X[50];
    ListEtat *S ;
    Etat S0;
    ListEtat *F;
    ListInstruction *I;
};

ListEtat* insertionEtat(ListEtat *liste,char *nomEtat);
ListInstruction* insertionInst(ListInstruction *liste_I,instruction ins);
int existe(char *nomEtat, ListEtat *et);
int existe_Inst(instruction inst,ListInstruction *l);
int existe_alphabet(char* alphabet,char c);
void lire_automate() ;
void affiche_automate();
void affiche_listInstruction(ListInstruction *p);
void affiche_listEtat(ListEtat * p);
int existe_mot(char* alphabet,char mot[10]);
void afficherAPG();
void afficherAS();
void construireAPG();
void construireAS();

Automate AG ;
Automate APG;
Automate AS;
//int nbreEtats;
 char etatName[20][5];
#endif // FONCTIONS_H_INCLUDED
