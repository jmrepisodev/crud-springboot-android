package com.repiso.apirestproductos.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repiso.apirestproductos.model.Producto;
import com.repiso.apirestproductos.repository.ProductoRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    public List<Producto> getAllProducts(){
        return productoRepository.findAll();
    }

    public Optional<Producto> getProductoById(int id){
        return productoRepository.findById(id);
    }

     public Optional<Producto> getProductoByNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public void saveProducto(Producto producto){
        productoRepository.save(producto);
    }

    public void deleteProducto(int id){
        productoRepository.deleteById(id);
    }

    public void updateProducto(Producto producto){
        productoRepository.save(producto);
    }


    






    
}
