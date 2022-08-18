package core.query;

import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 태경 2022-08-13
 */
@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public long saveNewTeam(String name) {
        return teamRepository.save(Team.builder().name(name).build()).getId();
    }

    public Team findById(long id) {
        Optional<Team> opt = teamRepository.findById(id);
        assert opt.isPresent(): "존재하지 않는 팀";

        return opt.get();
    }

    @Transactional
    public void updateName(long id, String name) {
        Team team = findById(id);
        team.setName(name);
    }
}
