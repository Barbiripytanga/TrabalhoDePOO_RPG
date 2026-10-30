
import java.util.Scanner;

// Classe auxiliar para ler o teclado.
// Usa UM único Scanner para o programa inteiro (criar vários Scanner(System.in)
// pode "perder" dados digitados) e não quebra se o usuário digitar letras.
public class Entrada {
    private static Scanner sc = new Scanner(System.in);

    public static int lerInt(){
        while( true ){
            String linha = sc.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch( NumberFormatException e ){
                System.out.print("Digite um número: ");
            }
        }
    }

    public static String lerTexto(){
        String linha = sc.nextLine().trim();
        while( linha.isEmpty() ){
            System.out.print("Não pode ficar vazio. Digite novamente: ");
            linha = sc.nextLine().trim();
        }
        return linha;
    }

    public static void lerLinha(){
        sc.nextLine();
    }
}
 