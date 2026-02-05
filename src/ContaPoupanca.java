public class ContaPoupanca extends Conta {
    private double taxaRendimento;
    private double valorRendimento;

    public ContaPoupanca(String titular, int numeroDaConta, double saldo) {
        super(titular, numeroDaConta, saldo);
        taxaRendimento = 0.010;
    }

    @Override
    public void depositar(double valor) {
        if(valor > 0) {
            double novoSaldo = getSaldo() + valor;
            valorRendimento = valor * taxaRendimento;
            setSaldo(novoSaldo + valorRendimento);
        }

    }

    @Override
    public void sacar(double valor) {
        if (getSaldo() > 0 && valor  <= getSaldo()) {
            double novoValor = getSaldo() - valor;
            setSaldo(novoValor);
        }else{
            System.out.println("Saldo insulficiente");
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
            System.out.println("Rendimentos R$: "+valorRendimento);
    }
}
