package com.urna.app.repository;

import com.urna.app.percistence.entity.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SessaoRepository extends JpaRepository<SessaoEntity, Long> {
}
