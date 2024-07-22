package org.zartt.cloud.apis;

import org.springframework.stereotype.Component;
import org.zartt.cloud.resp.ResultData;
import org.zartt.cloud.resp.ReturnCodeEnum;

/**
 * @author: zartt
 * @description: TODO
 */
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public ResultData getPayByOrderNo(String orderNo)
    {
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(),"对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}
