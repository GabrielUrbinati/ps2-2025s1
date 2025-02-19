
class Main{
    public static void main(String[]args){

        Conta [] contas= {
            new ContaInfinita(1110,50),
            new ContaBancaria(2222,90),
            new ContaBancaria(333,1000)
        };
        for (int i = 0;i<contas.length;i++){
            contas[i].sacar(900);
            System.out.print(contas[i]);
        }
                                                //Conta c= new ContaInfinita(1234,5);//
                                                       //c.sacar(1_000_000);//
                                                       // System.out.println(c);
    }
}