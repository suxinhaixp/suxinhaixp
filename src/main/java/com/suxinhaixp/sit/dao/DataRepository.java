package com.suxinhaixp.sit.dao;

//123
import com.suxinhaixp.sit.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface DataRepository extends JpaRepository<Data,Integer> {

@Query(value = "select SUM(product_quantity) as sellnumber,product_name from order_detail a,order_master b where  a.order_id=b.order_id and order_status=0 and convert(a.create_time,char)  like ? GROUP BY product_id",nativeQuery = true)
     List<Data> getselled(String create_time);
}
