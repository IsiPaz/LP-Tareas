package tarea3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class Main {

	/** main
	--------------------
	Descripción breve : metodo que recorre los 3 archivos y guarda los datos, luego encuentra la ciudad optima
	--------------------
	*/

	public static void main(String[] args) {

		//Atributos comentados
		//(int) (n_ciudades) : cantidad de ciudades sacadas. //(int) (n_caminos) : cantidad de caminos.
		//(int) (n1) : primer valor del arreglo creado a partir de la linea leida en el archivo mapa.txt. //(int) (n2) : segundo valor del arreglo creado a partir de la linea leida en el archivo mapa.txt. //(int) (n3) : tercer valor del arreglo creado a partir de la linea leida en el archivo mapa.txt.
		//(int) (cont) : contador para ciclos. //(int) (cont1) : contador para ciclos.
		//(int) (combustible) : guarda el precio del combustible en la lectura del archivo empresa.txt.
		//(int) (no_linea_vacia) : indicador para lineas no vacias.
		//(String) (fileName1) : nombre del archivo1. //(String) (fileName2) : nombre del archivo2. //(String) (fileName3) : nombre del archivo3.
		//(String) (line) : linea vacias null.
		//(Pais) (pais) : atributo creado para guardar el pais que se extrae del archivo mapa.txt.
		//(Ciudad) (ciudad) : atributo creado para guardar ciudades que se extrae del archivo edificaciones.txt.

		int n_ciudades = 0; int n_caminos = 0;
		int n1 = 0,n2 = 0,n3 = 0;
        int cont = 0,cont1;
		int combustible = 0;

        int no_linea_vacia = 1;

		// The name of the file to open.
        String fileName1 = "mapa.txt";
        String fileName2 = "edificaciones.txt";
        String fileName3 = "empresa.txt";

        // This will reference one line at a time
        String line = null;
        Pais pais = new Pais(0,0);
        Ciudad ciudad =  new Ciudad(0,0,0);


//*************************file 1************************************
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName1);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader =  new BufferedReader(fileReader);
            while((line = bufferedReader.readLine()) != null) {

				String[] val = line.split(" ");

            	if ((val.length < 1) || (line.length()<1)) {
       				System.out.println("Linea vacia detectada en archivo " + fileName1 + ", por favor corregir el problema.");
       				no_linea_vacia = 0;
       				line = null;
       			}

        		if (no_linea_vacia == 1) {

        			//primera linea = nÂ° de nodos

        			if (cont  == 0){
        				n_ciudades = Integer.parseInt(line);
        			}

        			//segunda linea = nÂ° de caminos
        			else if (cont == 1){
        				n_caminos = Integer.parseInt(line);
        				pais = new Pais(n_ciudades,n_caminos);
        			}

        			//resto de lineas = relacion entre ciudades y sus caminos
        			else if (cont > 1) {
       					//System.out.println(val.length);
       					if (val.length == 3) {
       						n1 = Integer.parseInt(val[0]);
       						n2 = Integer.parseInt(val[1]);
        					n3 = Integer.parseInt(val[2]);

        					pais.addEdge(n1,n2,n3);
        				}
        				else if (val.length > 3) {
        					System.out.println("Sobran datos en relaciones, se tomaran los primeros 3");
        				}
       					else {
       						System.out.println("Faltan datos en relacion de nodos.");
       					}
        			}
        		}
        		cont +=1;
        	}
        	// Always close files.

            //System.out.println("cerrando archivo 1");
        	bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName1 + "'");
            System.out.println("");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName1 + "'");
            System.out.println("");
       		// Or we could just do this:
       		// ex.printStackTrace();
       	}

//*************************file 2************************************
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName2);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

						int sum_c = 0;
						int sum_e = 0;
            //cont = 0;

            while((line = bufferedReader.readLine()) != null){

                //System.out.println(line);
                String[] val = line.split(" ");

                if ((val.length < 1) || (line.length() < 1)) {
       				System.out.println("Linea vacia detectada en archivo" + fileName2 +", por favor corregir el problema.");
       				no_linea_vacia = 0;
       				line = null;
                }
        		if (no_linea_vacia == 1) {

        			if (val.length > 2) {

        				n1 = Integer.parseInt(val[0]);
        				n2 = Integer.parseInt(val[1]);
        				n3 = Integer.parseInt(val[2]);
        				ciudad = new Ciudad(n1,n2,n3);

        				if(n2!=0){ // si hay casas
        					line = bufferedReader.readLine();
        					val = line.split(" ");
        					if ((val.length < 1) || (line.length() < 1)) {
        	       				System.out.println("Linea vacia detectada en archivo" + fileName2 +", por favor corregir el problema.");
        	       				no_linea_vacia = 0;
        	       				line = null;
        	                }
        	        		if (no_linea_vacia == 1) {


        	        			sum_c = 0;
        	        			for (int c1 = 0;c1 < val.length; c1 ++) {
        	        				sum_c += Integer.parseInt(val[c1]);
        	        			}
        	        		}
        				}
        				if(n2==0){
        	        		sum_c = 0;
        				}

        				if(n3!=0){
        					line = bufferedReader.readLine();
        					val = line.split(" ");
        					sum_e = 0;
        					if ((val.length < 1) || (line.length() < 1)) {
        	       				System.out.println("Linea vacia detectada en archivo" + fileName2 +", por favor corregir el problema.");
        	       				no_linea_vacia = 0;
        	       				line = null;
        	                }
        	        		if (no_linea_vacia == 1) {

        	        			for (int c1 = 0;c1 < val.length; c1 ++) {
        	        				sum_e += Integer.parseInt(val[c1]);
        	        			}
        	        			pais.set_ciudad(ciudad,sum_c,sum_e);
        	        			//System.out.println(sum_c+"     "+sum_e);
        	        		}
        				}
        				if(n3==0){
        					sum_e = 0;
        					pais.set_ciudad(ciudad,sum_c,sum_e);
        					//System.out.println(sum_c+"     "+sum_e);
        				}
        			}
        		}
            }
            // Always close files.
            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName2 + "'");
        }

        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName2 + "'");
            // Or we could just do this:
            // ex.printStackTrace();
        }

//*************************file 3************************************
        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName3);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            cont = 0;
            int p_b = 0, p_l = 0, p_c;
            while((line = bufferedReader.readLine()) != null) {
            	//System.out.println(line);
    			if (line.length() < 1) {
       				System.out.println("Linea vacia detectada en archivo "+fileName3+", por favor corregir el problema.");
       				no_linea_vacia = 0;
       				line = null;
       			}
        		if (no_linea_vacia == 1) {
        			//primera linea = n° de nodos


        			//System.out.println(line);
        			if (cont  == 0) {
        				//precio balon gas de casas
        				p_b = Integer.parseInt(line);
        			}
        			else if (cont == 1){
        				//precio litro gas de edificios
        				p_l = Integer.parseInt(line);
        			}
        			else {
        				//precio consumo por transporte
        				p_c = Integer.parseInt(line);
								combustible = p_c;
        				pais.set_empresa(p_b,p_l,p_c);
						//System.out.println(p_b+" "+p_l+" "+p_c);

        			}
        			cont +=1;
        		}
            }
            // Always close files.
            bufferedReader.close();
        }

        catch(FileNotFoundException ex) {
            System.out.println("No es posible abrir el archivo '" + fileName3 + "'");
        }

		catch(IOException ex) {
            System.out.println("Error al leer el archivo '" + fileName3 + "'");
        }

//***************************************************************************************


	//Variables comentados
	//(int) (kilometros) : distancia total minima para llegar de una ciudad cont a una ciudad cont1.
	//(int) (gasto) : gasto total realizado al ir de una ciudad cont a una ciudad cont1.
	//(int) (ganancia) : valor que indica la ganancia respectiva de la ciudad.
	//(int) (trucks) : cantidad camiones utilizados en cada ciudad.
	//(int) (truckcitos) : cantidad de camionetas utilizadas en cada ciudad.
	//(int) (vehicles) : cantidad de vehiculos utilizados para repartir en cada ciudad.
	//(int) (cost_b) : Consumo por balon.
	//(int) (cost_l) : Consumo por litro.
	//(int) (consumoE) : consumo de los edificios en una ciudad.
	//(int) (consumoC) : consumo de casas en una ciudad.
	//(int) (utilidad) : se guarda la utilidad de cada ciudad.
	//(int) (max_utilidad) : utilidad maxima.
	//(ArrayList<Integer>) (c) : arreglo con el camino mas corto.
	//(ArrayList<Integer>) (ciudades_optimas) : arreglo con las ciudades optimas.
	//(int) (ConsumoC_O) : consumo casas ciudad de origen.
	//(int) (ConsumoE_O) : consumo edificios ciudad de origen.

	int kilometros = 0;
	int gasto, ganancia, trucks, truckcitos, vehicles,cost_l,cost_b,consumoC,consumoE, utilidad;


	//precios
	Empresa em = pais.get_empresa();
	cost_b = em.getPrecioBalones();
	cost_l = em.getPrecioLitros();

	ArrayList<Integer> ciudades_optimas = new ArrayList<Integer>();

	int max_utilidad = Integer.MIN_VALUE;

	for (cont = 0; cont< pais.nNodes() ;cont++){

		Ciudad origen = pais.get_ciudad(cont); //ciudad de origen
		int ConsumoC_O = origen.get_consumo_casa();
		int ConsumoE_O = origen.get_consumo_edificio();
		utilidad = 0;

		for (cont1 = 0; cont1 < pais.nNodes() ;cont1++){
			ganancia=0;gasto=0;

			ArrayList<Integer> c = pais.shortestPath(cont,cont1); //arreglo con el camino mas corto
			kilometros = pais.dist_recorrida(c); //distancia total minima para llegar de cont a cont1

			Ciudad destino = pais.get_ciudad(cont1); //ciudad de destino
			trucks = destino.getnEdificios();
			truckcitos = destino.getnCasa();

			if (truckcitos!= 0){
				truckcitos = 1;
			}


			vehicles = truckcitos+trucks;
			gasto = kilometros*combustible*vehicles;

			//consumos Casas/Edificios
			consumoC =  destino.get_consumo_casa();
			consumoE = destino.get_consumo_edificio();

			ganancia = cost_b*consumoC + cost_l*consumoE ;

			utilidad += ganancia - gasto;
		}

		origen.set_utilidad(utilidad);

		if (origen.get_utilidad() == max_utilidad){
			ciudades_optimas.add(origen.getid());
		}

		if (origen.get_utilidad() > max_utilidad) { //le saque el >=
			ciudades_optimas.clear();//la lista quedaria vacia
			max_utilidad = origen.get_utilidad();
			ciudades_optimas.add(origen.getid());
		}

	}

	// ESTO CALCULA LA UTILIDAD DEPENDIENDO DE LA CIUDAD OPTIMA
	for (int y = 0; y<ciudades_optimas.size(); y++){
		// (int) (opti) : id de la ciudad optima
		int opti = ciudades_optimas.get(y);
		System.out.println("\nLa ciudad "+opti+" es la ubicacion optima");
		for (cont1 = 0; cont1 < pais.nNodes() ;cont1++){
			gasto=0;ganancia=0;vehicles=0;utilidad = 0;
			ArrayList<Integer> c = pais.shortestPath(cont1,opti);
			kilometros = pais.dist_recorrida(c); //distancia total minima para llegar de cont a cont1

			Ciudad destino = pais.get_ciudad(cont1); //ciudad de destino
			trucks = destino.getnEdificios();
			truckcitos = destino.getnCasa();

			if (truckcitos!= 0){
				truckcitos = 1;
			}

			vehicles = truckcitos+trucks;
			gasto = kilometros*combustible*vehicles;

			//consumos Casas/Edificios
			consumoC =  destino.get_consumo_casa();
			consumoE = destino.get_consumo_edificio();

			ganancia = cost_b*consumoC + cost_l*consumoE;

			utilidad = ganancia-gasto;
			System.out.println("ciudad "+destino.getid()+":");
			System.out.println("- Utilidad: "+utilidad);
			if (pais.get_ciudad(cont1).getnCasa() > 0) {
				System.out.println("- utilizaron "+trucks+" camiones cisterna y 1 camionetas");
			}
			else {
				System.out.println("- utilizaron "+trucks+" camiones cisterna y 0 camionetas");
			}

		}

		System.out.println("\n");
	}


	}

}
