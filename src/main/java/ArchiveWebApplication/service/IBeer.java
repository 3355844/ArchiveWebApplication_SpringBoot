package ArchiveWebApplication.service;

import ArchiveWebApplication.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBeer extends JpaRepository<Beer, Long> {

    @Query("SELECT b FROM Beer b")
    List<Beer> getAllBeer();

    @Query("UPDATE Beer b set b.name = :name, b.alcoholPercent = :alcoholPercent where b.id = :id") // delete space from query
    void updateBeer(@Param("name") String name,
                    @Param("alcoholPercent") double alcoholPercent,
                    @Param("id") long id);

    @Query("select b FROM Beer b WHERE b.id = :id")
    Beer getBeerById(@Param("id") long id);
}
