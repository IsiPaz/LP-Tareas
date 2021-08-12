package tarea3;

public class Empresa{

    protected int PrecioLitros;
    protected int PrecioBalones;

    Empresa (int pb , int pl){
    	setPrecioLitros(pl);
        setPrecioBalones(pb);
    }

    /** getPrecioLitros
    Parametro : void
    --------------------
    Descripción breve : permite obtener el precio del litro de gas de la empresa
    --------------------
    */

    public int getPrecioLitros(){
        return PrecioLitros;
    }

    /** getPrecioBalones
    Parametro : void
    --------------------
    Descripción breve : permite obtener el precio del balon de gas de la empresa
    --------------------
    */

    public int getPrecioBalones(){
        return PrecioBalones;
    }


    /** setPrecioLitros
    Parametro : (int) (pl)
    --------------------
    Descripción breve : permite guardar el precio del litro de gas
    --------------------
    */

    public void setPrecioLitros(int pl){
        PrecioLitros = pl;
    }

    /** setPrecioBalones
    Parametro : (int) (pb)
    --------------------
    Descripción breve : permite guardar el precio del balon de gas
    --------------------
    */

    public void setPrecioBalones(int pb){
        PrecioBalones = pb;
    }

}
