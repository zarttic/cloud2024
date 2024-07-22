package org.zartt.cloud.entities;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 表名：t_order
*/
@Getter
@Table(name = "t_order")
@ToString
public class Order  implements Serializable {
    /**
     * -- GETTER --
     *
     * @return id
     */
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;

    /**
     * 用户id
     * -- GETTER --
     *  获取用户id
     *
     * @return userId - 用户id

     */
    @Column(name = "user_id")
    private Long userId;

    /**
     * 产品id
     * -- GETTER --
     *  获取产品id
     *
     * @return productId - 产品id

     */
    @Column(name = "product_id")
    private Long productId;

    /**
     * 数量
     * -- GETTER --
     *  获取数量
     *
     * @return count - 数量

     */
    private Integer count;

    /**
     * 金额
     * -- GETTER --
     *  获取金额
     *
     * @return money - 金额

     */
    private Long money;

    /**
     * 订单状态: 0:创建中; 1:已完结
     * -- GETTER --
     *  获取订单状态: 0:创建中; 1:已完结
     *
     * @return status - 订单状态: 0:创建中; 1:已完结

     */
    private Integer status;

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    /**
     * 设置数量
     *
     * @param count 数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 设置金额
     *
     * @param money 金额
     */
    public void setMoney(Long money) {
        this.money = money;
    }

    /**
     * 设置订单状态: 0:创建中; 1:已完结
     *
     * @param status 订单状态: 0:创建中; 1:已完结
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}