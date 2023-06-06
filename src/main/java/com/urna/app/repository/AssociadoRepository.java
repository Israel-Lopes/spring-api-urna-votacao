package com.urna.app.repository;

import com.urna.app.percistence.entity.AssociadoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociadoRepository extends JpaRepository<AssociadoEntity, Long> {
    AssociadoEntity findByCpf(String cpf);
}
