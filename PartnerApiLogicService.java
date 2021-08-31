package com.koreait.day4.service;

import com.koreait.day4.ifs.CrudInterface;
import com.koreait.day4.model.entity.Partner;
import com.koreait.day4.model.network.Header;

import com.koreait.day4.model.network.request.UserApiRequest;

import com.koreait.day4.model.network.response.UserApiResponse;
import com.koreait.day4.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service // 서비스레이어, 내부에서 자바로직을 처리함
@RequiredArgsConstructor
public class PartnerApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }
}
