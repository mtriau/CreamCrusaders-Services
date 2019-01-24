package com.handmade.dao;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public abstract class AbstractJpaDAO<T> {
	 
	   private Class< T > type;
	 
	   @PersistenceContext
	   EntityManager entityManager;
	 
	   public AbstractJpaDAO(){
		   Type t = getClass().getGenericSuperclass();
	       ParameterizedType pt = (ParameterizedType) t;
	       type = (Class) pt.getActualTypeArguments()[0];
	   }
	   
	   public void settype( Class< T > typeToSet ) {
	      this.type = typeToSet;
	   }
	 
	   public T findOne( Integer id ){
	      return entityManager.find( type, id );
	   }
	   public List< T > findAll(){
	      return entityManager.createQuery( "from " + type.getName() )
	       .getResultList();
	   }
	   public List<T> findAllWithPropertyId(String tableName, String columnName, Integer id){
		   Query q = entityManager.createQuery(
					"SELECT e FROM " + type.getName() + " e WHERE " + columnName + "  = :prop");

		   	q.setParameter("prop", id);
			return (List<T>) q.getResultList();
	   }
	 
	   public T save( T entity ){
	      entityManager.persist( entity );
	      entityManager.flush();
	      return entity;
	   }
	 
	   public void update( T entity ){
	      entityManager.merge( entity );
	   }
	 
	   public void delete( T entity ){
	      entityManager.remove( entity );
	   }
	   public void deleteById( Integer entityId ){
	      T entity = findOne( entityId );
	      delete( entity );
	   }
	}
