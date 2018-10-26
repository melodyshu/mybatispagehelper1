package com.fx;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory= new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession= sqlSessionFactory.openSession();
        CityMapper cityMapper= sqlSession.getMapper(CityMapper.class);
        PageHelper.startPage(3,5);
        List<City> cityList = cityMapper.selectAll();
        System.out.println(cityList);
        PageInfo<City> pageInfo=new PageInfo<City>(cityList);
        System.out.println("总数:"+pageInfo.getTotal());
        System.out.println("页数:"+pageInfo.getPages());
        System.out.println("每页数:"+pageInfo.getPageSize());

        //System.out.println(pageInfo);
        //System.out.println(pageInfo.getList());
        sqlSession.close();
    }
}
