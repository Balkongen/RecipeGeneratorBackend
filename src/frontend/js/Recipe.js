class Recipe {
    
    name;
    ingredients = [];
    instructions;

    constructor(name, ingredients ,instructions) {
        this.name = name;
        this.setIngridients(ingredients);
        this.setInstructions(instructions);
    }

    setIngridients(ingredients) {
        this.ingredients = ingredients;
    }

    setInstructions(instructions) {
        this.instructions = instructions;
    }

    changeIngredientsAmount(factor) {
        for (let i = 0; i < this.ingredients.length; i++) {
            let amount = this.ingredients[i].charAt(0);
            if (this.checkNumber(amount)) {
                let rest = this.ingredients[i].substring(1);
                amount *= factor;
                this.ingredients[i] = amount + rest;   
            } 
        }
    }

    checkNumber(letter) {
        return letter >= '0' && letter <= '9';
    }

    printIngr() {
        for (let i of this.ingredients) {
            console.log(i);
        }
    }
} // End of class

// All recipes
const RECEPT = [];

const cacioEPeppe = new Recipe(
    "Cacio e peppe",
    [
        "100 grams parmesan", 
        "1 grams black pepper", 
        "200 grams pasta of your choice"
    ],
    "Cook the pasta and mix all the ingridients in a frying pan"
);

RECEPT.push(cacioEPeppe);

const pastaPesto = new Recipe(
    "Pasta Pesto",
    [
        "0.5 pot of basil",
        "5 grams pine nuts",
        "7 cl olive oil",
        "30 grams parmesan",
        "200 grams pasta of your choice"
    ],
    "Mix all the ingredients in a blender. Boil the pasta, mix it all together in a frying pan."
);
RECEPT.push(pastaPesto);

const penneVodka = new Recipe(
    "Penne vodka",
    [
        "200 grams penne pasta",
        "70 grams diced bacon",
        "A splash of vodka",
        "100 grams tomato sauce",
        "1,5 dl cream"
    ],
    "Boil the pasta, fry the bacon, add the vodka and then mix all the ingredients together."
);
RECEPT.push(penneVodka);

const pastaWithTomato = new Recipe(
    "Pasta with tomato sauce",
    [
        "200 grams penne pasta",
        "0.5 can of crushed tomatoes",
        "2 cloves of garlic",
        "50 grams parmesan cheese",
        "Salt, pepper and thyme for seasoning",
        "Olive oil"
    ],
    "Chop the garlic and fry it in olive oil in a pan. Fry until the garlic gets a little color then add the crushed tomatoes. Turn the heat down and let it simmer for 30 minutes. Meanwhile put on a pot of boiling water with salt and add the pasta. When the pasta is aldente add it to the sauce and mix it all together. Add some pasta water if the sauce gets too dry. Add the cheese and mix it."
);
RECEPT.push(pastaWithTomato);

const stirFry = new Recipe(
    "Noodle stir fry",
    [
        "150 grams rice noodles",
        "1 clove of garlic",
        "1 tea spoon of minced ginger",
        "1 egg",
        "Japanese soy sauce",
        "Oyster sauce",
        "Fish sauce",
        "Salt and pepper",
        "Your preffered vegetables",
    ],
    "The important thing with stir frys is to have all the ingridients ready before you start cooking. So begin with preparing all the vegetables, garlic and ginger. <br> <br>Turn on the frying pan and put it on 6 on a scale from 0-10. Add the cooking oil. When the oil is up to temperature add the garlic and ginger. Let it cook for about 10 to 15 seconds before adding your vegetables. The thicker the chunks the more cooking time it needs. Add the egg and scramble it in the pan. Turn down the head and add the noodles, soy, oyster and fish sauce. Mix all of the ingredients."
);
RECEPT.push(stirFry);

const chickenSandwich = new Recipe(
    "Chicken BLT",
    [
        "150 grams of chicken breast",
        "Bread of your choice",
        "4 cherry tomatoes",
        "Mayonaise",
        "Curry spice mix",
        "Lettuce",
        "Tomato",
        "Bacon",
        "Salt and pepper",
        "1 egg"
    ],
    "Start with frying the bread with butter in a pan. Slice the chicken breast so you have a thin long piece that can cover the whole bread. Fry the chicken. Meanwhile you can prepare the mayonaise. <br> <br>Mix the mayonaise, curry mix, salt and pepepr togther. Feel free to add other spices or use another sauce.<br> <br>Fry the egg and bacon. Assemble the sandwich by covering the bread slices with the mayonaise, then add the rest of the ingredients however you prefer."
);
RECEPT.push(chickenSandwich);

const pastaSalsicca = new Recipe(
    "Pasta salsiccia",
    [
        "150 grams Penne pasta",
        "100 grams salsiciia",
        "0.5 onions",
        "1 clove of garlic",
        "1 table spoon of tomato paste",
        "Chili",
        "Thyme, salt and pepper",
        "Parmesan cheese"
    ],
    "Take out the meat from the salsiccia and put it in a frying pan. Fry until the meat has gotten som color, then add the diced onion and garlic.<br><br>Put on a pot with salted water the let it heat it up to a boil. Add the pasta. Add the rest of the ingredients to the frying pan. When the pasta is aldente add it to the rest of the ingredients and mix it up. Add pastawater and parmesan to make the dish creamy."
);
RECEPT.push(pastaSalsicca);

const breakfastBurrito = new Recipe(
    "Breakfast burrito",
    [
        "70 grams of bacon",
        "0.5 onions",
        "1 potato",
        "1 tortilla",
        "1 egg",
        "Cheese",
        "Mayonaise",
        "Sriracha",
    ],
    "Chop the onion in slices and grate the potatos. Then frying the bacon in a pan. Make a hasbrown and use the excess fat to fry the potato and the onion.<br><br>Crack open an egg the stir it in the pan. After ten seconds or so put the tortilla on it. Then flip it and put all of the ingredients in it."
);
RECEPT.push(breakfastBurrito);
