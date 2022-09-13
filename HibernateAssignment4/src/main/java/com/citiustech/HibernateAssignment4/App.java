package com.citiustech.HibernateAssignment4;

import com.citiustech.HibernateAssignment4.dao.DaoImpl;

public class App 
{
    public static void main( String[] args )
    {
        DaoImpl.findMaximumRevenue();
        DaoImpl.findMinimumRevenue();
        DaoImpl.averageRevenue();
        DaoImpl.sumOfRevenue();
        DaoImpl.getNumberOfMoviesInAParticularLanguage("English");
        DaoImpl.getNumberOfMoviesInEachLanguage();
    }
}
