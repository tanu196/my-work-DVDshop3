package system;

import Item.Dvd;
import customer.Member;

public class Main {
	public static void main(String[] args) {
		Dvd[] inventry = {
				new Dvd("君の名は" ,300 , "A0001")
		};
		
		Member[] member = {
				new Member("0001", "ishimaru")
		};
		
		Reji reji = new Reji(inventry, member);
		
		RentalShopApp r =  new RentalShopApp(reji);
		r.start();
	}
}




/*どんなDVDショップにしたいかに関して
 *
 * まずレジ起動して商品を入れる
 * 次はdvd一本の貸し出しのものを書いていく
 * 
 * 
 * 
 * 
 * 
 * 選択式
 * １：貸出 できた
 * ２：返却 できた
 * ３：在庫一覧　一旦全部作ってから
 * ４：売上確認　一旦全部作ってから
 * ０：終了
 * 
 * 
 * 8/27  会話型まで完成させる
 * 
 * 返却の時の具体的な処理
 * 借りたものbooleanをfalseに変更する
 * 延滞料金発生するかを判断して計算してお金を出す
 * ↑これは後から実装する
 * 
 * 
 * 
 * 
 * 
 */