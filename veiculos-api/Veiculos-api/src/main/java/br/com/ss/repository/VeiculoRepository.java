package br.com.ss.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.ss.model.Veiculo;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {

	void save(Optional<Veiculo> veiculoVendido);

	@Query(value = "select * from VEICULO where vendido = FALSE", nativeQuery = true)
	List<Veiculo> veiculosNaoVendidos();

	List<Veiculo> findByMarca(String marca);

	List<Veiculo> findByDataAtualizacaoLessThanEqual(LocalDate dataAtualizacao);

}
