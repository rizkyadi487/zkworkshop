package entity;

import java.io.Serializable;

public class MProductPK implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String prodId;

	public String getProdId() {
		return prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
}
