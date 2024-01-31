#include <stdio.h>
#include <stdlib.h>
#include "PILE.h"
#include "NODE.h"
#include "INSTRUCTION.h"

struct INSTRUCTION *Allouer ( ){
    return ((struct INSTRUCTION *) malloc( sizeof(struct INSTRUCTION )));
}

void Aff_Val_w(struct INSTRUCTION *P, char *v){
    P->w = v;
}

void Aff_Val_Sj(struct INSTRUCTION *P, struct NODE *v){
    P->Sj = v;
}

void Aff_Adr_INSTRU( struct INSTRUCTION *P, struct INSTRUCTION *Q){
    P->next = Q;
}

struct INSTRUCTION *Suivant_INSTRU(struct INSTRUCTION *P){
    return( P->next );
}

char *Valeur_w(struct INSTRUCTION *P){
    return( P->w) ;
};

struct NODE *Valeur_Sj(struct INSTRUCTION *P){
    return( P->Sj) ;
}


/*
sommet* construire_auto_gen(){
        arc *a1,*a2=NULL;
        sommet *s1=NULL,*s2=NULL,*s3,*s4 ,*racine=NULL;
        int nb_etat=0,nb_alpha=0,nb_fin=0,bo=0,source,destination;
        char a,c ,chaine[10];
        textcolor(13);
        printf("ENRER ----> s <---- POUR AJOUTER UN ETAT\n\n");
        printf("ENRER ----> a <---- POUR AJOUTER UN ARC\n\n");
        printf("ENTRER ----> ENTREE <---- POUR FINIR\n\n");
        printf("ENTRER ----> . <---- POUR MOT VIDE\n");
        textcolor(15);
        while ((a=getch())!=13){
            if(a=='s'){
                const_sommet(&s2,nb_etat,NULL,NULL,0);
                if(bo==0) {bo=1;racine=s2;}
                if(s1!=NULL) {aff_adr_som(s1,s2);}
                s1=s2;
                textcolor(10);
                printf("S%d a ete creer\n",nb_etat);
                textcolor(15);
                nb_etat++;
            }
            if(a=='a'){
                textcolor(11);
                printf("ENRER LE NUM DE L ETAT SOURCE \n");
                scanf("%d",&source);
                textcolor(11);
                printf("ENRER LE NUM DE L ETAT DESTINATION \n");
                scanf("%d",&destination);
                printf("ENRER LA VALEUR DE L ARC \n");
                scanf("%s",chaine);
                if((s3=elem_liste(racine,source))){
                    if((s4=elem_liste(racine,destination))){
                       const_arc(&a1,s4,NULL,chaine);
                       a2=fin_list(s3);
                       if(!s3->a) s3->a=a1;
                       if(a2!=NULL) aff_adr_arc(a2,a1);
                       a2=a1;
                       textcolor(12);
                       printf("S%d vers S%d creer \n",source,destination);
                       textcolor(15);
                   }else printf("ETAT S%d N EXISTE PAS",destination);
                }else printf("ETAT S%d N EXISTE PAS",source);
            }
        }
        return racine;
}*/
