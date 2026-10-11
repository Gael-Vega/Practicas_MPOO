public class NumerosPrimos {
boolean esPrimo = true;

    public void verificacion(){
        for (int i = 2; i <= 10; i++) {
        esPrimo = true;    
            for (int n = 2; n < i; n++){
                if (i % n !=0) continue;
                if (i % n == 0) {esPrimo = false; break;}
            }
        if (esPrimo == true) System.out.print(i+" ");
        }
    }
}