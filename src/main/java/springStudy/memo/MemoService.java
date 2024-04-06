package springStudy.memo;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class MemoService {

    private final MemoRepository memoRepository;

    @Transactional
    public Long update(Long id, String contents){
        Memo memo = memoRepository.findById(id).orElseThrow();
        memo.update(contents);
        return memo.getId();
    }

}
