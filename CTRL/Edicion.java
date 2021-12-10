/*
@param entrada, entrada2, entrada3, texto, contador, count
*/
package CTRL;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;
import java.util.Scanner;


public class Edicion{
  public Edicion(){}

  public void editor(){
        int respuesta=1;
    //While que permite continuar con la edición
    while(respuesta==1){
      //Sacnners para guardar valores del usuario
      Scanner entrada = new Scanner(System.in);
      Scanner entrada2 = new Scanner(System.in);
      Scanner entrada3 = new Scanner(System.in);
    try{    
      
      System.out.println("\nEscribe el numero de la linea que deseas modificar");
      int texto= entrada.nextInt();
      int contador=0;
      //Declaración para leer el archivo definitivo
      FileReader fr = new FileReader("definitivo.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();//Se le asigna la primera linea del archivo a un string
      BufferedReader cr= new BufferedReader(new InputStreamReader(System.in));
      //Declaración para escribir en el archivo ejemplo2
      FileWriter fs = new FileWriter("ejemplo2.csv");
      BufferedWriter bs = new BufferedWriter(fs);
      PrintWriter salida = new PrintWriter(bs);
      //Permite recorrer todo el archivo definitivo
      while(linea != null){
        contador=contador+1;
        String nombreCompelto=null,pH1=null,pH2=null,pH3=null,pV1=null,pV2=null,pV3=null,dir=null;
        int numDeEmpleado=0,edad=0,añosServicio=0;
        //Identifica la linea que queremos modificar sea la misma donde estamos
        if(contador==texto){
          System.out.println(linea);
          //Separa la linea en tokens
          StringTokenizer tokenizador=new StringTokenizer(linea,",");
          int count=1;
          
          System.out.println("\nQue columna deseas modificar, desde la columna 1 hasta la 11");
          int columnaM = entrada.nextInt();
          while(tokenizador.hasMoreTokens()){
            String aux=tokenizador.nextToken();
            //System.out.println(aux+" Columna "+count);

            if(count==1){
              nombreCompelto = aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==1){
                System.out.println("\nEscribe el nombre completo del empleado");
                nombreCompelto=entrada3.nextLine();
              }
            }
            else if(count==2){
              edad=Integer.parseInt(aux);
              //Identifica la columna que se quiere modificar
              if(columnaM==2){
                System.out.println("\nEscribe la edad del empleado");
                edad=entrada.nextInt();
              }
            }
            else if(count==3){
              numDeEmpleado=Integer.parseInt(aux);
              //Identifica la columna que se quiere modificar
              if(columnaM==3){
                System.out.println("\nEscribe el numero de empleado");
                numDeEmpleado=entrada.nextInt();
              }}
            else if(count==4){
              añosServicio=Integer.parseInt(aux);
              //Identifica la columna que se quiere modificar
              if(columnaM==4){
                System.out.println("\nEscribe los años de servicio");
                añosServicio=entrada.nextInt();
              }}
            else if(count==5){
              dir=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==5){
                System.out.println("\nEscribe la direccion");
                String dirM=entrada2.nextLine();
                System.out.println("\nEscribe la colonia");
                String colM=entrada2.nextLine();
                System.out.println("\nEscribe el codigo postal");
                int cpM=entrada.nextInt();
                System.out.println("\nEscribe el telefono");
                int telM=entrada.nextInt();
                dir="|Direccion: "+dirM+" |Colonia: "+colM+" Codigo Postal: "+cpM+" |Telefono: "+telM;
              }}
            else if(count==6){
              pH1=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==6){
                System.out.println("\nEscribe el proyecto historico 1");
                pH1=entrada2.nextLine();
              }}
            else if(count==7){
              pH2=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==7){
                System.out.println("\nEscribe el proyecto historico 2");
                pH2=entrada2.nextLine();
              }}
            else if(count==8){
              pH3=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==8){
                System.out.println("\nEscribe el proyecto historico 3");
                pH3=entrada3.nextLine();
              }}
            else if(count==9){
              pV1=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==9){
                System.out.println("\nEscribe el proyecto vigente 1");
                pV1=entrada3.nextLine();
              }}
            else if(count==10){
              pV2=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==10){
                System.out.println("\nEscribe el proyecto vigente 2");
                pV2=entrada3.nextLine();
              }}
            else if(count==11){
              pV3=aux;
              //Identifica la columna que se quiere modificar
              if(columnaM==11){
                System.out.println("\nEscribe el proyecto vigente 3");
                pV3=entrada3.nextLine();
              }
            }
            count++;
            }
           //Asigna a un string la linea modificada 
          System.out.println("\nLa linea queda como:");
          String linea2=(nombreCompelto+","+edad+","+numDeEmpleado+","+añosServicio+","+dir+","+pH1+","+pH2+","+pH3+","+pV1+","+pV2+","+pV3);
          System.out.println(linea2);
          count=0;
          salida.println(linea2);
        }
        //Identifica que la linea no es la que se quiere modificar
        if(contador!=texto){
          salida.println(linea);//Imprime la linea de definitivo en ejemplo2
        } 

        linea = br.readLine();
      }
      salida.close();  
      br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }

    try{
      FileReader fr = new FileReader("ejemplo2.csv");
      BufferedReader br = new BufferedReader(fr);
      FileWriter fw = new FileWriter("definitivo.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida = new PrintWriter(bw);
      String linea = br.readLine();
      while(linea != null){
        salida.println(linea);//Imprime la linea de ejemplo2 en definitivo
        linea = br.readLine();
      }
      salida.close();
      br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    System.out.println("\n\nDeseas continuar editando el archivo,1=si 2=no");
    respuesta=entrada3.nextInt();

  }
  System.out.println("\n\n-------Fin---------\n\n");
  /*entrada.close();
  entrada2.close();
  entrada3.close();*/
  }
}