package com.epam.training.restaurant;

import com.epam.training.restaurant.domain.Client;
import com.epam.training.restaurant.domain.Restaurant;
import com.epam.training.restaurant.factoty.DishFactory;
import com.epam.training.restaurant.factoty.ExtraFactory;
import com.epam.training.restaurant.util.ConsoleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestaurantApplication implements CommandLineRunner {
    private static final String QUIT = "Q";
    private ConsoleService consoleService = ConsoleService.getInstance();

    public static void main(String[] args) {
        SpringApplication.run(RestaurantApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Restaurant restaurant = new Restaurant(true);
        Thread kitchen = new Thread(restaurant);
        kitchen.start();
        emulateWorkflow(restaurant);
        restaurant.close();
        kitchen.join();
    }

    private void emulateWorkflow(Restaurant restaurant){
        String choice = "";
        while (!choice.equalsIgnoreCase(QUIT)){
            Client c = new Client(0, restaurant);
            String dish = consoleService.readValue("We've got Chips and HotDog today. What do you want?");
            String extra = consoleService.readValue("You can add Ketchup or Mustard? What do you want?");
            c.placeOrder(
                    DishFactory.getDishByName(dish).orElse(null),
                    ExtraFactory.getExtraByName(extra).orElse(null)
            );

            choice = consoleService.readValue("Press Q to Quit or enything else to carry on:");
        }
    }
}
