import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;


public class PanelInfo extends JPanel{ /**Panel permettant d'afficher les automates **/ 

	private static final long serialVersionUID = 2677739331449435679L;
	private static final PanelInfo instance = new PanelInfo();
	public static SimpleAttributeSet STYLE_NORMAL;
	public static SimpleAttributeSet STYLE_INFO;
	public static SimpleAttributeSet STYLE_TITRE;
	public static SimpleAttributeSet TITRE_CENTRE;
	public JTextPane stat;
	//public JTextPane combinaison;

	public JTextPane textPane;

	private Image image;

	public PanelInfo(){
		creerStyles();
		
		this.setOpaque(false);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(5, 10, 5, 10);
		c.weightx=1;
		c.weighty=3;
		c.gridx=1;
		c.gridy=1;
		stat = new JTextPane();
		stat.setPreferredSize(new Dimension(1200, 700));
		stat.setOpaque(false);
		//afficherStat(0, 0, 0, 0);
		JScrollPane scrollStat = new JScrollPane(stat);
		scrollStat.setOpaque(false);
		scrollStat.getViewport().setOpaque(false);
		TitledBorder borderStat = BorderFactory.createTitledBorder("Affichage des automates");
		borderStat.setTitleColor(Color.BLACK);
		borderStat.setTitleFont(new Font("Brush Script MT", Font.PLAIN, 30));
		scrollStat.setBorder(borderStat);
		add(scrollStat, c);
		c.gridy=2;
		textPane = new JTextPane();
		textPane.setEditable(false);
		

		c.gridy=3;

	}

	private void creerStyles(){
		STYLE_TITRE = new SimpleAttributeSet();
		StyleConstants.setFontFamily(STYLE_TITRE, "Times New Roman");
		StyleConstants.setFontSize(STYLE_TITRE, 15);
		StyleConstants.setForeground(STYLE_TITRE, Color.BLACK);
		StyleConstants.setBold(STYLE_TITRE, true);

		TITRE_CENTRE = new SimpleAttributeSet();
		StyleConstants.setAlignment(TITRE_CENTRE, StyleConstants.ALIGN_CENTER);

		STYLE_NORMAL = new SimpleAttributeSet();
		StyleConstants.setFontFamily(STYLE_NORMAL, "Times New Roman");
		StyleConstants.setForeground(STYLE_NORMAL, Color.BLACK);
		StyleConstants.setFontSize(STYLE_NORMAL, 15);

		STYLE_INFO = new SimpleAttributeSet();
		StyleConstants.setFontFamily(STYLE_INFO, "Times New Roman");
		StyleConstants.setFontSize(STYLE_INFO, 15);
		StyleConstants.setForeground(STYLE_INFO, Color.BLACK);
	}

	

	


	
}
