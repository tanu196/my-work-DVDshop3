package system;

import Item.Dvd;
import customer.Member;

public class Reji {
	//レジが持つ情報
	Dvd[] dvds;
	Member[] members;
	
	
	//レジが持つ機能
	//探す機能はレジが持つ！
	
	public Reji(Dvd[] dvds , Member[] members) {
		this.dvds = dvds;
		this.members = members;
	}
	
	
	//借りる処理
	public Remember rentalIn(String memberId , String dvdId){
		//memberid探してオブジェクト作る
		Member member = findMember(memberId);
		if(member == null) {
			System.out.println("会員番号" + memberId + "は登録されていません");
		}
		
		//dvd探してオブジェクト作る
		Dvd dvd = findDvd(dvdId);
		if(dvd == null) {
			System.out.println("dvd番号" + dvdId + "のDVDはありません");
		}
				
		if(!dvd.isExist()){
			dvd.dvdRental();//貸出中にする
		}else {
			System.out.println("貸出中です");
		}
		
		
		Remember rental = new Remember(member , dvd);//レンタルクラスに会員とdvd情報を記録する
		member.addPoint(dvd.getPrice()/100);//会員のポイント加算
		return rental;//更新
	}
	
	
	//返すっていう処理
	public Remember rentalOut(String memberId , String dvdId) {
		Member member = findMember(memberId);
		if(member == null) {
			System.out.println("会員番号" + memberId + "は登録されていません");
		}
		
		Dvd dvd = findDvd(dvdId);
		if(dvd == null) {
			System.out.println("dvd番号" + dvdId + "のDVDはありません");
		}
		
		
		if(dvd.isExist()) {
			dvd.dvdReturn();//返却できた
		}else {
			System.out.println("返却が完了できていません");
		}
		
		Remember rentalOut = new Remember(member , dvd);//返却したものを記録する
		return rentalOut;//更新
	}
	
	
	//ID探すメソッド
	private Dvd findDvd(String id) {
		for(Dvd dvd : dvds) {
			if(dvd.getDvdId().equals(id)) {
				return dvd;
			}
		}
		return null;
	}
	
	
	private Member findMember(String id) {
		for(Member member : members) {
			if(member.getMemberId().equals(id)) {
				return member;
			}
		}
		return null;
	}
}
