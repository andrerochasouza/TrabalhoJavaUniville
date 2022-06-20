import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        PessoaDAO pessoaDAO = new PessoaDAO();
        
        while (true) {
            System.out.println("-----------------------");
            System.out.println("1 - Adicionar pessoa");
            System.out.println("2 - Listar pessoas");
            System.out.println("3 - Buscar pessoa por ID");
            System.out.println("4 - Excluir pessoa");
            System.out.println("5 - Sair");
            System.out.println("-----------------------");
            
            Pessoa pessoa = new Pessoa();
            
            int opcao = scan.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome da pessoa");
                    String nome = scan.next();
                    System.out.println("Digite o id da pessoa");
                    int id = scan.nextInt();
                    pessoa.setNome(nome);
                    pessoa.setId(id);
                    pessoaDAO.add(pessoa);
                    break;
                case 2:
                    System.out.println("Lista de pessoas");
                    System.out.println("-----------------------");
                    pessoaDAO.getAll().forEach(p -> System.out.println(p.getId() + " - " + p.getNome()));
                    break;
                case 3:
                    System.out.println("Digite o ID da pessoa");
                    id = scan.nextInt();
                    pessoa = pessoaDAO.getById(id);
                    System.out.println("-----------------------");
                    System.out.println(pessoa.getId() + " - " + pessoa.getNome());
                    break;
                case 4:
                    System.out.println("Digite o ID da pessoa");
                    id = scan.nextInt();
                    pessoa = pessoaDAO.getById(id);
                    pessoaDAO.delete(pessoa);
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
