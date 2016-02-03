
public class StringBadUse {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("hello");
		//StringBuffer sb = new StringBuffer("hello");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.ensureCapacity(2000);
		sb.append("56gfnlkfdjglfjglfd");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		String sql = "select * from product";
		String productType ="Mobile";
		double price = 9090;
		if(productType!=null){
		sql = sql + " where type="+ productType;
		}
		if(price>0){
			sql= sql + " and price > "+price;
		}

	}

}
