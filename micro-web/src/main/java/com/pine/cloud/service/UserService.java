package com.pine.cloud.service;

import com.pine.cloud.bean.ConsultContent;
import rx.Observable;

import java.util.List;
import java.util.concurrent.Future;

public interface UserService {
    List<ConsultContent> queryContents();

    Future<String> queryContentsAsyn();

    List<ConsultContent> queryContent();

    String queryMonitor();

    public Observable<String> mergeResult();
}
