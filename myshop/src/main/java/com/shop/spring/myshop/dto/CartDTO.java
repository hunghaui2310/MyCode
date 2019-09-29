package com.shop.spring.myshop.dto;

import java.util.ArrayList;
import java.util.List;

public class CartDTO {

    private int orderNum;

    private CustomInfoDTO customInfoDTO;

    private final List<CartLineInfoDTO> cartLine = new ArrayList<CartLineInfoDTO>();

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public CustomInfoDTO getCustomInfoDTO() {
        return customInfoDTO;
    }

    public void setCustomInfoDTO(CustomInfoDTO customInfoDTO) {
        this.customInfoDTO = customInfoDTO;
    }

    public List<CartLineInfoDTO> getCartLine() {
        return cartLine;
    }
}
