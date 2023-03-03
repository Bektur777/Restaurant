package kg.bektur.Restaurant.repositories;

import kg.bektur.Restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    @Modifying
    @Query("UPDATE Restaurant r SET r.deleted = true WHERE r.id = :id")
    void softDelete(@Param("id") Long id);

}
