import java.util.ArrayList;

class funciones {
    
/*Práctica 1 de Técnicas y Diseño de Algoritmos */

/*2) */
private static boolean termine = false ;
public static int constanteMagica(int n) {
    return ((n*n*n+n)/2) ;
}

public static int sumaFila(int[][] m,int i,int n) {
    int suma = 0 ;
    for(int j = 0 ; j < n ; j++) {
        suma += m[i][j] ;
    }
    return suma ;
}
public static int sumaColumna(int[][] m,int j,int n) {
    int suma = 0 ;
    for(int i = 0 ; i < n ; i++) {
        suma += m[i][j] ;
    }
    return suma ;
}
public static int sumaDiagonal1(int[][]m,int n) {
    int suma = 0 ;
    for(int i = 0; i <n ; i++) {
      for(int j= 0; j<n ; j++) {
        if(i==j) {
            suma += m[i][j] ;
        }
      }
      
        
    } 
    return suma;
}



public static int sumaDiagonal2(int[][]m,int n) {
    int suma = 0 ;
    for(int i = 0; i <n ; i++) {
        suma += m[i][n-i-1] ;
    } 
    return suma;
}
public static boolean cuadradoValido(int[][]m , int n,int i,int j) {
    if(j==n-1 && i ==n-1) {
        //recorro todas las columnas,filas y dioganles y me pregunto si es igual a la constate magica
        for(int k = 0;k<n ; k++) {
            for(int l = 0 ; l<n ;l++) {
                if(sumaFila(m,k,n)!=constanteMagica(n)||sumaColumna(m, l, n)!=constanteMagica(n)||sumaDiagonal1(m, n)!=constanteMagica(n)||sumaDiagonal2(m,n)!=constanteMagica(n)) {
                    return false ;
                }
    }
}
    }
    else {
        //recorro todo y me pregunto si es menor o igual a la constante magica
        for(int k = 0;k<n ; k++) {
            for(int l = 0 ; l<n ;l++) {
                if(sumaFila(m,k,n)>constanteMagica(n)||sumaColumna(m, l, n)>constanteMagica(n)||sumaDiagonal1(m, n)>constanteMagica(n)||sumaDiagonal2(m,n)>constanteMagica(n)) {
                    return false ;
                }
            }
        }
    } return true ;
}

public static int[][] cuadradoMagico(int n) {
    int[][] matriz = new int[n][n] ;
   /*  boolean[] valores = new boolean[n*n] ;
    for(int k = 0 ; k <n*n ; k++) {
        valores[k] = false ; la peor idea del mundo
    } */
    ArrayList<Integer> valores = new ArrayList<>();

    return cuadradoMagicoBK(matriz,valores,n,0,0) ;
}
 private static int[][] cuadradoMagicoBK(int[][]m,ArrayList<Integer> valores,int n,int i,int j) {
    if (termine) {
        return m;
    }
    

   while(termine == false ) {
    if(i!= n-1 && j == n-1) { //termino la fila y sigo (o no)
        for(int k = 1 ; k<=n*n ; k++) {
            if(!valores.contains(k)) {
                valores.add(k) ;
                m[i][j] = k;
                if(sumaFila(m, i, n)==constanteMagica(n)) {
                    cuadradoMagicoBK(m, valores, n, i+1, 0);
                }
                cuadradoMagicoBK(m, valores, n, i, j);
                valores.remove(k) ;

            }
        }

    }
    if(i==n-1 && j!=n-1) {
        for(int k = 1 ; k<=n*n ; k++) {
            if(!valores.contains(k)) {
                valores.add(k) ;
                m[i][j] = k;
                if(sumaColumna(m, j, n)==constanteMagica(n)) {
                    cuadradoMagicoBK(m, valores, n, i, j+1);
                }
                cuadradoMagicoBK(m, valores, n, i, j);
                valores.remove(k) ;

            }
        }
    }
   if(i==n-1 && j == n-1) { 
    for(int k = 1 ; k<=n*n ; k++) {
        if(!valores.contains(k)) {
            valores.add(k) ;
            m[i][j] = k;
            if(cuadradoValido(m, n, i, j)) {
                termine = true ;
            }
            cuadradoMagicoBK(m, valores, n, i, j-1);
            valores.remove(k) ;

        }
    }
   }
   else {
    for(int k = 1 ; k<=n*n ; k++) {
        if(!valores.contains(k)) {
            valores.add(k) ;
            m[i][j] = k ;
            if(cuadradoValido(m, n, i, j)) {
                cuadradoMagicoBK(m, valores, n, i, j+1);
            }
            cuadradoMagicoBK(m, valores, n, i, j);
            valores.remove(k) ;

        }
    }
   }}
   return m ;
 }
 public static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
        for (int value : row) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}

 public static void main(String[] args) {
    
    int l = 3 ;
    int [][] a =cuadradoMagico(l) ;
    printMatrix(a);
 }
      

}
