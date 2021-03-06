package com.suncity.dao.order;

import java.util.List;
import java.util.Map;

import com.suncity.model.order.Order;

public interface OrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    int insert(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    int insertSelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    Order selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    int updateByPrimaryKeySelective(Order record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_order
     *
     * @mbg.generated Wed Mar 08 16:48:14 CST 2017
     */
    int updateByPrimaryKey(Order record);

	List<Order> queryOrderList(Order order);

	List<Order> queryOrderListByType(Order order);

	List<Order> queryOrderListByMember(Map<String, Object> map);
}