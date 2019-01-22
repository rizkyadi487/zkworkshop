package service;

import java.util.List;

import dto.MCustomerDto;


public interface MCustomerSvc {
	public List<MCustomerDto> findAllCustomer();
	public void save (MCustomerDto dto);
	public void update (MCustomerDto dto);
	public void delete (MCustomerDto dto);
	public MCustomerDto findOneBarang (String kodeCustomer);
	public List<MCustomerDto> findAllCustomerBySearch(String cari);
}
