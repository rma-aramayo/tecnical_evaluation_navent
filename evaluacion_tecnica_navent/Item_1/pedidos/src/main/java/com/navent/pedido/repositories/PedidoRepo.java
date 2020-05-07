package com.navent.pedidos.repositories;

import com.navent.orders.models.Pedido;

public class PedidoRepo implements Repository {

    private PedidosDAO pedidosDao;
    private BumexMemcached bumexMemcached;

    public PedidoRepo(PedidosDAO pedidosDao, BumexMemcached bumexMemcached) {
        this.pedidosDao = pedidosDao;
        this.bumexMemcached = bumexMemcached;
    }

    @Override
    public Pedido get(Integer id) {
        Object pedidoCache = bumexMemcached.get(id.toString());
        if(pedidoCache != null) {
            return (Pedido) pedidoCache;
        }
        Pedido pedido = pedidosDao.select(id);
        if(pedido != null){
            bumexMemcached.set(id.toString(), pedido);
            return pedido;
        }
        return null;
    }

    @Override
    public Pedido create(Pedido pedido) {
        pedidosDao.insertOrUpdate(pedido);
        return pedido;
    }

    @Override
    public Pedido update(Pedido pedido) {
        pedidosDao.insertOrUpdate(pedido);
        Object pedidosCache = bumexMemcached.get(pedido.getIdPedido().toString());
        if(pedidosCache != null){
            bumexMemcached.set(pedido.getIdPedido().toString(), pedido);
        }
        return pedido;
    }

    @Override
    public void delete(int id) {
        Pedido pedido = new Pedido(id);
        pedidosDao.delete(pedido);
        Object pedidosCache = bumexMemcached.get(pedido.getIdPedido().toString());
        if(pedidosCache != null){
            bumexMemcached.delete(pedido.getIdPedido().toString());
        }

    }
}

