package cn.coder.tacos.message;

import cn.coder.tacos.domain.Order;

public interface OrderMessagingService {
    void sendOrder(Order order);
}
