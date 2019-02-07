package selab.swv.project.dao;

import java.util.List;

import selab.swv.project.dto.ProjectVO;

public interface ProjectDAO {
	public List<ProjectVO> selectProject() throws Exception;
}
