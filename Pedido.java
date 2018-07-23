class Pedido {
  private final static double EMISSAO_POR_KM = 0.113;
  private int id;
  private String cliente;
  private int distanciaKm;

  public int getId() {
    return this.id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getCliente() {
    return this.cliente;
  }
  public void setCliente(String cliente) {
    this.cliente = cliente;
  }
  public int getDistanciaMetros() {
    return this.distanciaKm;
  }
  public void setDistanciaMetros(int distanciaKm) {
    this.distanciaKm = distanciaKm;
  }

  public double getCo2Economizado() {
    return this.distanciaKm * Pedido.EMISSAO_POR_KM / 1000;
  }
  public String resumo() {
    return "Cliente: " + this.getCliente() + ". Pedido: " + this.getId() +
           ". Distância percorrida: " + this.getDistanciaMetros() +
           " m. CO economizado: " + this.getCo2Economizado() + " kg.";
  }
}
