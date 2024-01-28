public class Transition { /** Transition d'un automate **/ 
	Etat Si;  /** Etat de départ **/
	String Xi;  /** Mot **/ 
	Etat Sj;  /** Etat d'arrivée **/
	Transition()
	{
		
	}
	
	Transition(Etat Si, String Xi, Etat Sj)
	{
		this.Si=Si; 
		this.Xi=Xi; 
		this.Sj=Sj; 
	}
	
}
