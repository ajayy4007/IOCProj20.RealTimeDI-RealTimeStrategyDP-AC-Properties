package com.nt.test;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.vo.CustomerVO;
public class RealTimeDITest {
	public static void main(String[] args) {
		//Read input from end user as string value
			Scanner s=new Scanner(System.in);
			System.out.println("Enter Customer name::");
			String name=s.nextLine();
			System.out.println("Enter customer addrs::");
			String addrs=s.nextLine();
			System.out.println("Enter customer principal amount::");
			String pAmt=s.nextLine();
			System.out.println("Enter Time (in months)");
			String time=s.nextLine();
			System.out.println("Enter customer Rate of intrest::");
			String rate=s.nextLine();
			CustomerVO vo=new CustomerVO();
			vo.setCustName(name);
			vo.setCustAddrs(addrs);
			vo.setPamt(pAmt);
			vo.setRate(rate);
			vo.setTime(time);
			//create IOC container 
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
			//get controller class OBJ
			MainController controller=ctx.getBean("controller",MainController.class);
			//invoke the methods
			try {
				String result=controller.processCustomer(vo);
				System.out.println(result);
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Internal Problem...Try Again"+e.getMessage());
			}
}
}
