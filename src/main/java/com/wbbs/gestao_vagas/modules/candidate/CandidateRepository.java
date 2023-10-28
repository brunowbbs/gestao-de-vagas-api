package com.wbbs.gestao_vagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID> {

  // Comeca com find e coloca o nome dos campos que vai buscar.
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);

  // CandidateEntity findByUsernameAnEmail(String username, String email);
}
