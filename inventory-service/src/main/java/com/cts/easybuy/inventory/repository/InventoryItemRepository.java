package com.cts.easybuy.inventory.repository;

import com.substring.easybuy.inventory.domain.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Long> {

	Optional<InventoryItem> findBySku(String sku);

	Optional<InventoryItem> findByProductId(UUID productId);

	boolean existsBySku(String sku);

	boolean existsByProductId(UUID productId);

	List<InventoryItem> findByActiveTrueOrderByProductNameAsc();

	List<InventoryItem> findByAvailableQuantityLessThanEqualAndActiveTrueOrderByAvailableQuantityAsc(int threshold);
}
