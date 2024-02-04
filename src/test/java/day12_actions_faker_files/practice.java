package day12_actions_faker_files;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class practice extends TestBase {
    @Test
   public void practice01() {
      Faker faker = new Faker();

        System.out.println(faker.university().name());

    }
}
