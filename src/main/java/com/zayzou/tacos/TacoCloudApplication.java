package com.zayzou.tacos;

import com.zayzou.tacos.data.IngredientRepository;
import com.zayzou.tacos.entity.Ingredient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TacoCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(TacoCloudApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(IngredientRepository ingredientRepository){
        return args -> {
            ingredientRepository.save(new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP));
        };
    }

  /*  @Bean
    public ApplicationRunner dataLoader2(IngredientRepository ingredientRepository){
        return args -> {
            ingredientRepository.save(new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));
        };
    }*/

}
