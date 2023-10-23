/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.IDao;
import entities.Machine;
import entities.Salle;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.MachineService;
import service.SalleService;
import util.HibernateUtil;

/**
 *
 * @author hicham
 */
public class Test {

    public static void main(String[] args) {
        try {
            IDao<Machine> dao = new MachineService();
            IDao<Salle> dao2 = new SalleService();
            //Salle salle = new Salle("CC5");
            //dao2.create(salle);
            //dao.create(new Machine("rr44", "DELL", 6000, salle));
            /*for(Machine m : dao.findAll()){
             System.out.println(m);
             }
             for(Salle s : dao2.findAll()){
             System.out.println(s);
             }*/

            for (Machine m : dao.findMachineParSalle(dao2.findById(2))) {
                System.out.println(m);
            }
        } catch (RemoteException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
