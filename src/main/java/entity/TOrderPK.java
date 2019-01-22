package entity;

import java.io.Serializable;

public class TOrderPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
}
