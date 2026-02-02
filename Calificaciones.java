public class Calificaciones {

    // ===== CLASE ESTUDIANTE =====
    static class Estudiante {
        String codigo;
        String nombre;
        double[] notas;
        int cantidad;

        Estudiante(String codigo, String nombre) {
            this.codigo = codigo;
            this.nombre = nombre;
            notas = new double[4];
            cantidad = 0;
        }

        void agregarNota(double nota) {
            notas[cantidad] = nota;
            cantidad++;
        }

        double promedio() {
            double suma = 0;
            for (int i = 0; i < cantidad; i++) {
                suma += notas[i];
            }
            return suma / cantidad;
        }

        boolean aprobo() {
            return promedio() >= 3.0;
        }
    }

    // ===== CLASE GESTOR CURSO =====
    static class GestorCurso {
        Estudiante[] estudiantes;
        int total;

        GestorCurso() {
            estudiantes = new Estudiante[5];
            total = 0;
        }

        void agregarEstudiante(Estudiante e) {
            estudiantes[total] = e;
            total++;
        }

        void mostrarEstudiantes() {
            for (int i = 0; i < total; i++) {
                System.out.println(
                    estudiantes[i].nombre +
                    " - Promedio: " +
                    estudiantes[i].promedio()
                );
            }
        }

        void estadisticas() {
            int aprobados = 0;
            int reprobados = 0;

            for (int i = 0; i < total; i++) {
                if (estudiantes[i].aprobo()) {
                    aprobados++;
                } else {
                    reprobados++;
                }
            }

            System.out.println("Aprobados: " + aprobados);
            System.out.println("Reprobados: " + reprobados);
        }
    }

    // ===== MÉTODO MAIN =====
    public static void main(String[] args) {

        GestorCurso curso = new GestorCurso();

        Estudiante e1 = new Estudiante("1", "Ana");
        e1.agregarNota(4.5);
        e1.agregarNota(3.8);
        e1.agregarNota(4.2);
        e1.agregarNota(4.0);

        Estudiante e2 = new Estudiante("2", "Luis");
        e2.agregarNota(2.5);
        e2.agregarNota(2.8);
        e2.agregarNota(3.0);
        e2.agregarNota(2.9);

        Estudiante e3 = new Estudiante("3", "Carlos");
        e3.agregarNota(3.5);
        e3.agregarNota(3.7);
        e3.agregarNota(3.9);
        e3.agregarNota(3.6);

        Estudiante e4 = new Estudiante("4", "Maria");
        e4.agregarNota(4.8);
        e4.agregarNota(4.9);
        e4.agregarNota(5.0);
        e4.agregarNota(4.7);

        Estudiante e5 = new Estudiante("5", "Pedro");
        e5.agregarNota(1.5);
        e5.agregarNota(2.0);
        e5.agregarNota(2.3);
        e5.agregarNota(1.8);

        curso.agregarEstudiante(e1);
        curso.agregarEstudiante(e2);
        curso.agregarEstudiante(e3);
        curso.agregarEstudiante(e4);
        curso.agregarEstudiante(e5);

        System.out.println("LISTADO DE ESTUDIANTES:");
        curso.mostrarEstudiantes();

        System.out.println("\nESTADÍSTICAS:");
        curso.estadisticas();
    }
}
