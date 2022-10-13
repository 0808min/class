package ver01;

class Contact {

//	���옣 �젙蹂�
//	�겕 �씠由� �쟾�솕踰덊샇 �씠硫붿씪 二쇱냼 �깮�씪 洹몃９

	
	private String name;
	private String phonenumber;
	private String email;
	private String address;
	private String birthday;
	private String group;

	public Contact(String name, String phoneNumber, String eMail, String address, int birth, String group) {
		this.name = name;
		this.phonenumber = phonenumber;
		this.email = email;
		this.address = address;
		this.birthday = birthday;
		this.group = group;

	}

	Contact() {

	}

//	湲곕뒫
//	�겕 �쐞 �뜲�씠�꽣瑜� 異쒕젰�븯�뒗 湲곕뒫

//	異붽� �슂援� �궗�빆 
//	�겕 蹂��닔�뱾�� 吏곸젒 李몄“瑜� 留됱븘 罹≪뒓�솕 泥섎━瑜� �븯�룄濡� �빐遊낆떆�떎. 
//	蹂��닔�쓽 吏곸젒 李몄“�뒗 �븞�릺吏�留� 蹂��닔�쓽 媛믪쓣 �뼸�쓣 �닔 �엳�뒗 硫붿냼�뱶(getter)��
//	蹂��닔�뿉 媛믪쓣 ���옣�븷 �닔 �엳�뒗 硫붿냼�뱶(setter)瑜� �젙�쓽�빀�땲�떎.
//	�겕 �씤�뒪�꽩�뒪 �깮�꽦怨� �븿猿� �뜲�씠�꽣瑜� 珥덇린�솕 �븷 �닔 �엳�룄濡� �깮�꽦�옄瑜� �젙�쓽�빐遊낆떆�떎.
//	�겕 ���옣�븷 �뜲�씠�꽣瑜� 肄섏넄�뿉�꽌 �궗�슜�옄�쓽 �엯�젰 媛믪쑝濡� �씤�뒪�꽩�뒪瑜� �깮�꽦�빐遊낆떆�떎.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phonenumber;
	}

	public void setPhoneNumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public void tell() {
		System.out.println(" ------data------");
		System.out.println("�씠由� : " + this.name);
		System.out.println("�쟾�솕踰덊샇 : " + this.phonenumber);
		System.out.println("E-mail : " + this.email);
		System.out.println("二쇱냼 : " + this.address);
		System.out.println("�깮�씪 : " + this.birthday);
		System.out.println("洹몃９ : " + this.group);

	}

	@Override
	public String toString() {
		return "Contact [name=" + name + ", phonenumber=" + phonenumber + ", email=" + email + ", address=" + address
				+ ", birthday=" + birthday + ", group=" + group + "]";
	}

}
