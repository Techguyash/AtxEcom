package com.atx.atxecom.services;

import com.atx.atxecom.dto.orders.OrderItemsDto;
import com.atx.atxecom.dto.orders.OrdersDTO;
import com.atx.atxecom.entity.*;
import com.atx.atxecom.exception.DataMismatchException;
import com.atx.atxecom.exception.NoDataFoundException;
import com.atx.atxecom.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author ashiq
 * @createdOn 16/03/25 12:40 pm
 * @project AtxEcom
 **/
@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService
{
    private final OrderRepo orderRepo;
    private final ModelMapper modelMapper;
    private final AppUserRepo appUserRepo;
    private final AddressRepo addressRepo;
    private final ProductRepo productRepo;
    private final OrderItemsRepo orderItemsRepo;


    @Override
    public OrdersDTO createOrder(OrdersDTO ordersDTO)
    {
        Orders entityTobeSaved = modelMapper.map(ordersDTO, Orders.class);
        AppUser orderedUser = appUserRepo.findById(ordersDTO.getUserId()).orElseThrow(
                () -> new NoDataFoundException("User Not Found"));
        Address orderedAddress = addressRepo.findById(ordersDTO.getAddressId()).orElseThrow(
                () -> new NoDataFoundException("Address Not Found"));
        List<OrderItemsDto> orderItems = ordersDTO.getOrderItems();

        entityTobeSaved.setUserId(orderedUser);
        entityTobeSaved.setShippingAddress(orderedAddress);
        entityTobeSaved.setOrderDate(LocalDateTime.now());
        double calculatedCartValue=0;
        for(OrderItemsDto orderItem : orderItems)
        {
            calculatedCartValue+=orderItem.quantity()*orderItem.unitPrice();
        }
        //INFO : verifying the cart value
        if(ordersDTO.getCartValue()!=calculatedCartValue)
        {
            throw new DataMismatchException("Total Cart Value Not Matched with Order Items");
        }
        entityTobeSaved.setCartValue(calculatedCartValue);
        Orders savedOrder = orderRepo.save(entityTobeSaved);
        for(OrderItemsDto itemsDto:orderItems)
        {
            Long productId = itemsDto.productId();
            Product foundProduct =
                    productRepo.findById(productId).orElseThrow(() -> new NoDataFoundException("Product Not Found"));
            OrderItems orderItem=new OrderItems();
            modelMapper.map(itemsDto, orderItem);
            orderItem.setProduct(foundProduct);
            orderItem.setOrders(savedOrder);
            orderItem.setTotalPrice(itemsDto.quantity() * itemsDto.unitPrice());
            orderItemsRepo.save(orderItem);
        }
        return modelMapper.map(ordersDTO, OrdersDTO.class);

    }

    @Override
    public OrdersDTO updateOrder(OrdersDTO ordersDTO)
    {
        return null;
    }

    @Override
    public OrdersDTO getOrderById(Long id)
    {
        return null;
    }

    @Override
    public OrdersDTO getOrdersByUserId(Long userId)
    {
        return null;
    }
}
