package org.zartt.cloud.controller;

import jakarta.annotation.Resource;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.zartt.cloud.entity.PayDTO;
import org.zartt.cloud.resp.ResultData;

import java.util.List;

/**
 * @author: zartt
 * @description: TODO
 */
@RestController
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    //调用对应的地址修改为注册在consul上的值
    public static final String PAYMENT_URL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PAYMENT_URL+"/pay/add", payDTO, ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getById(@PathVariable("id")Integer id){
        return restTemplate.getForObject(PAYMENT_URL+"/pay/get/"+id, ResultData.class);
    }
    @GetMapping("/consumer/pay/getall")
    public ResultData getAll(){
        return restTemplate.getForObject(PAYMENT_URL+"/pay/getall", ResultData.class);
    }
    //TODO 删除和修改
    @GetMapping("/consumer/pay/del/{id}")
    public ResultData delById(@PathVariable("id")Integer id) {
        return restTemplate.getForObject(PAYMENT_URL+"/pay/del/"+id, ResultData.class);
    }
    @GetMapping("/consumer/pay/update")
    public ResultData update(PayDTO payDTO){
        return restTemplate.postForObject(PAYMENT_URL+"/pay/update", payDTO, ResultData.class);
    }

    /**
     * 负载均衡demo 轮询
     *
     * @return {@link String }
     */
    @GetMapping(value = "/consumer/pay/get/info")
    private String getInfoByConsul()
    {
        return restTemplate.getForObject(PAYMENT_URL + "/pay/get/info", String.class);
    }
    @Resource
    private DiscoveryClient discoveryClient;

    /**
     * 获取所有服务
     *
     * @return {@link String }
     */
    @GetMapping("/consumer/discovery")
    public List<ServiceInstance> discovery()
    {
        return discoveryClient.getInstances("cloud-payment-service");
    }
}
