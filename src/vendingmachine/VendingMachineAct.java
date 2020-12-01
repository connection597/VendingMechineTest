package vendingmachine;

public abstract class VendingMachineAct {
	public abstract void insertCoin() ; //동전투입
	public abstract void returnCoin();  //잔돈 반환
	public abstract void enterMenu();   //메뉴등록
	public abstract void deleteMenu();   //메뉴삭제
	public abstract void updateMenu();  //메뉴수정
	public abstract void enterStock();  //재고등록
	public abstract void printMenu();   //메뉴보기
	public abstract void choiceMenu();  //메뉴 선택
	
}
