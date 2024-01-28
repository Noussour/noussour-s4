#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#include "affichage.h"

#include "fonctions.h"

#define tmax 50
#define selected_color 11
#define selected_background 17
#define not_selected_color 15
#define not_selected_background 0
#include <windows.h>

int wherex()
{
        CONSOLE_SCREEN_BUFFER_INFO coninfo;

        GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &coninfo);
        return coninfo.dwCursorPosition.X+1;
}

int wherey()
{
        CONSOLE_SCREEN_BUFFER_INFO coninfo;

        GetConsoleScreenBufferInfo(GetStdHandle(STD_OUTPUT_HANDLE), &coninfo);
        return coninfo.dwCursorPosition.Y;
}

void gotoxy(int xpos, int ypos)
{
        COORD scrn;
        HANDLE hOuput = GetStdHandle(STD_OUTPUT_HANDLE);

        scrn.X = xpos-1;
        scrn.Y = ypos;
        SetConsoleCursorPosition(hOuput, scrn);
}
void textcolor(unsigned int color)
{
    if (color >15 || color <=0)
    {
        HANDLE hcon = GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(hcon,15);

    }
    else
    {
        HANDLE hcon = GetStdHandle(STD_OUTPUT_HANDLE);
        SetConsoleTextAttribute(hcon,color);
    }
}

void textbackground(int bcolor)
{
     WORD wColor;
     //We will need this handle to get the current background attribute
     HANDLE hStdOut = GetStdHandle(STD_OUTPUT_HANDLE);
     CONSOLE_SCREEN_BUFFER_INFO csbi;

     //We use csbi for the wAttributes word.
     if(GetConsoleScreenBufferInfo(hStdOut, &csbi))
     {
        //make a color form the current backgound and our forground color
          wColor = (csbi.wAttributes & 0xF) | ((bcolor  << 4 ) & 0xF0);
          SetConsoleTextAttribute(hStdOut, wColor);

     }
}

char menu[]="Lecture automate#Affichage automate#Automate part. gen.#Automate simple#Quitter";

void cadre(char *s,int choix)
{
    int a,b,i=0,j=0;
    int x=4,y=3;

    if (choix > MAX_CHOIX - (MAX_CHOIX-1) % NB_CHOIX_PAR_LIGNE - 1)
        x=4+12;

    a=(choix-1)%NB_CHOIX_PAR_LIGNE+1;
    b=(choix-1)/NB_CHOIX_PAR_LIGNE+1;

    x+=(DIMENSION_LARG+3)*(a-1);
    y+=(DIMENSION_HAUT+2)*(b-1);

    gotoxy(x,y);

    textbackground(0);
    for(i=0;i<DIMENSION_LARG+2;i++){printf("%c",s[j]);j++;}
    for(i=0;i<DIMENSION_HAUT;i++)
    {
        y++; gotoxy(x,y);printf("%c",s[j]);j++;
        gotoxy(x+DIMENSION_LARG+1,y);printf("%c",s[j]);j++;
    }
    y++;
    gotoxy(x,y);
    for(i=0;i<DIMENSION_LARG+2;i++){printf("%c",s[j]);j++;}
}
void affichCadre(int choix,int NChoix)
{
    int i,j=0;
    char s[100];

    for(i=0;i<(DIMENSION_LARG+2)*2+DIMENSION_HAUT*2;i++){s[j]=' ';j++;}
    cadre(s,choix);

    j=0;
    s[j]=201;j++;
    for(i=0;i<DIMENSION_LARG;i++){s[j]=205;j++;}
    s[j]=187;j++;
    for(i=0;i<DIMENSION_HAUT*2;i++){s[j]=186;j++;}
    s[j]=200;j++;
    for(i=0;i<DIMENSION_LARG;i++){s[j]=205;j++;}
    s[j]=188;j++;
    cadre(s,NChoix);
}

void affichMenu(int choix)
{

    int x=5,y=4,i=1,j=0,k=0,l=0;
    char s[20];
    while(i <= MAX_CHOIX)
    {
        textbackground(i);

        for(j=0;menu[l]!='#' && l < strlen(menu);j++)
        {
            s[j]=menu[l];
            l++;
        }s[j]='\0';
        l++;
        for(j=0;j<DIMENSION_HAUT;j++)
        {
            k=0;
            while(k<DIMENSION_LARG)
            {
                gotoxy(x+k,y+j);
                if((j == (DIMENSION_HAUT / 2)) && (k == (DIMENSION_LARG/2)-(strlen(s)/2)))
                {
                    printf("%s",s);
                    k+=strlen(s);
                }
                printf(" ");
                k++;
            }
        }
        x+=DIMENSION_LARG+3;
        i++;
        if((i-1) % NB_CHOIX_PAR_LIGNE == 0)
        {
            if (i > MAX_CHOIX - (MAX_CHOIX-1) % NB_CHOIX_PAR_LIGNE - 1)  x=5+12;
            else x=5;
            y+=DIMENSION_HAUT+2;
        }
    }
}

int Choisir_Option()
{
    int a=0,b=0,choix=1, New_Choix=1;

    affichMenu(choix);
    while(a!=13)
    {
        affichCadre(choix,New_Choix);
        choix = New_Choix;
        a=getch();
        if(a==224)
        {
            b=getch();
            if(b == GAUCHE)
            {
                if(choix==1)  New_Choix=MAX_CHOIX;
                else   New_Choix--;
            }
            else if(b == HAUT)
            {
                if(choix<=NB_CHOIX_PAR_LIGNE)
                {
                    New_Choix = MAX_CHOIX - (MAX_CHOIX-1) % NB_CHOIX_PAR_LIGNE - 1 + choix;
                    if(New_Choix > MAX_CHOIX)  New_Choix=MAX_CHOIX;
                }
                else   New_Choix-=NB_CHOIX_PAR_LIGNE;
            }
            else if(b == DROITE)
            {
                if(choix==MAX_CHOIX) New_Choix=1;
                else New_Choix++;
            }
            else if(b == BAS)
            {
                if(choix > MAX_CHOIX - (MAX_CHOIX-1) % NB_CHOIX_PAR_LIGNE - 1)
                    New_Choix = (choix-1) % NB_CHOIX_PAR_LIGNE + 1;
                else
                {
                    New_Choix+=NB_CHOIX_PAR_LIGNE;
                    if(New_Choix > MAX_CHOIX)  New_Choix=MAX_CHOIX;
                }
            }
        }
    }
    return choix;
}

void Boite(char *s)
{
    int i;
    printf("\n\n");
    printf("   %c",201);
    for(i=0;i<70;i++){printf("%c",205);}
    printf("%c\n   ",187);
    printf("%c",186);
    for(i=0;i<70/2-strlen(s)/2;i++){printf(" ");}
    printf("%s",s);
    for(i=70/2+strlen(s)/2;i<70;i++){printf(" ");}
    printf("%c\n   ",186);
    printf("%c",200);
    for(i=0;i<70;i++){printf("%c",205);}
    printf("%c",188);
    printf("\n\n");
}

void affichLigne(char *s)
{
    int i=0,x=19;

    gotoxy(x,wherey()+1);
    while(i<strlen(s))
    {
        if(s[i]=='0') x++;
        else
        {
            gotoxy(x,wherey());
            printf("%c",s[i]);
            x++;
        }
        i++;
    }
}
void start_Screen()
{
    printf("\n\t   +--------------------------------------------------+\n");
    printf("\t   |           TP Realise par Bouhenni Sarra          |\n");
    printf("\t   +--------------------------------------------------+\n");


    textbackground(2);
    affichLigne("            000            000        ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("            000            000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("            000            000        ");
    textbackground(16);

    textcolor(15);
    printf("\n\n\t   +--------------------------------------------------+\n");
    printf("\t   |     ECOLE NATIONALE SUPERIEURE D'INFORMATIQUE    |\n");
    printf("\t   +--------------------------------------------------+");
    textcolor(16);

    printf("\n\n\t\t  ");
    system("pause");
}
void quitter()
{
    textcolor(16);
    printf("\n\t   +--------------------------------------------------+\n");
    printf("\t   |        MERCI D'AVOIR UTILISER MON PROGRAMME      |\n");
    printf("\t   |           TP Realise par Bouhenni Sarra          |\n");
    printf("\t   +--------------------------------------------------+\n");

    textbackground(2);
    affichLigne("            000            000        ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("  0000000000000  0000000000000000  ");
    affichLigne("            000            000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("  00000000000000000000000  000000  ");
    affichLigne("            000            000        ");

    textbackground(0);
    textcolor(15);
    printf("\n\n\t   +--------------------------------------------------+\n");
    printf("\t   |     ECOLE NATIONALE SUPERIEURE D'INFORMATIQUE    |\n");
    printf("\t   +--------------------------------------------------+");
    textcolor(16);
}


