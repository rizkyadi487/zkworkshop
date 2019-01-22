package service;

import java.util.List;

import dto.TOrderDto;

public interface TOrderSvc {
	public List<TOrderDto> findAllOrder();
	public void save (TOrderDto dto);
	public void update (TOrderDto dto);
	public void delete (TOrderDto dto);
	public TOrderDto findOneBarang (String kodeOrder);
	public List<TOrderDto> findAllOrderBySearch(String cari);
}
