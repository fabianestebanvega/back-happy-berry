package co.com.api.wise_stock.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import co.com.api.wise_stock.entity.Producto;
import co.com.api.wise_stock.repository.ProductoRepository;
import co.com.api.wise_stock.repository.ProveedorRepository;
import co.com.api.wise_stock.util.AWSS3Service;
import co.com.api.wise_stock.util.Response;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository articuloRepository;

	@Autowired
	ProveedorRepository proveedorRepository;

	@Autowired
	AWSS3Service awss3Service;
	private static final String rutaArticulo = "/happy-berry/producto/";
	
	
	public Response listadoArticulos() {
		return Response.crear(true, "Listado articulos", articuloRepository.findAll());
	}

	public Response saveArticulo(Producto articulo, MultipartFile file) {
		try {

			if (file != null) {
				String urlImagen = awss3Service.createFolderFile(rutaArticulo, file);
				articulo.setImagen(urlImagen);

			}
			//articulo.setCategoria(articulo.getCategoria().toUpperCase());
			articulo.setFechaResgistro(new Date());

			return Response.crear(true, "Articulo registrado", articuloRepository.save(articulo));
		} catch (Exception e) {
			return Response.crear(false, "error registrado articulo", e);
			// TODO: handle exception
		}

	}
	
	public Response updateArticulo(Producto articulo,MultipartFile file) {
		try {
			Optional<Producto>articuloCurrent=articuloRepository.findById(articulo.getId());
			if(articuloCurrent.isEmpty()) {
				return Response.crear(false, "error articulo no esta registrado", null);
				
			}
			
			Producto articuloReturn=articuloCurrent.get();
			
			
			articuloReturn.setCategoria(articulo.getCategoria());
			//articuloReturn.setNombre(articulo.getNombre());
			articuloReturn.setMarca(articulo.getMarca());
			//articuloReturn.setPrecio(articulo.getPrecio());
			//articuloReturn.setStock(articulo.getStock());
			//articuloReturn.setCantidadMinima(articulo.getCantidadMinima());
			articuloReturn.setEstado(articulo.getEstado());
			if(file!=null) {
				String url=awss3Service.createFolderFile(rutaArticulo, file);
				articuloReturn.setImagen(url);
			}
			
			
			
			
			return Response.crear(true, "Articulo registrado", articuloRepository.save(articuloReturn));
		} catch (Exception e) {
			// TODO: handle exception
			return Response.crear(false, "error actualizando articulo", e);
		}
	}

}
