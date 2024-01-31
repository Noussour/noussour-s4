#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "function.h"
#include "INSTRUCTION.h"
#include "NODE.h"
#include "PILE.h"

struct NODE *Tete;
struct INSTRUCTION *I;
int ID_init, Final[99], ID_FINAL = 0, nbr_Etats = 0, ID_word = 0,ID_ALPHABET = 0;
char *word[99] ;
char alphabet[99];


int main()
{
    int stop = 0;
    char c;
    printf("\n\n\n\n\t NOTA : \"Le mot vide est représenté par le symbole << $ >> !!!!\n\n\n\n");
    system("pause");
    system("cls");
    printf("Donner l'alphabet de Votre automate generalise \"entrer '+' pour arreter\" : \n\n");
    while(stop != -1){
        printf("\t Alphabet[%d] = ",ID_ALPHABET);
        c = getchar();
        while (getchar() != '\n');
        if(c == '+'){
            stop = -1;
        }else{
            alphabet[ID_ALPHABET] = c;
            ID_ALPHABET++;
        }
    }
    printf("   Donner le nombre d'etats de Votre automate generalise : ");
    scanf("%d",&nbr_Etats);
    creatNode(nbr_Etats);
    Afficher_Ensemble_Etat();
    Etat_Initiale();
    Etat_Fineaux();
    Transition();
    system("pause");
    system("cls");
    Afficher_AG();
    //Alpha();
    PartGeneraliste();
    Afficher_APG();
    AS();
    Afficher_AS();
    return 0;
}

void creatNode(int nbr)
{

    int i = 0;
    struct NODE *N, *R;

    for(i = 0 ; i < nbr ; i++)
    {
        N = AllouerNODE();
        N->finale = 0;
        N->init = 0;
        N->stat = i;
        N->next = NULL;
        N->ptrInstru = NULL;
        if(i == 0) Tete = N;
        else R->next = N;
        R = N;
    }

}

void Afficher_Ensemble_Etat()
{
    struct NODE *node;
    printf("\n     L'ensemble des Sommets de votre Automate Generalise est :\n");
    printf("\t S = {");
    node = Tete;
    while(node != NULL)
    {
        printf(" S%d", Valeur_Stat_NODE(node));
        if( node->next != NULL ) printf(", ");
        node = node->next;
    }
    printf("}.");
}

void Etat_Initiale()
{
    int num, j = 0;
    struct NODE *N;
    N = Tete;
    printf("\n\n     Choisir l'etat initiale (juste le numero de l'etat) :   S");
    scanf("%d",&num);
    ID_init = num;
    for(j = 0 ; j<num ; j++)
    {
        N = N->next;
    }
    if(N != NULL) N->init = 1;
};

void Etat_Fineaux()
{
    int num = 0, nbr = 0, i = 0, j = 0;
    struct NODE *N;
    N = Tete;
    printf("\n\n     Combien d'etats fineaux voulez-vous ?   ==>  nombre d'etat(s) = ");
    scanf("%d",&nbr);
    for(i = 0 ; i < nbr ; i++)
    {
        printf("\n\n     Choisir l'etat finale (juste le numero de l'etat) :   S");
        scanf("%d",&num);
        for(j = 0 ; j<num ; j++)
        {
            N = Suivant_NODE(N);
        }
        if(N != NULL)
        {
            N->finale = 1;
            Final[ID_FINAL] = num;
            ID_FINAL++;
        }
    }
};

void Transition()
{

    char *mot;
    struct INSTRUCTION *instru1, *instru2;
    struct NODE *P, *Q;
    int nbr_Transition = 0,j = 0 , k = 0, sommet;
    instru1 = NULL;
    instru2 = NULL;
    mot = NULL;
    P = Tete;

    printf("\n NOTA : \"Le mot vide se représente par le symbole << $ >> !!!!\n\n");
    while(P != NULL)
    {
        Q = Tete;
        printf("\n\n     Combien de transitions voulez vous faire a partir du noeud S%d : ",P->stat);
        scanf("%d",&nbr_Transition);
        for(j = 0 ; j < nbr_Transition ; j++)
        {
            instru1 = Allouer();
            Aff_Adr_INSTRU(instru1,NULL);
            //do{
                printf("\tMot :  ");
                scanf("%s",&mot);
           // }while(verifiication(mot) == 1);
            Aff_Val_w(instru1,mot);
            word[ID_word] = mot;
            ID_word++;
            printf("\tVers : S");
            scanf("%d",&sommet);
            for(k = 0 ; k < sommet; k++)
                Q = Suivant_NODE(Q);
            instru1->Sj = Q;
            if( j == 0)
            {
                I = instru1;
            }
            else
            {
                Aff_Adr_INSTRU(instru2,instru1);
            }
            instru2 = instru1;
            Q = Tete;
        }
        P->ptrInstru = I;
        I = NULL;
        P = Suivant_NODE(P);
    }
}

int verifiication(char *s){

    int result = 1, i = 0, j = 0, stop = 0;
    char c[0];

    while(exist(&s[i]) == 1 && i < strlen(&s)){
        i++;
    }
    if( i == strlen(&s)) result = 1;
    return result;
}
void Afficher_AG()
{

    char *mot;
    struct INSTRUCTION *instru;
    struct NODE *T, *F;
    int i = 0;

    printf("\n\t\tAG< X* , S , S0 , F , I >");
    printf("\n\n\n\t\tNota : M inclus danx X*.\n\n");
    printf("\tM = {");
    for( i = 0 ; i < ID_word ; i++)
    {
        printf(" %s",&word[i]);
        if(i != (ID_word - 1)) printf(",");
    }
    printf(" }\n\n");
    i = 0;
    printf("\tS = {");
    for( i = 0 ; i < nbr_Etats ; i++)
    {
        printf(" S%d",i);
        if(i != (nbr_Etats - 1)) printf(",");
    }
    printf(" }\n\n");
    printf("\tS0 = {");
    printf(" S%d",ID_init);
    printf(" }\n\n");
    i = 0;
    printf("\tSF = {");
    for( i = 0 ; i < ID_FINAL ; i++)
    {
        printf(" S%d",Final[i]);
        if(i != (ID_FINAL - 1)) printf(",");
    }
    printf(" }\n\n");
    T = Tete;
    printf("\tI = {");
    while(T != NULL)
    {
        instru = T->ptrInstru;
        while( instru != NULL)
        {
            F = instru->Sj;
            printf(" S%d%sS%d",T->stat,&(instru->w),F->stat);
            if(instru->next != NULL) printf(",");
            instru = instru->next;
        }
        T = T->next;
    }
    printf(" }\n\n");
}

int exist(char *c)
{
    int i = 0 , boolean = 0;

    while(i < ID_ALPHABET && boolean == 0)
    {
        if(alphabet[i] == c)
        {
            boolean = 1;
        }
        i++;
    }
    return boolean;
}

void PartGeneraliste()
{
    struct INSTRUCTION *Ins, *I, *K, *M, *S;
    char *mot , kalima[20], *mot2;
    struct NODE *G, *N, *L;
    int i = 0, j = 0;

    G = NULL;
    G = Tete;
    while(G != NULL)
    {
        Ins = G->ptrInstru;
        S = NULL;
        while(Ins != NULL)
        {
            mot = &(Ins->w);
            if(strlen(mot) == 1)
            {
                S = Ins;
                Ins = Ins->next;
            }
            else
            {
                N = G;
                while(N->next != NULL) N = N->next;
                L = AllouerNODE();
                N->next = L;
                L->finale = 0;
                L->init = 0;
                L->next = NULL;
                L->stat = nbr_Etats;
                nbr_Etats++;
                K = Ins;
                M = Ins->next;
                I = Allouer();
                if(S != NULL) S->next = I;
                I->next = M;
                I->Sj = L;
                I->w = mot[0];
                L->ptrInstru = K;
                K->next = NULL;
                Ins = I;
                if(K == G->ptrInstru)   G->ptrInstru = I;
                mot2 = &(K->w);
                j = 0;
                for (j = 1; j < strlen(mot2); j++) kalima[j-1] = mot2[j];
                kalima[j-1] = '\0';
                strcpy(&(K->w),kalima);
                sprintf(kalima,"");
                S = Ins;
                Ins = Ins->next;
            }
        }
        G = G->next;
    }
}

void Afficher_APG()
{

    char *mot;
    struct INSTRUCTION *instru;
    struct NODE *T, *F;
    int i = 0;


    printf("\n\t\tAPG< X U {$} , S , S0 , IF , II >");
    printf("\n\n");
    printf("\tX U {$} = { $,");
    for( i = 0 ; i < ID_ALPHABET ; i++)
    {
        printf(" %c",alphabet[i]);
        if(i != (ID_ALPHABET - 1)) printf(",");
    }
    printf(" }\n\n");
    i = 0;
    printf("\tS = {");
    for( i = 0 ; i < nbr_Etats ; i++)
    {
        printf(" S%d",i);
        if(i != (nbr_Etats - 1)) printf(",");
    }
    printf(" }\n\n");
    printf("\tS0 = {");
    printf(" S%d",ID_init);
    printf(" }\n\n");
    i = 0;
    printf("\tSF = {");
    for( i = 0 ; i < ID_FINAL ; i++)
    {
        printf(" S%d",Final[i]);
        if(i != (ID_FINAL - 1)) printf(",");
    }
    printf(" }\n\n");
    T = Tete;
    printf("\tI = {");
    while(T != NULL)
    {
        instru = T->ptrInstru;
        while( instru != NULL)
        {
            F = instru->Sj;
            printf(" S%d%sS%d",T->stat,&(instru->w),F->stat);
            if(instru->next != NULL) printf(",");
            instru = instru->next;
        }
        if(T->next != NULL) printf(",");
        T = T->next;
    }
    printf(" }\n\n");
}

void AS()
{

    struct pile *pile;
    struct INSTRUCTION *Ins, *I, *K, *M, *S;
    char *mot , kalima[20], *mot2;
    struct NODE *G, *N, *L;
    int i = 0, j = 0, do_it = 0;

    pile = NULL;

    empiler(&pile,NULL);
    G = Tete;
    if(G->next != NULL)
    {
        empiler(&pile,G);
        G = G->next;
    }

    while(G != NULL)
    {
        Ins = G->ptrInstru;
        S = NULL;
        M = NULL;
        while(Ins != NULL)
        {
            if(strcmp(&(Ins->w),"$") == 0)
            {
                N = Ins->Sj;
                if(N->finale == 1)
                {
                    G->finale = 1;
                    Final[ID_FINAL] = G->stat;
                    ID_FINAL++;
                }
                I = N->ptrInstru;
                K = Ins->next;
                if(S == NULL)
                {
                    G->ptrInstru = K;
                }
                else if( K != NULL) S->next = K;
                else S->next = I;
                free(Ins);
                Ins = K;
                M = K;
                while( do_it == 0 && K != NULL)
                {
                    M = K;
                    K = K->next;
                    if(M == I) do_it = 1;
                }
                if(do_it == 0 && M != NULL && N != G) M->next = I;
                if(M == NULL && Ins != NULL)
                {
                    if(S != NULL) S->next = I;
                    else G->ptrInstru = I;
                }
                do_it = 0;

            }
            else
            {
                S = Ins;
                Ins = Ins->next;
            }
        }
        Depiler(&pile,&G);

    }
}

void Afficher_AS()
{

    char *mot;
    struct INSTRUCTION *instru;
    struct NODE *T, *F;
    int i = 0;


    printf("\n\t\tAS< X , S , S0 , IF , II >");
    printf("\n\n");
    printf("\tX = {");
    for( i = 0 ; i < ID_ALPHABET ; i++)
    {
        if(alphabet[i] != '$')
        {
            printf(" %c",alphabet[i]);
            if(i != (ID_ALPHABET - 1)) printf(",");
        }
    }
    printf(" }\n\n");
    i = 0;
    printf("\tS = {");
    for( i = 0 ; i < nbr_Etats ; i++)
    {
        printf(" S%d",i);
        if(i != (nbr_Etats - 1)) printf(",");
    }
    printf(" }\n\n");
    printf("\tS0 = {");
    printf(" S%d",ID_init);
    printf(" }\n\n");
    i = 0;
    printf("\tSF = {");
    for( i = 0 ; i < ID_FINAL ; i++)
    {
        printf(" S%d",Final[i]);
        if(i != (ID_FINAL - 1)) printf(",");
    }
    printf(" }\n\n");
    T = Tete;
    printf("\tI = {");
    while(T != NULL)
    {
        instru = T->ptrInstru;
        while( instru != NULL)
        {
            F = instru->Sj;
            printf(" S%d%sS%d",T->stat,&(instru->w),F->stat);
            if(instru->next != NULL) printf(",");
            instru = instru->next;
        }
        if(T->next != NULL) printf(",");
        T = T->next;
    }
    printf(" }\n\n");
}
