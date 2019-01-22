package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the m_product database table.
 * 
 */
@Entity
@Table(name="m_product")
@IdClass(MProductPK.class)
@NamedQuery(name="MProduct.findAll", query="SELECT m FROM MProduct m")
public class MProduct implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="prod_id")
	private String prodId;

	@Column(name="exp_date")
	private Date expDate;

	@Column(name="prod_name")
	private String prodName;

	@Column(name="prod_price")
	private int prodPrice;

	public MProduct() {
	}

	public String getProdId() {
		return this.prodId;
	}

	public void setProdId(String prodId) {
		this.prodId = prodId;
	}

	public Date getExpDate() {
		return this.expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getProdName() {
		return this.prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return this.prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}

}