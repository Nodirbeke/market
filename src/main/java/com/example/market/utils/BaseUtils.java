
package com.example.market.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.client.RestTemplate;

@Getter
@Setter
public class BaseUtils {

    public static final String CREATE_PATH = "create";
    public static final String UPDATE_PATH = "update";
    public static final String DELETE_PATH = "delete/{id}";
    public static final String GET_PATH = "get/{id}";
    public static final String LIST_PATH = "list";

}
