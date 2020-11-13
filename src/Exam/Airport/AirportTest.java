package Exam.Airport;

import Exam.Airport.Model.Plane;
import Exam.Airport.Service.PlaneService;

public class AirportTest {
    public static void main(String[] args) {
        PlaneService planeService = new PlaneService();
        Plane plane1, plane2, plane3;
        plane1 = planeService.createPlane();
        planeService.printAllInfo(plane1);
        System.out.println("************** Task 2");
        plane2 = planeService.createPlane();
        planeService.checkSomeInfo(plane1);
        planeService.checkSomeInfo(plane2);
        System.out.println("************** Newer");
        planeService.printAllInfo(planeService.newerPlane(plane1, plane2));
        System.out.println("************** bigger WS");
        System.out.println(planeService.biggerWSModel(plane1, plane2));
        plane3 = planeService.createPlane();
        planeService.smallestSeats(plane1, plane2, plane3);
        Plane[] planesArray = {plane1, plane2, plane3};
        planeService.printNotMilitary(planesArray);
        System.out.println("*****hour 100+");
        planeService.inAir100(planesArray);
        System.out.println("*****min weight");
        planeService.minWeigth(planesArray);
        System.out.println("*****min cost");
        planeService.printAllInfo(planeService.minCost(planesArray));
        System.out.println("********Ascending*****");
        planeService.planeYearAsc(planesArray);
    }
}
