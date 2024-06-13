package co.com.api.wise_stock.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.api.wise_stock.repository.CategoriaRepository;
import co.com.api.wise_stock.util.Response;
@Service
public class CategoriaService {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	public Response listadoDeCategorias() {
		return Response.crear(true, "Lista de categorias", categoriaRepository.findAll());
	}

}
