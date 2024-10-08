package com.technexushub.services;

import com.technexushub.dtos.AddItemToCartRequest;
import com.technexushub.dtos.CartDTO;

public interface CartService {
//add items to cart

 //case 1 :cart for user not available : we'll create a cart and then  add the  item
    // case 2:cart is available  add the items to cart
    CartDTO addItemToCart(String userId, AddItemToCartRequest request);
    //remove Item From cart
    void removeItemFromCart(String userId,int cartItem);
    //remove all items from cart
    void clearCart(String userId);
    CartDTO getCartByUser(String userId);
}
