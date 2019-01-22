package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.TOrderDetail;
import entity.TOrderDetailPK;

public interface TOrderDetailDao extends JpaRepository<TOrderDetail, TOrderDetailPK>{

}
