package arquant.backend.utilidades;

import java.util.Comparator;

import arquant.backend.entity.Habilitado;

public class Comparadores {

	public static Comparator<Habilitado> ordenarPorOrden = new Comparator<Habilitado>() {
		@Override
		public int compare(Habilitado o1, Habilitado o2) {
			return o1.getOrden().compareTo(o2.getOrden());
		}
		
	};
	
}
