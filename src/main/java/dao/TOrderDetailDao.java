package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import entity.TOrderDetail;
import entity.TOrderDetailPK;

public interface TOrderDetailDao extends JpaRepository<TOrderDetail, TOrderDetailPK>{
	@Query("select a from TOrderDetail a "
			+ "where a.id = :cari ")
	public List<TOrderDetail> findDataBySearch(@Param("cari")TOrderDetailPK cari);
}
