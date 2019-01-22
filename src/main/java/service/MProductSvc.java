package service;

import java.util.List;

import dto.MProductDto;

public interface MProductSvc {
	public List<MProductDto> findAllProduct();
	public void save (MProductDto dto);
	public void update (MProductDto dto);
	public void delete (MProductDto dto);
	public MProductDto findOneBarang (String kodeProduct);
	public List<MProductDto> findAllProductBySearch(String cari);
}
