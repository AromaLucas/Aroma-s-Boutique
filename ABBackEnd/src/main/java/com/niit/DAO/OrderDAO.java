package com.niit.DAO;

import com.niit.Model.OrderDetail;

public interface OrderDAO {
	public boolean payment(OrderDetail orderDetail);
	public boolean updateCartItemsStatus(String username, int orderId);

}
