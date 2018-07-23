import java.util.ArrayList;
import java.util.Iterator;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

class PedidoContainer {
  private ArrayList<Pedido> pedidos;
  public PedidoContainer() {
    this.pedidos = new ArrayList<Pedido>();
  }
  public Iterator<Pedido> iterator() {
    return pedidos.iterator();
  }
  public void importCSV(String filePath, boolean sobrescrever)
    throws FileNotFoundException, IOException, ParseException{
    FileReader fileReader = new FileReader(filePath);
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    int offset = 0;
    ArrayList<Pedido> importPedidos = new ArrayList<Pedido>();
    String line = "";
    try {
      while ((line = bufferedReader.readLine()) != null) {
        String[] fields = line.split(",");
        if (fields.length != 3) {
          throw new ParseException("Todas as linhas devem possuir 3 colunas",
                                   offset);
        }
        Pedido pedido = new Pedido();
        pedido.setCliente(fields[0]);
        try {
          pedido.setId(Integer.parseInt(fields[1]));
          pedido.setDistanciaMetros(Integer.parseInt(fields[2]));
        } catch (NumberFormatException e) {
          throw new ParseException("Formato inválido. Esperado valor inteiro.",
                                   offset);
        }
        offset += line.length();
        importPedidos.add(pedido);
      }
    } catch (Exception e) {
      throw e;
    } finally {
      fileReader.close();
    }
    if (sobrescrever) {
      this.pedidos = importPedidos;
    } else {
      this.pedidos.addAll(importPedidos);
    }
  }
}
