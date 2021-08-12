package tarea3;

public class Casa extends Edificacion{

    Casa(int c){
        setBalones(c);
    }

    //setter y getter Balones

    /** getConsumo
    Parametro : void
    --------------------
    Descripción breve : permite obtener consumo de balones de casas
    --------------------
    */
    public int getConsumo(){return super.consumo;}


    /** setBalones
    Parametro : (int) (balones)
    --------------------
    Descripción  breve :  permite guardar el valor del consumo(balones) en casas
    --------------------
    */
	public void setBalones(int balones){super.consumo = balones;}

}
