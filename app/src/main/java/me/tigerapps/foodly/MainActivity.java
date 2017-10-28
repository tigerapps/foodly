package me.tigerapps.foodly;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {
    private final ArrayList<Food> foods = new ArrayList<>();


    public recommendMeal(User user, FoodDatabase fdb){

     return aMeal
    }



    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.main_activity);


        Food sausage = new Food("sausage",210, 17, 16, 0 );
        Food egg = new Food("egg", 347, 30.6, 24.2, 7.8);
        Food milk = new Food("milk", 61, 3.2, 3.3, 4.8);
        Food orangeJuice = new Food("orange juice", 110, 2, 0, 26);
        Food hamburger = new Food("hamburger", 235, 9, 2, 50);
        Food onion = new Food("onion", 64, 1.6, 0, 11);
        Food rice = new Food("rice", 130, 2.4, 0.2, 28.7);
        Food garlic = new Food("garlic", 203, 8.6, 5.7, 45);
        Food tomato = new Food("tomato", 22, 1.1, 0.2, 4.8);
        Food cheese = new Food("cheese", 113, 7, 9, 0.4);
        Food pork = new Food("pork", 297, 25.7, 20.8, 0);
        Food beef = new Food("beef", 213, 22, 13, 0);
        Food chicken = new Food("chicken", 165, 31, 1.2, 0);
        Food carrot = new Food("carrot", 25, 0.6, 0.1, 6);
        Food broccoli = new Food("broccoli", 50, 4.2, 0.5, 10);
        Food salt = new Food("salt", 0, 0, 0, 0);
        Food sugar = new Food("sugar", 9, 0, 0, 2.3);
        Food bacon = new Food("bacon", 43, 3, 3.3, 0.1);
        Food butter = new Food("butter", 102, 0.1, 12, 0);
        Food ketchup = new Food("ketchup", 19, 0.2, 0, 4.5);
        Food pasta = new Food("pasta", 75, 2.9, 0.6, 14);
        Food noodle = new Food("noodle", 221, 7, 3.3, 40);
        Food mustard = new Food("mustard", 3, 0.2, 0.2, 0.3);
        Food ginger = new Food("ginger", 9, 0.2, 0.1, 2);
        Food ham = new Food("ham", 203, 29, 8, 2.1);



        ArrayList<Food> alfredo = new ArrayList<>();
        alfredo.addAll(Arrays.asList(pasta, butter, salt, cheese, noodle));
        ArrayList<Food>  steak = new ArrayList<>();
        steak.addAll(Arrays.asList(beef, egg, salt, ketchup, mustard));
        ArrayList<Food> thaiBeef = new ArrayList<>();
        thaiBeef.addAll(Arrays.asList(sugar, garlic, ginger, beef, beef));
        ArrayList<Food> tomatoSoup = new ArrayList<>();
        tomatoSoup.addAll(Arrays.asList(tomato, onion, salt, butter, milk, ham));
        ArrayList<Food> broccoliBeef = new ArrayList<>();
        broccoliBeef.addAll(Arrays.asList(broccoli, beef, sugar, ginger, garlic));
        ArrayList<Food> cheeseBurger = new ArrayList<>();
        cheeseBurger.addAll(Arrays.asList(hamburger, cheese, ketchup, onion));
        ArrayList<Food> sausageEgg = new ArrayList<>();
        sausageEgg.addAll(Arrays.asList(sausage, egg, onion, ketchup, sugar, salt, butter, ham));


    }
}
