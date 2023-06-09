package com.nt.service;
import com.nt.bo.CustomerBO;
import com.nt.dao.ICustomerDAO;
import com.nt.dto.CustomerDTO;
public final class CustomerMgmtServiceImpl implements ICustomerMgmtService {
private ICustomerDAO dao;//HAS A PROPERTY
	public CustomerMgmtServiceImpl(ICustomerDAO dao) {
		System.out.println("CustomerMgmtServiceImpl.1 param-constructor");
		this.dao = dao;
	}

	@Override
	public String calculateSimpleIntrest(CustomerDTO dto) throws Exception {
	//Calculate simple intrest amount
		float intrAmt=(dto.getPamt()*dto.getRate()*dto.getTime())/100.0f;
		//create BO class OBJ having persistent data
		CustomerBO bo=new CustomerBO();
		bo.setCustName(dto.getCustName());
		bo.setCustAddrs(dto.getCustAddrs());
		bo.setPamt(dto.getPamt());
		bo.setRate(dto.getRate());
		bo.setTime(dto.getTime());
		bo.setIntrestAmount(intrAmt);
		//use DAO
		int count=dao.insert(bo);
		//Ternary operator
		return count==1?"Customer registered successfully--->SimpleIntrest amount::"+intrAmt:
				"Customer registration failed";
	}

}
