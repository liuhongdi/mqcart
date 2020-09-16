package rocketcart.send.pojo;

import java.util.List;

//购物车消息
public class CartMsg {
    //用户id
    private int userId;
    public int getUserId() {
        return this.userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    //购物车id
    private List<Integer> cartList;
    public List<Integer> getCartList() {
        return this.cartList;
    }
    public void setCartList(List<Integer> cartList) {
        this.cartList = cartList;
    }
}
