package guitar.model;
public class Guitar {

  private String serialNumber;
  private double price;
  GuitarSpec spec;

  public Guitar() {
 
  }

  public String getSerialNumber() {
    return serialNumber;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double newPrice) {
    this.price = newPrice;
  }

  public GuitarSpec getSpec() {
    return spec;
  }

public void setGuitarSpec(GuitarSpec spec) {
	 this.spec = spec;
}

public void setSerialNumber(String serialNumber) {
	this.serialNumber = serialNumber;
}
}
