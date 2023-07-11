package arquant.backend.lector;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import arquant.backend.entity.Habilitado;
import arquant.backend.entity.Producto;
import arquant.backend.entity.Stock;
import arquant.backend.entity.Talla;
import arquant.backend.utilidades.Comparadores;

public class Lector {
	ArrayList <Producto> productos = new ArrayList<>();
	ArrayList <Talla> tallas = new ArrayList<>();
	ArrayList <Stock> stocks = new ArrayList<>();
	
	ArrayList <Habilitado> listado = new ArrayList<>();
	Set<Integer> productosMostrables = new LinkedHashSet<>();
	
	//cargo cada registro en un arrayList
	public void registrarProductos() {
		
		try (CSVReader reader = new CSVReader(new FileReader("archivocsv/product.csv"))) {
		    String[] nextLine;
		    while ((nextLine = reader.readNext()) != null) {
		       int campo1;
		       int campo2;
		    	
		    	for (String value : nextLine) {
		    		String[] valor1 = nextLine[0].replaceAll("\\s", "").split(",");
		    		String[] valor2 = nextLine[1].replaceAll("\\s", "").split(",");
		    		
		    		campo1= Integer.parseInt(valor1[0]);
		    		campo2= Integer.parseInt(valor2[0]);
		    		Producto prod = new Producto(campo1,campo2);
		    		productos.add(prod);
		            break;
		        }
		    	
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void registrarStock() {
		
		try (CSVReader reader = new CSVReader(new FileReader("archivocsv/stock.csv"))) {
		    String[] nextLine;
		    while ((nextLine = reader.readNext()) != null) {
		       int campo1;
		       int campo2;
		    	
		    	for (String value : nextLine) {
		    		String[] valor1 = nextLine[0].replaceAll("\\s", "").split(",");
		    		String[] valor2 = nextLine[1].replaceAll("\\s", "").split(",");
		    		
		    		campo1= Integer.parseInt(valor1[0]);
		    		campo2= Integer.parseInt(valor2[0]);
		    		Stock inventario = new Stock(campo1,campo2);
		    		stocks.add(inventario);
		            break;
		        }
		    	
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	public void registrarTalla() {
		
		try (CSVReader reader = new CSVReader(new FileReader("archivocsv/size-1.csv"))) {
		    String[] nextLine;
		    while ((nextLine = reader.readNext()) != null) {
		       int campo1;
		       int campo2;
		       boolean campo3;
		       boolean campo4;
		       
		    	for (String value : nextLine) {
		    		String[] valor1 = nextLine[0].replaceAll("\\s", "").split(",");
		    		String[] valor2 = nextLine[1].replaceAll("\\s", "").split(",");
		    		String[] valor3 = nextLine[2].replaceAll("\\s", "").split(",");
		    		String[] valor4 = nextLine[3].replaceAll("\\s", "").split(",");
		    		
		    		campo1= Integer.parseInt(valor1[0]);
		    		campo2= Integer.parseInt(valor2[0]);
		    		campo3= Boolean.parseBoolean(valor3[0]);
		    		campo4=	Boolean.parseBoolean(valor4[0]);
		    		
		    		Talla medida = new Talla(campo1,campo2,campo3,campo4);
		    		tallas.add(medida);
		            break;
		        }
		    	
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (CsvValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	//creo una coleccion con los datos de cada producto 
	public void cargarStock() {
		
		
		for(Talla item : tallas) {
			Habilitado habilitado = new Habilitado();
			habilitado.setProdId(item.getIdProducto());
			habilitado.setBacksoon(item.isBacksoon());
			habilitado.setProdTalla(item.getIdTalla());
			habilitado.setSpecial(item.isSpecial());			
			listado.add(habilitado);
		}
}
		
	
	//completo los datos de cada producto
	public void completarStock() {
		//completo cantidad del producto
		for(Habilitado item : listado) {
			
			for(Stock cantidad : stocks) {
				
				if(item.getProdTalla() == cantidad.getIdTalla()) {
					
					item.setProdCantidad(cantidad.getCantidad());
					
				}
				
				
				
			}
			
		}
		
		//completo codigo de orden del producto
		for(Habilitado item : listado) {
			for(Producto prod : productos) {
				if(item.getProdId()==prod.getId()) {
					item.setOrden(prod.getOrden());
				}
				
				
			}
		}
		
}
	
	
	//una vez que tengo el registro completo, opero y filtro sobre cada producto
	public void filtroSpecial() {
		
for(Habilitado item : listado) {
	item.setApto(false);
	
		//opero SOLO sobre los productos con al menos un codigo especial y marco los aptos
		if(item.isSpecial()) {
			int especialVerificador = item.getProdId();
			
			
			for(Habilitado item2 : listado) {
				
				if(item2.getProdId() ==especialVerificador ) {
					
					if(item2.getProdCantidad()>0 && item2.isBacksoon() && item2.getProdTalla() != item.getProdTalla()) {
						item.setApto(true);
					}
				}
			}
		}
	}
		
}
	
	
	public void filtroCasoComun() {
		for (Habilitado item : listado) {
			
			for (Habilitado item2 : listado) {
				//opero SOLO sobre los productos sin codigo especial y marco los aptos
				if(item2.getProdId()==item.getProdId()) {
					if(item2.isSpecial()==false) {
						if(item2.isBacksoon() || item2.getProdCantidad()>0 || item2.isBacksoon() && item2.getProdCantidad()>0 ) {
							item2.setApto(true);
						}
					}
				}
			}
		}
	}
	
	
	public void ordenar() {
		
		Collections.sort(listado, Comparadores.ordenarPorOrden);
		
		for(Habilitado item : listado) {
			if(item.isApto()) {
				productosMostrables.add(item.getProdId());
			}
		}
		
		
}
	
	
	//muestro los resultados
	public void mostrar() {
		System.out.println("----------------------");
		
		System.out.println("Los productos se muestran en este orden de Id:");
		
		int size = productosMostrables.size();
	    int comas = 0;
		
		for(Integer id : productosMostrables) {
			System.out.print(id);
			comas++;
	        if (comas < size) {
	            System.out.print(",");
	        }
		}
		System.out.println();
		
		System.out.println("----------------------");
		System.out.println("El Listado ordenado de los articulos disponibles es:");
		for(Habilitado item : listado) {
			if(item.isApto()) {
				System.out.println(item);
			}
		}
		System.out.println("----------------------");
}

	
	
	
}




