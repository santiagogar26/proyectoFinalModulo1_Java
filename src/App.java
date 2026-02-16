import java.util.Scanner;

public class App {
   
    static String nombre = "N/A", estado = "N/A";
    static double nota1 = -1, nota2 = -1, nota3 = -1;
    static double promedio = 0;

    public static void main(String[] args) throws Exception {
       Scanner sc = new Scanner(System.in);
       int opcion; 

       do{
            mostrarMenu();
            opcion = leerEnteros(sc, "Seleccione una opción: ");
            sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarEstudiante(sc);
                    break;

                case 2:
                    mostrarEstudiante();
                    break;

                case 3:
                    calcularPromedio();
                    break;

                case 4:
                    mostrarEstudiante();
                    System.out.printf("Promedio: %.2f%n", promedio);
                    setEstado();
                    break;

                case 5:
                    nombre = "N/A";
                    nota1 = -1;
                    nota2 = -1;
                    nota3 = -1;
                    promedio = 0;
                    estado = "N/A";
                    break;

                case 0:
                    System.out.println("Saliendo del programa...");
                    break; 
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción del menú");
                    break;
            }
        } while (opcion != 0);

        sc.close();
    }

static void mostrarMenu() {
    System.out.println("\n=== Menú de Gestión de Estudiantes ===");
    System.out.println("1. Registrar datos de un estudiante");
    System.out.println("2. Mostrar datos del estudiante actual");
    System.out.println("3. Calcular promedio de notas");
    System.out.println("4. Mostrar resumen completo del estudiante");
    System.out.println("5. Limpiar datos del estudiante actual");
    System.out.println("0. Salir");
}

static int leerEnteros(Scanner sc, String mensaje) {
    int numero;
    System.out.println(mensaje);
    numero = sc.nextInt();
    sc.nextLine();
    return numero;
}

static void registrarEstudiante(Scanner sc) {
    
    nombre = validarNombre(sc);

    nota1 = leerNotas(sc, "Ingrese la nota 1: ");
    nota2 = leerNotas(sc, "Ingrese la nota 2: ");
    nota3 = leerNotas(sc, "Ingrese la nota 3: ");
    System.out.println("Datos del estudiante registrados exitosamente.");
    }

    static double leerNotas(Scanner sc, String mensaje) {
        double nota;
        while (true) {
            System.out.println(mensaje);
            String linea = sc.nextLine().replace(",", ".");
            nota = Double.parseDouble(linea);
            if (validarNota(nota)) {
                break;
            } else {
                System.out.println("Nota no válida. Por favor, ingrese una nota entre 0 y 100.");
            }
        }
        return nota;
    }

    static void mostrarEstudiante() {
        if (nombre.equals("N/A")) {
            System.out.println("No se han registrado datos del estudiante.");
        } else {
            System.out.println("Nombre del estudiante: " + nombre);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    static boolean validarNota(double nota) {
        return nota >= 0 && nota <= 100;
    }

    static void calcularPromedio() {
        if (nombre.equals("N/A")) {
            System.out.println("No se han registrado datos del estudiante.");
        } else {
            promedio = (nota1 + nota2 + nota3) / 3;
            System.out.printf("Promedio: %.2f%n", promedio);
        }
    }

    static void setEstado(){
        estado = (promedio >= 60) ? "Aprobado" : "Reprobado";
        System.out.println("Estado: " + estado);
    }

    static String validarNombre(Scanner sc) {
        String nombreInput;
        while (true) {
            System.out.println("Ingrese el nombre del estudiante:");
            nombreInput = sc.nextLine().trim();
            if (!nombreInput.isEmpty()) {
                nombre = nombreInput;
                break;
            } else {
                System.out.println("El nombre no puede estar vacío. Por favor, ingrese un nombre válido.");
            }
        }
        return nombreInput;
    }
}

