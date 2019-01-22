package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the t_order database table.
 * 
 */
@Entity
@Table(name="t_order")
@IdClass(TOrderPK.class)
@NamedQuery(name="TOrder.findAll", query="SELECT t FROM TOrder t")
public class TOrder implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="order_id")
	private String orderId;

	@Column(name="cust_id")
	private int custId;

	private int total;

	public TOrder() {
	}

	public String getOrderId() {
		return this.orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getTotal() {
		return this.total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

}