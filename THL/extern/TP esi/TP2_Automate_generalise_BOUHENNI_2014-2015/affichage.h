#ifndef AFFICHAGE_INCLUDED
#define AFFICHAGE_INCLUDED

    #define MAX_CHOIX 5
    #define NB_CHOIX_PAR_LIGNE 3
    #define DIMENSION_HAUT 9
    #define DIMENSION_LARG 21
    #define GAUCHE 75
    #define HAUT 72
    #define DROITE 77
    #define BAS 80

    int wherex();
    int wherey();
    void gotoxy(int xpos, int ypos);
    void textcolor(unsigned int color);
    void textbackground(int bcolor);

    void cadre(char *s,int choix);
    void affichCadre(int choix,int NChoix);
    void affichLigne(char *s);
    void affichMenu(int choix);
    int Choisir_Option();
    void start_Screen();
    void Boite(char *s);
    void quitter();

#endif

