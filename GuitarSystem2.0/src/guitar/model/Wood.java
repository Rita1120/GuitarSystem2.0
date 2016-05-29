package guitar.model;
public enum Wood { 

  MAHOGANY, MAPLE,COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA;

  public String toString() {
    switch(this) {
     
      case MAHOGANY:           return "MAHOGANY";
      case MAPLE:              return "MAPLE";
      case COCOBOLO:           return "COCOBOLO";
      case CEDAR:              return "CEDAR";
      case ADIRONDACK:         return "ADIRONDACK";
      case ALDER:              return "ALDER";
      case SITKA:              return "SITKA";
      default:  return "unspecified";
    }
  }
}
