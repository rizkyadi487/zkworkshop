package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.MCustomer;
import entity.MCustomerPK;

public interface MCustomerDao extends JpaRepository<MCustomer, MCustomerPK>{

}
