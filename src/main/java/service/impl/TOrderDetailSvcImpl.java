package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.MProductDao;
import dao.TOrderDetailDao;
import dto.TOrderDetailDto;
import entity.MProduct;
import entity.TOrder;
import entity.TOrderDetail;
import entity.TOrderDetailPK;
import service.TOrderDetailSvc;

@Service("tOrderDetailSvc")
@Transactional
public class TOrderDetailSvcImpl implements TOrderDetailSvc {

	@Autowired
	private TOrderDetailDao dao;

	@Autowired
	private MProductDao daoProduk;

	@Override
	public List<TOrderDetailDto> findAllOrderDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(TOrderDetailDto dto) {
		TOrderDetail order = new TOrderDetail();
		TOrderDetailPK orderPK = new TOrderDetailPK();
		orderPK.setOrderId(dto.getOrderId());
		orderPK.setProdId(dto.getProdId());
		order.setId(orderPK);
		order.setProdPrice(dto.getProdPrice());
		order.setProdQty(dto.getProdQty());
		order.setSubTotal(dto.getSubTotal());
		dao.save(order);
	}

	@Override
	public void update(TOrderDetailDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(TOrderDetailDto dto) {
		// TODO Auto-generated method stub

	}

	@Override
	public TOrderDetailDto findOneBarang(String kodeOrderDetail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TOrderDetailDto> findAllOrderDetailBySearch(String cari) {
		TOrderDetailPK pk = new TOrderDetailPK();
		pk.setOrderId(cari);
		List<MProduct> listbarang = daoProduk.findAll();
		List<TOrderDetailDto> listdto = new ArrayList<>();
		for (MProduct barang : listbarang) {
			pk.setProdId(barang.getProdId());
			List<TOrderDetail> list = dao.findDataBySearch(pk);
			for (TOrderDetail custo : list) {
				TOrderDetailDto dto = new TOrderDetailDto();
				dto.setOrderId(custo.getId().getOrderId());
				dto.setProdId(custo.getId().getProdId());
				dto.setProdPrice(custo.getProdPrice());
				dto.setProdQty(custo.getProdQty());
				dto.setSubTotal(custo.getSubTotal());
				listdto.add(dto);
			}
		}
		

		return listdto;
	}

}
