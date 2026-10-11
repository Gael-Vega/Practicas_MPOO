public class ATM{
float alcancia=0;

    public void Depositos(float cantidadNueva){
        alcancia += cantidadNueva;
    }

    public boolean Retiros(float retiro){
        if (alcancia>0 && retiro>alcancia){
            return false;
        }
        else{
            alcancia -=retiro;
            return true;
        }
    }

    public float ConsultaSal(){
        return alcancia;
    }
}