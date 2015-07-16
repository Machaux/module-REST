package com.bankonet.EJB;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.bankonet.persistance.Employe;


@Stateless
@TransactionManagement(value=TransactionManagementType.CONTAINER)
public class EmployeEJB {
	
	@PersistenceContext(unitName="jpa-tp") private EntityManager em;
	
	public List<Employe> getEmployes(){
	
		String req1 = "Select e from Employe as e";
		Query quer1 = this.em.createQuery(req1);
				
		List<Employe> result1 = (List<Employe>)quer1.getResultList();	
		
		return result1;
}
	public Employe getEmployesByID(int id){
		
		Employe cherchedEmploye = null;
		List<Employe> listeEmploye = this.getEmployes();
				
		for (Employe employe : listeEmploye)
		{
			if (id==employe.getId())
			{
				cherchedEmploye=employe;
			}
		}
		return cherchedEmploye;
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void createEmploye(int id, String nom){
		
		Employe newEmploye = new Employe(id, nom);
		em.merge(newEmploye);
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void updateEmploye(int id, String nouvNom) throws Exception{
		
		Employe updatableEmploye = getEmployesByID(id);
		if (updatableEmploye!=null)
		{
			updatableEmploye.setNom(nouvNom);
			em.persist(updatableEmploye);
		}
		else
		{
			throw (new NullPointerException());		
		}
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void deleteEmploye(int id) throws Exception{
		
		Employe deletableEmploye = getEmployesByID(id);
		if (deletableEmploye!=null)
		{
			em.remove(deletableEmploye);
		}
		else
		{
			throw (new NullPointerException());		
		}
		
	}
}
