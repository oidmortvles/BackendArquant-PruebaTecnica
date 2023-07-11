package arquant.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import arquant.backend.lector.Lector;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
		
		Lector lector = new Lector();
		
		lector.registrarProductos();
		lector.registrarStock();
		lector.registrarTalla();
		lector.cargarStock();
		lector.completarStock();
		lector.filtroSpecial();
		lector.filtroCasoComun();
		lector.ordenar();
		lector.mostrar();
		}
	}
