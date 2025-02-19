public class ContaBancaria extends Conta {
    public ContaBancaria(int n, double s){super(n,s);}

    @Override
    public void depositar(double valor){
        saldo+=valor;
    }

    public boolean sacar(double valor){
        if(valor<=saldo){
            saldo-=valor;
            return true;
        }
        return false;
    }
    
}
