package projet;
import java.util.ArrayList;
import java.util.*;
import java.util.Random;

public class Initialisation {
	
	final char allD[][]=new char[16][6];
	char Plateau[][]=new char[4][4];
	
	char[] rempTab(char a,char b ,char c,char d,char e,char f){
		char [] tab =new char[6];
		tab[0]=a;
		tab[1]=b;
		tab[2]=c;
		tab[3]=d;
		tab[4]=e;
		tab[5]=f;			
		return tab;
		
	}
	
	public void Remplir(){
	 	
			allD[0]=rempTab('B','A','J','O','Q','M');
			allD[1]=rempTab('R','A','L','E','S','C');
			allD[2]=rempTab('L','I','B','A','R','T');
			allD[3]=rempTab('T','O','K','U','E','N');
			allD[4]=rempTab('R','O','F','I','A','X');
			allD[5]=rempTab('A','V','E','Z','D','N');
			allD[6]=rempTab('N','U','L','E','G','Y');
			allD[7]=rempTab('M','E','D','A','P','C');
			allD[8]=rempTab('S','U','T','E','L','P');
			allD[9]=rempTab('H','E','F','S','I','E');
			allD[10]=rempTab('R','O','M','A','S','I');
			allD[11]=rempTab('G','I','N','E','V','T');
			allD[12]=rempTab('R','U','E','I','L','W');
			allD[13]=rempTab('R','E','N','I','S','H');
			allD[14]=rempTab('T','I','E','A','A','O');
			allD[15]=rempTab('D','O','N','E','S','T');
			
	}
	

	public void remplirPlateu()
	{
		this.Remplir();
		Random rand =new Random();
		int n;
		int d;
		ArrayList<Integer> deUsed =new ArrayList<Integer>(16);
		
				
		for(int i=0;i<4;i++)
		{
			d=rand.nextInt(16);
			for(int j=0;j<4;j++)
			{
				n=rand.nextInt(6);//la colonne choisie dans allD( la face )
				while(deUsed.contains(d)){
					 d=rand.nextInt(16);//la ligne choisie dans allD(le dé)
				}
				
				deUsed.add(d);
				
				this.Plateau[i][j]=this.allD[d][n];//le dé num d avec la face n
				
			}
		}
		
			
	}
	
	public void afficherPlateau(){
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
			{
				System.out.print(this.Plateau[i][j]);
			}
			
			System.out.println();
		}
	}
	
	

}
