package com.suncity.dao.cart;

import java.util.List;
import java.util.Map;

import com.suncity.model.cart.Cart;

public interface CartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    int insert(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    int insertSelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    Cart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    int updateByPrimaryKeySelective(Cart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ujn_cart
     *
     * @mbg.generated Wed Mar 08 16:31:06 CST 2017
     */
    int updateByPrimaryKey(Cart record);

	List<Cart> queryCartList(Cart cart);

	List<Cart> queryCartListByMember(Map<String, Object> map);

	Cart selectByProductId(String product_id);
}