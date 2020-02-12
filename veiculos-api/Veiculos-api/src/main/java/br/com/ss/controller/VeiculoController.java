package br.com.ss.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.ss.dto.VeiculoDTO;
import br.com.ss.model.Veiculo;
import br.com.ss.repository.VeiculoRepository;
import br.com.ss.service.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoController {

	@Autowired
	private VeiculoService veiculoService;

	@Autowired
	private VeiculoRepository veiculoRepository;

	@Autowired
	public VeiculoController(VeiculoService veiculoService) {
		this.veiculoService = veiculoService;
	}

	@RequestMapping(method = RequestMethod.GET, produces = { org.springframework.http.MediaType.APPLICATION_JSON_VALUE,
			org.springframework.http.MediaType.APPLICATION_XML_VALUE

	})
	public ResponseEntity<List<Veiculo>> listar() {

		return ResponseEntity.status(HttpStatus.OK).body(veiculoService.listar());
	}

	@PostMapping
	public ResponseEntity<Veiculo> salvar(@RequestBody VeiculoDTO veiculoDTO) {
		Veiculo veiculo = veiculoService.salvar(veiculoDTO.toObject());
		return new ResponseEntity<>(veiculo, HttpStatus.CREATED);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Veiculo>> buscarPeloCodigo(@PathVariable Long id) {
		Optional<Veiculo> veiculos = veiculoRepository.findById(id);

		if (veiculos != null)
			return ResponseEntity.ok(veiculos);
		else
			return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		veiculoService.deletar(id);
		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Veiculo veiculo, @PathVariable("id") Long id) {
		veiculo.setId(id);
		veiculoService.atualizar(veiculo);
		return ResponseEntity.noContent().build();

	}

	@PatchMapping("/{id}/vendido")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizarParcial(@PathVariable Long id, RequestBody vendido) {
		veiculoService.atualizarVendido(id, vendido);

	}

	@GetMapping("/listarVeiculos")
	public List<Veiculo> getVeiculo(Long id) {
		return veiculoService.listaVeiculosNaoVendidos(0);

	}

	@GetMapping("/por-marca")
	public List<Veiculo> porMarca(@RequestParam String marca) {
		return veiculoService.listaVeiculosPorMarca(marca);
	}
}
