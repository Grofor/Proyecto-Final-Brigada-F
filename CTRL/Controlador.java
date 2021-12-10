package CTRL;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

public class Controlador{

  public Controlador(){}

  public void numReg(){
    // objeto tipo Trabajador para generar los registros
    Trabajador tr1 = new Trabajador();

    //Arreglo donde se guardan las direcciones separadas por comas
    String[] dir = new String[300];

    //Arreglo donde se guardan las direcciones YA NO separadas por comas
    String[] dirSinComas = new String[300];

    //Arreglo donde se guardan los proyectos historicos separados por comas
    String[] pH = new String[40];

    //Arreglo donde se guardan los proyectos historicos YA NO separados por comas
    String[] pHSinComas = new String[40];

    //Arreglo donde se guardan los proyectos vigentes separados por comas
    String[] pV = new String[10];

    //Arreglo donde se guardan los proyectos vigentes YA NO separados por comas
    String[] pVSinComas = new String[10];

    //Arreglo donde guargamos los 20 nombres propios
    String[] nombres = {"David","Renato","Octavio","Carlos","Francisco","Juan","Roberto","Luis","Antonio","Pedro","Margarita","Karen","Jimena","Ximena","Claudia","Valeria","Juana","Maria","Karla","Regina"};

    //Arreglo donde guardamos los 20 apellidos paternos
    String [] apellidosP = {"Carapia","Quinto","Armas","Vega","Morales","Perez","Torres","Anaya","Garcia","Vazquez","Reyes","Gutierrez","Gomez","Lagunes","Pina","Mota","Sanchez","Ortega","Galindo","Montalbo"};

    //Arreglo donde guardamos los 20 apellidos maternos
    String [] apellidosM = {"Lagos","Guerrero","Montoya","Ramirez","Dorado","Diaz","Lopez","Aguilar","Palacios","Pacheco","Villegas","Romero","Flores","Silva","Mora","Olvera","Facio","Galicia","Paez","Carranza"};

    //---------------------modulo generador de direcciones---------------------//
    //leer el archivo de direcciones y guardarlo en un arreglo
    try{
      FileReader fr = new FileReader("archivodirecciones.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();
      int i=0;
      while(linea != null){
        dir[i]=linea;
        linea = br.readLine();      
        i++;
      }
      br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    
    
    //guardar las direcciones completas sin comas en el arreglo e identificar las partes de la dirección.
    for(int i=0;i<300;i++){
      StringTokenizer tokenizador=new StringTokenizer(dir[i],",");
      int count=0;
      String direccion=null, colonia =null,telefono=null;
      int cp=0;
      while(tokenizador.hasMoreTokens()){
        String aux=tokenizador.nextToken();
        if(count==0)
          direccion = aux;
        else if(count==1)
          colonia=aux;
        else if(count==2)
          cp=Integer.parseInt(aux);
        else if(count==3)
          telefono=aux;
        count++;
      }
      dirSinComas[i]=direccion+"|Colonia: "+colonia+"|Codigo Postal:" +cp+"|Telefono:"+telefono;
    }

    //---------------------modulo generador de registro de proyectos---------------------//
    //leer los archivos de proyectos y guardarlos en dos arreglos
    try{
      FileReader fr = new FileReader("archivoProyectosHistoricos.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();
      int i=0;
      while(linea != null){
        pH[i]=linea;
        linea = br.readLine();      
        i++;
      }
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }

    try{
      FileReader fr = new FileReader("archivoProyectosVigentes.csv");
      BufferedReader br = new BufferedReader(fr);
      String linea = br.readLine();
      int i=0;
      while(linea != null){
        pV[i]=linea;
        linea = br.readLine();      
        i++;
      }
    br.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
    
    //guardar los proyectos historicos completos sin comas en el arreglo e identificar las partes de cada proyecto.
    for(int i=0;i<40;i++){
      StringTokenizer tokenizador=new StringTokenizer(pH[i],",");
      int count=0;
      String identificador=null, nombreProyecto =null;
      while(tokenizador.hasMoreTokens()){
        String aux=tokenizador.nextToken();
        if(count==0)
          identificador = aux;
        else if(count==1)
          nombreProyecto=aux;
        count++;
      }
      pHSinComas[i]=identificador+": "+nombreProyecto;
    }

    //guardar los proyectos vigentes completos sin comas en el arreglo e identificar las partes de cada proyecto.
    for(int i=0;i<10;i++){
      StringTokenizer tokenizador=new StringTokenizer(pV[i],",");
      int count=0;
      String identificador=null, nombreProyecto =null;
      while(tokenizador.hasMoreTokens()){
        String aux=tokenizador.nextToken();
        if(count==0)
          identificador = aux;
        else if(count==1)
          nombreProyecto=aux;
        count++;
      }
      pVSinComas[i]=identificador+": "+nombreProyecto;
    }
    
    //---------------------modulo generador de datos personales (registros completos)---------------------//
    try{
      FileWriter fw = new FileWriter("definitivo.csv");
      BufferedWriter bw = new BufferedWriter(fw);
      PrintWriter salida = new PrintWriter(bw);

      salida.println("NOMBRE,EDAD,NUMERO DE TRABAJADOR,ANOS DE SERVICIO,DIRECCION,PROYECTO HISTORICO 1,PROYECTO HISTORICO 2,PROYECTO HISTORICO 3,PROYECTO VIGENTE 1,PROYECTO VIGENTE 2,PROYECTO VIGENTE 3");

      for(int i=0;i<10;i++){

        tr1.setNombre(nombres[(int)(Math.random()*nombres.length)]+" "+apellidosP[(int)(Math.random()*apellidosP.length)]+" "+apellidosM[(int)(Math.random()*apellidosM.length)]);

        int edad = (int)(Math.random() * 70)+18;
        tr1.setEdad(edad);
      
        //generador años de servicio
        int p=0;
        int anServ = (int)(Math.random()*50)+1;

        int dif = edad-anServ;//Trabajador no puede tener 20 años y 18 años de serv, tampoco puede empezar a trabajar antes de los 18 años.
        while(p!=1){
          if(edad>anServ && dif>17){
            tr1.setAnosDeServicio(anServ);
            p=1;
          }else{
            anServ = (int)(Math.random()*50)+1;
            dif = edad-anServ;
          }
        }    

        tr1.setNumTrabajador((int)(Math.random() *10)+1);

        tr1.setDireccion(dirSinComas[(int)(Math.random()*299)]);

        /**
        * @param numPH número de proyecto historico 1 (aleatorio)
        * @param numPH2 número de proyecto historico 2 (aleatorio)
        * @param numPH3 número de proyecto historico 3 (aleatorio)
        */

        int numero1=0;
        int numero2=0;
        int numero3=0;
        int numPH = (int)(Math.random()*39)+1;
        numero1=numPH;
        tr1.setPHistorico1(pHSinComas[numPH]);  
        do{
          int numPH2 = (int)(Math.random()*39)+1;
          numero2=numPH2;
          tr1.setPHistorico2(pHSinComas[numPH2]);
        }while (numero1==numero2);

        do{
          int numPH3 = (int)(Math.random()*39)+1;
          numero3=numPH3;
          tr1.setPHistorico3(pHSinComas[numPH3]);
        }while(numero1==numero3 || numero2==numero3);

        /**
        * @param numPV número de proyecto vigente 1 (aleatorio)
        * @param numPV2 número de proyecto vigente 2 (aleatorio)
        * @param numPV3 número de proyecto vigente 3 (aleatorio)
        */

        int numero4=0;
        int numero5=0;
        int numero6=0;
        int numPV = (int)(Math.random()*9)+1;
        numero4=numPV;
        tr1.setPVigente1(pVSinComas[numPV]);  
        do{
          int numPV2 = (int)(Math.random()*9)+1;
          numero5=numPV2;
         tr1.setPVigente2(pVSinComas[numPV2]);
        }while (numero4==numero5);
        do{
          int numPV3 = (int)(Math.random()*9)+1;
          numero3=numPV3;
          tr1.setPVigente3(pVSinComas[numPV3]);
        }while(numero4==numero6 && numero5==numero6);

        System.out.println("Linea .csv: "+(i+2)+"|Nombre: "+tr1.getNombre()+"|Edad: "+tr1.getEdad()+"|Numero de trabajador: "+tr1.getNumTrabajador()+"|Anos de Servicio: "+tr1.getAnosDeServicio()+"|Direccion: "+tr1.getDireccion()+"|Proyectos Historicos: "+tr1.getPHistorico1()+"|"+tr1.getPHistorico2()+"|"+tr1.getPHistorico3()+"|Proyectos Vigentes: "+tr1.getPVigente1()+"|"+tr1.getPVigente2()+"|"+tr1.getPVigente3()+"|");
        System.out.println(" ");

        String linea2=(tr1.getNombre()+","+tr1.getEdad()+","+tr1.getNumTrabajador()+","+tr1.getAnosDeServicio()+","+tr1.getDireccion()+","+tr1.getPHistorico1()+","+tr1.getPHistorico2()+","+tr1.getPHistorico3()+","+tr1.getPVigente1()+","+tr1.getPVigente2()+","+tr1.getPVigente3());
        salida.println(linea2);
      }salida.close();
    }catch(FileNotFoundException ex){
      System.out.println(ex.getMessage());
    }catch(IOException ex){
      System.out.println(ex.getMessage());
    }
  }
}