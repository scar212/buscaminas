package com.mycompany.buscaminas;

import java.util.Scanner;

public class Buscaminas {

    public static void main(String[] args) {
    Scanner leer = new Scanner (System.in);
    int tablero [][]= new int[6][6];
    double w=0;
    double z=0;
    int minas=0;
    int intentos=10;
    int tminas=4;
    for(int j=0;j<6;j++)
	for (int i=0;i<6;i++)
            tablero [j][i]=0;
		do  {  
                    w=Math.random()*6;
                    z=Math.random()*6;  
                    w=(int)w;
                    z=(int)z;
                    if(z!=0 && w!=0 && z!=6-1 && w!=6-1){
                        tablero[(int)w][(int) z ]=1;
                        minas++;
                    }
       		}while (minas<=4);      
       	System.out.println("\n-x----------------------------------------------------x-");
       	System.out.println("  Ingresa las coordenas en un rango del 1 al 6");
       	do {
       		int x=0,y=0;
       		int nminas = 0;
       		
       		do{
                    System.out.println("\n-x----------------------------------------------------x-");
                    System.out.println("\n	Intento :"+intentos+" , Cual es su coordenada? \n");
                    System.out.print("		Fila:  ");
                    x=leer.nextInt();
                    System.out.println();
                    System.out.print("		Columna:  ");
                    y=leer.nextInt();	 
                    if(x==0 || y==0 || x>6 || y>6)
       			System.out.println("\n	==>Coordenadas incorrectas<== \n");
       		}while (x==0 || y==0 || x>6 || y>6);
                    x=x-1;
                    y=y-1;
       		
       		if(tablero [x][y]==0){
       			
                    if (x==0&&y==0){
       			if(x+1>=0 && x+1<6 && y<6)
                            nminas=nminas+tablero [x+1][y];
                            if(x+1>=0 && x+1<6 && y+1<6 && y+1>=0)
                                nminas=nminas+tablero [x+1][y+1];
       				if(x>=0 && x<6 && y+1<6 && y+1>= 0)
                                    nminas=nminas+tablero [x][y+1];
                    }else{
                        if(y==0){
                            if(x+1>=0 && x+1<6 && y<6)
       				nminas=nminas+tablero [x+1][y];
       				if(x-1>=0 && x-1<6 && y<6)
                                    nminas=nminas+tablero [x-1][y];
                                    if(x-1>=0 && x-1<6 && y+1<6 && y+1>=0)
       					nminas=nminas+tablero [x-1][y+1];
       					if(x>=0 && x<6 && y+1<6 && y+1>= 0)
                                            nminas=nminas+tablero [x][y+1];
                                            if(x+1>=0 && x+1<6 && y+1<6 && y+1>=0)
       						nminas=nminas+tablero [x+1][y+1];
                        }else{       				
                            if(x-1>=0 && x-1<6 && y-1<6)
       				nminas=nminas+tablero [x-1][y-1];
       				if(x>=0 && x<6 && y-1<6)
                                    nminas=nminas+tablero [x][y-1];
                                    if(x+1>=0 && x+1<6 && y-1<6)
       					nminas=nminas+tablero [x+1][y-1];
       					if(x+1>=0 && x+1<6 && y<6)
                                            nminas=nminas+tablero [x+1][y];
                                            if(x-1>=0 && x-1<6 && y<6)
       						nminas=nminas+tablero [x-1][y];
                                                if(x-1>=0 && x-1<6 && y+1<6 && y+1>=0)
                                                    nminas=nminas+tablero [x-1][y+1];
                                                    if(x>=0 && x<6 && y+1<6 && y+1>= 0)
                                                        nminas=nminas+tablero [x][y+1];
                                                        if(x+1>=0 && x+1<6 && y+1<6 && y+1>=0)
                                                            nminas=nminas+tablero [x+1][y+1];
                        }
                    }
       			 System.out.print("\n	Mina no encontrada. ");
       			 
       			 if(intentos>tminas)
       			 	 System.out.print("	Alrededor hay: "+ nminas);
       			 System.out.println("\n	Intentos restantes: "+(intentos-1));
       		}
       		else
       			{
       				tminas = tminas-1;
       				System.out.println("\n	Acertaste!, Mina Eliminada Restan "+tminas+" Minas");
       				System.out.println("\n	Intentos restantes: "+(intentos-1));
       			}
       	
          intentos=intentos-1;
      }while (intentos>=tminas && intentos>0 && tminas>0);	
 	   
       	if(tminas==0)
       		System.out.println("		GANASTE!");
       	
       	if(tminas>intentos)
       		System.out.println("		PERDISTE!    (Exceso de minas restantes "+tminas+")\n\n");
       	
       	if(intentos==0)
       		System.out.println("		PERDISTE!");
 	   }

    private static void showInitialBoard(Integer[][] initialBoard, Integer boardSize) {
        System.out.print("\nThe Minesweeper configuration is: ");
        for (int i = 0; i < boardSize; i++) {
            System.out.print("[");
            for (int j = 0; j < boardSize; j++) {
                System.out.print(initialBoard[i][j]);
                if (j < boardSize - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]");
            if (i < boardSize - 1) {
                System.out.print(",");
            }
        }
    }
}
