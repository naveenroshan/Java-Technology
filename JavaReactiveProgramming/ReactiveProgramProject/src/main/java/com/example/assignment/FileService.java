package com.example.assignment;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import reactor.core.publisher.Mono;

public class FileService {
	
	
	//Building the Mono piple Line for read
	public static Mono<String> read(String fileName){
		return Mono.fromSupplier(() -> readFile(fileName));
	}
	
	//Building the Mono piple Line for write
	public static Mono<Void> write(String fileName, String content){
		return Mono.fromRunnable(() -> writeFile(fileName, content));
	}
	
	//Building the Mono piple Line for delete
	public static Mono<Void> delete(String fileName){

		return Mono.fromRunnable(() -> deleteFile(fileName));
	}

	
	

	 private static final Path PATH = Paths.get("src/main/resources/Assignment/sec01");
	 
	 private static String readFile(String filename) {
		 try {
			 return Files.readString(PATH.resolve(filename));
		 }catch(IOException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	 private static void writeFile(String filename, String content) {
		 try {
			 Files.writeString(PATH.resolve(filename), content);
		 }catch(IOException e) {
			 throw new RuntimeException(e);
		 }
	 }
	 
	 private static void deleteFile(String filename) {
		 try {
			 Files.delete(PATH.resolve(filename));
		 }catch(IOException e) {
			 throw new RuntimeException(e);
		 }
	 }
		 

}
