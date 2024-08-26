
import java.util.*;

public class PilaCauta {
    static ArrayList<Integer> maxima(ArrayList<Integer> a , ArrayList<Integer> b) {
        if(a.size()> b.size()) {
            return a ;
        }
        else {
            return b ;
        }
    }
    static ArrayList<Integer> agregar(ArrayList<Integer> a,Integer elem) {
        a.add(elem) ;
        return a ;
    }


   static ArrayList<Integer> pilaCauta(int[] peso,int[] soporte) {
      ArrayList<Integer> res = new ArrayList<>() ;
      return pilaCauta1(0,peso,soporte,res,0) ;
    }
    static ArrayList<Integer> pilaCauta1(int i,int[] peso,int[] soporte,ArrayList<Integer> res,int pesoTotal) {
        if(i==0) {
            
            ArrayList<Integer> poner = pilaCauta1(i+1, peso, soporte,agregar(res,i+1), pesoTotal) ;
           
            ArrayList<Integer>  noPoner = pilaCauta1(i+1,peso,soporte,res,pesoTotal) ;
            return res ;
        }
        if(i== peso.length -1) {
            if(peso[i]>soporte[res.get(res.size()-1)-1] || pesoTotal+peso[i]> soporte[res.get(0)-1]) {
                return res ;
            }
            else {
                
                return agregar(res,i+1) ;
            }
        }
        else {
            if(i!= 1 && peso[res.get(res.size()-1)-1]>soporte[res.get(res.size()-1)-1] || pesoTotal > soporte[res.get(0)-1]) {
                res.remove(res.size()-1) ;
            }

            
            ArrayList<Integer> poner = pilaCauta1(i+1, peso, soporte,agregar(res,i+1), pesoTotal+peso[i]) ;
           
            ArrayList<Integer> Noponer = pilaCauta1(i+1, peso, soporte, res, pesoTotal) ;
           
            return maxima(poner, Noponer) ;
            
        }
        


    }
        
   
        
    public static void main(String[] args) {
        int[] pesos = {19,7,5} ;
        int[] s = {15,13,7} ;
        System.out.println(pilaCauta(pesos,s)) ;

    }
}