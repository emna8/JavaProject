package projet;
import javax.swing.JOptionPane;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


public class User  {	
	LinkedList<String> usersWords;
	private int UserScore;
	
	//Constructor
	public User(){
		this.UserScore=0;
		this.usersWords=new LinkedList<String>();
	}
	
	
	//verify if the word is valid
	public boolean verify(String word,ArrayList<String>d,HashSet<String>Possible){
		boolean b=true;
		b=word.length()>=3;
		if(b){
			b=!this.usersWords.contains(word);
			if(b){
				b=d.contains(word.toLowerCase());
				if(b){
					b=Possible.contains(word.toUpperCase());
					}
			}
		}
	return b;
		
	}

	//Getter
	public int getUserScore() {
		return UserScore;
	}

	//Setter
	public void setUserScore(int userScore) {
		UserScore = userScore;
	}

//calculer le score de User
public void countUserScore(String word){
	
	if(word.length()<8){
		this.UserScore+=word.length()-2;
	}
	
	if(word.length()>=8){
		this.UserScore+=11;
	}
	
}
    
    //Saisir les mots de User en VERIFIANT leur validité
	@SuppressWarnings("deprecation")
	public void getWords(ArrayList<String>dic,HashSet<String>p) throws InterruptedException{
		String w;
		Time t=new Time();
		t.start();		
		do{
						
			w=JOptionPane.showInputDialog("More");
			if(w.isEmpty())
			{	
				//we need to stop the thread !!
				t.stop();
				break;				
			}
			else{
				if(this.verify(w,dic,p) && t.isAlive()){
				this.usersWords.add(w);
				this.countUserScore(w);
				//I want to show him his score every time he entered a word
				JOptionPane.showMessageDialog(null, "Score : "+this.UserScore);
				}
			else {
				if(!t.isAlive()){
					JOptionPane.showMessageDialog(null, "Time is over !! ");
				}else
					JOptionPane.showMessageDialog(null, "Invalid word ");
					}
				}
				
		}while(t.isAlive()&& !w.isEmpty());
		
		System.out.println("Les mots proposés : "+this.usersWords);
	}
	
	
	public class Time extends Thread{
		long d;

		@Override
		public void run() {
			// TODO Auto-generated method stub
			long d=180*1000;
			
			while(d!=0){
				try {
					//System.out.print("in in \n");
					d-=1000;
					Thread.sleep(1000);
					System.out.print(d/1000+"\n");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				}
		
			}
			
			 JOptionPane.showMessageDialog(null, "Time is over", "END",
                     JOptionPane.INFORMATION_MESSAGE);
			
		}
		
		public void stopI(){
			this.d=0;
			
		}
		

	}	

	
}
