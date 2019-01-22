package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the t_order_detail database table.
 * 
 */
@Embeddable
public class TOrderDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="order_id")
	private String orderId;

	@Column(name="prod_id")
	private String prodId;

	public TOrderDetailPK() {
	}
	public String getOrderId() {
		return this.orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProdId() {
		return this.prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TOrderDetailPK)) {
			return false;
		}
		TOrderDetailPK castOther = (TOrderDetailPK)other;
		return 
			this.orderId.equals(castOther.orderId)
			&& this.prodId.equals(castOther.prodId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.orderId.hashCode();
		hash = hash * prime + this.prodId.hashCode();
		
		return hash;
	}
}