package com.technexushub.repositories;

import com.technexushub.entities.Cart;
import com.technexushub.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,String> {
    Optional<Cart> findByUser(User user);
//    Cart findByUser(User user);
}
