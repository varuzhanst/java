package Exam.Airport.Service;

import Exam.Airport.Model.Plane;

import java.util.Scanner;

public class PlaneService {


    public Plane createPlane() {
        Plane plane = new Plane();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter model:");
        plane.setModel(scanner.nextLine());
        System.out.println("Enter country:");
        plane.setCountry(scanner.nextLine());
        System.out.println("Enter year:");
        plane.setYear(scanner.nextInt());
        System.out.println("Enter hours:");
        plane.setHours(scanner.nextInt());
        System.out.println("Is it military / true or false:");
        plane.setMilitary(scanner.nextBoolean());
        System.out.println("Enter weight:");
        plane.setWeight(scanner.nextInt());
        System.out.println("Enter wingspan:");
        plane.setWingspan(scanner.nextInt());
        System.out.println("Enter top speed:");
        plane.setTopSpeed(scanner.nextInt());
        System.out.println("Enter seats:");
        plane.setSeats(scanner.nextInt());
        System.out.println("Enter cost:");
        plane.setCost(scanner.nextDouble());
        return plane;
    }
/*Task 1. (score 5)
Create function:
Parameter one Plane
Result: print all information of the plane */

    public void printAllInfo(Plane plane) {
        System.out.println("Model:" + plane.getModel());
        System.out.println("Country:" + plane.getCountry());
        System.out.println("Year:" + plane.getYear());
        System.out.println("Hours:" + plane.getHours());
        System.out.println("Is it military:" + plane.isMilitary());
        System.out.println("Weight:" + plane.getWeight());
        System.out.println("Wingspan:" + plane.getWingspan());
        System.out.println("Top speed:" + plane.getTopSpeed());
        System.out.println("Seats:" + plane.getSeats());
        System.out.println("Cost:" + plane.getCost());

    }

    /*Task 2. (score 5)
Create function:
Parameter one Plane
Result: print cost and topSpeed
 if the plane is military
 otherwise print model and country*/

    public void checkSomeInfo(Plane plane) {
        if (plane.isMilitary()) {
            System.out.println("Top speed:" + plane.getTopSpeed());
            System.out.println("Cost:" + plane.getCost());
        } else {
            System.out.println("Model:" + plane.getModel());
            System.out.println("Country:" + plane.getCountry());
        }
    }
/*Task 3. (score 7)
Create function:
Parameter two Planes
Result: return the plane which one is newer
 (if they have the same age return first one).*/

    public Plane newerPlane(Plane plane1, Plane plane2) {
        if (plane1.getYear() >= plane2.getYear()) {
            return plane1;
        } else return plane2;
    }

    /*Task 4. (score 7)
Create function:
Parameter two Planes
Result: return the model of the plane which has bigger wingspan
 (if they have the same - return second one).*/

    public String biggerWSModel(Plane plane1, Plane plane2) {
        if (plane1.getWingspan() <= plane2.getWingspan()) {
            return plane2.getModel();
        } else return plane1.getModel();
    }

  /*Task 5. (score 7)
Create function:
Parameter three Planes
Result: print country of the plane with smallest seats count
 (if they have the same - print first).*/

    public void smallestSeats(Plane plane1, Plane plane2, Plane plane3) {
        if (plane1.getSeats() <= plane2.getSeats() && plane1.getSeats() <= plane3.getSeats())
            System.out.println(plane1.getCountry());
        else if (plane2.getSeats() <= plane1.getSeats() && plane2.getSeats() <= plane3.getSeats())
            System.out.println(plane2.getCountry());
        else if (plane3.getSeats() <= plane1.getSeats() && plane3.getSeats() <= plane2.getSeats())
            System.out.println(plane3.getCountry());
    }

    /*Task 6. (score 7)
 Create function:
 Parameter array of Planes
 Result: print all not military planes.
 */
    public void printNotMilitary(Plane[] plane) {
        for (int i = 0; i < plane.length; i++) {
            if (!plane[i].isMilitary()) {
                printAllInfo(plane[i]);
            }
        }

    }
/*
* Task 7. (score 10)
Create function:
Parameter array of Planes
Result: print all military
* planes which were in air more than 100 hours.
* */

    public void inAir100(Plane[] plane) {
        for (int i = 0; i < plane.length; i++) {
            if (plane[i].getHours() > 100) {
                printAllInfo(plane[i]);
            }
        }
    }

   /*Task 8. (score 10)
Create function:
Parameter array of Planes
Result: return the plane with minimal weight
 (if there are some of them return last one).*/

    public void minWeigth(Plane[] plane) {
        int ind = 0;
        int min = plane[0].getWeight();
        for (int i = 1; i < plane.length; i++) {
            if (plane[i].getWeight() <= min) {
                min = plane[i].getWeight();
                ind = i;
            }
        }
        printAllInfo(plane[ind]);
    }

    /*Task 9. (score 10)
    * Create function:
Parameter array of Planes
Result: return the plane with minimal cost
* from all military planes (if there are some of them return first one).
    * */
    public Plane minCost(Plane[] plane) {
        int ind = 0;
        double min = plane[0].getCost();
        for (int i = 1; i < plane.length; i++) {
            if (plane[i].getWeight() < min) {
                min = plane[i].getWeight();
                ind = i;
            }
        }
        return plane[ind];
    }

    /*Task 10. (score 12)
Create function:
Parameter array of Planes
Result: print planes in ascending form order by year
*/
    public void planeYearAsc(Plane[] plane) {
        int years[] = new int[plane.length];
        for (int i = 0; i < years.length; i++) {
            years[i] = plane[i].getYear();
        }

        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < years.length - 1; i++) {
                if (years[i] > years[i + 1]) {
                    int temp;
                    temp = years[i];
                    years[i] = years[i + 1];
                    years[i + 1] = temp;
                    isSorted = false;
                }
            }
            for (int i = 0; i < plane.length; i++) {
                for (int j = 0; j < plane.length; j++) {
                    if (plane[j].getYear() == years[i]) {
                        printAllInfo(plane[j]);
                    }
                }
            }


        }
    }

}
