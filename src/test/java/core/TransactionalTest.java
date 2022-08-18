package core;

import static org.assertj.core.api.Assertions.assertThat;

import core.query.Team;
import core.query.TeamRepository;
import core.query.TeamService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author 태경 2022-08-13
 */
@SpringBootTest
public class TransactionalTest {

    @Autowired
    TeamService teamService;

    @Autowired
    TeamRepository teamRepository;

    @Test
    void test1() {
        long id = teamService.saveNewTeam("바르셀로나");

        teamService.updateName(id, "파리생제르망");

        Team team = teamService.findById(id);
        assertThat(team.getName()).isEqualTo("파리생제르망");
    }
}
