package com.wbbs.gestao_vagas.modules.candidate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wbbs.gestao_vagas.modules.candidate.CandidateEntity;
import com.wbbs.gestao_vagas.modules.candidate.useCases.CreateCandidateUsecase;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CreateCandidateUsecase createCandidateUsecase;

  @PostMapping()
  public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {

    try {
      var result = this.createCandidateUsecase.execute(candidateEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }

  }

}
