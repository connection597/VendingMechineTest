package vendingmachine;

import java.util.Scanner;

public class MachineApp {

	public static void main(String[] args) {
		VendingMachine vm = new VendingMachine();
		Scanner sc = new Scanner(System.in);
		int ch;
		
		while(true) {
			do {
				System.out.println("1.동전투입 2.잔돈반환 3.메뉴선택 4. 관리자메뉴 5. 종료");
				ch=sc.nextInt();
				}while(ch<1||ch>5);
			if(ch==5)
				break;
			switch(ch) {
			case 1:
				vm.insertCoin();
				break;
			case 2:
				vm.returnCoin();
				break;
			case 3:
				vm.choiceMenu();
				break;
			case 4:
				while(true) {
					do {
						System.out.println("1.메뉴등로 2.메뉴삭제 3.메뉴수정 4.재고 등록 5.이전");
						ch = sc.nextInt();			
					}while(ch<1 || ch>5);
					if(ch ==5)
						break;
					switch(ch){
						case 1 :
							vm.enterMenu();
							break;
						case 2 :
							vm.deletMenu();
							break;
						case 3 :
							vm.updateMenu();
							break;
						case 4 :
							vm.enterStock();
							break;
					}
				}
				break;
			}
		}
	}
}
