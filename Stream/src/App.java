import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        // Lista de inteiros para gerar uma stream
        List<Integer> list = Arrays.asList(1, 8, 4, 2, 9);

        // Mapeamento de cada elemento da lista para o valor multiplicado por 10
        Stream<Integer> stream = list.stream().map(x -> x * 10);
        System.out.println("Lista multiplicada por 10: " + Arrays.toString(stream.toArray()));

        // Criação de uma stream com valores individuais usando Stream.of()
        Stream<String> stream2 = Stream.of("Fabiola", "Antonio", "Victor");
        System.out.println("Stream de nomes: " + Arrays.toString(stream2.toArray()));

        // Criação de uma stream infinita com iteração (números pares)
        Stream<Integer> stream3 = Stream.iterate(0, x -> x + 2);
        System.out.println("Primeiros 10 números pares: " + Arrays.toString(stream3.limit(10).toArray()));

        // Criação de uma stream para gerar uma sequência de Fibonacci
        Stream<Long> stream4 = Stream.iterate(new Long[] { 0L, 1L }, p -> new Long[] { p[1], p[0] + p[1] })
                .map(p -> p[0]);
        System.out
                .println("Sequência Fibonacci (primeiros 10 valores): " + Arrays.toString(stream4.limit(10).toArray()));

        // Cálculo da soma de todos os elementos da lista usando reduce
        int sum = list.stream().reduce(0, Integer::sum);
        System.out.println("Soma dos valores da lista: " + sum);

        // Filtragem de números pares de uma nova lista e multiplicação de cada um por
        // 10
        List<Integer> novaLista = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> novaStream = novaLista.stream()
                .filter(x -> x % 2 == 0) // Filtra apenas os números pares
                .map(x -> x * 10) // Multiplica cada número par por 10
                .collect(Collectors.toList());
        System.out.println("Números pares multiplicados por 10: " + Arrays.toString(novaStream.toArray()));
    }
}
