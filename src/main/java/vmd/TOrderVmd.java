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

import dto.TOrderDto;
import service.TOrderSvc;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class TOrderVmd {
	
	@WireVariable
	TOrderSvc tOrderSvc; //sama dengan service implement
	
	List<TOrderDto> dtos = new ArrayList<TOrderDto>();
	private String cari;
	TOrderDto tOrderDto = new TOrderDto();
	Session session = Sessions.getCurrent();
	
	@Init
	public void load(){
		dtos = tOrderSvc.findAllOrder();
	}
	
	@NotifyChange("dtos")
	@Command
	public void search(){
		
		dtos = tOrderSvc.findAllOrderBySearch(cari);
		List<TOrderDto> list = tOrderSvc.findAllOrderBySearch(cari);
		
		if (list.size()>0) {
			dtos= list;
		}else{
			Messagebox.show("DATA GA ADA !!");
		}
	}
	
	@NotifyChange("customerDto")
	@Command
	public void delete(){
		if (tOrderDto.getOrderId() == null) {
			Messagebox.show("silahkan pilih data");
		}
		else{
			Messagebox.show("apakah anda yakin ?","perhatikan", 
					new Button [] {Button.YES,Button.NO},
					Messagebox.QUESTION, Button.NO,
					new EventListener<Messagebox.ClickEvent>(){
				public void onEvent(ClickEvent event){
					if (Messagebox.ON_YES.equals(event.getName())) {
						tOrderSvc.delete(tOrderDto);
						dtos.remove(tOrderDto);
						BindUtils.postNotifyChange(null, null, TOrderVmd.this, "dtos");
						Messagebox.show("data berhasil di delete!!!!");
						
					}
				}
			});
		}
	}
	
	@Command
	public void add(){
		session.removeAttribute("editDto");
		Executions.sendRedirect("AddTOrder.zul");
	}
	
	@NotifyChange("customerDto")
	@Command
	public void edit(){
		if (tOrderDto.getOrderId()!=null) {
			session.setAttribute("editDto", tOrderDto);
			Executions.sendRedirect("AddTOrder.zul");
		}else{
			Messagebox.show("PILIH DATA DULU !!!");
		}
	}

	public List<TOrderDto> getDtos() {
		return dtos;
	}

	public void setDtos(List<TOrderDto> dtos) {
		this.dtos = dtos;
	}

	public String getCari() {
		return cari;
	}

	public void setCari(String cari) {
		this.cari = cari;
	}

	public TOrderDto gettOrderDto() {
		return tOrderDto;
	}

	public void settOrderDto(TOrderDto tOrderDto) {
		this.tOrderDto = tOrderDto;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}
	
	




	
	
}
