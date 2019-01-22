package service;

import java.util.List;

import dto.TOrderDetailDto;


public interface TOrderDetailSvc {
	public List<TOrderDetailDto> findAllOrderDetail();
	public void save (TOrderDetailDto dto);
	public void update (TOrderDetailDto dto);
	public void delete (TOrderDetailDto dto);
	public TOrderDetailDto findOneBarang (String kodeOrderDetail);
	public List<TOrderDetailDto> findAllOrderDetailBySearch(String cari);
}
