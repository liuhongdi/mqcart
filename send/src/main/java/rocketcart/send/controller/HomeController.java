package rocketcart.send.controller;

import com.alibaba.fastjson.JSON;
import rocketcart.send.pojo.CartMsg;
import rocketcart.send.rocket.Producer;
import rocketcart.send.rocket.RocketConstants;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private Producer producer;

    //初始化并发送消息
    @RequestMapping("/send")
    public String send() throws Exception {
        //要删除的购物车的id
        List<Integer> cartList = new ArrayList<Integer>();
        cartList.add(1);
        cartList.add(2);
        cartList.add(3);
        //消息
        CartMsg msg = new CartMsg();
        msg.setUserId(1);
        msg.setCartList(cartList);

        String msgJson = JSON.toJSONString(msg);
        //生成一个信息，标签在这里手动指定
        Message message = new Message(RocketConstants.TOPIC, "carttag", msgJson.getBytes());
        //发送信息
        SendResult sendResult = producer.getProducer().send(message);
        System.out.println("生产者已发送一条信息，内容={"+sendResult+"}");

        return "success";
    }
}
