package guitar.service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import guitar.model.Guitar;
import guitar.model.GuitarSpec;

public class Inventory {
  private List guitars;

  public void setGuitar(List guitars) {
		this.guitars = guitars;
	}
  public void addGuitar(Guitar guitar) {
	  if(guitar.getSpec()!=null){
              guitars.add(guitar);}
  }

  public List getGuitar() {
        return guitars;
 
  }

  public List search(Guitar guitar1) {     //参数
    List matchingGuitars = new ArrayList();
    for (Iterator i = guitars.iterator(); i.hasNext(); ) {
      Guitar guitar2 = (Guitar)i.next();      //数据库
      if (guitar2.getSpec().matches(guitar1.getSpec()))
        matchingGuitars.add(guitar2);
    }
    return matchingGuitars;
  }
}
