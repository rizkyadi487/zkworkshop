package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the t_order_detail database table.
 * 
 */
@Entity
@Table(name="t_order_detail")
@NamedQuery(name="TOrderDetail.findAll", query="SELECT t FROM TOrderDetail t")
public class TOrderDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TOrderDetailPK id;

	@Column(name="prod_price")
	private int prodPrice;

	@Column(name="prod_qty")
	private int prodQty;

	@Column(name="sub_total")
	private int subTotal;

	public TOrderDetail() {
	}

	public TOrderDetailPK getId() {
		return this.id;
	}

	public void setId(TOrderDetailPK id) {
		this.id = id;
	}

	public int getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

	public int getProdQty() {
		return this.prodQty;
	}

	public void setProdQty(int prodQty) {
		this.prodQty = prodQty;
	}

	public int getSubTotal() {
		return this.subTotal;
	}

	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
	}

}