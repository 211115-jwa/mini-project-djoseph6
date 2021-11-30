package com.revature.app;

import io.javalin.Javalin;

public class Driver {
	static Pet[] pets;
	static int currentIndex;
	
	public static void main(String[] args) {
		currentIndex=0;
		pets = new Pet[10]; // initializing the pets array
		
		Javalin app = Javalin.create();
		
		app.start();
		
		app.post("/pets", ctx -> {
			// our information is going to be coming in as "form parameters"
			Pet pet = new Pet();
			pet.name = ctx.formParam("name");
			pet.species = ctx.formParam("species");
			pet.description = ctx.formParam("description");
			pet.age = Integer.parseInt(ctx.formParam("age"));
			
			pets[currentIndex] = pet;
			currentIndex++;
			
			String responseText = "";
			
			for (Pet eachPet : pets) {
				System.out.println(eachPet);
				if (eachPet != null) {
					responseText += eachPet.name + "<br>";
				}
			}
			
			ctx.html(responseText);
		});
	}
}
