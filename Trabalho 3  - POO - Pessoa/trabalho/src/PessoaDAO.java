import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private List<Pessoa> pessoas = new ArrayList<Pessoa>();

    public Pessoa getById(int id) {
        return pessoas.stream().filter(p -> p.getId() == id).findFirst().get();
    }

    public List<Pessoa> getAll() {
        return pessoas;
    }

    public void add(Pessoa pessoa) {
        try {
            this.pessoas.add(pessoa);
        } catch (Exception e) {
            System.out.println("Não é possivel adicionar pessoa");
        }
    }

    public void delete(Pessoa pessoa) {
        try {
            this.pessoas.remove(pessoa);
        } catch (Exception e) {
            System.out.println("Não é possivel remover pessoa não existente");
        }
    }
}
