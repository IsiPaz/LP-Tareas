package tarea3;

public class Edificio extends Edificacion{

    Edificio(int c){
        setLitros(c);
    }

    //setter y getter Litros

    /** getConsumo
    Parametro : void
    --------------------
    Descripción breve : funcion para obtener el consumo en litros de edificio
    --------------------
    */

    public int getConsumo(){return super.consumo;}

    /** setLitros
    Parametro : (int) (litros)

    --------------------
    Descripción breve : funcion que permite guardar la cantidad de consumo(litros en edificio)
    --------------------
    */

	public void setLitros(int litros){super.consumo = litros;}

}
