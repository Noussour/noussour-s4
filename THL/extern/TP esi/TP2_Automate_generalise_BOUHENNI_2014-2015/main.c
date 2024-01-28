#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "fonctions.h"
#include "affichage.h"

int main()
{
    int choix=1;

    start_Screen();
    textcolor(16);
    do
    {
        system("cls");
        choix=Choisir_Option();
        system("cls");
        switch(choix)
        {
            case 1:
                lire_automate();
            break;
            case 2:
                affiche_automate();
            break;
            case 3:
                {
                    construireAPG();
                    afficherAPG();
                }
            break;
            case 4:
                {
                    construireAS();
                    afficherAS();
                }
            break;
            case 5:
            quitter();
            break;
        }
        printf("\n\n\t\t  ");
        system("pause");
    }while(choix != MAX_CHOIX);
    return EXIT_SUCCESS;
}
