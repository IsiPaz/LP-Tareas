package tarea3;

public class Camion_cisterna extends Vehiculo{

     Camion_cisterna(int c){
         super.setconsumo(c);
     }

     //setter y getter consumo

    /** getConsumoV
    Parametro : (int) (c)
    --------------------
    Descripción breve : funcion que sirve para guardar el consumov del Camion_cisterna
    --------------------
    */
     public int getConsumoV(){return consumoV;}

    /** setConsumoV
    Parametro : (int) (c)
    --------------------
    Descripción breve : funcion que sirve para guardar el consumov del Camion_cisterna
    --------------------
    */
     public void setconsumo(int c){consumoV = c;}
}
