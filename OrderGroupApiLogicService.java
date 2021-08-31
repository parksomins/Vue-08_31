package com.koreait.day4.service;

import com.koreait.day4.ifs.CrudInterface;
import com.koreait.day4.model.entity.OrderGroup;
import com.koreait.day4.model.entity.Users;
import com.koreait.day4.model.enumclass.OrderType;
import com.koreait.day4.model.network.Header;
import com.koreait.day4.model.network.Pagination;
import com.koreait.day4.model.network.request.OrderGroupApiRequest;
import com.koreait.day4.model.network.request.UserApiRequest;
import com.koreait.day4.model.network.response.OrderGroupApiResponse;
import com.koreait.day4.model.network.response.UserApiResponse;
import com.koreait.day4.repository.OrderGroupRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.criterion.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service // 서비스레이어, 내부에서 자바로직을 처리함
@RequiredArgsConstructor
public class OrderGroupApiLogicService extends BaseService<OrderGroupApiRequest, OrderGroupApiResponse, OrderGroup> {

    @Override
    public Header<OrderGroupApiResponse> create(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
        return null;
    }

    @Override
    public Header<OrderGroupApiResponse> delete(Long id) {
        return null;
    }

    public OrderGroupApiResponse response(OrderGroup orderGroup){
        OrderGroupApiResponse orderGroupApiResponse = OrderGroupApiResponse.builder()
                .id(orderGroup.getId())
                .status(orderGroup.getStatus())
                .orderType(orderGroup.getOrderType())
                .revAddress(orderGroup.getRevAddress())
                .revName(orderGroup.getRevName())
                .paymentType(orderGroup.getPaymentType())
                .totalPrice(orderGroup.getTotalPrice())
                .totalQuantity(orderGroup.getTotalQuantity())
                .orderAt(orderGroup.getOrderAt())
                .arrivalDate(orderGroup.getArrivalDate())
                .build();
        return orderGroupApiResponse;
    }
    public Header<List<OrderGroupApiResponse>> search(Pageable pageable){
        Page<OrderGroup> orderGroups = baseRepository.findAll(pageable);
        List<OrderGroupApiResponse> orderGroupApiResponseList = orderGroups.stream()
                .map(orderGroup->response(orderGroup))
                .collect(Collectors.toList());
        Pagination pagination = Pagination.builder()
                .totalPages(orderGroups.getTotalPages())
                .totalElements(orderGroups.getTotalElements())
                .currentPage(orderGroups.getNumber())
                .currentElements(orderGroups.getNumberOfElements())
                .build();
        return Header.OK(orderGroupApiResponseList, pagination);
    }
}