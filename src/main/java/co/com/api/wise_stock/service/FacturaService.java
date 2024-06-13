package co.com.api.wise_stock.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.api.wise_stock.entity.Cliente;
import co.com.api.wise_stock.entity.Factura;
import co.com.api.wise_stock.entity.FacturaProducto;
import co.com.api.wise_stock.entity.Producto;
import co.com.api.wise_stock.entity.TipoFactura;
import co.com.api.wise_stock.repository.ProductoRepository;
import co.com.api.wise_stock.repository.ClienteRepository;
import co.com.api.wise_stock.repository.FacturaProductoRepository;
import co.com.api.wise_stock.repository.FacturaRepository;
import co.com.api.wise_stock.repository.TipoFacturaRepository;
import co.com.api.wise_stock.util.Response;

@Service
public class FacturaService {
	
	@Autowired
	FacturaRepository facturaRepository;
	
	@Autowired
	FacturaProductoRepository facturaProductoRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ProductoRepository articuloRepository;
	@Autowired
	TipoFacturaRepository tipoFacturaRepository;
	
	public Response listadoFacturas() {
		return Response.crear(true, "Listado de facturas", facturaRepository.findAll());
	}
	
	public Response saveFacturaVenta(Factura factura) {
		
		try {
			Date fecha=new Date();
			//Tipo factura venta id 1
			Optional<TipoFactura>tipo=tipoFacturaRepository.findById(1);
			factura.setTipoFactura(tipo.get());
			factura.setFechaRegistro(fecha);
			Double total=factura.getPrecioTotal();
			factura.setPrecioBase(total*0.81);
			factura.setIva(total*0.19);
			Optional<Cliente>clienteCurrent=clienteRepository.findByDocumento(factura.getCliente().getDocumento());
			if(clienteCurrent.isPresent()) {
				factura.setCliente(clienteCurrent.get());
			}else {
				factura.setCliente(clienteRepository.save(factura.getCliente()));
			}
			Factura facturaCurren=facturaRepository.save(factura);
			List<FacturaProducto>listadoProducto=new ArrayList<>();
			for (FacturaProducto facturaProducto : factura.getProductos()) {
				
				Producto articulo=articuloRepository.findById(facturaProducto.getProducto().getId()).get();
				Integer stock=articulo.getCantidad();
				Integer cantidad=facturaProducto.getCantidad();
				if(stock>=cantidad) {
					facturaProducto.setFacturaId(facturaCurren.getId());
					facturaProducto.setFechaRegistro(fecha);
					listadoProducto.add(facturaProducto);
					
					//articulo.setStock(stock-cantidad);
					articuloRepository.save(articulo);
					
				}
				
			}
			facturaProductoRepository.saveAll(listadoProducto);
			Factura facturaReturn=facturaRepository.findById(facturaCurren.getId()).get();
			return Response.crear(true, "Factura registrada",facturaReturn );
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return Response.crear(false, "Error registrando factura", e);
		}
		
		
	}

}
