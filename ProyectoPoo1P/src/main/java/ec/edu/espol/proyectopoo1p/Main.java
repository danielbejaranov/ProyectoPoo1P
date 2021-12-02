
package ec.edu.espol.proyectopoo1p;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    
        System.out.println("Menú de opciones");
        System.out.println("1. Dueño");
        System.out.println("2. Mascota");
        System.out.println("3. Concurso");
        System.out.println("4. Premio");
        System.out.println("5. Criterio");
        System.out.println("6. Inscripción");
        System.out.println("7. MiembroJurado");
        System.out.println("8. Evaluacion");        
    
        int opcion;
        
        do{ 
            System.out.println("Ingrese una opcion: ");
            Scanner sc = new Scanner(System.in);
            opcion = sc.nextInt();
            
            switch(opcion){    
                
                case 1: 
                    System.out.println("op1");
                    break;
                    
                case 2:
                    System.out.println("op2");
                    break;
                    
                case 3:
                    System.out.println("op3");
                    break;
                    
                case 4:
                    System.out.println("op4");
                    break;
                    
                case 5:
                    System.out.println("op5");
                    break;
                    
                case 6:
                    System.out.println("op6");
                    break;
                    
                case 7:
                    System.out.println("op7");
                    break;
                    
                case 8:
                    System.out.println("op8");
                    break;
                    
                default: System.out.println("Opcion invalida");
                    break;
            } 
        } while (opcion >= 1) ;
    }  
}
