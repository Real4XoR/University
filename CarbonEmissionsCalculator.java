// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 1
 * Name:
 * Username:
 * ID:
 */

import ecs100.*;

/** Program for calculating carbon emissions */

public class CarbonEmissionsCalculator{

    public static final double EMISSION_FACTOR_POWER = 0.0977;   // emissions factor of electricity per kWh
    public static final double EMISSION_FACTOR_WASTE = 0.299;    // emissions factor of food waste per kg

    public static final double ANNUAL_AVERAGE_POWER_EMISSION_NZ = 266.5;   //Annual average carbon emissions in NZ (kg) from electricity use
    public static final double ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ = 18; //Annual average carbon emissions in NZ (kg) from food waste

    /**
     * Calculates and prints carbon emissions
     */
    
    public void calculateEmissions(){
        UI.println("--------------------------------");
        UI.println("Carbon Emmisions Calculator Core");
        double kwh = UI.askDouble("Monthly Electricity consumption (kWh)");
        double food_waste = UI.askDouble("Weekly food waste (kg)");
        double power_emission = (kwh * EMISSION_FACTOR_POWER);
        double food_emission = (food_waste * EMISSION_FACTOR_WASTE);
        double average_daily_emissions = ((power_emission*12)/365 + food_emission/7); 
        UI.println("CO2 emissions casused by electricity (kg CO2-e) in the month: " + String.format("%.2f", power_emission));
        UI.println("CO2 emissions caused by waste (kg CO2-e) in the week: " + String.format("%.2f", food_emission));
        UI.println("Daily average CO2 emissions (kg CO2-e): " + String.format("%.2f", average_daily_emissions));

    }

    public void CalculateEmissionsCompletion(){
        UI.println("----------------------------");
        UI.println("Carbon Emmissions Completion");
        double kwh_c = UI.askDouble("Monthly household electricity consuption (kWh): ");
        double food_waste_c = UI.askDouble("Weekly household food waste (kg): ");
        double power_emission_c = (kwh_c * EMISSION_FACTOR_POWER);
        double food_emission_c = (food_waste_c * EMISSION_FACTOR_WASTE);
        double average_daily_emissions_c = ((power_emission_c*12/365) + food_emission_c/7);
        UI.println("CO2 emissions casused by electricity (kg CO2-e) in the month: " + String.format("%.2f", power_emission_c));
        UI.println("CO2 emissions caused by waste (kg CO2-e) in the week: " + String.format("%.2f", food_emission_c));
        UI.println("Daily average household CO2 emissions (kg CO2-e): " + String.format("%.2f", average_daily_emissions_c));
        double household_members = UI.askDouble("Number of individuals in household: ");
        //double annual_national_average = ANNUAL_AVERAGE_POWER_EMISSION_NZ * EMISSION_FACTOR_POWER
                //+ ANNUAL_AVERAGE_FOOD_WASTE_EMISSION_NZ * EMISSION_FACTOR_WASTE;
        double annual_household_emissions_amount = ((average_daily_emissions_c * 365/household_members/(266.5+18))*100);
        UI.println("You emit " + String.format("%.2f", annual_household_emissions_amount) + "% CO2 emissions of NZ annual average" );
        
    }
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Calculate Emissions", this::calculateEmissions);
        UI.addButton("Calculate Emissions Completion", this::CalculateEmissionsCompletion);
        UI.addButton("Quit", UI::quit);
        UI.setDivider(1);    // Expand the Text pane
    }

    public static void main(String[] args){
        CarbonEmissionsCalculator cec = new CarbonEmissionsCalculator();
        cec.setupGUI();
    }

}
