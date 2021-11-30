package com.revature.app;


//import org.eclipse.jetty.client.api.Request;

import io.javalin.Javalin;

public class Main {
	static House[] houses;
	static int currentIndex;

	public static void main(String[] args) {
		currentIndex = 0;
		houses = new House[100];
		Javalin app = Javalin.create(); 
		//Javalin app1 = Javalin.create();
		
		
		app.start();
		//app1.start();
		
		app.post("/BuildAHome", ctx-> {
			House house = new House();
			house.styleOfHome = ctx.formParam("styleOfHome");
			house.numOfFloors =  Integer.parseInt(ctx.formParam("numOfFloors"));
			house.numOfDoors =  Integer.parseInt(ctx.formParam("numOfDoors"));
			house.numOfWindows =  Integer.parseInt(ctx.formParam("numOfWindows"));
			house.numOfBedrooms =  Integer.parseInt(ctx.formParam("numOfBedrooms"));
			house.numOfBaths =  Integer.parseInt(ctx.formParam("numOfBaths"));
			house.numOfKitchens =  Integer.parseInt(ctx.formParam("numOfKitchens"));
			house.styleOfFloor = ctx.formParams("styleOfFloor");
			house.typeOfDoor = ctx.formParams("typeOfDoor");
			house.typeOfWindow = ctx.formParams("typeOfWindow");
			house.styleOfBedroom = ctx.formParams("styleOfBedroom");
			house.typeOfBathroom = ctx.formParams("typeOfBathroom");
			house.styleOfBathroom = ctx.formParams("styleOfBathroom");
			house.styleOfKitchen = ctx.formParams("styleOfKitchen");
			house.houseNumber = currentIndex + 1;
			
			houses[currentIndex] = house;
			currentIndex++;
			
			String reply = "You custom home has been submitted!";
			String reply1 = "Go back to the previous page to add more custom homes or see your list of custom homes!";
			reply += "<br>"+ reply1;
			ctx.html(reply);
			
			
		});
		
		app.get("/BuildAHome", ctx -> {
			System.out.println("You have " +currentIndex+ " house(s)!");
			
			
			String responseText = "";
			//String response = "";
			
			for(House eachhouse: houses) {
				
				
				if (eachhouse != null) {
				System.out.println(eachhouse);
				System.out.println("The style of this home will be: " +eachhouse.styleOfHome);
				System.out.println("This house has: " +eachhouse.numOfFloors+ " floors. The styles of floors will be: " +eachhouse.styleOfFloor);
				System.out.println("This house has: " +eachhouse.numOfDoors+ " doors. The type of doors will be: " +eachhouse.typeOfDoor);
				System.out.println("This house has: " +eachhouse.numOfWindows+ " windows. The type of windows will be: " +eachhouse.typeOfWindow);
				System.out.println("This house has: " +eachhouse.numOfBedrooms+ " bedrooms. The styles of bedrooms will be: " +eachhouse.styleOfBedroom);
				System.out.println("This house has: " +eachhouse.numOfBaths+ " bathrooms. The type of bathrooms will be: " +eachhouse.typeOfBathroom+ ". The styles of bathrooms will be: " +eachhouse.styleOfBathroom);
				System.out.println("This house has: " +eachhouse.numOfKitchens+ " kitchens. The styles of kitchens will be: " +eachhouse.styleOfKitchen);
									
				
				String a = "House number " +eachhouse.houseNumber+ " :";
				String a1 = "The style of this home will be: " +eachhouse.styleOfHome;
				String a2 = "This house has: " +eachhouse.numOfFloors+ " floors. The styles of floors will be: " +eachhouse.styleOfFloor;
				String a3 = "This house has: " +eachhouse.numOfDoors+ " doors. The type of doors will be: " +eachhouse.typeOfDoor;
				String a4 = "This house has: " +eachhouse.numOfWindows+ " windows. The type of windows will be: " +eachhouse.typeOfWindow;
				String a5 = "This house has: " +eachhouse.numOfBedrooms+ " bedrooms. The styles of bedrooms will be: " +eachhouse.styleOfBedroom;
				String a6 = "This house has: " +eachhouse.numOfBaths+ " bathrooms. The type of bathrooms will be: " +eachhouse.typeOfBathroom+ ". The styles of bathrooms will be: " +eachhouse.styleOfBathroom;
				String a7 = "This house has: " +eachhouse.numOfKitchens+ " kitchens. The styles of kitchens will be: "+eachhouse.styleOfKitchen;
				
				responseText += "<br>" + a +"<br>"+ a1 +"<br>"+ a2 +"<br>"+ a3 +"<br>"+ a4 +"<br>"+ a5 +"<br>"+ a6 +"<br>"+ a7 +"<br>";
				//response = a + responseText;
				}
				
			}
			ctx.html(responseText);
		});

	}

}
