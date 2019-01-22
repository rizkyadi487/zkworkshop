package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MCustomerDao;
import dao.MProductDao;
import dto.MCustomerDto;
import dto.MProductDto;
import entity.MCustomer;
import entity.MProduct;
import service.MProductSvc;

@Service("mProductSvc")
@Transactional
public class MProductSvcImpl implements MProductSvc{

	@Autowired
	private MProductDao dao;
	
	@Override
	public List<MProductDto> findAllProduct() {
		List<MProductDto> listdto = new ArrayList<>();
		List<MProduct> list = dao.findAll();
		for(MProduct m : list){
			MProductDto dto = new MProductDto();
			dto.setExpDate(m.getExpDate());
			dto.setProdId(m.getProdId());
			dto.setProdName(m.getProdName());
			dto.setProdPrice(m.getProdPrice());
			listdto.add(dto);
		}
		return listdto;
	}

	@Override
	public void save(MProductDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MProductDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MProductDto dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MProductDto findOneBarang(String kodeProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MProductDto> findAllProductBySearch(String cari) {
		// TODO Auto-generated method stub
		return null;
	}

}
