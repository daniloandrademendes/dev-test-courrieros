import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;

public class Main {
  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usar: java " + Main.class.getName() +
        " CAMINHO_DO_ARQUIVO");
      return;
    }
    final String filePath = args[0];
    PedidoContainer pedidos = new PedidoContainer();
    try {
      pedidos.importCSV(filePath, true);
    } catch(FileNotFoundException e) {
      System.out.println("Falha em abrir o arquivo " + filePath);
    } catch(IOException e) {
      System.out.println("Falha lendo o arquivo " + filePath);
    } catch(ParseException e) {
      System.out.println("Falha analisando o arquivo " + filePath + ":\n" +
                         e + ". offset: " + e.getErrorOffset());
    }
    Iterator<Pedido> pedidoInterator = pedidos.iterator();
    while (pedidoInterator.hasNext()) {
      System.out.println(pedidoInterator.next().resumo());
    }
  }
}
