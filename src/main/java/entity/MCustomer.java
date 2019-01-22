package entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the m_customer database table.
 * 
 */
@Entity
@Table(name="m_customer")
@IdClass(MCustomerPK.class)
@NamedQuery(name="MCustomer.findAll", query="SELECT m FROM MCustomer m")
public class MCustomer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="cust_id")
	private int custId;

	@Column(name="cust_address")
	private String custAddress;

	@Column(name="cust_name")
	private String custName;

	public MCustomer() {
	}

	public int getCustId() {
		return this.custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustAddress() {
		return this.custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public String getCustName() {
		return this.custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

}