
import java.util.*;
import java.io.*;
import java.time.*;

public class GestioneAutomezzi extends Automezzo{

	
	public static boolean x=false;
	public static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws Exception{
		
try {

		System.out.println("0 - inserimento");
		System.out.println("1 - aggiunta");
		System.out.println("2 - cancellazione");
		System.out.println("3 - Ricerca e stampa su System.out di tutti i dati di un veicolo dato il numero di targa");
		System.out.println("4 - Ricerca e stampa su System.out di tutti i veicoli in cui l’anno dell’ultima revisione...");
		System.out.println("5 - stampa");
		System.out.println("6 - stampa su file");
		System.out.println("7 - Esci");
		
		String n1 = reader.readLine();
		int n = Integer.parseInt(n1);
		
		switch(n)
		{
		
		case 0:{
			inserimento();
			
			break;
			}
		
		case 1:{
			aggiunta();
			
			break;
		}
		
		case 2:{
			cancellazione();
			
			break;
		}
		case 3:{
			Ricerca1();
			
			break;
		}
		case 4:{
			Ricerca2();
		
			break;
		}
		case 5:{
			stampa();
			
			break;
		}
		case 6:{
			stampaSuFile();
		
			break;
		}
		case 7:{
			Esci();
			
			break;
		}
		
		}//fine switch
		
		while(true) {
		Scelta();
		}
			
		}//fine try
		
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}
		
	}//fine main
	

	public static void inserimento(){
		
	
try{	
			x=true;
			FileReader input=new FileReader("input.txt");
			Scanner in=new Scanner (input);

			String s;
			//LEGGO PRIMA RIGA///
			s=in.nextLine();
			
			String[] str=s.split(",");
			MARCA.add(str[0].replace(" ", ""));
			MODELLO.add(str[1].replace(" ", ""));
			TARGA.add(str[2].replace(" ", ""));
			IMMATRICOLAZIONE.add(Integer.parseInt(str[3].replace(" ", "")));
			REVISIONE.add(Integer.parseInt(str[4].replace(" ", "")));
			
			//VADO AVANTI A LEGGERE IL FILE
			 while(in.hasNext()){
				 
				 s=in.nextLine();
				 String[] str2=s.split(",");
				 MARCA.add(str2[0].replace(" ", ""));
				 MODELLO.add(str2[1].replace(" ", ""));
				 TARGA.add(str2[2].replace(" ", ""));
				 IMMATRICOLAZIONE.add(Integer.parseInt(str2[3].replace(" ", "")));
				 REVISIONE.add(Integer.parseInt(str2[4].replace(" ", "")));
				 
		        }
			
			 	in.close();
				
		
		}//fine try
		
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}

		
		
	}//fine inserimento
	
	public static void aggiunta(){
		
try {
		//ottengo anno corrente
		 LocalDate datacorrente = LocalDate.now();
		int Annocorrente = datacorrente.getYear();
		
		//leggo da tastiera
		
		
		System.out.println("inserisci 1 per veicolo nuovo o 0 per veicolo usato");
		String n1 = reader.readLine();
		int veicolo = Integer.parseInt(n1);
		
		
		if(veicolo==1){
		
			System.out.println("inserisci MARCA MODELLO TARGA del veicolo. (Uno spazio tra un dato e l altro!)");
			String s = reader.readLine();
			String[] str =  s.split(" ");
			
			MARCA.add(str[0].replace(" ", ""));
			MODELLO.add(str[1].replace(" ", ""));
			TARGA.add(str[2].replace(" ", ""));
			IMMATRICOLAZIONE.add(Annocorrente);
			REVISIONE.add(Annocorrente);
		}
		else {
			System.out.println("inserisci MARCA MODELLO TARGA del veicolo. (Uno spazio tra un dato e l altro!)");
			String s1 = reader.readLine();
			String[] str1 =  s1.split(" ");
			
			MARCA.add(str1[0].replace(" ", ""));
			MODELLO.add(str1[1].replace(" ", ""));
			TARGA.add(str1[2].replace(" ", ""));
			
			System.out.println("inserisci Anno Immatricolazione del veicolo");
			String n2 = reader.readLine();
			int immatricolazione = Integer.parseInt(n2);
			IMMATRICOLAZIONE.add(immatricolazione);
			
			System.out.println("inserisci Anno Revisione del veicolo");
			String n3 = reader.readLine();
			int revisione = Integer.parseInt(n3);
			REVISIONE.add(revisione);
		}
		
		
		if(x==false) {
			
			System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
			String n3 = reader.readLine();
			int b = Integer.parseInt(n3);
			
			if(b==0) {
				x=false;
				
			}
			else {
				inserimento();
			}
			
		}//fine if
		
	
		
		}//fine try
		
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}
	
		
	}
	
	public static void cancellazione(){
		
		
try {
			System.out.println("inserisci la targa per la cancellazione del veicolo");
			String num = reader.readLine();
			
			for (int i = 0; i < TARGA.size(); i++) {
			      if(TARGA.get(i).equals(num)) {
			    	  
			    	  //eliminazione veicolo
			    	  TARGA.remove(i);
			    	  MARCA.remove(i);
			    	  MODELLO.remove(i);
			    	  IMMATRICOLAZIONE.remove(i);
			    	  REVISIONE.remove(i);
			    	 
			    	 }
			      }//fine for
			
			if(x==false) {
				
				System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
				String n3 = reader.readLine();
				int b = Integer.parseInt(n3);
				
				if(b==0) {
					x=false;
					
				}
				else {
					inserimento();
				}
				
			}

			
			
		}//fine try
	
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}

	}
	
	public static void Ricerca1(){
	
		//NOTA BENE: SE CI SONO 2 O PIU VEICOLO UGUALI, VERRANNO STAMPATI TUTTI
		
try {
			System.out.println("inserisci la targa per la stampa del veicolo");
			String num = reader.readLine();
			
			for (int i = 0; i < TARGA.size(); i++) {
			      if(TARGA.get(i).equals(num)) {
			    	  
			    	  System.out.println(MARCA.get(i)+" "+MODELLO.get(i)+" "+TARGA.get(i)+" "+IMMATRICOLAZIONE.get(i)+" "+REVISIONE.get(i));
			    	 
			    	 }
			      }//fine for
			
			if(x==false) {
				
				System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
				String n3 = reader.readLine();
				int b = Integer.parseInt(n3);
				
				if(b==0) {
					x=false;
					
				}
				else {
					inserimento();
				}
				
			}
			
			
			
			
		}//fine try
	
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}
		
		
	}//fine Ricerca1()
	
	public static void Ricerca2(){
		
try {
		
		//ottengo anno corrente
		 LocalDate datacorrente = LocalDate.now();
		int Annocorrente = datacorrente.getYear();
		
		for(int i=0;i<TARGA.size();i++) {
			
			if((REVISIONE.get(i).equals(IMMATRICOLAZIONE.get(i)) && REVISIONE.get(i).equals(Annocorrente-4)) || (REVISIONE.get(i).equals(Annocorrente-2))) {
				
				 System.out.println(MARCA.get(i)+" "+MODELLO.get(i)+" "+TARGA.get(i)+" "+IMMATRICOLAZIONE.get(i)+" "+REVISIONE.get(i));
				
			}
		}
		
		if(x==false) {
			
			System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
			String n3 = reader.readLine();
			int b = Integer.parseInt(n3);
			
			if(b==0) {
				x=false;
				
			}
			else {
				inserimento();
			}
			
		}
	
		
		
		}//fine try
		
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}
		
		
	}//fine Ricerca2()
	
	public static void stampa(){
		
try {
	
		if(MODELLO.size()==1) {
			
			System.out.println(MODELLO.get(0)); 
	   }
		
		else {
		
		for (int i = 0; i < MODELLO.size(); i++){ 
			
			
			 for(int j=i+1; j<MODELLO.size(); j++){
				 
				 
				 if(MODELLO.get(i).equals(MODELLO.get(j))){
					 
					 break;

				 }
					 
					 if(j==MARCA.size()-1){
						
						 System.out.println(MODELLO.get(i)); 
					 }		 
			 }
			 
			 if(i==MARCA.size()-2) {
				 
				 System.out.println(MODELLO.get(i+1));
			 }
			
		    }//fine secondo for
		}
		
		if(x==false) {
			
			System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
			String n3 = reader.readLine();
			int b = Integer.parseInt(n3);
			
			if(b==0) {
				x=false;
				
			}
			else {
				inserimento();
			}
		}

		
		}//fine try
		
		catch(Exception e){
			
			System.out.println("ERROR "+e.getMessage());
		}
		
		
	}//fine stampa()
	
	public static void stampaSuFile(){
	
		
try {
			//scrivo per stringhe usando un buffered
			FileWriter w=new FileWriter("output.txt");
		    BufferedWriter b=new BufferedWriter (w);
		    
		    if(MODELLO.size()==1) {
		    	 
		    	 b.write(MODELLO.get(0));
		    }
		    
		    else {
			
		    for (int i = 0; i < MODELLO.size(); i++) { 
				
				
				 for(int j=i+1; j<MODELLO.size(); j++) {
					 
					 
					 if(MODELLO.get(i).equals(MODELLO.get(j))){
						  
						 break;

					 }
						 
						 if(j==MARCA.size()-1) {
							  
							 b.write(MODELLO.get(i)+"\n"); 
						 
						 }		 
				 }
				 
				 if(i==MARCA.size()-2) {
					  
					 b.write(MODELLO.get(i+1)+"\n");
				 }
				
			    }//fine secondo for
		    }//fine else
		    
		    b.flush();
			w.close();
		    
			if(x==false) {
				
				System.out.println("vuoi fare l inserimento da file? inserisci '1' per si o '0' per no");
				String n3 = reader.readLine();
				int b2 = Integer.parseInt(n3);
				
				if(b2==0) {
					x=false;
					
				}
				else {
					inserimento();
				}
				
			}
			
			}//fine try
			
			catch(Exception e){
				
				System.out.println("ERROR "+e.getMessage());
			}	
		
	}//fine stampasufile()
	
	public static void Esci(){
		System.out.println("Sei uscito dal programma");
		System.exit(0);
		
	}//fine esci()
	
	public static void Scelta() throws Exception{
		
	
		System.out.println("1 - aggiunta");
		System.out.println("2 - cancellazione");
		System.out.println("3 - Ricerca e stampa su System.out di tutti i dati di un veicolo dato il numero di targa");
		System.out.println("4 - Ricerca e stampa su System.out di tutti i veicoli in cui l’anno dell’ultima revisione...");
		System.out.println("5 - stampa");
		System.out.println("6 - stampa su file");
		System.out.println("7 - Esci");
		
		String n1 = reader.readLine();
		int n = Integer.parseInt(n1);
		
		switch(n)
		{
		
		case 1:{
			aggiunta();
		
			break;
		}
		
		case 2:{
			cancellazione();
			
			break;
		}
		case 3:{
			Ricerca1();
		
			break;
		}
		case 4:{
			Ricerca2();
			
			break;
		}
		case 5:{
			stampa();
		
			break;
		}
		case 6:{
			stampaSuFile();
			
			break;
		}
		case 7:{
			Esci();
			
			break;
		}
		
		}//fine switch
		
	}//fine Scelta
		
	
}//fine classe
