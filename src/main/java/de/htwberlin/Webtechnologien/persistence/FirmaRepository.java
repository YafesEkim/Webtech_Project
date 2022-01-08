package de.htwberlin.Webtechnologien.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FirmaRepository extends JpaRepository<FirmaEntity, Long> {

    List<FirmaEntity> findAllByFirmaName(String firmaName);

}
