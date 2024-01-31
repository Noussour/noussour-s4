import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException, Exception, Throwable {
		
	/**En mode graphique **/ 	
		Fenetre in= new Fenetre(); 
		in.setVisible(true);
	/** En mode Console **/
		AutomateGeneralise A= new AutomateGeneralise(); 
		A.CreerAutomateGenralise();
	    A.afficheAutomateGeneralise();
		AutomateSimple B,C,D; 
		B= A.CreerAutomatePartielGeneralise();
	    B.afficheAutomateSimplee();
	}

}
