public class travesiaVital {
    
static int minimaVida(int i ,int j,int[][] tablero) {
    int[][] memoria = new int[i][j] ;
    if(minimaVidaPD(0, 0,memoria,tablero)>0) {
        return minimaVidaPD(0, 0, memoria, tablero) ;

    } 
    else {
       return 1 ;
    }
}

static int minimaVidaPD(int i,int j,int[][] memoria,int[][] tablero) {
    if(i==memoria.length-1 && j== memoria[0].length-1) {
       memoria[i][j] += tablero[i][j] ;
       return memoria[i][j] ;
    }
    if(i!=memoria.length-1 && j == memoria[0].length-1) {
        memoria[i][j] += tablero[i][j] ;
        return minimaVidaPD(i+1, j, memoria, tablero) ;
    }
    if(i== memoria.length-1 && j!= memoria[0].length-1) {
        memoria[i][j] += tablero[i][j] ;
        return minimaVidaPD(i, j+1, memoria, tablero) ;
    }
    else {
        if(memoria[i][j]!= 0 ) {
            return memoria[i][j] ;
        }

        else {
        int abajo = minimaVidaPD(i+1, j, memoria, tablero) ;
        int derecha = minimaVidaPD(i, j+1, memoria, tablero) ;
        int res = Math.min(derecha, abajo) ;
        memoria[i][j] += res;
        return res ;
    }
   }
}
public static void main(String[] args) {
    int n = 3 ;
    int m = 3 ;
    int[][] tab = {
        {-2,-3,3},
        {-5,-10,1},
        {10,30,-5}
    } ;
    System.out.println(minimaVida(n,m,tab)) ;

}

    
}
