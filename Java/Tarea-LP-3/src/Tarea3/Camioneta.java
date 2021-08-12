package tarea3;

public class Camioneta extends Vehiculo{

    Camioneta(int c){
        super.setconsumo(c);
    }

    //setter y getter consumo

    /** getConsumoV
    Parametro : void
    --------------------
    Descripción breve : funcion que sirve para obtener el consumov del Camioneta
    --------------------
    */
    public int getConsumoV(){return consumoV;}

    /** getConsumoV
    Parametro : void
    --------------------
    Descripción breve : funcion que sirve para obtener el consumov del Camioneta
    --------------------
    */
    public void setconsumo(int c){consumoV = c;}

}
