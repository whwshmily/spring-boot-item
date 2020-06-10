package com.whw.dao;

import com.whw.domain.Cart;
import com.whw.domain.Category;
import com.whw.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryDao {
    @Select("SELECT CATEGORY_ID,NAME,TURN,DESCRIPTION,PARENT_ID FROM BOOK_CATEGORY WHERE PARENT_ID = #{parentId}")
    List<Category> findByParentId(int parentId);

    @Select("SELECT CATEGORY_ID,NAME,TURN,DESCRIPTION,PARENT_ID FROM BOOK_CATEGORY WHERE CATEGORY_ID = #{id}")
    Category findById(int id);

    @Select("SELECT * FROM BOOK_PRODUCT WHERE CATEGORY_ID = #{categoryId} ORDER BY ${orderByName} ${sortType}")
    List<Product> findByCategoryIdAndSort(
            @Param("categoryId") int categoryId,
            @Param("orderByName") String orderByName,
            @Param("sortType") String sortType);

    @Select("SELECT * FROM BOOK_PRODUCT WHERE KEYWORDS LIKE ${content}")
    List<Product> findByLikeSearch(@Param("content") String content);

    @Select("SELECT * FROM BOOK_PRODUCT WHERE PRODUCT_ID = #{id}")
    Product findByProductId(int id);
    @Select("SELECT CART_ID,PRODUCT_ID,USER_ID,PRODUCT_NUM FROM BOOK_CART WHERE USER_ID = #{userId}")
    @Results(id = "result",
            value = {@Result(property = "cart_id" ,column = "cart_id"),
                     @Result(property = "user_id",column = "user_id"),
                     @Result(property = "product_num",column = "product_num"),
                     @Result(property = "product",column = "product_id" ,one = @One(select = "findByProductId"))
            }
    )
    List<Cart> findByUserId(int userId);
    @Update("UPDATE BOOK_CART SET PRODUCT_NUM = #{product_num} WHERE CART_ID = #{cart_id}")
    int updateByCartId(Cart cart);
    @Delete("DELETE FROM BOOK_CART WHERE USER_ID = #{userId} AND product_id = #{product_id}")
    int deleteByUserIdAndProduct(@Param("userId")int userId,@Param("product_id")int product_id);
    @Delete("DELETE FROM BOOK_CART WHERE USER_ID = #{userId}")
    int deleteByUserId(int userId);
    @Insert("INSERT INTO BOOK_CART (PRODUCT_ID,USER_ID,PRODUCT_NUM) VALUES(#{product.product_id},#{user_id},#{product_num})")
    int insertCart(Cart cart);
    @Select("SELECT CART_ID,PRODUCT_ID,USER_ID,PRODUCT_NUM FROM BOOK_CART WHERE USER_ID = #{userId} AND product_id = #{product_id}")
    @ResultMap("result")
    Cart findByUserIdAndProductId(@Param("userId")int userId,@Param("product_id")int product_id);
}
