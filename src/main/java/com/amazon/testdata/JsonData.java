package com.amazon.testdata;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {

    private String Menu;
    private String SubMenu;
    private String Checkbox;
    private String BrandName;
    private String Filter;
    private String Section;
    private int ElementAt;

}
