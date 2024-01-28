
public class Etat { /** Etat d'un automate **/ 

	int nbEtat; /** numéro d'état **/
	boolean fin;  /** booléen permettant de savoir si un état est final ou non **/ 
	
	Etat ()
	{
	}
	Etat (int nbEtat, boolean fin)
	{
		this.nbEtat= nbEtat; 
		this.fin= fin; 
	}
}
