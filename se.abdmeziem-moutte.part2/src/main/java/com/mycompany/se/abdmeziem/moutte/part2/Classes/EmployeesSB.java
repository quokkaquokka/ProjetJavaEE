/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.se.abdmeziem.moutte.part2.Classes;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Camille Moutte and Theo Abdmeziem
 */
@Stateless
public class EmployeesSB {
    @PersistenceContext
    EntityManager em;

    public List getEmployees() {
        Query q = em.createQuery("SELECT e FROM Employees e");
        return q.getResultList();
    }
    
    public Employees getEmployee(int id) {
        Employees employees = null;
        Query q = em.createQuery("SELECT e FROM Employees e WHERE e.id = :id");
        q.setParameter("id", id);
        employees = (Employees) q.getSingleResult();
        return employees;
    }
    
     public void deleteEmployee(int id) {        
        Query query = em.createQuery("DELETE FROM Employees e WHERE e.id = :id");
        int deletedCount = query.setParameter("id", id).executeUpdate();
    }
     
     public void updateEmployee(int id, String name, String firstname, String homePhone,
			String mobPhone, String proPhone, String address, String postcode,
			String city, String email){
         Query query = em.createQuery(
                "UPDATE Employees SET name = :n, firstname = :f, telhome = :th, telmob = :tm, telpro = :tp, adress = :a, postalcode = :p, city = :c, email = :em WHERE id = :id"
            );
        int updateCount = query.setParameter("n", name)
            .setParameter("f", firstname)
            .setParameter("th", homePhone)
            .setParameter("tm", mobPhone)
            .setParameter("tp", proPhone)
            .setParameter("a", address)
            .setParameter("p", postcode)
            .setParameter("c", city)
            .setParameter("em", email)
            .setParameter("id", id)
              .executeUpdate();
     }
     
     public void addEmployees(String name, String firstname, String homePhone,
            String mobPhone, String proPhone, String address, String postcode,
            String city, String email) {
        Query query = em.createNativeQuery(
              "INSERT INTO EMPLOYEES (NAME,FIRSTNAME,TELHOME,TELMOB,TELPRO,ADRESS,POSTALCODE,CITY,EMAIL) VALUES (?,?,?,?,?,?,?,?,?)"
          );
          
        int isDone = query.setParameter(1, name)
            .setParameter(2, firstname)
            .setParameter(3, homePhone)
            .setParameter(4, mobPhone)
            .setParameter(5, proPhone)
            .setParameter(6, address)
            .setParameter(7, postcode)
            .setParameter(8, city)
            .setParameter(9, email)
            .executeUpdate();
     }
}
