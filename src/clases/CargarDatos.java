
package clases;


public class CargarDatos {
  private static String us;
  private static int x,y;
  public CargarDatos() {
        us = "";
        x=0;
        y=0;
    }
    
      public static String getUsuario(){
       return us;
   }
   
   public static void setUsuario(String cap){
       us=cap;
   } 
    
   public static int getNumpregunta1(){
       return x;
   }
   
   public static void setNumpregunta1(int i){
       x=i;
   }
   
   
   public static int getNumpregunta2(){
       return y;
   }
   
   public static void setNumpregunta2(int j){
       y=j;
   }
   
   
   
}
