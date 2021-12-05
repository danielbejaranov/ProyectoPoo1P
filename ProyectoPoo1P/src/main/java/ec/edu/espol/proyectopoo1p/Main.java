
package ec.edu.espol.proyectopoo1p;

import ec.edu.espol.model.Concurso;
import ec.edu.espol.model.Criterio;
import ec.edu.espol.model.Dueno;
import ec.edu.espol.model.Evaluacion;
import ec.edu.espol.model.Inscripcion;
import ec.edu.espol.model.Mascota;
import ec.edu.espol.model.MiembroJurado;
import ec.edu.espol.model.Premio;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");        
        
        int opcion;
        
        do{
            System.out.println("MENU DE OPCIONES");
            System.out.println("1.Dueño");
            System.out.println("2.Mascota");
            System.out.println("3.Concurso");
            System.out.println("4.Premio");
            System.out.println("5.Criterio");
            System.out.println("6.Inscripcion");
            System.out.println("7.MiembroJurado");
            System.out.println("8.Evaluacion");
 
            System.out.println("Por favor digite una opción: ");
            opcion = sc.nextInt();
            
            switch(opcion){
                
                case 1:
                    Dueno.nextDueno(sc, "dueños.txt");
                    break;
                    
                case 2:
                    Mascota.nextMascota(sc, "mascotas.txt");                    
                    break;
                    
                case 3:
                    //System.out.println("Concurso");
                    Concurso concurso = Concurso.nextConcurso(sc, "concursos.txt");
                    break;
                    
                case 4:
                    System.out.println("Premio");
                    Premio premio1 = Premio.nextPremio(sc);
                    break;
                    
                case 5:
                    System.out.println("Criterio");
                    Criterio criterio1 = Criterio.nextCriterio(sc);
                    break;
                    
                case 6:
                    System.out.println("Inscripcion");
                    Inscripcion inscripcion1 = Inscripcion.nextInscripcion(sc);
                    break;
                    
                case 7:
                    System.out.println("Miembro del jurado");
                    MiembroJurado jurado = MiembroJurado.nextMiembroJurado(sc, "miembroJurados.txt");
                    break;
                    
                case 8:
                    System.out.println("Evaluacion");
                    Evaluacion evaluacion1 = Evaluacion.nextCalificacion(sc);
                    break;
                    
                default:
                    System.out.println("Opción invalida, por favor ingrese una opcion valida");
                    break;
            } //fin de switch
            
        }while (opcion >= 1);   //fin del ciclo do while
        System.out.println("EL PROGRAMA HA FINALIZADO");
        
    } //fin metodo main
    
} // fin de la clase main
