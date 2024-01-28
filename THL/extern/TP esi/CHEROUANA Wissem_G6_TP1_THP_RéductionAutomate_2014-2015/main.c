#include <stdlib.h>
#include <string.h>
#include <stdio.h>
#include <windows.h>
#include <ctype.h>
#include"affichage.h"


typedef enum bool bool;
enum bool {false, true};

typedef struct Etat Etat;

struct Etat  /** Structur d'un état **/
{
    int nbEtat; /** nombre d'états **/
    bool Fin; /** Booléen permettant de savoir si un état est final ou non **/
};

typedef struct Instruction  /** La structure Instruction de l'automate **/
{
    Etat Si;   /** Etat initial de l'instruction **/
    char Xi;   /** Alphabet appartenant à X **/
    Etat Sj;   /** Etat final de l'instruction **/
} Instruction;

typedef struct Automate /** Structure d'un automate **/
{
    char ensAlphabet[500]; /** Ensempble d'alphabets **/
    Etat ensEtats[500];   /** Ensemble d'états **/
    Etat ensEtatsFinaux[500]; /** Ensemble d'états finaux **/
    Etat etatInitial; /** Etat initial **/
    Instruction ensInstructions[500]; /** Ensemble des instructions **/

} Automate;

/**** Variables globales ****/
char X [500];
Etat S[500];
Etat S0;
Etat F[500];
Instruction Instrc[500];

int etatAccessible[500];
int nbAccessible;

/** le nombre de predecesseurs par chaque état (a partir de chaque instruction) **/
int nbPre_Etat[500];

/** Les états accessibles et coaccessibles de l'automate original **/
Etat etatCoaccessible[500];
int nbCoaccessible;

void chargement ()
{
    int i=0,j=0,v=0;
    Color(11,16);
    printf ("\t  PATIENTEZ SVP ... ");
    for (i=0; i<=100; i++)
    {
        v = (rand() % (9999));
        printf ("°");
        for (j=0; j<v*999; j++) {}
    }
    printf (" TERMINE");
    Sleep(500);
}

void creerAutomate(Automate *A, int *nbAlphabet, int *nbEtats, int *nbEtatsFinaux, int *nbInstructions)
{
    char c;
    printf(" Veuillez introduire le nombre d'alphabets : ");
    textcolor(10);
    scanf("%d",&(*nbAlphabet));
    textcolor(15);
    int i,j;
    printf(" Veuillez saisir les %d alphabets de votre automate (1 seul caractere)  : \n",*nbAlphabet);
    for (i=0; i<*nbAlphabet; i++)
    {
repAlph:
        printf("    - L'alphabet %d : ",i+1);
        getchar();
        textcolor(10);
        scanf("%c",&c);
        textcolor(15);

        for (j=0; j<strlen(X); j++) /** Boucle permettant de vérifier si il y a des doublons à la lecture des alphabets **/
        {

            if(X[j]==c)  /** Si un alphabet existe déjà **/
            {
                printf("\n Alphabet deja existant !! Veuillez introduire un autre svp !! \n");
                goto repAlph; //Refaire la dernière lecture
            }
        }
        X[i] = c;       /** Remplir l'ensemble de l'alphabet **/
    }

    for(i=0; i<*nbAlphabet; i++)
    {
        (*A).ensAlphabet[i]=X[i];
    }


    int numEtat;
    printf("\n Veuillez introduire le nombre d'etats : ");
zeroEtats:
    textcolor(10);
    scanf("%d",&(*nbEtats));
    textcolor(15);
    if (*nbEtats==0)
    {
        printf(" /!\\ Veuillez entrer un nombre valide différent de zero !!");
        goto zeroEtats;
    }
    int cptIns=1;
    textcolor(15);
    printf("    - L'etat : ");
    textcolor(10);
    printf("S");
    scanf("%d",&S0.nbEtat);
    S[0].nbEtat = S0.nbEtat;
    S[0].Fin=false;
    textcolor(15);
    for (i=1; i<*nbEtats; i++)
    {
repEtat:
        printf("    - L'etat : ");
        textcolor(10);
        printf("S");
        scanf("%d",&numEtat);
        textcolor(15);
        for (j=0; j<cptIns; j++) /** Boucle permettant de vérifier si il y a des doublons **/
        {
            if(S[j].nbEtat == numEtat) // Si un état existe déjà
            {
                printf(" Etat deja existant !! Veuillez introduire un autre svp !! ");
                goto repEtat;
            }
        }
        S[i].nbEtat = numEtat;
        S[i].Fin=false;
        cptIns++;  /** Remplir l'ensemble des états **/
    }

    for(i=0; i<*nbEtats; i++)
    {
        (*A).ensEtats[i]=S[i];
    }

    int existe=0;

    A->etatInitial=S0; /** Mettre à jour l'état initial de l'automate **/

    int s;
    printf("\n Veuillez introduire le nombre d'etats finaux : ");
refaireLec2:
    textcolor(10);
    scanf("%d",&(*nbEtatsFinaux));
    textcolor(15);
    if (*nbEtatsFinaux> *nbEtats)
    {
        printf("\n Attention!! nombre superieur au total d'états :/ ");
        goto refaireLec2;
    }

    cptIns=0;
    for (i=0; i<*nbEtatsFinaux; i++)
    {
        existe=0;
repEtatFinal:
        printf(" L'etat final : ");
        textcolor(10);
        printf("S");
        getchar();
        scanf("%d",&numEtat);
        textcolor(15);
        for (s=0; s<*nbEtats; s++) /** Boucle permettant de vérifier si il y a des doublons **/
        {
            if(S[s].nbEtat == numEtat) existe=1; /** Si un état existe déjà **/
        }
        if (!existe)
        {
            printf("\n Etat inexistant dans l'ensemble des etats ! Veuillez zn saisir un autre : ");
            goto repEtatFinal;
        }

        for (j=0; j<cptIns; j++) /** Boucle permettant de vérifier si il y a des doublons **/
        {
            if(F[j].nbEtat == numEtat) /** Si un état final existe déjà dans l'ensemble des états finaux **/
            {
                printf("\n Etat deja marque final !! Veuillez en saisir un autre !! ");
                goto repEtatFinal;
            }
        }

        F[i].nbEtat = numEtat;
        F[i].Fin=true;
        cptIns++;
    }
    /** Remplir l'ensemble des états finaux **/
    for(i=0; i<*nbEtatsFinaux; i++)
    {
        (*A).ensEtatsFinaux[i]=F[i];
    }

    int ind;
    printf ("\n Veuillez préciser la taille de l'ensemble des instructions de votre automate : ");
    textcolor(10);
    scanf("%d",&(*nbInstructions));
    textcolor(15);
    printf ("\n Veuillez donner l'ensemble des transitions de votre automate : \n ");
    for(i=0; i<*nbInstructions; i++)
    {
        textcolor(10);
        printf("    \n-------- Instruction %d : --------",i+1);
EI:
        textcolor(15);
        printf ("\n     L'etat de depart est Si = S");
        existe=0;

        scanf("%d",&numEtat);
        for (s=0; s<*nbEtats; s++)
        {
            if(S[s].nbEtat == numEtat) /** Si l'état de l'instruction entré existe dans l'ensemble des états **/
            {
                existe=1;
                ind=s;
            }
        }
        if (!existe)
        {
            printf(" Etat inexistant ! Veuillez en saisir un autre : ");
            goto EI;
        }
        else
        {
            Instrc[i].Si.nbEtat=numEtat;
            Instrc[i].Si.Fin=S[ind].Fin;
        }


Alph :
        printf ("     L'alphabet Xi =  ");
        existe=0;
        c=getch();
        printf("%c",c);
        for (s=0; s<*nbAlphabet; s++)
        {
            if(X[s] == c) /** Si l'alphabet entré de l'instructions existe dans l'ensemble d'alphabets **/
            {
                existe=1;
                ind=s;
            }
        }
        if (!existe)
        {
            printf(" Alphabet inexistant ! Veuillez en saisir un autre : ");
            goto Alph;
        }
        else
        {
            Instrc[i].Xi=c;
        }

EF:
        printf ("\n     L'etat d'arrivee est Sj = S");
        existe=0;
        scanf("%d",&numEtat);
        for (s=0; s<*nbEtats; s++)
        {
            if(S[s].nbEtat == numEtat) /** Si l'état d'arrivée saisi de l'instruction figure dans l'ensemble des états de l'automate **/
            {
                existe=1;
                ind=s;
            }
        }
        if (!existe)
        {
            printf(" Etat inexistant ! Veuillez en saisir un autre : ");
            goto EF;
        }
        else
        {
            Instrc[i].Sj.nbEtat=numEtat;
            Instrc[i].Sj.Fin=S[ind].Fin;
        }
    }

    /** Remplissage de l'ensemble des instructions **/

    for(i=0; i<*nbInstructions; i++)
    {
        A->ensInstructions[i]=Instrc[i];
    }
}

void afficheAutomate(Automate A, int a, int b, int c, int d) /** Procédure permettand d'afficher les 5-uplets de l'automate **/
{
    int i;
    printf(" L'etat initial est : ");
    textcolor(11);
    printf("S%d ", A.etatInitial.nbEtat );

    textcolor(15);
    printf(" \n\n L'ensemble de l'alphabet est : ");
    textcolor(11);
    printf("X = { ");
    for (i=0; i<a-1; i++)
        printf("%c , ", A.ensAlphabet[i]);
    printf("%c }", A.ensAlphabet[a-1]);
    textcolor(15);
    printf(" \n\n L'ensemble d'états est : "); //Afficher l'ensemble d'états
    textcolor(11);
    printf("S = { ");
    for (i=0; i<b-1; i++)
    {
        printf("S%d , ", A.ensEtats[i].nbEtat);
    }
    printf("S%d }", A.ensEtats[b-1].nbEtat);
    textcolor(15);
    printf("\n\n L'ensemble d'états finaux est : ");
    textcolor(11);
    printf(" F = { ");
    if (c==0)
    {
        printf(" }");
        goto label;
    }
    for (i=0; i<c-1; i++)
    {
        printf("S%d , ", A.ensEtatsFinaux[i].nbEtat);
    }
    printf("S%d }", A.ensEtatsFinaux[c-1].nbEtat);
label:
    textcolor(15);
    printf(" \n\n L'ensemble des instructions est : ");
    textcolor(11);
    printf("I = { ");
    for (i=0; i<d-1; i++)
    {
        printf("(S%d, %c, S%d) ", A.ensInstructions[i].Si.nbEtat, A.ensInstructions[i].Xi, A.ensInstructions[i].Sj.nbEtat);
    }
    printf("(S%d, %c, S%d) } ", A.ensInstructions[d-1].Si.nbEtat, A.ensInstructions[d-1].Xi, A.ensInstructions[d-1].Sj.nbEtat) ;
}

int RangAlphabet(char c) /** Fonction qui retourne le rang de l'alphabet d'une instruction par rapport à l'ensemble d'alphabets de l'automate **/
{
    int i,j;
    for (i=0; i<500; i++)
    {
        if(X[i]==c) /** Si un alphabet de l'ensemble X correspond à l'alphabet cherché ==> retourner le rang de cet alpahebt dans X **/
        {
            j=i;
        }

    }
    return j;
}

void RepMatricielle(Automate A, int matrice[500][500], int nbAlphabet, int nbEtats ) /** Procédure permettant de remplir la table de transitions **/
{
    int i,j,rang;

    for (i=0; i<nbEtats; i++)
    {
        for (j=0; j<nbAlphabet; j++)
        {
            matrice[i][j]=-1; /**Affecter des -1 à toutes les cellules du tableau **/
        }
    }

    for(i=0; i<nbEtats*nbAlphabet; i++)
    {
        rang=RangAlphabet(Instrc[i].Xi);
        matrice[Instrc[i].Si.nbEtat][rang]=Instrc[i].Sj.nbEtat; /** Affecter un état d'arrivée à chaque cellule du tableau **/
    }


}

void afficher_en(Automate A , int matrice [500][500],int nbalpha, int nbetat) /** Affichage de la table de transitions **/
{
    system("cls");
    Color(11,16);
    printf("\n                                       =============> REPRESENTATION MATRICIELLE DE L'AUTOMATE <=============   ");

    textcolor(15);
    int m,y,x;
    for (y= 0; y<nbetat+1; y++)
    {
        printf("\n%c",218);
        for (m=0; m<4; m++)      printf("%c",196);
        printf("%c",191);
        for(x=0; x<nbalpha; x++)
        {
            printf("%c",218);
            for (m=0; m<4; m++)      printf("%c",196);
            printf("%c",191);//
        }
        printf("\n%c",179);
        printf("    ");
        printf("%c",179);
        for(x=0; x<nbalpha; x++)
        {
            printf("%c    %c",179,179);//
        }

        for (m=0; m<4; m++)      printf(" ");

        printf("\n%c",192);

        for(x= 0; x<nbalpha; x++)
        {
            for (m=0; m<4; m++)      printf("%c",196);
            printf("%c",217);
            printf("%c",192);//
        }


        for (m=0; m<4; m++)      printf("%c",196);
        printf("%c",217);
    }
    printf("\n");
    int dep = 2;
    gotoxy( 2,3);
    for(m=1; m<nbalpha+1; m++)
    {
        dep=dep+6;
        gotoxy( dep,wherey());
        printf("%c",A.ensAlphabet[m-1]);
    }
    gotoxy(2,6);
    dep = 6;
    x= wherex();

    for(m=1; m<nbetat+1; m++)
    {
        printf("S%d",m-1);
        dep = dep + 3;
        gotoxy(x,dep);
    }
    dep =8;
    gotoxy( 8,6);
    for(m=0; m<nbetat; m++)
    {
        for(x= 0; x<nbalpha; x++)
        {
            if (matrice[m][x]==-1) printf("%d",matrice[m][x]);
            else                   printf("S%d",matrice[m][x]);

            dep = dep+6;
            gotoxy( dep,wherey());
        }
        dep = 8;
        gotoxy( 8,wherey()+3);

    }
    printf("\n\n\n\n");

}

bool existeAcc(int etat) /** fonction permettant de verifier si un état est accessible ou non **/
{
    int i = 0;
    while(i<nbAccessible)
    {
        if(etatAccessible[i]==etat) return true;
        i++;
    }
    return false;
}

void accessible(int nbInstructions) /** Préocédure permettant de trouver les états accessibles d'un automate donné **/
{

    etatAccessible[0]= S0.nbEtat; /** L'état initial de l'automate est toujours accessible **/
    nbAccessible = 1; /** au moins l'état initial **/
    int i,j=0,k;
    /** Avoir les successeurs de tous les etats accessibles qui sont des nouveaux états accessibles **/
    while(j<nbAccessible)
    {
        for (i=0; i<nbInstructions; i++)
        {
            /** Avoir les successeurs d'un état accessible qui sont des nouveaux états accessibles **/
            if((Instrc[i].Si.nbEtat==etatAccessible[j])&&(Instrc[i].Si.nbEtat!=Instrc[i].Sj.nbEtat)) /** Si l'état est accessible et il n'y a pas de boucle (Si!=Sj)**/
            {

                {
                    if((Instrc[i].Sj.nbEtat!=S0.nbEtat)&&(!existeAcc(Instrc[i].Sj.nbEtat)))
                        /** Si l'état n'est pas l'état initial et n'a pas été déjà marqué comme étant un état accessible **/
                    {
                        etatAccessible[nbAccessible]= Instrc[i].Sj.nbEtat; /** l'état d'arrivée de l'instruction est un nouveau état accessible **/
                        nbAccessible ++; /** Incrémenter le nombre d'éttas accseeibles **/
                    }
                }

            }
        }
        j++;
    }
    /** Affichage du nombre ainsi que les éttas accessibles de l'automate **/

    printf("\n\n Le nombre des etats accessibles est :");
    textcolor(10);
    printf(" %d",nbAccessible);
    textcolor(15);

    printf("\n\n Les etats accessibles sont : ");
    textcolor(10);
    printf("{ ")   ;
    for(i=0; i<nbAccessible-1; i++)
    {
        printf("S%d , ",etatAccessible[i]);
    }
    printf("S%d }",etatAccessible[nbAccessible-1]);
    printf("\n\n");
    textcolor(15);
}

void calculNbPre_Etats(int nbInstructions)
{
    int i;
    for(i=0; i<nbInstructions; i++)
    {
        nbPre_Etat[Instrc[i].Sj.nbEtat] ++;
    }
}


bool existeCoacc(int etat) /**Si un état est co-accessible ou non **/
{
    int i = 0;
    while(i<nbCoaccessible)
    {
        if(etatCoaccessible[i].nbEtat==etat) return true;
        i++;
    }
    return false;
}

void coaccessible(int nbInstructions, int nbEtatsFinaux) /**Procédure permettant de trouver les états coaccessible en se basant sur les états accessibles déjà trouvés **/
{
    int i,j=0,k;
    nbCoaccessible = 0;
    /** Tous les états finaux sont coaccessibles **/
    for (i = 0; i<nbEtatsFinaux; i++)
    {
        if(existeAcc(F[i].nbEtat)) /** Si un état final est accessible (pour éviter de refaire le travail d'accessibilité **/
        {
            etatCoaccessible[nbCoaccessible] = F[i]; /**Marquer l'état final comme étant un état coaccessible **/
            nbCoaccessible++;
        }
    }
    /** calcul du nombre de predecesseurs pour chaque état **/
    calculNbPre_Etats(nbInstructions);
    /** Avoir les prédecesseurs de tous les etats coaccessibles qui sont des nouveaux états coaccessibles **/
    while(j<nbCoaccessible)
    {
        for (i=0; i<nbInstructions; i++)
        {
            /** Avoir les prédecésseurs d'un etat coaccessible qui sont des nouveaux états coaccessibles **/
            if((Instrc[i].Sj.nbEtat==etatCoaccessible[j].nbEtat)&&(Instrc[i].Si.nbEtat!=Instrc[i].Sj.nbEtat)&&existeAcc(Instrc[i].Si.nbEtat))
            {
                for(k = 0; k<nbPre_Etat[j]; k++)
                {
                    if((!existeCoacc(Instrc[i].Si.nbEtat))) /** Si un état de départ ne figure pas dans les étas access/coaccess déjà définis **/
                    {
                        etatCoaccessible[nbCoaccessible].nbEtat=  Instrc[i].Si.nbEtat; /** ajouter ce dernier **/
                        etatCoaccessible[nbCoaccessible].Fin=Instrc[i].Si.Fin;
                        nbCoaccessible ++;
                    }
                }

            }
        }
        j++;
    }
    printf("\n\n Le nombre d'etats accessibles et coaccessibles: ");
    textcolor(10);
    printf(" %d",nbCoaccessible);
    textcolor(15);
    printf("\n\n Les etats accessibles et coaccessibles: ");
    textcolor(10);
    printf("{ ")   ;
    for(i=0; i<nbCoaccessible-1; i++)
    {
        printf("S%d , ",etatCoaccessible[i].nbEtat);
    }
    printf("S%d }", etatCoaccessible[nbCoaccessible-1].nbEtat);
    textcolor(15);
    printf("\n\n Appuyer sur n'importe quelle touche pour afficher l'automate reduit ! \n\n\n");
    getch();
}


bool alphabetExist(Automate A, char alphabet) /** Permet de vérifier si un alphabet existe **/
{
    int i=0;
    bool p=false;
    while(i<strlen(A.ensAlphabet))
    {
        if(A.ensAlphabet[i]==alphabet) p=true;
        i++;
    }
    return p;
}

void automate_reduit(Automate *A, int nbInstructions)
{
    int cpt=0;

    int i = 0;
    bool trouv =false;
    while((i<nbCoaccessible)&&(!trouv))
    {
        if (etatCoaccessible[i].nbEtat==S0.nbEtat) trouv =true;
        i++;
    }
    if(!trouv)   printf("\n\nL'automate n'as pas d'etat initial donc elle ne genere aucun mot");
    else
    {

        int j=0;
        printf("\n\n L'etat initial est : ");
        textcolor(11);
        printf(" S%d",S0.nbEtat);
        textcolor(15);
        A->etatInitial=S0;
        printf("\n\n L'ensemble des etats de l'automate reduit est : ");
        textcolor(11);
        printf("{ ");

        for(i = 0; i<nbCoaccessible; i++)
        {
            A->ensEtats[i]=etatCoaccessible[i];
            if (A->ensEtats[i].Fin==true)
            {
                A->ensEtatsFinaux[j]=A->ensEtats[i];
                j++;
            }

        }


        for(i = 0; i<nbCoaccessible-1; i++)
        {
            printf("S%d , ",A->ensEtats[i].nbEtat);
        }
        printf("S%d }", A->ensEtats[nbCoaccessible-1].nbEtat );
        textcolor(15);
        printf("\n\n L'ensemble des états finaux de l'automate réduit est : "),
               textcolor(11);
        printf("{ ")   ;
        for(i = 0; i<j-1; i++)
        {
            printf("S%d , ",A->ensEtatsFinaux[i].nbEtat);
        }
        printf("S%d }", A->ensEtatsFinaux[j-1].nbEtat );


        textcolor(15);
        for(i= 0; i<nbCoaccessible; i++)
        {
            A->ensEtats[nbCoaccessible].nbEtat = etatCoaccessible[i].nbEtat;
        }
        printf("\n\n L'ensemble des instructions de l'automate reduit : ");

        textcolor(11);
        printf("{ ");  /** Définir les instructions et l'alphabet **/
        int s=0;
        for(i =0; i<nbInstructions; i++)
        {
            if(existeCoacc(Instrc[i].Si.nbEtat)&&(existeCoacc(Instrc[i].Sj.nbEtat)))
            {
                /** ajouter l'instruction a l'ensemble des instructions de l'automate réduit **/
                A->ensInstructions[cpt].Si.nbEtat=Instrc[i].Si.nbEtat;
                A->ensInstructions[cpt].Sj.nbEtat=Instrc[i].Sj.nbEtat;
                A->ensInstructions[cpt].Xi=Instrc[i].Xi;
                printf("(S%d, %c, S%d) ",A->ensInstructions[cpt].Si.nbEtat,A->ensInstructions[cpt].Xi,A->ensInstructions[cpt].Sj.nbEtat);
                if (!(alphabetExist(*A,A->ensInstructions[cpt].Xi)))
                {
                    A->ensAlphabet[s]=A->ensInstructions[cpt].Xi;
                    s++;
                }
                cpt ++;
            }
        }
        printf("}");



        textcolor(15);

        printf("\n\n L'ensemble de l'alphabet est : ");
        textcolor(11);
        printf("{ ");
        for (i=0; i<s-1; i++)
            printf("%c , ", A->ensAlphabet[i]);
        printf("%c }", A->ensAlphabet[i]);
    }
    textcolor(15);


}



int main()
{
    int    menuw=0;
    int choix=1;

    hell();



    Automate A,B;
    int a,b,c,d, matrice[500][500];
    Etat etatsAccesible[500];


    do
    {
        system("cls");
        printf("         \n");
        Color(15,16);
        printf("       -->  Veuillez faire un choix dans le menu suivant :\n\n") ;
        decor();
        choix=Choisir_Option();
        system("cls");


        switch(choix)
        {
        case 1:
            system("cls");
            Color(11,16);
            printf("\n                                       =============> CREATION D'UN AUTOMATE <=============   \n\n ");
            printf(" \n\n\n");
            textcolor(15);
            creerAutomate(&A,&a,&b,&c,&d);
            printf("\n\n\n");
            chargement();
            printf("\n\n\n");
            textcolor(15);
            printf("\n\n  Operation terminee avec succes :)\n\n");
            returnToMenu();
            printf("\n\n\n");
            break;
        case 2:
            system("cls");
            Color(11,16);
            printf("\n                                      =============> AFFICHAGES DE L'AUTOMATE <=============   \n\n ");
            printf(" \n\n\n");
            textcolor(15);
            afficheAutomate(A,a,b,c,d);
            printf("\n\n\n");
            textcolor(15);
            returnToMenu();
            printf("\n\n\n");
            break;

        case 3:
            system("cls");
            Color(11,16);
            printf("\n                                       =============> REPRESENTATION MATRICIELLE DE L'AUTOMATE <=============   \n\n ");
            printf(" \n\n\n");
            textcolor(15);
            RepMatricielle(A,matrice,a,b);
            afficher_en(A,matrice,a,b);
            printf("\n\n\n");
            textcolor(15);
            returnToMenu();
            printf("\n\n\n");
            break;
        case 4:
            system("cls");
            Color(11,16);
            printf("\n                                       =============> REDUCTION DE L'AUTOMATE <=============   \n\n ");
            printf(" \n\n\n");
            textcolor(15);
            accessible(d);
            coaccessible(d,c);
            automate_reduit(&B,d);
            printf("\n\n\n");
            textcolor(15);
            returnToMenu();
            printf("\n\n\n");
            break;

        case 5:
            printf("\n\n\n\n");
            the_end();
            printf("\n\n\n\n");
            system("pause");
            break;
        }

    }
    while(choix != MAX_CHOIX);

    return EXIT_SUCCESS;


}
