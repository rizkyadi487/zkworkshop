import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import service.MCustomerSvc;
import service.TOrderDetailSvc;
import service.TOrderSvc;
import dao.MCustomerDao;
import dao.MProductDao;
import dao.TOrderDao;
import dao.TOrderDetailDao;
import dto.MCustomerDto;
import dto.TOrderDetailDto;
import dto.TOrderDto;
import entity.MCustomer;
import entity.MProduct;
import entity.TOrder;
import entity.TOrderDetail;
import entity.TOrderDetailPK;

public class testing {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"/META-INF/spring/app-config.xml");
		System.out.println("Tes Database");
		TOrderDao mahasiswaDao3 = ctx.getBean(TOrderDao.class);
		TOrderSvc svc = ctx.getBean(TOrderSvc.class);
		MCustomerSvc svc2 = ctx.getBean(MCustomerSvc.class);
		TOrderDetailSvc svc3 = ctx.getBean(TOrderDetailSvc.class);

//		List<TOrder> listReadJurusan = mahasiswaDao3.findAll();
//		System.out.println("======= LIST Jurusan ========");
//		for (TOrder m : listReadJurusan) {
//			System.out.print("|" + m.getCustId() + "\t");
//			System.out.print("|" + m.getOrderId() + "\t");
//			System.out.println("|" + m.getTotal() + "\t");
//		}
		
//		List<TOrderDto> listReadJurusan3 = svc.findAllOrderBySearch("cust 1");
//		System.out.println("======= LIST Jurusan ========");
//		for (TOrderDto m : listReadJurusan3) {
//			System.out.print("|" + m.getCustId() + "\t");
//			System.out.print("|" + m.getCustName()+ "\t");
//			System.out.print("|" + m.getOrderId() + "\t");
//			System.out.println("|" + m.getTotal() + "\t");
//		}
		
//		List<MCustomerDto> listCustomer = new ArrayList<MCustomerDto>();
//		listCustomer = svc2.findAllCustomer();
//		
//		TOrderDetailPK pk = new TOrderDetailPK ();
//		pk.setOrderId("o2");
//		pk.setProdId("P01");
//		List<TOrderDetailDto> listReadJurusan3 = svc3.findAllOrderDetailBySearch(pk);
//		System.out.println("======= LIST Jurusan ========");
//		for (TOrderDetailDto m : listReadJurusan3) {
//			System.out.print("|" + m.getOrderId() + "\t");
//			System.out.print("|" + m.getProdId()+ "\t");
//			System.out.print("|" + m.getProdPrice()+ "\t");
//			System.out.print("|" + m.getProdQty()+ "\t");
//			System.out.println("|" + m.getSubTotal()+ "\t");
//		}
	}
}
