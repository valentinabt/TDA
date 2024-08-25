public class travesiaVital {
/* falta adaptarlo a programacion dinamica,tener una matriz llamada memoria y guardar los resultados parciales ahi */
static int minimaVida(int i ,int j,int[][] tablero) {
   
    return minimaVidaPD(0,0,0,tablero) ;
}

static int minimaVidaPD(int i,int j,int cont,int[][] tablero) {
    
    if(i==tablero.length-1 && j == tablero[0].length-1) {
        if(tablero[i][j]<0) {
            if(cont-Math.abs(tablero[i][j])<1) {
                int nuevo = (Math.abs(tablero[i][j])-cont)+1 ;
                cont = nuevo ;
            }
        }
        return cont;
        
    }
    if(i== tablero.length-1 && j!= tablero[0].length-1) {
        if(tablero[i][j]<0) {
            if(cont-Math.abs(tablero[i][j])<1) {
                int nuevo = (Math.abs(tablero[i][j])+cont)+1 ;
                cont = nuevo ;
            }
        }
        return minimaVidaPD(i, j+1, cont, tablero) ;
     
       
    }
    if(j== tablero[0].length-1 && i!= tablero.length-1) {
        if(tablero[i][j]<0) {
            if(cont-Math.abs(tablero[i][j])<1) {
                int nuevo = (Math.abs(tablero[i][j])+ cont)+1 ;
                cont = nuevo ;
            }
        }
        return minimaVidaPD(i+1, 0, cont, tablero) ;
     
       
    }
    else {

        if(j==0 && i == 0) {
           cont += Math.abs(tablero[i][j]) +1 ;
        }
        else {
            if(tablero[i][j]<0) {
                if(cont-Math.abs(tablero[i][j])<1) {
                    int nuevo =  Math.abs(tablero[i][j]) + cont +  ;
                    cont = nuevo ;
                }
            }

        }
        int abajo = minimaVidaPD(i+1, j,cont,tablero) ;
        int derecha = minimaVidaPD(i,j+1,cont,tablero) ;
        return Math.min(derecha, abajo) ;
        
      
    }
   }

public static void main(String[] args) {
    int[][] tab = {
        {-2,-3,3},
        {-5,-10,1},
        {10,30,-5}
    } ;
    System.out.println(minimaVida(n,m,tab)) ;

}

    
}
