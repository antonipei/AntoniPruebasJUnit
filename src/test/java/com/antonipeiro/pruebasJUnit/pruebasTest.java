package com.antonipeiro.pruebasJUnit;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class pruebasTest {


    /* -------------------------------------------
    ---------------- EJERCICIO 1 -----------------
    -------------------------------------------- */

    @Test
    void testSignoPositivo() {
        assertEquals(1, Main.signo(5), "Debe retornar 1 para números positivos");
    }

    @Test
    void testSignoNegativo() {
        assertEquals(-1, Main.signo(-8), "Debe retornar -1 para números negativos");
    }

    @Test
    void testSignoCero() {
        assertEquals(0, Main.signo(0), "Debe retornar 0 para el valor cero");
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 2 -----------------
    -------------------------------------------- */

    @Test
    void testEdadInvalidaCero() {
        assertThrows(IllegalArgumentException.class, () -> {
            Main.clasificarEdad(-1);
        }, "Debe lanzar excepción para edad 0");
    }

    @Test
    void testInfanciaLimite() {
        assertEquals("Infancia", Main.clasificarEdad(5));
    }

    @Test
    void testNinez() {
        assertEquals("Niñez", Main.clasificarEdad(11));
    }

    @Test
    void testAdolescencia() {
        assertEquals("Adolescencia", Main.clasificarEdad(12));
    }

    @Test
    void testJuventud() {
        assertEquals("Juventud", Main.clasificarEdad(20));
    }

    @Test
    void testAdultez() {
        assertEquals("Adultez", Main.clasificarEdad(59));
    }

    @Test
    void testVejez() {
        assertEquals("Vejez", Main.clasificarEdad(60));
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 3 -----------------
    -------------------------------------------- */

    @Test
    void testArrayVacio() {
        int[] entrada = {};
        assertEquals(0, Main.contarPositivos(entrada),
                "Un array vacío debe devolver 0");
    }

    @Test
    void testSoloNegativos() {
        int[] entrada = {-1, -10, -5};
        assertEquals(0, Main.contarPositivos(entrada),
                "Un array sin positivos debe devolver 0");
    }

    @Test
    void testMezclaValores() {
        int[] entrada = {10, -2, 0, 5, -1};
        // Solo 10 y 5 son positivos
        assertEquals(2, Main.contarPositivos(entrada),
                "Debe contar correctamente solo los elementos > 0");
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 4 -----------------
    -------------------------------------------- */

    @Test
    void testNotaMenorACero() {
        assertThrows(IllegalArgumentException.class, () -> Main.calificacion(-1));
    }

    @Test
    void testNotaMayorADiez() {
        assertThrows(IllegalArgumentException.class, () -> Main.calificacion(11));
    }

    @Test
    void testSuspenso() {
        assertEquals("SUSPENSO", Main.calificacion(4));
    }

    @Test
    void testSuficiente() {
        assertEquals("SUFICIENTE", Main.calificacion(5));
    }

    @Test
    void testBien() {
        assertEquals("BIEN", Main.calificacion(6));
    }

    @Test
    void testNotable() {
        assertEquals("NOTABLE", Main.calificacion(8));
    }

    @Test
    void testSobresaliente() {
        assertEquals("SOBRESALIENTE", Main.calificacion(10));
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 5 -----------------
    -------------------------------------------- */

    @Test
    void testDivisiblePor4No100() {
        assertTrue(Main.esBisiesto(2024), "2024 debe ser bisiesto");
    }

    @Test
    void testDivisiblePor100No400() {
        assertFalse(Main.esBisiesto(2100), "2100 no debe ser bisiesto");
    }

    @Test
    void testDivisiblePor400() {
        assertTrue(Main.esBisiesto(2000), "2000 debe ser bisiesto");
    }

    @Test
    void testNoDivisiblePor4() {
        assertFalse(Main.esBisiesto(2023), "2023 no debe ser bisiesto");
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 6 -----------------
    -------------------------------------------- */

    @Test
    void testJugadaInvalida() {
        assertThrows(IllegalArgumentException.class, () ->
                Main.jugar("PIEDRA", "LAGARTO"));
    }

    @Test
    void testEmpate() {
        assertEquals("EMPATE", Main.jugar("TIJERA", "TIJERA"));
    }

    @Test
    void testGanaJugador1() {
        assertEquals("GANA JUGADOR 1", Main.jugar("PIEDRA", "TIJERA"));
        assertEquals("GANA JUGADOR 1", Main.jugar("TIJERA", "PAPEL"));
        assertEquals("GANA JUGADOR 1", Main.jugar("PAPEL", "PIEDRA"));
    }

    @Test
    void testGanaJugador2() {
        assertEquals("GANA JUGADOR 2", Main.jugar("TIJERA", "PIEDRA"));
    }

    /* -------------------------------------------
    ---------------- EJERCICIO 7 -----------------
    -------------------------------------------- */

    @Test
    void testPasswordVacia() {
        assertEquals(0, Main.evaluarPassword(""),
                "Una cadena vacía debe tener 0 puntos");
    }

    @Test
    void testPasswordDebil() {
        int score = Main.evaluarPassword("pass");
        assertTrue(score >= 0 && score <= 2, "Debe clasificarse como DEBIL");
    }

    @Test
    void testPasswordMedia() {
        int score = Main.evaluarPassword("Abc12345");
        assertTrue(score >= 3 && score <= 4, "Debe clasificarse como MEDIA");
    }

    @Test
    void testPasswordFuerte() {
        assertEquals(5, Main.evaluarPassword("Admin.2026"),
                "Debe obtener la puntuación máxima");
    }
}
