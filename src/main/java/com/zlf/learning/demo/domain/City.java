package com.zlf.learning.demo.domain;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName City
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/7/26 17:55
 * @Version 1.0
 */
@Getter
@Setter
public class City {

    private Long id;
    private Long provinceId;
    private String cityName;
    private String description;
}
