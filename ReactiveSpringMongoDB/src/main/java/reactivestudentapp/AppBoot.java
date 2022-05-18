package reactivestudentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = "reactivestudentapp")
public class AppBoot {

	public static void main(String[] args) {
		List<String> names = new ArrayList<>();
			names.add("Naveen");
			names.add("Vignesh");
			names.add("Ram");

		// imperative style
		List<String> capitalNames = new ArrayList<>();
		for(String name:names){
			String capitalName = name.toUpperCase();
		 	capitalNames.add(capitalName);
		}
		System.out.println(capitalNames);

		// declarative style 1
		Stream<String> namesStream = names.stream()
									      .map(name -> {
			      								return name.toUpperCase();
										      });
		List<String> capitalNames2 = namesStream.collect(Collectors.toList());
		System.out.println(capitalNames2);

		// declarative style 2
		List<String> capitalNames3 = names.stream()
									    .peek(name -> System.out.println("Stage 1 : Peeking at " + name))
										.map(name -> {
											System.out.println("Stage 2 : converting to uppercase " + name);
											return name.toUpperCase();
										})
										.map(name -> {
											System.out.println("Stage 3 : adding * to " + name);
											return name + " * ";
										})
										//.map(name -> name.toUpperCase())
										//.map(name -> name + "*")
										.collect(Collectors.toList());
		System.out.println(capitalNames3);

		// declarative style 2.a
		List<String> capitalNames4 = names.stream()
											.peek(name -> System.out.println("Stage 1 : Peeking at " + name))
										//	.map(name -> name.toUpperCase())
										    .map(String::toUpperCase)
											.map(name -> name + "*")
											.collect(Collectors.toList());
		System.out.println(capitalNames4);

		// declarative style 2 (map name to length)
		List<Integer> namesLength = names.stream()
										.map(name -> name.length())
										.collect(Collectors.toList());
		System.out.println(namesLength);

		SpringApplication.run(AppBoot.class, args);
	}

}
