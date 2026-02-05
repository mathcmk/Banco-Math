import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {
    private List<Conta> contas = new ArrayList<>();


    public void addConta(Conta c){
        contas.add(c);
    }

    public void listarContas(){
        System.out.println("\t--- Contas no Sistema ---");
        System.out.println("Titular               N° Conta");
        contas.stream()
                .map(p -> p.getTitular() +" - \t\t"+p.getNumeroDaConta())
                .forEach(System.out::println);
    }

    public void buscarContaPorNome(String nome){
         contas.stream()
                .filter(p -> p.getTitular().equalsIgnoreCase(nome))
                .findFirst()
                .ifPresentOrElse(
                        Conta::exibir,
                        () -> System.out.println("Não encntrado")
                );
    }

    public Conta buscarContaPorNumero(int numero){
        Conta contaRetornar = null;
        Iterator<Conta> iterator = contas.iterator();

       while(iterator.hasNext()){
           Conta c = iterator.next();
           if(c.getNumeroDaConta() == numero){
               contaRetornar = c;
           }
       }
       return contaRetornar;
    }

    public void removerConta(int numeroConta) {
        boolean sucesso = false;
        Iterator<Conta> iterator = contas.iterator();
        //Percorrer
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getNumeroDaConta() == numeroConta) {
                iterator.remove();
                sucesso = true;
                System.out.println("Conta -" + numeroConta + "- removida com sucesso");
            }
        }
        if (sucesso == false) {
            System.out.println("Conta -" + numeroConta + "- não encontrada");
        }
    }

    public void transferir(int origem, int destino, double valor) {
        Iterator<Conta> iterator = contas.iterator();
        Conta c1 = null;
        Conta c2 = null;
        //Percorrer
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c.getNumeroDaConta() == origem) {
                c1 = c;
            }
            if(c.getNumeroDaConta() == destino){
                c2 = c;
            }
        }

        if(c1 == null || c2 == null){
            System.out.println("Conta não encontrada");
            return;
        }


        double valorAtual = c1.getSaldo();

       if(c1.getSaldo() > 0 && valor <= c1.getSaldo()){
           c1.sacar(valor);
       }

       if (c1.getSaldo() < valorAtual){
           c2.depositar(valor);
           System.out.println("Transferencia efetuada com sucesso!");
       }
    }


    public void extrato(int num) {
        for (Conta contaN : contas) {

            if (contaN.getNumeroDaConta() == num) {
                System.out.println("\nEXTRATO");
                System.out.println("---------------------------------------");
                System.out.println("Titular: " + contaN.getTitular());
                System.out.println("---------------------------------------");
                System.out.println("Numero da conta: " + contaN.getNumeroDaConta());
                System.out.println("---------------------------------------");
                System.out.println("Saldo: R$" + contaN.getSaldo());
                System.out.println("---------------------------------------");
            } else {
                System.out.println("Conta não encontrada!");
            }

        }
    }

    public void salvarEmArquivo(){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("Contas.txt"))){

            for (Conta c : contas){
                String tipo = "";

                if(c instanceof ContaCorrente){
                    tipo = "CORRENTE";
                } else if (c instanceof ContaPoupanca) {
                    tipo = "POUPANCA";
                }

                bw.write(
                        tipo+";"+
                                c.getTitular()+";"+
                                c.getNumeroDaConta()+";"+
                                c.getSaldo()
                );
                bw.newLine();
            }
            System.out.println("Conta salva com sucesso!");

        } catch (IOException e) {
            System.out.println("Erro ao salvar arquivo!");
        }
    }




}
