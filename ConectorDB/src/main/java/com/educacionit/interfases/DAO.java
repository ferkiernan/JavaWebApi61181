package com.educacionit.interfases;

import java.util.List;

//Generics
public interface DAO<K,E> {
	boolean insertar(E e);
	boolean modificar(E e);
	boolean eliminar(E e);
	
	E buscarPorId(K k);
	
	List<E> listar();
	

}
