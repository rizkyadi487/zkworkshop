package entity;

import java.io.Serializable;

public class MCustomerPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int custId;

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}
}
