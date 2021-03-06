package com.line.ticket.service.mybatis;

import com.line.ticket.common.util.JsonTool;
import com.line.ticket.service.mapper.DemoMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

@Slf4j
public class MybatisMain {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-factory.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            DemoMapper demoMapper = sqlSession.getMapper(DemoMapper.class);
            log.info("demoMapper:{}", JsonTool.toJSONString(demoMapper.selectDemo(1)));
        }
        log.info("result");
    }
}
