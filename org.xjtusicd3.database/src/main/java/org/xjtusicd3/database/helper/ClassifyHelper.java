package org.xjtusicd3.database.helper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.xjtusicd3.database.logic.SqlSessionManager;
import org.xjtusicd3.database.mapper.ClassifyPersistenceMapper;
import org.xjtusicd3.database.model.ClassifyPersistence;
import org.xjtusicd3.database.model.QuestionPersistence;


public class ClassifyHelper {
	/*
	 * spider_分类的添加
	 */
	public static void save(ClassifyPersistence classifyPersistence) throws Exception{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		mapper.save(classifyPersistence);
		session.close();
	}
	/*
	 * spider_按照分类名称查找
	 */
	public static List<ClassifyPersistence> spider_ClassifyListByName(String ClassifyName,String parentId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.spider_ClassifyListByName(ClassifyName,parentId);
		session.close();
		return list;
	}
	/*
	 * robot-分类
	 */
	public static List<ClassifyPersistence> classifyName1(){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.FirstClassify_robot();
		session.close();
		return list;
	}
	public static List<ClassifyPersistence> classifyName2(String ParentId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.SecondClassify_robot(ParentId);
		session.close();
		return list;
	}

	/*
	 * faq、faq1_上侧的第二级分类
	 */
	public static List<ClassifyPersistence> faq1_ClassifyName(String parentId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.SecondClassify_robot2(parentId);
		session.close();
		return list;
	}
	/*
	 * faq1_下面4栏推荐_按照浏览量
	 */
	public static List<ClassifyPersistence> faq1_SecondClassify(String parentId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.faq1_SecondClassify(parentId);
		session.close();
		return list;
	}
	public static List<QuestionPersistence> faq1_faqPersistences(String faqClassify){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<QuestionPersistence> list = mapper.faq1_faqPersistences(faqClassify);
		session.close();
		return list;
	}
	public static List<QuestionPersistence> faq1_faqPersistences2(String faqClassify){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<QuestionPersistence> list = mapper.faq1_faqPersistences2(faqClassify);
		session.close();
		return list;
	}
	/*
	 * faq2_获取第二类分类的名称、第一类分类的名称
	 */
	public static List<ClassifyPersistence> faq2_classify(String ClassifyId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.faq2_classify(ClassifyId);
		session.close();
		return list;
	}
	public static String faq2_classifyParentId(String ClassifyId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		String classifyParentId = mapper.faq2_classifyParentId(ClassifyId);
		session.close();
		return classifyParentId;
	}
	/*
	 * zyq_question_查看问答模块的分类
	 * 
	 *  ClassifyName   type
	 *  
	 *  List<ClassifyPersistence>
	 */
	public static List<ClassifyPersistence> question_ClassifyListByName(String ClassifyName,String type)
	{
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.question_ClassifyListByName(ClassifyName,type);
		session.close();
		return list;
	}
	/*
	 * zpz_查看分类的第二子类
	 */
	public static List<ClassifyPersistence> SecondClassify_total(String parentId){
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.SecondClassify_total(parentId);
		session.close();
		return list;
	}
	
	/**
	 * author:zzl
	 * abstract:获取当前问题分类的上一级分类
	 * data:2017年9月15日09:58:36
	 */
	public static String faq_parentId(String faq_classifyId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		String classifyParentId = mapper.faq_parentId(faq_classifyId);
		session.close();
		return classifyParentId;
	}
	/**
	 * author:zzl
	 * abstract:获取该父分类下的所有子分类
	 * data:2017年9月15日10:07:11
	 */
	public static List<ClassifyPersistence> faq_classifyIds(String parentId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.faq_classifyIds(parentId);
		session.close();
		return list;
	}
	
	/**
	 * author:zzl
	 * abstract:获取一级分类信息
	 * data:2017年9月17日19:33:19
	 */
	public static List<ClassifyPersistence> getInfoById(String classifyId) {
		SqlSession session = SqlSessionManager.getSqlSessionFactory().openSession(true);
		ClassifyPersistenceMapper mapper = session.getMapper(ClassifyPersistenceMapper.class);
		List<ClassifyPersistence> list = mapper.getInfoById(classifyId);
		session.close();
		return list;
	}
	

	
	
}
