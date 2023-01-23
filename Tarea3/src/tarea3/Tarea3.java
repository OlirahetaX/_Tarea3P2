package tarea3;

import java.util.Scanner;
/* SOLUCION
        CAJA 1: u,u,u,u,u,u,u,l,l,l,d,d,d,d,g,u,u,u,u,r,r,d,d,d,d,d,d,d,d,l,s
        CAJA 2: u,u,u,u,u,u,u,l,l,l,l,d,d,d,d,g,u,u,u,u,r,r,r,d,d,d,d,d,d,d,d,l,s
        CAJA 3: u,u,u,u,u,u,u,l,l,l,l,l,d,d,d,d,g,u,u,u,u,r,r,r,r,d,d,d,d,d,d,d,d,l,s
        TODAS LAS CAJAS: u,u,u,u,u,u,u,l,l,l,l,l,d,d,d,d,g,r,g,r,g,u,u,u,u,r,r,d,d,d,d,d,d,d,d,l,s
*/

public class Tarea3 {

    public static int filR = 7;
    public static int colR = 7;
    public static int k = 0;
    public static String cad[];
    public static String R="[R]";

    public static void main(String[] args) {
        try{
        System.out.print("Ingrese Movimientos Separados por comas :");
        Scanner rm = new Scanner(System.in);
        String cadena = rm.nextLine();

        cad = cadena.split(",");
        

        String matriz[][] = new String[10][10];
         
        matriz[4][4] = "[C]";
        matriz[4][3] = "[C]";
        matriz[4][2] = "[C]";
       
        if (cad.length!=0) {
            valoresMatriz(matriz);
        }
        }catch(Exception e){System.out.println("FUERA DEL LIMITE");}
    }

    public static void imprimirMatriz(String matriz[][], int filas, int cols) {

        if (filas == matriz.length - 1 && cols == matriz[0].length - 1) {
            System.out.println(matriz[filas][cols]);
            System.out.println("");
            if (k < cad.length) {
                valoresMatriz(matriz);
            }

        } else {
            if (cols == matriz[0].length - 1) {
                System.out.println(matriz[filas][cols]);
                imprimirMatriz(matriz, filas + 1, 0);
            } else {
                System.out.print(matriz[filas][cols]);
                imprimirMatriz(matriz, filas, cols + 1);
            }
        }
        
    }

    public static void valoresMatriz(String matriz[][]) {
        //matriz[filR][colR] = "[R]";
        System.out.println("["+filR+"]"+"["+colR+"]");
        for (String[] matriz1 : matriz) {
            for (int j = 0; j < matriz1.length; j++) {
                if (!"[C]".equals(matriz1[j])) {
                    matriz1[j] = "[ ]";
                }    
            }
        }
        matriz[1][1] = "[X]";
        matriz[2][1] = "[X]";
        matriz[3][1] = "[X]";
        matriz[4][1] = "[X]";
        matriz[5][1] = "[X]";
        matriz[1][5] = "[X]";
        matriz[2][5] = "[X]";
        matriz[3][5] = "[X]";
        matriz[4][5] = "[X]";
        matriz[5][5] = "[X]";
        matriz[5][2] = "[X]";
        matriz[5][3] = "[X]";
        matriz[5][4] = "[X]";
        matriz[8][5] = "[O]";
        matriz[filR][colR] = R;
        
        switch (cad[k]) {
            case "U","u" -> filR -= 1;
            case "D","d" -> filR += 1;
            case "L","l" -> colR -= 1;
            case "R","r" -> colR += 1;
            case "g","G" -> {
                if (matriz[4][4].equals(R) || matriz[4][3].equals(R) || matriz[4][2].equals(R)) {
                    
                    if (null==R) {
                        R = "[RC]";
                    }else R = switch (R) {
                        case "[RC]" -> "[RC2]";
                        case "[RC2]" -> "[RC3]";
                        default -> "[RC]";
                    };
                    
                }else {
                    System.out.println("CAJA NO DISPONIBLE");
                    System.exit(0);
                    
                }
            }
            case "S","s" -> {
                if (matriz[8][5].equals(R)) {
                    System.out.println("BIEN HECHO CAJA ENTREGADA");
                    matriz[8][5] = "[O]";
                    R="[R]";
                    filR=7;
                    colR=7;
                }else{
                    System.out.println("EL OBJETIVO NO ES EN ESTE LUGAR :(");
                    System.exit(0);
                }
            }
            default -> {
            }
        }
        //imprimirMatriz(matriz, 0,0);
        k += 1;
        if (matriz[1][1] !="[R]"&& matriz[2][1]!="[R]" && matriz[3][1]!="[R]" && matriz[4][1] !="[R]"&& matriz[5][1]!="[R]" && matriz[1][5]!="[R]" && matriz[2][5]!="[R]" && matriz[3][5]!="[R]" && matriz[4][5]!="[R]" && matriz[5][5]!="[R]" &&  matriz[5][2]!="[R]" && matriz[5][2]!="[R]" && matriz[5][2]!="[R]") {
            imprimirMatriz(matriz, 0, 0);
        }else{
            System.out.println("MOVIMIENTO NO VALIDO");
        }
        

    }
}
