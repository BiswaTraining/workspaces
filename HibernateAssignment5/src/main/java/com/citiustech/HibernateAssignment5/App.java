package com.citiustech.HibernateAssignment5;

import com.citiustech.HibernateAssignment5.Dao.DaoImpl;

public class App 
{
    public static void main( String[] args )
    {
        DaoImpl.insertAssetAndEmployeeToDatabase();
        DaoImpl.getAssetById(1);
        DaoImpl.getCostliestAsset();
        DaoImpl.countTotalNumberOfEmployees();
        DaoImpl.getEmployeeDetailsOrderByName();
        DaoImpl.getEmployeeDetailsById(1);
        DaoImpl.getAverageAssetPriceByAssetLocation();
        DaoImpl.updatePassword(1);
        DaoImpl.deleteEmployeeById(4);
    }
}
