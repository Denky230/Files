
package files;

import java.util.InputMismatchException;
import java.util.Scanner;

import management.IOManager;
import management.SportsManager;

public class Files {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Menu variables
        boolean exit = false;
        int menuOption;

        // Initialize sports
        SportsManager.fillSportsList();
        // Check if program folder structure exists
        IOManager.makeActiveSportsFolders();

        while (!exit) {
            System.out.println("\nQue quieres hacer?\n"
                    + "1 - Inscribir alumno\n"
                    + "2 - Consultar alumnos por curso\n"
                    + "3 - Consultar qué deportes no son jugables\n"
                    + "4 - Eliminar inscripción alumno\n"
                    + "5 - Ver listado de inscripciones\n"
                    + "6 - Anular deporte\n"
                    + "0 - Salir"
            );

            try {
                menuOption = in.nextInt();
                boolean validOption;

                do {
                    validOption = true;

                    // TO DO
                    switch (menuOption) {
                        case 1: // ADD STUDENT
                            System.out.println("Inserta los siguientes datos: Nombre, Apellidos, Curso, Género, Edad y Deporte");
                            break;
                        case 2: // CHECK STUDENT BY COURSE
                            break;
                        case 3: // CHECK SPORTS READINESS
                            break;
                        case 4: // REMOVE STUDENT
                            break;
                        case 5: // CHECK INSCRIPTIONS
                            break;
                        case 6: // REMOVE SPORT
                            break;
                        case 0: // EXIT
                            exit = true;
                            break;
                        default:
                            System.out.println("Esa opción no existe, elije una que exista");
                            validOption = false;
                    }
                } while (!validOption);
            } catch (InputMismatchException e) {
                System.out.println("Ha habido un error en la introducción de datos");
                in.nextLine();
            }
        }
    }
}