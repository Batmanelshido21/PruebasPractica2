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
    int año;

    int bandera = 1;
    while (bandera == 1) {
      mes = llenarMes(lector);
      if (mes != 0) {
        dia = llenarDia(lector, mes);
        if (dia != 0) {
          año = llenarAño(lector);
          if (año != 0) {
            NextDate(mes, dia, año);
          }
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

  private static int llenarAño(Scanner lector) {
    try {
      System.out.println("Introduce el año");
      int año = lector.nextInt();
      if ((año >= 1812) && (año <= 2020)) {
        return año;
      } else {
        System.out.println("Error en el rango del año");
      }
    } catch (InputMismatchException e) {
      System.out.println("Introduzca un valor entero");
    }
    return 0;
  }


  private static int llenarDia(Scanner lector, int mes) {
    try {
      System.out.println("Introduce el día");
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
        System.out.println("Introduce un día valido para el mes seleccionado");

      }
    } catch (InputMismatchException e) {
      System.out.println("Introduzca un valor entero");
    }
    return 0;
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

  private static void NextDate(int mes, int dia, int año) {
    if ((mes == 2) && (dia == 28)) {
      mes++;
      dia = 1;
    } else if ((mes == 1) && (dia == 31) || (mes == 3) && (dia == 31) || (mes == 5) && (dia == 31)
        || (mes == 7) && (dia == 31) || (mes == 8) && (dia == 31) || (mes == 10) && (dia == 31)
        || (mes == 12) && (dia == 31)) {
      if (mes == 12) {
        año++;
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
    System.out.println("año " + año);
  }

}
