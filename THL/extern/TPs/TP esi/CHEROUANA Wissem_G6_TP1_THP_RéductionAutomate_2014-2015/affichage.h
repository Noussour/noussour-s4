#ifndef AFFICHAGE_H_INCLUDED
#define AFFICHAGE_H_INCLUDED

#include <conio.h>
#define tmax 50
#define selected_color 4
#define selected_background 11
#define not_selected_color 15
#define not_selected_background 0
#define MAX_CHOIX 5
#define NB_CHOIX_PAR_LIGNE 3
#define DIMENSION_HAUT 9
#define DIMENSION_LARG 21
#define GAUCHE 75
#define HAUT 72
#define DROITE 77
#define BAS 80


char menu[]="Creation Automate#Affichage Automate#Repre Matricielle#Reduction Automate#Quitter";


typedef enum
{
    BLACK,          /**< black color */
    BLUE,           /**< blue color */
    GREEN,          /**< green color */
    CYAN,           /**< cyan color */
    RED,            /**< red color */
    MAGENTA,        /**< magenta color */
    BROWN,          /**< brown color */
    LIGHTGRAY,      /**< light gray color */
    DARKGRAY,       /**< dark gray color */
    LIGHTBLUE,      /**< light blue color */
    LIGHTGREEN,     /**< light green color */
    LIGHTCYAN,      /**< light cyan color */
    LIGHTRED,       /**< light red color */
    LIGHTMAGENTA,   /**< light magenta color */
    YELLOW,         /**< yellow color */
    WHITE           /**< white color */
} COLORS;


void hell();
void Color(int couleurDuTexte,int couleurDeFond);
void textcolor(unsigned int color);
void textbackground(int bcolor);
void gotoxy(int xpos, int ypos);
void intro();
void decor ();
int wherex();
int wherey();
int menu2(int max,...);
void returnToMenu();
void the_end();
void cadre(char *s,int choix);
void affichCadre(int choix,int NChoix);
void affichMenu(int choix);
int Choisir_Option();
void Boite(char *s);


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

    textbackground(BLACK);
    for(i=0; i<DIMENSION_LARG+2; i++)
    {
        printf("%c",s[j]);
        j++;
    }
    for(i=0; i<DIMENSION_HAUT; i++)
    {
        y++;
        gotoxy(x,y);
        printf("%c",s[j]);
        j++;
        gotoxy(x+DIMENSION_LARG+1,y);
        printf("%c",s[j]);
        j++;
    }
    y++;
    gotoxy(x,y);
    for(i=0; i<DIMENSION_LARG+2; i++)
    {
        printf("%c",s[j]);
        j++;
    }
}
void affichCadre(int choix,int NChoix)
{
    int i,j=0;
    char s[100];

    for(i=0; i<(DIMENSION_LARG+2)*2+DIMENSION_HAUT*2; i++)
    {
        s[j]=' ';
        j++;
    }
    cadre(s,choix);

    j=0;
    s[j]=201;
    j++;
    for(i=0; i<DIMENSION_LARG; i++)
    {
        s[j]=205;
        j++;
    }
    s[j]=187;
    j++;
    for(i=0; i<DIMENSION_HAUT*2; i++)
    {
        s[j]=186;
        j++;
    }
    s[j]=200;
    j++;
    for(i=0; i<DIMENSION_LARG; i++)
    {
        s[j]=205;
        j++;
    }
    s[j]=188;
    j++;
    cadre(s,NChoix);
}

void affichMenu(int choix)
{
    int x=5,y=4,i=1,j=0,k=0,l=0;
    char s[20];
    while(i <= MAX_CHOIX)
    {
        if(i%2==0)
        {
            textcolor(5);
            textbackground(11);
        }
        else
        {
            textcolor(15);
            textbackground(3);
        }

        for(j=0; menu[l]!='#' && l < strlen(menu); j++)
        {
            s[j]=menu[l];
            l++;
        }
        s[j]='\0';
        l++;
        for(j=0; j<DIMENSION_HAUT; j++)
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

    printf("   %c",201);
    for(i=0; i<70; i++)
    {
        printf("%c",205);
    }
    printf("%c\n   ",187);
    printf("%c",186);
    for(i=0; i<70/2-strlen(s)/2; i++)
    {
        printf(" ");
    }
    printf("%s",s);
    for(i=70/2+strlen(s)/2; i<70-1; i++)
    {
        printf(" ");
    }
    printf("%c\n   ",186);
    printf("%c",200);
    for(i=0; i<70; i++)
    {
        printf("%c",205);
    }
    printf("%c",188);
}



void Color(int couleurDuTexte,int couleurDeFond)   /** fonction d'affichage des couleurs **/
{
    HANDLE H=GetStdHandle(STD_OUTPUT_HANDLE);
    SetConsoleTextAttribute(H,couleurDeFond*16+couleurDuTexte);
}


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



void returnToMenu()
{
    //gotoxy(4,28);
    printf("\n\n");
    textcolor(10);
    printf ("          +---------------------------------------------------------------------------------------------------------------------------+\n");
    printf ("          |                                        ");
    textcolor(12);
    printf("[ ");
    textcolor(14);
    printf ("ENTER");
    textcolor(12);
    printf (" ] ");
    textcolor(15);
    printf ("Pour revenir au MENU PRINCIPAL");
    textcolor(10);
    printf("                                           |\n");
    printf ("          +---------------------------------------------------------------------------------------------------------------------------+\n");

    Color(15,16);
    getch();
    system("cls");
}

void the_end()
{
    Color(11,16);
    printf ("             __            ____             U _____ u _   _     _____   U  ___ u _____                         \n ");
    printf ("         U /" "  \\  u     U |  __"")u    ___    \\|  ___""|/| \\ |"" |   |_ ""  _|   \\/"" _ \\/|_ ""  _|  \n");
    printf ("          \\/ __ \\/       \\|  _ \\/   |_"" _|    |  _|""  <|  \\| |>    | |     | | | |  | |          \n");
    printf ("          / ___  \\        | |_) |    | |     | |___ U| |\\  |u   /| |\\.-,_| |_| | /| |\\     \n");
    printf ("         /_/    \\_\\       |____/   U/| |\\u   |_____| |_| \\_|   u |_|U \\_)-\\___/ u |_|U      \n" );
    printf ("         \\\\      >>      _|| \\\\_.-,_|___|_,-.<<   >> ||   \\\\,-._// \\\\_     \\\\   _// \\\\_     \n");
    printf ("        (__)    (__)    (__) (__)\\_)-' '-(_/(__) (__)(_"")   (_/(__) (__)   (__) (__) (__)       \n");

    Color(15,16);

}


void intro()
{
    printf("\n\n\n\n");
    Color(14,16);
    printf("                     ******************************************************************************************\n");
    printf("                     *");

    Color(11,16);
    printf("             _");

    Color(14,16);
    printf("                                                                          *\n");
    printf("                     *            ");


    Color(11,16);
    printf("|_|");


    Color(14,16);
    printf("                                                                         *\n");
    printf("                     *            ");

    Color(11,16);
    printf("/_/");
    Color(14,16);
    printf("                                                                         *  \n");
    printf("                     *   ");
    Color(15,16);
    printf("___  ___ _");

    Color(14,16);
    printf("                                                                           * \n");
    printf("                     *  ");
    Color(15,16);

    printf("/ _ \\/ __| |");

    Color(14,16);
    printf("                                                                          *\n");
    printf("                     * ");
    Color(15,16);

    printf("|  __/\\__ \\ |        Ecole nationale Superieure d'Informatique               ");

    Color(14,16);
    printf("          *\n");
    printf("                     *  ");
    Color(15,16);

    printf("\\___||___/_|        Cycle Preparatoire Integre (2CPI) - SFSD               ");

    Color(14,16);
    printf("           * \n");
    printf("                     *                                                                                        *\n");
    printf("                     *                                                                                        *\n");
    printf("                     *  ");
    Color(15,16);
    Color(11,16);
    printf("Programme : ");
    Color(15,16);
    printf("Meilleure Organisation parmis 3 crees lors des operations de mise a jour");

    Color(14,16);
    printf("  *\n");
    printf("                     *  ");
    Color(15,16);

    Color(14,16);
    printf("                                                                                      *\n");
    printf("                     *  ");
    Color(15,16);


    Color(11,16);
    printf("Realise par :");
    Color(15,16);
    printf(" CHEROUANA Wissem - KHADIR Karima                      _.-''\\     ");

    Color(14,16);
    printf("       *\n");
    printf("                     *                        ");
    Color(15,16);

    printf("   Section B Groupe 8                     _.-''     \\    ");

    Color(14,16);
    printf("       *\n");
    printf("                     *                        ");
    Color(15,16);

    printf("      05/01/2014                       ,-''          \\  ");

    Color(14,16);
    printf("        *  \n");
    printf("                     *  ");
    Color(15,16);

    printf("                                                            ( \\");
    Color(14,16);
    printf("    INDEX    ");
    Color(15,16);
    printf("\\");

    Color(14,16);
    printf("         *\n");
    Color(14,16);
    printf("                     * ");
    Color(11,16);
    printf(" Encadre par :");
    Color(15,16);
    printf(" Mr. BOULAKRADECHE Mohamed                      \\ \\");
    Color(14,16);
    printf("    MOTS     ");
    Color(15,16);
    printf("\\        ");
    Color(14,16);
    printf("*\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                \\ \\   ~ ~ ~ ~   \\");
    Color(14,16);
    printf("       *\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                 \\ \\   ~~~~  _.--;      ");
    Color(14,16);
    printf("*\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                  \\ \\    _.-'    :      ");
    Color(14,16);
    printf("*\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                   \\ \\,-'    _.-'       ");
    Color(14,16);
    printf("*\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                    \\(   _.-'           ");
    Color(14,16);
    printf("*\n");
    printf("                     *");
    Color(15,16);
    printf("                                                                     `--'               ");
    Color(14,16);
    printf("*\n");
    printf("                     *               ");

    Color(15,16);
    printf("APPUYEZ SUR LA TOUCHE ENTREE POUR COMMENCER");

    Color(14,16);
    printf("                              *\n");
    printf("                     *                                                                                        *\n");
    printf("                     ******************************************************************************************\n");

    Color(15,16);
    getchar() ;


}


int menu2(int max,...)

/** Fonction permettant un bel affichage du menu **/

{
    int choi,a,i,b,d,y;
    char p[tmax];
    char **choix=NULL;
    choix=malloc(max*sizeof(p));
    va_list marker;
    va_start( marker,max );     /* Initialize variable arguments. */
    for (i=0; i<max; i++)
    {
        choix[i] = va_arg( marker,char*);
    }
    va_end( marker );
    d=wherey();
    y=d;
    textcolor (selected_color);
    textbackground (selected_background);
    printf("%s\n",choix[0]);
    textbackground (not_selected_background);
    textcolor(not_selected_color);
    for (i=1; i<max; i++)
    {
        printf("%s\n",choix[i]);
    }
abbbbb:
    while((a=getch())==224)
    {
        b=getch();
        if(b==80 && y<d+max-1)
        {
            gotoxy(1,y);
            textcolor(not_selected_color);
            i=y-d;
            textbackground (not_selected_background);
            printf("%s",choix[i]);
            y++;
            textcolor (selected_color);
            gotoxy(1,y);
            textbackground (selected_background);
            printf("%s",choix[i+1]);
        }
        if(b==72 && y>d)
        {
            gotoxy(1,y);
            textcolor(not_selected_color);
            i=y-d;
            textbackground (not_selected_background);
            printf("%s",choix[i]);
            y--;
            textcolor (selected_color);
            gotoxy(1,y);
            textbackground (selected_background);
            printf("%s",choix[i-1]);
        }


    }
    if (a!=13)goto abbbbb;

    choi=y-d;
    textbackground (not_selected_background);
    textcolor(not_selected_color);
    gotoxy(1,d+4);
    return choi+1;
}

void decor ()
{
    Color(15,16);
    printf("                                                                                     _______  _______  _                      \n");
    printf("                                                                                    (       )(  ____ \\( (    /||\\     /|    ");
    Color(11,16);
    printf("                           \n");
    Color(15,16);
    printf("                                                                                    | () () || (    \\/|  \\  ( || )   ( |    ");
    Color(11,16);
    printf("                           \n");
    Color(15,16);
    printf("                                                                                    | || || || (__    |   \\ | || |   | |   ");
    Color(11,16);
    printf("                        \n");
    Color(15,16);
    printf("                                                                                    | |(_)| ||  __)   | (\\ \\) || |   | |  ");
    Color(11,16);
    printf("                       \n");
    Color(15,16);
    printf("                                                                                    | |   | || (      | | \\   || |   | |   ");
    Color(11,16);
    printf("                        \n");
    Color(15,16);
    printf("                                                                                    | )   ( || (____/\\| )  \\  || (___) |    ");
    Color(11,16);
    printf("                          \n");
    Color(15,16);
    printf("                                                                                    |/     \\|(_______/|/    )_)(_______)    ");
    Color(11,16);
    printf("                   \n");
    printf("                                                                                                                                    \n");
    printf("                                                                                                                                     \n");
    printf("                                                                                                                                     \n\n");
}


void hell ()
{
    printf("                        ____________________________________     ______________________________________\n");
    printf("                     .-/|       ~~~~~~ ***** ~~~~~~          \\ /           ~~~~~~ ***** ~~~~~~        |\\-.\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||  Ecole Superieure d'Informatique    :   Cycle Superieur - Tronc commun(1CS) ||||\n");
    printf("                     ||||");
    Color(11,16);
    printf("              _");
    textcolor(15);
    printf("                      :              Module : THP             ||||\n");
    textcolor(15);
    printf("                     ||||");
    Color(11,16);
    printf("             |_|");
    textcolor(15);

    printf("                     :                    TP1                ||||\n");
    printf("                     ||||");
    Color(11,16);
    printf("             /_/");
    textcolor(15);
    printf("                     :                                       ||||\n");
    printf("                     ||||");
    Color(15,16);
    printf("   ___  ___ _");
    textcolor(15);
    printf("                        :                                       ||||\n");
    printf("                     ||||");
    Color(15,16);
    printf("  / _ \\/ __| |");
    printf("                       :                                       ||||\n");
    Color(15,16);
    printf("                     ||||");
    printf(" |  __/\\__ \\ |                       :");
    printf("                                       ||||\n");
    Color(15,16);
    printf("                     ||||");
    printf("  \\___||___/_|                       : ");
    printf("                                      ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||");
    Color(11,16);
    printf("  Programme : ");
    textcolor(15);
    printf("                       :                                       ||||\n");
    Color(15,16);

    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||  Reduction d'un automate simple     :                                       ||||\n");
    printf("                     ||||           deterministe :            :");


    Color(11,16);
    printf("   Realise par :");
    Color(15,16);
    printf("                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :");

    printf("     --> CHEROUANA Wissem");
    Color(15,16);
    printf("              ||||\n");
    printf("                     ||||                                     : ");

    printf("                     ");
    Color(15,16);
    printf("                 ||||\n");

    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :");

    printf("        Section B Groupe 6");
    Color(15,16);
    printf("             ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :");

    Color(11,16);
    printf("   Encadre par :");
    Color(15,16);
    printf("                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :");

    printf("         Mme. BENATCHBA Karima   ");
    Color(15,16);
    printf("      ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||                                     :                                       ||||\n");
    printf("                     ||||____________________________________ : ______________________________________||||\n");
    printf("                     ||/=====================================\\:/=======================================\\||\n");
    printf("                     `--------------------------------------~___~---------------------------------------''\n\n");
    textcolor(14);
    printf("                                        APPUYER SUR UNE ENTER POUR COMMENCER ");
    getchar() ;
}

#endif // AFFICHAGE_H_INCLUDED
