package br.com.DesafioSantander.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import br.com.DesafioSantander.domain.Gastos;

public interface GastosRepository extends JpaRepository<Gastos, Integer>, JpaSpecificationExecutor<Gastos> {}
