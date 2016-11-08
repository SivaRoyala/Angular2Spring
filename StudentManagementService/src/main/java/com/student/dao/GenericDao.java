package com.student.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class GenericDao< T extends Serializable > {
	 
	   private Class< T > clazz;
	 
	   @Autowired
	   SessionFactory sessionFactory;
	 
	   public final void setClazz( Class< T > clazzToSet ){
	      this.clazz = clazzToSet;
	   }
	 
	   @SuppressWarnings("unchecked")
	   public T findOne( long id ){
	      return (T) getCurrentSession().get( clazz, id );
	   }
	   
	   @SuppressWarnings("unchecked")
	   public List< T > findAll(){
	      return getCurrentSession().createQuery( "from " + clazz.getName() ).list();
	   }
	 
	   public void create( T entity ){
	      getCurrentSession().persist( entity );
	   }
	 
	   public void update( T entity ){
	      getCurrentSession().merge( entity );
	   }
	 
	   public void delete( T entity ){
	      getCurrentSession().delete( entity );
	   }
	   public void deleteById( long entityId ){
	      T entity = findOne( entityId );
	      delete( entity );
	   }
	   
	   protected final Session getCurrentSession(){
	      return sessionFactory.openSession();
	   }
	   
	   public void closeSession(Session session){
			if(session != null){
				session.close();
			}
		}
	}
