package projet;

import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MainProjet  {
	static int x;
	static Scanner s=new Scanner(System.in);
	public static void main(String [] args) throws InterruptedException
	{
		String y;
		System.out.println("\t\t\t\t\t**Boggle Game**\n");
		System.out.println("1-Temps du jeu: 3 min.\n2-Comment jouer?:\n  Chercher un mot à partir des lettres adjacents du plateau\n\t\t*Horizontalement\n\t\t*Verticalement\n\t\t*Diagonale\n");
		System.out.println("3-les mots doivent etre de 3 lettres au minimum\n4-Il est interdit d'utiliser plusieurs fois le meme dé pour le meme mot\n5-Joueur1: Vous\nJoueur2:l'ordinateur");
	    System.out.println("6-Score: depend du longeur du mot:\n\n\t\tLongeur:|\t3\t|4\t|5\t|6\t|7\t|8+");
	    System.out.println("\t\tPoints:|\t1\t|2\t|3\t|4\t|5\t|11\n");
	    System.out.println("6-Si les 2 joueurs ont trouvé le meme mot, il sera rayé des listes le contenant.\n7-Le gagnant c'est le joueur ayant le score le plus élevé");
		
	    while(true)	{
	    System.out.println("\n\nLe jeu commence dans quelques secondes\n\n\tEssayez de trouver le maximum du mot\n\t\t Bonne chance!\n\n");
		Initialisation i=new Initialisation();
		i.remplirDictionary();
		i.remplirPlateu();
		PossibleWords p=new PossibleWords();
		p.remplirAll(i.Plateau, i.dictionary);
		Table t=new Table(i.Plateau);
		t.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		t.setSize(400,200);
		t.setVisible(true);
		User u=new User();
		u.getWords(i.dictionary,p.allPossibleWords);
		System.out.print("\nTern of atificial\n");
		ArtificialGamer a=new ArtificialGamer();
		a.remplirArtificial(i.Plateau, i.dictionary);
		a.countArtifialScore();
		System.out.println("\nLe score initial de pc "+a.getArtificialScore());
		System.out.println("Le score initial joueur humain "+u.getUserScore());
		p.tellWinner(u,a);
		System.out.println("\nScore final pc "+a.getArtificialScore());
		System.out.println("Score final joueur humain "+u.getUserScore());
		System.out.print("\nVoila la liste des mots possibles\n"+p.allPossibleWords);
		y=JOptionPane.showInputDialog("Q:Quitter");
		if(y.equals("q")|| y.equals("Q")){
			JOptionPane.showMessageDialog(null, "Good Bye");
			break;}
		
		
		/*Menu m=new Menu();
		m.setSize(300,200);
		m.setVisible(true);*/
	
		
		
		
		
	}
		
		
		
		 
		
		
		
		
		
			
	    }
	

	
	}
	
	


