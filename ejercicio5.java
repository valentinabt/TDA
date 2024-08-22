class ejercicio5 {
//funciona para el upite pero al menos funciona 
static int[] minimo(int[]a,int[]b) {
    if(a[0] > b[0]) {
        return b ;

    }
    if(a[0]<b[0]) {
        return a ;
    }
    else {
        if(a[1]>b[1]) {
            return b ;
        }
        else {
            return a ;
        }
    }
  

}
static int[] cc(int[]conj,int i,int j) {
    if(j<0) {
        int[] res = new int[2] ;
        res[0] = 0 ;
        res[1] = -j ;
        return res ;
    }
    if(j>0 && i == conj.length) {
        int[] res = new int[2] ;
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        return res ;
    }
    /*if(j==0 ) {
        int[] res = new int[2] ;
        res[0] = i ;
        res[1] = 0 ;
        return res ;
    } */


    else {
        int[] usar = cc(conj, i+1, j-conj[i]) ;
        usar[0]++ ;
        int[] noUsar = cc(conj, i+1, j) ;
        return minimo(usar,noUsar) ;
    }

}
public static void main(String[] args) {
    int[] prueba = {2, 3, 5, 15,20} ;
    int[] res = cc(prueba,0,14) ;
    System.out.println(res[0]);
    System.out.println(res[1]);

}
    
}
