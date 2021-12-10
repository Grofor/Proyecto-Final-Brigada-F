package CTRL;

public class Trabajador{
  
  private String nombre;
  private String direccion;
  private String pHistorico1;
  private String pHistorico2;
  private String pHistorico3;
  private String pVigente1;
  private String pVigente2;
  private String pVigente3;
  private int edad;
  private int numTrabajador;
  private int anosDeServicio;

  public Trabajador(){}

  public void setNombre(String nombre){
    this.nombre = nombre;
  }
  public String getNombre(){
    return nombre;
  }

  public void setDireccion(String direccion){
    this.direccion = direccion;
  }
  public String getDireccion(){
    return direccion;
  }

  public void setPHistorico1(String pHistorico1){
    this.pHistorico1 = pHistorico1;
  }
  public String getPHistorico1(){
    return pHistorico1;
  }

  public void setPVigente1(String pVigente1){
    this.pVigente1 = pVigente1;
  }
  public String getPVigente1(){
    return pVigente1;
  }

  public void setPHistorico2(String pHistorico2){
    this.pHistorico2 = pHistorico2;
  }
  public String getPHistorico2(){
    return pHistorico2;
  }

  public void setPVigente2(String pVigente2){
    this.pVigente2 = pVigente2;
  }
  public String getPVigente2(){
    return pVigente2;
  }

  public void setPHistorico3(String pHistorico3){
    this.pHistorico3 = pHistorico3;
  }
  public String getPHistorico3(){
    return pHistorico3;
  }

  public void setPVigente3(String pVigente3){
    this.pVigente3 = pVigente3;
  }
  public String getPVigente3(){
    return pVigente3;
  }

  public void setEdad(int edad){
    this.edad = edad;
  }
  public int getEdad(){
    return edad;
  }

  public void setNumTrabajador(int numTrabajador){
    this.numTrabajador = numTrabajador;
  }
  public int getNumTrabajador(){
    return numTrabajador;
  }

  public void setAnosDeServicio(int anosDeServicio){
    this.anosDeServicio = anosDeServicio;
  }
  public int getAnosDeServicio(){
    return anosDeServicio;
  }
  @Override
  public String toString(){
    return "Trabajador {Nombre:"+nombre+" Proyecto Histórico 1:"+pHistorico1+" Proyecto Histórico 2:"+pHistorico2+" Proyecto Histórico 3:"+pHistorico3+" Proyecto Vigente 1:"+pVigente1+" Proyecto Vigente 2:"+pVigente2+" Proyecto Vigente 3"+pVigente3+" Edad:"+edad+" Numero de trabajador:"+numTrabajador+" Anos de servicio:"+anosDeServicio+"}";
  }
}