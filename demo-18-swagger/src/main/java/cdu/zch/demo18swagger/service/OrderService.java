package cdu.zch.demo18swagger.service;

import cdu.zch.demo18swagger.entity.Order;
import cdu.zch.demo18swagger.utils.CommonResult;

import java.util.List;

/**
 * @author Zch
 * @data 2023/5/16
 **/
public interface OrderService {

    /**
     * 保存订单
     *
     * @param order 订单参数
     * @return CommonResult<Order>
     */
    CommonResult<Order> saveOrder(Order order);

    /**
     * 查询所有订单
     *
     * @return CommonResult<List<Order>>
     */
    CommonResult<List<Order>> findOrderAll();

    /**
     * 根据id更新订单
     *
     * @param order 订单参数
     * @return CommonResult<Order>
     */
    CommonResult<Order> updateOrderById(Order order);

    /**
     * 根据id删除订单
     *
     * @param id 订单id
     * @return CommonResult<Order>
     */
    CommonResult<Order> deleteOrderById(Long id);

}
