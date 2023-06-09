package com.urna.app.repository;

import com.urna.app.percistence.entity.SessaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotacaoRepository extends JpaRepository<SessaoEntity, Long> {
}
