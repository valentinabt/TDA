import java.util.*;

public class Main {
    static ArrayList<Integer> maxima(ArrayList<Integer> a , ArrayList<Integer> b) {
        if(a.size()> b.size()) {
            return a ;
        }
        else {
            return b ;
        }
    }


   static ArrayList<Integer> pilaCauta(int[] peso,int[] soporte) {
      ArrayList<Integer> res = new ArrayList<>() ;
      return pilaCauta1(0,peso,soporte,res,0) ;
    }
    static ArrayList<Integer> pilaCauta1(int i,int[] peso,int[] soporte,ArrayList<Integer> res,int pesoTotal) {
        if(i==0) {
            res.add(i+1) ;
            ArrayList<Integer> poner = pilaCauta1(i+1, peso, soporte, res, pesoTotal) ;
            res.remove(res.size()-1) ;
            ArrayList<Integer>  noPoner = pilaCauta1(i+1,peso,soporte,res,pesoTotal) ;
            return res ;
        }
        if(i== peso.length -1) {
            if(peso[i]>soporte[res.get(res.size()-1)-1] || pesoTotal+peso[i]> soporte[res.get(0)-1]) {
                return res ;
            }
            else {
                res.add(i+1) ;
                return res ; 
            }
        }
        else {
            if(i!= 1 && peso[res.get(res.size()-1)-1]>soporte[res.get(res.size()-1)-1] || pesoTotal > soporte[res.get(0)-1]) {
                //res.remove(res.size()-1) ;
            }

            
            ArrayList<Integer> poner = pilaCauta1(i+1, peso, soporte, res, pesoTotal+peso[i]) ;
            res.add(i+1) ;
            ArrayList<Integer> Noponer = pilaCauta1(i+1, peso, soporte, res, pesoTotal) ;
            //res.remove(res.size()-1) ;
            return maxima(poner, Noponer) ;
            
        }
        


    }
        
   
        
    public static void main(String[] args) {
        int[] pesos = {19,7,5} ;
        int[] s = {15,13,7} ;
        System.out.println(pilaCauta(pesos,s)) ;

    }
}
