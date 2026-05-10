package com.cts.easybuy.products.repositories;

import com.cts.easybuy.products.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {

    @Query("SELECT c FROM Category c JOIN c.products p WHERE p.id = :productId")
    List<Category> findByProductId(@Param("productId") UUID productId);
}
