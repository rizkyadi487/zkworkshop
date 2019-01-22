package vmd;

import java.util.ArrayList;
import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Session;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;

import service.MCustomerSvc;
import service.MProductSvc;
import service.TOrderDetailSvc;
import service.TOrderSvc;
import dto.MCustomerDto;
import dto.MProductDto;
import dto.TOrderDetailDto;
import dto.TOrderDto;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TOrderNewVmd {
	
	List<TOrderDto> customers = new ArrayList<TOrderDto>();
	List<MProductDto> products = new ArrayList<MProductDto>();

	public MCustomerDto getCustomerDto() {
		return customerDto;
	}

	public void setCustomerDto(MCustomerDto customerDto) {
		this.customerDto = customerDto;
	}

	public TOrderDto getDto() {
		return dto;
	}

	public void setDto(TOrderDto dto) {
		this.dto = dto;
	}

	public List<TOrderDto> getCustomers() {
		return customers;
	}

	public void setCustomers(List<TOrderDto> customers) {
		this.customers = customers;
	}

	public Boolean getStatusModal() {
		return statusModal;
	}

	public void setStatusModal(Boolean statusModal) {
		this.statusModal = statusModal;
	}

	public List<MProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<MProductDto> products) {
		this.products = products;
	}

	public TOrderDetailDto getDetail() {
		return detail;
	}

	public void setDetail(TOrderDetailDto detail) {
		this.detail = detail;
	}

	public List<TOrderDto> getDetails() {
		return details;
	}

	public void setDetails(List<TOrderDto> details) {
		this.details = details;
	}

	public List<MCustomerDto> getListCustomer() {
		return listCustomer;
	}

	public void setListCustomer(List<MCustomerDto> listCustomer) {
		this.listCustomer = listCustomer;
	}

	public String getRead() {
		return read;
	}

	public void setRead(String read) {
		this.read = read;
	}

	public List<MProductDto> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<MProductDto> listProduct) {
		this.listProduct = listProduct;
	}

	public MProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(MProductDto productDto) {
		this.productDto = productDto;
	}

	// //========================= INI DIA ==========================
	@WireVariable
	TOrderDetailSvc tOrderDetailSvc;

	@WireVariable
	TOrderSvc tOrderSvc;

	@WireVariable
	MCustomerSvc mCustomerSvc;

	@WireVariable
	MProductSvc mProductSvc;

	// /============================== OBJECT ===========================
	
	List<TOrderDto> details = new ArrayList<TOrderDto>();
	List<MCustomerDto> listCustomer = new ArrayList<MCustomerDto>();
	List<MProductDto> listProduct = new ArrayList<MProductDto>();
	Session session = Sessions.getCurrent();

	private TOrderDto dto = new TOrderDto();
	private TOrderDetailDto detail = new TOrderDetailDto();
	private MCustomerDto customerDto = new MCustomerDto();
	private MProductDto productDto = new MProductDto();

	String read;
	Boolean statusModal;

	// //====================== COMMAND ===============================
	@Init
	public void load() {
		if (session.getAttribute("editDto") != null) {
			dto=(TOrderDto) session.getAttribute("editDto");
			listCustomer = mCustomerSvc.findAllCustomer();
			listProduct = mProductSvc.findAllProduct();
			read="true";
			for (MCustomerDto m : listCustomer) {
				if (m.getCustId() == dto.getCustId()) {
					customerDto.setCustName(m.getCustName());
				}
			}
		} else {
			listCustomer = mCustomerSvc.findAllCustomer();
			listProduct = mProductSvc.findAllProduct();
			read="false";
		}
		statusModal = false;

	}

	@NotifyChange("statusModal")
	@Command
	public void showModal() {
		statusModal = !statusModal;
	}

	@Command
	public void back() {
		Executions.sendRedirect("TOrder.zul");
	}
	
	@NotifyChange("statusModal")
	@Command
	public void saveDetailBarang() {
		detail.setOrderId(dto.getOrderId());
		detail.setProdId("P01");
		detail.setProdPrice(123);
		detail.setProdQty(12);
		detail.setSubTotal(123321);
		tOrderDetailSvc.save(detail);
		showModal();
		//Executions.sendRedirect("TOrder.zul");
	}
	
	@Command
	public void delete(){
		if (detail.getOrderId() == null) {
			Messagebox.show("silahkan pilih data");
		}
		else{
			Messagebox.show("apakah anda yakin ?","perhatikan", 
					new Button [] {Button.YES,Button.NO},
					Messagebox.QUESTION, Button.NO,
					new EventListener<Messagebox.ClickEvent>(){
				public void onEvent(ClickEvent event){
					if (Messagebox.ON_YES.equals(event.getName())) {
						tOrderDetailSvc.delete(detail);
						BindUtils.postNotifyChange(null, null, TOrderNewVmd.this, "dtos");
						Messagebox.show("data berhasil di delete!!!!");
						
					}
				}
			});
		}
	}

	@Command
	public void save() {
		dto.setCustId(1);
		dto.setCustName("askjdfh");
		dto.setOrderId("asdf");
		dto.setTotal(123);
		tOrderSvc.save(dto);
		Executions.sendRedirect("TOrder.zul");
	}

}
