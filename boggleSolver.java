package projet;

import java.util.ArrayList;
import java.util.HashSet;

public class boggleSolver {
	
	//Constructor
	public boggleSolver(){
		
	}
	
		
	public void findWordsUtil(Object[][]boggle,boolean[][] visited,int i,int j,String str,ArrayList<String>dic,HashSet<String>all)
		{
		visited[i][j]=true;
		str=str+boggle[i][j];
		
		int cmp=0,stop=0;
		while(cmp<dic.size() && stop==0){
			String v=dic.get(cmp);
			//System.out.println(v);
			if(v.length()>=str.length()){
			String temp=v.substring(0, str.length());
		 if(str.toLowerCase().equals(temp)){
				stop=1;
			}}
			
			cmp++;
		}
		if(stop==0){
			str=str.substring(0,str.length()-1);
		}
		
		if(stop==1)
		if(dic.contains(str.toLowerCase()) && !all.contains(str)&& str.length()>=3)
			all.add(str);
		
		for(int row=i-1;row<=i+1 && row <4 ;row++){
			if(row>=0){
			for(int col=j-1;col<=j+1 && col<4 ;col++)
				if(col>=0 && !visited[row][col] &&stop==1)
					findWordsUtil(boggle,visited,row,col,str,dic,all);
		}}		
		visited[i][j]=false;
	}
	
	public  void find(Object [][] b,ArrayList<String>d,HashSet<String>all)
	{
		boolean v[][]=new boolean[4][4];
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				v[i][j]=false;
		
		String str="";
		
		for(int i=0;i<4;i++)
			for(int j=0;j<4;j++)
				findWordsUtil(b,v,i,j,str,d,all);
				
		
	}
	

}
