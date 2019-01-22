package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.TOrder;
import entity.TOrderPK;

public interface TOrderDao extends JpaRepository<TOrder, TOrderPK>{
	@Query("select a, b.custName "
			+ "from TOrder a, MCustomer b "
			+ "where (a.custId = b.custId)")
	public List<Object[]> findAllDataOrder();
	
	@Query("select a, b.custName "
			+ "from TOrder a, MCustomer b "
			+ "where (a.custId = b.custId) and b.custName like %:cari%")
	public List<Object[]> findDataBySearch(@Param("cari") String cari);
}
