package dio.service;

import dio.entity.Produto;
import dio.exception.ProductNullException;
import dio.exception.ProductPriceException;
import dio.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;

	public Produto save(Produto produto) throws Exception {
		if (produto.getNome() == null || produto.getPreco() == null)
			throw new ProductNullException();
		if (produto.getPreco() < 0)
			throw new ProductPriceException();
		return repository.save(produto);
	}

	public Produto findById(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Produto> findAll() {
		return repository.findAll();
	}
}
