package de.htwberlin.Webtechnologien.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RechnungsRepository extends JpaRepository<RechnungEntity, Long> {
}