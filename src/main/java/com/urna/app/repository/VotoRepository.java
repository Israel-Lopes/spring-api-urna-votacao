package com.urna.app.repository;

import com.urna.app.percistence.entity.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotoRepository extends JpaRepository<VotoEntity, Long> {
}
