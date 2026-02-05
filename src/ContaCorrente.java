public class ContaCorrente extends Conta {
    static double taxaSaque;


    public ContaCorrente(String titular, int numeroDaConta, double saldo) {
        super(titular, numeroDaConta, saldo);
        this.taxaSaque = 2.50;
    }



    @Override
    public void sacar(double valor) {
        double novoValor;
        if(getSaldo() > 0 && (valor + taxaSaque) <= getSaldo()) {
            novoValor = (getSaldo() - (valor + taxaSaque));
            setSaldo(novoValor);
        }else{
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("Saldo insulficiente!");
            System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n");
        }

    }

    @Override
    public void exibir() {
        System.out.println(">>>>>>>>>Dados da conta<<<<<<<<<");
        System.out.println("--------------------------------------------");
        System.out.println("Titular:\t"+getTitular());
        System.out.println("--------------------------------------------");
        System.out.println("Numero da conta:\t"+getNumeroDaConta());
        System.out.println("--------------------------------------------");
        System.out.println("Saldo disponivel R$:\t"+getSaldo());
        System.out.println("--------------------------------------------");
        System.out.println("Valor da taxa de saque R$: "+taxaSaque);
    }
}
