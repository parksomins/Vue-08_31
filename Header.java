package com.koreait.day4.model.network;

import com.koreait.day4.model.entity.OrderGroup;
import com.koreait.day4.model.network.response.ItemApiResponse;
import com.koreait.day4.model.network.response.OrderGroupApiResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Header<T> {

    // api 통신시간
    private LocalDateTime transactionTime;
    // api 응답코드
    private String resultCode;
    // api 설명
    private String description;

    private T data;

    private Pagination pagination;

    // Ok
    public static <T> Header<T> OK(){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .build();
    }

    // Data
    public static <T> Header<T> OK(T data){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .build();
    }

    public static <T> Header<T> OK(T data, Pagination pagination){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("OK")
                .description("OK")
                .data(data)
                .pagination(pagination)
                .build();
    }


    // error
    public static <T> Header<T> ERROR(String description){
        return (Header<T>)Header.builder()
                .transactionTime(LocalDateTime.now())
                .resultCode("ERROR")
                .description("ERROR")
                .build();
    }
}
