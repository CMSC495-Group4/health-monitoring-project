
/**
 * Calculation Class
 * This class accepts a string array and will compute the total number of calories necessary to eat in order to...
 * gain weight, lose weight, or maintain weight.
 *
 * @author Brandon Sroufe
 *
 */
public class Calculation {
    private int height;
    private int weight;
    private int age;
    private String gender;
    private String activity_level;
    private int target_goal;
    private String[] bios;
    private double calories;
    private double calories_must_eat;

    /**
     * Calculation Constructor
     * @param string_array a string array of biometric data. Array length of 20. Uses indices 6-19
     */
    public Calculation(String[] string_array){
        bios = string_array;
        this.height = Integer.parseInt(bios[2]);
        this.weight = Integer.parseInt(bios[3]);
        this.age = Integer.parseInt(bios[4]);
        this.gender = bios[5];
        this.activity_level = bios[6];
        this.target_goal = Integer.parseInt(bios[7]);
    }

    /**
     * Switch on gender and calculate calories needed to eat.
     *  @return double
     */
    public double getCalc(){
        switch (gender){
            case("male"):
                double temp = calcMale();
                calories = calcHarrisBenedict(temp);
                break;

            case("female"):
                temp = calcFemale();
                calories = calcHarrisBenedict(temp);
                break;
        }
        if (target_goal > weight){ //eat more
            calories_must_eat = calories + 500;

        }else if (target_goal < weight){ //eat less
            calories_must_eat = calories - 500;

        } else if(target_goal == weight){ //eat the same
            calories_must_eat = calories;
        }
        return calories_must_eat;
    }

    private double calcMale(){
        double BMR = (66 + (weight * 6.3) + (12.9 * height) - (6.8 * age));
        return BMR;
    }

    private double calcFemale(){
        double BMR = (655 + (4.3 * weight) + (4.7 * height) - (4.7 * age));
        return BMR;
    }

    /**
     * Calculates Harris Benedict Formula
     * @param BMR
     * @return double rounded to nearest int, calories_to_maintain current weight
     */
    private double calcHarrisBenedict(double BMR){
        double calories_to_maintain = 0;
        switch(activity_level){
            case("sedentary"):
                calories_to_maintain = BMR * 1.2;
                break;
            case("light_activity"):
                calories_to_maintain = BMR * 1.375;
                break;
            case("moderate"):
                calories_to_maintain = BMR * 1.55;
                break;
            case("very_active"):
                calories_to_maintain = BMR * 1.725;
                break;
            case("extra_active"):
                calories_to_maintain = BMR * 1.9;
                break;
        }
        return Math.round(calories_to_maintain);
    }
}