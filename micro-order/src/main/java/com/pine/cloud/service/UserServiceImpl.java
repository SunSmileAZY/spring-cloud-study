package com.pine.cloud.service;

import com.pine.cloud.bean.ConsultContent;
import com.pine.cloud.dao.CommonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

//	@Autowired
//	CommonMapper mapper;

	@Override
	public List<ConsultContent> queryContent() {
//		return mapper.queryContent(new HashMap());
		return null;
	}
}
