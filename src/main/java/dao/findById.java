package dao;

import bean.student;
import org.apache.ibatis.session.SqlSession;
import util.MybatisUtil;

public class findById {
    public student find(int id) throws Exception
    {
        SqlSession sqlSession=MybatisUtil.getSqlSession();
        try{
            return sqlSession.selectOne("studentNameSpace.findById",id);

        }catch (Exception e)
        {
            e.printStackTrace();
            sqlSession.rollback();
            throw e;
        }finally {
            MybatisUtil.closeSqlSession();
        }
    }
    public static void main(String[] args) throws Exception
    {
        findById find =new findById();
        student student=find.find(1);
        System.out.println(student.getId()+"   "+student.getCard().getNum()+"     "+student.getName());
    }
}
