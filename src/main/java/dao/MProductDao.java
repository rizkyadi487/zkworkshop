package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MProduct;
import entity.MProductPK;

public interface MProductDao extends JpaRepository<MProduct, MProductPK>{

}
