package com.antonipeiro.pruebasJUnit;

public class Main {

    /* -------------------------------------------
    ---------------- EJERCICIO 1 -----------------
    -------------------------------------------- */

    public static int signo(int x) {
        if (x > 0) {
            return 1;
        } else if (x < 0) {
            return -1;
        }
        return 0;
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 2 -----------------
    -------------------------------------------- */

    public static String clasificarEdad(int edad) {
        if (edad < 0) {
            throw new IllegalArgumentException("Edad no válida");
        }
        if (edad < 6) {
            return "Infancia";
        } else if (edad < 12) {
            return "Niñez";
        } else if (edad < 18) {
            return "Adolescencia";
        } else if (edad < 25) {
            return "Juventud";
        } else if (edad < 60) {
            return "Adultez";
        } else {
            return "Vejez";
        }
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 3 -----------------
    -------------------------------------------- */

    public static int contarPositivos(int[] datos) {
        int contador = 0;
        for (int i = 0; i < datos.length; i++) {
            if (datos[i] > 0) {
                contador++;
            }
        }
        return contador;
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 4 -----------------
    -------------------------------------------- */

    public static String calificacion(int nota) {
        if (nota < 0 || nota > 10) {
            throw new IllegalArgumentException("Nota no válida");
        }
        return switch (nota) {
            case 0, 1, 2, 3, 4 -> "SUSPENSO";
            case 5 -> "SUFICIENTE";
            case 6 -> "BIEN";
            case 7, 8 -> "NOTABLE";
            default -> "SOBRESALIENTE";
        };
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 5 -----------------
    -------------------------------------------- */

    public static boolean esBisiesto(int anyo) {
        if ((anyo % 4 == 0 && anyo % 100 != 0) || (anyo % 400 == 0)) {
            return true;
        } else {
            return false;
        }
    }

    /* -------------------------------------------S
    ---------------- EJERCICIO 6 -----------------
    -------------------------------------------- */

    public static String jugar(String jugador1, String jugador2) {
        // Validar entradas nulas o vacías
        if (jugador1 == null || jugador2 == null) {
            throw new IllegalArgumentException("La jugada no puede ser nula");
        }

        // Normalizar a mayúsculas para evitar errores de formato
        String j1 = jugador1.toUpperCase();
        String j2 = jugador2.toUpperCase();

        // Validar jugadas permitidas [cite: 182, 192]
        if (!esValida(j1) || !esValida(j2)) {
            throw new IllegalArgumentException("Jugada no válida");
        }

        // Lógica de empate
        if (j1.equals(j2)) {
            return "EMPATE";
        }

        // Lógica de resolución [cite: 187, 188, 190]
        if ((j1.equals("PIEDRA") && j2.equals("TIJERA")) ||
                (j1.equals("TIJERA") && j2.equals("PAPEL")) ||
                (j1.equals("PAPEL") && j2.equals("PIEDRA"))) {
            return "GANA JUGADOR 1";
        }

        return "GANA JUGADOR 2";
    }

    private static boolean esValida(String jugada) {
        return jugada.equals("PIEDRA") || jugada.equals("PAPEL") || jugada.equals("TIJERA");
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 7 -----------------
    -------------------------------------------- */

    public static int evaluarPassword(String password) {
        if (password == null || password.isEmpty()) {
            return 0;
        }

        int puntos = 0;

        // 1. Al menos 8 caracteres
        if (password.length() >= 8) {
            puntos++;
        }

        // 2. Contiene mayúsculas
        if (password.matches(".*[A-Z].*")) {
            puntos++;
        }

        // 3. Contiene minúsculas
        if (password.matches(".*[a-z].*")) {
            puntos++;
        }

        // 4. Contiene números
        if (password.matches(".*[0-9].*")) {
            puntos++;
        }

        // 5. Contiene símbolos (caracteres no alfanuméricos)
        if (password.matches(".*[^a-zA-Z0-9].*")) {
            puntos++;
        }

        return puntos;
    }
}