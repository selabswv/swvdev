package selab.swv.project.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import selab.swv.project.dto.ProjectVO;

@Repository
public class ProjectDAOImpl implements ProjectDAO {

	private static final Logger logger = LoggerFactory.getLogger(ProjectDAOImpl.class);
	@Inject
	private SqlSession sqlSession;
	
	private static final String Namespace = "selab.swv.mapper.selectMapper";

	@Override
	public List<ProjectVO> selectProject() throws Exception {
		
		
		return sqlSession.selectOne(Namespace+".selectProject");
	}

}
