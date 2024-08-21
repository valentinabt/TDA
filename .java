/*Práctica 1 de Tecnicas y Diseño de Algoritmos */
import java.util.*;
/*Implementaciones */
class funciones {


/*2) Cuadrados Mágicos */



int[][] crearMatriz(int n) {
    /*Requiere: n != 2 */
    int[][] matriz = new int[n][n];
    return matriz ;
}

int constanteMagica(int n) {

    return ((n*((n^2)+1))/2) ;
}

int sumaFila(int[][] matriz,int i) {
    int[] fila = matriz[i] ;
    int suma = 0 ;
    for (numero in : fila) {
            suma += numero ;

    }
    return suma ;
}
int sumaColumna(int[][] matriz,int j) {
    int suma = 0 ;
    for(int i=0 ;i< matriz.length;i++) {
        suma += matriz[i][j] ;
    }
    return suma;
}

Float sumaDiagonal1(int[][] matriz,int n) { /*por que va float aca??? */
    if(n%2 ==0) {
        return(matriz[0][0]+ matriz[(n/2)-1][(n/2)-1]+ matriz[n][n]) ;
    }
    else {
        return(matriz[0][0]+ matriz[(n/2)][(n/2)]+ matriz[n][n]) ;
    }
}

Float sumaDiagonal2(int[][] matriz,int n) { /*por que va float aca??? */
    if(n%2 ==0) {
        return(matriz[0][n]+ matriz[(n/2)-1][(n/2)-1]+ matriz[n][0]) ;
    }
    else {
        return(matriz[0][n]+ matriz[(n/2)][(n/2)]+ matriz[n][0]) ;
    }
}

int [][] cuadradoMagico(int n) {
    list<integer> sol = new ArrayList<>() ;
    for(integer k = 1 ; k<=n*n ; k++) {
        sol.add(k) ;
    }
    int numero = constanteMagica(n) ;
    return cuadradoRecursivo(n,0,0,sol,numero) ;
    
}
/*Ideas :
 * -Si complete una fila,tengo que preguntarme si la suma es igual a la cte mágica
 * -Si complete una columna,tengo que preguntarme si la suma es igual a la cte mágica
 * -Si no complete una fila y una columna,tngo que preguntarme si la suma supera a la cte mágica,si lo hace,debo hacer backtracking e
 * insertar el antecesor inmediato 
 * -Dberia crear una funcion auxiliar que busque un antecesor inmediato,como se trata de un arreglo no debria ser muy dificil crearla
 * -Al completar cosas de la diagonales,tambien deberia preguntarme si se cumple o no la igualdad con la cte mágica (0,0 con la mitad de la matriz y con n,n)
 * luego,0,n con la mitad y con n,0
 * -el principal problema es de que forma hago backtracking?
 * -Para la recursión,tengo que pensar el caso base,que es aquel que no tiene paso recursivo,y cual seria?
 * Si i=j=n y sumaFila= sumaColumna= cte magica = diagonales return res 
 * 
 */



 int[][] cuadradoRecursivo(int n,int i,int j,list<integer> sol,int numero) {
    int[][] res = new int[n][n] ;
    /*¿deberia poner todo en un ciclo while para que se termine cuando i==j==n+1? */
        if(i==j && j==n && sumaFila(res, i)== sumaColumna(res, j)&& sumaDiagonal1(res, n)== sumaDiagonal2(res, n)&& sumaFila(res, i)== sumaDiagonal1(res, n) && sumaFila(res, i)==numero) {
            /*lo de arriba es horrible y deberia hacer una funcion auxiliar para poner eso */
            return res ; /*deberia poner el ultimo numero  */
        }
        else {
            if(i!= n && j!=n) { /*esto no es asi  */
            res[i][j] = sol[0] ;
                if(sumaFila(res, i) < numero && sumaColumna(res, j) < numero && sumaDiagonal1(res, n) < numero && sumaDiagonal2(res, n)<numero) {
                    sol.remove(res[i][j]) ;
                    cuadradoRecursivo(n, i, j+1, sol, numero) ;
                }
                else {
                    sol.remove(res[i][j]) ;
                    sol.add(res[i][j]) ; /*no se si tiene mucho snetido,pero lo saco y lo pongo al final asi no intento de nuevo con ese */
                    cuadradoRecursivo(n, i, j, sol, numero) ;
                }
            if(j==n && i!= n) {
                /*lo mismo que antes pero considerando que la fila ya la termine */
                res[i][j] = sol[0] ;
                if(sumaFila(res, i) < numero && sumaColumna(res, j) < numero && sumaDiagonal1(res, n) < numero && sumaDiagonal2(res, n)<numero) {
                    sol.remove(res[i][j]) ;
                    cuadradoRecursivo(n, i+1, 0, sol, numero) ;
                }
                else {
                    sol.remove(res[i][j]) ;
                    sol.add(res[i][j]) ; /*no se si tiene mucho snetido,pero lo saco y lo pongo al final asi no intento de nuevo con ese */
                    cuadradoRecursivo(n, i, j, sol, numero) ;
                }
 
            } /*creo que el caso del else es un caso general y lo podria poner fuera de todo if */

        }
    }
 }


}