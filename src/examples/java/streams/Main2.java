package streams;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main2 {

	static class Camisa {
		String color;
		String marca;
		String talla;

		Camisa(String color, String marca, String talla) {
			this.color = color;
			this.marca = marca;
			this.talla = talla;
		}

		public String getColor() {
			return color;
		}

		public String getMarca() {
			return marca;
		}

		public String getTalla() {
			return talla;
		}

		@Override
		public String toString() {
			return "camisa color: " + color + ", marca: " + marca + ", talla: " + talla;
		}

	}

	public static void main(String[] args) {
		Camisa c1 = new Camisa("rojo", "adidas", "XL");
		Camisa c2 = new Camisa("azul", "nike", "L");
		Camisa c3 = new Camisa("negra", "today", "S");

		List<Camisa> camisaList = Arrays.asList(c1, c2, c3);

		Predicate<Camisa> p = s -> "rojo".equals(s.color);

		//List<Camisa> result = camisaList.stream().filter(p)
				//.collect(Collectors.toList());

		//result.forEach(System.out::println);

		Map<String, List<Camisa>> mapCamisasByMarca = camisaList.stream().collect(Collectors.groupingBy(Camisa::getMarca));

		System.out.print(mapCamisasByMarca);



	}
}
