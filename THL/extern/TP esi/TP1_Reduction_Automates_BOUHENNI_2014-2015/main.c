
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "fonctions.h"

int main()
{
printf("\n\n               +----------------------------------------------------------------------------------+\n");
    printf("               +        Construction d'un Automate simple deterministe  A<X, S, S0, F, I>         +\n");
    printf("               +----------------------------------------------------------------------------------+\n\n\n");
 lire_automate();
 system("cls");
 printf("\n\n               +--------------------------------------------------------+\n");
    printf("               +        Affichage de l'automate A<X, S, S0, F, I>        +\n");
    printf("               +---------------------------------------------------------+\n\n\n");
affiche_automate_non_red();
printf("\n\n \t Veuillez appuyer sur une touche pour afficher l'automate apres la reduction.\n");
getchar();
 system("cls");
printf("\n\n               +----------------------------------------------------------------------+\n");
    printf("               +        Affichage de l'automate reduit A'<X', S', S0', F', I'>        +\n");
    printf("               +----------------------------------------------------------------------+\n\n\n");


construire_automate_reduit();

affiche_automate_red();



return 0;
}

