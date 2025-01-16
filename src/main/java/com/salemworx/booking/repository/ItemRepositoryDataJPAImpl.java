package com.salemworx.booking.repository;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.salemworx.booking.domain.Status;
import com.salemworx.booking.domain.Item;

@Repository
public interface ItemRepositoryDataJPAImpl extends JpaRepository<Item, Long> {

	@Query("select i.status from item i where i.itemId = :itemId")
	Optional<String> findStatusByItemId(@Param("itemId") Long itemId);

	@Query("select i.lockedUntil from item i where i.itemId = :itemId")
	String findLockedUtilByItemId(@Param("itemId") Long itemId);

	@Modifying
	@Query("update item i set i.status = :status, i.lockedUntil= :lockedUntil where i.itemId = :itemId")
	int markItemAsLocked(@Param("itemId") Long itemId, @Param("status") Status status,
			@Param("lockedUntil") LocalDateTime lockedUntil);
	
	@Modifying
	@Query("update item i set i.status = null, i.lockedUntil = null where i.lockedUntil < Now()")
	int releaseStaleLocks();

}
