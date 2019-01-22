package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MCustomerDao;
import dto.MCustomerDto;
import entity.MCustomer;
import service.MCustomerSvc;

@Service("mCustomerSvc")
@Transactional
public class MCustomerSvcImpl implements MCustomerSvc{

	@Autowired
	private MCustomerDao dao;
	
	@Override
	public List<MCustomerDto> findAllCustomer() {
		List<MCustomerDto> listdto = new ArrayList<>();
		List<MCustomer> list = dao.findAll();
		for(MCustomer m : list){
			MCustomerDto dto = new MCustomerDto();
			dto.setCustAddress(m.getCustAddress());
			dto.setCustId(m.getCustId());
			dto.setCustName(m.getCustName());
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public void save(MCustomerDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MCustomerDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MCustomerDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MCustomerDto findOneBarang(String kodeCustomer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MCustomerDto> findAllCustomerBySearch(String cari) {
		// TODO Auto-generated method stub
		return null;
	}

}
