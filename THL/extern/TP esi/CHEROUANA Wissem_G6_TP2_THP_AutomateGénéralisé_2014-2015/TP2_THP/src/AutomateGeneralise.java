import java.util.*;


public class AutomateGeneralise {
	
	ArrayList<Etat> ensEtatsInitiaux= new ArrayList<Etat>(); 
	ArrayList<String> ensAlphabet= new ArrayList<String>(); 
	ArrayList<Etat> ensEtats= new ArrayList<Etat>(); 
	ArrayList<Etat> ensEtatsFinaux= new ArrayList<Etat>(); 	
	ArrayList<Transition> ensTranGen= new ArrayList<Transition>();
	
	int nbEtats; 
	int nbEtatsFinaux; 
	int nbTransitions; 
	int nbAlphabet;
	int nbEtatsInitiaux; 

	static String chaine=""; 
	static String chaine2=""; 
public void CreerAutomateGenralise() /**Création de l"automate généralise **/
{
	Scanner sc = new Scanner(System.in);
	System.out.print(" Veuillez saisir le nombre d'alphabet de l'automate : ");
	nbAlphabet = sc.nextInt();	
	while (ensAlphabet.size()<nbAlphabet) 
	{
		Scanner sc2 = new Scanner(System.in);
		System.out.print("	 - Alphabet "+(ensAlphabet.size()+1)+" : "); 
		String alph = sc2.nextLine(); 
		int exist=RechercheAlphabet(alph); 
		if (exist<0) 
		{
			ensAlphabet.add(alph); 
		}
		else 
		{
			System.out.println(" Attention /!\\ Alphabet déjà existant, veuillez en saisir un autre ! ");
		}
	}
	ensAlphabet.add("&"); 
	nbAlphabet=ensAlphabet.size(); 
	
	Scanner sc3 = new Scanner(System.in);
	System.out.print("\n Veuillez saisir le nombre d'états de l'automate : ");
	nbEtats = sc3.nextInt();
	int i=0; 
	while (ensEtats.size()<nbEtats) 
	{
		Etat etat = new Etat(i, false); 
		ensEtats.add(etat); 
		i++; 
	}
	
	 System.out.print(" - L'ensemble des états est : ");
	    System.out.print(" 	S = { ");
	    for (int i2=0; i2<nbEtats-1; i2++)
	    	 System.out.print("S"+ensEtats.get(i2).nbEtat+", ");
	    System.out.println("S"+ensEtats.get(nbEtats-1).nbEtat+" }");
	    
	
	Scanner sc0= new Scanner(System.in);
	System.out.print("\n Veuillez saisir le nombre d'états initiaux de l'automate : ");
	nbEtatsInitiaux = sc0.nextInt();
	while (ensEtatsInitiaux.size()<nbEtatsInitiaux) 
	{
		int cpt=1; 
		Scanner sc01 = new Scanner(System.in);
		System.out.print(" 	- Etat initial "+(ensEtatsInitiaux.size()+1)+" : S"); 
		int numEtat = sc01.nextInt(); 
		Etat etat = new Etat(numEtat, true); 
		if (RechercheEtat(numEtat)==true && cpt!=0 && ExistEtatInitial(numEtat)==false) 
		{
			ensEtatsInitiaux.add(etat); 
			cpt++;
		}
		else 
		{
			if (RechercheEtat(numEtat)==false)
			System.out.println(" Attention /!\\ Etat inexistant dans l'ensemble des états");
			else System.out.println(" Attention /!\\ Cet état existe déjà dans l'ensemble des états initiaux ");	
		}
	}
	
	
 	Scanner sc4 = new Scanner(System.in);
	System.out.print("\n Veuillez saisir le nombre d'états finaux de l'automate : ");
	nbEtatsFinaux = sc4.nextInt();
	while (ensEtatsFinaux.size()<nbEtatsFinaux) 
	{
		int cpt=1; 
		Scanner sc5 = new Scanner(System.in);
		System.out.print(" 	- Etat final "+(ensEtatsFinaux.size()+1)+" : S");
		int numEtat = sc4.nextInt(); 
		Etat etat = new Etat(numEtat, true); 
		if (RechercheEtat(numEtat)==true && cpt!=0 && ExistEtatFinal(numEtat)==false) 
		{
			ensEtats.get(numEtat).fin=true;
			ensEtatsFinaux.add(etat); 
			cpt++;
		}
		else 
		{
			if (RechercheEtat(numEtat)==false)
			System.out.println(" Attention /!\\ Etat inexistant dans l'ensemble des états");
			else System.out.println(" Attention /!\\ Cet état existe déjà dans l'ensemble des états finaux ");	
		}
	}
	
	
	Scanner sc5 = new Scanner(System.in);
	System.out.print("\n Veuillez saisir le nombre de transitions de l'automate : ");
	nbTransitions = sc5.nextInt();
	
	System.out.print("\n Le mot vide est noté : & ");
	while (ensTranGen.size()<nbTransitions)
	{
		
		int cpt=0, numEtat=0, numEtat2=0; 
		String alphabet=""; 
		boolean fin=false; 
		System.out.println("\n------ Instruction n°"+(ensTranGen.size()+1)+"------"); 
		System.out.print("- L'état de départ Si = S");
		Scanner sc6 = new Scanner(System.in);
		numEtat = sc6.nextInt();
		if (!RechercheEtat(numEtat))
		{
			System.out.println("  Attention /!\\ Etat de départ inexistant dans l'ensemble des états \n Retapez la transition :p");
			fin=true;
		}
		else
		{
			System.out.print("- Mot Xi = ");
			Scanner sc7 = new Scanner(System.in);
			alphabet = sc7.nextLine();
			if (motAppartientAlphabet(alphabet)==false)
			{ 
				System.out.println("  Attention /!\\ Un ou plusieurs alphabets de ce mot n'existent pas dans l'ensemble d'alphabets \n Retapez la transition :p");
				fin=true; 
			}
			else
			{
				System.out.print("- L'état d'arrivée Sj = S");
				Scanner sc8 = new Scanner(System.in);
				numEtat2 = sc8.nextInt();
				if (!RechercheEtat(numEtat2))
				{
					System.out.println("  Attention /!\\ Etat d'arrivée inexistant dans l'ensemble des états \n Retapez la transition :p");
					fin=true; 
				}
			}
		}
		if (!fin)
		{   Etat Si= new Etat(numEtat, ensEtats.get(numEtat).fin); 
			Etat Sj= new Etat(numEtat2, ensEtats.get(numEtat2).fin); 
			Transition tr = new Transition(Si,alphabet,Sj);
			ensTranGen.add(tr);
			cpt++;
		}
	}
	
}


public int RechercheAlphabet (String alphabet) /**Méthode permettant de vérifier si un alphabet existe dans l'ensemble d'alphabet ou non **/
{
	Collections.sort(ensAlphabet);
	return Collections.binarySearch(ensAlphabet, alphabet); 
}


public boolean RechercheEtat (int numEtat) /**Méthode permettant de vérifier si un état existe dans l'ensemble d'états ou non **/
{
	int i=0; 
	boolean trouv=false; 
	for (i=0; i<nbEtats; i++)
	{
		if (ensEtats.get(i).nbEtat == numEtat) trouv=true; 
	}
	return trouv; 
}


public boolean ExistEtatFinal (int numEtat)/**Méthode permettant de vérifier si un état final existe dans l'ensemble d'états finaux ou non **/
{
	int i=0; 
	boolean trouv=false; 
	for (i=0; i<ensEtatsFinaux.size(); i++)
	{
		if (ensEtatsFinaux.get(i).nbEtat == numEtat) trouv=true; 
	}
	return trouv; 
}

public boolean ExistEtatInitial (int numEtat) /**Méthode permettant de vérifier si un état initial existe dans l'ensemble d'états initiaux ou non **/
{
	int i=0; 
	boolean trouv=false; 
	for (i=0; i<ensEtatsInitiaux.size(); i++)
	{
		if (ensEtatsInitiaux.get(i).nbEtat == numEtat) trouv=true; 
	}
	return trouv; 
}

boolean BoucleInfinie() /** Méthode permettant de savoir si le nombre des transitions spontanées est égal au nombre de transition ==> cas d'une boucle infinie **/
{
	int i=0, cpt=0; 
	
	for (i=0; i<nbTransitions; i++)
	{
		if (ensTranGen.get(i).Xi.equals("&")) cpt++; 
	}
	if (cpt==nbTransitions) return true;
	else return false; 
}

boolean AutomatePartilGeneralise(AutomateSimple A) /**Méthode permettant de vérifier si un automate est encore partiellment généralisé ou pas **/ 
{
	boolean parGen=false;
	for (int i=0; i<A.nbTransitions; i++)
	{
		if (A.ensTran.get(i).Xi.equals("&")) parGen=true; 
	}
	return parGen; 
}


boolean motAppartientAlphabet(String mot) /** Méthode permettant de savoir si un mot entré dans la transition est formé de l'ensemble d'alphabets **/ 
{
    boolean trouve=true; 
	int i=0 ;
	for (i=0; i<mot.length();i++)
	{
		if (RechercheAlphabet(mot.substring(i,i+1))<0) trouve=false; 
	}
	return trouve;
	
}

public void afficheAutomateGeneralise() /** Méthode permettant d'afficher l'automate généralisé **/ 
{
	int i=0;
	
	System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("                                   Automate généralisé                                       "); 
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	
	 System.out.println(" - L'ensemble des états initiaux est : ");
	 System.out.print(" 	Si = { ");
	    for (i=0; i<nbEtatsInitiaux-1; i++)
	    	 System.out.print("S"+ensEtatsInitiaux.get(i).nbEtat+", ");
	    System.out.println("S"+ensEtatsInitiaux.get(nbEtatsInitiaux-1).nbEtat+" }");
   
	System.out.println(" - L'ensemble de l'alphabet est : ");
    System.out.print(" 	X = { ");
    for (i=0; i<ensAlphabet.size()-1; i++)
    	 System.out.print(ensAlphabet.get(i)+", ");
    System.out.println(ensAlphabet.get(ensAlphabet.size()-1)+" }");
    
    System.out.println(" - L'ensemble des états est : ");
    System.out.print(" 	S = { ");
    for (i=0; i<nbEtats-1; i++)
    	 System.out.print("S"+ensEtats.get(i).nbEtat+", ");
    System.out.println("S"+ensEtats.get(nbEtats-1).nbEtat+" }");
    
    System.out.println(" - L'ensemble des états finaux est : ");
    System.out.print(" 	F = { ");
    for (i=0; i<nbEtatsFinaux-1; i++)
    	 System.out.print("S"+ensEtatsFinaux.get(i).nbEtat+", ");
    System.out.println("S"+ensEtatsFinaux.get(nbEtatsFinaux-1).nbEtat+" }");
    
    System.out.println(" - L'ensemble des instructions est : ");
    System.out.print(" 	I = { ");
    for (i=0; i<nbTransitions-1; i++)
    {
    	 System.out.print("(S"+ensTranGen.get(i).Si.nbEtat+", "+ensTranGen.get(i).Xi+", S"+ensTranGen.get(i).Sj.nbEtat+"), ");
    }
    System.out.println("(S"+ensTranGen.get(nbTransitions-1).Si.nbEtat+", "+ensTranGen.get(nbTransitions-1).Xi+", S"+ensTranGen.get(nbTransitions-1).Sj.nbEtat+") } ");
} 


public AutomateSimple CreerAutomatePartielGeneralise() /** Création de l'automate simple **/ 
{
	int i=0; 
	AutomateSimple A = new AutomateSimple();
	A.ensEtats=ensEtats;
	A.ensEtatsInitiaux=ensEtatsInitiaux; 
	A.ensEtatsFinaux=ensEtatsFinaux; 
	A.nbEtatsFinaux=nbEtatsFinaux;
	A.nbEtatsInitiaux=nbEtatsInitiaux; 
	A.nbEtats=nbEtats;
	int nb=nbEtats; 
	for (i=0; i<nbTransitions; i++)
	{
		Transition trTmp = new Transition(); 
		trTmp=ensTranGen.get(i); 
		if ((trTmp.Xi).length()==1)   /** Si la longueur du mot de la transition est égal à 1 copier la transition dans l'ensemble **/ 
		{
			Transition tr2 = new Transition(trTmp.Si, trTmp.Xi, trTmp.Sj);
			A.ensTran.add(tr2); 
			if (A.RechercheAlphabet(trTmp.Xi)<0) A.ensAlphabet.add(trTmp.Xi); 
		}
		else /** Mot de longueur supérieur à 1 **/
		{
			String alphabetTemp= trTmp.Xi; 
			int tailleAlph = (trTmp.Xi).length(); /** On récupère la taille du mot **/ 
			int j=0; 
			while (j<tailleAlph)
			{ 
				Etat Si = new Etat(A.nbEtats-1, A.ensEtats.get(nbEtats-1).fin);
				Etat Sj = new Etat(A.nbEtats, false);
				String alpXi= alphabetTemp.substring(j,j+1); /** extraire un caractère du mot de la transition **/
				Transition tr3= new Transition(Si, alpXi,Sj  ); 
				A.ensTran.add(tr3); /** Mettre à jour l'automate **/ 
				if (A.RechercheAlphabet(alpXi)<0)A.ensAlphabet.add(alpXi); 
				A.nbEtats++;  /** Augmenter le nombre d'états: états intermédiaires **/ 
				j++;
			}
			A.ensTran.get(A.ensTran.size()-1).Sj=trTmp.Sj;
			A.ensTran.get(A.ensTran.size()-j).Si=trTmp.Si;
			A.nbEtats--; 
			Etat et=new Etat(A.nbEtats-1, false);
			A.ensEtats.add(et); 
		}
		A.nbTransitions=A.ensTran.size();
	}
	A.nbAlphabet=A.ensAlphabet.size(); 
	
	for (i=0; i<nb; i++)
	{
		A.ensEtats.get(i).fin= ensEtats.get(i).fin; 	
	}
	for (i=nb; i<A.nbEtats; i++)
	{
		A.ensEtats.get(i).fin=false;  		
	}
	
	
	
	System.out.println("\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("                        Automate partiellement généralisé                      "); 
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
	
	

	chaine=chaine+"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	chaine=chaine+"                                   Automate partiellement généralisé                                       \n"; 
	chaine=chaine+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	chaine=chaine+" - L'ensemble des états initiaux est : ";
	chaine=chaine+" Si = { ";
	    for (int i1=0; i1<A.nbEtatsInitiaux-1; i1++)
	    	 chaine=chaine+"S"+A.ensEtatsInitiaux.get(i1).nbEtat+", ";
	    chaine=chaine+"S"+A.ensEtatsInitiaux.get(A.nbEtatsInitiaux-1).nbEtat+" }";
	    chaine=chaine+"\n - L'ensemble de l'alphabet est : ";
	  chaine=chaine+" X = { ";
    for (int i1=0; i1<A.ensAlphabet.size()-1; i1++)
    	chaine=chaine+A.ensAlphabet.get(i1)+", ";
    chaine=chaine+A.ensAlphabet.get(A.ensAlphabet.size()-1)+" }";
    
    chaine=chaine+"\n - L'ensemble des états est : ";
    chaine=chaine+" S = { ";
    for (int i1=0; i1<A.nbEtats-1; i1++)
    	chaine=chaine+"S"+A.ensEtats.get(i1).nbEtat+", ";
    chaine=chaine+"S"+A.ensEtats.get(A.nbEtats-1).nbEtat+" }" ; 
    
    chaine=chaine+"\n - L'ensemble des états finaux est : ";
    chaine=chaine+" F = { ";
    for (int i1=0; i1<A.nbEtatsFinaux-1; i1++)
    	chaine=chaine+"S"+A.ensEtatsFinaux.get(i1).nbEtat+", ";
    	chaine=chaine+"S"+A.ensEtatsFinaux.get(A.nbEtatsFinaux-1).nbEtat+" }";
    
    	chaine=chaine+("\n - L'ensemble des instructions est : ");
    	chaine=chaine+(" I = { ");
    for (int i1=0; i1<A.nbTransitions-1; i1++)
    {
    	chaine=chaine+"(S"+A.ensTran.get(i1).Si.nbEtat+", "+A.ensTran.get(i1).Xi+", S"+A.ensTran.get(i1).Sj.nbEtat+"), ";
    }
    chaine=chaine+"(S"+A.ensTran.get(A.nbTransitions-1).Si.nbEtat+", "+A.ensTran.get(A.nbTransitions-1).Xi+", S"+A.ensTran.get(A.nbTransitions-1).Sj.nbEtat+") } ";

   
	
	A.afficheAutomateSimplee(); /** Affichage de l'automate partiellement généralisé **/ 
	
	AutomateSimple autSimp = new AutomateSimple();  
	int j,m = 0; 
	autSimp.nbEtats=A.nbEtats;
	autSimp.ensEtats=A.ensEtats; 
	autSimp.nbEtatsInitiaux=A.nbEtatsInitiaux; 
	autSimp.ensEtatsInitiaux=A.ensEtatsInitiaux; 
	autSimp.nbEtatsFinaux=A.nbEtatsFinaux; 
	for (i=0; i<A.nbEtatsFinaux; i++)
	{
		autSimp.ensEtatsFinaux.add(A.ensEtatsFinaux.get(i));
		for (j=0; j<A.nbTransitions; j++)
		{
			if (A.ensTran.get(j).Sj.nbEtat == A.ensEtatsFinaux.get(i).nbEtat)
			{ 
				if(A.ensTran.get(j).Xi.equals("&"))
				{
					autSimp.ensEtatsFinaux.add(A.ensTran.get(j).Si); 
					autSimp.nbEtatsFinaux++; 	
				}
			}
		}
	}
	for (i=0; i<A.nbAlphabet; i++)
	{
		if (!A.ensAlphabet.get(i).equals("&"))
			autSimp.ensAlphabet.add(A.ensAlphabet.get(i)); 
	}
	autSimp.nbAlphabet=autSimp.ensAlphabet.size(); 
	
	/** Mise à jour des états finaux de l'automate simple **/

	Transition [] tab= new Transition[1000]; 
	while (AutomatePartilGeneralise(A)) /** Tant que l'automate est partiellement généralisé : contient de transitions spontanées **/ 
	{	
		m=0; 
		for (i=0; i<A.nbTransitions ; i++) /** Parcourir l'ensemble des transitions **/ 
		{
			
			if(!(A.ensTran.get(i).Xi.equals("&"))) 
			{
				tab[m]= A.ensTran.get(i);  
				m++;
			}
			else /** Si le mot de la transtion est vide **/ 
			{
				for (int k=0; k<A.nbTransitions ; k++ )
				{
					if ((A.ensTran.get(i).Sj.nbEtat==A.ensTran.get(k).Si.nbEtat) && (i!=k))
					{
						Transition tr = new Transition(A.ensTran.get(i).Si, A.ensTran.get(k).Xi, A.ensTran.get(k).Sj); 
						tab[m]= tr; 
						m++;
					}
				}
			}
		}		
		A.nbTransitions=m; 

		for (int z=0 ; z<A.nbTransitions; z++)
		{
			A.ensTran.add(z,tab[z]); 
		}
		A.ensAlphabet=autSimp.ensAlphabet; 
	}
	
	autSimp.ensTran=A.ensTran; 
	autSimp.nbTransitions=A.nbTransitions; 
	
	System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	System.out.println("                                Automate simple                                "); 
	System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");	
	

	chaine2=chaine2+"\n\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	chaine2=chaine2+"                                   Automate simple                                      \n"; 
	chaine2=chaine2+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
	chaine2=chaine2+" - L'ensemble des états initiaux est : ";
	chaine2=chaine2+" Si = { ";
	    for (int i1=0; i1<autSimp.nbEtatsInitiaux-1; i1++)
	    	 chaine2=chaine2+"S"+autSimp.ensEtatsInitiaux.get(i1).nbEtat+", ";
	    chaine2=chaine2+"S"+autSimp.ensEtatsInitiaux.get(autSimp.nbEtatsInitiaux-1).nbEtat+" }";
	    chaine2=chaine2+"\n - L'ensemble de l'alphabet est : ";
	  chaine2=chaine2+" X = { ";
    for (int i1=0; i1<autSimp.ensAlphabet.size()-1; i1++)
    	chaine2=chaine2+autSimp.ensAlphabet.get(i1)+", ";
    chaine2=chaine2+A.ensAlphabet.get(autSimp.ensAlphabet.size()-1)+" }";
    
    chaine2=chaine2+"\n - L'ensemble des états est : ";
    chaine2=chaine2+" S = { ";
    for (int i1=0; i1<autSimp.nbEtats-1; i1++)
    	chaine2=chaine2+"S"+autSimp.ensEtats.get(i1).nbEtat+", ";
    chaine2=chaine2+"S"+A.ensEtats.get(autSimp.nbEtats-1).nbEtat+" }" ; 
    
    chaine2=chaine2+"\n - L'ensemble des états finaux est : ";
    chaine2=chaine2+" F = { ";
    for (int i1=0; i1<autSimp.nbEtatsFinaux-1; i1++)
    	chaine2=chaine2+"S"+autSimp.ensEtatsFinaux.get(i1).nbEtat+", ";
    	chaine2=chaine2+"S"+autSimp.ensEtatsFinaux.get(autSimp.nbEtatsFinaux-1).nbEtat+" }";
    
    	chaine2=chaine2+("\n - L'ensemble des instructions est : ");
    	chaine2=chaine2+(" I = { ");
    for (int i1=0; i1<autSimp.nbTransitions-1; i1++)
    {
    	chaine2=chaine2+"(S"+autSimp.ensTran.get(i1).Si.nbEtat+", "+autSimp.ensTran.get(i1).Xi+", S"+autSimp.ensTran.get(i1).Sj.nbEtat+"), ";
    }
    chaine2=chaine2+"(S"+autSimp.ensTran.get(autSimp.nbTransitions-1).Si.nbEtat+", "+autSimp.ensTran.get(autSimp.nbTransitions-1).Xi+", S"+autSimp.ensTran.get(autSimp.nbTransitions-1).Sj.nbEtat+") } ";

   
	
	return autSimp; 
}

 
}



