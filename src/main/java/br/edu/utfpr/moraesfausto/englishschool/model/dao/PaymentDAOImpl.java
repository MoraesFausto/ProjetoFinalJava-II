/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Payment;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class PaymentDAOImpl implements PaymentDAO{

    EntityManager manager;
    
    public PaymentDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Payment Payment) {
        manager.getTransaction().begin();
        manager.persist(Payment);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Payment Payment) {
        manager.getTransaction().begin();
        manager.merge(Payment);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Payment Payment) {
        manager.getTransaction().begin();
        manager.remove(Payment);
        manager.getTransaction().commit();
    }

    @Override
    public List<Payment> listAll() {
        List<Payment> payments;
        
        TypedQuery query = manager.createQuery("SELECT p from Payment p", Payment.class);
        payments = query.getResultList();
        
        return payments;
    }

    @Override
    public Payment listById(Long id) {
        Payment payment;
        Query query = manager.createQuery("SELECT p from Payment p WHERE p.id = " + id);
        payment = (Payment) query.getSingleResult();
        return payment;
    }
    
}
