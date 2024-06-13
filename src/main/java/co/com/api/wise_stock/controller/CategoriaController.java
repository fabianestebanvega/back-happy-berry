package co.com.api.wise_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.api.wise_stock.service.CategoriaService;
import co.com.api.wise_stock.util.Response;

@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@GetMapping
	public Response listadoCategorias() {
		return categoriaService.listadoDeCategorias();
	}

}
