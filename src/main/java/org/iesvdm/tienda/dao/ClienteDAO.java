package org.iesvdm.tienda.dao;

import org.iesvdm.tienda.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {



    public List<Cliente> getAll();


    public void update(Cliente cliente);


}
