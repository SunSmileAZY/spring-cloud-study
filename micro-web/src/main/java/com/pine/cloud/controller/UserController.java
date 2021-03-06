package com.pine.cloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.strategy.concurrency.HystrixRequestContext;
import com.pine.cloud.bean.ConsultContent;
import com.pine.cloud.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;
import rx.Observer;
import rx.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @RequestMapping("/queryUser")
    public List<ConsultContent> queryUser() {
        return userService.queryContents();
    }

    @RequestMapping("/queryContent")
    public List<ConsultContent> queryContent() {
        return userService.queryContent();
    }

    @RequestMapping("/queryContentsAsync")
    public String queryContentsAsync() {
        Future<String> stringFuture = userService.queryContentsAsyn();
        try {
            String cacheResult = stringFuture.get();

            return cacheResult;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/mergeResult")
    public String mergeResult() {
        Observable<String> observer = userService.mergeResult();
        final List<String> result = new ArrayList<String>();

        final CountDownLatch c = new CountDownLatch(1);

        Subscription subscribe = observer.subscribe(new Observer<String>() {

            @Override
            public void onCompleted() {
                String resultstr = JSONObject.toJSONString(result);
                log.info(resultstr);
                log.info("==========onCompleted be invoke===========");
                c.countDown();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String t) {
                result.add(t);
                log.info("==========onNext be invoke===========" + t);
            }
        });

        try {
            c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return JSONObject.toJSONString(result);
    }

    @RequestMapping("/queryMonitor")
    public String queryMonitor() {
        return userService.queryMonitor();
    }

    @RequestMapping("/loadBalancerClient")
    public String loadBalancerClient() {
        ServiceInstance choose = loadBalancerClient.choose("micro-order");
        log.info("====ServiceInstance:instanceId->" + choose.getInstanceId());
        log.info("====ServiceInstance:serviceId->" + choose.getServiceId());
        log.info("====ServiceInstance:ip@port@uri->" + choose.getHost()+"@"+choose.getPort()+"@"+choose.getUri());
        StringBuffer b = new StringBuffer();
        b.append("====ServiceInstance:serviceId->" + choose.getServiceId()).
                append("====ServiceInstance:serviceId->" + choose.getServiceId())
                .append("====ServiceInstance:ip@port@uri->" + choose.getHost()+"@"+choose.getPort()+"@"+choose.getUri());
        return b.toString();
    }

    // 能否访问数据库的标识
    public static boolean canVisitDb = true;

    @RequestMapping(value = "/db/{can}", method = RequestMethod.GET)
    public void setDb(@PathVariable boolean can) {
        canVisitDb = can;
    }


    @RequestMapping("/test/hystrixCollapser")
    public void test() throws ExecutionException, InterruptedException {
        //开启上下文TheardLocal
        HystrixRequestContext context = HystrixRequestContext.initializeContext();
        Future<String> demo1 = userService.test("a");
        Future<String> demo2 = userService.test("b");
        System.out.println(demo1.get());
        System.out.println(demo2.get());
        context.close();
    }
}
