package br.com.ss.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.ss.exception.VeiculoNaoEncontradoException;
import br.com.ss.model.Veiculo;
import br.com.ss.repository.VeiculoRepository;

@Service
public class VeiculoService {

	private final VeiculoRepository veiculoRepository;

	@Autowired
	public VeiculoService(VeiculoRepository veiculoRepository) {
		this.veiculoRepository = veiculoRepository;
	}

	public Veiculo salvar(Veiculo veiculo) {
		return veiculoRepository.save(veiculo);
	}

	public List<Veiculo> listar() {
		return (List<Veiculo>) veiculoRepository.findAll();
	}

	private Optional<Veiculo> buscarVeiculoExistente(Long id) {
		return buscarVeiculoPeloCodigo(id);
	}

	public void atualizarVendido(Long id, RequestBody vendido) {
		Optional<Veiculo> veiculoVendido = buscarVeiculoPeloCodigo(id);
		veiculoVendido.isPresent();
		veiculoRepository.save(veiculoVendido);

	}

	private Optional<Veiculo> buscarVeiculoPeloCodigo(Long id) {
		Optional<Veiculo> veiculoExistente = veiculoRepository.findById(id);
		if (veiculoExistente == null) {
			throw new IllegalArgumentException();
		}
		return veiculoExistente;
	}

	public void atualizar(Veiculo veiculo) {
		verificarExistencia(veiculo);
		veiculoRepository.save(veiculo);

	}

	private void verificarExistencia(Veiculo veiculo) {
		buscar(veiculo.getId());
	}

	public Optional<Veiculo> buscar(Long id) {
		Optional<Veiculo> veiculo = veiculoRepository.findById(id);

		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException("O veiculo não pode ser encontrado");
		}

		return veiculo;
	}

	public void deletar(Long id) {
		try {
			veiculoRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new VeiculoNaoEncontradoException("O veiculo nao pode ser foi encontrado");
		}

	}

	public List<Veiculo> listaVeiculosNaoVendidos(int i) {
		List<Veiculo> veiculo = veiculoRepository.veiculosNaoVendidos();
		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException("O veiculo não pode ser encontrado");
		}
		return veiculo;
	}

	public List<Veiculo> listaVeiculosPorMarca(String marca) {
		List<Veiculo> veiculo = veiculoRepository.findByMarca(marca);
		if (veiculo == null) {
			throw new VeiculoNaoEncontradoException("O veiculo não pode ser encontrado");
		}
		return veiculo;
	}

}
