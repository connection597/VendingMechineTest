package vendingmachine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class MachineAct implements VendingMachineAct{
	Scanner sc = new Scanner(System.in);
	ArrayList<VendingMachine>list = new ArrayList<VendingMachine>();
	private int remainMoney= 0;
	
	public void insertCoin() {
		int ch;
		System.out.println("돈을 넣어주세요");
		System.out.println("1.5000원, 2.1000원, 3.500원, 4.100원");
		
		ch = sc.nextInt();
		
		switch(ch) {
		case 1 :
			remainMoney = remainMoney + 5000;
			System.out.println("투입금액 :5000");
			break;
		case 2 :
			remainMoney = remainMoney + 1000;
			System.out.println("투입금액 :1000");
			break;
		case 3 :
			remainMoney = remainMoney + 500;
			System.out.println("투입금액 :500");
			break;
		case 4 :
			remainMoney = remainMoney + 100;
			System.out.println("투입금액 :100");
			break;
		}
		System.out.println("사용가능 금액:" + remainMoney);
	}
	
	public void enterMune() {
		VendingMachine vm = new VendingMachine();
		
		System.out.println("자판기 메뉴등록");
		System.out.println("메뉴이름?");
		
		vm.setDrinkName(sc.next());
		System.out.println("메뉴가격?(숫자만 입력)");
		
		vm.setDrinkPrice(sc.nextInt());
		System.out.println("재고 등록(채울 개수)");
		
		vm.setDrinkStock(sc.nextInt());
		System.out.println("등록완료");	
	}
	
	public void printMenu() {
		System.out.println("메뉴");
		
		VendingMachine vm = new VendingMachine();
		Iterator<VendingMachine>it = list.iterator();
		 
		 vm = it.next();
		 
		 System.out.println("제품명:"+vm.getDrinkName()+"");
		 System.out.println("제품명:"+vm.getDrinkPrice()+"");
		 System.out.println("제품명:"+vm.getDrinkStock()+"");
		 System.out.println();
	}
	
	public void choiceMenu() {
		System.out.print("메뉴선택");
		
		printMenu();
		System.out.println();
		
		String s;
		VendingMachine vm = new VendingMachine();
		Iterator<VendingMachine>it = list.iterator();
		
		System.out.print("원하는 제품명 입력");
	    sc.next();
	    
	    while(it.hasNext()) {
	    	vm = it.next();
	    	if(s.equals(vm.getDrinkName())) {
	    		if(vm.getDrinkStock()==0) {
	    			System.out.println("재고가 업습니다");
	    			break;
	    		}
	    		if(remainMoney -vm.getDrinkPrice()<0) {
	    			System.out.println("잔액이 부족합니다");
	    			break;
	    		}
	    		remainMoney= remainMoney =vm.getDrinkPrice();
	    		vm.setDrinkStock(vm.getDrinkStock()-1);
	    		System.out.println(vm.getDrinkName()+"출력완료, 남은돈"
	    		+remainMoney+"재고"+vm.getDrinkStock());
	    	}
	    }
	}
	
	public void enterStock() {
		System.out.println("재고 충전");
		
		String s;
		int stock;
		VendingMachine vm = new VendingMachine();
		printMenu();
		
		System.out.println();
		System.out.println("충전할 음료명 입력");
		
		s =sc.next();
		Iterator<VendingMachine>it = list.iterator();
		System.out.println("재고 충전할 수량 입력");
		stock = sc.nextInt();
		
		while(it.hasNext());
		vm = it.next();
		if(s.equals(vm.getDrinkName())) {
			vm.setDrinkStock(vm.getDrinkStock()+stock);
			System.out.println(vm.getDrinkName()+"충전완료 재고:"+vm.getDrinkStock());
			break;
		    }		
	    }    
	public void deleteMenu() {
		System.out.println("삭제할 제품명 입력");
		
		String s;
		VendingMachine vm = new VendingMachine();
		printMenu();
		s= sc.next();
		Iterator<VendingMachine>it = list.iterator();
		
		while(it.hasNext()) {
			vm = it.next();
			if(s.equals(vm.getDrinkName())) {
				list.remove(vm);
				System.out.println("삭제 완료");
				break;
			}
		}
	}
     public void updateMenu() {
			System.out.println("수정할 제품명 입력");
			String s;
			VendingMachine vm = new VendingMachine();
			printMenu();
			s= sc.next();
			Iterator<VendingMachine>it = list.iterator();
			if(s.equals(vm.getDrinkName())) {
				System.out.println("수정할 메뉴입력?");
				vm.setDrinkName(sc.next());
				System.out.println("수정할 메뉴가격?(숫자만 입력)");
				vm.setDrinkName(sc.next());
				System.out.println("수정할 재고입력?");
				vm.setDrinkName(sc.next());
				System.out.println("수정완료");
				break;
			}
		}				
	}


