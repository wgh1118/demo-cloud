package com.wanggh.cloud.es.repository;

import com.wanggh.cloud.es.entity.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends ElasticsearchRepository<User, String> {

}