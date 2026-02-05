public abstract class Conta implements OperacoesBancarias {
    private String titular;
    private int numeroDaConta;
    private double saldo;


    public Conta(String titular, int numeroDaConta, double saldo) {
        this.titular = titular;
        this.numeroDaConta = numeroDaConta;
        this.saldo = saldo;
    }

    public String getTitular(){
        return titular;
    }

    public int getNumeroDaConta(){
        return numeroDaConta;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    public void depositar(double valor){
        if(valor > 0) {
            saldo += valor;
        }
    }

    public abstract void sacar(double valor);


    public abstract void exibir();


}
