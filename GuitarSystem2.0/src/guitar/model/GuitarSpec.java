package guitar.model;
public class GuitarSpec {
 
  private Builder builder; 
  private String model;
  private Type type;
  private Wood backWood;
  private Wood topWood;

  public GuitarSpec() {
 
  }

  public void setBuilder(Builder builder) {
		this.builder = builder;
	}
  
  public Builder getBuilder() {
    return builder;
  }
  
  public void setModel(String model) {
	  this.model = model;
	}
  
  public String getModel() {
    return model;
  }

  public Type getType() {
    return type;
  }

  public Wood getBackWood() {
    return backWood;
  }

  public Wood getTopWood() {
    return topWood;
  }
  public void setTopWood(Wood topwood) {
		 this.topWood = topwood;
		
	}

	public void setBackWood(Wood backwood) {
		 this.backWood = backwood;
		
	}

	public void setType(Type type) {
		this.type=type;
	}
	
	
	
  public boolean matches(GuitarSpec spec) {
	  if(spec.getType()!=null && !spec.getType().equals(type)){
			return false;
		}
		if(spec.getBuilder()!=null && !spec.getBuilder().equals(builder)){
			return false;
		}
		if(spec.getModel()!=null && !spec.getModel().equals(model)){
			return false;
		}

		if(spec.getTopWood()!=null && !spec.getTopWood().equals(topWood)){
			return false;
		}
		if(spec.getBackWood()!=null && !spec.getBackWood().equals(backWood)){
			return false;
		}
		return true;
  }






}
