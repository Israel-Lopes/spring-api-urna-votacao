package com.urna.app.repository;

import com.urna.app.percistence.entity.FormularioDeVotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormularioDeVotoRepository extends JpaRepository<FormularioDeVotoEntity, Long> {
}
