package entity;

public class Order extends MyTrolley{
	private String order_id;
	private float sum_price;
	private String status;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public float getSum_price() {
		return sum_price;
	}

	public void setSum_price(float sum_price) {
		this.sum_price = sum_price;
	}

}
