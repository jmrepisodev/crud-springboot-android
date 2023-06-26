package com.repiso.apirestproductos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.repiso.apirestproductos.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Integer>{
   //Convención sobre convicción
    //CrudRepository permite realizar busquedas por campo según la entidad
    Optional<Producto> findByNombre(String nombre);

}
