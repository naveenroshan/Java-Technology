package com.example.assignment;

import com.example.utility.Util;

import java.io.File;

public class AssginmentMonoDemo {
	
	public static void main(String[] args) {
		
		FileService.read("fileOne")
		           .subscribe(
		        		   Util.onNext(), 
		        		   Util.onError(), 
		        		   Util.onComplete()
		            );
		FileService.write("fileThree", "This is File three")
				   .subscribe(
						   Util.onNext(),
						   Util.onError(),
						   Util.onComplete()
				   );

		FileService.delete("fileThree")
				.subscribe(
						Util.onNext(),
						Util.onError(),
						Util.onComplete()
				);
	}
}
