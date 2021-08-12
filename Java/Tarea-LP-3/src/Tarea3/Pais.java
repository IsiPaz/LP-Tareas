package tarea3;

//EXCEPTION
import java.lang.ArrayIndexOutOfBoundsException;
import java.lang.UnsupportedOperationException;

//LIBRERIAS
import java.util.Stack;
import java.util.ArrayList;


public class Pais implements Grafo{

    //Atributos comentados
    //(int) (cant_ciudades) : cantidad de nodos que tendra el grafo.
    //(int) (max_caminos) : cantidad de aristas qie tendra el grafo.
    //(int) (aristas) : cantidad de aristas actuales.
    //(int) (matrix) : Matriz basada en arreglos.
    //(int) (i,j) : contadores.
    //(Ciudad) (M_ciudades) : arreglo que almacena ciudades del respectivo pais.
    //(Empresa) (e) : empresa que pertenece al pais.

    protected final int cant_ciudades; //nodos
    protected final int max_caminos; //edges
    protected int aristas; //cantidad de aristas actuales
    protected int matrix[][]; //matriz de ady
    protected int i ; protected int j; //contadores
    protected Ciudad M_ciudades[];
    protected Empresa e;


    Pais(int ciudades, int caminos){ //constructor de la matriz
        cant_ciudades = ciudades;
        this.M_ciudades = new Ciudad[cant_ciudades];
        e = new Empresa(0,0);// new
        max_caminos = caminos;
        this.aristas = 0;

        matrix = new int[cant_ciudades][cant_ciudades];

        for (i = 0; i<nNodes(); i++){ //incializa la matriz en 0
            for (j = 0; j<nNodes(); j++){
                matrix[i][j]=0;
            }
        }
    }

    //nNodes: número de nodos del grafo.
    public int nNodes(){
        return cant_ciudades;
    }

    //nEdges: número de arcos del grafo.
    public int nEdges(){
        return max_caminos;
    }

    //edgeWeight: recibe como parámetro el identificador de dos nodos vecinos y retorna el peso de este arco.
    public int edgeWeight(int c1, int c2){
        try{
            if (matrix[c1][c2]!= 0){
                return matrix[c1][c2];
            }
            else {
            	return 0;
            }
        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Vertices inválidos, fuera de rango");
        }
        return 0;		//temporal

    }  // AGREGAR EXCEPCION DE QUE LAS CIUDADES INGRESADAS NO EXISTAN DENTRO DEL RANGO DE LA MATRIZ

    //addEdge: recibe el identificador de dos nodos y el peso de este arco respectivamente.
    public void addEdge(int c1, int c2, int dist){
        try{
            matrix[c1][c2] = dist;
            matrix[c2][c1] = dist;
            this.aristas = this.aristas+1;
        }

        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Vertices inválidos, fuera de rango");
        }

        catch (UnsupportedOperationException e){
            System.out.println("No es posible añadir más aristas");
        }
    }

    /** nombre: public ArrayList<Integer> camino
    (int) (b)
    (int[]) (parents)
    (ArrayList<Integer>) (lista)
    --------------------
    Descripción : Metodo auxiliar creado para retornar un ArrayList con las ciudades que forman el camino mas corto.
    --------------------
    */
    public ArrayList<Integer> camino(int b, int[] parents, ArrayList<Integer> lista){
        Stack<Integer> pila = new Stack<Integer>();
        int num;
        pila.push(b);

        for (int y = 0; y < parents.length; y++){
            num = parents[b];
            if (num == -1){
                y=parents.length;
            }
            else{
                pila.push(num);
                b=num;
            }
        }

        while(pila.empty() != true){

            int top = pila.peek();
            lista.add(top);
            pila.pop();
        }

        return lista;
    }


    //shortestPath: recibe el identificador de dos nodos y retorna el camino mas corto.
    public ArrayList<Integer> shortestPath(int a, int b){
        int i; int j;
        int cant_vertices = nNodes();
        int[]shortest_path = new int[cant_vertices]; //
        boolean[] visitados = new boolean[cant_vertices]; //
        int[] parents = new int[cant_vertices]; //
        ArrayList<Integer> lista = new ArrayList<Integer>();

        try{

            if (a==b){
                lista.add(0);
                return lista;
            }
            else{
                for(i=0;i<cant_vertices;i++){
                    shortest_path[i] = Integer.MAX_VALUE;
                    visitados[i] = false;
                }

                shortest_path[a] = 0;

                parents[a] = -1;

                for (j = 1; j < cant_vertices; j++){ 

                    int shortestDistance = Integer.MAX_VALUE;
                    int nearestVertex = -1;

                    for (i=0; i < cant_vertices; i++) {
                        if (!visitados[i] && shortest_path[i] < shortestDistance) {
                            nearestVertex = i;
                            shortestDistance = shortest_path[i];
                        }
                    }

                    visitados[nearestVertex] = true;


                    for (i = 0; i < cant_vertices; i++) {
                        int edgeDistance = this.matrix[nearestVertex][i];
                        if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < shortest_path[i])){
                            parents[i] = nearestVertex;
                            shortest_path[i] = shortestDistance + edgeDistance;
                        }
                    }

                }

                return camino(b,parents,lista);
            }
        }

        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Vertices inválidos, fuera de rango");
        }
        return lista;
    }


    /** Nombre: public void set_ciudad
     (Ciudad) (ciudad)
     (int) (g_c)
     (int) (g_e)
     --------------------
     Descripción breve : guardar consumo de casas y edificios en ciudad, luego guarda ciudad en un array en posicion de su id
     --------------------
     */

    public void set_ciudad (Ciudad ciudad, int g_c, int g_e) {

      ciudad.set_consumo_casa(g_c);
    	ciudad.set_consumo_edificio(g_e);
    	this.M_ciudades[ciudad.getid()] = ciudad;
    }

    /** set_empresa
    (int) (p_b)
    (int) (p_l)
    (int) (p_c)
    --------------------
    Descripción breve : guarda una empresas
    --------------------
    */

    public void set_empresa(int p_b,int p_l,int p_c){
        e = new Empresa(p_b,p_l);
        Camion_cisterna camion = new Camion_cisterna(p_c);

    }

    /** get_ciudad
    (int) (pos)
    --------------------
    Descripción breve : obtiene del arreglo de ciudades segun su id
    --------------------
    */

    public Ciudad get_ciudad(int pos){
        return this.M_ciudades[pos];
    }

    /** get_empresa
    parametro : void
    --------------------
    Descripción breve : obtiene la empresa del pais
    --------------------
    */

    public Empresa get_empresa(){
        return e;
    }

    /** dist_recorrida
    (ArrayList<Integer>) (carretera)
    --------------------
    Descripción breve : retorna la distancia total de un camino guardado en el array que es entregado como Parametro
    --------------------
    */

    public int dist_recorrida(ArrayList<Integer> carretera){
        int x,y,z;
        int total=0;

        y=0; z=0;


        for (x=0;x<carretera.size()-1;x++){

          y = carretera.get(x);
          z = carretera.get(x+1);
          total = this.matrix[y][z]+total;
        }

        return total;
    }

}
