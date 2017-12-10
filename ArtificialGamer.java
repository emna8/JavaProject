package projet;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class ArtificialGamer extends PossibleWords {
	
	HashSet<String> artifialWords;
	private int artificialScore;
	
	//Constructor
	public ArtificialGamer(){
		this.artifialWords=new HashSet<String>();
		this.artificialScore=0;
	}
	
	public void remplirArtificial(Object[][]p,ArrayList<String>d){
	  super.find(p,d,this.artifialWords);
	}
		
	//Getter
	public int getArtificialScore() {
		return artificialScore;
	}

    //Setter
	public void setArtificialScore(int artificialScore) {
		this.artificialScore = artificialScore;
	}

	public void countArtifialScore(){
		for(Iterator<String> i=artifialWords.iterator();i.hasNext();){
			String s=i.next();
		if(s.length()<8){
			this.artificialScore+=s.length()-2;
		}
						
		if(s.length()>=8){
			this.artificialScore+=11;
		}
		
	}
			
	}

}
