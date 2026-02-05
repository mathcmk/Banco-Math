//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    int opcao;
    int opcaoConta;
    int finalizar;

    ContaCorrente cc;
    ContaPoupanca cp;
    Banco bancoMath = new Banco();
    Scanner sc = new Scanner(System.in);

    //Nome do banco

    do {
        System.out.println("\t\t~ BANCO MATH ~\n\n");

        //Interface
        System.out.println("Escoha uma opção:\n" +
                "[1] - Criar conta\n" +
                "[2] - Listar contas\n" +
                "[3] - Depositar\n" +
                "[4] - Sacar\n" +
                "[5] - transferir\n" +
                "[6] - extrato\n"+
                "[7] - Sair\n");
        opcao = sc.nextInt();
        sc.nextLine();


        switch (opcao) {
            case 1:
                System.out.println("Digite nome titular: ");
                String nome = sc.nextLine();

                System.out.println("Digite o numero da conta");
                int numConta = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o saldo: ");
                double saldo = sc.nextDouble();

                System.out.println("Qual o tipo da conta:\n" +
                        "[1] - Corrente\n" +
                        "[2] - Poupança\n");
                opcaoConta = sc.nextInt();
                sc.nextLine();
                switch (opcaoConta) {
                    case 1:
                        cc = new ContaCorrente(nome, numConta, saldo);
                        bancoMath.addConta(cc);
                        System.out.println("Conta criada com sucesso!!");
                        break;

                    case 2:
                        cp = new ContaPoupanca(nome, numConta, saldo);
                        bancoMath.addConta(cp);
                        System.out.println("Conta criada com sucesso!!");
                        break;
                    default:
                        System.out.println("Opção Invalida!!");
                        break;
                }
                break;

            case 2:
                bancoMath.listarContas();
                break;

            case 3:
                System.out.println("Digite o numero da conta que deseja depositar: ");
                int numeroC = sc.nextInt();
                sc.nextLine();
                Conta c = bancoMath.buscarContaPorNumero(numeroC);

                System.out.println("Digite o valor a ser depositado: ");
                double valor = sc.nextDouble();
                sc.nextLine();

                if (c != null) {
                    c.depositar(valor);
                } else {
                    System.out.println("Conta não existe");
                }
                bancoMath.buscarContaPorNome(c.getTitular());
                break;

            case 4:
                System.out.println("Digite o numero da conta que deseja sacar: ");
                int numeroCo = sc.nextInt();
                sc.nextLine();
                Conta co = bancoMath.buscarContaPorNumero(numeroCo);

                System.out.println("Digite o valor a ser sacado: ");
                double valorS = sc.nextDouble();
                sc.nextLine();

                if (co != null) {
                    co.sacar(valorS);
                } else {
                    System.out.println("Conta não existe");
                }
                bancoMath.buscarContaPorNome(co.getTitular());
                break;

            case 5:
                System.out.println("Digite o numero da sua conta: ");
                int minhaConta = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o numero da conta destino: ");
                int contaDestino = sc.nextInt();
                sc.nextLine();

                System.out.println("Digite o valor a ser transferido: ");
                double valorTrans = sc.nextDouble();
                sc.nextLine();

                bancoMath.transferir(minhaConta, contaDestino, valorTrans);
                break;

            case 6:
                System.out.println("Digite o numero da conta: ");
                int numC = sc.nextInt();
                sc.nextLine();
                bancoMath.extrato(numC);
                break;

            case 7:
                System.out.println("Saindo...");
                break;

            default:
                System.out.println("Opção invalida!!");
                break;

        }

        System.out.println("Deseja fazer outra operação\n" +
                "[1] - SIM\n" +
                "[2] - NÃO\n");
        finalizar = sc.nextInt();
        sc.nextLine();
    }while (finalizar == 1);

    System.out.println("O banco Math agradece sua preferência");





}
