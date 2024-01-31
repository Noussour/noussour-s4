#include <stdlib.h>
#include <stdio.h>
#include "fonctions.h"
#include "affichage.h"
#include <string.h>

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
    char c ;char mot[10];
    Boite("Lecture d'un automate ");
    textcolor(12);
    printf("\n\t Veuillez utiliser le symbole: $ pour indiquer le mot vide!\n\n");
    textcolor(0);
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
        }while(c==10 || existe_alphabet(AG.X,c));
        AG.X[i]=c ;
    }
    AG.X[strlen(AG.X)]='$';

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

        AG.S= insertionEtat(AG.S,chaine);
    }

    printf(" \n\tLa liste des etats :\n");

    affiche_listEtat(AG.S);

    chaine=malloc(20*sizeof(char)) ;

    /* lire l'etat initial */
    printf("\n\n\tEntrer le nom de l'etat initial (Majiscule) :\t");

    do
    {
        scanf("%s",chaine);
    } while(!existe(chaine,AG.S)) ;

    AG.S0.nom=chaine ;

    printf("\n\tEntrer le nombre d'etats finaux  :\t");
    scanf("%d",&nbr);

    for(i=0; i<nbr; i++)
    {
        chaine=malloc(20*sizeof(char)) ;
        do
        {
            printf("\tEntrer le nom de l'etat final Num  %d :   ",i+1);

            scanf("%s",chaine);
        }while(existe(chaine,AG.F)|| !existe(chaine,AG.S)) ;

        AG.F= insertionEtat(AG.F,chaine);
        getchar();
    }

    printf("\n\t\tLecture des instructions \n\n");
    ListEtat* p=AG.S;
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
                    printf("\tEntrer le nom du successeur Num %d de l'etat %s :    ",j+1,ins.Si.nom);
                    scanf("%s",chaine);
                    ins.Sj.nom=chaine ;
                    getchar();
                }while(!existe(chaine,AG.S)) ;

                do
                {
                    printf("\tDonner le mot a lire \t");
                    scanf(" %s",mot);
                    getchar();

                }while(!existe_mot(AG.X,mot)) ;

               strcpy(ins.lettre,mot);

                if(existe_Inst(ins,AG.I))
                {
                    printf("\tL'instruction existe deja !! \n");
                }

            } while(existe_Inst(ins,AG.I)) ;
            //ajouter l'instruction//
            AG.I=insertionInst(AG.I,ins);
        }

        p=p->suivant;
    }

}
///********************************************************************************************************//
/// **************** la fonction existe() verifie si un etat **********************************************//
///****************** "Sj" existe deja dans la liste des etats "et" ***************************************//
///********************************************************************************************************//
int existe(char *nomEtat, ListEtat *et)
{
    while(et!=NULL) // parcourir la liste des etats
    {
        if((strcmp(nomEtat,et->etat.nom))==0) // comparer les noms des etats
                                 //de "et" avec le nom de l'etat à l'entrée
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

int existe_mot(char* alphabet,char mot[10])
{
    int i=0;
    for(i=0; i<strlen(mot); i++) // parcourir le tableau de l'alphabet
    {
        if(!existe_alphabet(alphabet,mot[i]))return 0 ; // si la lettre existe dans le tableau on retourne 1
    }
    return 1;
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
        strcpy(p->ins.lettre,ins.lettre) ;
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
           &&  (strcmp(inst.lettre,l->ins.lettre))==0 )// les deux instructions sont identiques si elles ont
                                            // le meme etat de depart, d'arrivé et la meme lettre
        {
            return 1; // on retourne vrai "1"
        }

        l=l->suivant; // passer à la prochaine instruction dans la liste
    }

    return 0;
}

///********************************************************************************************************//
///************ L'affichage de l'automate deterministe simple non réduit *********************************//
///******************************************************************************************************//
void affiche_automate()
{
    Boite("Affichage de l'automate generalise A");

    int i=0 ;
     printf("\n\tL'alphabet de l'automate A, X = {  ");

  if(strlen(AG.X)>0) {
    for(i=0; i<strlen(AG.X)-1; i++)
    {
        printf("%c ,",AG.X[i]);
    }

    printf("%c }",AG.X[i]) ;
     printf(
        "\n\n\n\tliste des etats de l'automate A  :  \n\t");
     affiche_listEtat(AG.S);

    printf("\n\n\n\tl'etat initial est :  ");
     printf("\t< %s >",AG.S0.nom);

     printf( "\n\n\n\tles etats finaux l'automate A  :  \n\t");
     affiche_listEtat(AG.F);

    printf("\n\n");

    printf("\n\tLa liste des instructions de l'automate A \n");

    affiche_listInstruction(AG.I);
     }
    else printf("\n\tL'automate est vide !\n");

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
        if(p->ins.lettre[0]=='$') printf("\n\t  %d - <%s, mot vide, %s>  ",i,p->ins.Si.nom,p->ins.Sj.nom);
        else printf("\n\t  %d - <%s,%s,%s>  ",i,p->ins.Si.nom,p->ins.lettre,p->ins.Sj.nom);
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

void construireAPG(){
      int i=0,n=0,j=0;
      for(i=0;i<strlen(AG.X);i++) APG.X[i]=AG.X[i];
      APG.S=AG.S;
      APG.S0=AG.S0;
      APG.F=AG.F;
      ListInstruction *liste=NULL;
      ListInstruction *p=AG.I;
      instruction inst;
      ListEtat *si=NULL, *sj=NULL;
      char e[]="S";char c='a';
while(p!=NULL) /// parcourir la liste des instructions de AG
{
    si=NULL; sj=NULL;

    if(strlen(p->ins.lettre)>1){ /// si le mot est de longueur > 1
           si=insertionEtat(si,p->ins.Si.nom); /// construire un nouveau etat portant le nom de Si
            n=strlen(p->ins.lettre); /// n est le nombre de transtions qu'on va ajouter

            for(i=0;i<n;i++){
                   if(i<n-1) { /// si c'est la dernière transition, on prend Sj comme état d'arrivée
                                sprintf(etatName[j],"%s%c\0",e,c) ; /// créer le nom du nouvel etat
                                 sj=insertionEtat(sj,etatName[j]);
                                j++; c++;
                             }
                    else {sj=insertionEtat(sj,p->ins.Sj.nom);}
                    /// on insere le nouvel état dans la liste des états de APG
                    APG.S=insertionEtat(APG.S,sj->etat.nom);
                    /// créer une nouvelle transition avec un mot de taille=1
                    inst.lettre[0]=p->ins.lettre[i];
                    inst.lettre[1]='\0';
                    inst.Si=si->etat;
                    inst.Sj=sj->etat;

                    liste=insertionInst(liste,inst); /// insertion de la nouvelle transition
                                                    ///  dans la liste des instructions de APG

                    si=sj;  /// l'état d'arrivée devient l'état de départ de la prochaine instruction à créer
                    sj=NULL;

        }
     }
     else{ /// le mot est de longueur inférieure ou égale à 1
            strcpy(inst.lettre,p->ins.lettre);
            inst.Si=p->ins.Si;
            inst.Sj=p->ins.Sj;
            /// I'=I' union { (si, w, sj)}
            liste=insertionInst(liste,inst);
        }
     p=p->suivant; /// passer à la prochaine instruction
}
      APG.I=liste;
}

void afficherAPG()
{
    Boite("Affichage de l'automate partiellement generalise");

    int i=0 ;

   if(strlen(APG.X)>0)
{
    printf("\n\tL'alphabet de l'automate partiellemnt generalise, X = {  ");

    for(i=0; i<strlen(APG.X)-1; i++)
    {
        printf("%c ,",APG.X[i]);
    }

    printf("mot vide }") ;

     printf(
        "\n\n\n\tliste des etats de l'automate partiellement generalise  :  \n\t");
     affiche_listEtat(APG.S);

     printf("\n\n\n\tl'etat initial est :  ");
     printf("\t< %s >",APG.S0.nom);

     printf( "\n\n\n\tles etats finaux l'automate partiellement generalise  :  \n\t");
     affiche_listEtat(APG.F);

    printf("\n\n");

    printf("\n\tLa liste des instructions de l'automate partiellemnt generalise \n");

    affiche_listInstruction(APG.I);
}
else printf("\n\tL'automate est vide !\n");

}
///****************** Supprimmer les transitions spontanées **********************///

void construireAS()
{

ListInstruction *I=NULL, *p=APG.I, *q=APG.I;
ListEtat *F=APG.F;
instruction ins;
int trouv=1,i=0;

while(trouv)
  {   /*Tant qu'il y a des transtions spontanées, on reboucle pour les éliminer*/
      trouv=0;
    while(p!=NULL)
     {   /*parcourir la liste des instructions pour chercher les transitions spontanées*/
         if(p->ins.lettre[0]!='$')
       {
           ins.Si=p->ins.Si;
           strcpy(ins.lettre, p->ins.lettre);
           ins.Sj=p->ins.Sj;
           I=insertionInst(I,ins);
       }
       else{
            if(strcmp(p->ins.Si.nom,p->ins.Sj.nom)!=0)
           {
              trouv=1;
              if(existe(p->ins.Sj.nom,APG.F)) /*Si sj est un etat final alors si devient final*/
                    F=insertionEtat(F,p->ins.Si.nom);
               while(q!=NULL) /*parcourir la liste des instructions pour chercher les successeurs de Sj */
               {
                 if(strcmp(p->ins.Sj.nom,q->ins.Si.nom)==0) /* si Sj' est un succésseur de Sj,
                                                               Sj' devient successeur de Sj */
                  {
                    ins.Si=p->ins.Si;
                    ins.Sj=q->ins.Sj;
                    strcpy(ins.lettre,q->ins.lettre);
                    I=insertionInst(I,ins);  /* insérer ins dans la nouvelle liste des transitions*/
                  }
                    q=q->suivant;
              }
           }
           }
        p=p->suivant;
        q=APG.I;
 }
if(trouv==1) /* si on a trouvé une transition spontanée , on refait la
                même chose avec la noouvelle liste d'instructions */
{
    p=I;
    I=NULL;
    q=p;
}
  }

AS.F=F;
AS.I=I;
AS.S=APG.S;
AS.S0=APG.S0;

if(strlen(APG.X)>0) /*l'ensemble de l'alphabet de AS = L'ensemble de l'alphabet de APG sans le mot vide*/
    for(i=0;i<strlen(APG.X)-1;i++) AS.X[i]=APG.X[i];


}
void afficherAS()
{
    Boite("Affichage de l'automate simple equivalent a l'automate generalise A");
     int i=0 ;

   if(strlen(AS.X)>0){

    printf("\n\tL'alphabet de l'automate simple A, X = {  ");
    for(i=0; i<strlen(AS.X)-1; i++)
    {
        printf("%c ,",AS.X[i]);
    }

    printf("%c }",AS.X[i]) ;

     printf(
        "\n\n\n\tliste des etats de l'automate simple A  :  \n\t");
     affiche_listEtat(AS.S);

    printf("\n\n\n\tl'etat initial est :  ");
     printf("\t< %s >",AS.S0.nom);

     printf( "\n\n\n\tles etats finaux l'automate simple A  :  \n\t");
     affiche_listEtat(AS.F);

    printf("\n\n");

    printf("\n\tLa liste des instructions de l'automate simple A \n");

    affiche_listInstruction(AS.I);
}
else printf("\n\tL'automate est vide !\n");
}
