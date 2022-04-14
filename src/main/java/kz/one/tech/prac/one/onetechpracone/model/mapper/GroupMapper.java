package kz.one.tech.prac.one.onetechpracone.model.mapper;

import kz.one.tech.prac.one.onetechpracone.model.Group;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GroupMapper implements RowMapper<Group> {

    @Override
    public Group mapRow(ResultSet rs, int rowNum) throws SQLException {
        Group group = new Group();
        group.setId(rs.getInt("id"));
        group.setName(rs.getString("name"));
        group.setMemberCount(rs.getInt("member_count"));
        group.setSupervisorId(rs.getInt("supervisor_id"));

        return group;
    }
}
