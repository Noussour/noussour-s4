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
    char lettre;
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

ListEtat * etatsAccessibles();
ListEtat * etatscoAccessibles();
ListEtat* insertionEtat(ListEtat *liste,char *nomEtat);
ListInstruction* insertionInst(ListInstruction *liste_I,instruction ins);
ListInstruction* construireI(ListEtat *S);

int existe(char *nomEtat, ListEtat *et);
int existe_Inst(instruction inst,ListInstruction *l);
int existe_alphabet(char* alphabet,char c);

void lire_automate() ;
void affiche_automate_non_red();
void affiche_listInstruction(ListInstruction *p);
void affiche_listEtat(ListEtat * p);
void construire_automate_reduit();
void affiche_automate_red();
void construire_automate_reduit();


Automate automate_non_reduit ;
Automate automate_reduit;
#endif // FONCTIONS_H_INCLUDED
