package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.TOrderDao;
import dto.TOrderDto;
import entity.TOrder;
import service.TOrderSvc;

@Service("tOrderSvc")
@Transactional
public class TOrderSvcImpl implements TOrderSvc{

	@Autowired
	private TOrderDao dao;
	
	@Override
	public List<TOrderDto> findAllOrder() {
		// TODO Auto-generated method stub
		List<Object[]> list = dao.findAllDataOrder();
		List<TOrderDto> listdto = new ArrayList<>();
		for(Object[] o : list){
			TOrderDto dto = new TOrderDto();
			TOrder k =(TOrder) o[0];
			String namaCustomer=(String) o[1];
			
			dto.setCustId(k.getCustId());
			dto.setCustName(namaCustomer);
			dto.setOrderId(k.getOrderId());
			dto.setTotal(k.getTotal());
			
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public void save(TOrderDto dto) {
		TOrder order = new TOrder();
		order.setCustId(dto.getCustId());
		order.setOrderId(dto.getOrderId());
		order.setTotal(dto.getTotal());
		dao.save(order);
		
	}

	@Override
	public void update(TOrderDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(TOrderDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TOrderDto findOneBarang(String kodeOrder) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TOrderDto> findAllOrderBySearch(String cari) {
		List<Object[]> list = dao.findDataBySearch(cari);
		List<TOrderDto> listdto = new ArrayList<>();
		for(Object[] o : list){
			TOrderDto dto = new TOrderDto();
			TOrder k =(TOrder) o[0];
			String namaCustomer=(String) o[1];
			
			dto.setCustId(k.getCustId());
			dto.setCustName(namaCustomer);
			dto.setOrderId(k.getOrderId());
			dto.setTotal(k.getTotal());

			listdto.add(dto);
		}
		return listdto;
	}

}
