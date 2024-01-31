import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;



public class AutomateGeneraliseInterface extends JPanel implements ActionListener { /**Classe de l'automate genéralisé**/ 
	
	
	JPanel pan = new JPanel();
	private static final long serialVersionUID = 1L;
	JFrame fen= new JFrame(); 
	JFrame fen2= new JFrame(); 
	AutomateGeneralise aut = new AutomateGeneralise(); 
	JTextField nbAlphabet = new JTextField("");
	JTextField nbEtats = new JTextField("");
	JTextField nbEtatsInitiaux = new JTextField("");
	JTextField nbEtatsFinaux = new JTextField("");
	JTextField nbTransitions = new JTextField("");
	ArrayList<JTextField> ensEtatsInitiaux= new ArrayList<JTextField>(); 
	ArrayList<JTextField> ensAlphabet= new ArrayList<JTextField>(); 
	ArrayList<JTextField> ensEtats= new ArrayList<JTextField>(); 
	ArrayList<JTextField> ensEtatsFinaux= new ArrayList<JTextField>(); 	
	ArrayList<JTextField> ensTrans= new ArrayList<JTextField>(); 
	Font   titleFont3  = new Font("Times New Roman", Font.ITALIC, 15);
	static String chaine =""; 
	AutomateGeneraliseInterface() throws IOException,  Exception, Throwable,  EnsNonValide
	{ 
		JPanel pan1= new JPanel(); 
		pan1.setPreferredSize(new Dimension(300, 200));
		pan1.setLocation(0, 0);
		JLabel lb1 = new JLabel("Nombre d'alphabet de l'automate"); 
		JLabel lb2 = new JLabel("Nombre d'états de l'automate"); 
		JLabel lb3 = new JLabel("Nombre d'états initiaux de l'automate"); 
		JLabel lb4 = new JLabel("Nombre d'états finaux de l'automate"); 
		JLabel lb5 = new JLabel("Nombre de transitions de l'automate"); 
		pan1.add(lb1);
		lb1.setPreferredSize(new Dimension(230,30));
		
		nbAlphabet.setPreferredSize(new Dimension(30,30)); 
		pan1.add(nbAlphabet); 
		pan1.add(lb2);
		lb2.setPreferredSize(new Dimension(230,30));
		nbEtats.setPreferredSize(new Dimension(30,30)); 
		pan1.add(nbEtats); 
		pan1.add(lb3); 
		lb3.setPreferredSize(new Dimension(230,30));
		nbEtatsInitiaux.setPreferredSize(new Dimension(30,30)); 
		pan1.add(nbEtatsInitiaux); 
		pan1.add(lb4);
		lb4.setPreferredSize(new Dimension(230,30));
		nbEtatsFinaux.setPreferredSize(new Dimension(30,30)); 
		pan1.add(nbEtatsFinaux); 
		pan1.add(lb5);
		lb5.setPreferredSize(new Dimension(230,30));
		nbTransitions.setPreferredSize(new Dimension(30,30)); 
		pan1.add(nbTransitions); 
		this.add(pan1, BorderLayout.WEST);
		JButton valider = new JButton("Valider"); 
		valider.setPreferredSize(new Dimension(100,30));
		this.add(valider);
		valider.addActionListener(new ValiderNb()); 
	}
	
	class ValiderNb implements ActionListener  
	{
		public void actionPerformed(ActionEvent arg0) 
		{
			boolean trouve=false; 
			
			try { 
				 int i = Integer.parseInt(nbEtats.getText()); 
				 i = Integer.parseInt(nbAlphabet.getText()); 
				 i = Integer.parseInt(nbEtatsInitiaux.getText()); 
				 i = Integer.parseInt(nbEtatsFinaux.getText()); 
				 i = Integer.parseInt(nbTransitions.getText()); 
				 trouve=true; 
				 if (Integer.parseInt(nbEtats.getText()) < Integer.parseInt(nbEtatsInitiaux.getText())) throw new nbInitSup() ;				 if (Integer.parseInt(nbEtats.getText()) < Integer.parseInt(nbEtatsFinaux.getText())) throw new nbFinauxSup();
				} 
			catch (nbInitSup e) { 
				trouve=false; 
				JOptionPane pos; 
				pos = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Attention ! Le nombre d'états initiaux doit être inférieur ou égal aux nombre d'états ", "Indication", JOptionPane.WARNING_MESSAGE);
			}
			catch (nbFinauxSup e) { 
				JOptionPane pos; 
				trouve=false; 
				pos = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Attention ! Le nombre d'états finaux doit être inférieur ou égal aux nombre d'états ", "Indication", JOptionPane.WARNING_MESSAGE);
			}
			
				catch (Exception e) { 
					JOptionPane pos; 
					trouve=false; 
					pos = new JOptionPane();
				JOptionPane.showMessageDialog(null, " Attention ! Vérifiez que tous les champs sont remplis et qu'ils contiennent des nombres entiers ", "Indication", JOptionPane.WARNING_MESSAGE);
				}
				if (trouve)
				{
				
				fen.setSize(900, 700);
				fen.setTitle("Création de l'automate");
				fen.setLocation(150, 0);
				JPanel pan = new JPanel();
				JPanel pan2 = new JPanel();
				JPanel pan3 = new JPanel();
				JPanel pan4 = new JPanel();
				JPanel pan5 = new JPanel();
				JPanel pan6 = new JPanel();
				fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fen.setLayout(new FlowLayout());
				fen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				pan.setPreferredSize(new Dimension(700,100));
				pan2.setPreferredSize(new Dimension(700,50));
				pan3.setPreferredSize(new Dimension(700,100));
				pan4.setPreferredSize(new Dimension(700,100));
				pan5.setPreferredSize(new Dimension(700,100));
				pan6.setPreferredSize(new Dimension(700,100));
				fen.add(pan);
				fen.add(pan2);
				fen.add(pan3);
				fen.add(pan4);
				fen.add(pan5);
				JLabel lb1= new JLabel("Ensemble de l'alphabet :"); 
				pan.add(lb1);
				lb1.setPreferredSize(new Dimension(200,30));
				
				for (int i2=0; i2<Integer.parseInt(nbAlphabet.getText()); i2++) 
				{
					JTextField m =new LimitedTextField(1); 
					m.setPreferredSize(new Dimension(30,30));
					pan.add(m); 
					ensAlphabet.add(m); 
				}
				JLabel lb= new JLabel("Le mot vide est noté : & \n          L'ensemble des états est : { "); 
				String chaine=""; 
				
				for (int i=0; i<Integer.parseInt(nbEtats.getText()); i++)
				{
					Etat et = new Etat(i, false);
					aut.ensEtats.add(et);
					chaine+="S"+i+", ";
				}
				chaine+=" }"; 
				lb.setText(lb.getText()+chaine);
				aut.nbEtats=aut.ensEtats.size(); 
				pan2.add(lb);
				JLabel lb3= new JLabel("Ensemble des états initiaux - Syntaxe: Si -"); 
				lb3.setPreferredSize(new Dimension(250,30));
				pan3.add(lb3);
				for (int i2=0; i2<Integer.parseInt(nbEtatsInitiaux.getText()); i2++) 
				{
					JTextField m =new JTextField(""); 
					m.setPreferredSize(new Dimension(30,30));
					pan3.add(m); 
					ensEtatsInitiaux.add(m);
				}
				
				JLabel lb4= new JLabel("Ensemble des états Finaux - Syntaxe: Sj -"); 
				lb4.setPreferredSize(new Dimension(250,30));
				pan4.add(lb4);
				for (int i2=0; i2<Integer.parseInt(nbEtatsFinaux.getText()); i2++) 
				{
					JTextField m =new JTextField(""); 
					m.setPreferredSize(new Dimension(30,30));
					pan4.add(m); 
					ensEtatsFinaux.add(m);
				}
				
				JLabel lb5= new JLabel("Ensemble des états transitions - Syntaxe: Si,Wi,Sj - "); 
				lb5.setPreferredSize(new Dimension(300,30));
				pan5.add(lb5);
				for (int i2=0; i2<Integer.parseInt(nbTransitions.getText()); i2++) 
				{
					JTextField m =new JTextField(""); 
					m.setPreferredSize(new Dimension(70,30));
					pan5.add(m); 
					ensTrans.add(m);
				}
				JButton valider2 = new JButton("Valider"); 
				valider2.setPreferredSize(new Dimension(100, 30));
				valider2.addActionListener(new ValiderEns());
				pan6.add(valider2); 
				fen.add(pan6);
				fen.setVisible(true);
				
				}
		}
	}
	
	class ValiderEns implements ActionListener   
	{
		
		
		boolean erreur=false; 
		public void actionPerformed(ActionEvent arg0) 
		{
			
		for (int i=0; i<Integer.parseInt(nbAlphabet.getText()); i++)
			{
				if (aut.RechercheAlphabet(ensAlphabet.get(i).getText())<0)
					aut.ensAlphabet.add(ensAlphabet.get(i).getText()); 
				
			}
			aut.ensAlphabet.add("&"); 
			aut.nbAlphabet=aut.ensAlphabet.size();
			
			
			
			
			boolean b1=false; 
			for (int i=0; i<Integer.parseInt(nbEtatsInitiaux.getText()); i++)
			{
				try
				{
					String chaine = ensEtatsInitiaux.get(i).getText().substring(1,ensEtatsInitiaux.get(i).getText().length() );  
					if (aut.RechercheEtat(Integer.parseInt(chaine))==true)
						{   
							System.out.print("");
						}
						else throw new EnsNonValide();
					}			
				catch (EnsNonValide e)
				{
					b1=true; 
				}
				catch (Exception e) { 
					b1=true; 
				}
			
			}
			
			if (b1)
			{
				JOptionPane pos; 
				pos = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Attention ! Erreur dans la saisie des états initiaux ", "Indication", JOptionPane.WARNING_MESSAGE);
			}
			
		
			boolean b2=false; 
			for (int i=0; i<Integer.parseInt(nbEtatsFinaux.getText()); i++)
			{  
				try
				{
					String chaine = ensEtatsFinaux.get(i).getText().substring(1,ensEtatsFinaux.get(i).getText().length() );  
					if (aut.RechercheEtat(Integer.parseInt(chaine))==true)
					{   
						
						System.out.print("");
					}
					else throw new EnsNonValide();
				}
				catch (EnsNonValide e2)
				{ 
					b2=true; 
				}	
				catch (Exception e) { 
					b2=true; 
				}
				
			}
			if (b2)
			{
				JOptionPane pos2; 
				pos2 = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Attention ! Erreur dans la saisie des états finaux ", "Indication", JOptionPane.WARNING_MESSAGE);
			} 
			
			boolean b3=false; 
			for (int i=0; i<Integer.parseInt(nbTransitions.getText()); i++)
			{  
				try
				{
					String chaine = ensTrans.get(i).getText(); 
					String[] te = (chaine.split(",")); 
					String c1= te[0].substring(1,te[0].length()); 
					String c2= te[1];
					String c3 = te[2].substring(1,te[2].length());
					System.out.println(c1+"--"+c2+"--"+c3);
					if ((aut.RechercheEtat(Integer.parseInt(c1))) && (aut.motAppartientAlphabet(c2)) && (aut.RechercheEtat(Integer.parseInt(c3))))
					{ 
						System.out.print("");
					}
					
					else throw new EnsNonValide();
				}
				catch (EnsNonValide e2)
				{ 
					b3=true; 
				}	
				catch (Exception e) 
				{ 
					
					
					b3=true; 
					System.out.println(b3);
				}
				
			}
			if (b3)
			{
				JOptionPane pos3	; 
				pos3 = new JOptionPane();
			JOptionPane.showMessageDialog(null, " Attention ! Erreur dans la saisie des transitions ", "Indication", JOptionPane.WARNING_MESSAGE);
			} 
		
			
			if ( !b1 && !b2 && !b3)
			{
				
				
				pan.setVisible(true);
				
				for (int i=0; i<Integer.parseInt(nbEtatsInitiaux.getText()); i++)
				{
					String chaine = ensEtatsInitiaux.get(i).getText().substring(1,ensEtatsInitiaux.get(i).getText().length() );  
					aut.ensEtatsInitiaux.add(aut.ensEtats.get(Integer.parseInt(chaine)));
				}
				aut.nbEtatsInitiaux=aut.ensEtatsInitiaux.size();
				
				
				for (int i=0; i<Integer.parseInt(nbEtatsFinaux.getText()); i++)
				{  
					
						String chaine = ensEtatsFinaux.get(i).getText().substring(1,ensEtatsFinaux.get(i).getText().length() );  
						aut.ensEtatsFinaux.add(aut.ensEtats.get(Integer.parseInt(chaine)));
				}
				aut.nbEtatsFinaux=aut.ensEtatsFinaux.size();
				
				for (int i=0; i<Integer.parseInt(nbTransitions.getText()); i++)
				{  
						String chaine = ensTrans.get(i).getText(); 
						String[] te = (chaine.split(",")); 
						String c1= te[0].substring(1,te[0].length()); 
						String c2= te[1];
						String c3 = te[2].substring(1,te[2].length());
						
						Transition tr = new Transition (aut.ensEtats.get(Integer.parseInt(c1)), c2, aut.ensEtats.get(Integer.parseInt(c3))); 
						aut.ensTranGen.add(tr); 
							
				}
				aut.nbTransitions=aut.ensTranGen.size();
				
				try
				{
					if (!aut.BoucleInfinie()) 
					{aut.afficheAutomateGeneralise();
								
					
				   
				    fen.dispose();
				    
					fen2.setSize(1000, 700);
					fen2.setLocation(0, 150);
					fen2.setTitle("Affichage des automates");
					pan.setPreferredSize(new Dimension(fen2.getHeight(), fen2.getWidth()));
					JTextArea a = new JTextArea(); 
					JTextPane aa= new JTextPane(); 
					aa.setText(chaine);
					aa.setFont(titleFont3);
					PanelInfo infos = new PanelInfo(); 
					pan.repaint();
					infos.setOpaque(false);
					
					
					chaine=chaine+"\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
					chaine=chaine+"                                   Automate généralisé                                       \n"; 
					chaine=chaine+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
					chaine=chaine+" - L'ensemble des états initiaux est : ";
					chaine=chaine+" Si = { ";
					    for (int i=0; i<aut.nbEtatsInitiaux-1; i++)
					    	 chaine=chaine+"S"+aut.ensEtatsInitiaux.get(i).nbEtat+", ";
					    chaine=chaine+"S"+aut.ensEtatsInitiaux.get(aut.nbEtatsInitiaux-1).nbEtat+" }";
					    chaine=chaine+"\n - L'ensemble de l'alphabet est : ";
					  chaine=chaine+" X = { ";
				    for (int i=0; i<aut.ensAlphabet.size()-1; i++)
				    	chaine=chaine+aut.ensAlphabet.get(i)+", ";
				    chaine=chaine+aut.ensAlphabet.get(aut.ensAlphabet.size()-1)+" }";
				    
				    chaine=chaine+"\n - L'ensemble des états est : ";
				    chaine=chaine+" S = { ";
				    for (int i=0; i<aut.nbEtats-1; i++)
				    	chaine=chaine+"S"+aut.ensEtats.get(i).nbEtat+", ";
				    chaine=chaine+"S"+aut.ensEtats.get(aut.nbEtats-1).nbEtat+" }" ; 
				    
				    chaine=chaine+"\n - L'ensemble des états finaux est : ";
				    chaine=chaine+" F = { ";
				    for (int i=0; i<aut.nbEtatsFinaux-1; i++)
				    	chaine=chaine+"S"+aut.ensEtatsFinaux.get(i).nbEtat+", ";
				    	chaine=chaine+"S"+aut.ensEtatsFinaux.get(aut.nbEtatsFinaux-1).nbEtat+" }";
				    
				    	chaine=chaine+("\n - L'ensemble des instructions est : ");
				    	chaine=chaine+(" I = { ");
				    for (int i=0; i<aut.nbTransitions-1; i++)
				    {
				    	chaine=chaine+"(S"+aut.ensTranGen.get(i).Si.nbEtat+", "+aut.ensTranGen.get(i).Xi+", S"+aut.ensTranGen.get(i).Sj.nbEtat+"), ";
				    }
				    chaine=chaine+"(S"+aut.ensTranGen.get(aut.nbTransitions-1).Si.nbEtat+", "+aut.ensTranGen.get(aut.nbTransitions-1).Xi+", S"+aut.ensTranGen.get(aut.nbTransitions-1).Sj.nbEtat+") } ";
				  
				    AutomateSimple B; 
					B= aut.CreerAutomatePartielGeneralise();
				    B.afficheAutomateSimplee();
					
				    chaine+="";
				    chaine+=AutomateGeneralise.chaine;
				    chaine+="";
				    chaine+=AutomateGeneralise.chaine2; 
					
				    infos.stat.setText(chaine);
				    infos.stat.setFont(new Font("Times New Roman", Font.ITALIC,15));
				    pan.add(infos);
				   	fen2.add(pan);
					fen2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					fen2.setExtendedState(fen.MAXIMIZED_BOTH);
					fen2.setVisible(true);
					
					}
					else throw new BoucleInfinie(); 
					
				}
				catch (BoucleInfinie e)
				{
					JOptionPane pos; 
					pos = new JOptionPane();
				JOptionPane.showMessageDialog(null, " Attention ! Comme il n'existe que des transitions spontanées, il y aura boucle infinie :p ", "Indication", JOptionPane.WARNING_MESSAGE);
				
				}
				
				
				
			}
			else
			{
				aut.ensEtatsInitiaux= new ArrayList<Etat>(); 
				aut.ensAlphabet= new ArrayList<String>(); 
				aut.ensEtatsFinaux= new ArrayList<Etat>(); 	
				aut.ensTranGen= new ArrayList<Transition>();
				aut.nbAlphabet=0;
				aut.nbEtatsFinaux=0;
				aut.nbEtatsInitiaux=0;
				aut.nbTransitions=0;
			}
				
			
		}
		
		
	}
	
	



	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
		}
 




