package system;
import java.util.Scanner;

import Item.Dvd;

public class RentalShopApp {
	private final Scanner sc = new Scanner(System.in);
	private final Reji reji;
	
	public RentalShopApp(Reji reji) {
		this.reji = reji;
	}
	
	
	public void start() {
		System.out.println("ーーーレンタルDVDショップシステムーーー");
		
		while(true) {
			showMenu();
			String choice = sc.nextLine();
			
			if(choice.equals("0")) {
				//終了へ
				System.out.println("終了します");
				break;
			}else if(choice.equals("1")) {
				//貸出へ
				rentalFlow();
			}else if(choice.equals("2")) {
				//返却へ
				returnFlow();
			}else if(choice.equals("3")) {
				//在庫一覧へ
				showInventory();
			}else {
				System.out.println("0～3の番号で入力してください");
			}
		}
	}
	
	
	private void rentalFlow() {
		System.out.print("会員番号");
		String memberId = sc.nextLine();
		System.out.print("DVDの管理番号");
		String dvdId = sc.nextLine();
		
		if(memberId.isEmpty() || dvdId.isEmpty()) {
			System.out.println("番号が入力されていません");
			return;
		}
		
		try {
			Remember rental = reji.rentalIn(memberId, dvdId);
			System.out.println(rental.getMember().getName() + "さんへ" + rental.getDvd().getTitle() + "を貸出しました。料金"
					 + rental.getDvd().getPrice() + "円");
		}catch(IllegalStateException e) {
			System.out.println("貸出できません" + e.getMessage());
		}
		
	}
	
	
	private void returnFlow() {
		System.out.print("返却する会員番号");
		String memberId = sc.nextLine();
		
		System.out.print("返却するDVDの管理番号");
		String dvdId = sc.nextLine();
		if(dvdId.isEmpty() || memberId.isEmpty()) {
			System.out.println("番号が入力されていません");
			return;
		}
		
		try {
			Remember rentalOut = reji.rentalOut(memberId ,dvdId);
		}catch(IllegalStateException e) {
			System.out.println("返却できません" + e.getMessage());
		}
	}
	
	//在庫一覧
	private void showInventory() {
		System.out.println("----在庫一覧----");
		
		for(Dvd dvd : reji.dvds) {
			if(dvd.isExist()) {
				String status = "在庫あり";
			}
			String status = "貸出中";
			System.out.println(dvd.getDvdId() + " " + dvd.getTitle() + " " + dvd.getPrice() + "円　現在" + status);
		}
	}
	
	private void showMenu() {
		System.out.println();
		System.out.println("1:貸出 2:返却 3:在庫一覧 0:終了");
		System.out.print("入力：");
	}
}
