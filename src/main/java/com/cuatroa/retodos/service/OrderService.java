package com.cuatroa.retodos.service;

import com.cuatroa.retodos.model.Order;
import com.cuatroa.retodos.repository.OrderRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JGil Version 1
 */
@Service
public class OrderService {

    /**
     * creación de variable de tipo Repositorio con la anotación
     */
    @Autowired
    private OrderRepository orderRepository;

    /**
     * metodo para obtener todos los datos de la tabla
     *
     * @return List de clase
     */
    public List<Order> getAll() {
        return orderRepository.getAll();
    }

    /**
     * metodo para obtener dato de la tabla reservaciones por Id
     *
     * @param id
     * @return Optional de clase
     */
    public Optional<Order> getOrder(int id) {
        return orderRepository.getOrder(id);
    }

    /**
     * metodo para registrar valores en la tabla reservaciones
     *
     * @param order
     * @return valor de clase
     */
    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return orderRepository.create(order);
        }
    }

    /**
     * metodo para registrar valores en la tabla reservaciones
     *
     * @param order
     * @return valor de clase
     */
    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = orderRepository.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                orderRepository.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    /**
     * metodo para borrar un dato de la tabla Reservaciones por Id
     * @param id
     * @return boolean
     */
    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            orderRepository.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    /**
     * Metodo para adquirir status
     * @param zona
     * @return List
     */
    public List<Order> findByZone(String zona) {
        return orderRepository.findByZone(zona);
    }

    /**
     * Metodo para el reporte de tiempo
     * @param dateStr
     * @param id
     * @return ordersSales
     */
    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return orderRepository.ordersSalesManByDate(dateStr, id);
    }

    /**
     * Metodo para el reporte de tiempo
     * @param state
     * @param id
     * @return ordersSales
     */
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return orderRepository.ordersSalesManByState(state, id);
    }
}
