import java.util.ArrayList;
import java.util.Collections;


public class AutomateSimple {

	ArrayList<String> ensAlphabet= new ArrayList<String>(); 
	ArrayList<Etat> ensEtats= new ArrayList<Etat>(); 
	ArrayList<Etat> ensEtatsFinaux= new ArrayList<Etat>(); 	
	ArrayList<Transition> ensTran= new ArrayList<Transition>(); 
	ArrayList<Etat> ensEtatsInitiaux= new ArrayList<Etat>(); 
	int nbEtats; 
	int nbEtatsFinaux; 
	int nbTransitions; 
	int nbAlphabet; 
	int nbEtatsInitiaux; 

	public int RechercheAlphabet (String alphabet) //Recherche d'un joueur par son nom
	{
		Collections.sort(ensAlphabet);
		return Collections.binarySearch(ensAlphabet, alphabet); 
	}
	
public void afficheAutomateSimplee()
{
	int i=0;
	
	
/*	 System.out.println(" - L'ensemble des états initiaux est : ");
	 System.out.print(" 	Si = { ");
	    for (i=0; i<nbEtatsInitiaux-1; i++)
	    	 System.out.print("S"+ensEtatsInitiaux.get(i).nbEtat+", ");
	    System.out.println("S"+ensEtatsInitiaux.get(nbEtatsInitiaux-1).nbEtat+" }");*/
   
	System.out.println(" - L'ensemble de l'alphabet est : ");
    System.out.print("	 X = { ");
    for (i=0; i<ensAlphabet.size()-1; i++)
    	 System.out.print(ensAlphabet.get(i)+", ");
    System.out.println(ensAlphabet.get(ensAlphabet.size()-1)+" }");
    
    System.out.println(" - L'ensemble des états est : ");
    System.out.print(" 	S = { ");
    for (i=0; i<nbEtats-1; i++)
    	 System.out.print("S"+ensEtats.get(i).nbEtat+", ");
    System.out.println("S"+ensEtats.get(nbEtats-1).nbEtat+" }");
    
    System.out.println(" - L'ensemble des états finaux est : ");
    System.out.print("	 F = { ");
   for (i=0; i<nbEtatsFinaux-1; i++)
    	 System.out.print("S"+ensEtatsFinaux.get(i).nbEtat+", ");
    System.out.println("S"+ensEtatsFinaux.get(nbEtatsFinaux-1).nbEtat+" }");
    
    
    System.out.println(" - L'ensemble des instructions est : ");
    System.out.print(" 	I = { ");
    for (i=0; i<nbTransitions-1; i++)
    {
    	 System.out.print("(S"+ensTran.get(i).Si.nbEtat+", "+ensTran.get(i).Xi+", S"+ensTran.get(i).Sj.nbEtat+"), ");
    }
    System.out.println("(S"+ensTran.get(nbTransitions-1).Si.nbEtat+", "+ensTran.get(nbTransitions-1).Xi+", S"+ensTran.get(nbTransitions-1).Sj.nbEtat+") } ");
} 

boolean AutomatePartilGeneralise(AutomateSimple A)
{
	boolean parGen=false;
	for (int i=0; i<A.nbTransitions; i++)
	{
		if (A.ensTran.get(i).Xi.equals("&")) parGen=true; 
	}
	return parGen; 
}

public AutomateSimple CreerAutomateSimple()
{
	AutomateSimple A= new AutomateSimple();
	int i, j,m = 0; 
	A.nbEtats=nbEtats;
	A.ensEtats=ensEtats; 
	A.nbEtatsInitiaux=nbEtatsInitiaux; 
	A.ensEtatsInitiaux=ensEtatsInitiaux; 
	A.nbEtatsFinaux=nbEtatsFinaux; 
	for (i=0; i< nbEtatsFinaux; i++)
	{
		A.ensEtatsFinaux.add(ensEtatsFinaux.get(i));
		for (j=0; j<nbTransitions; j++)
		{
			if (ensTran.get(j).Sj.nbEtat == ensEtatsFinaux.get(i).nbEtat)
			{ 
				if(ensTran.get(j).Xi.equals("&"))
				{
					A.ensEtatsFinaux.add(ensTran.get(j).Si); 
			     	A.nbEtatsFinaux++; 	
				}
			}
		}
	}
	for (i=0; i<nbAlphabet; i++)
	{
		if (!ensAlphabet.get(i).equals("&"))
			A.ensAlphabet.add(ensAlphabet.get(i)); 
	}
	A.nbAlphabet=A.ensAlphabet.size(); 
	
	AutomateSimple B=new AutomateSimple();
	B.nbEtats= A.nbEtats;
	B.ensEtats= A.ensEtats; 
	B.nbEtatsInitiaux=A.nbEtatsInitiaux; 
	B.ensEtatsInitiaux=A.ensEtatsInitiaux; 
	B.nbEtatsFinaux=A.nbEtatsFinaux;
	B.nbAlphabet=A.nbAlphabet; 
	B.ensAlphabet=A.ensAlphabet;
	B.nbTransitions=0;
	while (AutomatePartilGeneralise(A))
	{	
		System.out.println("hello--");
		
		m=0; 
		for (i=0; i<A.nbTransitions ; i++)
		{
			
			if(!(A.ensTran.get(i).Xi.equals("&")))
			{
				B.ensTran.add(m,A.ensTran.get(i)); 
				m++;
			}
			else
			{
				for (int k=0; k<A.nbTransitions ; k++ )
				{
					if ((A.ensTran.get(i).Sj.nbEtat==A.ensTran.get(k).Si.nbEtat) && (i!=k))
					{
						Transition tr = new Transition(A.ensTran.get(i).Si, A.ensTran.get(k).Xi, A.ensTran.get(k).Sj); 
						B.ensTran.add(m,tr); 
						m++;
					}
				}
			}
		}
		
		B.nbTransitions=m; 
		A.nbTransitions=B.nbTransitions; 
		A=B; 
	}
	
	

	
	
	return A; 
}

}
