package com.test.bean;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
public class GoogleGeoCodeResponse {

    private List<Result> results;
    private String status;

}
