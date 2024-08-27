
import java.util.*;

public class PilaCauta {

/*Boolean pilaValida(int[] pesos,int[] soporte,int i) {
    int sumatoria = 0 ;
    for(int k = i+1 ; k<pesos.length;k++){
        sumatoria += pesos[k] ;
    }
    if(soporte[i]>= sumatoria) {
        return True ;
    }
    return False ;
}
int pilaDeMayorLongitud(ArrayList<ArrayList<Int>> pilasValidas) {
    int maxima = 0 ;
    for(int j = 0; j< pilasValidas.size() ; j++) {
        if(pilasValidas.get(j).size() > maxima) {
            maxima = pilasValidas.get(j).size() ;
        }
    }
    return maxima ;
}
*/
//el problemita es que no uso memoria en nigun momento,es como una funcion recursiva pero no divido en subproblemas ni nada
static int pilaCauta(int[] pesos,int[] soportes) {
    int[] res = new int[pesos.length] ; 
    for(int j = 0; j < res.length ;j++) {
        res[j]= 1 ;
    }
    int[] resp = pilaCautaPaso(pesos, soportes,res,0,0) ;
    int maximo = 0 ;
    for(int j = 0 ; j < resp.length ; j++) {
        if(maximo < resp[j]) {
            maximo = resp[j] ;
        }
    }
    return maximo ;

}

static int[] pilaCautaPaso(int[] pesos,int[] soportes,int[] res,int i,int pesoTotal) {
    if(i== res.length) {
        return res ;
    }
    for(int j = i+1 ; j < pesos.length ; j++) {
        if(soportes[i] > pesoTotal+pesos[j]) {
            pesoTotal += pesos[j] ;
            res[i] += 1 ;

        }
     
       
    }
    pilaCautaPaso(pesos,soportes,res,i+1,0) ;  
    return res;
}


public static void main(String[] args) {
    int[] pesos = {19, 7, 5, 6, 1} ;
    int[] soporte =  {15, 13, 7, 8, 2} ;
    System.out.println(pilaCauta(pesos,soporte)) ;
}



        


    }
        
   
        
   