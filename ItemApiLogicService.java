package com.koreait.day4.service;

import com.koreait.day4.ifs.CrudInterface;
import com.koreait.day4.model.entity.Item;
import com.koreait.day4.model.entity.OrderGroup;
import com.koreait.day4.model.entity.Users;
import com.koreait.day4.model.enumclass.ItemStatus;
import com.koreait.day4.model.network.Header;
import com.koreait.day4.model.network.Pagination;
import com.koreait.day4.model.network.request.ItemApiRequest;
import com.koreait.day4.model.network.request.UserApiRequest;
import com.koreait.day4.model.network.response.ItemApiResponse;
import com.koreait.day4.model.network.response.OrderGroupApiResponse;
import com.koreait.day4.model.network.response.UserApiResponse;
import com.koreait.day4.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service  // 서비스레이어, 내부에서 자바로직을 처리함
@RequiredArgsConstructor
public class ItemApiLogicService extends BaseService<ItemApiRequest, ItemApiResponse, Item> {

    private final ItemRepository itemRepository;

    @Override
    public Header<ItemApiResponse> create(Header<ItemApiRequest> request) {
        ItemApiRequest itemApiRequest = request.getData();
        Item item =Item.builder()
                .name(itemApiRequest.getName())
                .status(ItemStatus.REGISTERED)
                .title(itemApiRequest.getTitle())
                .content(itemApiRequest.getContent())
                .price(itemApiRequest.getPrice())
                .build();
        Item newItem = itemRepository.save(item);
        return Header.OK(response(newItem));
    }

    @Override
    public Header<ItemApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
        return null;
    }

    @Override
    public Header<ItemApiResponse> delete(Long id) {
        return null;
    }

    public ItemApiResponse response(Item item){
        ItemApiResponse itemApiResponse = ItemApiResponse.builder()
                .id(item.getId())
                .name(item.getName())
                .title(item.getTitle())
                .content(item.getContent())
                .price(item.getPrice())
                .regDate(item.getRegDate())
                .build();
        return itemApiResponse;
    }

    public Header<List<ItemApiResponse>> search(Pageable pageable){
        Page<Item> item = baseRepository.findAll(pageable);
        List<ItemApiResponse> itemApiResponseList = item.stream()
                .map(items -> response(items))
                .collect(Collectors.toList());

        Pagination pagination = Pagination.builder()
                .totalPages(item.getTotalPages())
                .totalElements(item.getTotalElements())
                .currentPage(item.getNumber())
                .currentElements(item.getNumberOfElements())
                .build();

        return Header.OK(itemApiResponseList, pagination);
    }
}


