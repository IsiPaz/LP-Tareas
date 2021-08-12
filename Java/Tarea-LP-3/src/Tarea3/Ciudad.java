 package tarea3;

    public class Ciudad{

    protected int id;
    protected int nEdificios;
    protected int nCasa;
    protected Casa casa = new Casa(0);					//lineas extendidas, me estaban dando errores los set y get
    protected Edificio edificio = new Edificio(0);
    protected int utilidad;

    // Casa casa = casa donde se guarda el consumo de las casas de la ciudad
    // Edificio edificio = edificio donde se guarda el consumo de los edificios de la ciudades
    // int Utilidad = utilidad de la ciudad

    Ciudad(int i, int nc, int ne){
        setid(i);
        setnEdificios(ne);
        setnCasa(nc);
        utilidad = 0;
    }

    //getters

     /** getid
     Parametro : id
     --------------------
     Descripción breve : obtiene la id de la ciudad
     --------------------
     */
     public int getid(){return id;}

     /** getnEdificios
     Parametro : void
     --------------------
     Descripción breve : obtiene la cantidad de edificios que tiene la ciudad
     --------------------
     */
     public int getnEdificios(){return nEdificios;}

     /** getnCasa
     Parametro : void
     --------------------
     Descripción breve : obtiene la cantidad de casas que tiene la ciudad
     --------------------
     */
     public int getnCasa(){return nCasa;}

     /** get_consumo_edificio
     Parametro : void
     --------------------
     Descripción breve : retorna el consumo de los edificios que hay en la ciudad
     --------------------
     */
     public int get_consumo_edificio(){
         return edificio.getConsumo();
     }

     /** get_consumo_casa
     Parametro : void
     --------------------
     Descripción breve : retorna el consumo de las casas que hay en la ciudad
     --------------------
     */
     public int get_consumo_casa(){
         return casa.getConsumo();
     }

     /** get_utilidad_
     Parametro : void
     --------------------
     Descripción breve : retorna la utilidad de la ciudad
     --------------------
     */
     public int get_utilidad(){
         return this.utilidad;
     }

     //setters

     /** setid
     (int) (i) : entero con la id
     --------------------
     Descripción breve : guarda la id de la ciudad
     --------------------
     */
     public void setid(int i){this.id=i;}

     /** setnEdificios
     (int) (ne) : entero que represent la cantidad de edificios
     --------------------
     Descripción breve :  guarda la cantidad de edificios de la ciudad
     --------------------
     */
     public void setnEdificios(int ne){this.nEdificios = ne;}

     /** setnCasa
     (void) (setnCasa) : cant de casas que tiene la ciudad
     --------------------
     Descripción breve : guarda la cantidad de casas de la ciudad
     --------------------
     */
     public void setnCasa(int nc){this.nCasa = nc;}

     /** set_consumo_edificio
     (int) (consumo) : cantidad de consumo de los edificios en la ciudad
     --------------------
     Descripción breve : guarda el consumo total de los edificio que hay en la ciudad
     --------------------
     */
     public void set_consumo_edificio(int consumo){
         this.edificio = new Edificio(consumo);
     }

     /** set_consumo_casa
     (int) (consumo) :  cantidad de consumo de las casas totales en la ciudad
     --------------------
     Descripción breve : guarda el consumo de las casas que hay en la ciudad
     --------------------
     */
     public void set_consumo_casa(int consumo){
         this.casa = new Casa(consumo);
     }

     /** set_utilidad
     (int) (u) :  entero que representa la utilidad de la ciudad
     --------------------
     Descripción breve : guarda la utilidad de la ciudad
     --------------------
     */
     public void set_utilidad(int u){
         this.utilidad = u;
     }


    }
