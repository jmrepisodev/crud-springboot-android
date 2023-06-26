package com.repiso.apirestproductos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repiso.apirestproductos.model.Producto;
import com.repiso.apirestproductos.repository.ProductoRepository;
import com.repiso.apirestproductos.service.ProductoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductoController {

    //Inyecta automáticamente la clase servicio cuando sea necesario
    @Autowired  
    ProductoService productoService;  

    @GetMapping("/productos")
    public List<Producto> getAllProducts(){
        return productoService.getAllProducts();
    }

    @GetMapping("/producto/{id}")
    public Optional<Producto> getProductoById(@PathVariable("id") int id){
        return productoService.getProductoById(id);
    }

    @GetMapping("/producto/{nombre}")
     public Optional<Producto> getProductoByNombre(@PathVariable("nombre") String nombre){
        return productoService.getProductoByNombre(nombre);
    }

    @PostMapping("/producto")
    public void saveProducto(@RequestBody @Valid Producto producto){
        productoService.saveProducto(producto);
    }

    @DeleteMapping("/producto/{id}")
    public void deleteProducto(@PathVariable int id){
        productoService.deleteProducto(id);
    }

    @PutMapping("/producto/{id}")
    public void updateProducto(@PathVariable("id") int id, @RequestBody @Valid Producto dto){

        Producto producto=productoService.getProductoById(id).get();
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());

        productoService.updateProducto(producto);
    }



    
}
