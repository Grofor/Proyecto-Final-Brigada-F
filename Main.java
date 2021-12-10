/*
@author Armas Vega Grofor Octavio,Carapia Quinto David,Morales Perez Renato ,Torres Anaya Carlos Eduardo	
@param var, cont1, entrar, ed1 
*/
import CTRL.Controlador;
import CTRL.Edicion;
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {
    //Con el objeto cont1.numReg llamamos a todo lo que programamos en el main anterior
    System.out.println("\n--------Bienvenido al programa de gestión de personal----------\n");
    Scanner var = new Scanner(System.in);
    Controlador cont1 = new Controlador();
    cont1.numReg();

    System.out.println("\n¿Desea editar un registro de la base de datos? 1 sí 2 no");
    int entrar = var.nextInt();
    if(entrar==1){
      Edicion ed1 = new Edicion();
      ed1.editor();
    }else System.out.println("\n--------Fin---------\n");
  }
}