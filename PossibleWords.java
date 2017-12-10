package projet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class PossibleWords extends boggleSolver{
	
	HashSet<String> allPossibleWords;
	
	//Constructor
	public PossibleWords(){
		super();
		this.allPossibleWords=new HashSet<String>();
		
	}
	
	public void remplirAll(Object[][]p,ArrayList<String>d){
		super.find(p,d,this.allPossibleWords);
	}
	
	public int scoreFinal(String s){
		int x=0;
		if(s.length()<=8){
			x-=s.length()-2;
		}
			
		if(s.length()>=8){
			x-=11;
		}
		return x;//negative
	}
	
	public void rayeListe(User u,ArtificialGamer a){
		int x=0;
		Iterator<String> i=u.usersWords.iterator();
		while(i.hasNext()){
			String s=i.next();
			//System.out.println(s);
			if(a.artifialWords.contains(s.toUpperCase())){
				//u.usersWords.remove(s);
				a.artifialWords.remove(s.toUpperCase());
				x+=scoreFinal(s);//negative
				
				}
		}
			a.setArtificialScore(a.getArtificialScore()+x);
			u.setUserScore(u.getUserScore()+x);
		}
	
	
	public void tellWinner(User u,ArtificialGamer a){
		this.rayeListe(u, a);
		
		if(u.getUserScore()>a.getArtificialScore())
			{System.out.println("\nUser wins with "+u.getUserScore() +" points");}
		if(u.getUserScore()<a.getArtificialScore())
			System.out.println("\nArtificial wins "+ a.getArtificialScore()+" points");
		if(u.getUserScore()==a.getArtificialScore())
			System.out.println("\nEgalite 0 0");
		
	}
	
}
