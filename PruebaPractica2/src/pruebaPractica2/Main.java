package pruebaPractica2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author javier
 *
 */
public class Main {
  /**
   * @param args
   */
  public static void main(String[] args) {
    Scanner lector = new Scanner(System.in);
    int mes;
    int dia;
    int a�o;

    int bandera = 1;
    while (bandera == 1) {
      mes = llenarMes(lector);
      if (mes != 0) {
        dia = llenarDia(lector, mes);
        if (dia != 0) {
          a�o = llenarA�o(lector);
          if (a�o != 0 && !esA�oBisiesto( a�o ) ) {
            NextDate(mes, dia, a�o);
          }
          else
        	  NextDateBisiesto( mes, dia, a�o );
        }
      }
      try {
        System.out.println("Desea continuar 1=si cualquiera=salir");
        lector.nextLine();
        bandera = lector.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Introduzca un valor entero");
      }
    }
    System.out.println("Proceso finalizado");
  }

  private static int llenarA�o(Scanner lector) {
    try {
      System.out.println("Introduce el a�o");
      int a�o = lector.nextInt();
      if ((a�o >= 1812) && (a�o <= 2020)) {
        return a�o;
      } else {
        System.out.println("Error en el rango del a�o");
      }
    } catch (InputMismatchException e) {
      System.out.println("Introduzca un valor entero");
    }
    return 0;
  }


  private static int llenarDia(Scanner lector, int mes) {
    try {
      System.out.println("Introduce el d�a");
      int dia = lector.nextInt();
      if ((mes == 2) && (dia <= 29) && (dia >= 1)) {
        return dia;
      } else if ((mes == 1) && (dia >= 1) && (dia <= 31) || (mes == 3) && (dia >= 1) && (dia <= 31)
          || (mes == 5) && (dia >= 1) && (dia <= 31) || (mes == 7) && (dia >= 1) && (dia <= 31)
          || (mes == 8) && (dia >= 1) && (dia <= 31) || (mes == 10) && (dia >= 1) && (dia <= 31)
          || (mes == 12) && (dia >= 1) && (dia <= 31)) {
        return dia;
      } else if ((mes == 4) && (dia >= 1) && (dia <= 30) || (mes == 6) && (dia >= 1) && (dia <= 30)
          || (mes == 9) && (dia >= 1) && (dia <= 30) || (mes == 11) && (dia >= 1) && (dia <= 30)) {
        return dia;
      } else {
        System.out.println("Introduce un d�a valido para el mes seleccionado");

      }
    } catch (InputMismatchException e) {
      System.out.println("Introduzca un valor entero");
    }
    return 0;
  }
  
  private static boolean esA�oBisiesto( int a�o )
  {
	  if( a�o % 4 == 0 ){
		  return true;
	  }
	  else
		  return false;
  }


  private static int llenarMes(Scanner lector) {
    try {
      System.out.println("Introduce el mes");
      int mes = lector.nextInt();
      if ((mes >= 1) && (mes <= 12)) {
        return mes;
      } else {
        System.out.println("Introduzca un mes valido");
      }
    } catch (InputMismatchException e) {
      System.out.println("Introduzca un valor entero");
    }
    return 0;
  }

  private static void NextDate(int mes, int dia, int a�o) {
    if( mes == 2 && dia == 29 ) {
	System.out.println( "La fecha introducida no es v�lida." );
  }
    else{
    	if ((mes == 2) && (dia == 28)) {
    	      mes++;
    	      dia = 1;
    	    } else if ((mes == 1) && (dia == 31) || (mes == 3) && (dia == 31) || (mes == 5) && (dia == 31)
    	        || (mes == 7) && (dia == 31) || (mes == 8) && (dia == 31) || (mes == 10) && (dia == 31)
    	        || (mes == 12) && (dia == 31)) {
    	      if (mes == 12) {
    	        a�o++;
    	        mes = 0;
    	      }
    	      mes++;
    	      dia = 1;
    	    } else if ((mes == 4) && (dia == 30) || (mes == 6) && (dia == 30) || (mes == 9) && (dia == 30)
    	        || (mes == 11) && (dia == 30)) {
    	      mes++;
    	      dia = 1;
    	    } else {
    	      dia++;
    	    }
    	    System.out.println("dia " + dia);
    	    System.out.println("mes " + mes);
    	    System.out.println("a�o " + a�o);
    }
  }
  
  private static void NextDateBisiesto( int mes, int dia, int a�o ) {
	  if ((mes == 2) && (dia == 29)) {
	      mes++;
	      dia = 1;
	    } else if ((mes == 1) && (dia == 31) || (mes == 3) && (dia == 31) || (mes == 5) && (dia == 31)
	        || (mes == 7) && (dia == 31) || (mes == 8) && (dia == 31) || (mes == 10) && (dia == 31)
	        || (mes == 12) && (dia == 31)) {
	      if (mes == 12) {
	        a�o++;
	        mes = 0;
	      }
	      mes++;
	      dia = 1;
	    } else if ((mes == 4) && (dia == 30) || (mes == 6) && (dia == 30) || (mes == 9) && (dia == 30)
	        || (mes == 11) && (dia == 30)) {
	      mes++;
	      dia = 1;
	    } else {
	      dia++;
	    }
	    System.out.println("dia " + dia);
	    System.out.println("mes " + mes);
	    System.out.println("a�o " + a�o);
  }

}
