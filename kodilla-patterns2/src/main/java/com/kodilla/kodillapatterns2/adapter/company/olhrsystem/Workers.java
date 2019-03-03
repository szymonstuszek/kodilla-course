package com.kodilla.kodillapatterns2.adapter.company.olhrsystem;

public class Workers {
    private String[][] workers = {
            {"67032906720", "John", "Smith"},
            {"67032906721", "Ivone", "Novak"},
            {"67032906722", "Jessie", "Pinkman"},
            {"67032906723", "Walter", "White"},
            {"67032906724", "Clara", "Lanson"}
    };

    private double[] salaries = {
            4500.0,
            3700.0,
            4350.0,
            9000.0,
            6200.0,
    };

    public String getWorker(int n) {
        if(n > salaries.length) {
            return "";
        }
        return workers[n][0] + ", " + workers[n][1] + ", " + workers[n][2] + ", " + salaries[n];
    }

    public String[][] getWorkers() {
        return workers;
    }

    public double[] getSalaries() {
        return salaries;
    }
}
