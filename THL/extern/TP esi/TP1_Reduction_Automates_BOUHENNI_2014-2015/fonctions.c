#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"
#include <string.h>

///********************************************************************************************************//
/// **************** la fonction existe() verifie si un etat **********************************************//
///****************** "Sj" existe deja dans la liste des etats "et" ***************************************//
///********************************************************************************************************//
int existe(char *nomEtat, ListEtat *et)
{
    while(et!=NULL) // parcourir la liste des etats
    {
        if((strcmp(nomEtat,et->etat.nom))==0) // comparer les noms des etats
                                 //de "et" avec le nom des l'etat à l'entrée
        {
            return 1; // si on trouve qu'il y a dans la liste un etat portant le meme nom on retourne vraie "1"
        }

        et=et->suivant; // pour passer au prochain etat dans la liste
    }

    return 0; // on a parcouru toute la liste sans trouver l'etat qu'on cherche
              // donc, on retourne faux "0"
}

///********************************************************************************************************//
///***************** la fonction insertionEtat insere un etat donné dans la liste des etats dans l'entrée**//
///****************** et retourne la tete de la liste mise à jour *****************************************//
///********************************************************************************************************//

ListEtat* insertionEtat(ListEtat *liste,char *nomEtat)
{
    ListEtat *p =NULL;

    if(existe(nomEtat,liste)==0) // si l'etat n'existe pas dans la liste des etats
                                // donc , on peut l'inserer
    {
        p= malloc(sizeof(ListEtat)); // allouer un nouveau etat
        p->etat.nom=nomEtat ;
        p->suivant=liste;
        liste=p;
    }

    return liste; // retourner la tete de la nouvelle liste
}

///********************************************************************************************************//
///********** tester si une lettre 'c' existe deja dans le tableau de l'alphabet donné à l'entrée**********//
///********************************************************************************************************//

int existe_alphabet(char* alphabet,char c)
{
    int i=0 ;

    for(i=0; i<strlen(alphabet); i++) // parcourir le tableau de l'alphabet
    {
        if(c==alphabet[i])return 1 ; // si la lettre existe dans le tableau on retourne 1
    }
    return 0; // on a parcouru tout le tableau sans trouver la lettre qu'on cherche
              // donc, on retourne 0
}

///********************************************************************************************************//
///****************** Inserer une instruction dans la liste des instructions donnée à l'entrée ************//
///******************  et retourner la tete de la liste des instructions mise à jour **************************//
///********************************************************************************************************//

ListInstruction* insertionInst(ListInstruction *liste_I,instruction ins)
{
    ListInstruction *p =NULL;

    if(existe_Inst(ins,liste_I)==0) // si la nouvelle instruction n'existe pas dans la liste des instrucions
                                    // on l'insere, sinon on l'insere pas
    {
        p= malloc(sizeof(ListInstruction)); // allouer une nouvelle instruction
        p->ins.Si.nom=ins.Si.nom ;
        p->ins.Sj.nom=ins.Sj.nom ;
        p->ins.lettre=ins.lettre ;
        p->suivant=liste_I;
        liste_I=p;
    }

    return liste_I; // retourner la tete de la liste des instructions mise à jour
}

///********************************************************************************************************//
///********************** Verifier si une instruction existe deja dans la**********************************//
///*********************** liste des instruction donnée à l'entrée ou non *********************************//
///********************************************************************************************************//

int existe_Inst(instruction inst,ListInstruction *l)
{

    while(l!=NULL) // si la liste est vide, on teste rien
    {

        if((strcmp(inst.Si.nom,l->ins.Si.nom))==0 && (strcmp(inst.Sj.nom,l->ins.Sj.nom))==0
           &&  (inst.lettre==l->ins.lettre)) // les deux instructions sont identiques si elles ont
                                            // le meme etat de depart, d'arrivé et la meme lettre
        {
            return 1; // on retourne vrai "1"
        }

        l=l->suivant; // passer à la prochaine instruction dans la liste
    }

    return 0;
}


///********************************************************************************************************//
///************* Tester si un etat donné est final ou non *************************************************//
///********************************************************************************************************//

int existe_etat_final(ListEtat *l_Final,ListEtat *l)
{

    ListEtat* p =l_Final; // liste des etats finaux donné à l'entrée

    while(p!=NULL)
    {

        if(existe(p->etat.nom,l)) return 1 ;

        p=p->suivant;

    }
    return 0;

}

///********************************************************************************************************//
///************** chercher les etats coAccessibles de l'automate A<X, S, S0, F, I> ************************//
///********************************************************************************************************//

ListEtat * etatscoAccessibles()
{
    int trouve=1;
    ListInstruction *q=NULL;
    ListEtat *p=NULL, *liste=NULL;
    p=automate_non_reduit.F;

    while(p!=NULL) { // les etats finaux sont tous des etats coAccessibles
                    // donc on les insere dans la liste des etats coAccessibles
                 liste=insertionEtat(liste,p->etat.nom);
                 p=p->suivant;
}

 while(trouve) // tant qu'il y a des etats coAccessibles ayant des predecesseurs , on fait le test
 {
    q=automate_non_reduit.I;
    trouve=0;
    while(q!=NULL)  // on parcourt la liste des instructions
    {
        if(existe(q->ins.Sj.nom,liste)&& existe(q->ins.Si.nom, liste)==0)
            // si l'etat coAccessible est l'etat d'arrivée d'une instruction
            // alors son etat de depart est aussi coAccessible
        {  // on l'insere dans la liste des etats coAccessibles
            liste=insertionEtat(liste,q->ins.Si.nom);
            trouve=1; // un nouveau etat coAccessible trouvé et il se peut qu'il ait des predecesseurs
                      // qui seront des etats coAccessibles
        }

        q=q->suivant; // on passe à la prochaine instruction
    }

 }
 return liste; // on retourne la liste des etats coAccessibles trouvés
}

///********************************************************************************************************//
/// ******* chercher la liste des etats Accessibles de l'automate ****************************************//
///********************************************************************************************************//

ListEtat * etatsAccessibles()
{
   int trouve=1;
   ListEtat *liste=NULL;
   ListInstruction *q=NULL;

   //on initialise la liste des etats accessibles par l'etat initial de l'automate qui est
   // accessible par définition
   liste=insertionEtat(liste,automate_non_reduit.S0.nom);

while(trouve)  // tant qu'il y a des etats accessibles ayant des successeurs , on fait le test
 {
    q=automate_non_reduit.I;
    trouve=0;
    while(q!=NULL) // on parcourt la liste des instructions
    {
        if(existe(q->ins.Si.nom,liste)&& existe(q->ins.Sj.nom, liste)==0)
            // si dans une instruction, l'etat de depart "Si" est accessible, et l'etat d'arrivée "Sj"
            // n'appartient pas à la liste des etats accéssibles, on insere Sj dans la liste des etats
            // accessibles
        {
                 liste=insertionEtat(liste,q->ins.Sj.nom);
                 trouve=1;// un nouveau etat accessible trouvé, donc il se peut qu'il ait des successeurs
                      // qui seront des etats accessibles
        }

        q=q->suivant;// passer à la prochaine instruction
    }
 }
    return liste; // retourne la liste des etats acessibles de l'automate non reduit A
}

///********************************************************************************************************//
/// *****************  la fonction intersection retourne la liste des etats en commun************************//
///******************  entre deux listes d'etats données à l'entrée ***************************************//
///********************************************************************************************************//

ListEtat *intersection(ListEtat *p, ListEtat *q)
{
    ListEtat  *tmp=NULL;
    tmp=q;

    ListEtat *SS=NULL;
    while(p!=NULL) // On parcourt la premiere liste
    {
        q=tmp;
        while(q!=NULL) // on parcourt la deuxieme liste
        {
            if(strcmp(p->etat.nom,q->etat.nom)==0)// si deux etats ont le meme nom donc
                                                 // on les insere à la nouvelle liste crée
            {
                 SS=insertionEtat(SS,p->etat.nom);
            }
            q=q->suivant;
        }
        p=p->suivant;
    }
    return SS; // on retourne la nouvelle liste contenant les etats en commun
}

///********************************************************************************************************//
///************ Construction de l'ensemble des instructions I' de l'automate réduit A' *********************//
///********************************************************************************************************//

ListInstruction* construireI(ListEtat *S)
{
    // on initialise la nouvelle liste des instructions par le vide
    ListInstruction *II=NULL, *i=automate_non_reduit.I;
    instruction j;
    while(i!=NULL) // on parcourt l'ancienne liste des instructions I
    {
        if(existe(i->ins.Si.nom,S)&& existe(i->ins.Sj.nom,S))
            // si l'etat de depart et l'etat d'arrivée d'une instruction existent
            // dans la nouvelle liste d'instructions, donc on l'insere dans I'
        {
            j.lettre=i->ins.lettre;
            j.Si=i->ins.Si;
            j.Sj=i->ins.Sj;
            II=insertionInst(II,j);
        }
        i=i->suivant;
    }

return II; // on retourne la nouvelle liste d'instructions I'
}

///********************************************************************************************************//
///************** Construction de l'automate réduit  A' qui est identique à l'automate A ******************//
///********************************************************************************************************//

void construire_automate_reduit()
{
    ListEtat *p=NULL, *q=NULL,*SS=NULL, *FF=NULL;
    ListInstruction *II;

    p=etatsAccessibles(); // créer la liste des etats accessibles

    q=etatscoAccessibles(); // créer la liste des etats coAccessibles

    SS=intersection(p,q); // la nouvelle liste d'etats S' = l'intersection entre la liste
                         //  des etats accesssibles et la liste des etats coAccessibles

    FF=intersection(automate_non_reduit.F, SS); // La nouvelle liste des etats finaux
                        // F'= l'intersection entre l'ancien F et le nouveau ensemble S'

    II=construireI(SS); // On construit la nouvelle liste d'instructions à partir de S'

   int k=0; // on reconstruit l'ensemble X = l'Alphabet
   for(k=0;k<strlen(automate_non_reduit.X);k++) automate_reduit.X[k]=automate_non_reduit.X[k];

    automate_reduit.S=SS;
    automate_reduit.F=FF;
    automate_reduit.I=II;
    automate_reduit.S0=automate_non_reduit.S0;

}

///********************************************************************************************************//
///*********** Lecture de l'automate deterministe simple non réduit inséré par l'utilisateur **************//
///*********** L'alphabet: X ******************************************************************************//
///*********** Les etats de l'automate: S******************************************************************//
///*********** L'etat initial de l'automate: S0 **********************************************************//
///*********** Les etats finaux de l'automate: F *********************************************************//
///*********** La liste des instructions de l'automate: I ************************************************//
void lire_automate()
{
    int nbr=0,i=0,nbrEtat=0 ;
    char c ;

    do // On lit le nombre de lettres de l'alphabet X
    {
        printf("\tEntrer le nombre de lettres de l'alphabet  : ");

        scanf("%d",&nbr);
    }while(nbr<1) ;
    getchar();

    for(i=0; i<nbr; i++) // On lit les lettres de l'alphabet X de l'automate
                        // tant que la lettre existe, on reboucle jusqu'à obtenir une nouvelle lettre
    {
        do
        {
            printf("\tEntrer la lettre Num  %d   :   ",i+1);
            c=getchar();
            getchar() ;
        }while(c==10 || existe_alphabet(automate_non_reduit.X,c));
        automate_non_reduit.X[i]=c ;
    }

    do // lire le nombre d'etats
    {
        printf("\n\tEntrer le nombre  d'etats  :\t");
        scanf("%d",&nbr);
    }while(nbr<1) ;

    nbrEtat=nbr;

    char *chaine  ;


    for(i=0; i<nbr; i++)
    {
        chaine=malloc(20*sizeof(char)) ;

        sprintf(chaine,"S%d\0",i);

        automate_non_reduit.S= insertionEtat(automate_non_reduit.S,chaine);
    }

    printf("\n\t\tAlphabet : ");

    printf(" %s \n",automate_non_reduit.X);

    printf(" \n\tLa liste des etats :\n");

    affiche_listEtat(automate_non_reduit.S);

    chaine=malloc(20*sizeof(char)) ;

    /* lire l'etat initial */
    printf("\n\n\tEntrer le nom de l'etat initial (Majiscule) :\t");

    do
    {
        scanf("%s",chaine);
    } while(!existe(chaine,automate_non_reduit.S)) ;

    automate_non_reduit.S0.nom=chaine ;

    printf("\n\tEntrer le nombre d'etats finaux  :\t");
    scanf("%d",&nbr);

    for(i=0; i<nbr; i++)
    {
        chaine=malloc(20*sizeof(char)) ;
        do
        {
            printf("\tEntrer le nom de l'etat final Num  %d :   ",i+1);

            scanf("%s",chaine);
        }while(existe(chaine,automate_non_reduit.F)|| !existe(chaine,automate_non_reduit.S)) ;

        automate_non_reduit.F= insertionEtat(automate_non_reduit.F,chaine);
        getchar();
    }

    printf("\n\t\tLecture des instructions \n\n");
    ListEtat* p=automate_non_reduit.S;
    int j=0 ;
    instruction ins ;

    for(i=0; i<nbrEtat; i++)
    {

        ins.Si.nom=p->etat.nom;

        printf("\tEntrer le nombre de successeurs de l'etat  %s  :     ",p->etat.nom) ;
        scanf("%d",&nbr);
        for(j=0; j<nbr; j++)
        {
            do
            {
                chaine=malloc(20*sizeof(char)) ;
                do
                {
                    printf("\tEntrer le nom du successeurs Num %d de l'etat %s :    ",j+1,ins.Si.nom);
                    scanf("%s",chaine);
                    ins.Sj.nom=chaine ;
                    getchar();
                }while(!existe(chaine,automate_non_reduit.S)) ;

                do
                {
                    printf("\tDonner le caractere a lire \t");
                    c=getchar();
                    getchar();

                }while(!existe_alphabet(automate_non_reduit.X,c)) ;

                ins.lettre=c;

                if(existe_Inst(ins,automate_non_reduit.I))
                {
                    printf("\tL'instruction existe deja !! \n");
                }

            } while(existe_Inst(ins,automate_non_reduit.I)) ;
            //ajouter l'instruction//
            automate_non_reduit.I=insertionInst(automate_non_reduit.I,ins);

        }

        p=p->suivant;
    }

}


///********************************************************************************************************//
///******** Affichage de la liste des instructions dans une liste d'instructions donnée *******************//
///********************************************************************************************************//

void affiche_listInstruction(ListInstruction *p)
{
    int i=0 ;
    while(p!=NULL) // on parcourt la liste des instructions
    {
        i++;
        printf("\n\t  %d - <%s,%c,%s>  ",i,p->ins.Si.nom,p->ins.lettre,p->ins.Sj.nom);
        p=p->suivant;
    }
    printf("\n\n ");
}

///********************************************************************************************************//
///********** Afficher la liste des etats contenus dans une liste donné à l'entrée de la fonction *********//
///********************************************************************************************************//

void affiche_listEtat(ListEtat * p)
{

    if(p!=NULL) // on parcourt la liste des etats , on affiche le nom de chaque etat
    {
        affiche_listEtat(p->suivant);
        printf("\n\t - etat : %s ",p->etat.nom);
    }
}


///********************************************************************************************************//
///************ L'affichage de l'automate deterministe simple non réduit *********************************//
///******************************************************************************************************//
void affiche_automate_non_red()
{
    int i=0 ;
     printf("\n\tL'alphabet de l'automate A, X = {  ");

    for(i=0; i<strlen(automate_non_reduit.X)-1; i++)
    {
        printf("%c ,",automate_non_reduit.X[i]);
    }

    printf("%c }",automate_non_reduit.X[i]) ;

     printf(
        "\n\n\n\tliste des etats de l'automate A  :  \n\t");
     affiche_listEtat(automate_non_reduit.S);

    printf("\n\n\n\tl'etat initial est :  ");
     printf("\t< %s >",automate_non_reduit.S0.nom);

     printf( "\n\n\n\tles etats finaux l'automate A  :  \n\t");
     affiche_listEtat(automate_non_reduit.F);

    printf("\n\n");

    printf("\n\tLa liste des instructions de l'automate A \n");

    affiche_listInstruction(automate_non_reduit.I);

}

///********************************************************************************************************//
///************ Afficher l'automate déterministe simple réduit ********************************************//
///********************************************************************************************************//

void affiche_automate_red()
{
    int i=0 ;

    printf("\n\tAffichage de l'automate deterministe simple reduit equivalent a l'automate insere:\n ");

     printf("\n\tL'alphabet de l'automate A', X= {  ");

    for(i=0; i<strlen(automate_reduit.X)-1; i++)
    {
        printf("%c ,",automate_reduit.X[i]);
    }

     printf("%c }",automate_reduit.X[i]) ;

     printf(
        "\n\n\n\tliste des etats de l'automate reduit A'  :  \n\t");
     affiche_listEtat(automate_reduit.S);
     printf("\n\n\n\tl'etat initial est :  ");
     printf("\t< %s >",automate_reduit.S0.nom);

     printf(
        "\n\n\n\tles etats finaux l'automate reduit A' :  \n\t");
     affiche_listEtat(automate_reduit.F);

    printf("\n\n");

    printf("\n\tLa liste des instructions de l'automate reduit A' \n");

    affiche_listInstruction(automate_reduit.I);

}
