import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout; 
import javax.swing.BoxLayout;
import javax.swing.Box;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Font;
import java.io.*;
import java.lang.Object;
import javax.swing.UIManager;
import javax.swing.plaf.metal.*;
import javax.swing.JLayeredPane;

public class Fenetre extends JFrame{
    // Dimension de la fenetre :
    private int X = 700;
    private int Y = 500;
    int indice = 0;

    // Liste de toutes les pages affichables
    private CardLayout cl = new CardLayout();
    private JPanel content = new JPanel();
    private String[] listContent = {"renduFaute", "choisirEquipe", "choisirJoueur", "typeFaute"};


    public Fenetre(){
	/* Paramètre de la fenetre */
	this.setTitle("Début des boutons");
	this.setSize(X + 20, Y + 20);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setLocationRelativeTo(null);
      
	try {
	    UIManager.setLookAndFeel(new MetalLookAndFeel());
	} catch (Exception e) {
	    System.out.println("Problème d'affichage");
	}
	
	// content.setLayout(cl);

	this.typeFaute(1, "Rouge");

	this.setVisible(true);
    }


    public void openClassAction() {
	CardLayout cl = new CardLayout();
	JPanel content = new JPanel();
	//Liste des noms de nos conteneurs pour la pile de cartes
	String[] listContent = {"CARD_1", "CARD_2", "CARD_3"};

	//On crée trois conteneurs de couleur différente
	JPanel card1 = new JPanel();
	card1.setBackground(Color.blue);		
	JPanel card2 = new JPanel();
	card2.setBackground(Color.red);		
	JPanel card3 = new JPanel();
	card3.setBackground(Color.green);

	JPanel boutonPane = new JPanel();
	JButton bouton = new JButton("Contenu suivant");
	//Définition de l'action du bouton
	bouton.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){
		    //Via cette instruction, on passe au prochain conteneur de la pile
		    cl.next(content);
		}
	    });
		
	JButton bouton2 = new JButton("Contenu par indice");
	//Définition de l'action du bouton2
	bouton2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){				
		    if(++indice > 2)
			indice = 0;
		    //Via cette instruction, on passe au conteneur correspondant au nom fourni en paramètre
		    cl.show(content, listContent[indice]);
		}
	    });
		
	boutonPane.add(bouton);
	boutonPane.add(bouton2);
	//On définit le layout
	content.setLayout(cl);
	//On ajoute les cartes à la pile avec un nom pour les retrouver
	content.add(card1, listContent[0]);
	content.add(card2, listContent[1]);
	content.add(card3, listContent[2]);

	this.getContentPane().add(boutonPane, BorderLayout.NORTH);
	this.getContentPane().add(content, BorderLayout.CENTER);

    }

    public JPanel openClass() {
	//On crée nos différents conteneurs de couleur différente
	JPanel cell1 = new JPanel();
	cell1.setBackground(Color.YELLOW);
	cell1.setPreferredSize(new Dimension(60, 40));		
	JPanel cell2 = new JPanel();
	cell2.setBackground(Color.red);
	cell2.setPreferredSize(new Dimension(60, 40));
	JPanel cell3 = new JPanel();
	cell3.setBackground(Color.green);
	cell3.setPreferredSize(new Dimension(60, 40));
	JPanel cell4 = new JPanel();
	cell4.setBackground(Color.black);
	cell4.setPreferredSize(new Dimension(60, 40));
	JPanel cell5 = new JPanel();
	cell5.setBackground(Color.cyan);
	cell5.setPreferredSize(new Dimension(60, 40));
	JPanel cell6 = new JPanel();
	cell6.setBackground(Color.BLUE);
	cell6.setPreferredSize(new Dimension(60, 40));
	JPanel cell7 = new JPanel();
	cell7.setBackground(Color.orange);
	cell7.setPreferredSize(new Dimension(60, 40));
	JPanel cell8 = new JPanel();
	cell8.setBackground(Color.DARK_GRAY);
	cell8.setPreferredSize(new Dimension(60, 40));
		
	//Le conteneur principal
	JPanel content = new JPanel();
	content.setPreferredSize(new Dimension(300, 120));
	content.setBackground(Color.WHITE);
	//On définit le layout manager
	content.setLayout(new GridBagLayout());
		
	//L'objet servant à positionner les composants
	GridBagConstraints gbc = new GridBagConstraints();
		
	//On positionne la case de départ du composant
	gbc.gridx = 0;
	gbc.gridy = 0;
	//La taille en hauteur et en largeur
	gbc.gridheight = 1;
	gbc.gridwidth = 1;
	content.add(cell1, gbc);
	//---------------------------------------------
	gbc.gridx = 1;
	content.add(cell2, gbc);
	//---------------------------------------------
	gbc.gridx = 2;		
	content.add(cell3, gbc);		
	//---------------------------------------------
	//Cette instruction informe le layout que c'est une fin de ligne
	gbc.gridwidth = GridBagConstraints.REMAINDER;
	gbc.gridx = 3;	
	content.add(cell4, gbc);
	//---------------------------------------------
	gbc.gridx = 0;
	gbc.gridy = 1;
	gbc.gridwidth = 1;
	gbc.gridheight = 2;
	//Celle-ci indique que la cellule se réplique de façon verticale
	gbc.fill = GridBagConstraints.VERTICAL;
	content.add(cell5, gbc);
	//---------------------------------------------
	gbc.gridx = 1;
	gbc.gridheight = 1;
	//Celle-ci indique que la cellule se réplique de façon horizontale
	gbc.fill = GridBagConstraints.HORIZONTAL;
	gbc.gridwidth = GridBagConstraints.REMAINDER;
	content.add(cell6, gbc);
	//---------------------------------------------
	gbc.gridx = 1;
	gbc.gridy = 2;
	gbc.gridwidth = 2;
	content.add(cell7, gbc);
	//---------------------------------------------
	gbc.gridx = 3;
	gbc.gridwidth = GridBagConstraints.REMAINDER;
	content.add(cell8, gbc);
	//---------------------------------------------


	return content;
    }

    public JPanel unBouton(String s) {
	JPanel pan = new JPanel();
	JButton bouton = new JButton(s);
	pan.add(bouton);
	
	return pan;
    }

    public void boutonToutEcran(String s) {
	JButton bouton = new JButton(s);
	this.getContentPane().add(bouton);
    }

    public void plusieursBoutons() {
	this.setLayout(new BorderLayout());
	this.getContentPane().add(new JButton("Nord"), BorderLayout.NORTH);
	this.getContentPane().add(new JButton("Ouest"), BorderLayout.WEST);
	this.getContentPane().add(new JButton("Centre"), BorderLayout.CENTER);
	this.getContentPane().add(new JButton("Est"), BorderLayout.EAST);
	this.getContentPane().add(new JButton("Sud"), BorderLayout.SOUTH);
    }


    // TODO : Action
    public void choisirEquipe() {
	Font font = new Font("Equipe", Font.BOLD, 50);

	JButton bleu = new JButton("BLEU");
	bleu.setBackground(Color.BLUE);
	bleu.setForeground(Color.WHITE);
	bleu.setFont(font);
	bleu.setPreferredSize(new Dimension(X/2, Y));

	JButton rouge = new JButton("ROUGE");
	rouge.setBackground(Color.RED);
	rouge.setForeground(Color.WHITE);
	rouge.setFont(font);
	rouge.setPreferredSize(new Dimension(X/2, Y));

	JPanel all = new JPanel();
	all.add(bleu);
	all.add(rouge);
	content.add(all, listContent[1]);
	
	this.setContentPane(all);

	
    }

    // TODO : action des boutons
    public void choisirJoueur() {
	JPanel all = new JPanel();
	Font font = new Font("Joueurs", Font.BOLD, 100);

	for (int i = 1; i< 6; i++) {
	    JButton j = new JButton();
	    final int k = i;
	    j.setFont(font);
	    j.setText(Integer.toString(i));
	    j.setBackground(Color.WHITE);
	    j.setPreferredSize(new Dimension(X/3, Y/2));
	    all.add(j);
	}

	JButton j = new JButton();
	Font changeFont = new Font("Joueurs", Font.BOLD, 20);
	j.setText("Changement");
	j.setFont(changeFont);
	j.setBackground(Color.WHITE);
	j.setPreferredSize(new Dimension(X/3, Y/2));
	all.add(j);
	content.add(all, listContent[2]);

	this.setContentPane(all);
    }

    // TODO : Actions
    public void renduFaute(String type, int num, String coul) {
	Font fontNum = new Font("Equipe", Font.BOLD, 150);
	Font fontFaute = new Font("Equipe", Font.BOLD, 70);
	Font fontCoul = new Font("Equipe", Font.BOLD, 130);

	// Creation des 3 boutons :
	// Type de faute
	JButton f = new JButton(type);
	f.setPreferredSize(new Dimension(X/2, Y/2));
	f.setBackground(Color.WHITE);
	f.setFont(fontFaute);

	// Numéro de joueur
	JButton n = new JButton(Integer.toString(num));
	n.setPreferredSize(new Dimension(X/2, Y/2));
	n.setBackground(Color.WHITE);
	n.setFont(fontNum);

	// Couleur d'équipe
	JButton c = new JButton(coul);
	c.setBackground(Color.RED);
	c.setPreferredSize(new Dimension(X, Y/2));
	c.setFont(fontCoul);
	c.setForeground(Color.WHITE);

	JPanel all = new JPanel();
	all.add(f);
	all.add(n);
	all.add(c);
	all.setBackground(Color.WHITE);

	content.add(all, listContent[0]);


	content.repaint();

	//this.setContentPane(all);
    }

    // TODO : Actions
    public void nbPoints(int num, String coul) {
	Font font = new Font("Points", Font.BOLD, 50);

	this.setLayout(new GridLayout(1, 3));
	JButton pt1 = new JButton("1");
	pt1.setBackground(Color.WHITE);
	pt1.setForeground(Color.BLACK);
	pt1.setFont(font);
	JButton pt2 = new JButton("2");
	pt2.setBackground(Color.WHITE);
	pt2.setForeground(Color.BLACK);
	pt2.setFont(font);
	JButton pt3 = new JButton("3");
	pt3.setBackground(Color.WHITE);
	pt3.setForeground(Color.BLACK);
	pt3.setFont(font);
	this.getContentPane().add(pt1);
	this.getContentPane().add(pt2);
	this.getContentPane().add(pt3);
    }

    // TODO: Actions
    public void typeFaute(int num, String coul) {
	Font fontFaute = new Font("faute", Font.BOLD, 130);
	Font fontSport = new Font("sport", Font.BOLD, 50);
	Font fontTech = new Font("tech", Font.BOLD, 50);


	JButton faute = new JButton("FAUTE");
	faute.setBackground(Color.white);
	faute.setPreferredSize(new Dimension(X, Y/2));
	faute.setFont(fontFaute);
	faute.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent event){	
		    System.out.println("TestFaute");
		    renduFaute("FAUTE", num, coul);
		    //cl.show(content, listContent[0]);
		}
	    });

	JButton sport = new JButton("SPORTIVE");
	sport.setBackground(Color.white);
	sport.setPreferredSize(new Dimension(X/2, Y/2));
	sport.setFont(fontSport);
	JButton tech = new JButton("TECHNIQUE");
	tech.setBackground(Color.white);
	tech.setPreferredSize(new Dimension(X/2, Y/2));
	tech.setFont(fontTech);

	JPanel all = new JPanel();
	all.add(faute);
	all.add(sport);
	all.add(tech);	
	content.add(all, listContent[3]);

	this.setContentPane(all);
    }


}
