import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sound.sampled.SourceDataLine;
import javax.xml.crypto.dsig.spec.XPathType.Filter;

public class App {

    public static void main(String[] args) {
         List<Pessoa> lista = Arrays.asList(
                new Pessoa(1, "Huguinho", Departamento.FINANCEIRO, 40),
                new Pessoa(4, "Zezinho", Departamento.FINANCEIRO, 32),
                new Pessoa(3, "Luizinho", Departamento.VENDAS, 57),
                new  Pessoa(9, "Patinhas",   Departamento.VENDAS, 40),
                new Pessoa(10, "Donald", Departamento.GERENCIA, 54),
                new Pessoa(2, "Margarida", Departamento.FINANCEIRO, 40),
                new Pessoa(8, "Joe Doe", Departamento.VENDAS, 34),
                new Pessoa(5, "Jane Doe", Departamento.VENDAS, 22),
                new Pessoa(6, "Sr Smith", Departamento.VENDAS, 40),
                new Pessoa(7, "Sra Smith", Departamento.GERENCIA, 39),
                 new Pessoa(11, "Trinity", Departamento.VENDAS, 34),
                 new Pessoa(14, "Morpheus", Departamento.FINANCEIRO, 22),
                 new Pessoa(16, "AgenteSmith", Departamento.VENDAS, 47),
                 new Pessoa(13, "Neo", Departamento.GERENCIA, 29)
        );

        /***
         * Exercício
         *      - escreva as consultas solicitadas utilizando
         *        apenas expressões lambda e operações de agregação
          */
        System.out.println("1. Funcionários do setor de vendas:");

        Stream<Pessoa> vendas = lista.stream().filter(c -> c.getDpto() == Departamento.VENDAS);
        vendas.forEach(p -> System.out.println(p.getNome()));
        
        System.out.println("2. Funcionários do setor de vendas com idade entre 20 e 30 anos");

        Stream<Pessoa> ven2030 = lista.stream().filter(c -> c.getDpto() == Departamento.VENDAS).filter(c -> c.getIdade()>20).filter(c -> c.getIdade()<30);
        ven2030.forEach(p -> System.out.println(p.getNome()));
                                               


        System.out.println("3. Nomes (em maiúsculas) dos funcionários do setor de vendas (usando reduce");

        lista.forEach(p -> System.out.println(p.getNome().toUpperCase()));



        System.out.println("4. Todos os gerentes:");

        Stream<Pessoa> gerentes = lista.stream().filter(g -> g.getDpto() == Departamento.GERENCIA);
        gerentes.forEach(g ->  System.out.println(g.getNome()));



        System.out.println("5. Idade média dos gerentes:");

       

        System.out.println("6. Funcionarios ordenados pelo código:");

        Stream<Pessoa> cod = lista.stream().sorted(Comparator.comparing(Pessoa::getCodigo));
        cod.forEach(System.out::println);

        
        System.out.println("7. Funcionários ordenados pela idade+nome:");

        System.out.println("8. Criar uma nova lista apenas com os funcionarios do financeiro:");
        ArrayList<Pessoa> finan = new ArrayList<>();
    

        Stream<Pessoa> financeiro = lista.stream().filter(f -> f.getDpto()==Departamento.FINANCEIRO);
        financeiro.forEach(f -> finan.add(f));
        for (Pessoa p : finan) {
            System.out.println(p.getNome());
        }

        System.out.println("9. Nome e setor da pessoa mais jovem:");
       
    }
}
