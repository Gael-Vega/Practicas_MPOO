public class TablaDeMultiplicar{
    int numero;

    public int[] Multiplicar(int numero, int tamTabla){
        int [] tabla = new int[tamTabla];
        for (int i=0; i<tamTabla; i++){
            tabla[i] = numero * (i+1);
        }
        return tabla;
    }
}