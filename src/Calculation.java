
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
        this.height = Integer.parseInt(bios[0]);
        this.weight = Integer.parseInt(bios[1]);
        this.age = Integer.parseInt(bios[2]);
        this.gender = bios[3];
        this.activity_level = bios[4];
        this.target_goal = Integer.parseInt(bios[5]);
    }

    /**
     * Switch on gender and calculate calories needed to eat.
     *  @return double
     */
    public String calc_weight_goal(){
        switch (gender){
            case("Male"):
                double temp = calcMale();
                calories = calcHarrisBenedict(temp);
                break;

            case("Female"):
                temp = calcFemale();
                calories = calcHarrisBenedict(temp);
                break;
        }
        if (target_goal > weight){ //eat more
            calories_must_eat = calories + 500;
            return "You need to consume " + calories_must_eat + " calories in order to gain weight.";

        }else if (target_goal < weight){ //eat less
            calories_must_eat = calories - 500;
            return "You need to consume " + calories_must_eat + " calories in order to lose weight.";

        } else if(target_goal == weight){ //eat the same
            calories_must_eat = calories;
            return "You need to consume " + calories_must_eat + " calories in order to maintain your current weight.";
        }
        return "You need to consume " + calories_must_eat + " calories.";
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
            case("Light_Activity"):
                calories_to_maintain = BMR * 1.375;
                break;
            case("Moderate_Activity"):
                calories_to_maintain = BMR * 1.55;
                break;
            case("Very_Active"):
                calories_to_maintain = BMR * 1.725;
                break;
            case("Extra_Active"):
                calories_to_maintain = BMR * 1.9;
                break;
        }
        return Math.round(calories_to_maintain);
    }
}
