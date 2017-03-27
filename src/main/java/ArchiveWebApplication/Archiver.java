package ArchiveWebApplication;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by 33558 on 14.03.2017.
 */

public interface Archiver extends JpaRepository<Box, Long> {
    @Query("SELECT b FROM Box b")
    List<Box> getAllBoxes();

    @Query("select b FROM Box b WHERE b.id = :id")
    Box getBoxById(@Param("id") long id);
}
