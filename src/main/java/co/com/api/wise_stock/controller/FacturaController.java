package co.com.api.wise_stock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.api.wise_stock.entity.Factura;
import co.com.api.wise_stock.service.FacturaService;
import co.com.api.wise_stock.util.Response;

@RestController
@RequestMapping("/factura")
@CrossOrigin
public class FacturaController {
	
	@Autowired
	FacturaService facturaService;
	
	
	@GetMapping
	public Response listadoFacturas() {
		return facturaService.listadoFacturas();
	}
	
	@PostMapping("/save")
	public Response saveFactura(@RequestBody Factura factura) {
		return facturaService.saveFacturaVenta(factura);
	}

}
