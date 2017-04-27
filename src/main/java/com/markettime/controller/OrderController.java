package com.markettime.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.markettime.aop.LoggedIn;
import com.markettime.model.dto.DetailedOrderDto;
import com.markettime.model.dto.OrderDto;
import com.markettime.model.dto.ProductDto;
import com.markettime.model.dto.ShippingDto;

/**
 *
 * @author Radu Cosma
 *
 */
@Controller
@RequestMapping("orders")
public class OrderController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    /**
     *
     * @return
     */
    @LoggedIn
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getOrders() {
        return new ModelAndView("orders", "orders", createOrdersList());
    }

    /**
     *
     * @param orderId
     * @return
     */
    @LoggedIn
    @RequestMapping(method = RequestMethod.GET, value = "{orderId}")
    public ModelAndView getOrder(@PathVariable("orderId") int orderId) {

        LOGGER.info("started getOrder[orderId: {}]", orderId);

        DetailedOrderDto order = createOrder(orderId);
        LOGGER.info("completed getOrder; returned: {}", order);
        return new ModelAndView("order-details", "order", order);
    }

    private List<OrderDto> createOrdersList() {
        List<OrderDto> orders = new ArrayList<>();
        OrderDto order = new OrderDto();
        order.setId(1);
        order.setDate(new Date());
        order.setMarketplace("marketplace 1");
        order.setStatus("status 1");
        order.setTotal(new BigDecimal(11.11));
        orders.add(order);
        order = new OrderDto();
        order.setId(2);
        order.setDate(new Date());
        order.setMarketplace("marketplace 2");
        order.setStatus("status 2");
        order.setTotal(new BigDecimal(22.22));
        orders.add(order);
        order = new OrderDto();
        order.setId(3);
        order.setDate(new Date());
        order.setMarketplace("marketplace 3");
        order.setStatus("status 3");
        order.setTotal(new BigDecimal(33.33));
        orders.add(order);
        return orders;
    }

    private DetailedOrderDto createOrder(int orderId) {
        DetailedOrderDto order = new DetailedOrderDto();
        order.setId(orderId);
        ProductDto product = new ProductDto();
        product.setName("product name");
        product.setDescription("description");
        product.setTags("tag1, tag2, tag3");
        product.setShipping("shipping");
        product.setShippingTime("shipping time");
        product.setColor("color");
        product.setSize("size");
        product.setInventory("inventory");
        product.setPrice("price");
        product.setBrand("brand");
        product.setLandingPageUrl("presentation page url");
        product.setUpc("upc");
        product.setMarketplace("marketplace");
        order.setProduct(product);
        ShippingDto shippingInfo = new ShippingDto();
        shippingInfo.setFirstName("First");
        shippingInfo.setLastName("Last");
        shippingInfo.setAddress("address");
        shippingInfo.setEmail("email");
        shippingInfo.setPhoneNumber("112222233211");
        order.setShippingInfo(shippingInfo);
        order.setTransactionId(123);
        order.setTransactionDate(new Date());
        order.setTransactionStatus("transaction status");
        order.setQuantity(2);
        order.setShippingCost(new BigDecimal(20.00));
        order.setTotal(new BigDecimal(110.00));
        return order;
    }
}
