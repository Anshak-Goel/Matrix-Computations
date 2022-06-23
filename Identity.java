package ap_Assignment3;

import java.util.ArrayList;

public class Identity extends Scalar{
	public Identity(int order, ArrayList<String> types) {
		super(order,types,1);
		this.stored_type = "identity";
	}
	
}
