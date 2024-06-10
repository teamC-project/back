package com.back.back.common.object;
import java.util.List;
import java.util.ArrayList;
import com.back.back.common.util.ChangeDateFormatUtil;
import com.back.back.entity.CustomerBoardEntity;
import lombok.Getter;

@Getter
public class CustomerBoardListItem {
    private Integer customerBoardNumber;
    private String customerBoardTitle;
    private String customerBoardWriterId;
    private String customerBoardWriteDatetime;
    private Integer customerBoardViewCount;
    private boolean isSecret;

    private CustomerBoardListItem(CustomerBoardEntity customerBoardEntity) throws Exception {
        String writeDatetime = ChangeDateFormatUtil.changeYYMMDD(customerBoardEntity.getCustomerBoardWriteDatetime());

        String writerId = customerBoardEntity.getCustomerBoardWriterId();
        writerId =
        writerId.substring(0, 1) + 
        "*".repeat(writerId.length() - 1);

        this.customerBoardNumber = customerBoardEntity.getCustomerBoardNumber();
        this.customerBoardTitle = customerBoardEntity.getCustomerBoardTitle();
        this.customerBoardWriterId = writerId;
        this.customerBoardWriteDatetime = writeDatetime;
        this.customerBoardViewCount = customerBoardEntity.getCustomerBoardViewCount();
        this.isSecret = customerBoardEntity.isSecret();
    }

    public static List<CustomerBoardListItem>getList(List<CustomerBoardEntity> customerBoardEntities) throws Exception {
        List<CustomerBoardListItem> customerBoardList = new ArrayList<>();

        for (CustomerBoardEntity customerBoardEntity: customerBoardEntities) {
            CustomerBoardListItem customerBoardListItem = new CustomerBoardListItem(customerBoardEntity);
            customerBoardList.add(customerBoardListItem);
        }

        return customerBoardList;
    }
}
