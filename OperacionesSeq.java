import java.util.*;
public class OperacionesSeq {
    //voy a tomar a v como un arreglo pq me da mucha paja usar un arrayList
    // el resultado va a ser una lista 
    //list<String> expresion(list<String> a,list<String> b,list<String> c,int w,int[]v) {
        //int evaluacionA = 
    //}

    list<String> operacionesSeq(int[] v,int w) {
        String[][] memoria = new String[v.length][3] ;
        list<String> res = new ArrayList<String>() ;
        return operacionesSeqPD(v, w,0,acumulador,res) ;
    }
    list<String> operacionesSeqPD(int[] v ,int w,int i,int acumulador,List<String> res) {
        
        if(i== v.length-1) {
            if(acumulador == v) {
                memoria[i] = res ;
            }
            return res ;
            //else o retornar alguna lista vacia o algo asi
        }
        else {
            list<String> suma = operacionesSeqPD(v, w, i+1, acumulador+v[i],res.add("+")) ;
            list<String> multiplicar = operacionesSeqPD(v, w, i+1, acumulador*v[i],res.add("*")) ;
            list<String> potenciar = operacionesSeqPD(v, w, i+1, acumulador+v[i],res.add("$")) ;
            return res ;
        }
    }
    
}
