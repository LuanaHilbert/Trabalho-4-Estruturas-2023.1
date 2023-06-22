import java.util.Scanner;

class TestaContato {
    public static void main(String[] args) {
        ListaContatos lista = new ListaContatos();
        Scanner entrada = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n----Agenda de Contatos----");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato");
            System.out.println("4 - Imprimir contatos");
            System.out.println("0 - Sair");
            System.out.print("Digite a opcao desejada: ");
            opcao = entrada.nextInt();
            entrada.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o nome do contato: ");
                    String nome = entrada.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = entrada.nextLine();
                    Contato contato = new Contato(nome, telefone);
                    lista.adicionarContato(contato);
                    break;

                case 2:
                    System.out.print("\nDigite o nome do contato que deseja remover: ");
                    String nomeRemover = entrada.nextLine();
                    lista.removerContato(nomeRemover);
                    break;

                case 3:
                    System.out.print("\nDigite o nome do contato que deseja buscar: ");
                    String nomeBuscar = entrada.nextLine();
                    lista.buscarContato(nomeBuscar);
                    break;

                case 4:
                    System.out.println("\n----Lista de Contatos----");
                    lista.imprimirContatos();
                    break;

                case 0:
                    System.out.println("\nSaindo do programa...");
                    break;

                default:
                    System.out.println("\nOpcao invalida.");
                    break;
            }
        } while (opcao != 0);

        entrada.close();
    }
}